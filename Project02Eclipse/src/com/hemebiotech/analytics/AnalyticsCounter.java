package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	public static final String  PATHTOFILESYMPTOMES  = "symptoms.txt"; 
	public static final String PATHTOFILEOUT  = "result.out"; 

	public static void main(String args[]) throws Exception {
		// lire le fichier && creer la liste des symptomes
		/*
		 * Analyse analyse = new Analyse(new, new , new); 
		 * List<String> toto =analyse.getSymptoms(); 
		 * Map<String, Integer> tata = analyse.count(toto);
		 * Map<String, Integer> tutu = analyse.order(tata); analyse.write(tutu);
		 
		List<String> listeSymptomes = new ArrayList<String>();
		Map<String, Integer> mapSymptomes = new HashMap<String, Integer>();
		Map<String, Integer> order = new HashMap<String, Integer>();
		Analyse analyse = new Analyse(new ReadSymptomDataFromFile(PATHTOFILESYMPTOMES),new CalculOccuranceSymptomes(listeSymptomes),new OrderSymptomes(mapSymptomes),new WriteSymptomes(order, PATHTOFILEOUT));
		listeSymptomes = analyse.getSymptoms();
		mapSymptomes= analyse.getMapSymptomes();
		analyse.order();
		analyse.write();*/
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