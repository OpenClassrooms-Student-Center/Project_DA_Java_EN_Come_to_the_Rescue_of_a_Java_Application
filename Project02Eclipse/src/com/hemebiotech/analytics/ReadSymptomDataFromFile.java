package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList; // class reelle qui implemente List
import java.util.List;  // interface generique

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	private String filepath; // private car juste dans cette class et filephath et le chemin a prendre. Ecrire symptom ici et trop figé dans l'ecrire dans main qui est le chef d'orchestre
	
	/**
	 * @param filepath : un chemin complet ou partiel vers un fichier contenant des symptômes, un par ligne
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath; // this parce que le nom du paramètre est le même que l’attribut.
	}
	
	@Override
	public List<String> GetSymptoms() {
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
