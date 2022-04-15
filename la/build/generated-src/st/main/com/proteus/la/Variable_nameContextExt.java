package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Variable_nameContextExt extends AbstractBaseExtendedContext{

	public Variable_nameContextExt(Variable_nameContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Variable_nameContext getLatestContext(){
		return (Variable_nameContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Variable_nameContext getContext(String str){
		return (Variable_nameContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).variable_name());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Variable_nameContext){
				addToContexts((Variable_nameContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Variable_nameContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}