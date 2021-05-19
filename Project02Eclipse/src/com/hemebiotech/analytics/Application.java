package com.hemebiotech.analytics;

/**
 * @author alex
 * @version 1.0 runs getAnalyticsCounter: (1) read data from a file symptoms.txt
 *          (1 symptom per line) (2) sort the information to obtain a TreeMap
 *          (key: symptom name, value: occurrences number) (3) export the result
 *          to a file results.out
 */
public class Application {

	public static void main(String[] args) {
		AnalyticsCounter aCounters = new AnalyticsCounter();
		aCounters.getAnalyticsCounter();

	}

}
