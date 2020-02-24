function f(n) {
 	if (n == 0) {
		result = 1;
	} 	else {
		result = n * f(n - 1);
	}
	return result;
}

x = f(3);
y = f(3);