package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

/**
 * This interface defines the method for writing symptoms to a data source.
 */
public interface ISymptomWriter {
	/**
	 * Writes symptoms and their frequencies to the specified data source.
	 *
	 * @param symptoms An object of type Map where keys are symptoms and values are
	 *                 their frequencies.
	 * @throws Exception An exception may be thrown if an error occurs during the
	 *                   writing of symptoms to the data source.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}
