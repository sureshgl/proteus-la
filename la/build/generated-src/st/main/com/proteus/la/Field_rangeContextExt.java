package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;
import com.proteus.la.Start_indexContextExt;
import com.proteus.la.Stop_indexContextExt;



public class Field_rangeContextExt extends AbstractBaseExtendedContext{

	public Field_rangeContextExt(Field_rangeContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
		addToContexts(ctx);
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Field_rangeContext getLatestContext(){
		return (Field_rangeContext)super.getLatestContext();
	}


  /*
   * Create a context for the given string  with extended context populated in that
   */
	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).field_range();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Field_rangeContext){
				addToContexts((Field_rangeContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Field_rangeContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	public Long getFieldStartIndex(){
		return ((Start_indexContextExt)extendedContextVisitor.visit(getLatestContext().start_index())).getIndex();
	}

	public Long getFieldStopIndex(){
		return ((Stop_indexContextExt)extendedContextVisitor.visit(getLatestContext().stop_index())).getIndex();
	}

	public Long getSize(){
		return Math.abs((getFieldStartIndex() - getFieldStopIndex()) + 1 );
	}
}
