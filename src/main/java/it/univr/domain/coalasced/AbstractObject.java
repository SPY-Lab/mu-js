package it.univr.domain.coalasced;

import java.util.Collection;

import org.apache.commons.collections15.multimap.MultiHashMap;
import it.univr.domain.AbstractValue;

public class AbstractObject implements AbstractValue {
	
	private MultiHashMap<FA, AbstractValue> abstractObject;// = new MultiHashMap<FA,AbstractValue>();
	
//	public AbstractObject() {
//		this.abstractObject = new MultiHashMap<FA,AbstractValue>();
//	}
	
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
//		if(other instanceof AbstractObject) {
//			return null;
//		}
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
		
		for (FA abstractProperty: getAbstractObjectMap().keySet()) {
			
			Object abstractValue = getAbstractObjectMap().get(abstractProperty);
			
			if (!abstractProperty.isSingleString() || !abstractProperty.isInfinite()) {
				// this means that the abstract property recognizes only finite languages (not equals to 1)
				
				abstractObject.remove(abstractProperty);
				
				for (String s: abstractProperty.getLanguage())
					for(Object o: (Collection<AbstractValue>) abstractValue)
						this.abstractObject.put(new FA(s), (AbstractValue) o);
			}
		}
	}
	
	public AbstractValue lookupAbstractObject(FA p) {
		//TODO: Marin
		return new Bottom();
	}
}
