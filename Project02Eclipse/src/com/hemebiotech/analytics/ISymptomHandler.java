package com.hemebiotech.analytics;

import java.io.IOException;

public interface ISymptomHandler {
	
	/**
	 * if no data available do nothing
	 * if data are available count and sort by alphabetic order
	 * 
	 */
	void countAndSortEachSymptom();

	/**
	 * @param path a full or partial path to file with symptom strings in it, one per line
	 * 
	 * create a file with the data sorted in counAndSortEachSymptom
	 */
	void CreateSortedFile(String path) throws IOException;

}
