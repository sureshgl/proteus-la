package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Const_expr_only_primaryContextExt extends Constant_expressionContextExt{

	public Const_expr_only_primaryContextExt(Const_expr_only_primaryContext ctx) {
		super(ctx);
	}

	@Override
	public Const_expr_only_primaryContext getContext(){
		return (Const_expr_only_primaryContext)contexts.get(contexts.size()-1);
	}

	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).constant_expression();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Const_expr_only_primaryContext){
				addToContexts((Const_expr_only_primaryContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Const_expr_only_primaryContext.class.getName());
			}
		}
		else {
			addToContexts(null);
		}
	}
}