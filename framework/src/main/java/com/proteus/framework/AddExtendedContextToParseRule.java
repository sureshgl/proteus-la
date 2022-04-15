package com.proteus.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.proteus.framework.utils.FileUtils;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;

import java.lang.IllegalArgumentException;
import java.io.FileNotFoundException;

import com.proteus.framework.ANTLRv4.ANTLRv4Lexer;
import com.proteus.framework.ANTLRv4.ANTLRv4Parser;
import com.proteus.framework.ANTLRv4.ANTLRv4Parser.GrammarSpecContext;
import com.proteus.framework.ANTLRv4.ANTLRv4Parser.AlternativeContext;
import com.proteus.framework.ANTLRv4.ANTLRv4Parser.ElementContext;
import com.proteus.framework.ANTLRv4.ANTLRv4Parser.LabeledAltContext;
import com.proteus.framework.ANTLRv4.ANTLRv4Parser.RuleSpecContext;
import com.proteus.framework.ANTLRv4.ANTLRv4ParserBaseVisitor;

public class AddExtendedContextToParseRule extends ANTLRv4ParserBaseVisitor<StringBuilder> {

	/*
	 * parserRuleSpec
	 * : DOC_COMMENT?
	 * ruleModifiers? RULE_REF ARG_ACTION?
	 * ruleReturns? throwsSpec? localsSpec?
	 * rulePrequel*
	 * COLON
	 * ruleBlock
	 * SEMI
	 * exceptionGroup
	 * ;
	 */

	// private List<String> literals;
	private StringBuilder updatedGrammar;

	private GrammarSpecContext grammarSpecContext;

	// public StringLiteralsToLexers(){
	// literals = new ArrayList<String>();
	// }


	public AddExtendedContextToParseRule(File grammarFile) {
		updatedGrammar = new StringBuilder();
		try{
			InputStream inputStream = new FileInputStream(grammarFile);
			ANTLRv4Lexer lexer = new ANTLRv4Lexer(new ANTLRInputStream(inputStream));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			ANTLRv4Parser parser = new ANTLRv4Parser(tokens);
			grammarSpecContext = parser.grammarSpec();
		}
		catch(IOException exception)
		{
			exception.printStackTrace();
			grammarSpecContext = null;
		}
	}

	public StringBuilder getUpdatedGrammar(){
		return visitGrammarSpec(grammarSpecContext);
	}


	

	/*
			grammarSpec
				:	DOC_COMMENT?
					grammarType id SEMI
					prequelConstruct*
					rules
					modeSpec*
					EOF
				;
	*/

	@Override
	public StringBuilder visitGrammarSpec(@NotNull ANTLRv4Parser.GrammarSpecContext ctx){
		if( ctx.DOC_COMMENT() != null){
			updatedGrammar.append(ctx.DOC_COMMENT().getText());
			updatedGrammar.append("\n\n");
		}
		if( ctx.grammarType() != null ){
			visitGrammarType(ctx.grammarType());
			updatedGrammar.append( ctx.id().getText() + " " + ctx.SEMI().getText());
			updatedGrammar.append("\n\n");
		}
		if( ctx.prequelConstruct() != null && ctx.prequelConstruct().size() > 0 ){
			for(int i=0; i< ctx.prequelConstruct().size(); i++){
				updatedGrammar.append(ctx.prequelConstruct(i).getText());
				updatedGrammar.append("\n\n");
			}
		}
		if( ctx.rules() != null){
			visitRules(ctx.rules());
		}
		updatedGrammar.append("\n");
		if(ctx.modeSpec() != null && ctx.modeSpec().size() > 0){
			for(int i=0; i < ctx.modeSpec().size(); i++){
				updatedGrammar.append(ctx.modeSpec(i).getText());
				updatedGrammar.append("\n\n");
			}
		}
		return updatedGrammar;
	}


