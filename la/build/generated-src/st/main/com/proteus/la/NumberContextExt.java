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
		super("la", new LAParser(null), new LALexer(null), new LAParserExtendedContextVisitor());
		addToContexts(ctx);
		parent = ctx;
		number = 0L;
	}

  /*
   * Return the conext associated with this extened context
   */
	@Override
	public NumberContext getContext(){
		return (NumberContext)contexts.get(contexts.size()-1);
	}

  /*
   * Create a context for the given string  with extended context populated in that
   */
	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).number();
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
  public void Initalize(){
		if( (getContext().Hex_number() != null )&&  (getContext().Hex_number().getText().length()  > 0 )){
			number = Long.decode(getContext().Hex_number().getText());
		}
		else if( (getContext().Unsigned_number() != null) &&  (getContext().Unsigned_number().getText().length()  > 0 ) ){
			number = Long.decode(getContext().Unsigned_number().getText());
		}
		else
			throw new NumberFormatException(getContext().getText());
	}

	public Long eval() {
			return number;
	}
	

}