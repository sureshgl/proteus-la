package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Enum_nameContextExt extends AbstractBaseExtendedContext{

	public Enum_nameContextExt(Enum_nameContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Enum_nameContext getLatestContext(){
		return (Enum_nameContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Enum_nameContext getContext(String str){
		return (Enum_nameContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).enum_name());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Enum_nameContext){
				addToContexts((Enum_nameContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Enum_nameContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}