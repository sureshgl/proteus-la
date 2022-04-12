package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Const_expr_gtContextExt extends Constant_expressionContextExt{

	public Const_expr_gtContextExt(Const_expr_gtContext ctx) {
		super(ctx);
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Const_expr_gtContext getLatestContext(){
		return (Const_expr_gtContext)super.getLatestContext();
	}

	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).constant_expression();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Const_expr_gtContext){
				addToContexts((Const_expr_gtContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Const_expr_gtContext.class.getName());
			}
		}
		else {
			addToContexts(null);
		}
	}
}