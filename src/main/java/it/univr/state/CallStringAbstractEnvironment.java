package it.univr.state;

import java.util.HashMap;

import it.univr.domain.AbstractDomain;
import it.univr.domain.AbstractValue;

public class CallStringAbstractEnvironment extends HashMap<CallString, AbstractEnvironment> {

	private AbstractDomain domain;

	public CallStringAbstractEnvironment(AbstractDomain domain) {
		super();
		this.setAbstractDomain(domain);
	}
	
	public CallStringAbstractEnvironment(AbstractDomain domain, AbstractStore store, AbstractHeap heap, CallString cs) {
		super();
		this.setAbstractDomain(domain);
		AbstractEnvironment env = new AbstractEnvironment(domain);
		env.setHeap(heap);
		env.setStore(store);
		put(cs, env);
	}
	
	public CallStringAbstractEnvironment(AbstractDomain domain, AbstractEnvironment env, CallString cs) {
		super();
		this.setAbstractDomain(domain);
		put(cs, env);
	}

	public AbstractDomain getAbstractDomain() {
		return domain;
	}

	public void setAbstractDomain(AbstractDomain domain) {
		this.domain = domain;
	}
	
	public AbstractStore getStore(CallString cs) {
		return get(cs).getStore();
	}
	
	public AbstractHeap getHeap(CallString cs) {
		return get(cs).getHeap();
	}
	
	public void putVariable(Variable var, AbstractValue v, CallString cs) {
		get(cs).getStore().put(var, v);
	}
	
	public void removeVariable(Variable var, CallString cs) {
		get(cs).getStore().remove(var);
	}
	
	@Override
	public CallStringAbstractEnvironment clone() {
		return (CallStringAbstractEnvironment) super.clone();
	}
	
	public  CallStringAbstractEnvironment leastUpperBound(CallStringAbstractEnvironment other) {
		CallStringAbstractEnvironment lub = new CallStringAbstractEnvironment(domain);

		for (CallString cs : keySet()) 
			lub.put(cs, get(cs).leastUpperBound(other.get(cs)));

		for (CallString cs : other.keySet()) 
			if (!containsKey(cs))
				lub.put(cs, other.get(cs).clone());

		return lub;
	}
	
	public  CallStringAbstractEnvironment widening(CallStringAbstractEnvironment other) {
		CallStringAbstractEnvironment lub = new CallStringAbstractEnvironment(domain);

		for (CallString cs : keySet()) 
			lub.put(cs, get(cs).widening(other.get(cs)));

		for (CallString cs : other.keySet()) 
			if (!containsKey(cs))
				lub.put(cs, other.get(cs).clone());

		return lub;
	}
}
