package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LAParser.*;


public class Const_expr_andContextExt extends Constant_expressionContextExt{

	public Const_expr_andContextExt(Const_expr_andContext ctx) {
		super(ctx);
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Const_expr_andContext getLatestContext(){
		return (Const_expr_andContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Const_expr_andContext getContext(String str){
		return (Const_expr_andContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).constant_expression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Const_expr_andContext){
				addToContexts((Const_expr_andContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Const_expr_andContext.class.getName());
			}
		}
		else {
			addToContexts(null);
		}
	}
	
	@Override
	public Long eval() throws Exception
	{
		throw new UnsupportedOperationException();
	}
}
