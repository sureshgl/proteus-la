package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class IsolateContextExt extends AbstractBaseExtendedContext{

	public IsolateContextExt(IsolateContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public IsolateContext getLatestContext(){
		return (IsolateContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public IsolateContext getContext(String str){
		return (IsolateContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).isolate());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof IsolateContext){
				addToContexts((IsolateContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+IsolateContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}