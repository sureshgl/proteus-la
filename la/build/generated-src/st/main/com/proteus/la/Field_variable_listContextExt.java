package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

import java.util.ArrayList;
import java.util.List;

public class Field_variable_listContextExt extends AbstractBaseExtendedContext{
	
	private Chain_definitionContextExt chain;
	private Group_declarationContextExt group;
	private ElementContextExt element;
	private List<FieldContextExt> fields;
	private Long fieldStart;
	private Long fieldEnd;

	public Field_variable_listContextExt(Field_variable_listContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
		fieldStart = Long.MAX_VALUE;
		fieldEnd = Long.MIN_VALUE;
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Field_variable_listContext getLatestContext(){
		return (Field_variable_listContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Field_variable_listContext getContext(String str){
		return (Field_variable_listContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).field_variable_list());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Field_variable_listContext){
				addToContexts((Field_variable_listContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Field_variable_listContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	public Chain_definitionContextExt getChain(){
		return this.chain;
	}

	public Group_declarationContextExt getGroup(){
		return this.group;
	}

	public ElementContextExt getElement(){
		return this.element;
	}

	public List<FieldContextExt> getFields(){
		return this.fields;
	}

	public Long getStartIndex(){
		return this.fieldStart;
	}

	public Long getEndIndex(){
		return this.fieldEnd;
	}

	public Long getFieldLength(){
		Long length = this.fieldEnd - this.fieldStart + 1;
		if( length % 4  == 0 ){
			return length;
		}
		else{
			return ((length>>2)<<2) + 4L;
		}
	}

	@Override 
	public void processFieldReferences(){
		//super.processFieldReferences();
		List<Field_variableContext> field_variableContexts= getLatestContext().field_variable();
		this.fields = new ArrayList<FieldContextExt>();
		String[] fieldNames  = new String[field_variableContexts.size()];

		Field_variableContextExt field_variableContextExt = (Field_variableContextExt)extendedContextVisitor.visit(field_variableContexts.get(0));
		String chainName = field_variableContextExt.getChainName();
		this.chain = field_variableContextExt.getChain();
		//this.chain =  getChain(chainName);
		String groupName = field_variableContextExt.getGroupName();
		this.group = field_variableContextExt.getGroup();
		String elementName = field_variableContextExt.getElementName();
		this.element = field_variableContextExt.getElement();
		fieldNames[0] = field_variableContextExt.getFieldName();
		this.fields.add(field_variableContextExt.getField());

		for(int i=1; i < field_variableContexts.size(); i++ ){
			field_variableContextExt = (Field_variableContextExt)extendedContextVisitor.visit(field_variableContexts.get(i));
			String anotherChainName = field_variableContextExt.getChainName();
			assert anotherChainName.equals(chainName) : "Should not have fileds from diferent chains";
			String anotherGroupName = field_variableContextExt.getGroupName();
			assert anotherGroupName.equals(groupName) : "Should not have fileds from diferent groups";
			String anotherElementName = field_variableContextExt.getElementName();
			assert anotherElementName.equals(elementName) : "Should not have fileds from diferent groups";
			fieldNames[i] = field_variableContextExt.getFieldName();
			for(int k=i-1; k>=0; k--){
				assert !(fieldNames[k].equals(fieldNames[i])) : "Should not have a field more than once field:" + fieldNames[i];
			}
			this.fields.add(field_variableContextExt.getField());
		}

		//Set Start & End values of the field collection
		for(FieldContextExt fieldContextExt : this.fields){
			if (fieldStart > fieldContextExt.getStartIndex()){
				fieldStart = fieldContextExt.getStartIndex();
			}
			if (fieldEnd < fieldContextExt.getStopIndex()){
				fieldEnd = fieldContextExt.getStopIndex();
			}
		}
	}
}
