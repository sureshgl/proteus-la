package com.proteus.framework;

import java.io.File;
import java.util.Map;
import java.lang.IllegalArgumentException;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;
import com.proteus.framework.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PopulateExtendedContextVisitorGenerator {
	protected static final Logger logger = LoggerFactory.getLogger(ExtendedContextVisitorGenerator.class);
	private String packageName;
	private String grammarName;
	private String parserName;
	private String directoryLocation;
	private String grammarFilePath;
	private String templateFilePath;
	private final String methodSkel = "populateExtendedContextClassVisitorMethodSkel";
	private final String classSkel = "populateExtendedContextClassVisitorSkel";

	public PopulateExtendedContextVisitorGenerator(String grammarFilePath, String templateFilePath, String directoryLocation,
			String packageName, String grammarName, String parserName) {
		this.grammarFilePath = grammarFilePath;
		this.templateFilePath = templateFilePath;
		this.directoryLocation = directoryLocation;
		this.packageName = packageName;
		this.grammarName = grammarName;
		this.parserName = parserName;
	}

	public void generate() throws Exception{
		int count = 0;
		StringBuilder sb = new StringBuilder();
		GrammarFile rulesOfGrammarFile = new GrammarFile(grammarFilePath);
		STGroupFile stgf = new STGroupFile(templateFilePath);
		for (String name : rulesOfGrammarFile.getParserRules()) {
				ST st = stgf.getInstanceOf(methodSkel);
			String ruleContextName = toContext(name);
			st.add("parserName", parserName);
			st.add("ruleName", name.substring(0,1).toUpperCase()+ name.substring(1));
			st.add("ruleContextName", ruleContextName);
			sb.append(st.render());
			logger.info(name.substring(0,1).toUpperCase()+ name.substring(1) +":" + ruleContextName);
			count++;
		}
		//altRules -> Alt rule name : main rule
		Map<String, String> altRules = rulesOfGrammarFile.getAltRules();
		for (String name : altRules.keySet()) {
			ST st = stgf.getInstanceOf(methodSkel);
			String ruleContextName = toContext(name);
			st.add("parserName", parserName);
			st.add("ruleName", name.substring(0,1).toUpperCase()+ name.substring(1));
			st.add("ruleContextName", ruleContextName);
			sb.append(st.render());
			logger.info(name.substring(0,1).toUpperCase()+ name.substring(1) +":" + ruleContextName);
			count++;
		}
		logger.info("Total "+ count);

		ST st = stgf.getInstanceOf(classSkel);
		st.add("packageName", packageName);
		st.add("grammarName", grammarName);
		st.add("parserName", parserName);
		st.add("methods", sb.toString());
		FileUtils.WriteFile(new File(directoryLocation +"/"+ parserName +"PopulateExtendedContextVisitor.java"), st.render());
	}

	private String toContext(String input) {
		StringBuilder sb = new StringBuilder();
		sb.append(input.substring(0, 1).toUpperCase());
		sb.append(input.substring(1));
		sb.append("Context");
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {

		if (args.length != 6) {
			throw new IllegalArgumentException(
					"Usage : PopulateExtendedContextVisitorGenerator <grammarFilePath> <templateFilePath> <directoryLocation> <packageName> <grammarName>, <parserName>");
		}
		String grammarFilePath = args[0];
		String templateFilePath = args[1];
		String directoryLocation = args[2];
		String packageName = args[3];
		String grammarName = args[4];
		String parserName = args[5];
		PopulateExtendedContextVisitorGenerator extendedContextVisitorGenerator = new PopulateExtendedContextVisitorGenerator(
				grammarFilePath, templateFilePath, directoryLocation, packageName, grammarName, parserName);
		extendedContextVisitorGenerator.generate();
	}
}
