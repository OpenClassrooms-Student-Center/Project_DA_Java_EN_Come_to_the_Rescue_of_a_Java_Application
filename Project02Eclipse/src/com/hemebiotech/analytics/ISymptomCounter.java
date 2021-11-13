package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public interface ISymptomCounter {
	/**
	 * 
	 * @param listNotCounted Symptoms read from symptoms.txt
	 * @return Treemap with symptom as key, count as value
	 */
	public Map<String, Integer> processData(List<String> listNotCounted);

}
