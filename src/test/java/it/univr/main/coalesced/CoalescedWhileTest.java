package it.univr.main.coalesced;


import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.CoalascedAbstractDomain;
import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.fsm.machine.Automaton;
import it.univr.fsm.machine.State;
import it.univr.fsm.machine.Transition;
import it.univr.main.Analyzer;
import it.univr.state.AbstractMemory;
import it.univr.state.Variable;

public class CoalescedWhileTest {

	private CoalascedAbstractDomain domain = new CoalascedAbstractDomain();

	@Test
	public void testWhile001() throws Exception {
		String file = "src/test/resources/while/while001.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 1);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("100", "100"));
	}

	@Test
	public void testWhile002() throws Exception {
		String file = "src/test/resources/while/while002.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		HashSet<State> states = new HashSet<State>();
		HashSet<Transition> delta = new HashSet<Transition>();

		State q0 = new State("q0", true, true);

		states.add(q0);

		delta.add(new Transition(q0, q0, "a"));

		// a^* 
		Automaton a = new Automaton(delta, states);

		// State size
		Assert.assertEquals(state.size(), 1);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new FA(a));
	}

	@Test
	public void testWhile003() throws Exception {
		String file = "src/test/resources/while/while003.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 1);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new FA(Automaton.makeEmptyString()));
	}

	@Test
	public void testWhile004() throws Exception {
		String file = "src/test/resources/while/while004.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 1);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("0", "0"));
	}	

	@Test
	public void testWhile005() throws Exception {
		String file = "src/test/resources/while/while005.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 2);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("100", "100"));
	}


	@Test
	public void testWhile006() throws Exception {
		String file = "src/test/resources/while/while006.js";
		AbstractMemory state = Analyzer.analyze(file, domain, true);

		// State size
		Assert.assertEquals(state.size(), 2);

		// State values
		Assert.assertEquals(state.getValue(new Variable("x")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("100", "101"));
	}
}
