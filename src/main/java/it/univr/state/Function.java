package it.univr.state;

import java.util.Vector;

import it.univr.main.MuJsParser;

public class Function {
	
	private Variable name; 
	private Vector<Variable> formalParameters;
	private MuJsParser.BodyContext body;
	
	public Function(Variable name, Vector<Variable> formalParameters, MuJsParser.BodyContext body) {
		this.name = name;
		this.formalParameters = formalParameters;
		this.body = body;
	}

	public Vector<Variable> getFormalParameters() {
		return formalParameters;
	}

	public void setFormalParameters(Vector<Variable> formalParameters) {
		this.formalParameters = formalParameters;
	}

	public MuJsParser.BodyContext getBody() {
		return body;
	}

	public void setBody(MuJsParser.BodyContext body) {
		this.body = body;
	}

	public Variable getFunctionName() {
		return name;
	}

	public void setId(Variable name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		String result = "function " + name + "(";
		
		for (Variable v : formalParameters)
			result += v + ",";
		
		
		result = result.substring(0, result.length() - 1) + ") " + body.getText();
		return result;
	}
	
	
}