	/*
			grammarType
				:	(	LEXER GRAMMAR
					|	PARSER GRAMMAR
					|	GRAMMAR
					)
				;
	*/
	@Override
	public StringBuilder visitGrammarType (@NotNull ANTLRv4Parser.GrammarTypeContext ctx){
		if(ctx.LEXER() != null)
		{
			updatedGrammar.append(ctx.LEXER().getText() + " ");
		}

		if(ctx.PARSER() != null)
		{
			updatedGrammar.append(ctx.PARSER().getText() + " ");
		}

		if(ctx.GRAMMAR() != null)
		{
			updatedGrammar.append(ctx.GRAMMAR().getText() + " ");
		}

		return updatedGrammar;
	}

	@Override
	public StringBuilder visitRules(@NotNull ANTLRv4Parser.RulesContext ctx){
		if(ctx.ruleSpec() != null && ctx.ruleSpec().size() > 0)
		{
			for(int i=0; i < ctx.ruleSpec().size(); i++){
				if( ctx.ruleSpec(i).parserRuleSpec() != null){
					visitParserRuleSpec(ctx.ruleSpec(i).parserRuleSpec());
				}
				else if( ctx.ruleSpec(i).lexerRule() != null){
					updatedGrammar.append(ctx.ruleSpec(i).getText());
					updatedGrammar.append("\n");
				}
			}	
		}
		return updatedGrammar;
	}

	@Override
	public StringBuilder visitParserRuleSpec(@NotNull ANTLRv4Parser.ParserRuleSpecContext ctx) {
		String name = ctx.RULE_REF().getText();
		updatedGrammar.append(name);
		updatedGrammar.append("\n");
		String camelCase = name.substring(0, 1).toUpperCase() + name.substring(1);
		updatedGrammar.append("locals [ " + camelCase + "ContextExt extendedContext = null ]\n");
		updatedGrammar.append(":");
		visitRuleBlock(ctx.ruleBlock());
		updatedGrammar.append(";");
		updatedGrammar.append("\n\n");
		return updatedGrammar;
	}

	/*
	 * ruleBlock
	 * : ruleAltList
	 * ;
	 */
	@Override
	public StringBuilder visitRuleBlock(@NotNull ANTLRv4Parser.RuleBlockContext ctx) {
		return visitRuleAltList(ctx.ruleAltList());
	}

	/*
	 * ruleAltList
	 * : labeledAlt (OR labeledAlt)*
	 * ;
	 */
	@Override
	public StringBuilder visitRuleAltList(@NotNull ANTLRv4Parser.RuleAltListContext ctx) {
		List<LabeledAltContext> labledAltList = ctx.labeledAlt();
		visitLabeledAlt(labledAltList.get(0));
		for (int i = 1; i < labledAltList.size(); i++) {
			updatedGrammar.append("\n");
			updatedGrammar.append("| ");
			visitLabeledAlt(labledAltList.get(i));
		}
		return updatedGrammar;
	}

	/*
	 * labeledAlt
	 * : alternative (POUND id)?
	 * ;
	 */
	@Override
	public StringBuilder visitLabeledAlt(@NotNull ANTLRv4Parser.LabeledAltContext ctx) {
		visitAlternative(ctx.alternative());
		if (ctx.id() != null) {
			updatedGrammar.append(ctx.POUND().getText());
			updatedGrammar.append(ctx.id().getText());
		}

		return updatedGrammar;
	}

	/*
	 * alternative
	 * : elementOptions? element*
	 * ;
	 */
	@Override
	public StringBuilder visitAlternative(@NotNull ANTLRv4Parser.AlternativeContext ctx) {
		List<ElementContext> elementList = ctx.element();
		for (ElementContext elementContext : elementList) {
			visitElement(elementContext);
		}
		return updatedGrammar;
	}

	/*
	 * element
	 * : labeledElement
	 * ( ebnfSuffix
	 * |
	 * )
	 * | atom
	 * ( ebnfSuffix
	 * |
	 * )
	 * | ebnf
	 * | ACTION QUESTION? // SEMPRED is ACTION followed by QUESTION
	 * ;
	 */
	@Override
	public StringBuilder visitElement(@NotNull ANTLRv4Parser.ElementContext ctx) {
		if (ctx.atom() != null) {
			visitAtom(ctx.atom());
			if (ctx.ebnfSuffix() != null) {
				updatedGrammar.append(ctx.ebnfSuffix().getText() + " ");
			} else {
				updatedGrammar.append(" ");
			}
		} else if (ctx.ebnf() != null) {
			visitEbnf(ctx.ebnf());
		}
		return updatedGrammar;
	}

