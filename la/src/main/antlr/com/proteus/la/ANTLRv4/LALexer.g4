lexer grammar LALexer;

@header{
package com.proteus.la.ANTLRv4;

import com.proteus.la.*;
}


ISOLATE_ADDRESSES : 'isolate_addresses';
VARIABLE : 'variable';
MASK_ADDR : 'MASK_ADDR';
VAL_ADDR : 'VAL_ADDR';
OP_ADDR : 'OP_ADDR';
CHAIN : 'chain';
GROUP : 'group';
ELEMENT : 'element';
ENUM : 'enum';
FIELD : 'field';
SELECT : 'select';
SELECT_ADDR : 'SELECT_ADDR';
SHIFT_ADDR : 'SHIFT_ADDR';
LCURL : '{';
RCURL : '}';
LBRACK : '[';
RBRACK : ']';
COLON : ':';
STARSTAR :   '**';
STAR : '*';
DIV : '/';
MODULO : '%';
PLUS : '+';
MINUS : '-';
LSHIFT : '<<';
RSHIFT : '>>';
ALSHIFT : '<<<';
ARSHIFT : '>>>';
LT : '<';
GT : '>';
LE : '<=';
GE : '>=';
EQUALS : '=';
NOT : '!';
NOT_EQUALS : '!=';
AND : '&';
NAND : '~$';
OR : '|';
NOR : '~|';
XOR : '^';
XORN : '~^';
XNOR : '^~';
LOR : '||';
LAND : '&&';
COMPLIMENT : '~';
QUATIONMARK : '?';
COMMA : ',';
DOT : '.';

Hex_number : ( Size )? Hex_base Hex_value ;
Unsigned_number : Decimal_digit ( '_' | Decimal_digit )* ;

fragment
Size : Non_zero_unsigned_number ;

fragment
Non_zero_unsigned_number : Non_zero_decimal_digit ( '_' | Decimal_digit )* ;

fragment
Non_zero_decimal_digit : [1-9] ;

fragment
Hex_base : ('\'' [sS]? [hH] | '0x' | '0X') ;

fragment
Hex_value : Hex_digit ( '_' | Hex_digit )* ;

fragment
Hex_digit : X_digit | Z_digit | [0-9a-fA-F] ;

fragment
X_digit : [xX] ;

fragment
Z_digit : [zZ?] ;

fragment
Decimal_digit : [0-9] ;


BLOCK_COMMENT
	:	'/*' .*? ('*/' | EOF)  -> channel(HIDDEN)
	;

LINE_COMMENT
	:	'//' ~[\r\n]*  -> channel(HIDDEN)
	;



WS  :   [ \t\n\r]+ -> channel(HIDDEN) ;

ID  :  [a-zA-Z_] [a-zA-Z0-9_$]* ;