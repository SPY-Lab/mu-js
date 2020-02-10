package it.univr.main.coalesced;

import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.coalasced.Bottom;
import it.univr.domain.coalasced.CoalascedAbstractDomain;
import it.univr.domain.coalasced.Interval;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class CoalescedLookupObjectTest {
	
	private String dir = "src/test/resources/objects/";
	private CoalascedAbstractDomain domain = new CoalascedAbstractDomain();
	
	@Test
	public void testPropLookup001() throws Exception {
		String file = dir + "lookup001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("1", "1"));
	}
	
	@Test
	public void testPropLookup002() throws Exception {
		String file = dir + "lookup002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("y")), new Bottom());
		Assert.assertEquals(state.getValue(new Variable("z")), new Bottom());
	}
	
	@Test
	public void testPropLookup003() throws Exception {
		String file = dir + "lookup003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("y")), new Interval("1", "4"));
	}
	
	@Test
	public void testPropLookup004() throws Exception {
		String file = dir + "lookup004.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 2);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("z")), new Interval("1", "1"));
	}
}
