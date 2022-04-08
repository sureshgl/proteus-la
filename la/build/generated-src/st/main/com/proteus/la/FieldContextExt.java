package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class FieldContextExt extends AbstractBaseExtendedContext{

	public FieldContextExt(FieldContext ctx) {
		super("la", new LAParser(null), new LALexer(null), new LAParserExtendedContextVisitor());
		addToContexts(ctx);
		parent = ctx;
	}

  /*
   * Return the conext associated with this extened context
   */
	@Override
	public FieldContext getContext(){
		return (FieldContext)contexts.get(contexts.size()-1);
	}

  /*
   * Create a context for the given string  with extended context populated in that
   */
	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).field();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof FieldContext){
				addToContexts((FieldContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+FieldContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	public final int getSize(){ return end - start + 1 }

	public final String getFieldName(){
		return getContext().field_name().getText();
	}

	@Override	
	public void PopulateSymbolTable(SymbolTable symbolTable){
		symbolTable.put(getFieldName(), this);
		start = System.Integer.parse()
	}

	private int start, end;

}