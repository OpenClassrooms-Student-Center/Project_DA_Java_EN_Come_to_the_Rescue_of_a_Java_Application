package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
	/**
	 * 
	 * @param compteurs Nous le prenons pour prendre sa taille et l'utilisons pour
	 *                  écrire les symptômes / We take it to take it size and use for
	 *                  with it to write symptoms
	 */
	void writeSymptoms(Map<String, Integer> compteurs);
}