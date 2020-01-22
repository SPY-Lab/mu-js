package it.univr.domain.coalasced;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;

import it.univr.domain.AbstractValue;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;

public class FA implements AbstractValue {

	private static int widening = 3;
	
	public static void main(String[] args) {
		Automaton a = Automaton.rightQuotient(Automaton.suffixesAt(4,Automaton.makeRealAutomaton("hello")),  Automaton.suffix(Automaton.suffixesAt(6, Automaton.makeRealAutomaton("hello"))));
		System.err.println(a);
	}

	private Automaton automaton;
	
	// 20.12 START
	private boolean hasCycle() {
		return this.automaton.hasCycle();
	}
	
	public HashSet<String> getLanguage() {
		assertTrue(!this.automaton.hasCycle());
		return this.automaton.getLanguage();
	}
	
	public boolean isSingleString() {
		return this.automaton.isSingleString();
	}
	
	public boolean isInfinite() {
		return hasCycle();
	}
	
	public static FA star(Automaton a) {
		return new FA(Automaton.star(a));
	}
	
	public static FA star(String s) {
		return new FA(Automaton.star(Automaton.makeAutomaton(s)));
	}
	
	public FA minus(FA that) {
		return new FA(Automaton.minus(this.automaton, that.automaton));
	}
	// 20.12 END
	
	public FA() {
		this.automaton = Automaton.makeEmptyLanguage();
	}

	public FA(String s) {
		this.automaton = Automaton.makeRealAutomaton(s);
		this.automaton.minimize();
	}

	public FA(Automaton automaton) {
		this.automaton = automaton;
		this.automaton.minimize();
	}
	
	public void minimize() {
		automaton.minimize();
	}
	
	public static void setWidening(int w) {
		FA.widening = w;
	}

	@Override
	public AbstractValue leastUpperBound(AbstractValue other) {
		if (other instanceof FA) 
			return new FA(Automaton.union(getAutomaton(), ((FA) other).getAutomaton()));
		else if (other instanceof Bottom)
			return clone();
		return new Top();
	}

	@Override
	public AbstractValue widening(AbstractValue other) {
		if (other instanceof FA) 
			return new FA(Automaton.union(getAutomaton(), ((FA) other).getAutomaton()).widening(widening));
		else if (other instanceof Bottom)
			return clone();
		
		return new Top();	
	}

	public Automaton getAutomaton() {
		return automaton;
	}

	public void setAutomaton(Automaton automaton) {
		this.automaton = automaton;
	}

	@Override
	public String toString() {
		return automaton.toRegex().toString();
	}

	public FA concat(FA other) {
		return new FA(Automaton.concat(automaton, other.getAutomaton()));
	}

