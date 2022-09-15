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
public class OrderSymptomes implements IOrderSymptom{

	public Map<String, Integer> mapSymptome;

	OrderSymptomes(Map<String, Integer> varMapSymptome) {
		this.mapSymptome = varMapSymptome;
	}

	public Map<String, Integer> order()// Map<String,Integer>
	{
		TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(this.mapSymptome);
		return sortedMap;
	}

}
