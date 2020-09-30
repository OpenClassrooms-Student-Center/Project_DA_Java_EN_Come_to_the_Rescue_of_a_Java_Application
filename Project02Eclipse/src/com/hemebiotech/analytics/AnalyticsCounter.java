package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter implements Analytics{
	
	/** use a TreeMap to have the keys ordered by their lexicographic value. 
	 * This variable contain a dictionary of symptoms(key) associated to the amount of occurrence(value) found
	 * in the List analyzed.
	 */
	private Map<String, Integer> countedSymptoms = new TreeMap<>();
	
	/**
	 * countSymptoms iterate over the List used in parameter: if the key doesn't exist in 
	 * countedSymptoms, create it and set the value associated to 0, if the symptom already
	 * exist in countedSymptoms, increase the value associated to it by 1.
	 * 
	 * @param symptomsList is a list containing all the symptoms we are going to iterate over
	 */
	private void countSymptoms(List<String> symptomsList) {
		for (String symptom: symptomsList) {
			this.countedSymptoms.putIfAbsent(symptom, 0);
			this.countedSymptoms.put(symptom, countedSymptoms.get(symptom) + 1);
		}
	}

	/**
	 * Take a List and iterate over it to remove spaces and set all letters in lower case.
	 * It's purpose is to make sure we don't get different words to address the same symptom.
	 */
	private void cleanDatas(List<String> symptomsList) {
		symptomsList.replaceAll( string -> string.toLowerCase().replaceAll(" ", ""));
	}
	
	/**
	 * Analyze use the methods defined in AnalyticsCounter to analyze the data.
	 */
	public void analyze(List<String> symptomsList) {
		this.cleanDatas(symptomsList);
		this.countSymptoms(symptomsList);
	}
	
	/**
	 * This method return the dictionary of symptoms
	 */
	public Map<String, Integer> getAnalyzedSymptoms() {
		return this.countedSymptoms;
	}

}
