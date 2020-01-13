package it.univr.domain.coalesced;
import org.junit.Assert;
import org.junit.Test;

import it.univr.domain.AbstractValue;
import it.univr.domain.coalasced.AbstractObject;
import it.univr.domain.coalasced.FA;
import it.univr.domain.coalasced.Interval;

import org.apache.commons.collections15.multimap.MultiHashMap;
public class NormalizationTest {
	
	@Test
	public void testNorm01() throws Exception{
		MultiHashMap<FA, AbstractValue> abstractObjectMap = new MultiHashMap<>();
		abstractObjectMap.put(new FA("s"), new Interval("1", "1"));
		//abstractObjectMap.put(new FA("s"), new Interval("1","2"));
		
//		MultiHashMap<FA, AbstractValue> tempAbstractObject = new MultiHashMap<>();
//		tempAbstractObject.put(new FA("s"), new Interval("1","2"));
		
		//AbstractObject abs1 = new AbstractObject(tempAbstractObject);
		System.out.print(new AbstractObject(abstractObjectMap).normalize().getAbstractObjectMap());
		//Assert.assertEquals(abs1, );
	}
}
