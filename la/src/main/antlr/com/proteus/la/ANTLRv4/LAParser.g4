parser grammar LAParser ;

options{tokenVocab=LALexer;}

@header{
package com.proteus.la.ANTLRv4;

import com.proteus.la.*;

}

start
locals [ StartContextExt extendedContext = new StartContextExt(this) ]
: group_definition*  chain_definition*  isolate_variable_definition*  EOF 
|  select_definition*  EOF ;

isolate_variable_definition
locals [ Isolate_variable_definitionContextExt extendedContext = new Isolate_variable_definitionContextExt(this) ]
: isolate_addresses  variable_declaration (  variable_declaration  )+ ;

isolate_addresses
locals [ Isolate_addressesContextExt extendedContext = new Isolate_addressesContextExt(this) ]
: ISOLATE_ADDRESSES ;

variable_declaration
locals [ Variable_declarationContextExt extendedContext = new Variable_declarationContextExt(this) ]
: variable  variable_name  isolate_mask_address  isolate_mask_address_value  value_address  value_address_value  op_address  op_address_value ;

variable
locals [ VariableContextExt extendedContext = new VariableContextExt(this) ]
: VARIABLE ;

variable_name
locals [ Variable_nameContextExt extendedContext = new Variable_nameContextExt(this) ]
: ID ;

isolate_mask_address
locals [ Isolate_mask_addressContextExt extendedContext = new Isolate_mask_addressContextExt(this) ]
: MASK_ADDR ;

isolate_mask_address_value
locals [ Isolate_mask_address_valueContextExt extendedContext = new Isolate_mask_address_valueContextExt(this) ]
: number ;

value_address
locals [ Value_addressContextExt extendedContext = new Value_addressContextExt(this) ]
: VAL_ADDR ;

value_address_value
locals [ Value_address_valueContextExt extendedContext = new Value_address_valueContextExt(this) ]
: number ;

op_address
locals [ Op_addressContextExt extendedContext = new Op_addressContextExt(this) ]
: OP_ADDR ;

op_address_value
locals [ Op_address_valueContextExt extendedContext = new Op_address_valueContextExt(this) ]
: number ;

select_definition
locals [ Select_definitionContextExt extendedContext = new Select_definitionContextExt(this) ]
: SELECT  field_refrence_list ;

field_refrence_list
locals [ Field_refrence_listContextExt extendedContext = new Field_refrence_listContextExt(this) ]
: field_reference (  field_reference  )* ;

field_reference
locals [ Field_referenceContextExt extendedContext = new Field_referenceContextExt(this) ]
: FIELD  field_variable_list ;

field_variable_list
locals [ Field_variable_listContextExt extendedContext = new Field_variable_listContextExt(this) ]
: field_variable (  field_variable  )* ;

field_variable
locals [ Field_variableContextExt extendedContext = new Field_variableContextExt(this) ]
: chain_varible_name  DOT  group_member_name  DOT  element_member_name  DOT  field_member_name ;

chain_varible_name
locals [ Chain_varible_nameContextExt extendedContext = new Chain_varible_nameContextExt(this) ]
: ID ;

group_member_name
locals [ Group_member_nameContextExt extendedContext = new Group_member_nameContextExt(this) ]
: ID ;

element_member_name
locals [ Element_member_nameContextExt extendedContext = new Element_member_nameContextExt(this) ]
: ID ;

field_member_name
locals [ Field_member_nameContextExt extendedContext = new Field_member_nameContextExt(this) ]
: ID ;

chain_definition
locals [ Chain_definitionContextExt extendedContext = new Chain_definitionContextExt(this) ]
: CHAIN  chain_number_index  chain_name  chain_member_list ;

chain_name
locals [ Chain_nameContextExt extendedContext = new Chain_nameContextExt(this) ]
: ID ;

chain_number_index
locals [ Chain_number_indexContextExt extendedContext = new Chain_number_indexContextExt(this) ]
: number ;

chain_member_list
locals [ Chain_member_listContextExt extendedContext = new Chain_member_listContextExt(this) ]
: chain_member (  chain_member  )* ;

chain_member
locals [ Chain_memberContextExt extendedContext = new Chain_memberContextExt(this) ]
:(  group_declaration  );

