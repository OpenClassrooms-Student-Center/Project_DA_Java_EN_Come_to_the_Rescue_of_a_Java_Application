package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author alex
 * @version 1.0 1.read a list of symptoms from a file (1 symptom per line)
 *          2.sort the list (symptoms + occurrences) 3.save the sorted list
 */

public class AnalyticsCounter {
	/**
	 * @param path of the file containing the symptoms
	 * @param path of the file containing the result (ordered list)
	 */
	static final String symptomsInputFilePath = "Project02Eclipse/symptoms.txt";
	static final String symptomsOutputFilePath = "Project02Eclipse/results.out";

	public ArrayList<String> getSymptomList() {

		/**
		 * read data from a file (: 1 string per line) an add them one by one to a
		 * ArrayList
		 */
		ArrayList<String> symptomList = new ArrayList<String>();
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(symptomsInputFilePath);
		symptomList = reader.getSymptoms();

		return symptomList;
	}

	public TreeMap<String, Integer> getSymptomAndOccurrencesMap(ArrayList<String> symptomList) {

		/**
		 * convert an unordered ArrayList with duplications into TreeMap : keys :
		 * (ordered) list of symptoms, values : occurrences number of each symptoms
		 */

		TreeMap<String, Integer> symptomAndOccurrencesMap = new TreeMap<String, Integer>();
		SortSymptomFromArrayList sorter = new SortSymptomFromArrayList(symptomList);
		symptomAndOccurrencesMap = sorter.sortSymptom();

		return symptomAndOccurrencesMap;
	}

	public void saveAnalyticsCounter(TreeMap<String, Integer> symptomAndOccurrencesMap) {
		/**
		 * write (Key + ": " + Value) from a TreeMap to a file, one couple per line.
		 * (key : symptom name, value : occurrences number of the symptom)
		 */
		WriteSortedSymptomsToFile writer = new WriteSortedSymptomsToFile(symptomAndOccurrencesMap,
				symptomsOutputFilePath);
		writer.saveSortedSymptoms();
	}
}
