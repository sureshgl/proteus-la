package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class FieldContextExt extends AbstractBaseExtendedContext{

	private Long mask;	
	public FieldContextExt(FieldContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
		mask = -1L;
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public FieldContext getLatestContext(){
		return (FieldContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public FieldContext getContext(String str){
		return (FieldContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).field());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof FieldContext){
				addToContexts((FieldContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+FieldContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	@Override
	public void PopulateSymbolTable(SymbolTable symbolTable){
		String fieldName = getName();
		symbolTable.put(fieldName, this);
	}

	public String getName(){
		return  getLatestContext().field_name().extendedContext.getName();
	}

	public Long getStartIndex(){
		return getLatestContext().field_range().extendedContext.getFieldStartIndex();
	}

	public Long getStopIndex(){
		return getLatestContext().field_range().extendedContext.getFieldStopIndex();
	}	

	public Long getSize(){
		assert getStopIndex() > getStartIndex() : "stop index should be greated than start index";
		return getStopIndex() - getStartIndex() + 1;
	}

	public Long getMask(){
		Long arg1 = -1L;
		Long arg2 = -1L;
		if(getStartIndex() < 63)
		{
				arg1 = (1L << (getStartIndex() + 1)) -1;
		}
		arg2 = arg2<<getStopIndex();
		return ~(arg1 & arg2);
	}

	public void Initialize() throws Exception{
		this.mask = getMask();
	}

}
