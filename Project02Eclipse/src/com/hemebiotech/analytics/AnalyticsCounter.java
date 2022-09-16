package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	public static final String  PATHTOFILESYMPTOMES  = "symptoms.txt"; 
	public static final String PATHTOFILEOUT  = "result.out"; 

	public static void main(String args[]) throws Exception {
	
		ISymptomReader symptomes = new ReadSymptomDataFromFile(PATHTOFILESYMPTOMES);
		List<String> listeSymptomes = symptomes.getSymptoms();
		if (listeSymptomes.size() != 0) {
			// creer une map de symptome && calculer les occurances de chaque symptome
			ISymptomCalcul mapSymptomesOccurance = new CalculOccuranceSymptomes(listeSymptomes);
			Map<String, Integer> mapSymptomes = mapSymptomesOccurance.getMapSymptomes();

			// classifier les symptomes par ordre alphabétique
			IOrderSymptom mapSymptomesOrdonner = new OrderSymptomes(mapSymptomes);
			mapSymptomesOrdonner.order();

			// remplir le fichier de sortie
			ISymptomWriter fileOut = new WriteSymptomes(mapSymptomesOrdonner.order(), PATHTOFILEOUT);
			fileOut.write();

			System.out.println("Traitement réussi, Vous trouverez le résultat dans le fichier result.out");
		} else {
			System.out.println("Le fichier source est vide !!!");
		}
				
	}
}