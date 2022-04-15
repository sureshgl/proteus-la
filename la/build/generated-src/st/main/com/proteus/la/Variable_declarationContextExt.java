package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Variable_declarationContextExt extends AbstractBaseExtendedContext{

	public Variable_declarationContextExt(Variable_declarationContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Variable_declarationContext getLatestContext(){
		return (Variable_declarationContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Variable_declarationContext getContext(String str){
		return (Variable_declarationContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).variable_declaration());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Variable_declarationContext){
				addToContexts((Variable_declarationContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Variable_declarationContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}