package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
	
	void WriteToFile(Map<String, Integer> writeSymptoms);

	void writeSymptoms(Map<String, Integer> symptomsMap);
} 