	public FA substring(Interval init, Interval end) {
		Automaton result = Automaton.makeEmptyLanguage();

		if (getAutomaton().isSingleString())
			setAutomaton(Automaton.makeRealAutomaton(getAutomaton().getSingleString()));
		
		if (init.isNegativeInfinite())
			init.setLow("0");

		if (end.isNegativeInfinite())
			end.setLow("0");

		//
		// First row
		//
		if (init.isFiniteConcrete()) {
			if (end.isFiniteConcrete()) {
				ArrayList<Long> initIntegers = init.getIntergers();
				ArrayList<Long> endIntegers = end.getIntergers();

				for (int i = 0; i < initIntegers.size(); i++)
					for (int j = 0; j < endIntegers.size(); j++)
						result = Automaton.union(result, Automaton.substring(automaton, initIntegers.get(i), endIntegers.get(j)));
				result.minimize();
				return new FA(result);
			}

			else if (end.isNegativeInfinite() && !end.isPositiveInfinite()) {
				return substring(init, new Interval("0", end.getHigh()));
			}

			else if (!end.isNegativeInfinite() && end.isPositiveInfinite()) {

				long i = Integer.parseInt(init.getLow());
				long j = Integer.parseInt(init.getHigh());
				long l = Integer.parseInt(end.getLow());


				// Table 1 case (first row, third column)
				if (i <= l && j <= l) {
					ArrayList<Long> initIntegers = init.getIntergers();

					for (int c = 0; c < initIntegers.size(); ++c)
						result = Automaton.union(result, Automaton.substringWithUnknownEndPoint(automaton, initIntegers.get(c), l));

					return new FA(result);

				}

				// Table 2 case (first row, third column)
				else if (l < i) {
					return FA.union(
							substring(new Interval(String.valueOf(l), String.valueOf(j)), new Interval(String.valueOf(i), String.valueOf(j)))
							, 
							substring(new Interval(String.valueOf(i), String.valueOf(j)), new Interval(String.valueOf(j),"+Inf")));

				}

				// Table 3 (first row, third column)
				else if (i <= l && j > l) {
					FA first = substring(new Interval(String.valueOf(l), String.valueOf(j)), new Interval(String.valueOf(l), String.valueOf(j)));
					FA second = substring(new Interval(String.valueOf(i), String.valueOf(l)), new Interval(String.valueOf(l), "+Inf"));
					FA third = substring(new Interval(String.valueOf(l), String.valueOf(j)), new Interval(String.valueOf(j), "+Inf"));

					return FA.union(FA.union(first, second), third);

				}
			}

			else if (end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return substring(init, new Interval("0", "+Inf"));
			}
		}

		//
		// Second row
		//
		else if (init.isNegativeInfinite() && !init.isPositiveInfinite()) {


			if (end.isFiniteConcrete()) {
				return substring(new Interval("0", init.getHigh()), end);
			}

			else if (end.isNegativeInfinite() && !end.isPositiveInfinite()) {
				return substring(new Interval("0", init.getHigh()), new Interval("0", end.getHigh()));
			}

			else if (!end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return substring(new Interval("0", init.getHigh()), new Interval(end.getLow(), "+Inf"));
			}

			else if (end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return substring(new Interval("0", "+Inf"), new Interval("0", "+Inf"));
			}

		}

		//
		// Third row
		//
		else if (!init.isNegativeInfinite() && init.isPositiveInfinite()) {

			if (end.isFiniteConcrete()) {

				long i = Integer.parseInt(init.getLow());
				long l = Integer.parseInt(end.getLow());
				long k = Integer.parseInt(end.getHigh());

				// Table 1 (third row, first column)
				if (i <= l) {
					FA first = substring(new Interval(String.valueOf(i), String.valueOf(k)), end);
					FA second = substring(end, new Interval(end.getLow(), "+Inf"));

					return FA.union(first, second);
				}

				// Table 2 (third row, first column)
				else if (l < i && i <= k) {
					FA first = substring(new Interval(end.getLow(), end.getHigh()), new Interval(init.getLow(), end.getHigh()));
					FA second = substring(new Interval(end.getLow(), init.getLow()), new Interval(init.getLow(),"+Inf"));
					FA third = substring(new Interval(init.getLow(), end.getHigh()), new Interval(end.getHigh(), "+Inf"));
					
					return FA.union(FA.union(first, second), third);
				}
				
				// Table 3 (third row, first column)
				else if (i > k) {
				
					return substring(new Interval(end.getLow(), end.getHigh()), new Interval(init.getLow(), "+Inf"));
				}

			}
			
			else if (end.isNegativeInfinite() && !end.isPositiveInfinite()) {
				return substring(new Interval(init.getLow(), "+Inf"), new Interval("0", end.getHigh()));
			}

			else if (!end.isNegativeInfinite() && end.isPositiveInfinite()) {
				
				long i = Integer.parseInt(init.getLow());
				long l = Integer.parseInt(end.getLow());
				
				// Table 1 (third row, third column)
				if (i <= l) {
					FA first = substring(new Interval(init.getLow(), end.getLow()), new Interval(end.getLow(), "+Inf"));
					FA second = new FA(Automaton.factorsStartingAt(automaton, l));
					
					return FA.union(first, second);
				}
				
				// Table 2 (third row, third column)
				else if (l < i) {
					return substring(new Interval(end.getLow(), "+Inf"), new Interval(init.getLow(), "+Inf"));
				}
				
				// Table 3 (third row, third column)
				else 
					return substring(init, end);
					
			}
			
			else if (end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return substring(new Interval(init.getLow(), "+Inf"), new Interval("0", "+Inf"));
			}

		}
		
		//
		// Fourth row
		//
		else if (init.isNegativeInfinite() && init.isPositiveInfinite()) {
			
			if (end.isFiniteConcrete()) {
				return substring(new Interval("0", "+Inf"), end);
			}
			
			else if (end.isNegativeInfinite() && !end.isPositiveInfinite()) {
				return substring(new Interval("0", "+Inf"), new Interval("0", end.getHigh()));
			}
			
			else if (!end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return substring(new Interval("0", "+Inf"), new Interval(end.getLow(), "+Inf"));
			}
			
			else if (end.isNegativeInfinite() && end.isPositiveInfinite()) {
				return new FA(Automaton.factors(automaton));
			}
		}

		return null;

	}

