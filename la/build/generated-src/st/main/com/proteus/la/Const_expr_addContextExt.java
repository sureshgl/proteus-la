package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LAParser.*;

import java.lang.Long;

public class Const_expr_addContextExt extends Constant_expressionContextExt{

	public Const_expr_addContextExt(Const_expr_addContext ctx) {
		super(ctx);
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Const_expr_addContext getLatestContext(){
		return (Const_expr_addContext)super.getLatestContext();
	}

	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).constant_expression();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Const_expr_addContext){
				addToContexts((Const_expr_addContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Const_expr_addContext.class.getName());
			}
		}
		else {
			addToContexts(null);
		}
	}

	@Override 
	public Long eval() throws Exception
	{
		Long lhs = getLatestContext().constant_expression(0).extendedContext.eval();
		Long rhs = getLatestContext().constant_expression(0).extendedContext.eval();
		return lhs + rhs;
	}
}
