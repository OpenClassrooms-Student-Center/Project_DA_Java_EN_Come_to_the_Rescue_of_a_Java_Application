package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	public static String pathTofileSymptomes;

	public static void main(String args[]) throws Exception {
		// lire le fichier && creer la liste des symptomes
		pathTofileSymptomes = "symptoms.txt";
		ISymptomReader symptomes = new ReadSymptomDataFromFile(pathTofileSymptomes);
		List<String> listeSymptomes = symptomes.getSymptoms();
		if (listeSymptomes.size() != 0) {
			// creer une map de symptome && calculer les occurances de chaque symptome
			ISymptomCalcul mapSymptomesOccurance = new CalculOccuranceSymptomes(listeSymptomes);
			Map<String, Integer> mapSymptomes = mapSymptomesOccurance.getMapSymptomes();

			// classifier les symptomes par ordre alphabétique
			OrderSymptomes mapSymptomesOrdonner = new OrderSymptomes(mapSymptomes);
			mapSymptomesOrdonner.ordre();

			// remplir le fichier de sortie
			ISymptomWriter fileOut = new WriteSymptomes(mapSymptomesOrdonner.ordre(), "result.out");
			fileOut.write();

			System.out.println("Traitement réussi, Vous trouverez le résultat dans le fichier result.out");
		} else {
			System.out.println("Le fichier source est vide !!!");
		}
	}
}