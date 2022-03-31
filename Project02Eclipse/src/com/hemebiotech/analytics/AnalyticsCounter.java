package com.hemebiotech.analytics;

/**
 *@author Fatima
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
	 * 
	 * @param symptomList : a raw listing of all Symptoms obtained from a data
	 *                    source, duplicates are possible/probable
	 *
	 */
	public AnalyticsCounter(List<String> symptomList) {
		this.symptomList = symptomList;
	}

	public AnalyticsCounter() {
	}

	/**
	 * 
	 * Setter : Method that sets value of symptomList
	 * 
	 * @param symptomList : a raw listing of all Symptoms obtained from a data
	 *                    source, duplicates are possible/probable
	 *
	 */
	public void setSymptomList(List<String> symptomList) {
		this.symptomList = symptomList;
	}

	/**
	 * 
	 * Getter: Method that returns value of symptomList
	 *
	 * @return List<String>, a raw listing of all Symptoms obtained from a data
	 *         source, duplicates are possible/probable
	 */
	public List<String> getSymptomList() {
		return symptomList;
	}

	/**
	 * 
	 * Method that calculate number of occurrence of a symptom from the list of
	 * symptoms
	 * 
	 * @return TreeMap <String, Long> that contains (key value)(key = symptom,
	 *         value= number of occurrences) sorted
	 */
	@Override
	public TreeMap<String, Long> getSymptomsOccurrences() {
		TreeMap<String, Long> counter = new TreeMap<String, Long>();
		if (symptomList != null && !symptomList.isEmpty())
			for (String symptom : symptomList) {
				counter.putIfAbsent(symptom, 0L);
				counter.put(symptom, counter.get(symptom) + 1);
			}
		else if (symptomList == null)
			System.out.println("Get symptoms occurrences: List of symptoms is null");
		else if (symptomList.isEmpty())
			System.out.println("Get symptoms occurrences: List of symptoms is empty");
		return counter;
	}
}
