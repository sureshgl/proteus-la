package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Isolate_addressesContextExt extends AbstractBaseExtendedContext{

	public Isolate_addressesContextExt(Isolate_addressesContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Isolate_addressesContext getLatestContext(){
		return (Isolate_addressesContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Isolate_addressesContext getContext(String str){
		return (Isolate_addressesContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).isolate_addresses());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Isolate_addressesContext){
				addToContexts((Isolate_addressesContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Isolate_addressesContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}