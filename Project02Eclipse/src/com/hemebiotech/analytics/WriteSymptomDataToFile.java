package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 
 * Write Symptom file and data
 *
 */

public class WriteSymptomDataToFile implements ISymptomWriter {
	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to the file of which strings of
	 *                 symptoms will be written in, one per line
	 * 
	 */
	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * 
	 * @param symptomsList a list of symptoms imported from symptoms.txt
	 * @throws IOException 
	 * 
	 */
	public void setSymptoms(Map<String, Integer> symOccurrences) throws IOException {

		TreeMap<String, Integer> sortedSympOccurrences = new TreeMap<String, Integer>(symOccurrences);

		if (filepath != null) {
			BufferedWriter writer = null;
			try {
				 writer = new BufferedWriter(new FileWriter(filepath));

				sortedSympOccurrences.putAll(symOccurrences);

				Set<String> symptoms = sortedSympOccurrences.keySet();

				for (String symptom : symptoms) {
					System.out.println(symptom + " : " + sortedSympOccurrences.get(symptom));
					writer.write(symptom + " : " + sortedSympOccurrences.get(symptom));
					writer.newLine();
				}

				writer.close();
			} catch (IOException e) {
				System.out.println("Problème lors d'ecriture dans le fichier !");
			}finally {
				writer.close();
			}
		}

	}

}
