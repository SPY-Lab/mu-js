function g(b) {
	b = b - 1;
	b = b + 1;
	return b;
}


function f(a) {
	while (true) {
		a = g(a) + 1;
	}
	
	return a;
}

x = f(1);