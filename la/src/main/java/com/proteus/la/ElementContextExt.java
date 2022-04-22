package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

import com.proteus.framework.app.SymbolTable;

public class ElementContextExt extends AbstractBaseExtendedContext{

	public ElementContextExt(ElementContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
		localSymbolTable = new SymbolTable();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public ElementContext getLatestContext(){
		return (ElementContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public ElementContext getContext(String str){
		return (ElementContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).element());
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

	public Long getIndex(){
		Element_number_indexContext element_number_indexContext = getLatestContext().element_number_index();
		return element_number_indexContext.extendedContext.getIndex();
	}

	@Override
	public void PopulateSymbolTable(SymbolTable symbolTable){
		super.PopulateSymbolTable(localSymbolTable);
		String elementName = getLatestContext().element_name().extendedContext.getName();
		symbolTable.put(elementName, this);
	}


}
