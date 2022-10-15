package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	private static String path = "C:\\Users\\dimit\\OneDrive\\Bureau\\Developpeur_Java_Bac_LVL_4\\Projets\\Projet 2\\p2Clone\\Project02Eclipse";
	private static String fileName = "symptoms.txt";
	private static String filePath = path + "/" + fileName;
	
	public static void main(String args[]) {

		//1 - lire le fichier des symptoms (symptoms.txt)
		ReadSymptomDataFromFile readFile = new ReadSymptomDataFromFile(filePath);
		List<String> symptomsList = readFile.getSymptoms();

		//2 - trier les symptomes par nb d'occurence / puis par ordre alphabetique
		Map<String, Long> occurenceBySymptoms = readFile.countAndSortSymptoms(symptomsList);

		//3 - générer le fichier qui contient les symptomes
		readFile.generateSymptomsReport(occurenceBySymptoms);

	}
}
