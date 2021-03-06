package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Isolate_mask_address_valueContextExt extends AbstractBaseExtendedContext{

	public Isolate_mask_address_valueContextExt(Isolate_mask_address_valueContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Isolate_mask_address_valueContext getLatestContext(){
		return (Isolate_mask_address_valueContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Isolate_mask_address_valueContext getContext(String str){
		return (Isolate_mask_address_valueContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).isolate_mask_address_value());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Isolate_mask_address_valueContext){
				addToContexts((Isolate_mask_address_valueContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Isolate_mask_address_valueContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}