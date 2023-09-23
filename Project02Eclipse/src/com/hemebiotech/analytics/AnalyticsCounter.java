package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The AnalyticsCounter class is responsible for processing and analyzing
 * symptoms data.
 */
public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * Constructs an AnalyticsCounter object with a symptom reader and a symptom
	 * writer.
	 *
	 * @param reader The symptom reader to read symptom data from a data source.
	 * @param writer The symptom writer to write analyzed data to a data source.
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Retrieves a list of symptoms from the data source.
	 *
	 * @return A list of symptoms read from the data source.
	 * @throws Exception If an error occurs while reading the data source.
	 */
	public List<String> getSymptoms() throws Exception {
		return this.reader.getSymptoms();
	}

	/**
	 * Counts the frequency of each symptom in the provided list.
	 *
	 * @param symptoms A list of symptoms to count.
	 * @return A map containing symptoms as keys and their frequencies as values.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> countMap = new HashMap<>();

		for (String symptom : symptoms) {
			countMap.computeIfAbsent(symptom, s -> 0);
			countMap.put(symptom, countMap.get(symptom) + 1);
		}

		return countMap;
	}

	/**
	 * Sorts the symptoms and their frequencies alphabetically.
	 *
	 * @param symptoms A map containing symptoms as keys and their frequencies as
	 *                 values.
	 * @return A sorted map with symptoms sorted alphabetically.
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	/**
	 * Writes the analyzed symptom data to a data source.
	 *
	 * @param symptoms A map containing symptoms as keys and their frequencies as
	 *                 values.
	 * @throws Exception If an error occurs while writing the symptoms.
	 * 
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) throws Exception {
		this.writer.writeSymptoms(symptoms);
	}
}
