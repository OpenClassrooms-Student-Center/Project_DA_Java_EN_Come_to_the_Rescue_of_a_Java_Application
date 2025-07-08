package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * Anything that will write symptom data to a source The important part is, the
 * return value from the operation, which is a Map with a key/value association
 * 
 * String as key, Count as value
 * 
 * 
 */
public interface ISymptomWriter {
	/**
	 * 
	 * 
	 * @return
	 * @throws IOException
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}
