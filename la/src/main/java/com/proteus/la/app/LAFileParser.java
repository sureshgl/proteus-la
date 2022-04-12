package com.proteus.la.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proteus.framework.utils.FileUtils;
import com.proteus.framework.IExtendedContextVisitor;
import com.proteus.framework.app.AbstractBaseExtendedContext;
import com.proteus.la.StartContextExt;
import com.proteus.la.LAParserExtendedContextVisitor;
import com.proteus.la.ANTLRv4.LAParser.StartContext;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.framework.DescriptiveErrorListener;



public class LAFileParser {

	private static final Logger logger = LoggerFactory.getLogger(LAFileParser.class);

	public static StartContext getStartContext(File file) {
		logger.info("trying to parse " + file);

    String content = FileUtils.ReadFromFile(file);
		ParserRuleContext parserRuleContext = trySLLContent(content);
		if (parserRuleContext == null) {
			parserRuleContext = tryLLContent(content);
		}
		if (parserRuleContext != null) {
			IExtendedContextVisitor extendedContextVisitor = new LAParserExtendedContextVisitor();
			StartContextExt startContextExt = (StartContextExt) extendedContextVisitor.visit(parserRuleContext);
			if (startContextExt == null) {
				logger.warn("No context");
			}
			StartContext startContext = startContextExt.getLatestContext();
			logger.info("Done with " + file);
			return startContext;
		} else {
			throw new IllegalStateException("Could not parse module :" + file);
		}
	}

	public static ParserRuleContext tryLLContent(String content) {
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
			ParserRuleContext tree = parser.start();
			return tree;
		} catch (Exception e) {
			logger.error("Error parsing content with LL strategy" + e);
			return null;
		}
	}

	public static ParserRuleContext trySLLContent(String content) {
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
			ParserRuleContext tree = parser.start();
			return tree;
		} catch (Exception e) {
				logger.debug("Error parsing content with SLL strategy" + e);
				return null;
		}
	}


}
