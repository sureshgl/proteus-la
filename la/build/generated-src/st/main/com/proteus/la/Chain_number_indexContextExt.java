package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Chain_number_indexContextExt extends AbstractBaseExtendedContext{

	public Chain_number_indexContextExt(Chain_number_indexContext ctx) {
		super("la", new LAParser(null), new LALexer(null), new LAParserExtendedContextVisitor());
		addToContexts(ctx);
		parent = ctx;
	}

  /*
   * Return the conext associated with this extened context
   */
	@Override
	public Chain_number_indexContext getContext(){
		return (Chain_number_indexContext)contexts.get(contexts.size()-1);
	}

  /*
   * Create a context for the given string  with extended context populated in that
   */
	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).chain_number_index();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Chain_number_indexContext){
				addToContexts((Chain_number_indexContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Chain_number_indexContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}