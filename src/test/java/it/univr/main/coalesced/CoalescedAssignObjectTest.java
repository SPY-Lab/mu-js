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

public class CoalescedAssignObjectTest {

	private String dir = "src/test/resources/objects/";
	private CoalascedAbstractDomain domain = new CoalascedAbstractDomain();

	@Test
	public void testVisitAssigns001() throws Exception {
		String file = dir + "assign001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);
		System.out.println(state);
		AbstractObject hObject = new AbstractObject(new FA("a"), new Interval("0", "0"));
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("b"), new Interval("1", "1"));
		properties.put(new FA("c"), new Interval("2", "2"));
		properties.put(new FA("d"), new Interval("3", "3"));
		AbstractObject yObject = new AbstractObject(properties);

		AllocationSite hSite = new AllocationSite(1,0);
		AllocationSite ySite = new AllocationSite(2,0);

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 2);

		// Store values
		Assert.assertEquals(state.getValue(new Variable("h")), new AllocationSites(hSite));
		Assert.assertEquals(state.getValue(new Variable("y")), new AllocationSites(ySite));

		// Heap value
		Assert.assertEquals(state.getValue(hSite), hObject);
		Assert.assertEquals(state.getValue(ySite), yObject);
	}

	@Test
	public void testVisitAssigns002() throws Exception {
		String file = dir + "assign002.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		AbstractObject aObject = new AbstractObject(new FA("a"), new Interval("0", "0"));
		AbstractObject hObject = new AbstractObject(new FA("b"), new Interval("0", "0"));
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<FA, AbstractValue>();
		properties.put(new FA("o"), new Interval("0", "0"));
		properties.put(new FA("b"), new Interval("2", "2"));
		AbstractObject yObject = new AbstractObject(properties);

		AllocationSite aSite = new AllocationSite(1,0);
		AllocationSite hSite = new AllocationSite(2,0);	
		AllocationSite ySite = new AllocationSite(3,0);	

		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 3);

		// Store values
		Assert.assertEquals(state.getValue(new Variable("a")), new AllocationSites(aSite));
		Assert.assertEquals(state.getValue(new Variable("h")), new AllocationSites(hSite));
		Assert.assertEquals(state.getValue(new Variable("y")), new AllocationSites(ySite));

		// Heap value
		Assert.assertEquals(state.getValue(aSite), aObject);
		Assert.assertEquals(state.getValue(hSite), hObject);
		Assert.assertEquals(state.getValue(ySite), yObject);
	}

	@Test
	public void testVisitAssigns003() throws Exception {
		String file = dir + "assign003.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		AbstractObject aObject = new AbstractObject(new FA("a"), new Bool(1));
		MultiHashMap<FA, AbstractValue> hProperties = new MultiHashMap<FA, AbstractValue>();
		hProperties.put(new FA("b"), new Bool(1));
		hProperties.put(new FA("c"), new FA("a"));
		AbstractObject hObject = new AbstractObject(hProperties);
		MultiHashMap<FA, AbstractValue> yProperties = new MultiHashMap<FA, AbstractValue>();
		yProperties.put(new FA("o"), new Bool(1));
		yProperties.put(new FA("b"), new Bool(0));
		AbstractObject yObject = new AbstractObject(yProperties);

		
		AllocationSite aSite = new AllocationSite(1,0);
		AllocationSite hSite = new AllocationSite(2,0);	
		AllocationSite ySite = new AllocationSite(3,0);	
		
		// State size
		Assert.assertEquals(state.sizeStore(), 3);
		Assert.assertEquals(state.sizeHeap(), 3);

		// Store values
		Assert.assertEquals(state.getValue(new Variable("a")), new AllocationSites(aSite));
		Assert.assertEquals(state.getValue(new Variable("h")), new AllocationSites(hSite));
		Assert.assertEquals(state.getValue(new Variable("y")), new AllocationSites(ySite));

		// Heap value
		Assert.assertEquals(state.getValue(aSite), aObject);
		Assert.assertEquals(state.getValue(hSite), hObject);
		Assert.assertEquals(state.getValue(ySite), yObject);
	}
	
	@Test
	public void testObjectAssign004() throws Exception {
		String file = dir + "assign004.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);

		AbstractObject trueObj = new AbstractObject(new FA("a"), new Interval("1", "1"));
		AbstractObject falseObj = new AbstractObject(new FA("a"), new Interval("2", "2"));

		AllocationSite trueSite = new AllocationSite(7,1);
		AllocationSite falseSite = new AllocationSite(9,1);	

		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 2);

		// Store values
		Assert.assertEquals(state.getValue(new Variable("i")), new Interval("0", "+Inf"));
		Assert.assertEquals(state.getValue(new Variable("x")), new AllocationSites(trueSite, falseSite));

		// Heap value
		Assert.assertEquals(state.getValue(trueSite), trueObj);
		Assert.assertEquals(state.getValue(falseSite), falseObj);
	}
}
