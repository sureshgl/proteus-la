package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LAParser.*;


public class Const_expr_arshiftContextExt extends Constant_expressionContextExt{

	public Const_expr_arshiftContextExt(Const_expr_arshiftContext ctx) {
		super(ctx);
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Const_expr_arshiftContext getLatestContext(){
		return (Const_expr_arshiftContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Const_expr_arshiftContext getContext(String str){
		return (Const_expr_arshiftContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).constant_expression());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Const_expr_arshiftContext){
				addToContexts((Const_expr_arshiftContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Const_expr_arshiftContext.class.getName());
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
