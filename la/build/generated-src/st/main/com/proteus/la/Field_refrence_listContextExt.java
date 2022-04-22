package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Field_refrence_listContextExt extends AbstractBaseExtendedContext{

	public Field_refrence_listContextExt(Field_refrence_listContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Field_refrence_listContext getLatestContext(){
		return (Field_refrence_listContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Field_refrence_listContext getContext(String str){
		return (Field_refrence_listContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).field_refrence_list());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Field_refrence_listContext){
				addToContexts((Field_refrence_listContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Field_refrence_listContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	/*
		Order the field refernces base on their field sizes
	*/
	@Override
	public void GenerateAddresses(){
		List<Field_referenceContext> field_referenceContexts =  getLatestContext().field_reference();
		List<Field_referenceContextExt> field_referenceContextExts = new ArrayList<>();
		for(Field_referenceContext field_referenceContext : field_referenceContexts){
			field_referenceContextExts.add(field_referenceContext.extendedContext);
		}
		field_referenceContextExts.sort(Comparator.comparing(Field_referenceContextExt::getFieldLength).reversed());

		for(int i=0; i < field_referenceContextExts.size(); i++){
			logger.info(field_referenceContextExts.get(i).getFormattedText());
		}

		for(int i=0; i < field_referenceContextExts.size(); i++){
			field_referenceContextExts.get(i).GenerateAddresses();
		}
	}


}