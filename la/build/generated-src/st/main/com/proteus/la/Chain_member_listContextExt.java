package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Chain_member_listContextExt extends AbstractBaseExtendedContext{

	public Chain_member_listContextExt(Chain_member_listContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Chain_member_listContext getLatestContext(){
		return (Chain_member_listContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Chain_member_listContext getContext(String str){
		return (Chain_member_listContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).chain_member_list());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Chain_member_listContext){
				addToContexts((Chain_member_listContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Chain_member_listContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}