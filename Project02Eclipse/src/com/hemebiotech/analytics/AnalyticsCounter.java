package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	private static String path = "C:\\Users\\dimit\\OneDrive\\Bureau\\Developpeur_Java_Bac_LVL_4\\Projets\\Projet 2\\p2Clone\\Project02Eclipse";
	private static String fileName = "symptoms.txt";
	private static String filePath = path + "/" + fileName;
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader(filePath));
		String line = reader.readLine();

		//1 - lire le fichier des symptoms (symptoms.txt)
		ReadSymptomDataFromFile readFile = new ReadSymptomDataFromFile(filePath);
		List<String> symptomsList = readFile.getSymptoms();

		//2 - trier les symptomes par nb d'occurence / puis par ordre alphabetique


		//3 - générer le fichier qui contient les symptomes
		int i = 0;	// set i to 0
		int headCount = 0;	// counts headaches
		while (line != null) {
			i++;	// increment i
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
