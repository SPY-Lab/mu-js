package it.univr.state;

import java.util.HashMap;

public class AbstractState {

	private HashMap<Variable, Function> functions;
	private HashMap<KeyAbstractState, AbstractEnvironment> state;
	
	public AbstractState() {
		this.functions = new HashMap<Variable, Function>();
		this.state = new HashMap<KeyAbstractState, AbstractEnvironment>();
	}

	public void add(KeyAbstractState key, AbstractEnvironment m) {
		if (state.containsKey(key))
			state.put(key, state.get(key).leastUpperBound(m));
		else
			state.put(key, m);
	}

	public HashMap<Variable, Function> getFunctions() {
		return functions;
	}
	
	public void addFunction(Variable name, Function function) {
		functions.put(name, function);
	}

	@Override
	public String toString() {
		String result = "";
		
		for (KeyAbstractState k : state.keySet()) {
			result += "\n*******************\n";
			result += "Line " + k.getRow() +", Column " + k.getCol() + "\n";
			result += state.get(k).toString();
		}
		
		return result;
	}

	public Function getFunction(Variable variable) {
		return functions.get(variable);
	}
}
