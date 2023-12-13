package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new HashMap<>(); // creation de la Map

		// parcourt la list "symptoms" et incrémente la map de +1 pour chaque symptome
		// qui se repete
		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}

		return symptomCounts;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		// Convertir la Map en une TreeMap pour obtenir un tri automatique par clé
		// (symptôme)
		TreeMap<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);

		// Convertir la TreeMap triée en une nouvelle HashMap pour la sortie
		Map<String, Integer> sortedMap = new LinkedHashMap<>(sortedSymptoms);

		return sortedMap;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
