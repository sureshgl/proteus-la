parser grammar LAParser ;

options{tokenVocab=LALexer;}

@header{
package com.proteus.la.ANTLRv4;

import com.proteus.la.*;

}

start
locals [ StartContextExt extendedContext = null ]
: group_definition*  chain_definition*  isolatation_definition*  EOF 
|  select_definition*  isolate_definition*  EOF ;

isolate_definition
locals [ Isolate_definitionContextExt extendedContext = null ]
: isolate  isolate_variable_declaration_list ;

isolate
locals [ IsolateContextExt extendedContext = null ]
: ISOLATE ;

isolate_variable_declaration_list
locals [ Isolate_variable_declaration_listContextExt extendedContext = null ]
: isolate_variable_declaration (  isolate_variable_declaration  )* ;

isolate_variable_declaration
locals [ Isolate_variable_declarationContextExt extendedContext = null ]
: variable  variable_name  field_variable ;

isolatation_definition
locals [ Isolatation_definitionContextExt extendedContext = null ]
: isolate_addresses  isolate_variable_address_definition_list ;

isolate_variable_address_definition_list
locals [ Isolate_variable_address_definition_listContextExt extendedContext = null ]
: variable_address_definition (  variable_address_definition  )* ;

isolate_addresses
locals [ Isolate_addressesContextExt extendedContext = null ]
: ISOLATE_ADDRESSES ;

variable_address_definition
locals [ Variable_address_definitionContextExt extendedContext = null ]
: variable  variable_name  isolate_mask_address  isolate_mask_address_value  value_address  value_address_value  op_address  op_address_value ;

variable
locals [ VariableContextExt extendedContext = null ]
: VARIABLE ;

variable_name
locals [ Variable_indexContextExt extendedContext = null ]
: ID ;

isolate_mask_address
locals [ Isolate_mask_addressContextExt extendedContext = null ]
: MASK_ADDR ;

isolate_mask_address_value
locals [ Isolate_mask_address_valueContextExt extendedContext = null ]
: number ;

value_address
locals [ Value_addressContextExt extendedContext = null ]
: VAL_ADDR ;

value_address_value
locals [ Value_address_valueContextExt extendedContext = null ]
: number ;

op_address
locals [ Op_addressContextExt extendedContext = null ]
: OP_ADDR ;

op_address_value
locals [ Op_address_valueContextExt extendedContext = null ]
: number ;

select_definition
locals [ Select_definitionContextExt extendedContext = null ]
: SELECT  field_refrence_list ;

field_refrence_list
locals [ Field_refrence_listContextExt extendedContext = null ]
: field_reference (  field_reference  )* ;

field_reference
locals [ Field_referenceContextExt extendedContext = null ]
: FIELD  field_variable_list ;

field_variable_list
locals [ Field_variable_listContextExt extendedContext = null ]
: field_variable (  field_variable  )* ;

field_variable
locals [ Field_variableContextExt extendedContext = null ]
: chain_varible_name  DOT  group_member_name  DOT  element_member_name  DOT  field_member_name ;

chain_varible_name
locals [ Chain_varible_nameContextExt extendedContext = null ]
: ID ;

group_member_name
locals [ Group_member_nameContextExt extendedContext = null ]
: ID ;

element_member_name
locals [ Element_member_nameContextExt extendedContext = null ]
: ID ;

field_member_name
locals [ Field_member_nameContextExt extendedContext = null ]
: ID ;

chain_definition
locals [ Chain_definitionContextExt extendedContext = null ]
: CHAIN  chain_number_index  chain_name  chain_member_list ;

chain_name
locals [ Chain_nameContextExt extendedContext = null ]
: ID ;

chain_number_index
locals [ Chain_number_indexContextExt extendedContext = null ]
: number ;

chain_member_list
locals [ Chain_member_listContextExt extendedContext = null ]
: chain_member (  chain_member  )* ;

chain_member
locals [ Chain_memberContextExt extendedContext = null ]
:(  group_declaration  );

group_definition
locals [ Group_definitionContextExt extendedContext = null ]
: GROUP  group_name  group_member_list ;

group_name
locals [ Group_nameContextExt extendedContext = null ]
: ID ;

