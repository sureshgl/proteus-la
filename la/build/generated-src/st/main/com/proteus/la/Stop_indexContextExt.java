package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Stop_indexContextExt extends AbstractBaseExtendedContext{

	private Long stop_index;
	public Stop_indexContextExt(Stop_indexContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
		stop_index = 0L;
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Stop_indexContext getLatestContext(){
		return (Stop_indexContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Stop_indexContext getContext(String str){
		return (Stop_indexContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).stop_index());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Stop_indexContext){
				addToContexts((Stop_indexContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Stop_indexContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	public Long getIndex()
	{
		return stop_index;
	}

	@Override
	public void Initialize() throws Exception{
		//stop_index = getContext().constant_expression().extendedContext.eval(); //Wrong way of accessing the extended context of a child nodes.
		stop_index = ((Constant_expressionContextExt)extendedContextVisitor.visit(getLatestContext().constant_expression())).eval();

	}

}
