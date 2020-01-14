package it.univr.domain.coalesced;

import org.junit.Test;

import it.univr.domain.AbstractValue;
import it.univr.domain.coalasced.AbstractObject;
import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;

import static org.junit.Assert.assertEquals;

import org.apache.commons.collections15.multimap.MultiHashMap;
public class NormalizationTest {
	
	@Test
	public void testNormalization001()  throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		abstractObjectMap.put(FA.union(new FA("a"), new FA("b")), new Interval("1", "2"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		
		obj.normalize();
	
		MultiHashMap<FA, AbstractValue> expcetedAbstractObjectMap = new MultiHashMap<>();
		expcetedAbstractObjectMap.put(new FA("a"), new Interval("1", "2"));
		expcetedAbstractObjectMap.put(new FA("b"), new Interval("1", "2"));
		
		AbstractObject expcetedObj = new AbstractObject(expcetedAbstractObjectMap);
		assertEquals(obj, expcetedObj);
	}
	
	@Test
	public void testNormalization002() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(new FA("a"), new Interval("5", "5"));
		abstractObjectMap.put(new FA("b"), new Interval("7", "7"));
		abstractObjectMap.put(FA.union(new FA("a"), new FA("b")), new Interval("1", "1"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		
		Interval expectedInterval = new Interval("1", "7");
		assertEquals(obj.lookupAbstractObject(new FA("b")), expectedInterval);
	}
	
	@Test
	public void testNormalization003() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(new FA("a"), new Interval("5", "5"));
		abstractObjectMap.put(new FA("b"), new Interval("7", "7"));
		abstractObjectMap.put(FA.union(new FA("a"), new FA("b")), new Interval("1", "1"));
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		System.out.println("original: "+obj);
		obj.normalize();
		System.out.println("normalized: "+obj);
	}
}
