package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Classe qui permet de lire, d'obtenir, compter, trier et écrire
 *  une liste de String passée en paramètres
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * Constructeur permettant d'affecter les attributs reader et writer avec les paramètres passés.
	 * @param reader instance de l'interface ISymptomReader
	 * @param writer instance de l'interface ISymptomWriter
	 */
	public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer ) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * methode qui permet d'obtenir une liste de string depuis l'attribut reader.
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 * Compte le nombre de symptomes présents dans la liste
	 * @param symptoms une liste de symptomes
	 * @return une map de symptomes avec leur nombre d'occurence associé
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> mapSymptoms = new HashMap<>();
		Integer nombreDeCeSymptom;

		for (String symptom : symptoms){
			symptom = symptom.trim().toLowerCase();
			nombreDeCeSymptom = mapSymptoms.getOrDefault(symptom, 0);
			mapSymptoms.put(symptom, nombreDeCeSymptom + 1);
		}
		return mapSymptoms;
	}

	/**
	 * Trie par ordre alphabétique les symptomes dans la clé de la map passée en paramètres
	 * @param symptoms une map de symptomes avec le nombre d'occurences
	 * @return une map triée
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<String, Integer>(symptoms);
	}

	/**
	 * Ecrit la map de symptomes triée avec le nombre d'occurences dans un fichier
	 * @param symptoms une map de symptomes triée avec le nombre d'occurences
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}
