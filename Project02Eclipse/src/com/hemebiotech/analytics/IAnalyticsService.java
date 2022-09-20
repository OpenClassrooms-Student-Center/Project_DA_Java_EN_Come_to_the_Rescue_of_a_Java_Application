/**
 * 
 */
package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface for analytics services
 * 
 * @author trimok
 *
 */
public interface IAnalyticsService {
	/**
	 * Read symptoms, count the number of occurrences for each symptom, and save
	 * results (symptom / count)
	 * 
	 * @return the number of symptoms/count
	 */
	int doSymptomCountAnalysis();

	/**
	 * Read the symptoms in the source
	 * 
	 * @return the list of symptoms read in the source
	 */
	List<Symptom> findAllSymptoms();

	/**
	 * Calculate the count for each symptom, and return an ordered (by symptom name)
	 * list of symptom / count
	 * 
	 * @param symptoms : the list of symptoms
	 * @return : the list of symptom / count
	 */
	List<SymptomCount> countSymptoms(List<Symptom> symptoms);

	/**
	 * Save the list of symptom / count
	 * 
	 * @param symptomCounts : the list of system / count to save
	 * @return the number of written occurrences
	 */
	int saveAllSymptomCounts(List<SymptomCount> symptomCounts);
}