	/*
	 * ebnf: block blockSuffix?
	 * ;
	 */
	@Override
	public StringBuilder visitEbnf(@NotNull ANTLRv4Parser.EbnfContext ctx) {
		visitBlock(ctx.block());
		if (ctx.blockSuffix() != null) {
			updatedGrammar.append(ctx.blockSuffix().getText() + " ");
		}
		return updatedGrammar;
	}

	/*
	 * * atom
	 * : range // Range x..y - only valid in lexers
	 * | terminal
	 * | ruleref
	 * | notSet
	 * | DOT elementOptions?
	 * ;
	 */
	@Override
	public StringBuilder visitAtom(@NotNull ANTLRv4Parser.AtomContext ctx) {
		if (ctx.terminal() != null) {
			visitTerminal(ctx.terminal());
		} else {
			updatedGrammar.append(" " + ctx.getText());
		}
		return updatedGrammar;
	}

	/*
	 * terminal
	 * : TOKEN_REF elementOptions?
	 * | STRING_LITERAL elementOptions?
	 * ;
	 * 
	 */

	@Override
	public StringBuilder visitTerminal(@NotNull ANTLRv4Parser.TerminalContext ctx) {
		updatedGrammar.append(" " + ctx.getText());
		return updatedGrammar;
	}

	/*
	 * block
	 * : LPAREN
	 * ( optionsSpec? ruleAction* COLON )?
	 * altList
	 * RPAREN
	 * ;
	 */
	@Override
	public StringBuilder visitBlock(@NotNull ANTLRv4Parser.BlockContext ctx) {
		updatedGrammar.append("( ");
		visitAltList(ctx.altList());
		updatedGrammar.append(" )");
		return updatedGrammar;
	}

	/*
	 * altList
	 * : alternative (OR alternative)*
	 * ;
	 */
	@Override
	public StringBuilder visitAltList(@NotNull ANTLRv4Parser.AltListContext ctx) {
		List<AlternativeContext> alternativeList = ctx.alternative();
		visitAlternative(alternativeList.get(0));
		for (int i = 1; i < alternativeList.size(); i++) {
			updatedGrammar.append("\n");
			updatedGrammar.append("|");
			visitAlternative(alternativeList.get(i));
		}
		return updatedGrammar;
	}

	List<RuleSpecContext> getRuleSpecList(){
		return grammarSpecContext.rules().ruleSpec();
	}

	/*
	 * It will be heavy to have a seperate command line args parser,
	 * so continuing with the crude way
	 * args[0] -> input path of grammer file.
	 * args[1] -> if provided is an output path of grammar file, else input file
	 * will be overwritten
	 */
	public static void main(String args[]) throws FileNotFoundException {
		String inputGrammarFilePath="";
		String outputGrammarFilePath="";
		if(args.length < 1){
			throw new IllegalArgumentException(" AddExtendedContextToParseRule requires atleast one argument, input file path of a grammar file");
		}
		else if(args.length > 2){
			throw new IllegalArgumentException(" AddExtendedContextToParseRule requires atnmost two arguments, input & output file paths of a grammar file");
		}
		else if(args.length == 1)
		{
			inputGrammarFilePath = args[0];
			outputGrammarFilePath = inputGrammarFilePath;
		}
		else if(args.length == 2)
		{
			inputGrammarFilePath = args[0];
			outputGrammarFilePath = args[1];
		}
		File inputGrammarFile = new File(inputGrammarFilePath);
		File outputGrammarFile = new File(outputGrammarFilePath);
		if(inputGrammarFile.exists()){
			AddExtendedContextToParseRule addExtendedContextToParseRule = new AddExtendedContextToParseRule(inputGrammarFile);
			StringBuilder updatedGrammar = addExtendedContextToParseRule.getUpdatedGrammar();
			FileUtils.WriteFile(outputGrammarFile, updatedGrammar.toString());
		}
		else{
			throw new FileNotFoundException(inputGrammarFilePath + " Not Found");
		}
	}
}