group_definition
locals [ Group_definitionContextExt extendedContext = new Group_definitionContextExt(this) ]
: GROUP  group_name  group_member_list ;

group_name
locals [ Group_nameContextExt extendedContext = new Group_nameContextExt(this) ]
: ID ;

group_member_list
locals [ Group_member_listContextExt extendedContext = new Group_member_listContextExt(this) ]
: group_member (  group_member  )* ;

group_member
locals [ Group_memberContextExt extendedContext = new Group_memberContextExt(this) ]
:(  element 
| enum_element  );

group_declaration
locals [ Group_declarationContextExt extendedContext = new Group_declarationContextExt(this) ]
: GROUP  group_name  group_variable_name  select_address  shift_address ;

group_variable_name
locals [ Group_variable_nameContextExt extendedContext = new Group_variable_nameContextExt(this) ]
: ID ;

select_address
locals [ Select_addressContextExt extendedContext = new Select_addressContextExt(this) ]
: SELECT_ADDR  number ;

shift_address
locals [ Shift_addressContextExt extendedContext = new Shift_addressContextExt(this) ]
: SHIFT_ADDR  number ;

enum_element
locals [ Enum_elementContextExt extendedContext = new Enum_elementContextExt(this) ]
: ENUM  enum_number_index  enum_name ;

enum_number_index
locals [ Enum_number_indexContextExt extendedContext = new Enum_number_indexContextExt(this) ]
: number ;

enum_name
locals [ Enum_nameContextExt extendedContext = new Enum_nameContextExt(this) ]
: ID ;

element
locals [ ElementContextExt extendedContext = new ElementContextExt(this) ]
: ELEMENT  element_number_index  element_name  field_list ;

element_name
locals [ Element_nameContextExt extendedContext = new Element_nameContextExt(this) ]
: ID ;

element_number_index
locals [ Element_number_indexContextExt extendedContext = new Element_number_indexContextExt(this) ]
: number ;

field_list
locals [ Field_listContextExt extendedContext = new Field_listContextExt(this) ]
: field  field* ;

field
locals [ FieldContextExt extendedContext = new FieldContextExt(this) ]
: FIELD  field_name  field_range ;

field_name
locals [ Field_nameContextExt extendedContext = new Field_nameContextExt(this) ]
: ID ;

field_range
locals [ Field_rangeContextExt extendedContext = new Field_rangeContextExt(this) ]
: LBRACK  start_index  COLON  stop_index  RBRACK ;

start_index
locals [ Start_indexContextExt extendedContext = new Start_indexContextExt(this) ]
: constant_expression;

stop_index
locals [ Stop_indexContextExt extendedContext = new Stop_indexContextExt(this) ]
:constant_expression;

constant_expression
locals [ Constant_expressionContextExt extendedContext = new Constant_expressionContextExt(this) ]
: number #const_expr_only_primary
|  unary_operator  number #const_expr_unary_op
|  constant_expression  STARSTAR  constant_expression #const_expr_st_st
|  constant_expression (  STAR 
| DIV 
| MODULO  ) constant_expression #const_expr_mutl
|  constant_expression (  PLUS 
| MINUS  ) constant_expression #const_expr_add
|  constant_expression (  LSHIFT 
| RSHIFT 
| ALSHIFT 
| ARSHIFT  ) constant_expression #const_expr_shift
|  constant_expression (  LT 
| GT 
| LE 
| GE  ) constant_expression #const_expr_comp
|  constant_expression (  EQUALS 
| NOT_EQUALS  ) constant_expression #const_expr_equality
|  constant_expression (  AND  ) constant_expression #const_expr_binary_and
|  constant_expression (  XOR 
| XNOR 
| XORN  ) constant_expression #const_expr_binary_xor
|  constant_expression (  OR  ) constant_expression #const_expr_binary_or
|  constant_expression (  LAND  ) constant_expression #const_expr_land
|  constant_expression (  LOR  ) constant_expression #const_expr_lor
|  constant_expression  QUATIONMARK  constant_expression  COLON  constant_expression #const_expr_conditional;

unary_operator
locals [ Unary_operatorContextExt extendedContext = new Unary_operatorContextExt(this) ]
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
locals [ NumberContextExt extendedContext = new NumberContextExt(this) ]
: Hex_number 
|  Unsigned_number ;


