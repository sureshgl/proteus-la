package com.proteus.la;

import com.proteus.framework.app.*;
import com.proteus.framework.IExtendedContextVisitor;
import com.proteus.la.ANTLRv4.LAParserBaseVisitor;
import com.proteus.la.ANTLRv4.LAParser;
import com.proteus.la.*;

public class LAParserExtendedContextVisitor extends LAParserBaseVisitor<AbstractBaseExtendedContext> implements IExtendedContextVisitor {
	@Override 
	public AbstractBaseExtendedContext visitStart(LAParser.StartContext ctx) {
		return ((StartContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitIsolate_definition(LAParser.Isolate_definitionContext ctx) {
		return ((Isolate_definitionContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitIsolate(LAParser.IsolateContext ctx) {
		return ((IsolateContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitIsolate_variable_declaration_list(LAParser.Isolate_variable_declaration_listContext ctx) {
		return ((Isolate_variable_declaration_listContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitIsolate_variable_declaration(LAParser.Isolate_variable_declarationContext ctx) {
		return ((Isolate_variable_declarationContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitIsolatation_definition(LAParser.Isolatation_definitionContext ctx) {
		return ((Isolatation_definitionContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitIsolate_variable_address_definition_list(LAParser.Isolate_variable_address_definition_listContext ctx) {
		return ((Isolate_variable_address_definition_listContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitIsolate_addresses(LAParser.Isolate_addressesContext ctx) {
		return ((Isolate_addressesContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitVariable_address_definition(LAParser.Variable_address_definitionContext ctx) {
		return ((Variable_address_definitionContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitVariable(LAParser.VariableContext ctx) {
		return ((VariableContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitVariable_name(LAParser.Variable_nameContext ctx) {
		return ((Variable_nameContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitIsolate_mask_address(LAParser.Isolate_mask_addressContext ctx) {
		return ((Isolate_mask_addressContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitIsolate_mask_address_value(LAParser.Isolate_mask_address_valueContext ctx) {
		return ((Isolate_mask_address_valueContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitValue_address(LAParser.Value_addressContext ctx) {
		return ((Value_addressContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitValue_address_value(LAParser.Value_address_valueContext ctx) {
		return ((Value_address_valueContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitOp_address(LAParser.Op_addressContext ctx) {
		return ((Op_addressContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitOp_address_value(LAParser.Op_address_valueContext ctx) {
		return ((Op_address_valueContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitSelect_definition(LAParser.Select_definitionContext ctx) {
		return ((Select_definitionContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField_refrence_list(LAParser.Field_refrence_listContext ctx) {
		return ((Field_refrence_listContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField_reference(LAParser.Field_referenceContext ctx) {
		return ((Field_referenceContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField_variable_list(LAParser.Field_variable_listContext ctx) {
		return ((Field_variable_listContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField_variable(LAParser.Field_variableContext ctx) {
		return ((Field_variableContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitChain_varible_name(LAParser.Chain_varible_nameContext ctx) {
		return ((Chain_varible_nameContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitGroup_member_name(LAParser.Group_member_nameContext ctx) {
		return ((Group_member_nameContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitElement_member_name(LAParser.Element_member_nameContext ctx) {
		return ((Element_member_nameContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField_member_name(LAParser.Field_member_nameContext ctx) {
		return ((Field_member_nameContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitChain_definition(LAParser.Chain_definitionContext ctx) {
		return ((Chain_definitionContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitChain_name(LAParser.Chain_nameContext ctx) {
		return ((Chain_nameContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitChain_number_index(LAParser.Chain_number_indexContext ctx) {
		return ((Chain_number_indexContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitChain_member_list(LAParser.Chain_member_listContext ctx) {
		return ((Chain_member_listContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitChain_member(LAParser.Chain_memberContext ctx) {
		return ((Chain_memberContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitGroup_definition(LAParser.Group_definitionContext ctx) {
		return ((Group_definitionContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitGroup_name(LAParser.Group_nameContext ctx) {
		return ((Group_nameContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitGroup_member_list(LAParser.Group_member_listContext ctx) {
		return ((Group_member_listContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitGroup_member(LAParser.Group_memberContext ctx) {
		return ((Group_memberContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitGroup_declaration(LAParser.Group_declarationContext ctx) {
		return ((Group_declarationContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitGroup_variable_name(LAParser.Group_variable_nameContext ctx) {
		return ((Group_variable_nameContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitSelect_address(LAParser.Select_addressContext ctx) {
		return ((Select_addressContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitShift_address(LAParser.Shift_addressContext ctx) {
		return ((Shift_addressContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitEnum_element(LAParser.Enum_elementContext ctx) {
		return ((Enum_elementContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitEnum_number_index(LAParser.Enum_number_indexContext ctx) {
		return ((Enum_number_indexContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitEnum_name(LAParser.Enum_nameContext ctx) {
		return ((Enum_nameContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitElement(LAParser.ElementContext ctx) {
		return ((ElementContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitElement_name(LAParser.Element_nameContext ctx) {
		return ((Element_nameContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitElement_number_index(LAParser.Element_number_indexContext ctx) {
		return ((Element_number_indexContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField_list(LAParser.Field_listContext ctx) {
		return ((Field_listContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField(LAParser.FieldContext ctx) {
		return ((FieldContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField_name(LAParser.Field_nameContext ctx) {
		return ((Field_nameContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitField_range(LAParser.Field_rangeContext ctx) {
		return ((Field_rangeContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitStart_index(LAParser.Start_indexContext ctx) {
		return ((Start_indexContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitStop_index(LAParser.Stop_indexContext ctx) {
		return ((Stop_indexContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitUnary_operator(LAParser.Unary_operatorContext ctx) {
		return ((Unary_operatorContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitNumber(LAParser.NumberContext ctx) {
		return ((NumberContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_only_primary(LAParser.Const_expr_only_primaryContext ctx) {
		return ((Const_expr_only_primaryContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_unary_op(LAParser.Const_expr_unary_opContext ctx) {
		return ((Const_expr_unary_opContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_st_st(LAParser.Const_expr_st_stContext ctx) {
		return ((Const_expr_st_stContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_mult(LAParser.Const_expr_multContext ctx) {
		return ((Const_expr_multContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_div(LAParser.Const_expr_divContext ctx) {
		return ((Const_expr_divContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_modulo(LAParser.Const_expr_moduloContext ctx) {
		return ((Const_expr_moduloContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_add(LAParser.Const_expr_addContext ctx) {
		return ((Const_expr_addContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_sub(LAParser.Const_expr_subContext ctx) {
		return ((Const_expr_subContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_lshift(LAParser.Const_expr_lshiftContext ctx) {
		return ((Const_expr_lshiftContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_rshift(LAParser.Const_expr_rshiftContext ctx) {
		return ((Const_expr_rshiftContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_alshift(LAParser.Const_expr_alshiftContext ctx) {
		return ((Const_expr_alshiftContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_arshift(LAParser.Const_expr_arshiftContext ctx) {
		return ((Const_expr_arshiftContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_lt(LAParser.Const_expr_ltContext ctx) {
		return ((Const_expr_ltContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_gt(LAParser.Const_expr_gtContext ctx) {
		return ((Const_expr_gtContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_le(LAParser.Const_expr_leContext ctx) {
		return ((Const_expr_leContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_ge(LAParser.Const_expr_geContext ctx) {
		return ((Const_expr_geContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_equal(LAParser.Const_expr_equalContext ctx) {
		return ((Const_expr_equalContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_not_equal(LAParser.Const_expr_not_equalContext ctx) {
		return ((Const_expr_not_equalContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_and(LAParser.Const_expr_andContext ctx) {
		return ((Const_expr_andContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_xor(LAParser.Const_expr_xorContext ctx) {
		return ((Const_expr_xorContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_xnor(LAParser.Const_expr_xnorContext ctx) {
		return ((Const_expr_xnorContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_xorn(LAParser.Const_expr_xornContext ctx) {
		return ((Const_expr_xornContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_or(LAParser.Const_expr_orContext ctx) {
		return ((Const_expr_orContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_land(LAParser.Const_expr_landContext ctx) {
		return ((Const_expr_landContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_lor(LAParser.Const_expr_lorContext ctx) {
		return ((Const_expr_lorContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}
	@Override 
	public AbstractBaseExtendedContext visitConst_expr_conditional(LAParser.Const_expr_conditionalContext ctx) {
		return ((Const_expr_conditionalContextExt)ctx.extendedContext).getLatestContext().extendedContext;
	}

}