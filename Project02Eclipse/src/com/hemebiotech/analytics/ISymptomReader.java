package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;

/**
 * Anything that will read symptom data from a source
 * Return value from the operation, which is a list of strings, that may contain many duplications
 */

public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source,
	 *  duplicates are possible/probable
	 */
	List<String> GetSymptoms (String filename) throws IOException;
}
