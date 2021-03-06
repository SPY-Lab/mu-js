package it.univr.domain;

public abstract class AbstractDomain implements TypeJuggligAbstractDomain {

	public abstract AbstractValue leastUpperBound(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue widening(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue greatestLowerBound(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue narrowing(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue greater(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue less(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue sum(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue diff(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue mul(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue substring(AbstractValue v1, AbstractValue v2, AbstractValue v3);
	public abstract AbstractValue charAt(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue indexOf(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue length(AbstractValue v1);
	public abstract AbstractValue not(AbstractValue v1);
	public abstract AbstractValue equals(AbstractValue v1, AbstractValue v2);
	public abstract AbstractValue and(AbstractValue first, AbstractValue second);
	public abstract AbstractValue or(AbstractValue first, AbstractValue second);
	public abstract AbstractValue div(AbstractValue left, AbstractValue right);


	public abstract AbstractValue makeInterval(AbstractValue v);
	public abstract AbstractValue makeFA(AbstractValue v);
	public abstract AbstractValue makeNaN(AbstractValue v);
	public abstract AbstractValue makeBool(AbstractValue v);
}
