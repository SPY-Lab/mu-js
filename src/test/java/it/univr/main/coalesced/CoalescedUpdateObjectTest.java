package it.univr.main.coalesced;

import org.apache.commons.collections15.multimap.MultiHashMap;
import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.AbstractValue;
import it.univr.domain.AllocationSite;
import it.univr.domain.coalasced.AbstractObject;
import it.univr.domain.coalasced.AllocationSites;
import it.univr.domain.coalasced.Bool;
import it.univr.domain.coalasced.CoalascedAbstractDomain;
import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;
import it.univr.main.Analyzer;
import it.univr.state.AbstractEnvironment;
import it.univr.state.Variable;

public class CoalescedUpdateObjectTest {
	
	private String dir = "src/test/resources/objects/";
	private CoalascedAbstractDomain domain = new CoalascedAbstractDomain();
	
	@Test
	public void testPropUpdate001() throws Exception {
		String file = dir + "update001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("a"), new Interval("1", "1"));
		properties.put(new FA("b"), new Interval("2", "3"));
		AbstractObject object = new AbstractObject(properties);
		
		AllocationSite site = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("x")), new AllocationSites(site));
		
		// Heap value
		Assert.assertEquals(state.getValue(site), object);
	}
	
	@Test
	public void testPropUpdate002() throws Exception {
		String file = dir + "update002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("a"), new Interval("1", "1"));
		properties.put(new FA("b"), new Interval("2", "4"));
		AbstractObject object = new AbstractObject(properties);
		
		AllocationSite site = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("x")), new AllocationSites(site));
		
		// Heap value
		Assert.assertEquals(state.getValue(site), object);
	}
	
	@Test
	public void testPropUpdate003() throws Exception {
		String file = dir + "update003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("a"), new Bool(1));
		properties.put(new FA("b"), new Bool(1));
		AbstractObject object = new AbstractObject(properties);
		
		AllocationSite site = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("x")), new AllocationSites(site));
		
		// Heap value
		Assert.assertEquals(state.getValue(site), object);
	}
	
	@Test
	public void testPropUpdate004() throws Exception {
		String file = dir + "update004.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("a"), new Interval("1", "1"));
		AbstractObject object = new AbstractObject(properties);
		
		AllocationSite site = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("x")), new AllocationSites(site));
		Assert.assertEquals(state.getValue(new Variable("y")), new AllocationSites(site));
		
		// Heap value
		Assert.assertEquals(state.getValue(site), object);
	}
}
