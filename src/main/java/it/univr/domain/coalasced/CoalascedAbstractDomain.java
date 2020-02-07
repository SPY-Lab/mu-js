package it.univr.domain.coalasced;

import it.univr.domain.AbstractDomain;
import it.univr.domain.AbstractValue;
import it.univr.fsm.machine.Automaton;

public class CoalascedAbstractDomain extends AbstractDomain {

	@Override
	public AbstractValue leastUpperBound(AbstractValue v1, AbstractValue v2) {
		if (v1.getClass().equals(v2.getClass()))
			return v1.leastUpperBound(v2);
		else if (v1 instanceof Bottom)
			return v2.clone();
		else if (v2 instanceof Bottom)
			return v1.clone();
		
		return new Top();
	}

	@Override
	public AbstractValue widening(AbstractValue v1, AbstractValue v2) {

		if (v1.getClass().equals(v2.getClass()))
			return v1.widening(v2);
		return new Top();
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue v1, AbstractValue v2) {

		if (v1.getClass().equals(v2.getClass()))
			return v1.greatestLowerBound(v2);
		return new Top();
	}

	@Override
	public AbstractValue narrowing(AbstractValue v1, AbstractValue v2) {
		if (v1.getClass().equals(v2.getClass()))
			return v1.narrowing(v2);
		return new Top();
	}

	@Override
	public AbstractValue juggleToNumber(AbstractValue v) {
		return v.juggleToNumber();
	}

	@Override
	public AbstractValue juggleToString(AbstractValue v) {
		return v.juggleToString();

	}

	@Override
	public AbstractValue juggleToBool(AbstractValue v) {
		return v.juggleToBool();

	}

	@Override
	public AbstractValue greater(AbstractValue left, AbstractValue right) {

		if (left instanceof FA && right instanceof FA) {
			return new Bool(2);
		} else 	if ((left instanceof Interval || left instanceof Bool || left instanceof FA) && (right instanceof Interval || right instanceof Bool || right instanceof FA)) {
			AbstractValue leftJuggled = left.juggleToNumber();
			AbstractValue rightJuggled = right.juggleToNumber();

			if (leftJuggled instanceof Interval && rightJuggled instanceof Interval)
				return ((Interval) leftJuggled).greater((Interval) rightJuggled);		
		}

		return new NaN();
	}

	@Override
	public AbstractValue less(AbstractValue left, AbstractValue right) {

		if (left instanceof FA && right instanceof FA) {
			return new Bool(2);
		} else 	if ((left instanceof Interval || left instanceof Bool || left instanceof FA) && (right instanceof Interval || right instanceof Bool || right instanceof FA)) {
			AbstractValue leftJuggled = left.juggleToNumber();
			AbstractValue rightJuggled = right.juggleToNumber();

			if (leftJuggled instanceof Interval && rightJuggled instanceof Interval)
				return ((Interval) leftJuggled).less((Interval) rightJuggled);		
		}
		return new NaN();
	}

	@Override
	public AbstractValue sum(AbstractValue left, AbstractValue right) {
		if ((left instanceof Bool || left instanceof Interval) && (right instanceof Bool || right instanceof Interval))
			return ((Interval) left.juggleToNumber()).plus((Interval) right.juggleToNumber());
		else if (left instanceof FA && right instanceof FA)
			return new FA(Automaton.concat(((FA) left).getAutomaton(), ((FA) right).getAutomaton()));
		else if (left instanceof FA || right instanceof FA)
			return ((FA) left.juggleToString()).concat((FA) right.juggleToString());
		else if (left instanceof Top || right instanceof Top)
			return new Top();
		else
			return new NaN();
	}

	@Override
	public AbstractValue diff(AbstractValue left, AbstractValue right) {
		if ((left instanceof Interval || left instanceof Bool || left instanceof FA) && (right instanceof Interval || right instanceof Bool || right instanceof FA)) {
			AbstractValue leftJuggled = left.juggleToNumber();
			AbstractValue rightJuggled = right.juggleToNumber();

			if (leftJuggled instanceof Interval && rightJuggled instanceof Interval)
				return ((Interval) leftJuggled).diff((Interval) rightJuggled);
		}

		return new NaN();
	}

