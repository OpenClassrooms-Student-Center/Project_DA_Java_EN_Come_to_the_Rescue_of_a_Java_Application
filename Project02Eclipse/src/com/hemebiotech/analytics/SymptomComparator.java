package com.hemebiotech.analytics;

import java.util.Comparator;
import java.util.Map;

/**
 * allows to order the map
 * 
 * @author Fatima
 * 
 *
 */
public class SymptomComparator implements Comparator<String> {
	private Map<String, Integer> base;

	public SymptomComparator(Map<String, Integer> base) {
		this.base = base;
	}

	/**
	 * compare the value field to put it in ascending order.
	 */
	@Override
	public int compare(String a, String b) {

		if (base.get(a) >= base.get(b)) {
			return 1;
		} else {
			return -1;
		}

	}
}
