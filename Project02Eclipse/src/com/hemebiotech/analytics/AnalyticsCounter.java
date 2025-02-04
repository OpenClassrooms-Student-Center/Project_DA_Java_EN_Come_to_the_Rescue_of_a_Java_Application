package com.hemebiotech.analytics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {	
	ISymptomReader reader;
	ISymptomWriter writer;
	/**
	 * constructeur avec pour paramètres un objet de type ISymptomReader et un objet de type ISymptomWriter.
	 * @param reader Objet qui implémente l'interface ISymptomReader
	 * @param writer Objet qui implémente l'interface ISymptomWriter
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	/**
	 * récupère la liste des entrées dans le fichier en utilisant l’instance de ISymptomReader
	 * @return Liste des symptomes
	 */
	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}
	/**
	 * Compte les occurrences de chaque symptôme dans la liste.
	 * @param symptoms Liste des symptomes.
	 * @return Map avec comme clés les symptomes et comme valeurs le nombre de fois ou les symptomes apparaissent dans la liste.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCounts = new HashMap<>();

        for (String symptom : symptoms) {
            symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
        }

        return symptomCounts;
    }
	/**
	 * trie la liste de symptômes et d’occurrences par ordre alphabétique.
	 * @param symptoms Une map de symptomes avec leur nombre.
	 * @return Map avec comme clés les symptomes et comme valeurs le nombre de fois ou les symptomes apparaissent dans la liste.
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        Map<String, Integer> sortedSymptoms = new TreeMap<>(symptoms);
        return sortedSymptoms;
    }
	/**
	 * écrit le résultat dans le fichier de sortie en utilisant l’instance de ISymptomWriter
	 * @param symptoms une map de symptomes triée avec le nombre d'occurences.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}			
	}
