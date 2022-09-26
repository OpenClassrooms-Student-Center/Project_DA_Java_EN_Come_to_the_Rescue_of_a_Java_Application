/**
 * 
 */
package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Analytics service, provides analytic features
 * 
 * @see IAnalyticsService
 * @author trimok
 *
 */
public class AnalyticsService implements IAnalyticsService {
	/**
	 * The data acesss object factory
	 */
	private IDaoFactory daoFactory = DaoFileFactory.getFactory();

	/**
	 * Read symptoms, count the number of occurrences for each symptom, and save
	 * results (symptom / count)
	 */
	@Override
	public int doSymptomCountAnalysis() {

		// Find the symptoms
		List<Symptom> symptoms = findAllSymptoms();

		// Count the number of occurrences for each symptom
		List<SymptomCount> symptomCounts = countSymptoms(symptoms);

		// Save symptom / count
		return saveAllSymptomCounts(symptomCounts);
	}

	/**
	 * Read the list of symptoms in the source
	 * 
	 * @return the list of symptoms read in the source
	 */
	@Override
	public List<Symptom> findAllSymptoms() {
		ISymptomDao symptomDao = daoFactory.getSymptomDao();
		List<Symptom> symptoms = symptomDao.findAll();

		Logger.log(String.format("Total number of read symptoms occurrences (including duplicates) : %d",
				symptoms.size()));
		return symptoms;
	}

	/**
	 * Save the list of symptom / count
	 * 
	 * @param symptomCounts : the list of system / count to save
	 * @return the number of written occurrences
	 */
	@Override
	public int saveAllSymptomCounts(List<SymptomCount> symptomCounts) {
		ISymptomCountDao symptomCountDao = daoFactory.getSymptomCountDao();
		int nbWrittenOccurences = symptomCountDao.saveAll(symptomCounts);

		Logger.log(String.format("Total number of written symptoms / count : %d", nbWrittenOccurences));
		return nbWrittenOccurences;
	}

	/**
	 * Calculate the count for each symptom, and return an ordered (by symptom name)
	 * list of symptom / count
	 * 
	 * @param symptoms : the list of symptoms
	 * @return : the list of symptom / count
	 */
	@Override
	public List<SymptomCount> countSymptoms(List<Symptom> symptoms) {
		final int FIRST_COUNT = 1;
		final int INCREMENT = 1;

		// Calculate the count for each symptom
		Map<Symptom, Integer> mapSymptomCount = new TreeMap<>();
		for (Symptom symptom : symptoms) {
			Integer oldCount = mapSymptomCount.get(symptom);
			int newCount = (oldCount != null) ? oldCount + INCREMENT : FIRST_COUNT;
			mapSymptomCount.put(symptom, newCount);
		}

		// Get an ordered (by symptom name) list of symptom / count
		List<SymptomCount> symptomCountList = new ArrayList<>();
		for (Map.Entry<Symptom, Integer> symptomCountEntry : mapSymptomCount.entrySet()) {
			symptomCountList.add(
					new SymptomCount((Symptom) symptomCountEntry.getKey(), (Integer) symptomCountEntry.getValue()));
		}

		return symptomCountList;
	}
}
