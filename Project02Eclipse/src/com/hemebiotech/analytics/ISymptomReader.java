package com.hemebiotech.analytics;

import java.util.List;


/**
 * ISymptomReader interface defines the unique method GetSymptoms()
 * this interface is implmented in class ReadSymptomDataFromFile
 *
 * @author  Sébastien Vigé
 * @version 2.0
 * @since   2020-12-18
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	List<String> GetSymptoms ();
}
