package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Field_referenceContextExt extends AbstractBaseExtendedContext{

	public Field_referenceContextExt(Field_referenceContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Field_referenceContext getLatestContext(){
		return (Field_referenceContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Field_referenceContext getContext(String str){
		return (Field_referenceContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).field_reference());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Field_referenceContext){
				addToContexts((Field_referenceContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Field_referenceContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	public Chain_definitionContextExt getChain(){
		Field_variable_listContext field_variable_listContext = getLatestContext().field_variable_list();
		Field_variable_listContextExt field_variable_listContextExt = (Field_variable_listContextExt)extendedContextVisitor.visit(field_variable_listContext);
		return field_variable_listContextExt.getChain();
	}

	public Group_declarationContextExt getGroup(){
		Field_variable_listContext field_variable_listContext = getLatestContext().field_variable_list();
		Field_variable_listContextExt field_variable_listContextExt = (Field_variable_listContextExt)extendedContextVisitor.visit(field_variable_listContext);
		return field_variable_listContextExt.getGroup();
	}

	public ElementContextExt getElement(){
		Field_variable_listContext field_variable_listContext = getLatestContext().field_variable_list();
		Field_variable_listContextExt field_variable_listContextExt = (Field_variable_listContextExt)extendedContextVisitor.visit(field_variable_listContext);
		return field_variable_listContextExt.getElement();
	}

	public Long getFieldLength(){
		Field_variable_listContext field_variable_listContext = getLatestContext().field_variable_list();
		Field_variable_listContextExt field_variable_listContextExt = (Field_variable_listContextExt)extendedContextVisitor.visit(field_variable_listContext);
		return field_variable_listContextExt.getFieldLength();
	}

	public Long getStartIndex(){
		Field_variable_listContext field_variable_listContext = getLatestContext().field_variable_list();
		Field_variable_listContextExt field_variable_listContextExt = (Field_variable_listContextExt)extendedContextVisitor.visit(field_variable_listContext);
		return field_variable_listContextExt.getStartIndex();

	}

	public Long getEndIndex(){
		Field_variable_listContext field_variable_listContext = getLatestContext().field_variable_list();
		Field_variable_listContextExt field_variable_listContextExt = (Field_variable_listContextExt)extendedContextVisitor.visit(field_variable_listContext);
		return field_variable_listContextExt.getEndIndex();

	}

	public Long getMask(Long startIndex, Long endIndex){
		Long arg1 = -1L;
		Long arg2 = -1L;
		if(startIndex < 63)
		{
				arg1 = (1L << (startIndex + 1)) -1;
		}
		arg2 = arg2<<endIndex;
		System.out.println(Long.toBinaryString(arg1 & arg2));
		System.out.println(Long.toBinaryString(~(arg1 & arg2)));
		return ~(arg1 & arg2);
	}

	@Override
	public void GenerateAddresses(){
		Chain_definitionContextExt chain_definitionContextExt = getChain();
		Group_declarationContextExt group_declarationContextExt = getGroup();
		group_declarationContextExt.setSelectedElement(getElement());
		Long currLoc = chain_definitionContextExt.getCurrLoc();
		Long shiftCount  =  getStartIndex() - currLoc;
		if ( shiftCount < 0L ){
			shiftCount = 64L  + shiftCount;
		}
		group_declarationContextExt.setShiftCount(shiftCount);
		group_declarationContextExt.setMask(getMask(getStartIndex(), getEndIndex()));
		Long updatedCurrLoc = currLoc + getFieldLength();
		chain_definitionContextExt.updateCurrLoc(updatedCurrLoc);
	}
}
