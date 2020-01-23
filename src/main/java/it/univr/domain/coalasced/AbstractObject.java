package it.univr.domain.coalasced;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.SortedSet;

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
	
	/**
	 * 
	 * @return normalized this abstract object
	 */
	public void normalize() {

		HashSet<FA> keys = new HashSet<FA>();
		
		for (FA k : this.abstractObject.keySet())
			keys.add(k.clone());

		// first part
		for (FA abstractProperty: keys) {
			Collection<AbstractValue> abstractValue = getAbstractObjectMap().get(abstractProperty);
			
			if (!abstractProperty.isInfinite() && (!abstractProperty.isSingleString() || abstractProperty.getLanguage().size() != 1)) {
				// this means that the abstract property recognizes only finite languages (not equals to 1)
				abstractObject.remove(abstractProperty);
				for (String s: abstractProperty.getLanguage())
					for(AbstractValue a: abstractValue)
						this.abstractObject.put(new FA(s), a);
			}
		}
		
		// second part
		LinkedHashSet<FA> properties = new LinkedHashSet<>(this.abstractObject.keySet());
		
		while (properties.size() > 0) {
			FA abstractProperty1 = (FA)properties.toArray()[0];
			
			AbstractValue abstractValue1 =  this.lookupAbstractObject(abstractProperty1);
			this.abstractObject.remove(abstractProperty1);
			properties.remove(abstractProperty1);
			
			boolean normalized = false;
			
			for (int i = 0; i < properties.size(); i++) {
				FA abstractProperty2 = (FA)properties.toArray()[i];
				
				AbstractValue abstractValue2 = this.lookupAbstractObject(abstractProperty2);
				Automaton intersectionAutomaton = Automaton.intersection(abstractProperty1.getAutomaton(), abstractProperty2.getAutomaton());
				if ((!Automaton.isEmptyLanguageAccepted(intersectionAutomaton)) && !abstractProperty1.equals(abstractProperty2)) {
					normalized = true;
					FA intersectionProperty = new FA(intersectionAutomaton);
					
					this.abstractObject.put(intersectionProperty, this.lookupAbstractObject(intersectionProperty).leastUpperBound(abstractValue1).leastUpperBound(abstractValue2));
					properties.add(intersectionProperty);
					
					FA minusP1P2 = abstractProperty1.minus(abstractProperty2);
					if (!Automaton.isEmptyLanguageAccepted(minusP1P2.getAutomaton())) {
						this.abstractObject.put(minusP1P2, this.lookupAbstractObject(minusP1P2).leastUpperBound(abstractValue1));
						properties.add(minusP1P2);
					}
					FA minusP2P1 = abstractProperty2.minus(abstractProperty1);
					if (!Automaton.isEmptyLanguageAccepted(minusP2P1.getAutomaton())) {
						this.abstractObject.put(minusP2P1, this.lookupAbstractObject(minusP2P1).leastUpperBound(abstractValue2));
						properties.add(minusP2P1);
					}
					this.abstractObject.remove(abstractProperty2);
					properties.remove(abstractProperty2);
					i--;
				}
			}
			if (!normalized) {
				this.abstractObject.put(abstractProperty1, abstractValue1);
			}
		}
		
	}
	
	public AbstractValue lookupAbstractObject(FA p) {
		//TODO: Marin
		
		AbstractValue resultAbstractValue = new Bottom();
		
	
		
		for (FA abstractProperty: getAbstractObjectMap().keySet()) {
			// for each abstract property
			if (!Automaton.intersection(p.getAutomaton(), abstractProperty.getAutomaton()).equals(Automaton.makeEmptyLanguage())) {
				
				for(Object o: (Collection<?>) getAbstractObjectMap().get(abstractProperty)) {
					
					if(o instanceof AbstractValue) {
						
					
						
						resultAbstractValue = resultAbstractValue.leastUpperBound((AbstractValue)o);
						
					}
				}
			}
		}
		
		return resultAbstractValue;
	
	}
}
