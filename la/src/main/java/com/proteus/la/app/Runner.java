package com.proteus.la.app;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

import com.proteus.framework.DescriptiveErrorListener;
import com.proteus.framework.utils.FileUtils;
import com.proteus.la.Select_definitionContextExt;
import com.proteus.la.StartContextExt;
import com.proteus.la.ANTLRv4.LAParser.Select_definitionContext;
import com.proteus.la.ANTLRv4.LAParser.StartContext;
import com.proteus.la.app.LAFileParser;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

public class Runner {

  private LAFileParser laFileParser;

  public Runner(){
    laFileParser = new LAFileParser();
  }

  @Parameter( names = { "--spec", "-i" }, description  = "input file(s)" )
  private String specFilePath;

  @Parameter( names = { "--select", "-s"}, description = "Select spec file")
  private String selectFilePath;
  
  
  public void run() throws FileNotFoundException{
      File specFile = new File(specFilePath);
      if(specFile.exists()){
        StartContextExt startContextExt = laFileParser.getStartContext(specFile);
        System.out.println(startContextExt.getFormattedText());
      }
      else{
        throw new FileNotFoundException("Input file " + specFilePath + "not found");
      }
      File selectFile = new File(selectFilePath);
      if(selectFile.exists()){
        Select_definitionContextExt select_definitionContextExt = laFileParser.getSelectContext(selectFile);
        System.out.println(select_definitionContextExt.getFormattedText());
      }
      else{
        throw new FileNotFoundException("Select file " + selectFilePath + "not found");
      }

  }


  public StartContextExt getStartContext(String inputFilePath) throws FileNotFoundException{
    File inputFile = new File(inputFilePath);
    if(inputFile.exists()){
      StartContextExt startContextExt = laFileParser.getStartContext(inputFile);
      return startContextExt;
    }
    else{
      throw new FileNotFoundException("Input file " + inputFilePath + "not found");
    }
  }

  public Select_definitionContextExt getSelectContext(String inputFilePath) throws FileNotFoundException{
    File inputFile = new File(inputFilePath);
    if(inputFile.exists()){
      Select_definitionContextExt select_definitionContextExt = laFileParser.getSelectContext(inputFile);
      return select_definitionContextExt;
    }
    else{
      throw new FileNotFoundException("Input file " + inputFilePath + "not found");
    }
  }

  public void doSymanticCheck(String inputFilePath) throws FileNotFoundException{
    StartContextExt startContextExt = getStartContext(inputFilePath);
    startContextExt.SemanticCheck();
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
    runner.run();
  }

}