	public static FA union(FA a, FA b) {
		return new FA(Automaton.union(a.getAutomaton(), b.getAutomaton()));
	}

	public static FA makeEmptyLanguage() {
		return new FA(Automaton.makeEmptyLanguage());
	}
	
	public static FA union(String ... strings) {
		FA res = FA.makeEmptyLanguage();
		
		for (String s : strings)
			res = FA.union(res, new FA(s));
		
		return res;
	}
	
	public static FA union(FA ... automata) {
		FA res = FA.makeEmptyLanguage();
		
		for (FA a : automata)
			res = FA.union(res, a);
		
		return res;
	}
	
	public FA charAt(Interval index) {

		Automaton result = Automaton.makeEmptyLanguage();

		if (getAutomaton().isSingleString())
			setAutomaton(Automaton.makeRealAutomaton(getAutomaton().getSingleString()));
		
		// Case 1
		if (index.isFiniteConcrete()) {

			ArrayList<Long> integers = index.getIntergers();
			for (int i = 0; i < integers.size(); ++i)
				result = Automaton.union(result, Automaton.charAt(automaton, integers.get(i)));
		} 
		// Case 2
		else if (index.isNegativeInfinite() && !index.isPositiveInfinite() && Integer.parseInt(index.getHigh()) >= 0) {
			result = Automaton.union(charAt(new Interval("0", index.getHigh())).getAutomaton(), Automaton.makeEmptyString());
		} 
		// Case 3
		else if (index.isNegativeInfinite() && !index.isPositiveInfinite() && Integer.parseInt(index.getHigh()) < 0) {
			result = Automaton.makeEmptyString();
		} 
		// Case 4
		else if (!index.isNegativeInfinite() && index.isPositiveInfinite() && Integer.parseInt(index.getLow()) >= 0) {
//			result = Automaton.intersection(Automaton.factorsStartingAt(automaton, Integer.parseInt(index.getLow())), Automaton.atMostLengthAutomaton(1));
			result = Automaton.union(Automaton.chars(Automaton.suffixesAt(Integer.parseInt(index.getLow()), automaton)), Automaton.makeEmptyString());
		} 
		// Case 5
		else {
//			result = Automaton.intersection(Automaton.factors(automaton), Automaton.atMostLengthAutomaton(1));
			result = Automaton.union(Automaton.chars(automaton), Automaton.makeEmptyString());
		}

		return new FA(result);
	}

	@Override
	public AbstractValue juggleToNumber() {
		FA numbers = FA.makeNumberAutomaton();

		Automaton numbersIntoAutomaton = Automaton.intersection(numbers.getAutomaton(), getAutomaton());
		boolean hasOnlyNumbers = Automaton.isContained(getAutomaton(), numbers.getAutomaton());

		if (!Automaton.isEmptyLanguageAccepted(numbersIntoAutomaton) && hasOnlyNumbers) {

			//TODO: extract numbers from automaton.
			return new FA(numbersIntoAutomaton);
		}
		else if (!hasOnlyNumbers)
			return new Top();

		return new NaN();
	}

	@Override
	public AbstractValue juggleToString() {
		return clone();
	}

	@Override
	public AbstractValue juggleToBool() {

		if (getAutomaton().equals(Automaton.makeEmptyString()))
			return new Bool(0);
		else if (Automaton.isContained(Automaton.makeEmptyString(), getAutomaton()))
			return new Bool(2);

		return new Bool(1);
	}

	@Override
	public FA clone() {
		return new FA(getAutomaton().clone());
	}

	public static FA makeNumberAutomaton() {

		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();


		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, true);


		states.add(q0);
		states.add(q1);
		states.add(q2);

		delta.add(new Transition(q0, q1, "+"));
		delta.add(new Transition(q0, q1, "-"));

		for (int i = 0; i < 10; i++) {
			delta.add(new Transition(q0, q2, String.valueOf(i)));
			delta.add(new Transition(q1, q2, String.valueOf(i)));
			delta.add(new Transition(q2, q2, String.valueOf(i)));
		}

