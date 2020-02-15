package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that write in output file a list of symptoms with there count 
 * @author MrgnCpn
 *
 */ 
public interface ISymptomWriter {
	
	/**
	 * Write method
	 * @param symptomsList, Map of symptoms
	 * @param firstLetterIsCapital, if the first letter of symptoms name is Uppercase
	 * @param alignStatement, if statements are align
	 */
	void writeSymptoms(Map<String, Integer> symptomsList, boolean firstLetterIsCapital, boolean alignStatement);
}
