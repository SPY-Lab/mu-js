package it.univr.state;

import java.util.Vector;

public class KCallStrings extends Vector<CallString> {
	
	@Override
	public String toString() {
		String res = "";
		
		for (int i = 0; i < size(); i++)
			res += get(i).toString();
		return res;
	}
}
