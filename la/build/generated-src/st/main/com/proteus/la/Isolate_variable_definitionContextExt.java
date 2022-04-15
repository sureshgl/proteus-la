package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Isolate_variable_definitionContextExt extends AbstractBaseExtendedContext{

	public Isolate_variable_definitionContextExt(Isolate_variable_definitionContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Isolate_variable_definitionContext getLatestContext(){
		return (Isolate_variable_definitionContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Isolate_variable_definitionContext getContext(String str){
		return (Isolate_variable_definitionContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).isolate_variable_definition());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Isolate_variable_definitionContext){
				addToContexts((Isolate_variable_definitionContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Isolate_variable_definitionContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	@Override
	public void processFieldReferences(){
		//Stop further processing on this branch- as that is no-op
		return;
	}
	
}
