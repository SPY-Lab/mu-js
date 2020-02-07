package it.univr.main.coalesced;

import org.apache.commons.collections15.multimap.MultiHashMap;
import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.AbstractValue;
import it.univr.domain.AllocationSite;
import it.univr.domain.coalasced.AbstractObject;
import it.univr.domain.coalasced.AllocationSites;
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
	public void testObjectAssing001() throws Exception {
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
