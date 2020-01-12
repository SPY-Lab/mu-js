package it.univr.domain.coalasced;



import org.apache.commons.collections15.multimap.MultiHashMap;

import it.univr.domain.AbstractValue;

public class AbstractObject implements AbstractValue {
	// this è una multihashmap, quindi due chiavi uguali va bene
	
	private MultiHashMap<FA, AbstractValue> abstractObject = new MultiHashMap<FA,AbstractValue>();
	
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
//		if(other instanceof MultiHashMap)
//			for (FA fa: ((MultiHashMap<FA,AbstractValue>) other).keySet()){
//				
//			}
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
	public int hashCode() {
		// TODO: Marin
		return this.abstractObject.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		// TODO: Marin
		/*
		 * todo
		 */
		if (other instanceof AbstractObject)
			return this.abstractObject.equals(other);
		return false;
	}
	/**
	 * 
	 * @return normalized this abstract object
	 */
	private MultiHashMap<FA, AbstractValue> normalize() {
		//TODO: Marin
		MultiHashMap<FA, AbstractValue> tempAbstractObject = (MultiHashMap<FA, AbstractValue>) this.abstractObject.clone();
		for(FA fa: tempAbstractObject.keySet()) {
			AbstractValue abstractValue = (AbstractValue) tempAbstractObject.get(fa);
			if (!fa.isSingleString() || !fa.isInfinite()) {
				this.abstractObject.remove(fa, abstractValue); // ??
				for (String s: fa.getLanguage())
					this.abstractObject.put(new FA(s), abstractValue);
			}
		}
		return this.abstractObject;
	}
}
