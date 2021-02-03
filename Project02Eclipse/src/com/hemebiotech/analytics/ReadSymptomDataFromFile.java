package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	// public List<String> GetSymptoms() {
	public TreeMap<String, Integer> GetSymptoms() {
		// ArrayList<String> result = new ArrayList<String>();
		TreeMap<String, Integer> resultat = new TreeMap<String, Integer>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					// result.add(line);

					Integer valeur = resultat.get(line);

					if (valeur == null) {

						resultat.put(line, 1);

					} else {

						resultat.put(line, valeur + 1);
					}

					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// return result;
		return resultat;
	}

}
