package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String inputFile;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 *                 
	 *                 
	 *  Voir si besoin d'une nouvelle méthode pour mettre dans l'ordre ?
	 */
	public ReadSymptomDataFromFile(String inputFile) throws IOException {
		this.inputFile = inputFile;
	}

	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (inputFile != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				String line = reader.readLine();

				while (line != null) {
					result.add(line); /** affichage de la ligne */
					line = reader.readLine(); /** lecture de la prochaine ligne */
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
