package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Stop_indexContextExt extends AbstractBaseExtendedContext{

	private Long stop_index;
	public Stop_indexContextExt(Stop_indexContext ctx) {
		super("la", new LAParser(null), new LALexer(null), new LAParserExtendedContextVisitor());
		addToContexts(ctx);
		parent = ctx;
		stop_index = 0L;
	}

  /*
   * Return the conext associated with this extened context
   */
	@Override
	public Stop_indexContext getContext(){
		return (Stop_indexContext)contexts.get(contexts.size()-1);
	}

  /*
   * Create a context for the given string  with extended context populated in that
   */
	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).stop_index();
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
		stop_index = ((Constant_expressionContextExt)extendedContextVisitor.visit(getContext().constant_expression())).eval();

	}

}