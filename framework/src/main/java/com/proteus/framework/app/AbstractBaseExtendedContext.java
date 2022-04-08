package com.proteus.framework.app;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.proteus.framework.IExtendedContextVisitor;
import com.proteus.framework.app.IGetFormattedText;

/* 
  This is a base Application implementing a feature "GetFormattedText".
*/

@Data
public abstract class AbstractBaseExtendedContext implements IGetFormattedText {
	protected static final Logger logger = LoggerFactory.getLogger(AbstractBaseExtendedContext.class);

	//variables
  private String grammarName;
	private Parser parser;
	private Lexer lexer;
	private IExtendedContextVisitor extendedContextVisitor;


	@Setter(AccessLevel.NONE)
	protected List<ParserRuleContext> contexts;
	protected ParserRuleContext parent;

	//abstract methods
	abstract public ParserRuleContext getContext();
	abstract public ParserRuleContext getContext(String str);
	abstract public void setContext(ParserRuleContext ctx);

	public static SymbolTable globalSymbolTable = new SymbolTable(); //Global Symbol table.

	//constructor
	public AbstractBaseExtendedContext(String grammarName, Parser parser, Lexer lexer, IExtendedContextVisitor extendedContextVisitor){
    this.grammarName = grammarName;
		this.parser = parser;
		this.lexer = lexer;
		this.extendedContextVisitor = extendedContextVisitor;
		this.contexts = new ArrayList<ParserRuleContext>();
	}

		// This method is not exposed outside.
		public Parser getParser(String str) {
			lexer.setInputStream(new ANTLRInputStream(str));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			parser.setTokenStream(tokens);
			return parser;
		}

		protected void addToContexts(ParserRuleContext context) {
			contexts.add(context);
			AbstractBaseExtendedContext extCtx = getExtendedContext(context);
			if (extCtx != null) {
				extCtx.contexts = contexts;
				extCtx.parent = parent;
			}
		}


	public AbstractBaseExtendedContext getExtendedContext(ParseTree context){
		if(context != null){
			return (AbstractBaseExtendedContext)extendedContextVisitor.visit(context);
		} else{
			return null;
		}
	}

	@Data
	protected class Params{
		public Params( ParserRuleContext ctx, StringBuilder sb)
		{
			this.context = ctx;
			beginingOfAlignemtText = 0;
			input = ctx.start.getInputStream();
			this.stringBuilder = sb;
		}
		private ParserRuleContext context;
		private CharStream input;
		private StringBuilder stringBuilder;
		//private int endOfAlignmentText;
		private int beginingOfAlignemtText;

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder();

			sb.append("Context = " + context.getClass().getSimpleName() +"\n"+ context.getText()); sb.append("\n");
			sb.append("Text = "+ stringBuilder.toString()); sb.append("\n");
			sb.append("start ="+beginingOfAlignemtText); sb.append("\n");
			//sb.append("end = "+endOfAlignmentText);sb.append("\n");
			return sb.toString();
		}

	}

	//getFormattedText() app
	@Override
	public String getFormattedText(){
		StringBuilder sb = new StringBuilder();
		Params params = new Params(getContext(), sb);
		params.setBeginingOfAlignemtText(getContext().start.getStartIndex());
		getFormattedText(params);
		//logger.debug("output =\n" + sb.toString());
		return sb.toString();
	}

	protected void getFormattedText(Params params){
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(childCtx instanceof TerminalNode){
					printTerminalNode((TerminalNode)childCtx,params);
				}
				else if(childCtx.getText().length() >0){
					params.setContext((ParserRuleContext)childCtx);
					Params thisCtxParams = getExtendedContext(childCtx).getUpdatedParams(params);
					getExtendedContext(childCtx).getFormattedText(thisCtxParams);
				}
			}
			getUpdatedParams(params);
		}
	}

	/*
	 * check if they are pointing to the same char stream, else it resets the 
	 * params with the new char stream params.
	 */

	private Params getUpdatedParams(Params params) {
		if ( getContext() == null)
		{
			//The item is removed during the transformation, hence skip its contents.
			String alignmentText = params.getInput().getText(new Interval(params.getBeginingOfAlignemtText(), params.getContext().start.getStartIndex()-1));
			params.getStringBuilder().append(alignmentText);
			params.setBeginingOfAlignemtText(params.getContext().stop.getStopIndex() + 1); 
			return null;
		}
		if (getContext().start.getInputStream() != params.getContext().start.getInputStream())
		{
			/*
			 * advance the  begining of  alignment text, as we are going to consider 'mostRecentContext' in its place.
			 */
			if ( params.beginingOfAlignemtText  <  params.getContext().start.getStartIndex())
			{
				String alignmentText = params.getInput().getText(new Interval(params.beginingOfAlignemtText, params.getContext().start.getStartIndex()-1));
				params.getStringBuilder().append(alignmentText);
			}
			params.setBeginingOfAlignemtText(params.getContext().stop.getStopIndex() + 1); 
			return new Params(getContext(),params.getStringBuilder());
		}
		else
		{
			if (getContext().parent == null)
			{
				String alignmentText = params.getInput().getText(new Interval(params.beginingOfAlignemtText, params.getContext().start.getInputStream().size()));
				params.getStringBuilder().append(alignmentText);
			}
			params.setContext(getContext());
			return params;
		}
	}
	
  
  private void printTerminalNode(TerminalNode node,Params params){
		CharStream input = params.getContext().start.getInputStream();
		if(node.getText().equals("<EOF>")){
			String end = input.getText(new Interval(params.getBeginingOfAlignemtText(),input.size()));
			params.getStringBuilder().append(end);
		} else {
			if(params.getBeginingOfAlignemtText() < node.getSymbol().getStartIndex()){
				Interval alignmentTextInterval = new Interval(params.getBeginingOfAlignemtText(),node.getSymbol().getStartIndex()-1);
				String alignmentText = input.getText(alignmentTextInterval);
				params.getStringBuilder().append(alignmentText);
			}
			params.getStringBuilder().append(node.getText());
			params.setBeginingOfAlignemtText(node.getSymbol().getStopIndex()+1);
		}
	}



	public void PopulateSymbolTable(SymbolTable symbolTable)
	{
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					if(childCtx.getText().length() >0){
						getExtendedContext(childCtx).PopulateSymbolTable(symbolTable);
					}
				}
			}
		}
	}

	//Driver to perform the semantic checks.
	public void SemanticCheck()
	{
		ParserRuleContext ctx = getContext();
		if(ctx != null && ctx.children != null && ctx.children.size()>0){
			for(ParseTree childCtx : ctx.children){
				if(!(childCtx instanceof TerminalNode)){
					if(childCtx.getText().length() >0){
						getExtendedContext(childCtx).SemanticCheck();
					}
				}
			}
		}
	}

}