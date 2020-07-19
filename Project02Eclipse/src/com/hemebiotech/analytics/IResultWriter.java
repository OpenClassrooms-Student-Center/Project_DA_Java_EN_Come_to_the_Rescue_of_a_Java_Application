package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;

/**
 * Allows processing of symptoms data and writes out analyzed data in a file.
 * 
 * @author Yassine PAYET
 */
public interface IResultWriter {
	/**
	 * Creates a map of an existing map to synch up data and overcome thread
	 * safety.<br/>
	 * Writes in a result file the processed symptom data.<br/>
	 * 
	 * 
	 * @param mapSymptom
	 * @param sympList
	 * @throws IOException
	 */

	public static void writeResult(Map<String, Integer> mapSymptom, List<String> sympList)
			throws IOException, NullPointerException, ConcurrentModificationException {
	}
}
