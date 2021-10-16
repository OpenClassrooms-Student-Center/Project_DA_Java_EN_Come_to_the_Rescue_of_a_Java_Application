package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will post process the symptom data result. This program will
 * create a new file and write in it all the results.
 */

public interface ISymptomPostProcesser {

	/**
	 * Write in a file
	 */
	void WriteToFile(Map<String, Integer> sortedSymptoms);
}
