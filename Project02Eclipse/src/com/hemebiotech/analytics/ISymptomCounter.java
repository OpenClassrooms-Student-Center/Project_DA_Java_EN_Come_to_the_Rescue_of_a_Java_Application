package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public interface ISymptomCounter {
	/**
	 * 
	 * @param listNotCounted Symptômes lus à partir de Symptômes.txt / Symptoms read
	 *                       from symptoms.txt
	 * @return Map avec symptôme comme clé, compte comme valeur / Map with symptom
	 *         as key, count as value
	 */
	public Map<String, Integer> processData(List<String> listNotCounted);

}
