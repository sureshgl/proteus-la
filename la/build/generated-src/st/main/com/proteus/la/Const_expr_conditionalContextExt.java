package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Const_expr_conditionalContextExt extends Constant_expressionContextExt{

	public Const_expr_conditionalContextExt(Const_expr_conditionalContext ctx) {
		super(ctx);
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Const_expr_conditionalContext getLatestContext(){
		return (Const_expr_conditionalContext)super.getLatestContext();
	}

	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).constant_expression();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Const_expr_conditionalContext){
				addToContexts((Const_expr_conditionalContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Const_expr_conditionalContext.class.getName());
			}
		}
		else {
			addToContexts(null);
		}
	}
}