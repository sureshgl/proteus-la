package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LAParser.*;


public class Const_expr_only_primaryContextExt extends Constant_expressionContextExt{

	public Const_expr_only_primaryContextExt(Const_expr_only_primaryContext ctx) {
		super(ctx);
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Const_expr_only_primaryContext getLatestContext(){
		return (Const_expr_only_primaryContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Const_expr_only_primaryContext getContext(String str){
		return (Const_expr_only_primaryContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).constant_expression());
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

	@Override
	public Long eval() throws Exception {
		if( (getLatestContext().number() != null) && (getLatestContext().number().getText().length() > 0) )
			return getLatestContext().number().extendedContext.eval();
		else
			throw new NumberFormatException(getLatestContext().getText());
	}

}
