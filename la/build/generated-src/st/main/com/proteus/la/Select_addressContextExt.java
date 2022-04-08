package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Select_addressContextExt extends AbstractBaseExtendedContext{

	public Select_addressContextExt(Select_addressContext ctx) {
		super("la", new LAParser(null), new LALexer(null), new LAParserExtendedContextVisitor());
		addToContexts(ctx);
		parent = ctx;
	}

  /*
   * Return the conext associated with this extened context
   */
	@Override
	public Select_addressContext getContext(){
		return (Select_addressContext)contexts.get(contexts.size()-1);
	}

  /*
   * Create a context for the given string  with extended context populated in that
   */
	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).select_address();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Select_addressContext){
				addToContexts((Select_addressContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Select_addressContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}