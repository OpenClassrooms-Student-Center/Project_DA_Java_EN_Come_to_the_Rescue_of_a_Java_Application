package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;
/**
 * Créez le constructeur avec pour paramètres un objet de type
 * ISymptomReader et un objet de type ISymptomWriter. Ce
 * constructeur doit assigner les valeurs de ces deux paramètres à
 * deux attributs de classe.
 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;

	}
/**
 * Créez une méthode getSymptoms qui récupère la liste des entrées
 * dans le fichier en utilisant l’instance de ISymptomReader déjà
 * créée ;
 */
	public List<String> getSymptoms() {
//		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		List<String> symptoms = reader.getSymptoms();
		return symptoms;
		}
	/**
	 * Créez une méthode countSymptoms qui compte les occurrences
	 * de chaque symptôme existant ;
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCountMap = new HashMap<String, Integer>();
//		classic loop
//		for(int symptom=0;symptom<symptoms.length;symptom++){}
//		for-each loop
		for (String symptom : symptoms) {
			System.out.println(symptom);
			boolean isSymptomAlreadyExists = symptomCountMap.containsKey(symptom);
			if (isSymptomAlreadyExists){
				Integer count = symptomCountMap.get(symptom);
				symptomCountMap.put(symptom,count++);

//				count++;
			}
			else{
				Integer count = 1;
				symptomCountMap.put(symptom,count);
			}
		}
		return symptomCountMap;
	}
/**
 * Créez une méthode sortSymptoms qui trie la liste de symptômes
 * et d’occurrences par ordre alphabétique ;
 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}
/**
 * Créez une méthode writeSymptoms qui écrit le résultat dans le
 * fichier de sortie en utilisant l’instance de ISymptomWriter déjà
 * créée.
 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
//		WriteSymptomDataToFile writer = new WriteSymptomDataToFile();
		writer.writeSymptoms(symptoms);
	}

	public static void main(String args[]) throws Exception {
	}
}
