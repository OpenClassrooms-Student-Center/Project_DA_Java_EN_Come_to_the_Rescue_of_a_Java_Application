package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	// todo don't forget to ask  the mentor about the relatif path instead of the absolute one below
	private static final String path = "C:\\Users\\dimit\\OneDrive\\Bureau\\Developpeur_Java_Bac_LVL_4\\Projets\\Projet 2\\p2Clone\\Project02Eclipse";
	private static final String fileName = "symptoms.txt";
	private static final String filePath = path + "/" + fileName;

	/**
	 * Principal method, this method will call the others methods
	 * @param args
	 */
	public static void main(String[] args) {

		//1 - lire le fichier des symptoms (symptoms.txt)
		FileManagement fileManagement = new FileManagement(filePath);
		List<String> symptomsList = fileManagement.getSymptoms();

		//2 - trier les symptomes par nb d'occurence / puis par ordre alphabetique
		Map<String, Long> occurenceBySymptoms = fileManagement.countAndSortSymptoms(symptomsList);

		//3 - générer le fichier qui contient les symptomes
		fileManagement.generateSymptomsReport(occurenceBySymptoms);

	}
}
