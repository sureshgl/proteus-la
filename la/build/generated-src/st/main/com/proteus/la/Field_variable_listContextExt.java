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


	private  Chain_definitionContextExt getChain(String chainName){
		return (Chain_definitionContextExt) getSymbol(chainName);
	}

	private Group_declarationContextExt getGroup(String groupName){
		return (Group_declarationContextExt)getSymbol(groupName);
	}

	private ElementContextExt getElement(String elementName){
		return (ElementContextExt)getSymbol(elementName);
	}

	private FieldContextExt getField(String fieldName){
		return (FieldContextExt)getSymbol(fieldName);
	}

	public Field_variable_listContextExt(Field_variable_listContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
		addToContexts(ctx);
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
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).field_variable_list();
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

	public Long getFieldStart(){
		return this.fieldStart;
	}

	public Long getFieldEnd(){
		return this.fieldEnd;
	}

	public Long getFieldLength(){
		return this.fieldEnd - this.fieldStart + 1;
	}

	@Override 
	public void processFieldReferences(){
		//super.processFieldReferences();
		List<Field_variableContext> field_variableContexts= getLatestContext().field_variable();
		this.fields = new ArrayList<FieldContextExt>();
		String[] fieldNames  = new String[field_variableContexts.size()];

		Field_variableContextExt field_variableContextExt = (Field_variableContextExt)extendedContextVisitor.visit(field_variableContexts.get(0));
		String chainName = field_variableContextExt.getChainName();
		this.chain =  getChain(chainName);
		String groupName = field_variableContextExt.getGroupName();
		this.group = getGroup(groupName);
		String elementName = field_variableContextExt.getElementName();
		this.element = getElement(elementName);
		fieldNames[0] = field_variableContextExt.getFieldName();
		this.fields.add(getField(fieldNames[0]));

		for(int i=1; i < field_variableContexts.size(); i++ ){
			field_variableContextExt = (Field_variableContextExt)extendedContextVisitor.visit(field_variableContexts.get(0));
			String anotherChainName = field_variableContextExt.getChainName();
			assert anotherChainName.equals(chainName) : "Should not have fileds from diferent chains";
			String anotherGroupName = field_variableContextExt.getGroupName();
			assert anotherGroupName.equals(groupName) : "Should not have fileds from diferent groups";
			String anotherElementName = field_variableContextExt.getElementName();
			assert anotherElementName.equals(elementName) : "Should not have fileds from diferent groups";
			fieldNames[i] = field_variableContextExt.getFieldName();
			for(int k=i; k>=0; k--){
				assert fieldNames[k].equals(i) : "Should not have a field more than once";
			}
			this.fields.add(getField(fieldNames[i]));
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

	// @Override
	// public void PopulateLAStructs(){
	// 	List<Field_variableContext> fieldContexts= getLatestContext().field_variable();
	// 	for(Field_variableContext fieldContext : fieldContexts){
	// 		Field_variableContext latestFieldContext = fieldContext.extendedContext.getLatestContext();
	// 		String chainName = latestFieldContext.extendedContext.getChainName();
	// 		if(LAStructs.chains.get(chainName) == null)	{
	// 			LAStructs.Chain chain = new LAStructs.Chain();
	// 			chain.name = chainName;
	// 			chain.chainContextExt = latestFieldContext.extendedContext.getChain();
	// 			LAStructs.chains.put(chain.name, chain);

	// 			LAStructs.Group group = new LAStructs.Group();
	// 			group.name = latestFieldContext.extendedContext.getGroupName();
	// 			group.groupContextExt = latestFieldContext.extendedContext.getGroup();
	// 			chain.groups.put(group.name, group);

	// 			LAStructs.Element element = new LAStructs.Element();
	// 			element.name = latestFieldContext.extendedContext.getElementName();
	// 			element.elementContextExt = latestFieldContext.extendedContext.getElement();
	// 			group.elements.put(element.name, element);

	// 			LAStructs.Field field = new LAStructs.Field();
	// 			field.name = latestFieldContext.extendedContext.getFieldName();
	// 			field.fieldContextExt = latestFieldContext.extendedContext.getField();
	// 			element.fields.put(field.name, field);
	// 		}
	// 		else{
	// 			LAStructs.Chain chain = LAStructs.chains.get(chainName);
	// 			String groupName = latestFieldContext.extendedContext.getGroupName();
	// 			if(chain.groups.get(groupName) == null)
	// 			{
	// 				LAStructs.Group group = new LAStructs.Group();
	// 				group.name = groupName;
	// 				group.groupContextExt = latestFieldContext.extendedContext.getGroup();
	// 				chain.groups.put(group.name, group);

	// 				LAStructs.Element element = new LAStructs.Element();
	// 				element.name = latestFieldContext.extendedContext.getElementName();
	// 				element.elementContextExt = latestFieldContext.extendedContext.getElement();
	// 				group.elements.put(element.name, element);

	// 				LAStructs.Field field = new LAStructs.Field();
	// 				field.name = latestFieldContext.extendedContext.getFieldName();
	// 				field.fieldContextExt = latestFieldContext.extendedContext.getField();
	// 				element.fields.put(field.name, field);
	// 			}
	// 			else{
	// 				LAStructs.Group group = chain.groups.get(groupName);
	// 				String elementName = latestFieldContext.extendedContext.getElementName();
	// 				if( group.elements.get(elementName) == null){
	// 					LAStructs.Element element = new LAStructs.Element();
	// 					element.name = elementName;
	// 					element.elementContextExt = latestFieldContext.extendedContext.getElement();
	// 					group.elements.put(element.name, element);
	// 					LAStructs.Field field = new LAStructs.Field();
	// 					field.name = latestFieldContext.extendedContext.getFieldName();
	// 					field.fieldContextExt = latestFieldContext.extendedContext.getField();
	// 					element.fields.put(field.name, field);
	// 				}
	// 				else{
	// 					assert group.elements.size() >= 1 : "Cannot have two elements from the same group. Group = "+ groupName + " Element=" + elementName;
	// 					LAStructs.Element element = group.elements.get(elementName);
	// 					String fieldName = latestFieldContext.extendedContext.getFieldName();
	// 					if (element.fields.get(fieldName) == null){
	// 						LAStructs.Field field = new LAStructs.Field();
	// 						field.name = latestFieldContext.extendedContext.getFieldName();
	// 						field.fieldContextExt = latestFieldContext.extendedContext.getField();
	// 						element.fields.put(field.name, field);
	// 					}
	// 					{
	// 						assert true : "Duplicate field selection fieldName=" + fieldName;
	// 					}
	// 				}
	// 			}
	// 		}
	// 	}

	// }
	


}
