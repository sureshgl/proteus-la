package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Field_variableContextExt extends AbstractBaseExtendedContext{

	public Field_variableContextExt(Field_variableContext ctx) {
		super("la", new LAParser(null), new LALexer(null), new LAParserExtendedContextVisitor());
		addToContexts(ctx);
		parent = ctx;
	}

  /*
   * Return the conext associated with this extened context
   */
	@Override
	public Field_variableContext getContext(){
		return (Field_variableContext)contexts.get(contexts.size()-1);
	}

  /*
   * Create a context for the given string  with extended context populated in that
   */
	@Override
	public ParserRuleContext getContext(String str){
		return ((LAParser)getParser(str)).field_variable();
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Field_variableContext){
				addToContexts((Field_variableContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Field_variableContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	public String getChainName(){
		return getContext().getText().split("\\.")[0];
	}

	public String getGroupName(){
		return getContext().getText().split("\\.")[1];
	}

	public String getElementName(){
		return getContext().getText().split("\\.")[2];
	}

	public String getFieldName(){
		return getContext().getText().split("\\.")[3];
	}

	public Chain_definitionContextExt getChain(){
		String chainName = getChainName();
		return(Chain_definitionContextExt) getSymbol(chainName);
	}

	public Group_definitionContextExt getGroup(){
		String groupName = getChainName() + "." + getGroupName();
		return (Group_definitionContextExt)getSymbol(groupName);
	}

	public ElementContextExt getElement(){
		String elementName = getChainName() + "." + getGroupName() + "." + getElementName();
		return (ElementContextExt)getSymbol(elementName);
	}

	public FieldContextExt getField(){
		String fieldName = getContext().getText();
		return (FieldContextExt)getSymbol(fieldName);
	}

}