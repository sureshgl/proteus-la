package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Isolatation_definitionContextExt extends AbstractBaseExtendedContext{

	public Isolatation_definitionContextExt(Isolatation_definitionContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Isolatation_definitionContext getLatestContext(){
		return (Isolatation_definitionContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Isolatation_definitionContext getContext(String str){
		return (Isolatation_definitionContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).isolatation_definition());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Isolatation_definitionContext){
				addToContexts((Isolatation_definitionContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Isolatation_definitionContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}