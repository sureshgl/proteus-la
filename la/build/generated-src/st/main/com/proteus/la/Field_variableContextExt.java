package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Field_variableContextExt extends AbstractBaseExtendedContext{

	public Field_variableContextExt(Field_variableContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
		addToContexts(ctx);
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Field_variableContext getLatestContext(){
		return (Field_variableContext)super.getLatestContext();
	}


  /*
   * Create a context for the given string  with extended context populated in that
   */
	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).field_variable();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Field_variableContext){
				addToContexts((Field_variableContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Field_variableContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	public String getChainName(){
		return getLatestContext().getText().split("\\.")[0];
	}

	public String getGroupName(){
		String[] args = getLatestContext().getText().split("\\.");
		return args[0] + "." + args[1];
	}

	public String getElementName(){
		String[] args = getLatestContext().getText().split("\\.");
		return args[0] + "." + args[1] + "." + args[2];
	}

	public String getFieldName(){
		return getLatestContext().getText();
	}

}
