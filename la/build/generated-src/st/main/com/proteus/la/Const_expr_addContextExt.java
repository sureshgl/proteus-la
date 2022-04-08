package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Const_expr_addContextExt extends Constant_expressionContextExt{

	public Const_expr_addContextExt(Const_expr_addContext ctx) {
		super(ctx);
	}

	@Override
	public Const_expr_addContext getContext(){
		return (Const_expr_addContext)contexts.get(contexts.size()-1);
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
}