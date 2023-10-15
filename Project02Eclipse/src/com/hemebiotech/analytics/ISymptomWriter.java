package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface which allows you to write the sorted list of symptoms and their
 * number of occurrences in a "result.out" file.
 */
public interface ISymptomWriter {

	/**
	 * @param symptoms A Map containing the list of symptoms sorted as keys in
	 *                 strings and their occurrences as values in integers
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);

}
