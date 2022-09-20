package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface Dao for the object Symptom
 * 
 * @see Symptom
 * @author trimok
 */
public interface ISymptomDao {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a list of all Symptom obtained from a data source, duplicates names
	 *         are possible/probable
	 */
	List<Symptom> findAll();
}
