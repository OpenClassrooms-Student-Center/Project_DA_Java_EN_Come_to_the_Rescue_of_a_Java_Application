package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadSymptomDataFromFile {
	private String filepath;

	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	public ArrayList<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();
		try {
			FileReader filereader = new FileReader(filepath);
			BufferedReader br = new BufferedReader(filereader);

			String line;

			while ((line = br.readLine()) != null) {
				result.add(line);
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.err.println("impossible de trouver le fichier");
		} catch (IOException e) {
			System.err.println("impossible de lire le contenu du fichier");
		}

		return result;
	}

}
