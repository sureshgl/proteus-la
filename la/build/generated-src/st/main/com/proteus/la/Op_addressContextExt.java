package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Op_addressContextExt extends AbstractBaseExtendedContext{

	public Op_addressContextExt(Op_addressContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Op_addressContext getLatestContext(){
		return (Op_addressContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Op_addressContext getContext(String str){
		return (Op_addressContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).op_address());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Op_addressContext){
				addToContexts((Op_addressContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Op_addressContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}