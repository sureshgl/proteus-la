package com.proteus.la.app;

import java.io.File;
import java.io.FileNotFoundException;

import com.proteus.framework.app.SymbolTable;
import com.proteus.la.LAParserPopulateExtendedContextVisitor;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Runner {

  private LAFileParser laFileParser;

  public Runner(){
    laFileParser = new LAFileParser();
  }

  @Parameter( names = { "--spec", "-i" }, description  = "input file(s)" )
  private String specFilePath;

  @Parameter( names = { "--select", "-s"}, description = "Select spec file")
  private String selectFilePath;
  
  
  public void run() throws Exception{
      File specFile = new File(specFilePath);
      StartContext startContext;
      SymbolTable globalSymbolTable = new SymbolTable();
      if(specFile.exists()){
        startContext = laFileParser.getStartContext(specFile);
        new LAParserPopulateExtendedContextVisitor().visit(startContext);
        startContext.extendedContext.PopulateSymbolTable(globalSymbolTable);
        System.out.println(startContext.extendedContext.getFormattedText());
      }
      else{
        throw new FileNotFoundException("Input file " + specFilePath + "not found");
      }
      File selectFile = new File(selectFilePath);
      if(selectFile.exists()){
        Select_definitionContext select_definitionContext = laFileParser.getSelectContext(selectFile);
        new LAParserPopulateExtendedContextVisitor().visit(select_definitionContext);
        System.out.println(select_definitionContext.extendedContext.getFormattedText());
        startContext.extendedContext.Initialize();
        startContext.extendedContext.PopulateSymbolTable(globalSymbolTable);
        select_definitionContext.extendedContext.PopulateSymbolTable(globalSymbolTable);
        select_definitionContext.extendedContext.process(startContext);
        StringBuilder sb = new StringBuilder();
        startContext.extendedContext.printConfiguration(sb);
        System.out.println(sb.toString());
      }
      else{
        throw new FileNotFoundException("Select file " + selectFilePath + "not found");
      }

  }


  public StartContext getStartContext(String inputFilePath) throws FileNotFoundException{
    File inputFile = new File(inputFilePath);
    if(inputFile.exists()){
      StartContext startContext = laFileParser.getStartContext(inputFile);
      return startContext;
    }
    else{
      throw new FileNotFoundException("Input file " + inputFilePath + "not found");
    }
  }

  public Select_definitionContext getSelectContext(String inputFilePath) throws FileNotFoundException{
    File inputFile = new File(inputFilePath);
    if(inputFile.exists()){
      Select_definitionContext select_definitionContext = laFileParser.getSelectContext(inputFile);
      return select_definitionContext;
    }
    else{
      throw new FileNotFoundException("Input file " + inputFilePath + "not found");
    }
  }

  public void doSymanticCheck(String inputFilePath) throws FileNotFoundException{
    StartContext startContext = getStartContext(inputFilePath);
    startContext.extendedContext.SemanticCheck();
  }

  public static void main(String[] args) throws FileNotFoundException{
    String[] myArgs = {
                        "-i", "/Users/chotu/src/proteus-la/la/src/test/resources/sample1.la",
                        "-s", "/Users/chotu/src/proteus-la/la/src/test/resources/sample2.la"
                        };
    Runner runner = new Runner();
    JCommander.newBuilder()
      .addObject(runner)
      .build()
      .parse(myArgs);
    try{
      runner.run();
    }
    catch(Exception ex)
    {
      ex.printStackTrace();
    }
  }

}
