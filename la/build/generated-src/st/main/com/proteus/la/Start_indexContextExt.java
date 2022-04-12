package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Start_indexContextExt extends AbstractBaseExtendedContext{

	private Long start_index;

	public Start_indexContextExt(Start_indexContext ctx) {
		super("la", new LAParser(null), new LALexer(null), new LAParserExtendedContextVisitor());
		addToContexts(ctx);
		parent = ctx;
		start_index = 0L;
	}

  /*
   * Return the conext associated with this extened context
   */
	@Override
	public Start_indexContext getContext(){
		return (Start_indexContext)contexts.get(contexts.size()-1);
	}

  /*
   * Create a context for the given string  with extended context populated in that
   */
	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).start_index();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Start_indexContext){
				addToContexts((Start_indexContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Start_indexContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	public Long getIndex(){
		return start_index;
	}
	
	@Override
	public void Initialize() throws Exception{
		//start_index = getContext().constant_expression().extendedContext.eval();
		start_index = ((Constant_expressionContextExt)extendedContextVisitor.visit(getContext().constant_expression())).eval();
	}
}