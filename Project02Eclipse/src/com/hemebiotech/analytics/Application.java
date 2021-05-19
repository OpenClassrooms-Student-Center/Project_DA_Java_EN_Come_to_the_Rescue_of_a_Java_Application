package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author alex
 * @version 1.0 runs 3 methods of getAnalyticsCounter: (1) read data from a file
 *          symptoms.txt (1 symptom per line) (2) sort the information to obtain
 *          a TreeMap (key: symptom name, value: occurrences number) (3) export
 *          the result to a file results.out
 */
public class Application {

	public static void main(String[] args) {
		AnalyticsCounter aCounters = new AnalyticsCounter();

		/**
		 * (1) read data from a file symptoms.txt (1 symptom per line)
		 */
		ArrayList<String> symptomList = new ArrayList<String>();
		symptomList = aCounters.getSymptomList();

		/**
		 * 2) sort the information to obtain a TreeMap (key: symptom name, value:
		 * occurrences number)
		 */
		TreeMap<String, Integer> symptomAndOccurrencesMap = new TreeMap<String, Integer>();
		symptomAndOccurrencesMap = aCounters.getSymptomAndOccurrencesMap(symptomList);

		/**
		 * (3) export the result to a file results.out
		 */
		aCounters.saveAnalyticsCounter(symptomAndOccurrencesMap);

	}

}
