package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

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
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();

		if (filepath != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {

				String line = reader.readLine();
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
			} catch (IOException e) {
				System.err.println(
						"File not found. Please check the filenames and try again. Filepath given : " + filepath);
			}
		}

		return result;
	}

	@Override
	public List<String> getUniqueSymptomNames(List<String> symptoms) {
		// Converting a List to a Set will remove all duplicates. We then use
		// Collections to sort the list alphabetically
		Set<String> set = new HashSet<>(symptoms);
		List<String> uniqueSymptoms = new ArrayList<>();
		uniqueSymptoms.addAll(set);
		Collections.sort(uniqueSymptoms);
		return uniqueSymptoms;
	}

}
