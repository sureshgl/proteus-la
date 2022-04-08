package com.proteus.la.app;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

import com.proteus.framework.utils.FileUtils;
import com.proteus.la.ANTLRv4.LAParser.StartContext;
import com.proteus.la.app.LAFileParser;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

public class Runner {

  @Parameter(
		names = { "--input", "-i" },
		description  = "input file(s)"
	)
  private List<String>  inputFiles;
  
  public void run() throws FileNotFoundException{
    for(String filePath : inputFiles)
    {
      File inputFile = new File(filePath);
      if(inputFile.exists()){
        StartContext startContext = LAFileParser.getStartContext(inputFile);
        System.out.println(startContext.extendedContext.getFormattedText());
      }
      else{
        throw new FileNotFoundException("Input file " + filePath + "not found");
      }
    }
  }

  public StartContext getStartContext(String inputFilePath) throws FileNotFoundException{
    File inputFile = new File(inputFilePath);
    if(inputFile.exists()){
      StartContext startContext = LAFileParser.getStartContext(inputFile);
      return startContext;
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
    String[] myArgs = {"-i", "/Users/chotu/src/gradle/verilog/input.v"};
    Runner runner = new Runner();
    JCommander.newBuilder()
      .addObject(runner)
      .build()
      .parse(args);
    runner.run();
  }

}
