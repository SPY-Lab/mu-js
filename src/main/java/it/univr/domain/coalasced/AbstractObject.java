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
	public int hashCode() {
		// TODO: Marin
		return this.abstractObject.hashCode();
	}

	@Override
	public boolean equals(Object other) {
		// TODO: Marin
		if (other instanceof AbstractObject)
			return this.abstractObject.equals(((AbstractObject)other).getAbstractObjectMap());
		return false;
	}
	/**
	 * 
	 * @return normalized this abstract object
	 */
	public AbstractObject normalize() {
		//TODO: Marin
		AbstractObject absObj = new AbstractObject(this.getAbstractObjectMap());
		for(FA fa: absObj.getAbstractObjectMap().keySet()) {
			//AbstractValue abstractValue = (AbstractValue) absObj.getAbstractObjectMap().get(fa); // .getCollection(fa);
			Object abstractValue = absObj.getAbstractObjectMap().get(fa);
			if (!fa.isSingleString() || !fa.isInfinite()) {
				this.abstractObject.remove(fa, abstractValue); // ??
				for (String s: fa.getLanguage())
					for(Object o: (Collection<AbstractValue>)abstractValue)
						this.abstractObject.put(new FA(s), (AbstractValue)o);
			}
		}
		return this;
	}
}
