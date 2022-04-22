package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LAParser.*;


public class Const_expr_ltContextExt extends Constant_expressionContextExt{

	public Const_expr_ltContextExt(Const_expr_ltContext ctx) {
		super(ctx);
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Const_expr_ltContext getLatestContext(){
		return (Const_expr_ltContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Const_expr_ltContext getContext(String str){
		return (Const_expr_ltContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).constant_expression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Const_expr_ltContext){
				addToContexts((Const_expr_ltContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Const_expr_ltContext.class.getName());
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
