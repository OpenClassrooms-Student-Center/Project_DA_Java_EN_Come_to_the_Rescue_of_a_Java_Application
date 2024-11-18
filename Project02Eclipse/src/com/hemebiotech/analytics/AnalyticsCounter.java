package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * La classe AnalyticsCounter s'occupe de l'analyse des symptômes.
 * Elle utilise les instances de ISymptomReader et ISymptomWriter pour lire et écrire les donnée de symptômes.
 */

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;
	/**
	 * C'est le constructeur de la classe AnalyticsCounter.
	 * On utilise L'instance de lecture définit dans ISymptomReader pour lire les symptômes.
	 * On utilise L'instance d'écriture définit dans ISymptomWriter pour écrire les symptômes.
	 */

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;

	}
	/**
	 * On récupère la liste des symptômes de l'instance ISymptomReader.
	 * On retourne La liste des symptômes.
	 */
	public List<String> getSymptoms	() {
		return reader.getSymptoms();
	}
	/**
	 * On compte les occurrences de chaque symptôme dans la liste.
	 * Si un symptôme existe on incrémente de 1 pour le compte sinon on ajoute le nouveau symptôme à la liste  .
	 */

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCount = new HashMap<String, Integer>();
		for (String symptom : symptoms) {
			if (symptomCount.containsKey(symptom)) {
				symptomCount.put(symptom, symptomCount.get(symptom) + 1);
			} else {
				symptomCount.put(symptom, 1);
			}
		}
		return symptomCount;
	}
	/**
	 * On trie les symptômes par ordre alphabétique.
	 * On utilise les parametres symptoms de la map contenant les symptômes et leurs occurrences.
	 * On retourne Une map triée par ordre alphabétique.
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms){
		return new TreeMap<>(symptoms);
	}
	/**
	 * On écrit les symptômes et leurs occurrences dans le fichier.
	 * On utilise les parametres symptoms de la map contenant les symptômes et leurs occurrences.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

}
