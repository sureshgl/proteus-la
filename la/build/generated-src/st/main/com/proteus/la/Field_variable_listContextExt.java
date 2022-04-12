package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;
import com.proteus.la.app.LAStructs;
import com.proteus.la.app.LAStructs.*;

import java.util.List;

public class Field_variable_listContextExt extends AbstractBaseExtendedContext{

	private int field_count;
	public Field_variable_listContextExt(Field_variable_listContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
		addToContexts(ctx);
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

	@Override
	public void PopulateLAStructs(){
		List<Field_variableContext> fieldContexts= getLatestContext().field_variable();
		for(Field_variableContext fieldContext : fieldContexts){
			Field_variableContext latestFieldContext = fieldContext.extendedContext.getLatestContext();
			String chainName = latestFieldContext.extendedContext.getChainName();
			if(LAStructs.chains.get(chainName) == null)	{
				LAStructs.Chain chain = new LAStructs.Chain();
				chain.name = chainName;
				chain.chainContextExt = latestFieldContext.extendedContext.getChain();
				LAStructs.chains.put(chain.name, chain);

				LAStructs.Group group = new LAStructs.Group();
				group.name = latestFieldContext.extendedContext.getGroupName();
				group.groupContextExt = latestFieldContext.extendedContext.getGroup();
				chain.groups.put(group.name, group);

				LAStructs.Element element = new LAStructs.Element();
				element.name = latestFieldContext.extendedContext.getElementName();
				element.elementContextExt = latestFieldContext.extendedContext.getElement();
				group.elements.put(element.name, element);

				LAStructs.Field field = new LAStructs.Field();
				field.name = latestFieldContext.extendedContext.getFieldName();
				field.fieldContextExt = latestFieldContext.extendedContext.getField();
				element.fields.put(field.name, field);
			}
			else{
				LAStructs.Chain chain = LAStructs.chains.get(chainName);
				String groupName = latestFieldContext.extendedContext.getGroupName();
				if(chain.groups.get(groupName) == null)
				{
					LAStructs.Group group = new LAStructs.Group();
					group.name = groupName;
					group.groupContextExt = latestFieldContext.extendedContext.getGroup();
					chain.groups.put(group.name, group);

					LAStructs.Element element = new LAStructs.Element();
					element.name = latestFieldContext.extendedContext.getElementName();
					element.elementContextExt = latestFieldContext.extendedContext.getElement();
					group.elements.put(element.name, element);

					LAStructs.Field field = new LAStructs.Field();
					field.name = latestFieldContext.extendedContext.getFieldName();
					field.fieldContextExt = latestFieldContext.extendedContext.getField();
					element.fields.put(field.name, field);
				}
				else{
					LAStructs.Group group = chain.groups.get(groupName);
					String elementName = latestFieldContext.extendedContext.getElementName();
					if( group.elements.get(elementName) == null){
						LAStructs.Element element = new LAStructs.Element();
						element.name = elementName;
						element.elementContextExt = latestFieldContext.extendedContext.getElement();
						group.elements.put(element.name, element);
						LAStructs.Field field = new LAStructs.Field();
						field.name = latestFieldContext.extendedContext.getFieldName();
						field.fieldContextExt = latestFieldContext.extendedContext.getField();
						element.fields.put(field.name, field);
					}
					else{
						assert group.elements.size() >= 1 : "Cannot have two elements from the same group. Group = "+ groupName + " Element=" + elementName;
						LAStructs.Element element = group.elements.get(elementName);
						String fieldName = latestFieldContext.extendedContext.getFieldName();
						if (element.fields.get(fieldName) == null){
							LAStructs.Field field = new LAStructs.Field();
							field.name = latestFieldContext.extendedContext.getFieldName();
							field.fieldContextExt = latestFieldContext.extendedContext.getField();
							element.fields.put(field.name, field);
						}
						{
							assert true : "Duplicate field selection fieldName=" + fieldName;
						}
					}
				}
			}
		}

	}
	


}
