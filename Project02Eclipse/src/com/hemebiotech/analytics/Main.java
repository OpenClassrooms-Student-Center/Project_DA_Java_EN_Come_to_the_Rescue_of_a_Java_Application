package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {
	/**
	 * Methode qui permet d'appeler les autres méthodes afin de lire le fichier
	 * d'entree symptomes.txt et de ressortir un fichier result.out.txt avec les
	 * symptomes triés
	 */
	public static void main(String[] args) {
		 ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse//symptoms.txt");
		 ISymptomWriter writer = new WriteSymptomDataToFile();
		 AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
		 List<String> listSymptoms = analyticsCounter.getSymptoms();

		 Map <String, Integer> mapSymptoms = analyticsCounter.countSymptoms(listSymptoms);
		 mapSymptoms = analyticsCounter.sortSymptoms(mapSymptoms);
		 analyticsCounter.writeSymptoms(mapSymptoms);
	}
}

