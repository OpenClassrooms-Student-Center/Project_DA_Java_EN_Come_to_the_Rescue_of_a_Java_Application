package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
	/**
     * écrit une liste de symptomes et leur nombres.
     * @param symptoms est une map avec le nom des symptomes et leur nombre.
     * and the Integer value is the number of times the symptom has been reported
     */
	public void writeSymptoms(Map<String, Integer> symptoms);
}

