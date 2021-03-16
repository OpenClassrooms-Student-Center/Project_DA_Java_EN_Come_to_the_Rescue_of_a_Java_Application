package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadSymptomDataFromFile {
	private String filepath;

	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	public HashMap<String,int[]> getSymptoms() {
		HashMap<String,int[]> result = new HashMap<>();
		try {
			FileReader filereader = new FileReader(filepath);
			BufferedReader br = new BufferedReader(filereader);

			String line;

			while ((line = br.readLine()) != null) {
				int [] nombre = result.get(line);
				if(nombre == null){
					nombre = new int[]{0};
					result.put(line,nombre);}
					else {
						nombre[0] ++;
						result.put(line,nombre);
				}
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
