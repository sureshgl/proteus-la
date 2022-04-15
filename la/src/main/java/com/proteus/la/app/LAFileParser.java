package com.proteus.la.app;

import java.io.File;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proteus.framework.utils.FileUtils;
import com.proteus.la.ANTLRv4.LAParser.*;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.framework.DescriptiveErrorListener;



public class LAFileParser {

	private static final Logger logger = LoggerFactory.getLogger(LAFileParser.class);

	public  StartContext getStartContext(File file) {
		logger.info("trying to parse " + file);
    String content = FileUtils.ReadFromFile(file);
		LAParser parser = trySLLContent(content);
		StartContext startContext = (StartContext)parser.start();
		if( startContext == null ){
			parser = tryLLContent(content);
			startContext = (StartContext)parser.start();
		}
		if (startContext != null) {
			return startContext;
		} else {
			throw new IllegalStateException("Could not parse module :" + file);
		}
	}

	public  Select_definitionContext getSelectContext(File file) {
		logger.info("trying to parse " + file);
    String content = FileUtils.ReadFromFile(file);
		LAParser parser = trySLLContent(content);
		Select_definitionContext select_definitionContext = (Select_definitionContext)parser.select_definition();
		if( select_definitionContext == null ){
			parser = tryLLContent(content);
			select_definitionContext = (Select_definitionContext)parser.select_definition();
		}
		if (select_definitionContext != null) {
			return select_definitionContext;
		} else {
			throw new IllegalStateException("Could not parse module :" + file);
		}
	}

	public LAParser tryLLContent(String content) {
		LALexer lexer = new LALexer(new ANTLRInputStream(content));
		//lexer.removeErrorListeners();
		lexer.addErrorListener(DescriptiveErrorListener.INSTANCE);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LAParser parser = new LAParser(null);
		try {
			parser.getInterpreter().setPredictionMode(PredictionMode.LL);
			// parser.setErrorHandler(new BailErrorStrategy());
			// parser.setErrorHandler(new ExceptionErrorStrategy ());
			// parser.removeErrorListeners();
		  DescriptiveErrorListener descError = DescriptiveErrorListener.INSTANCE;
			parser.addErrorListener(descError);

			parser.setBuildParseTree(true);
			parser.setTokenStream(tokens);
			return parser;
		} catch (Exception e) {
			logger.error("Error parsing content with LL strategy" + e);
			return null;
		}
	}

	public LAParser trySLLContent(String content) {
		LALexer lexer = new LALexer(new ANTLRInputStream(content));
		//lexer.removeErrorListeners();
		lexer.addErrorListener(DescriptiveErrorListener.INSTANCE);

		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LAParser parser = new LAParser(null);
		try {
			parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
			// parser.setErrorHandler(new BailErrorStrategy());
			//parser.removeErrorListeners();
			DescriptiveErrorListener descError = DescriptiveErrorListener.INSTANCE;
			parser.addErrorListener(descError);
			// parser.setErrorHandler(new ExceptionErrorStrategy());
			parser.setBuildParseTree(true);
			parser.setTokenStream(tokens);
			return parser;
		} catch (Exception e) {
				logger.debug("Error parsing content with SLL strategy" + e);
				return null;
		}
	}


}
