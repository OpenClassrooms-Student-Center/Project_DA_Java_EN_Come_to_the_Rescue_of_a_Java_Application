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
 * les symptomes par ordre alphabétique
 */
public class OrderSymptomes implements IOrderSymptom {

	/**
	 * @return renvoie une map ordonner dont les clés sont les symptomes et les
	 *         valeurs sont le nombre d'occurance de ces symptomes
	 * @param une map de symptome non ordonner
	 */
	public Map<String, Integer> order(Map<String, Integer> mapSymptome) {
		TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(mapSymptome);
		return sortedMap;
	}

}
