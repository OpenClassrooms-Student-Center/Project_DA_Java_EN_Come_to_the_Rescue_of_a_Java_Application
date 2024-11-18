package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe ReadSymptomDataFromFile implémente l'interface ISymptomReader pour lire les symptômes à partir d'un fichier.
 */

public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	/**
	 * Constructeur de la classe ReadSymptomDataFromFile.
	 * filepath est le chemin du fichier contenant les symptômes.
	 */
		public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	/**
	 * On lit les symptômes à partir du fichier et les retourne dans une liste.
	 * On retourne sur la liste des symptômes tant qu'il y a des lignes à lire.
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
