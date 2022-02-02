package com.hemebiotech.analytics;


import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @param outputFile a full or partial path to file with symptom strings in it,
 *                   one per line
 * 
 *                   Voir si besoin d'une nouvelle méthode pour mettre dans
 *                   l'ordre ? TO DO : automatiser l'écriture du fichier.
 */
public class WriteSymptomOnFile implements ISymptomWriter {

	private String outputFile;

	public WriteSymptomOnFile(String outputFile) throws IOException {
		this.outputFile = outputFile;
	}
	
	@Override
	public Map<String, Integer> nbOccurrence(List<String> symptomsList) {
		Map<String, Integer> writeSymptoms = new HashMap<String, Integer>();
	
		 try (FileWriter fileWriter = new FileWriter(outputFile, false);
				BufferedWriter writer = new BufferedWriter (fileWriter)) {
			 for (String symptom : symptomsList) {
				while (writeSymptoms.containsKey(symptom)) {
					writer.write(symptom + "/n");
					writer.newLine();
				}
			 }
			 writer.close();
			 
		 } catch (IOException e) {

		      e.printStackTrace();
		}
 	return writeSymptoms;
}
}

