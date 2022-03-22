package com.hemebiotech.analytics;

/**
 * 
 *@author Fatima
 *
 */
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class AnalyticsCounter implements IAnalyticsCounter {

	private List<String> symptomList = new ArrayList<>();

	public AnalyticsCounter(List<String> symptomList) {
		this.symptomList = symptomList;
	}

	/**
	 * 
	 * Method that calculate number of occurrence of a symptom from the list of
	 * symptoms
	 * 
	 * @return HashMap <String, Long> that contains (key value), key = symptom,
	 *         value= number of occurrence
	 * @param not need a parameter
	 *
	 */
	@Override
	public TreeMap<String, Long> getSymptomsOccurences() {
		TreeMap<String, Long> counter = new TreeMap<String, Long>();
		for (String symptom : symptomList) {
			counter.putIfAbsent(symptom, 0L);
			counter.put(symptom, counter.get(symptom) + 1);
		}

		return counter;
	}
}
