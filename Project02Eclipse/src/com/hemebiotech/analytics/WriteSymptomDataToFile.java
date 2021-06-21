package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Write Symptom file and data
 *
 */

public class WriteSymptomDataToFile implements ISymptomWriter {
	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to the file of which strings of symptoms will be written in, one per line
	 * 
	 */
	public WriteSymptomDataToFile (String filepath) {
		this.filepath = filepath;
	}

	/**
	 * 
	 * @param symptomsList a list of symptoms imported from symptoms.txt
	 * 
	 */
	public Set<String> SetSymptoms(List<String> symptomsList) {
		Set<String> listOfSymptoms = new HashSet<String>(symptomsList);
		ArrayList<String> symptoms = new ArrayList<String>(listOfSymptoms);
		if (filepath != null) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
				
				for(String symptom : symptoms) {
					writer.write(symptom);
					writer.newLine();
				}
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return listOfSymptoms;
	}


}
