package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;
import com.proteus.la.app.LAStructs;
import com.proteus.la.app.LAStructs.*;
import java.util.Map;
import java.util.LinkedHashMap;

public class Select_definitionContextExt extends AbstractBaseExtendedContext{

	public Select_definitionContextExt(Select_definitionContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
		addToContexts(ctx);
		LAStructs.chains = new LinkedHashMap<String, LAStructs.Chain>();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Select_definitionContext getLatestContext(){
		return (Select_definitionContext)super.getLatestContext();
	}


  /*
   * Create a context for the given string  with extended context populated in that
   */
	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).select_definition();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Select_definitionContext){
				addToContexts((Select_definitionContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Select_definitionContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	@Override
	public void Initialize()throws Exception{
		PopulateLAStructs();
		super.Initialize();
	}

	public void SelectSymanticCheck(){

	}

	public void process(){
		try{
			Initialize();
		}
		catch(Exception ex){

		}
		PopulateLAStructs();
		SelectSymanticCheck();
	}
}
