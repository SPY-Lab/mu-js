package it.univr.state;

import java.util.HashMap;

public class AbstractState extends HashMap<KeyAbstractState, AbstractEnvironment>{

	public AbstractState() {
		super();
	}

	public void add(KeyAbstractState key, AbstractEnvironment m) {
		if (containsKey(key))
			put(key, get(key).leastUpperBound(m));
		else
			put(key, m);
	}

	@Override
	public String toString() {
		String result = "";

		for (KeyAbstractState k : keySet()) {
			result += "\n*******************\n";
			result += "Line " + k.getRow() +", Column " + k.getCol() + "\n";
			result += get(k).toString();
		}
		
		return result;
	}
}