group_member_list
locals [ Group_member_listContextExt extendedContext = null ]
: group_member (  group_member  )* ;

group_member
locals [ Group_memberContextExt extendedContext = null ]
:(  element 
| enum_element  );

group_declaration
locals [ Group_declarationContextExt extendedContext = null ]
: GROUP  group_name  group_variable_name  select_address  shift_address ;

group_variable_name
locals [ Group_variable_nameContextExt extendedContext = null ]
: ID ;

select_address
locals [ Select_addressContextExt extendedContext = null ]
: SELECT_ADDR  number ;

shift_address
locals [ Shift_addressContextExt extendedContext = null ]
: SHIFT_ADDR  number ;

enum_element
locals [ Enum_elementContextExt extendedContext = null ]
: ENUM  enum_number_index  enum_name ;

enum_number_index
locals [ Enum_number_indexContextExt extendedContext = null ]
: number ;

enum_name
locals [ Enum_nameContextExt extendedContext = null ]
: ID ;

element
locals [ ElementContextExt extendedContext = null ]
: ELEMENT  element_number_index  element_name  field_list ;

element_name
locals [ Element_nameContextExt extendedContext = null ]
: ID ;

element_number_index
locals [ Element_number_indexContextExt extendedContext = null ]
: number ;

field_list
locals [ Field_listContextExt extendedContext = null ]
: field  field* ;

field
locals [ FieldContextExt extendedContext = null ]
: FIELD  field_name  field_range ;

field_name
locals [ Field_nameContextExt extendedContext = null ]
: ID ;

field_range
locals [ Field_rangeContextExt extendedContext = null ]
: LBRACK  stop_index  COLON  start_index  RBRACK ;

start_index
locals [ Start_indexContextExt extendedContext = null ]
: constant_expression ;

stop_index
locals [ Stop_indexContextExt extendedContext = null ]
: constant_expression ;

constant_expression
locals [ Constant_expressionContextExt extendedContext = null ]
: number #const_expr_only_primary
|  unary_operator  number #const_expr_unary_op
|  constant_expression  STARSTAR  constant_expression #const_expr_st_st
|  constant_expression  STAR  constant_expression #const_expr_mult
|  constant_expression  DIV  constant_expression #const_expr_div
|  constant_expression  MODULO  constant_expression #const_expr_modulo
|  constant_expression  PLUS  constant_expression #const_expr_add
|  constant_expression  MINUS  constant_expression #const_expr_sub
|  constant_expression  LSHIFT  constant_expression #const_expr_lshift
|  constant_expression  RSHIFT  constant_expression #const_expr_rshift
|  constant_expression  ALSHIFT  constant_expression #const_expr_alshift
|  constant_expression  ARSHIFT  constant_expression #const_expr_arshift
|  constant_expression  LT  constant_expression #const_expr_lt
|  constant_expression  GT  constant_expression #const_expr_gt
|  constant_expression  LE  constant_expression #const_expr_le
|  constant_expression  GE  constant_expression #const_expr_ge
|  constant_expression  EQUALS  constant_expression #const_expr_equal
|  constant_expression  NOT_EQUALS  constant_expression #const_expr_not_equal
|  constant_expression  AND  constant_expression #const_expr_and
|  constant_expression  XOR  constant_expression #const_expr_xor
|  constant_expression  XNOR  constant_expression #const_expr_xnor
|  constant_expression  XORN  constant_expression #const_expr_xorn
|  constant_expression  OR  constant_expression #const_expr_or
|  constant_expression  LAND  constant_expression #const_expr_land
|  constant_expression  LOR  constant_expression #const_expr_lor
|  constant_expression  QUATIONMARK  constant_expression  COLON  constant_expression #const_expr_conditional;

unary_operator
locals [ Unary_operatorContextExt extendedContext = null ]
: PLUS 
|  MINUS 
|  NOT 
|  COMPLIMENT 
|  AND 
|  NAND 
|  OR 
|  NOR 
|  XOR 
|  XORN 
|  XNOR ;

number
locals [ NumberContextExt extendedContext = null ]
: Hex_number 
|  Unsigned_number ;


