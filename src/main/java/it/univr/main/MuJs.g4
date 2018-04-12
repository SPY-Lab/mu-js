grammar MuJs;

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

STRING: '"' ~('\r' | '\n' | '\"')* '"'
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
	;
	
stmt:
	   ID ASG expression SEMICOLON										#AssignmentStmt
	| 'if' '(' expression ')' block 'else' block						#IfStmt
	| 'while' '(' expression ')' block									#WhileStmt
	|  block															#BlockStmt
	|  stmt stmt														#Composition
	;
	
block:  '{' '}'
	|	'{' stmt '}'
	;	
	
WS: [ \r\n\t] + -> skip
   ;