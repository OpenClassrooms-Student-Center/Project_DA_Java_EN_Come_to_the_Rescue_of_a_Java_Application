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
 * @param filepath Attribut de la classe WriteSymptomDataToFile de type String
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filepath;

	/**
	 * 
	 * @param filename Paramètre du constructeur de la Classe pour l'attribut
	 *                 filepath
	 * 
	 */

	public WriteSymptomDataToFile(String filename) {

		this.filepath = filename;
	}

	@Override

	/**
	 * @param symptomsMap Liste utilisée pour l'écriture des symptomes triés et
	 *                    comptés vers un fichier de sortie
	 * 
	 * @throw IOException Exception levée si la liste des ymptomes n'a pu être écrit
	 *        dans le ficher de sortie
	 */
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
