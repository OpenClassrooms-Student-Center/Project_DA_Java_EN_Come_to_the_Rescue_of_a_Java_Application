package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author AMP2024
 * @version
 * 
 *          Class containing methods for counting symptoms and sorting them
 *          alphabetically. Uses a ISymptomReader object and its getSymptom()
 *          method and an ISymptomWriter object and its writeSymptom() method.
 */
public class AnalyticsCounter {

	ISymptomReader reader;
	ISymptomWriter writer;

	Map<String, Integer> symptomsMap = new HashMap<String, Integer>();

	List<String> unsortedList = new ArrayList<String>();

	/**
	 * @param reader an IsymptomReader object which allows you to read the file
	 *               containing the list of symptoms
	 * @param writer an IsymptomWriter object which allows you to write a file
	 *               containing the list of symptoms and their number of occurrences
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {

		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * 
	 * Used to get the raw list of symptoms from the symptoms.txt file and make a
	 * list that is returned
	 * 
	 * @return List<String> A list containing the raw list of symptoms
	 * 
	 */
	public List<String> getSymptoms() {

		return reader.getSymptoms();

	}

	/**
	 * Used to write to a file the list of symptoms sorted and their number of
	 * occurrences using the object writer and its writeSymptoms() method
	 * 
	 * @param symptoms A Map containing the list of symptoms sorted as keys in
	 *                 strings and their occurrences as values in integers
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {

		writer.writeSymptoms(symptoms);

	}

	/**
	 * Used to count symptoms. Takes as parameter the raw list of symptoms and
	 * counts the number of occurrences of each symptom then returns a Map
	 * containing the list of symptoms and their number of occurrences.
	 *
	 * @param symptoms A list containing the raw list of symptoms
	 * @return Map<String, Integer> Returns a Map containing the list of symptoms
	 *         and their number of occurrences
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {

		Map<String, Integer> listOfSymptoms = new HashMap<String, Integer>();

		for (String entry : symptoms) {
			if (listOfSymptoms.containsKey(entry)) {

				int symptomCounter = listOfSymptoms.get(entry) + 1;

				listOfSymptoms.put(entry, symptomCounter);
			}

			else {

				listOfSymptoms.put(entry, 1);
			}

		}
		return listOfSymptoms;
	}

	/**
	 * Used to sort the symptom list by copying the Map containing the symptom list
	 * into a TreeMap. By default, TreeMap sorts all its entries according to their
	 * natural ordering. For an integer, this would mean ascending order and for
	 * strings, alphabetical order.
	 *
	 * @param symptoms The Symptoms and their values ​​stored in a Map
	 * @return Map<String, Integer> Returns a Map containing the list of symptoms
	 *         sorted alphabetically and their number of occurrences
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {

		Map<String, Integer> sortedList = new TreeMap<String, Integer>();

		for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {

			sortedList.put(entry.getKey(), entry.getValue());
		}

		return sortedList;

	}

}
