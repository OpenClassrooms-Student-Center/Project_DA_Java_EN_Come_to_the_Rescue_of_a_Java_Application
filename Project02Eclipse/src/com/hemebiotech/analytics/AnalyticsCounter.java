package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class orchestrate reader and writer's classes
 *
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	/** Constructor 
	 * @param reader
	 * @param writer
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/** Get the list of symptoms
	 * @return list of symptoms
	 */
	public List<String> getSymptoms() {
		return this.reader.getSymptoms();
	}
	
	/** Counts symptoms
	 * @param symptoms : list of symptoms
	 * @return Map<String, Integer> 
	 * Keys are symptoms and values are ocurrences
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms){
		Map<String, Integer> countSymptoms = new HashMap<String, Integer>();
		for (String symptom : symptoms) {
			if (countSymptoms.containsKey(symptom)){
				int value = countSymptoms.get(symptom)+1;
				countSymptoms.put(symptom, value);
			} else 
				countSymptoms.put(symptom,1);
		}
		return countSymptoms;	
	}
	
	/** Sorts symptoms by alphabetical order
	 * @param symptoms : List of symptoms
	 * @return TreeMap<>(symptoms)
	 */
	public Map<String, Integer> sortSymptoms (Map<String, Integer> symptoms){
		return new TreeMap<>(symptoms);
	}
	
	/** Writes down symptoms into "result.out"
	 * @param symptoms : List of symptoms
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		this.writer.writeSymptoms(symptoms);
	}
}
