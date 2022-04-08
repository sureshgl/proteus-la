package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.framework.app.*;
import com.proteus.framework.IExtendedContextVisitor;
import com.proteus.la.ANTLRv4.LAParserBaseVisitor;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.ANTLRv4.LAParser.*;

public class LAParserExtendedContextVisitor extends LAParserBaseVisitor<AbstractBaseExtendedContext> implements IExtendedContextVisitor {
	@Override 
	public AbstractBaseExtendedContext visitStart(LAParser.StartContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitIsolate_variable_definition(LAParser.Isolate_variable_definitionContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitIsolate_addresses(LAParser.Isolate_addressesContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitVariable_declaration(LAParser.Variable_declarationContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitVariable(LAParser.VariableContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitVariable_name(LAParser.Variable_nameContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitIsolate_mask_address(LAParser.Isolate_mask_addressContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitIsolate_mask_address_value(LAParser.Isolate_mask_address_valueContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitValue_address(LAParser.Value_addressContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitValue_address_value(LAParser.Value_address_valueContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitOp_address(LAParser.Op_addressContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitOp_address_value(LAParser.Op_address_valueContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitSelect_definition(LAParser.Select_definitionContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField_refrence_list(LAParser.Field_refrence_listContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField_reference(LAParser.Field_referenceContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField_variable_list(LAParser.Field_variable_listContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField_variable(LAParser.Field_variableContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitChain_varible_name(LAParser.Chain_varible_nameContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitGroup_member_name(LAParser.Group_member_nameContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitElement_member_name(LAParser.Element_member_nameContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField_member_name(LAParser.Field_member_nameContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitChain_definition(LAParser.Chain_definitionContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitChain_name(LAParser.Chain_nameContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitChain_number_index(LAParser.Chain_number_indexContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitChain_member_list(LAParser.Chain_member_listContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitChain_member(LAParser.Chain_memberContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitGroup_definition(LAParser.Group_definitionContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitGroup_name(LAParser.Group_nameContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitGroup_member_list(LAParser.Group_member_listContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitGroup_member(LAParser.Group_memberContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitGroup_declaration(LAParser.Group_declarationContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitGroup_variable_name(LAParser.Group_variable_nameContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitSelect_address(LAParser.Select_addressContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitShift_address(LAParser.Shift_addressContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitEnum_element(LAParser.Enum_elementContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitEnum_number_index(LAParser.Enum_number_indexContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitEnum_name(LAParser.Enum_nameContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitElement(LAParser.ElementContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitElement_name(LAParser.Element_nameContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitElement_number_index(LAParser.Element_number_indexContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField_list(LAParser.Field_listContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField(LAParser.FieldContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField_name(LAParser.Field_nameContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField_range(LAParser.Field_rangeContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitUnary_operator(LAParser.Unary_operatorContext ctx) {
		return ctx.extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitNumber(LAParser.NumberContext ctx) {
		return ctx.extendedContext;
	}

}