package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de l'interface ISymptomReader}
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	/**
	 * @filepath Chemin du fichier un chemin complet ou partiel vers un fichier
	 *           contenant des chaînes de symptômes, une par ligne
	 */
	private String filepath;

	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * 
	 */
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		/**
		 * Lire les symptoms dans une liste
		 * 
		 */
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String symptom = reader.readLine();
				/**
				 * //transvaser resultat dans liste //pour comparer et extraire seulement une
				 * fois le contenu d'une ligne
				 */
				while (symptom != null) {
					result.add(symptom);
					symptom = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}