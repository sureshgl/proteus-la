package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LAParser.*;


public class Const_expr_st_stContextExt extends Constant_expressionContextExt{

	public Const_expr_st_stContextExt(Const_expr_st_stContext ctx) {
		super(ctx);
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Const_expr_st_stContext getLatestContext(){
		return (Const_expr_st_stContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Const_expr_st_stContext getContext(String str){
		return (Const_expr_st_stContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).constant_expression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Const_expr_st_stContext){
				addToContexts((Const_expr_st_stContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Const_expr_st_stContext.class.getName());
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
