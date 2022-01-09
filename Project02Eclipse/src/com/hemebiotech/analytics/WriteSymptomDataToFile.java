package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Classe permettant l'écriture de la liste des symptomes triés avec leurs
 * occurences respectives
 * 
 * @author Fouad
 * 
 * @param filepath Attribut de la Classe WriteSymptomDataToFile de type String
 * 
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filepath;

	/**
	 * 
	 * @param filename Paramètre du constructeur de la Classe WriteSymptomDataToFile
	 *                 contenant le chemin d'accès partiel ou complet vers le
	 *                 fichier sur lequel seront écrits les symptomes pour
	 *                 initialiser l'attribut de la Classe
	 * 
	 */

	public WriteSymptomDataToFile(String filename) {

		this.filepath = filename;
	}

	/**
	 * 
	 * 
	 * 
	 * @param filepath    Chemin d'accès vers le fichier dans lequel seront écrits
	 *                    les symptomes
	 *
	 * @param symptomsMap Tableau contenant les symptomes avec leurs occurences
	 *                    respectives
	 * 
	 * @throw IOException Exception levée si les données du tableau ne peuvent pas
	 *        être écrite dans le ficier de destination
	 */

	@Override
	public void writeSymptom(Map<String, Integer> symptomsMap) {

		FileWriter writer = null;
		try {
			writer = new FileWriter(filepath);
			for (Entry<String, Integer> entry : symptomsMap.entrySet()) {
				writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("erreur lors de l'écriture des symptomes dans le fichier de sortie");

		}
	}

}
