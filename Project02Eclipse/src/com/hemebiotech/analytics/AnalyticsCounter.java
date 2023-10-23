package com.hemebiotech.analytics;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;
/**
 * Implements methods to treat the data (get, count, sort, and write)
 */
public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;
	/**
	 * @param reader is the object that gets the data file, and gets method to read it
	 * @param writer is the object that create the result file, and gets method to write
	 */
	public AnalyticsCounter(final ISymptomReader reader,final ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	/**
	 * @return the list of all the symptoms (with duplicate)
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}
	/**
	 * This method turns a list of String into a map, to count occurrences of a symptom in the list
	 * @param symptoms is the list of all the symptoms
	 * @return a map, with as keys the symptoms, and as values the number of times the symptom appears in the given list
	 */
	public Map<String, Integer> countSymptoms(final List<String> symptoms) {
		Map<String, Integer> result = new HashMap<>();
		for(int i=0; i<symptoms.size(); i++){
			String symptom = symptoms.get(i).toLowerCase();
			if (result.containsKey(symptom)){
				result.put(symptom, result.get(symptom)+1);
			} else {
				result.put(symptom, 1);
			}
		}
		return result;
	}
	/**
	 * Sort the map, using a TreeMap
	 * @param symptoms is a map. The keys are the symptoms, and the value the number of times the symptom appeared in data
	 * @return the map, lexicographically sorted
	 */
	public Map<String, Integer> sortSymptoms(final Map<String, Integer> symptoms) {
		TreeMap<String, Integer> sorted = new TreeMap<>(symptoms);
		return sorted;
	}
	/**
	 * Writes the symptoms and their count in the result file.
	 * @param symptoms is a map. The keys are the symptoms, and the value the number of times the symptom appeared in data
	 */
	public void writeSymptoms(final Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
