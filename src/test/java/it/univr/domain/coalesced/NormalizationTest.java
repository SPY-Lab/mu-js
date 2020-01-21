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
	public void testNormalization001() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(FA.union(new FA("a"), new FA("b")), new Interval("1", "2"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
	
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("1", "2"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("1", "2"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(obj, expectedObj);
	}
	
	@Test
	public void testNormalization002() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(new FA("a"), new Interval("2", "4"));
		abstractObjectMap.put(FA.union(new FA("a"), new FA("b")), new Interval("3", "6"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("2", "6"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("3", "6"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(obj, expectedObj);
	}

	@Test
	public void testNormalization003() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(new FA("a"), new Interval("5", "5"));
		abstractObjectMap.put(new FA("b"), new Interval("7", "7"));
		abstractObjectMap.put(FA.union(new FA("a"), new FA("b")), new Interval("1", "1"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("1", "5"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("1", "7"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(obj, expectedObj);
	}
	
	@Test
	public void testNormalization004() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(FA.union(new FA("a"), new FA("b")), new Interval("1", "2"));
		abstractObjectMap.put(FA.union(new FA("a"), new FA("c")), new Interval("4", "5"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("1", "5"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("1", "2"));
		expectedAbstractObjectMap.put(new FA("c"), new Interval("4", "5"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(obj, expectedObj);
	}
	
	@Test
	public void testNormalization005() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(FA.union(new FA("a"), new FA("b")), new Interval("1", "3"));
		abstractObjectMap.put(FA.union(new FA("a"), new FA("c")), new Interval("6", "6"));
		abstractObjectMap.put(FA.union(new FA("b"), new FA("c")), new Interval("5", "8"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("1", "6"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("1", "8"));
		expectedAbstractObjectMap.put(new FA("c"), new Interval("5", "8"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(obj, expectedObj);
	}
	
	@Test
	public void testNormalization006() throws Exception {
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		
		abstractObjectMap.put(FA.union(new FA("a"), FA.union(new FA("b"), new FA("c"))), new Interval("3", "3"));
		abstractObjectMap.put(FA.union(new FA("b"), new FA("c")), new Interval("4", "4"));
		abstractObjectMap.put(new FA("c"), new Interval("5", "5"));
		
		AbstractObject obj = new AbstractObject(abstractObjectMap);
		obj.normalize();
		
		MultiHashMap<FA, AbstractValue> expectedAbstractObjectMap = new MultiHashMap<>();
		expectedAbstractObjectMap.put(new FA("a"), new Interval("3", "3"));
		expectedAbstractObjectMap.put(new FA("b"), new Interval("3", "4"));
		expectedAbstractObjectMap.put(new FA("c"), new Interval("3", "5"));
		
		AbstractObject expectedObj = new AbstractObject(expectedAbstractObjectMap);
		assertEquals(obj, expectedObj);
	}
}
