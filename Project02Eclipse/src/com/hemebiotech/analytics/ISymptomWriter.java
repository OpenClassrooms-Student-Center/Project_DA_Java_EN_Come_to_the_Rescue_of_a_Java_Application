package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
	
	/** Writes down symptoms into "result.out"
	 * @param symptoms : List of symptoms
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);
	
}
