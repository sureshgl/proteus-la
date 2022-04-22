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

	public Long getNibbleAdjustedFieldLength(){
		Long length = getFieldLength();
		if( length % 4  == 0 ){
			return length;
		}
		else{
			return ((length>>2)<<2) + 4L;
		}
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

	@Override
	public void GenerateAddresses(){
		Chain_definitionContextExt chain_definitionContextExt = getChain();
		Group_declarationContextExt group_declarationContextExt = getGroup();
		group_declarationContextExt.setSelectedElement(getElement());
		Long currLoc = chain_definitionContextExt.getCurrLoc();
		Long shiftCount = 0L;
		Long[] nibbleSizes = chain_definitionContextExt.getNibbleSize();
		Long[] nibbleMasks = chain_definitionContextExt.getNibbleMask();
		if(getFieldLength() >= 4){
			shiftCount  =  getStartIndex() - currLoc;
			if ( shiftCount < 0L ){
				shiftCount = 64L  + shiftCount;
			}
			
			Long mask = Utils.getMask(getEndIndex(), getStartIndex());
			Long shiftedMask = Utils.circularRightShift(mask, shiftCount);
			group_declarationContextExt.setShiftCount(shiftCount);
			group_declarationContextExt.setMask(mask);
			group_declarationContextExt.setShiftedMask(shiftedMask);
			
			Long updatedCurrLoc = currLoc + getNibbleAdjustedFieldLength();
			chain_definitionContextExt.updateCurrLoc(updatedCurrLoc);

			Long lastNibble = updatedCurrLoc/4 - 1;
			Long lastNibbleSize = 4 - (getNibbleAdjustedFieldLength() - getFieldLength());
			for(Long nibble=currLoc/4; nibble < lastNibble; nibble++) { 
				nibbleSizes[nibble.intValue()] = 0L; 
				nibbleMasks[nibble.intValue()] = -1L;
			}
			if(getNibbleAdjustedFieldLength() > getFieldLength()){
				nibbleSizes[lastNibble.intValue()] = 4 - lastNibbleSize; //available size
				nibbleMasks[lastNibble.intValue()] = Utils.getNibbleMask(lastNibble, lastNibbleSize);
			}
			else{
				nibbleSizes[lastNibble.intValue()] = 0L; 
				nibbleMasks[lastNibble.intValue()] = -1L;
			}
		}
		else{
			//get the first free slot
			Boolean placed = false;
			while(!placed){
				for(int i=0; i<nibbleSizes.length; i++){
					if(nibbleSizes[i] >= getFieldLength()){
						//check if we can fit the value there.
						Long fieldMask = Utils.getMask(getEndIndex(), getStartIndex());
						logger.info("fieldMask="+Long.toBinaryString(fieldMask));
						Long nibbleCurrLoc = i * 4 + (4 - nibbleSizes[i]);
						logger.info("nibbleCurrLoc="+ nibbleCurrLoc);
						Long fieldShiftCount = getStartIndex() - nibbleCurrLoc;
						Long shiftedFieldMask = 0L;
						if(fieldShiftCount > 0){
							shiftedFieldMask = Utils.circularRightShift(fieldMask, fieldShiftCount);
						}
						else{
							shiftedFieldMask = Utils.circularLeftShift(fieldMask, Math.abs(fieldShiftCount));
						}
						logger.info("circularShiftedFieldMask="+Long.toBinaryString(shiftedFieldMask));
						logger.info("~nibbleMasks[i]=" + Long.toBinaryString(~nibbleMasks[i]));
						logger.info("(~nibbleMasks[i] | shiftedFieldMask)= " + Long.toBinaryString(~nibbleMasks[i] | shiftedFieldMask));
						if( (~nibbleMasks[i] | shiftedFieldMask) == -1L ){
							if ( fieldShiftCount < 0L ){
								fieldShiftCount = 64L  + fieldShiftCount;
							}
							group_declarationContextExt.setShiftCount(fieldShiftCount);
							group_declarationContextExt.setMask(Utils.getMask(getEndIndex(), getStartIndex()));
							group_declarationContextExt.setShiftedMask(shiftedFieldMask);
							nibbleMasks[i] |= ~shiftedFieldMask;
							nibbleSizes[i] -= getFieldLength();
							placed = true;
							break;
						}
					}
				}
			}
		}
	}
}
