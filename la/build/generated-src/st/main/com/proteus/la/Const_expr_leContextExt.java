package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LAParser.*;


public class Const_expr_leContextExt extends Constant_expressionContextExt{

	public Const_expr_leContextExt(Const_expr_leContext ctx) {
		super(ctx);
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Const_expr_leContext getLatestContext(){
		return (Const_expr_leContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Const_expr_leContext getContext(String str){
		return (Const_expr_leContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).constant_expression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Const_expr_leContext){
				addToContexts((Const_expr_leContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Const_expr_leContext.class.getName());
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
