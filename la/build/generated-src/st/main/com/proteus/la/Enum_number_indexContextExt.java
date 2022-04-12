package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Enum_number_indexContextExt extends AbstractBaseExtendedContext{

	public Enum_number_indexContextExt(Enum_number_indexContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
		addToContexts(ctx);
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Enum_number_indexContext getLatestContext(){
		return (Enum_number_indexContext)super.getLatestContext();
	}


  /*
   * Create a context for the given string  with extended context populated in that
   */
	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).enum_number_index();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Enum_number_indexContext){
				addToContexts((Enum_number_indexContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Enum_number_indexContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}