package it.univr.domain.coalesced;

import org.apache.commons.collections15.multimap.MultiHashMap;
import org.junit.Assert;
import org.junit.Before;
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

public class AbstractObjectVisitTest {

	private CoalascedAbstractDomain domain;
	private MultiHashMap<FA, AbstractValue> abstractObjectMap;
	private AbstractObject obj;
	
	@Before
	public void setUp() throws Exception {
		 domain = new CoalascedAbstractDomain();
		 abstractObjectMap = new MultiHashMap<>();
	}

	@Test
	public void testVisitAssigns001() throws Exception {
		String file = "src/test/resources/objects/assign01.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);
		
		obj = new AbstractObject(new FA("a"), new Interval("0", "0"));
		
		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 2);
		
		// State value
		AllocationSites sites = (AllocationSites) state.getValue(new Variable("h"));
		for (AllocationSite site: sites.getAllocationSites())
			Assert.assertEquals(obj, state.getHeap().get(site));
		
		abstractObjectMap.clear();
		abstractObjectMap.put(new FA("b"), new Interval("1", "1"));
		abstractObjectMap.put(new FA("c"), new Interval("2", "2"));
		abstractObjectMap.put(new FA("d"), new Interval("3", "3"));
		obj = new AbstractObject(abstractObjectMap);
		
		sites = (AllocationSites) state.getValue(new Variable("y"));
		for (AllocationSite site: sites.getAllocationSites())
			Assert.assertEquals(obj, state.getHeap().get(site));
	}
	
	@Test
	public void testVisitAssigns002() throws Exception {
		String file = "src/test/resources/objects/assign02.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);
		
		obj = new AbstractObject(new FA("a"), new Interval("0", "0"));
		AllocationSites sites = (AllocationSites) state.getValue(new Variable("a"));
		for (AllocationSite site: sites.getAllocationSites())
			Assert.assertEquals(obj, state.getHeap().get(site));
		
		obj = new AbstractObject(new FA("b"), new Interval("0", "0"));
		sites = (AllocationSites) state.getValue(new Variable("h"));
		for (AllocationSite site: sites.getAllocationSites())
			Assert.assertEquals(obj, state.getHeap().get(site));
		
		abstractObjectMap.clear();
		abstractObjectMap.put(new FA("o"), new Interval("0", "0"));
		abstractObjectMap.put(new FA("b"), new Interval("2", "2"));
		obj = new AbstractObject(abstractObjectMap);
		
		sites = (AllocationSites) state.getValue(new Variable("y"));
		for (AllocationSite site: sites.getAllocationSites())
			Assert.assertEquals(obj, state.getHeap().get(site));
		
	}
	
	@Test
	public void testVisitAssigns003() throws Exception {
		String file = "src/test/resources/objects/assign03.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);
		
		obj = new AbstractObject(new FA("a"), new Bool(1));
		AllocationSites sites = (AllocationSites) state.getValue(new Variable("a"));
		for (AllocationSite site: sites.getAllocationSites())
			Assert.assertEquals(obj, state.getHeap().get(site));
		
		abstractObjectMap.clear();
		abstractObjectMap.put(new FA("b"), new Bool(1));
		abstractObjectMap.put(new FA("c"), new FA("a"));
		obj = new AbstractObject(abstractObjectMap);
		
		sites = (AllocationSites) state.getValue(new Variable("h"));
		for (AllocationSite site: sites.getAllocationSites())
			Assert.assertEquals(obj, state.getHeap().get(site));
		
		abstractObjectMap.clear();
		abstractObjectMap.put(new FA("o"), new Bool(1));
		abstractObjectMap.put(new FA("b"), new Bool(0));
		obj = new AbstractObject(abstractObjectMap);
		
		sites = (AllocationSites) state.getValue(new Variable("y"));
		for (AllocationSite site: sites.getAllocationSites())
			Assert.assertEquals(obj, state.getHeap().get(site));
		
	}

}
