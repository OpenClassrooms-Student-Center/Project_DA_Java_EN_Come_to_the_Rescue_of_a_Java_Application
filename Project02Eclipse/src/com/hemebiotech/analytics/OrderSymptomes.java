/**
 * 
 */
package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author massine classifier les symptomes par ordre alphabétique
 */
public class OrderSymptomes {

	public Map<String, Integer> mapSymptome;

	OrderSymptomes(Map<String, Integer> varMapSymptome) {
		this.mapSymptome = varMapSymptome;
	}

	public Map<String, Integer> ordre()// Map<String,Integer>
	{
		Map<String, Integer> newMapOrdonner = new HashMap<>();
		TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(this.mapSymptome);// on peut pas parcourrir
																							// une map

		Set<Entry<String, Integer>> set = sortedMap.entrySet();// convertire la map en set grace a entrySet

		Iterator<Entry<String, Integer>> iterator = set.iterator();

		while (iterator.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry me = (Map.Entry) iterator.next();
			newMapOrdonner.put((String) me.getKey(), (Integer) me.getValue());
		}
		return newMapOrdonner;
	}

}
