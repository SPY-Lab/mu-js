package it.univr.domain.coalesced;

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

public class AbstractObjectVisitTest {

	private CoalascedAbstractDomain domain = new CoalascedAbstractDomain();

	@Test
	public void testVisitAssigns001() throws Exception {
		String file = "src/test/resources/objects/assign01.js";
		AbstractEnvironment state = Analyzer.analyze(file, domain, false);
		
		MultiHashMap<FA, AbstractValue> map = new MultiHashMap<>();
		map.put(new FA("a"), new Interval("0", "0"));
		AbstractObject obj = new AbstractObject(map);
		
		// State size
		Assert.assertEquals(state.sizeStore(), 2);
		Assert.assertEquals(state.sizeHeap(), 2);
		
		// State value
		AllocationSites sites = (AllocationSites) state.getValue(new Variable("h"));
		for (AllocationSite site: sites.getAllocationSites()) {
			Assert.assertEquals(obj, state.getHeap().get(site));
		}
		
		map = new MultiHashMap<>();
		map.put(new FA("b"), new Interval("1", "1"));
		map.put(new FA("c"), new Interval("2", "2"));
		map.put(new FA("d"), new Interval("3", "3"));
		obj = new AbstractObject(map);
		
		sites = (AllocationSites) state.getValue(new Variable("y"));
		for (AllocationSite site: sites.getAllocationSites()) {
			Assert.assertEquals(obj, state.getHeap().get(site));
		}
	}

}
