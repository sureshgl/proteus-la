package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Group_definitionContextExt extends AbstractBaseExtendedContext{

	public Group_definitionContextExt(Group_definitionContext ctx) {
		super("la", new LAParser(null), new LALexer(null), new LAParserExtendedContextVisitor());
		addToContexts(ctx);
		parent = ctx;
		localSymbolTable = new SymbolTable();
	}

  /*
   * Return the conext associated with this extened context
   */
	@Override
	public Group_definitionContext getContext(){
		return (Group_definitionContext)contexts.get(contexts.size()-1);
	}

  /*
   * Create a context for the given string  with extended context populated in that
   */
	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).group_definition();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Group_definitionContext){
				addToContexts((Group_definitionContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Group_definitionContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}


	public final String getGroupName(){
		return getContext().group_name().getText();
	}

	public final void getElements(){
		
	}

	@Override	
	public void PopulateSymbolTable(SymbolTable symbolTable){
		symbolTable.put(getGroupName(), this);
		PopulateSymbolTable(localSymbolTable);
	}

	@Override
	public SemanticCheck(){

	}

	private SymbolTable localSymbolTable;

}