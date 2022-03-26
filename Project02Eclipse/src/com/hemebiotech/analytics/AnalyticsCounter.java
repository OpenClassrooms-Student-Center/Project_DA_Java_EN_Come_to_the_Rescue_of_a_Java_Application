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

	/**
	 * Constructor
	 * 
	 * @param List of String : symptoms not ordered
	 * 
	 */
	public AnalyticsCounter(List<String> symptomList) {
		this.symptomList = symptomList;
	}

	public AnalyticsCounter() {
	}

	public void setSymptomList(List<String> symptomList) {
		this.symptomList = symptomList;
	}

	public List<String> getSymptomList() {
		return symptomList;
	}

	/**
	 * 
	 * Method that calculate number of occurrence of a symptom from the list of
	 * symptoms
	 * 
	 * @return TreeMap <String, Long> that contains (key value)(key = symptom,
	 *         value= number of occurrence) sorted
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
