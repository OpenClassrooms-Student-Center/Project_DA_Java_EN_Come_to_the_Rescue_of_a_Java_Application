package com.hemebiotech.analytics;

import java.util.List;

/**
 * Defines the contract for reading symptom data from a data source
 * <p>
 * Implementations of this interface retrieve a raw list of symptoms
 *  <p>
 * Duplicate symptom names may be present in the returned list
 */

public interface ISymptomReader {
		
	/**
     * Returns the list of symptoms obtained from the data source
     * <p>
     * If no data is available, this method returns an empty list rather
     * than {@code null}
     *  <p>
     * The returned list may contain duplicate symptom names
     * <p>
     * @return a list of symptoms, or an empty list if no data is available
     */
	List<String> GetSymptoms ();
}
