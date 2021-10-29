package com.hemebiotech.analytics;

import java.util.Map;

/**
 * write symptoms in any data support
 * 
 * @author Fatima
 * @see ISymptomReader
 * @see ISymptomsDataProcessing
 * @see ISymptomWriter
 */
public interface ISymptomWriter {
	/**
	 * write the contents of the Map in data support
	 * 
	 * @param symptomMap Map with symptom in the key field and its frequency in the
	 *                   value field.
	 * @see ISymptomsDataProcessing#symptomsCounter(java.util.List)
	 * @see ISymptomsDataProcessing#sortedSymptoms(Map, java.util.Comparator)
	 */

	public void writeSymptomsData(Map<String, Integer> symptomMap);

}
