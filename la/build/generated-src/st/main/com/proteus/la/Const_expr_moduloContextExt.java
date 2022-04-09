package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Const_expr_moduloContextExt extends Constant_expressionContextExt{

	public Const_expr_moduloContextExt(Const_expr_moduloContext ctx) {
		super(ctx);
	}

	@Override
	public Const_expr_moduloContext getContext(){
		return (Const_expr_moduloContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).constant_expression();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Const_expr_moduloContext){
				addToContexts((Const_expr_moduloContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Const_expr_moduloContext.class.getName());
			}
		}
		else {
			addToContexts(null);
		}
	}
}