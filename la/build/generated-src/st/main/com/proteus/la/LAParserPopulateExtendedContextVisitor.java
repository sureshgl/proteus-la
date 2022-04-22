package com.proteus.la;

import org.antlr.v4.runtime.ParserRuleContext;
import com.proteus.la.ANTLRv4.LAParserBaseVisitor;
import com.proteus.la.ANTLRv4.LAParser;

public class LAParserPopulateExtendedContextVisitor extends LAParserBaseVisitor<ParserRuleContext> {
	@Override 
	public ParserRuleContext visitStart(LAParser.StartContext ctx) {
		super.visitStart(ctx);
		ctx.extendedContext = new StartContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitIsolate_definition(LAParser.Isolate_definitionContext ctx) {
		super.visitIsolate_definition(ctx);
		ctx.extendedContext = new Isolate_definitionContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitIsolate(LAParser.IsolateContext ctx) {
		super.visitIsolate(ctx);
		ctx.extendedContext = new IsolateContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitIsolate_variable_declaration_list(LAParser.Isolate_variable_declaration_listContext ctx) {
		super.visitIsolate_variable_declaration_list(ctx);
		ctx.extendedContext = new Isolate_variable_declaration_listContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitIsolate_variable_declaration(LAParser.Isolate_variable_declarationContext ctx) {
		super.visitIsolate_variable_declaration(ctx);
		ctx.extendedContext = new Isolate_variable_declarationContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitIsolatation_definition(LAParser.Isolatation_definitionContext ctx) {
		super.visitIsolatation_definition(ctx);
		ctx.extendedContext = new Isolatation_definitionContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitIsolate_variable_address_definition_list(LAParser.Isolate_variable_address_definition_listContext ctx) {
		super.visitIsolate_variable_address_definition_list(ctx);
		ctx.extendedContext = new Isolate_variable_address_definition_listContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitIsolate_addresses(LAParser.Isolate_addressesContext ctx) {
		super.visitIsolate_addresses(ctx);
		ctx.extendedContext = new Isolate_addressesContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitVariable_address_definition(LAParser.Variable_address_definitionContext ctx) {
		super.visitVariable_address_definition(ctx);
		ctx.extendedContext = new Variable_address_definitionContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitVariable(LAParser.VariableContext ctx) {
		super.visitVariable(ctx);
		ctx.extendedContext = new VariableContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitVariable_name(LAParser.Variable_nameContext ctx) {
		super.visitVariable_name(ctx);
		ctx.extendedContext = new Variable_nameContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitIsolate_mask_address(LAParser.Isolate_mask_addressContext ctx) {
		super.visitIsolate_mask_address(ctx);
		ctx.extendedContext = new Isolate_mask_addressContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitIsolate_mask_address_value(LAParser.Isolate_mask_address_valueContext ctx) {
		super.visitIsolate_mask_address_value(ctx);
		ctx.extendedContext = new Isolate_mask_address_valueContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitValue_address(LAParser.Value_addressContext ctx) {
		super.visitValue_address(ctx);
		ctx.extendedContext = new Value_addressContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitValue_address_value(LAParser.Value_address_valueContext ctx) {
		super.visitValue_address_value(ctx);
		ctx.extendedContext = new Value_address_valueContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitOp_address(LAParser.Op_addressContext ctx) {
		super.visitOp_address(ctx);
		ctx.extendedContext = new Op_addressContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitOp_address_value(LAParser.Op_address_valueContext ctx) {
		super.visitOp_address_value(ctx);
		ctx.extendedContext = new Op_address_valueContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitSelect_definition(LAParser.Select_definitionContext ctx) {
		super.visitSelect_definition(ctx);
		ctx.extendedContext = new Select_definitionContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitField_refrence_list(LAParser.Field_refrence_listContext ctx) {
		super.visitField_refrence_list(ctx);
		ctx.extendedContext = new Field_refrence_listContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitField_reference(LAParser.Field_referenceContext ctx) {
		super.visitField_reference(ctx);
		ctx.extendedContext = new Field_referenceContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitField_variable_list(LAParser.Field_variable_listContext ctx) {
		super.visitField_variable_list(ctx);
		ctx.extendedContext = new Field_variable_listContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitField_variable(LAParser.Field_variableContext ctx) {
		super.visitField_variable(ctx);
		ctx.extendedContext = new Field_variableContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitChain_varible_name(LAParser.Chain_varible_nameContext ctx) {
		super.visitChain_varible_name(ctx);
		ctx.extendedContext = new Chain_varible_nameContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitGroup_member_name(LAParser.Group_member_nameContext ctx) {
		super.visitGroup_member_name(ctx);
		ctx.extendedContext = new Group_member_nameContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitElement_member_name(LAParser.Element_member_nameContext ctx) {
		super.visitElement_member_name(ctx);
		ctx.extendedContext = new Element_member_nameContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitField_member_name(LAParser.Field_member_nameContext ctx) {
		super.visitField_member_name(ctx);
		ctx.extendedContext = new Field_member_nameContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitChain_definition(LAParser.Chain_definitionContext ctx) {
		super.visitChain_definition(ctx);
		ctx.extendedContext = new Chain_definitionContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitChain_name(LAParser.Chain_nameContext ctx) {
		super.visitChain_name(ctx);
		ctx.extendedContext = new Chain_nameContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitChain_number_index(LAParser.Chain_number_indexContext ctx) {
		super.visitChain_number_index(ctx);
		ctx.extendedContext = new Chain_number_indexContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitChain_member_list(LAParser.Chain_member_listContext ctx) {
		super.visitChain_member_list(ctx);
		ctx.extendedContext = new Chain_member_listContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitChain_member(LAParser.Chain_memberContext ctx) {
		super.visitChain_member(ctx);
		ctx.extendedContext = new Chain_memberContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitGroup_definition(LAParser.Group_definitionContext ctx) {
		super.visitGroup_definition(ctx);
		ctx.extendedContext = new Group_definitionContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitGroup_name(LAParser.Group_nameContext ctx) {
		super.visitGroup_name(ctx);
		ctx.extendedContext = new Group_nameContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitGroup_member_list(LAParser.Group_member_listContext ctx) {
		super.visitGroup_member_list(ctx);
		ctx.extendedContext = new Group_member_listContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitGroup_member(LAParser.Group_memberContext ctx) {
		super.visitGroup_member(ctx);
		ctx.extendedContext = new Group_memberContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitGroup_declaration(LAParser.Group_declarationContext ctx) {
		super.visitGroup_declaration(ctx);
		ctx.extendedContext = new Group_declarationContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitGroup_variable_name(LAParser.Group_variable_nameContext ctx) {
		super.visitGroup_variable_name(ctx);
		ctx.extendedContext = new Group_variable_nameContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitSelect_address(LAParser.Select_addressContext ctx) {
		super.visitSelect_address(ctx);
		ctx.extendedContext = new Select_addressContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitShift_address(LAParser.Shift_addressContext ctx) {
		super.visitShift_address(ctx);
		ctx.extendedContext = new Shift_addressContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitEnum_element(LAParser.Enum_elementContext ctx) {
		super.visitEnum_element(ctx);
		ctx.extendedContext = new Enum_elementContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitEnum_number_index(LAParser.Enum_number_indexContext ctx) {
		super.visitEnum_number_index(ctx);
		ctx.extendedContext = new Enum_number_indexContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitEnum_name(LAParser.Enum_nameContext ctx) {
		super.visitEnum_name(ctx);
		ctx.extendedContext = new Enum_nameContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitElement(LAParser.ElementContext ctx) {
		super.visitElement(ctx);
		ctx.extendedContext = new ElementContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitElement_name(LAParser.Element_nameContext ctx) {
		super.visitElement_name(ctx);
		ctx.extendedContext = new Element_nameContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitElement_number_index(LAParser.Element_number_indexContext ctx) {
		super.visitElement_number_index(ctx);
		ctx.extendedContext = new Element_number_indexContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitField_list(LAParser.Field_listContext ctx) {
		super.visitField_list(ctx);
		ctx.extendedContext = new Field_listContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitField(LAParser.FieldContext ctx) {
		super.visitField(ctx);
		ctx.extendedContext = new FieldContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitField_name(LAParser.Field_nameContext ctx) {
		super.visitField_name(ctx);
		ctx.extendedContext = new Field_nameContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitField_range(LAParser.Field_rangeContext ctx) {
		super.visitField_range(ctx);
		ctx.extendedContext = new Field_rangeContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitStart_index(LAParser.Start_indexContext ctx) {
		super.visitStart_index(ctx);
		ctx.extendedContext = new Start_indexContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitStop_index(LAParser.Stop_indexContext ctx) {
		super.visitStop_index(ctx);
		ctx.extendedContext = new Stop_indexContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitUnary_operator(LAParser.Unary_operatorContext ctx) {
		super.visitUnary_operator(ctx);
		ctx.extendedContext = new Unary_operatorContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitNumber(LAParser.NumberContext ctx) {
		super.visitNumber(ctx);
		ctx.extendedContext = new NumberContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_only_primary(LAParser.Const_expr_only_primaryContext ctx) {
		super.visitConst_expr_only_primary(ctx);
		ctx.extendedContext = new Const_expr_only_primaryContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_unary_op(LAParser.Const_expr_unary_opContext ctx) {
		super.visitConst_expr_unary_op(ctx);
		ctx.extendedContext = new Const_expr_unary_opContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_st_st(LAParser.Const_expr_st_stContext ctx) {
		super.visitConst_expr_st_st(ctx);
		ctx.extendedContext = new Const_expr_st_stContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_mult(LAParser.Const_expr_multContext ctx) {
		super.visitConst_expr_mult(ctx);
		ctx.extendedContext = new Const_expr_multContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_div(LAParser.Const_expr_divContext ctx) {
		super.visitConst_expr_div(ctx);
		ctx.extendedContext = new Const_expr_divContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_modulo(LAParser.Const_expr_moduloContext ctx) {
		super.visitConst_expr_modulo(ctx);
		ctx.extendedContext = new Const_expr_moduloContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_add(LAParser.Const_expr_addContext ctx) {
		super.visitConst_expr_add(ctx);
		ctx.extendedContext = new Const_expr_addContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_sub(LAParser.Const_expr_subContext ctx) {
		super.visitConst_expr_sub(ctx);
		ctx.extendedContext = new Const_expr_subContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_lshift(LAParser.Const_expr_lshiftContext ctx) {
		super.visitConst_expr_lshift(ctx);
		ctx.extendedContext = new Const_expr_lshiftContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_rshift(LAParser.Const_expr_rshiftContext ctx) {
		super.visitConst_expr_rshift(ctx);
		ctx.extendedContext = new Const_expr_rshiftContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_alshift(LAParser.Const_expr_alshiftContext ctx) {
		super.visitConst_expr_alshift(ctx);
		ctx.extendedContext = new Const_expr_alshiftContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_arshift(LAParser.Const_expr_arshiftContext ctx) {
		super.visitConst_expr_arshift(ctx);
		ctx.extendedContext = new Const_expr_arshiftContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_lt(LAParser.Const_expr_ltContext ctx) {
		super.visitConst_expr_lt(ctx);
		ctx.extendedContext = new Const_expr_ltContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_gt(LAParser.Const_expr_gtContext ctx) {
		super.visitConst_expr_gt(ctx);
		ctx.extendedContext = new Const_expr_gtContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_le(LAParser.Const_expr_leContext ctx) {
		super.visitConst_expr_le(ctx);
		ctx.extendedContext = new Const_expr_leContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_ge(LAParser.Const_expr_geContext ctx) {
		super.visitConst_expr_ge(ctx);
		ctx.extendedContext = new Const_expr_geContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_equal(LAParser.Const_expr_equalContext ctx) {
		super.visitConst_expr_equal(ctx);
		ctx.extendedContext = new Const_expr_equalContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_not_equal(LAParser.Const_expr_not_equalContext ctx) {
		super.visitConst_expr_not_equal(ctx);
		ctx.extendedContext = new Const_expr_not_equalContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_and(LAParser.Const_expr_andContext ctx) {
		super.visitConst_expr_and(ctx);
		ctx.extendedContext = new Const_expr_andContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_xor(LAParser.Const_expr_xorContext ctx) {
		super.visitConst_expr_xor(ctx);
		ctx.extendedContext = new Const_expr_xorContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_xnor(LAParser.Const_expr_xnorContext ctx) {
		super.visitConst_expr_xnor(ctx);
		ctx.extendedContext = new Const_expr_xnorContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_xorn(LAParser.Const_expr_xornContext ctx) {
		super.visitConst_expr_xorn(ctx);
		ctx.extendedContext = new Const_expr_xornContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_or(LAParser.Const_expr_orContext ctx) {
		super.visitConst_expr_or(ctx);
		ctx.extendedContext = new Const_expr_orContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_land(LAParser.Const_expr_landContext ctx) {
		super.visitConst_expr_land(ctx);
		ctx.extendedContext = new Const_expr_landContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_lor(LAParser.Const_expr_lorContext ctx) {
		super.visitConst_expr_lor(ctx);
		ctx.extendedContext = new Const_expr_lorContextExt(ctx);
		return ctx;
	}
	@Override 
	public ParserRuleContext visitConst_expr_conditional(LAParser.Const_expr_conditionalContext ctx) {
		super.visitConst_expr_conditional(ctx);
		ctx.extendedContext = new Const_expr_conditionalContextExt(ctx);
		return ctx;
	}

}