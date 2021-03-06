package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Shift_addressContextExt extends AbstractBaseExtendedContext{

	public Shift_addressContextExt(Shift_addressContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Shift_addressContext getLatestContext(){
		return (Shift_addressContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Shift_addressContext getContext(String str){
		return (Shift_addressContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).shift_address());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Shift_addressContext){
				addToContexts((Shift_addressContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Shift_addressContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}