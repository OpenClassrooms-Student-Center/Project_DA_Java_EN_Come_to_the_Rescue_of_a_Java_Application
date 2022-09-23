package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	public static final String  PATHTOFILESYMPTOMES  = "symptoms.txt"; 
	public static final String PATHTOFILEOUT  = "result.out"; 

	public static void main(String args[]) {
		Analyse analyse = new Analyse(new ReadSymptomDataFromFile() , new CalculOccuranceSymptomes(), new OrderSymptomes(), new WriteSymptomes());
		List<String> listeSymptomes = analyse.getSymptoms(PATHTOFILESYMPTOMES);
		if (listeSymptomes.size() != 0) {
			Map<String, Integer> mapSymptomes = analyse.getMapSymptomes(listeSymptomes);
			analyse.write(analyse.order(mapSymptomes), PATHTOFILEOUT);
			System.out.println("Traitement réussi, Vous trouverez le résultat dans le fichier result.out");
		} else {
			System.out.println("Le fichier source est vide !!!");
		}
				
	}
}