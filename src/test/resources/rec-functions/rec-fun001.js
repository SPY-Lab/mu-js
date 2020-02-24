function f(a) {
	if (a == 0) {
		result = 0;
	} else {
		result = f(a - 1);
	}
	
	return result;
}



x = f(100);