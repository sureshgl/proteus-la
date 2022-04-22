package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Variable_address_definitionContextExt extends AbstractBaseExtendedContext{
	private Long fieldValue;
	private Long fieldMask;
	public Variable_address_definitionContextExt(Variable_address_definitionContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
		fieldMask = -1L;
		fieldValue = -1L;
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Variable_address_definitionContext getLatestContext(){
		return (Variable_address_definitionContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Variable_address_definitionContext getContext(String str){
		return (Variable_address_definitionContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).variable_address_definition());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Variable_address_definitionContext){
				addToContexts((Variable_address_definitionContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Variable_address_definitionContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	public void setFieldMask(Long mask)
	{
		this.fieldMask = mask;
	}
	
	public Long getFieldMask(){
		return this.fieldMask;
	}

	public void setFieldValue(Long value)
	{
		this.fieldValue = value;
	}

	public Long getFieldValue(){
		return this.fieldValue;
	}

	@Override
	public void PopulateSymbolTable(SymbolTable symbolTable)
	{
		Variable_nameContext variable_nameContext = getLatestContext().variable_name();
		String variable_name = variable_nameContext.extendedContext.getName();
		String key = getLatestContext().variable().getText() + " " + variable_name;
		symbolTable.put(key,this);
	}


}