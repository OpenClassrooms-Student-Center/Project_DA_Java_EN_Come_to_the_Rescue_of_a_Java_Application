package com.hemebiotech.analytics;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Test JUnit for the features of Analytic Service
 * 
 * @author trimok
 *
 */
class TestAnalyticsCounter {

	/**
	 * Test for AnalyticsService.findAllSymptoms
	 */
	@Test
	void testFindAllSymptoms() {
		final int SYMPTOMS_WITH_DUPLICATE_SIZE = 100;

		IAnalyticsService service = new AnalyticsService();
		List<Symptom> symptoms = service.findAllSymptoms();
		assert (symptoms.size() == SYMPTOMS_WITH_DUPLICATE_SIZE);
	}

	/**
	 * Test for AnalyticsService.countSymptoms
	 */
	@Test
	void testCountSymptoms() {
		final int SYMPTOMS_SIZE = 23;
		IAnalyticsService service = new AnalyticsService();
		List<Symptom> symptoms = service.findAllSymptoms();
		List<SymptomCount> symptomCounts = service.countSymptoms(symptoms);
		assert (symptomCounts.size() == SYMPTOMS_SIZE);
	}

	/**
	 * Test for AnalyticsService.doSymptomCountAnalysis
	 */
	@Test
	void testSymptomsCountAnalysis() {
		final int SYMPTOMS_SIZE = 23;
		IAnalyticsService service = new AnalyticsService();
		int nbWrittenOccurrences = service.doSymptomCountAnalysis();
		assert (nbWrittenOccurrences == SYMPTOMS_SIZE);
	}
}
