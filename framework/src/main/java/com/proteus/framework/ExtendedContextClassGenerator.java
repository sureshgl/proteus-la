package com.proteus.framework;

import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroupFile;
import com.proteus.framework.utils.FileUtils;
import com.proteus.framework.GrammarFile;
import java.lang.IllegalArgumentException;

public class ExtendedContextClassGenerator {
	private String packageName;
	private String grammarName;
	private String parserName;
	private String lexerName;
  private String grammarFilePath;
  private String templateFilePath;
  private String directoryLocation;
  private final String contextClassSkeltonName = "contextClassSkel";
  private final String altContextClassSkeltonName = "contextAltClassSkel";

	public ExtendedContextClassGenerator(String packageName, String grammarName, String parserName, 
	String lexerName, String grammarFilePath, String templateFilePath, String directoryLocation){
		this.packageName = packageName;
		this.grammarName = grammarName;
		this.parserName = parserName;
		this.lexerName = lexerName;
		this.grammarFilePath = grammarFilePath;
		this.templateFilePath = templateFilePath;
		this.directoryLocation = directoryLocation;
	}

	public void generateClasses() throws Exception {
		int count = 0;
		GrammarFile rulesOfGrammarFile = new GrammarFile(grammarFilePath);
		STGroupFile stgf = new STGroupFile(templateFilePath);
		for (String name : rulesOfGrammarFile.getParserRules()) {
			ST st = stgf.getInstanceOf(contextClassSkeltonName);
			String className = toContextCase(name);
			st.add("packageName", packageName);
			st.add("grammarName", grammarName);
			st.add("parserName", parserName);
			st.add("lexerName", lexerName);
			st.add("className", className);
			st.add("ruleName", name);
      FileUtils.WriteFile(new File(directoryLocation + "/" + className + "Ext.java"), st.render());
			count++;
		}
		Map<String, String> altRules = rulesOfGrammarFile.getAltRules();
		for (String name : altRules.keySet()) {
			ST st = stgf.getInstanceOf(altContextClassSkeltonName);
			String className = toContextCase(name);
			String parentClassName = toContextCase(altRules.get(name));
			st.add("packageName", packageName);
			st.add("grammarName", grammarName);
			st.add("parserName", parserName);
			st.add("className", className);
			st.add("parentClassName", parentClassName);
			st.add("ruleName", altRules.get(name));
			count++;
			FileUtils.WriteFile(new File(directoryLocation + "/" + className + "Ext.java"), st.render());
		}
		Set<String> parentRulesForAltRules = new HashSet<>(altRules.values());
		for (String name : parentRulesForAltRules) {
			ST st = stgf.getInstanceOf("contextAltParentClassSkel");
			String className = toContextCase(name);
			st.add("packageName", packageName);
			st.add("grammarName", grammarName);
			st.add("parserName", parserName);
			st.add("lexerName", lexerName);
			st.add("className", className);
			count++;
			FileUtils.WriteFile(new File(directoryLocation + "/" + className + "Ext.java"), st.render());
		}
		System.out.println("Generated " + count + " classes");
	}

	private String toContextCase(String input) {
		StringBuilder sb = new StringBuilder();
		sb.append(input.substring(0, 1).toUpperCase());
		sb.append(input.substring(1));
		sb.append("Context");
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {

    if( args.length != 7 ){
      throw new IllegalArgumentException("Usage : ContextClassGenerator <packageName> <grammarName> <parserName> <lexerName> <grammarFile> <templateFile> <directoryLocation>");
    }
		String packageName = args[0];
		String grammarName = args[1];
		String parserName = args[2];
		String lexerName = args[3];
    String grammarFilePath = args[4];
    String templateFilePath = args[5];
    String directoryLocation = args[6];
    ExtendedContextClassGenerator contextClassGenerator 
      = new ExtendedContextClassGenerator(packageName, grammarName, parserName, lexerName, grammarFilePath,templateFilePath,directoryLocation);
		contextClassGenerator.generateClasses();
	}

}
