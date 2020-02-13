grammar MuJs;

@header {
    package it.univr.main;
}

ASG: '=';

NAN: 'NaN'
	;

BOOL: 'true' 
	| 'false';

SEMICOLON: ';';

ID: [a-z]+
	;

SIGN: '+' | '-';

INT: SIGN? [0-9]+ 
	;

STRING: '"' ~('\r' | '\n' | '"')* '"'
	| 	'\'' ~('\r' | '\n' )* '\'';
	
	 
LESS : '<'
	;	
	
program: stmt EOF 														#ProgramExecution
	;
	
val: 	INT 															#Integer
	| 	BOOL 															#Boolean
	| 	STRING															#String
	|	NAN																#NaN
	;	

object: '{' '}'															#EmptyObject
	|	'{' (ID ':' expression) (';' ID ':' expression)* '}'			#Obj
	;
expression:	
		expression '.' 'substring' '(' expression ',' expression ')'	#Substring
	|	expression '.' 'charAt' '(' expression ')'						#CharAt
	|	expression '.' 'indexOf' '(' expression ')'						#IndexOf
	|	expression '.' 'length'											#Length
	|	'(' expression ')'												#Parenthesis
	|	expression '==' expression										#Equals
	|	ID																#Identifier
	|	val																#PrimitiveValue
	|	expression '+' expression										#Sum
	|	expression '-' expression										#Diff
	|	expression '*' expression										#Mul
	|	expression '/' expression										#Div
	|	expression '>' expression										#Greater
	|	expression LESS expression										#Less
	|	expression '&&' expression										#And
	|	expression '||' expression										#Or
	|	'!' expression													#Not
	|	object															#ObjectExpression
	|	ID'[' expression ']'											#PropLookup
	|	ID '(' expression ( ',' expression )* ')'						#FunctionCall
	;
	
	
ret:
	'return' expression ';'												#Return
	;	
	
stmt:
	   ID ASG expression SEMICOLON										#AssignmentStmt
	| 'if' '(' expression ')' block 'else' block						#IfStmt
	| 'while' '(' expression ')' block									#WhileStmt
	|  block															#BlockStmt
	|  <assoc=right> stmt stmt											#Composition
	|  ID ASG 'new' object SEMICOLON 									#ObjectAsg
	|  ID '[' expression ']' ASG expression SEMICOLON 					#PropUpdate
	| 'function' ID '(' ID ( ',' ID)* ')' '{' bodyfunction '}'			#FunctionDeclaration
	;

bodyfunction:															
	stmt? ret 															#BodyFunction									
	; 	


block:  '{' '}'
	|	'{' stmt '}'
	;	
	
WS: [ \r\n\t] + -> skip
   ;