package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Chain_memberContextExt extends AbstractBaseExtendedContext{

	public Chain_memberContextExt(Chain_memberContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Chain_memberContext getLatestContext(){
		return (Chain_memberContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Chain_memberContext getContext(String str){
		return (Chain_memberContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).chain_member());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Chain_memberContext){
				addToContexts((Chain_memberContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Chain_memberContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}