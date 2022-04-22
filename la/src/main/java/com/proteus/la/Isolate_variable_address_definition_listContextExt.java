package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Isolate_variable_address_definition_listContextExt extends AbstractBaseExtendedContext{

	public Isolate_variable_address_definition_listContextExt(Isolate_variable_address_definition_listContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Isolate_variable_address_definition_listContext getLatestContext(){
		return (Isolate_variable_address_definition_listContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Isolate_variable_address_definition_listContext getContext(String str){
		return (Isolate_variable_address_definition_listContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).isolate_variable_address_definition_list());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Isolate_variable_address_definition_listContext){
				addToContexts((Isolate_variable_address_definition_listContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Isolate_variable_address_definition_listContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}