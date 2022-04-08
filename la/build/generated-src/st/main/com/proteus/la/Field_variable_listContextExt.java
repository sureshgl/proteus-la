package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Field_variable_listContextExt extends AbstractBaseExtendedContext{

	public Field_variable_listContextExt(Field_variable_listContext ctx) {
		super("la", new LAParser(null), new LALexer(null), new LAParserExtendedContextVisitor());
		addToContexts(ctx);
		parent = ctx;
	}

  /*
   * Return the conext associated with this extened context
   */
	@Override
	public Field_variable_listContext getContext(){
		return (Field_variable_listContext)contexts.get(contexts.size()-1);
	}

  /*
   * Create a context for the given string  with extended context populated in that
   */
	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).field_variable_list();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Field_variable_listContext){
				addToContexts((Field_variable_listContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Field_variable_listContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}
}