package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides symptom data stored in memory
 * <p>
 * This class implements the {@code ISymptomReader} interface and returns
 * a predefined list of symptoms. It is mainly intended for testing or
 * demonstration purposes
 */

public class ReadSymptomDataFromMemory implements ISymptomReader {
	
	/**
     * Returns the list of symptoms stored in memory
     * <p>
     * @return a list of symptom names
     */
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		result.add("fievre");
		result.add("saignement");
		result.add("hematome");
		result.add("fievre");
		return result;
	}
}
