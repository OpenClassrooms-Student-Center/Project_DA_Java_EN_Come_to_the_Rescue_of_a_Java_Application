package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * Anything that will write symptom data to a source The important part is, the
 * return value from the operation, which is a Map with a symptom/counting association
 * 
 * The implementation need to enable writing into the file.
 * 
 * 
 */

public interface ISymptomWriter {
	
	/**
	 * If no data is available to write into the file, return an empty list.
	 * 
	 * @param map of symptoms
	 * @return list of symptoms in alphabetical order to write in the file.
	 * @throws IOException
	 */

	public void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}
