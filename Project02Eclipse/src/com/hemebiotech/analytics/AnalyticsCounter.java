package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Classe permettant de compter le nombre de symptomes dans un fichier texte
 * 
 * @author Fouad
 * 
 */
public class AnalyticsCounter {

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */

	public static void main(String args[]) throws Exception {

		AnalyticsCounter instance = new AnalyticsCounter();
		instance.countSymptoms();

	}

	public void countSymptoms() throws IOException {
		System.out.println("Lecture du fichier en cours...");
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");

		List<String> list_symptoms = reader.getSymptoms();
		System.out.println("Lecture du fichier OK");

		System.out.println("Comptage des symptomes en cours...");
		ISymptomCounter counter = new SymptomsCounter();
		Map<String, Integer> occurence_symptoms = counter.getSymptomsOccurence(list_symptoms);
		System.out.println("Comptage des symptomes OK");

		System.out.println("Ecriture des résultats dans le fixhier de sortie en cours...");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		writer.writeSymptom(occurence_symptoms);
		System.out.println("Ecriture des résultats dans le fixhier de sortie en cours OK");
	}

}
