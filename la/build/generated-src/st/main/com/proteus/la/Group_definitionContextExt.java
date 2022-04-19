package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Group_definitionContextExt extends AbstractBaseExtendedContext{

	private ElementContextExt selectedElement;
	private Long shiftCount;
	private Boolean refered = false;

	public Group_definitionContextExt(Group_definitionContext ctx) {
		super("la", new LAParser(null), new LALexer(null),  ctx, new LAParserExtendedContextVisitor());
		localSymbolTable = new SymbolTable();
		selectedElement = null;
		shiftCount = -1L;
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Group_definitionContext getLatestContext(){
		return (Group_definitionContext)super.getLatestContext();
	}

	/*
	* Create a context for the given string  with extended context populated in that
	*/
	@Override
	public Group_definitionContext getContext(String str){
		return (Group_definitionContext)new LAParserPopulateExtendedContextVisitor().visit(((LAParser)getParser(str)).group_definition());
	}

	@Override
	public void setContext(ParserRuleContext ctx){
		if(ctx != null){
			if(ctx instanceof Group_definitionContext){
				addToContexts((Group_definitionContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "+Group_definitionContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	@Override
	public void PopulateSymbolTable(SymbolTable symbolTable)
	{
			super.PopulateSymbolTable(localSymbolTable);
			Group_nameContext group_nameContext =  getLatestContext().group_name();
			String groupName = group_nameContext.extendedContext.getName();
			String key = getLatestContext().GROUP().getText() + " " + groupName;
			symbolTable.put(key, this);
	}

	public Boolean isRefered(){
		return this.refered;
	}
	public void setSelectedElement(ElementContextExt element)
	{
		this.refered = true;
		this.selectedElement = element;
	}
	public ElementContextExt getSelectedElement(){
		return this.selectedElement;
	}

	public void setShiftCount(Long  shiftCount)
	{
		this.shiftCount = shiftCount;
	}
	
	public Long getShiftCount(){
		return this.shiftCount;
	}

	@Override
	public void processFieldReferences(){
		//Stop further processing on this branch- as that is no-op
		return;
	}

}
