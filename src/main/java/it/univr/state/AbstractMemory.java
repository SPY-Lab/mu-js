package it.univr.state;

import java.util.HashMap;

import it.univr.domain.AbstractDomain;
import it.univr.domain.AbstractValue;
import it.univr.domain.coalasced.Bottom;
import it.univr.domain.coalasced.FA;
import it.univr.domain.lifted.LiftedUnionAbstractValue;

/**
 * Abstract state class. It is a partial map from Variable to AbstractValue.
 * 
 * @author  * @author <a href="vincenzo.arceri@univr.it">Vincenzo Arceri</a>
 */
public class AbstractMemory extends HashMap<Variable, AbstractValue> {


	private static final long serialVersionUID = 1L;
	private AbstractDomain domain;


	public AbstractMemory(AbstractDomain domain) {
		super();
		this.domain = domain;
	}

	/**
	 * Perform the least upper bound of two memories.
	 * 
	 * @param m1 first memory
	 * @param m2 second memory
	 * @return the least upper bound of the two memory
	 */
	public AbstractMemory leastUpperBound(AbstractMemory other) {
		AbstractMemory lub = new AbstractMemory(domain);

		for (Variable v: keySet()) 
			lub.put(v, domain.leastUpperBound(getValue(v),other.getValue(v)));

		for (Variable v: other.keySet()) 
			if (!containsKey(v))
				lub.put(v, domain.leastUpperBound(getValue(v),other.getValue(v)));

		return lub; 
	}

	/**
	 * Perform the narrowing of two states.
	 * 
	 * @param m1 first state
	 * @param m2 second state
	 * @return the widening of the two states
	 */
	public AbstractMemory narrowing(AbstractMemory other) {
		AbstractMemory lub = new AbstractMemory(domain);

		for (Variable v: keySet()) 
			lub.put(v, domain.narrowing(getValue(v),other.getValue(v)));

		for (Variable v: other.keySet()) 
			if (!containsKey(v))
				lub.put(v, domain.narrowing(getValue(v),other.getValue(v)));

		return lub; 
	}

	/**
	 * Perform the widening of two states.
	 * 
	 * @param m1 first state
	 * @param m2 second state
	 * @return the widening of the two states
	 */
	public AbstractMemory widening(AbstractMemory other) {
		AbstractMemory lub = new AbstractMemory(domain);

		for (Variable v: keySet()) 
			lub.put(v, domain.widening(getValue(v),other.getValue(v)));

		for (Variable v: other.keySet()) 
			if (!containsKey(v))
				lub.put(v, domain.widening(getValue(v),other.getValue(v)));

		return lub; 
	}

	public AbstractValue getValue(Variable v) {
		if (containsKey(v))
			return get(v);
		return new Bottom();
	}


	public void intersect(AbstractMemory other) {
		for (Variable v : other.keySet()) 
			put(v, domain.greatestLowerBound(getValue(v),(other.getValue(v))));
	}

	@Override
	public String toString() {
		String result = "*******************\n";

		for (Variable v : keySet())
			result += v.toString() + " -> " + getValue(v) + "\n";

		if (isEmpty())
			result += "Empty abstract state.\n";

		result += "*******************\n";
		return result;
	}

	@Override
	public AbstractMemory clone() {
		return (AbstractMemory) super.clone();
	}

	@Override
	public AbstractValue put(Variable key, AbstractValue v) {
		if (v instanceof FA) {
			((FA) v).minimize();
			super.put(key, v);
			return v;
		}

		else if (v instanceof LiftedUnionAbstractValue && ((LiftedUnionAbstractValue) v).isFA()) {
			if (((LiftedUnionAbstractValue) v).getFA() instanceof FA) {
				((FA) ((LiftedUnionAbstractValue) v).getFA()).minimize(); 
				super.put(key, v);
				return v;
			}
		}
		
		super.put(key, v);
		return v;
	}
}
