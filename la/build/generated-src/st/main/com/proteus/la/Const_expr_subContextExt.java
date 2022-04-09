package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Const_expr_subContextExt extends Constant_expressionContextExt{

	public Const_expr_subContextExt(Const_expr_subContext ctx) {
		super(ctx);
	}

	@Override
	public Const_expr_subContext getContext(){
		return (Const_expr_subContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).constant_expression();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Const_expr_subContext){
				addToContexts((Const_expr_subContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Const_expr_subContext.class.getName());
			}
		}
		else {
			addToContexts(null);
		}
	}
}