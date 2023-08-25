package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * Constructor of the class AnalyticsCounter
	 *
	 * @param The Object of type ISymptomReader is used to read symptoms for a file
	 * @param The Object of type ISymptomWriter is used to write symptoms and occurence in a output file
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;

	}
	/**
	 * Read sympstoms.txt file and return the List of symptoms
	 *
	 * @return symptoms List
	 */
	public List<String> getSymptoms() {
		List<String> symptoms = reader.getSymptoms();
		return symptoms;
		}
	/**
	 * Count occurence of a symptom
	 *
	 * @param symptoms List
	 * @return symptoms K: symptom V: Occurence
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCountMap = new HashMap<String, Integer>();
//		classic loop
//		for(int symptom=0;symptom<symptoms.length;symptom++){}
//		for-each loop
		for (String symptom : symptoms) {
			boolean isSymptomAlreadyExists = symptomCountMap.containsKey(symptom);
			Integer count = 1;
			if (isSymptomAlreadyExists){
				count = symptomCountMap.get(symptom) + 1;
			}
			else{
			}
			symptomCountMap.put(symptom,count);
		}
		return symptomCountMap;
	}
	/**
	 * Sort symptoms Map with a TreeMap who's an Implementation of Map
	 *
	 * @param symptoms K: symptom V: Occurence
	 * @return TreeMap of symptoms
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}
	/**
	 * Call the method writeSymptoms from Interface ISymptomWriter
	 *
	 * @param symptoms K: symptom V: Occurence
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

}
