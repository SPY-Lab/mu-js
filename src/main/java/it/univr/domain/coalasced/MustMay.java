package it.univr.domain.coalasced;

import it.univr.domain.AbstractValue;
import it.univr.fsm.machine.Automaton;

public class MustMay implements AbstractValue {

	/**
	 * May static value
	 */
	private static byte MAY = 0;

	/**
	 * Must static value
	 */
	private static byte MUST = 1;

	/**
	 * Abstract must-may value
	 */
	private byte value;

	/**
	 * Abstract boolean constructor.
	 * 
	 * @param value byte identifying an abstract boolean.
	 */
	public MustMay(byte value) {
		this.value = value;
	}

	public MustMay(int value) {
		this.value = (byte) value;
	}

	/**
	 * Returns the abstract must-may value.
	 * 
	 * @return the abstract must-may value
	 */
	public byte getValue() {
		return value;
	}

	/**
	 * Set the abstract must-may value.
	 * 
	 * @param value the abstract must-may value to set
	 */
	public void setValue(byte value) {
		this.value = value;
	}

	public boolean isMay() {
		return this.getValue() == MAY;
	}

	public boolean isMust() {
		return this.getValue() == MUST;
	}
	
	public MustMay inverse() {
		if (this.isMust())
			return new MustMay(MAY);
		else
			return new MustMay(MUST);
	}

	@Override
	public String toString() {
		if (value == MAY)
			return "may";
		else
			return "MUST";
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof MustMay)
			return getValue() == ((MustMay) other).getValue();
		return false;
	}

	@Override
	public MustMay clone() {
		return new MustMay(getValue());
	}

	@Override
	public AbstractValue leastUpperBound(AbstractValue other) {
		if (other instanceof MustMay) {
			if (getValue() == ((MustMay) other).getValue())
				return clone();
			return new MustMay(MAY);
		} else if (other instanceof Bottom)
			return clone();

		return new Top();
	}

	@Override
	public AbstractValue widening(AbstractValue other) {
		return leastUpperBound(other);
	}

	@Override
	public AbstractValue juggleToNumber() {
		if (isMay())
			return new Interval("0", "0");
		else
			return new Interval("1", "1");
	}

	@Override
	public AbstractValue juggleToString() {
		if (isMay())
			return new FA(Automaton.makeAutomaton("may"));
		else
			return new FA(Automaton.makeAutomaton("must"));
	}

	@Override
	public AbstractValue juggleToBool() {
		if (isMay())
			return new Bool(0);
		else
			return new Bool(1);
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue value) {
		
		if (value instanceof MustMay) {
			if (getValue() == ((MustMay) value).getValue())
				return clone();
			return new MustMay(MUST);
		} else if (value instanceof Top)
			return clone();

		return new Bottom();
	}

	@Override
	public AbstractValue narrowing(AbstractValue value) {
		return greatestLowerBound(value);
	}

}