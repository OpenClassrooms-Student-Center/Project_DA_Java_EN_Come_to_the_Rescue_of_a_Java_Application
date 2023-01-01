package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyticsCounterMain {

	private static String fileName = "symptoms.txt";
	private static String outFileName = "result.out";

	public static void main(String[] args) throws IOException {
		// instanciation de l'objet AnalyticsCounter
		AnalyticsCounternew analyticsCounter = new AnalyticsCounternew();

		// appel de la méthode qui récupère la liste des sysmptoms
		List<String> listSym = analyticsCounter.getSymptoms(fileName);

		// appel la méthode qui regroupe le symptom par occurence
		Map<String, Integer> symptomsOcurenceMap = analyticsCounter.getSymptomsMapOcurence(listSym);

		// pour affichage
		symptomsOcurenceMap.forEach((key, value) -> {
			System.out.println("symptom : " + key + " | occurence : " + value);
		});

		// écrire dans le fichier result.out.
		analyticsCounter.writerSymptoms(symptomsOcurenceMap, outFileName);
	}

}