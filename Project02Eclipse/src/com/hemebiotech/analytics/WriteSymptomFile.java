package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Creation of the final file with ordered and counted list of symptoms
 * 
 * @author CHRISTINE TETI
 *
 */

public class WriteSymptomFile {
	/**
	 * Writes final file with list of sorted and counted symptoms
	 * 
	 * @param symptomsSorting a TreeMap containing a list of sorted and counted
	 *                        symptoms strings
	 * @throws IOException
	 */

	public void writeSymptomData(TreeMap<String, Integer> symptomsSorting) throws Exception {

		try {
			// Create a new file
			File symptomslist = new File("resultsout.txt");

			// Create BufferedWriter using FileWriter with TreeMap of symptoms as argument
			BufferedWriter bwriterfile = new BufferedWriter(new FileWriter(symptomslist));

			// Write title on first line
			bwriterfile.write("List of symptoms reported by patients: ");
			bwriterfile.newLine();

			if (symptomsSorting != null && !symptomsSorting.isEmpty()) {

				// Iterate over map entries to write only one symptom by line
				for (Map.Entry<String, Integer> entry : symptomsSorting.entrySet()) {
					bwriterfile.write(entry.getKey() + ":" + entry.getValue());
					bwriterfile.newLine();
				}
			}
			// Write no symptoms message if Tree Map is empty
			else {
				bwriterfile.write("No symptoms! ");

			}

			// Close BufferedWriter
			bwriterfile.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}