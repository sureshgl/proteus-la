package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Element_nameContextExt extends AbstractBaseExtendedContext{

	public Element_nameContextExt(Element_nameContext ctx) {
		super("la", new LAParser(null), new LALexer(null), new LAParserExtendedContextVisitor());
		addToContexts(ctx);
		parent = ctx;
	}

  /*
   * Return the conext associated with this extened context
   */
	@Override
	public Element_nameContext getContext(){
		return (Element_nameContext)contexts.get(contexts.size()-1);
	}

  /*
   * Create a context for the given string  with extended context populated in that
   */
	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).element_name();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Element_nameContext){
				addToContexts((Element_nameContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Element_nameContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}