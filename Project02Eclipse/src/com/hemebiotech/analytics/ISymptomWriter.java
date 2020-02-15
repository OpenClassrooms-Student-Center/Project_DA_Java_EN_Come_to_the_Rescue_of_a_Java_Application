package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
	void writeSymptoms(Map<String, Integer> symptomsList, boolean firstLetterIsCapital, boolean alignStatement);
}
