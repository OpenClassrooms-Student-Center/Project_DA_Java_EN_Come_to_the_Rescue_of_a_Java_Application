package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Interface ISymptomWriter: Anything that will write symptoms and their
 * occurrence analyze from a list of symptoms to a file in the directory.
 */
public interface ISymptomWriter {
	
	/**
	 * exportSymptomsRate: method that will write symptoms to a "result.out" file in
	 * the working directory in the format:
	 * 
	 * <ul>
	 * <li>Symptom1: Occurrence of Symptom1</li>
	 * <li>Symptom2: Occurrence of Symptom2</li>
	 * <li>Symptom3: Occurrence of Symptom3</li>
	 * </ul>
	 * 
	 * duplications are not possible.
	 * 
	 * @param SymptomsRate
	 * 
	 */
public void writerSymptomsToFile(Map<String, Integer> symptomsRate, String fileToWrite);

}
