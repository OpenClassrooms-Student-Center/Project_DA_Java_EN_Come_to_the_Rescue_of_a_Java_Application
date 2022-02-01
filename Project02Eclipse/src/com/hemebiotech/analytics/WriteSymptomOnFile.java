package com.hemebiotech.analytics;


import java.io.IOException;
import java.util.HashMap;
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

	public WriteSymptomOnFile(String outputFile) {
		this.outputFile = outputFile;
	}

	public void writeSymptoms(Map<String, Integer> nbOccurence) throws IOException{
		Map<String, Integer> compteurs = new HashMap<String, Integer>(nbOccurence);
}
}
