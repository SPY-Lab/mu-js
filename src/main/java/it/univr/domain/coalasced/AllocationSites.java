package it.univr.domain.coalasced;

import java.util.HashSet;

import it.univr.domain.AbstractValue;
import it.univr.domain.AllocationSite;

public class AllocationSites implements AbstractValue {

	private HashSet<AllocationSite> sites;

	public AllocationSites clone() {
		return new AllocationSites((HashSet<AllocationSite>) sites.clone());
	}

	public AllocationSites() {
		this.sites = new HashSet<AllocationSite>();
	}
	
	public AllocationSites(AllocationSite ... ls) {
		this.sites = new HashSet<AllocationSite>();
		for (AllocationSite l : ls)
			sites.add(l);
	}

	public AllocationSites(HashSet<AllocationSite> s) {
		this.sites = s;
	}

	public HashSet<AllocationSite> getAllocationSites() {
		return sites;
	}

	public void setaAllocationSites(HashSet<AllocationSite> sites) {
		this.sites = sites;
	}

	@Override
	public AbstractValue leastUpperBound(AbstractValue other) {
		if (other instanceof AllocationSites) {
			HashSet<AllocationSite> s = new HashSet<AllocationSite>();

			for (AllocationSite l : sites)
				s.add(l.clone());

			for (AllocationSite l : ((AllocationSites) other).getAllocationSites())
				s.add(l.clone());

			return new AllocationSites(s);
		}

		return new Top();
	}

	@Override
	public AbstractValue widening(AbstractValue other) {
		return leastUpperBound(other);
	}

	@Override
	public AbstractValue greatestLowerBound(AbstractValue other) {
		if (other instanceof AllocationSites) {
			HashSet<AllocationSite> s = new HashSet<AllocationSite>();

			for (AllocationSite l : sites)
				if (((AllocationSites) other).containsSite(l))
					s.add(l.clone());

			return new AllocationSites(s);
		}

		return new Top();
	}

	public boolean containsSite(AllocationSite l) {
		return sites.contains(l);
	}

	public int size() {
		return sites.size();
	}

	public boolean isEmpty() {
		return sites.isEmpty();
	}

	@Override
	public AbstractValue narrowing(AbstractValue value) {
		return greatestLowerBound(value);
	}

	@Override
	public String toString() {

		if (isEmpty())
			return "{}";

		String result = "{";

		for (AllocationSite l : sites) 
			result += l.toString() + ","; 		

		return result.substring(0, result.lastIndexOf(",")) + "}";
	}

	@Override
	public int hashCode() {
		return sites.hashCode();
	}

	@Override
	public boolean equals(Object other) {

		if (other instanceof AllocationSites) {

			if (size() != ((AllocationSites) other).size())
				return false;

			for (AllocationSite l : sites)
				if (!((AllocationSites) other).containsSite(l))
					return false;

			return true;
		}

		return false;
	}
	


	@Override
	public AbstractValue juggleToNumber() {
		return new Bottom(); 
	}

	@Override
	public AbstractValue juggleToString() {
		return new Bottom(); 

	}

	@Override
	public AbstractValue juggleToBool() {
		return new Bottom(); 
	}

}
