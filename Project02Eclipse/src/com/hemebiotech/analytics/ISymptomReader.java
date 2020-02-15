package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomReader {
	Map<String, Integer> GetSymptoms();
	Map<String, Integer> sortSymptomsByKey(Map<String, Integer> symptomsList);
	Map<String, Integer> sortSymptomsByValue(Map<String, Integer> symptomsList);
}
