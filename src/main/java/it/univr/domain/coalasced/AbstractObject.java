package it.univr.domain.coalasced;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.antlr.v4.runtime.misc.Pair;
import org.apache.commons.collections15.multimap.MultiHashMap;

import it.univr.domain.AbstractValue;
import it.univr.fsm.machine.Automaton;

public class AbstractObject implements AbstractValue {

	private MultiHashMap<FA, AbstractValue> abstractObject;

	public AbstractObject(FA fa, AbstractValue abstractValue) {
		this.abstractObject = new MultiHashMap<>();
		this.abstractObject.put(fa, abstractValue);
	}

	public AbstractObject() {
		this.abstractObject = new MultiHashMap<>();
	}

	public MultiHashMap<FA, AbstractValue> getAbstractObjectMap() {
		return this.abstractObject;
	}

	public AbstractObject(MultiHashMap<FA, AbstractValue> abstractObject) {
		this.abstractObject = new MultiHashMap<>();
		this.abstractObject.putAll(abstractObject);
	}

	@Override
	public AbstractValue juggleToNumber() {
		// TODO: Marin
		return null;
	}

	@Override
	public AbstractValue juggleToString() {
		// TODO: Marin
		return null;
	}

	@Override
	public AbstractValue juggleToBool() {
		// TODO: Marin
		return null;
	}

	@Override
	public AbstractValue leastUpperBound(AbstractValue other) {
		// TODO: Marin
		if(other instanceof AbstractObject)
			return null;
		return new Bottom();
	}

	@Override
	public AbstractValue widening(AbstractValue other) {
		// TODO: Marin
		if(other instanceof AbstractObject) {
			return null;
		}
		return new Top();
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue value) {
		// TODO: Marin
		if (value instanceof AbstractObject)
			return null;
		return new Bottom();
	}

	@Override
	public AbstractValue narrowing(AbstractValue value) {
		// TODO: Marin
		return null;
	}

	@Override
	public String toString() {
		return abstractObject.toString();
	}

	@Override
	public int hashCode() {
		// TODO: Marin
		return this.abstractObject.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof AbstractObject)
			return this.abstractObject.equals(((AbstractObject)other).getAbstractObjectMap());

		return false;
	}

	public void put(FA k, AbstractValue v) {
		if (this.abstractObject.containsKey(k)) {
			AbstractValue toPut = new Bottom();
			ArrayList<AbstractValue> other = (ArrayList<AbstractValue>) this.abstractObject.get(k);
			abstractObject.remove(k);

			for (AbstractValue o : other)
				toPut = toPut.leastUpperBound(o);

			abstractObject.put(k, v.leastUpperBound(toPut));

		} else {
			this.abstractObject.put(k, v);

		}

	}

	/**
	 * 
	 * @return normalized this abstract object
	 */
	public void normalize() {

		HashSet<FA> keys = new HashSet<FA>();

		for (FA k : this.abstractObject.keySet()) {
			keys.add(k.clone());
		}

		// first part
		for (FA abstractProperty: keys) {
			Collection<AbstractValue> abstractValue = getAbstractObjectMap().get(abstractProperty);

			if (!abstractProperty.isInfinite() && (!abstractProperty.isSingleString() || abstractProperty.getLanguage().size() != 1)) {
				// this means that the abstract property recognizes only finite languages (not equals to 1)

				abstractObject.remove(abstractProperty);
				for (String s: abstractProperty.getLanguage())
					for(AbstractValue a: abstractValue)
						put(new FA(s), a);
			}
		}

		// second part
		int previousHash;
		do {
			HashSet<Pair<FA, FA>> visited = new HashSet<Pair<FA,FA>>();

			previousHash = abstractObject.hashCode();
			keys = new HashSet<FA>();

			for (FA k : this.abstractObject.keySet()) 
				keys.add(k.clone());
									
			for (FA k1 : keys)  {

				AbstractValue v1 = get(k1);

				for (FA k2 : keys)  {

					AbstractValue v2 = get(k2);

					Automaton intersectionAutomaton = Automaton.intersection(k1.getAutomaton(), k2.getAutomaton());
					Pair<FA,FA> toCheck1 = new Pair<FA, FA>(k1, k2);
					Pair<FA,FA> toCheck2 = new Pair<FA, FA>(k2, k1);

					if ((!Automaton.isEmptyLanguageAccepted(intersectionAutomaton)) && !k1.equals(k2) && !visited.contains(toCheck1) && !visited.contains(toCheck2)) {

						FA intersectionProperty = new FA(intersectionAutomaton);
						this.abstractObject.remove(k1);
						this.abstractObject.remove(k2);
						
						FA minusP1P2 = k1.minus(k2); AbstractValue minusP1P2Value = get(minusP1P2).leastUpperBound(v1);
						FA minusP2P1 = k2.minus(k1); AbstractValue minusP2P1Value = get(minusP2P1).leastUpperBound(v2);
						
						MultiHashMap<FA, AbstractValue> toAdd = new MultiHashMap<FA, AbstractValue>();

						toAdd.put(intersectionProperty, lookupAbstractObject(intersectionProperty).leastUpperBound(v1).leastUpperBound(v2));


						if (!Automaton.isEmptyLanguageAccepted(minusP1P2.getAutomaton()) && !minusP1P2Value.equals(new Bottom())) 
							toAdd.put(minusP1P2, minusP1P2Value);
												
						if (!Automaton.isEmptyLanguageAccepted(minusP2P1.getAutomaton()) && !minusP2P1Value.equals(new Bottom())) 
							toAdd.put(minusP2P1, minusP2P1Value);
						
						
						for (FA k : toAdd.keySet()) 
							for (AbstractValue v : toAdd.get(k))
								put(k, v); 

					}
					visited.add(new Pair<FA, FA>(k1, k2));
					visited.add(new Pair<FA, FA>(k2, k1));
				}
			}
			
		} while (previousHash != abstractObject.hashCode());

	}


	public AbstractValue lookupAbstractObject(FA p) {
		//TODO: Marin

		AbstractValue resultAbstractValue = new Bottom();

		for (FA abstractProperty: getAbstractObjectMap().keySet()) {
			// for each abstract property
			if (!Automaton.intersection(p.getAutomaton(), abstractProperty.getAutomaton()).equals(Automaton.makeEmptyLanguage())) {

				for(AbstractValue currentValue: getAbstractObjectMap().get(abstractProperty)) {
					
					resultAbstractValue = resultAbstractValue.leastUpperBound(currentValue);
				}
			}
		}

		return resultAbstractValue;
	}

	public AbstractValue get(FA k) {
		AbstractValue v2 = new Bottom();
		ArrayList<AbstractValue> s = (ArrayList<AbstractValue>) abstractObject.get(k);
		if (s != null)
			for (AbstractValue v : s)
				v2 = v;
		return v2;
	}

}