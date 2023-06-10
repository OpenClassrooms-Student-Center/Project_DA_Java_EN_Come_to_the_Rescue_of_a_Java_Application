package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Map;

public interface ISymptomWriter {
	Map<String, Integer> symptoms = new HashMap<>();

	public void writeSymptoms(Map<String, Integer> symptoms);

}