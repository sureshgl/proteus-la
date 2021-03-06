package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Isolate_mask_addressContextExt extends AbstractBaseExtendedContext{

	public Isolate_mask_addressContextExt(Isolate_mask_addressContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Isolate_mask_addressContext getLatestContext(){
		return (Isolate_mask_addressContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Isolate_mask_addressContext getContext(String str){
		return (Isolate_mask_addressContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).isolate_mask_address());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Isolate_mask_addressContext){
				addToContexts((Isolate_mask_addressContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Isolate_mask_addressContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}