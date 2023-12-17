package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Cette classe {@code AnalyticsCounter} fournit des fonctionnalités pour
 * compter, trier et écrire des symptômes.
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * Constructeur de la classe {@code AnalyticsCounter}.
	 *
	 * @param reader Un objet implémentant l'interface {@code ISymptomReader} pour
	 *               lire les symptômes.
	 * @param writer Un objet implémentant l'interface {@code ISymptomWriter} pour
	 *               écrire les symptômes.
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Récupère la liste des symptômes à partir de l'objet {@code ISymptomReader}.
	 *
	 * @return Une liste de chaînes de caractères représentant les symptômes.
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
		return reader.getSymptoms();
	}

	/**
	 * Compte le nombre d'occurrences de chaque symptôme dans une liste donnée.
	 *
	 * @param symptoms Une liste de chaînes de caractères représentant les symptômes
	 *                 à compter.
	 * @return Une Map associant chaque symptôme à son nombre d'occurrences.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new HashMap<>();
		Map<String, Integer> symptomCounts = new HashMap<>();

		// Parcourt la liste "symptoms" et incrémente la Map pour chaque symptôme
		// en comptant ses occurrences.
		for (String symptom : symptoms) {
			symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
		}

		return symptomCounts;
	}

	/**
	 * Trie les symptômes par ordre alphabétique.
	 *
	 * @param symptoms Une Map associant les symptômes à leur nombre d'occurrences.
	 * @return Une Map triée par ordre alphabétique des symptômes.
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		// Utilise TreeMap pour obtenir un tri automatique par ordre alphabétique.
		Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);

		return sortedSymptoms;
	}

	/**
	 * Écrit les symptômes et leur nombre d'occurrences en utilisant l'objet
	 * {@code ISymptomWriter}.
	 *
	 * @param symptoms Une Map associant les symptômes à leur nombre d'occurrences à
	 *                 écrire.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
