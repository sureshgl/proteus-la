package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

import java.lang.Long;

public class NumberContextExt extends AbstractBaseExtendedContext{

	private Long number;
	public NumberContextExt(NumberContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
		number = 0L;
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public NumberContext getLatestContext(){
		return (NumberContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public NumberContext getContext(String str){
		return (NumberContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).number());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof NumberContext){
				addToContexts((NumberContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+NumberContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	@Override
  public void Initialize() throws Exception{
		if( (getLatestContext().Hex_number() != null )&&  (getLatestContext().Hex_number().getText().length()  > 0 )){
			number = Long.decode(getLatestContext().Hex_number().getText());
		}
		else if( (getLatestContext().Unsigned_number() != null) &&  (getLatestContext().Unsigned_number().getText().length()  > 0 ) ){
			number = Long.decode(getLatestContext().Unsigned_number().getText());
		}
		else
			throw new NumberFormatException(getLatestContext().getText());
	}

	public Long eval() {
			return number;
	}
	

}
