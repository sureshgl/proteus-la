package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;

import com.proteus.framework.app.*;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LALexer;
import com.proteus.la.ANTLRv4.LAParser.*;

public class Isolate_variable_declarationContextExt extends AbstractBaseExtendedContext {
	private Variable_address_definitionContextExt variable_address_definitionContextExt;

	public Isolate_variable_declarationContextExt(Isolate_variable_declarationContext ctx) {
		super("la", new LAParser(null), new LALexer(null), ctx, new LAParserExtendedContextVisitor());
		variable_address_definitionContextExt = null;
	}

	/*
	 * Create a context for the given string with extended context populated in that
	 */
	@Override
	public Isolate_variable_declarationContext getLatestContext() {
		return (Isolate_variable_declarationContext) super.getLatestContext();
	}

	/*
	 * Create a context for the given string with extended context populated in that
	 */
	@Override
	public Isolate_variable_declarationContext getContext(String str) {
		return (Isolate_variable_declarationContext) new LAParserPopulateExtendedContextVisitor()
				.visit(((LAParser) getParser(str)).isolate_variable_declaration());
	}

	@Override
	public void setContext(ParserRuleContext ctx) {
		if (ctx != null) {
			if (ctx instanceof Isolate_variable_declarationContext) {
				addToContexts((Isolate_variable_declarationContext) ctx);
			} else {
				throw new ClassCastException(ctx.getClass().getSimpleName() + " cannot be cased to "
						+ Isolate_variable_declarationContext.class.getName());
			}
		} else {
			addToContexts(null);
		}
	}

	private String getTypeName() {
		return getLatestContext().variable().getText() + " " + getLatestContext().variable_name().extendedContext.getName();
	}

	/*
	 * Variable_address_definitionContextExt has the variable address data.
	 * 
	 */

	@Override
	public void Initialize() throws Exception {
		super.Initialize();
		// Keep a copy of Variable Definition.
		// Every Veriable declaration should have their definition.
		String typeName = getTypeName();
		this.variable_address_definitionContextExt = (Variable_address_definitionContextExt) getSymbol(typeName);
		assert this.variable_address_definitionContextExt != null
				: typeName + "Missing the definition, should be declared before its usage";
	}

	/*
	 * From the upstream data, we need to extract the values of the specified fields
	 * in to specific registers
	 * variable v1 <chain>.<group>.<element>.<field>
	 * extract the value of <chain>.<group>.<element>.<field> from upstream data
	 * register and assign that to v1.
	 */
	public void evaluateIsolateVariables(Long upstreamValue) {
		Field_variableContextExt field_variableContextExt = getLatestContext().field_variable().extendedContext;
		Long fieldMask = field_variableContextExt.getMask();
		Long shiftCount = field_variableContextExt.getShiftCount();
		fieldMask = Utils.circularRightShift(fieldMask, shiftCount); // isolate mask address
		Long fieldValue = upstreamValue & ~fieldMask; // isolate field value.
		this.variable_address_definitionContextExt.setFieldMask(fieldMask);
		this.variable_address_definitionContextExt.setFieldValue(fieldValue);
	}
}