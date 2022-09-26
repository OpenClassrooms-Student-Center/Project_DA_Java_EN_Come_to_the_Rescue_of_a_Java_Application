/**
 * 
 */
package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface Dao for the object SymptomCount
 * 
 * @see SymptomCount
 * @author trimok *
 */
public interface ISymptomCountDao {
	/**
	 * Save a list of symptom / count
	 * 
	 * @param SymptomCounts : the list of the symptom / count to save
	 * @return the number of written occurrences
	 */
	int saveAll(List<SymptomCount> SymptomCounts);
}
