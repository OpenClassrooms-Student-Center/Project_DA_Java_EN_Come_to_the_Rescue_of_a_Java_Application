package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write a list of symptom / number of occurs
 */

public interface ISymptomWriter {

	void WriteSymptoms(Map<String, Integer> listSymptoms);

}