		return new FA(new Automaton(delta, states));
	}

	public static FA makeNegativeNumbersAutomaton() {

		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();

		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, true);
		State q3 = new State("q3", false, false);


		states.add(q0);
		states.add(q1);
		states.add(q2);
		states.add(q3);

		delta.add(new Transition(q0, q1, "+"));
		delta.add(new Transition(q0, q1, "-"));
		delta.add(new Transition(q1, q2, "0"));
		delta.add(new Transition(q0, q3, "-"));

		for (int i = 0; i < 10; i++) {
			delta.add(new Transition(q3, q2, String.valueOf(i)));
		}

		return new FA(new Automaton(delta, states));
	}

	public static FA makePositiveNumbersAutomaton() {
		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();

		State q0 = new State("q0", true, false);
		State q1 = new State("q1", false, false);
		State q2 = new State("q2", false, true);

		states.add(q0);
		states.add(q1);
		states.add(q2);

		delta.add(new Transition(q0, q1, "+"));

		for (int i = 0; i < 10; i++) {
			delta.add(new Transition(q0, q2, String.valueOf(i)));
			delta.add(new Transition(q1, q2, String.valueOf(i)));
			delta.add(new Transition(q2, q2, String.valueOf(i)));
		}

		return new FA(new Automaton(delta, states));
	}

	public Interval length() {

		if (getAutomaton().isSingleString())
			return new Interval(String.valueOf(getAutomaton().getSingleString().length()), String.valueOf(getAutomaton().getSingleString().length()));

		if (getAutomaton().hasCycle()) {

			HashSet<Integer> lengths = new HashSet<Integer>();

			for (State f : getAutomaton().getFinalStates()) 
				lengths.add(getAutomaton().minimumDijkstra(f).size() - 1);

			return new Interval(String.valueOf(getMinimumInteger(lengths)), "+Inf");

		} else {

			HashSet<Integer> lengths = new HashSet<Integer>();

			for (State f : getAutomaton().getFinalStates()) {
				lengths.add(getAutomaton().minimumDijkstra(f).size() - 1);
				lengths.add(getAutomaton().maximumDijkstra(f).size() - 1);
			}

			return new Interval(String.valueOf(getMinimumInteger(lengths)), String.valueOf(getMaximumInteger(lengths)));	
		}
	}

	private int getMinimumInteger(HashSet<Integer> set) {
		int min = Integer.MAX_VALUE;

		for (Integer i : set)
			if (i < min)
				min = i;

		return min;	
	}

	private int getMaximumInteger(HashSet<Integer> set) {
		int max = -1;

		for (Integer i : set)
			if (i > max)
				max = i;

		return max;	
	}

	public Interval indexOf(FA search) {

		if (getAutomaton().hasCycle())
			return new Interval("-1", "+Inf");

		Automaton build = getAutomaton().isSingleString() ? Automaton.makeRealAutomaton(getAutomaton().getSingleString()) : getAutomaton().clone();
		Automaton search_clone = search.getAutomaton().isSingleString() ? Automaton.makeRealAutomaton(search.getAutomaton().getSingleString()) : search.getAutomaton().clone();

		Automaton original = getAutomaton().isSingleString() ? Automaton.makeRealAutomaton(getAutomaton().getSingleString()) : getAutomaton().clone();
		
		HashSet<Integer> indexesOf = new HashSet<>();

		for (State s : build.getStates()) {
			if (s.isInitialState())
				s.setInitialState(false);
			s.setFinalState(true);
		}

		for (State q : build.getStates()) {
			q.setInitialState(true);

			if (!Automaton.isEmptyLanguageAccepted(Automaton.intersection(build, search_clone))) 
				indexesOf.add(original.maximumDijkstra(q).size() - 1);
			

			q.setInitialState(false);	
		}
		
		// No state in the automaton can read search
		if (indexesOf.isEmpty())
			return new Interval("-1", "-1");
		else if (search_clone.recognizesExactlyOneString() && original.recognizesExactlyOneString())
			return new Interval(String.valueOf(getMinimumInteger(indexesOf)), String.valueOf(getMinimumInteger(indexesOf)));
		else 
			return new Interval("-1", String.valueOf(getMaximumInteger(indexesOf)));

	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof FA)
			return getAutomaton().equals(((FA) other).getAutomaton());
		return false;
	}

	@Override
	public int hashCode() {
		return this.getAutomaton().hashCode();
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue value) {
		if (value instanceof FA) 
			return new FA(Automaton.intersection(getAutomaton(), ((FA) value).getAutomaton()));
		return new Bottom();
	}
	
	@Override
	public AbstractValue narrowing(AbstractValue value) {
		return clone();
	}
}
