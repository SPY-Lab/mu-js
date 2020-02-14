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

public class CoalescedObjectWideningTest {
	private String dir = "src/test/resources/objects/widening/";
	private CoalascedAbstractDomain domain = new CoalascedAbstractDomain();
	
	@Test
	public void testObjectWidening001() throws Exception {
		String file = dir + "widening001.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain).getAbstractEnvironmentAtMainCallString();
		
		MultiHashMap<FA, AbstractValue> properties = new MultiHashMap<>();
		properties.put(new FA("a"), new Interval("1", "+Inf"));
		AbstractObject oObject = new AbstractObject(properties);
		
		AllocationSite oSite = new AllocationSite(1,0);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 1);
		Assert.assertEquals(state.sizeHeap(), 1);
		
		// Store values
		Assert.assertEquals(state.getValue(new Variable("o")), new AllocationSites(oSite));
		
		// Heap value
		Assert.assertEquals(state.getValue(oSite), oObject);
	}
		
}
