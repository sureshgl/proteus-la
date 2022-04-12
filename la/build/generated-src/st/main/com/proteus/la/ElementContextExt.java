package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

import com.proteus.framework.app.SymbolTable;

public class ElementContextExt extends AbstractBaseExtendedContext{

	public ElementContextExt(ElementContext ctx) {
		super("la", new LAParser(null), new LALexer(null), new LAParserExtendedContextVisitor());
		addToContexts(ctx);
		parent = ctx;
		localSymbolTable = new SymbolTable();
	}

  /*
   * Return the conext associated with this extened context
   */
	@Override
	public ElementContext getContext(){
		return (ElementContext)contexts.get(contexts.size()-1);
	}

  /*
   * Create a context for the given string  with extended context populated in that
   */
	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).element();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof ElementContext){
				addToContexts((ElementContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+ElementContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	@Override
	public void PopulateSymbolTable(SymbolTable symbolTable){
		symbolTable.put(getContext().element_name().getText(), this);
		super.PopulateSymbolTable(localSymbolTable);
	}


}