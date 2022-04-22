package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Select_definitionContextExt extends AbstractBaseExtendedContext{

	private StartContext startContext = null;
	public Select_definitionContextExt(Select_definitionContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
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
	public Select_definitionContext getContext(String str){
		return (Select_definitionContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).select_definition());
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
	public AbstractBaseExtendedContext lookUp(String symbol){
		return startContext.extendedContext.lookUp(symbol);
	}

	public void process(StartContext ctx){
		this.startContext = ctx;
		StringBuilder sb = new StringBuilder();
		try{
			this.startContext.extendedContext.Initialize();
			Initialize();
		}
		catch(Exception ex){
		}
		processFieldReferences();
		symanticCheck();
		GenerateAddresses();
		this.startContext.extendedContext.printConfiguration(sb);
		System.out.println(sb.toString());
	}
}
