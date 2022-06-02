package com.hemebiotech.analytics;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsCounter {
	static final String filePath = "C:\\Users\\10166140\\OpenclassroomsProjects\\Projet2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt";

	public static void main(String[] args) throws Exception {
		// first get input
		Map<String, Integer> mapFromFile
				= hashMapSymptoms();

		writeSymptoms(mapFromFile);
	}

	public static Map<String, Integer> hashMapSymptoms() {

		Map<String, Integer> mapSymptoms
				= new HashMap<>();

		try {
			File file = new File(filePath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();

			int count = 1;
			// On lit les lignes 1 par 1
			while ((line != null)) {
				// incrémenter le compteur de ligne
				// Récupérer le texte de la ligne
				String symptoms = line;
				// Mettre symptoms + compteur dans le map
				if (!mapSymptoms.containsKey(symptoms)) {
					mapSymptoms.put(symptoms, count);
				} else {
					Integer currentValue = mapSymptoms.get(symptoms);
					mapSymptoms.replace(symptoms, ++currentValue);
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapSymptoms;
	}

	public static void writeSymptoms(Map<String, Integer> mapFromFile) {

		if (filePath != null) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"));

				mapFromFile.forEach((symptom, count) -> {
					try {
						writer.write(symptom + "=" + count);
						writer.newLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

