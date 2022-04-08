package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Chain_varible_nameContextExt extends AbstractBaseExtendedContext{

	public Chain_varible_nameContextExt(Chain_varible_nameContext ctx) {
		super("la", new LAParser(null), new LALexer(null), new LAParserExtendedContextVisitor());
		addToContexts(ctx);
		parent = ctx;
	}

  /*
   * Return the conext associated with this extened context
   */
	@Override
	public Chain_varible_nameContext getContext(){
		return (Chain_varible_nameContext)contexts.get(contexts.size()-1);
	}

  /*
   * Create a context for the given string  with extended context populated in that
   */
	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).chain_varible_name();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Chain_varible_nameContext){
				addToContexts((Chain_varible_nameContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Chain_varible_nameContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}