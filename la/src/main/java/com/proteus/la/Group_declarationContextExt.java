package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Group_declarationContextExt extends AbstractBaseExtendedContext {

	private Group_definitionContextExt group_definitionContextExt;

	public Group_declarationContextExt(Group_declarationContext ctx) {
		super("la", new LAParser(null), new LALexer(null), ctx, new LAParserExtendedContextVisitor());
		group_definitionContextExt = null;
		localSymbolTable = new SymbolTable();
	}

	/*
	 * Create a context for the given string with extended context populated in that
	 */
	@Override
	public Group_declarationContext getLatestContext() {
		return (Group_declarationContext) super.getLatestContext();
	}

	/*
	 * Create a context for the given string with extended context populated in that
	 */
	@Override
	public Group_declarationContext getContext(String str) {
		return (Group_declarationContext) new LAParserPopulateExtendedContextVisitor()
				.visit(((LAParser) getParser(str)).group_declaration());
	}

	@Override
	public void setContext(ParserRuleContext ctx) {
		if (ctx != null) {
			if (ctx instanceof Group_declarationContext) {
				addToContexts((Group_declarationContext) ctx);
			} else {
				throw new ClassCastException(
						ctx.getClass().getSimpleName() + " cannot be cased to " + Group_declarationContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	private String getGroupName() {
		Group_variable_nameContext group_variable_nameContext = getLatestContext().group_variable_name();
		return group_variable_nameContext.extendedContext.getName();
	}

	@Override
	public void PopulateSymbolTable(SymbolTable symbolTable) {
		String groupName = getGroupName();
		symbolTable.put(groupName, this);
	}

	// GROUP + " " + group_name
	private String getTypeName() {
		Group_nameContext group_nameContext = getLatestContext().group_name();
		return getLatestContext().GROUP().getText() + " " + group_nameContext.extendedContext.getName();
	}

	@Override
	public AbstractBaseExtendedContext lookIn(String symbol) {
		return this.group_definitionContextExt.lookIn(symbol);
	}

	@Override
	public void Initialize() throws Exception {
		super.Initialize();
		// Keep a copy of Group Definition.
		// Every group declaration should have their Group definition.
		String typeName = getTypeName();
		Group_definitionContextExt group_definitionContextExt = (Group_definitionContextExt) getSymbol(typeName);
		assert group_definitionContextExt != null
				: typeName + "Missing the definition, should be declared before its usage";
		String groupTypeDefinitionStr = group_definitionContextExt.getFormattedText();
		System.out.println(groupTypeDefinitionStr);
		Group_definitionContext group_definitionContext = (Group_definitionContext) group_definitionContextExt
				.getContext(groupTypeDefinitionStr);
		this.group_definitionContextExt = group_definitionContext.extendedContext;
		this.group_definitionContextExt.PopulateSymbolTable(localSymbolTable);
		this.group_definitionContextExt.Initialize();
	}

	public void setSelectedElement(ElementContextExt element) {
		group_definitionContextExt.setSelectedElement(element);
	}

	public ElementContextExt getSelectedElement() {
		return group_definitionContextExt.getSelectedElement();
	}

	public void setShiftCount(Long shiftCount) {
		group_definitionContextExt.setShiftCount(shiftCount);
	}

	public Long getShiftCount() {
		return group_definitionContextExt.getShiftCount();
	}

	public void setMask(Long mask) {
		group_definitionContextExt.setMask(mask);
	}

	public Long getMask() {
		return group_definitionContextExt.getMask();
	}

	public void setShiftedMask(Long shiftedMask){
		group_definitionContextExt.setShiftedMask(shiftedMask);
	}

	public Long getShiftedMask(){
		return group_definitionContextExt.getShiftedMask();
	}

	@Override
	public void printConfiguration(StringBuilder sb) {
		if (group_definitionContextExt.isRefered()) {
			sb.append("GroupName:" + getGroupName() + "\t");
			sb.append("Select Adrr:" + getSelectedElement().getIndex() + "\t");
			sb.append("ShiftCount:" + getShiftCount() + "\n");
			sb.append("Mask:" + Long.toBinaryString(getMask()) + "\n");
			sb.append("ShiftedMask:" + Long.toBinaryString(getShiftedMask()) + "\n");
		}
	}

}