	@Override
	public AbstractValue mul(AbstractValue left, AbstractValue right) {
		if ((left instanceof Interval || left instanceof Bool || left instanceof FA) && (right instanceof Interval || right instanceof Bool || right instanceof FA)) {
			AbstractValue leftJuggled = left.juggleToNumber();
			AbstractValue rightJuggled = right.juggleToNumber();


			if (leftJuggled instanceof Interval && rightJuggled instanceof Interval)
				return ((Interval) leftJuggled).mul((Interval) rightJuggled);
		}

		return new NaN();
	}

	@Override
	public AbstractValue substring(AbstractValue string, AbstractValue init, AbstractValue end) {
		if (string instanceof FA && init instanceof Interval && end instanceof Interval) 
			return ((FA) string).substring((Interval) init, (Interval) end);

		return new Bottom();
	}

	@Override
	public AbstractValue charAt(AbstractValue string, AbstractValue index) {

		if (string instanceof FA && index instanceof Interval)
			return ((FA) string).charAt((Interval) index);
		else	
			return new Bottom();
	}

	@Override
	public AbstractValue not(AbstractValue v1) {
		return ((Bool) v1.juggleToBool()).not();
	}

	@Override
	public AbstractValue makeInterval(AbstractValue v) {
		return v;
	}

	@Override
	public AbstractValue makeFA(AbstractValue v) {
		return v;
	}

	@Override
	public AbstractValue makeNaN(AbstractValue v) {
		return v;
	}

	@Override
	public AbstractValue makeBool(AbstractValue v) {
		return v;
	}

	@Override
	public AbstractValue length(AbstractValue v1) {
		if (v1 instanceof FA) {
			return ((FA) v1).length();
		}

		return new Bottom();
	}

	@Override
	public AbstractValue equals(AbstractValue v1, AbstractValue v2) {
		if (v1 instanceof FA && v2 instanceof FA)
			return new Bool(2);
		else if ((v1 instanceof Bool || v1 instanceof FA || v1 instanceof Interval) && (v2 instanceof Bool || v2 instanceof FA || v2 instanceof Interval)) {
			AbstractValue left = v1.juggleToNumber();
			AbstractValue right = v2.juggleToNumber();

			if (left instanceof Interval && right instanceof Interval)
				return ((Interval) left).isEqual((Interval) right);

		} 
		
		return new NaN();
	}

	@Override
	public AbstractValue indexOf(AbstractValue v1, AbstractValue v2) {
		if (v1 instanceof FA) {
			return ((FA) v1).indexOf((FA) v2.juggleToString());
		}
		
		return new Bottom();
	}

	@Override
	public AbstractValue and(AbstractValue first, AbstractValue second) {
		AbstractValue firstEvaluation = first.juggleToBool();

		if (firstEvaluation instanceof Bool) {
			if (((Bool) firstEvaluation).isTrue())
				return second;
			else if (((Bool) firstEvaluation).isFalse())
				return new Bool(0);
			else {
				return new Bool(0).leastUpperBound(second);			
			}
		}
		
		return new Bottom();
	}
	
	@Override
	public AbstractValue or(AbstractValue first, AbstractValue second) {
		AbstractValue firstEvaluation = first.juggleToBool();

		if (firstEvaluation instanceof Bool) {
			if (((Bool) firstEvaluation).isFalse())
				return second;
			else if (((Bool) firstEvaluation).isTrue())
				return new Bool(0);
			else {
				return new Bool(0).leastUpperBound(second);			
			}
		}
		
		return new Bottom();
	}

	@Override
	public AbstractValue div(AbstractValue left, AbstractValue right) {
		//TODO:div
		return new Top();
	}

	@Override
	public AbstractValue makeBottom() {
		return new Bottom();
	}

	@Override
	public boolean isTrue(AbstractValue v) {
		AbstractValue r = juggleToBool(v);
		return r instanceof Bool && ((Bool) r).isTrue();	
	}

	@Override
	public boolean isFalse(AbstractValue v) {
		AbstractValue r = juggleToBool(v);
		return r instanceof Bool && ((Bool) r).isFalse();	}

	@Override
	public boolean isTopBool(AbstractValue v) {
		AbstractValue r = juggleToBool(v);
		return r instanceof Bool && ((Bool) r).isTopBool();
	}
}
