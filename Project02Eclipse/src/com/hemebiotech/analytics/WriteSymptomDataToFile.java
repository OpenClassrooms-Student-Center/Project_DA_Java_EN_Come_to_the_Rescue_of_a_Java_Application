package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * classe qui permet d'écrire un fichier en implémentant l'Interface ISymptomWriter
 *
 */
public class WriteSymptomDataToFile  implements ISymptomWriter{
	/**
	 * Methode qui permet d'écrire dans un fichier result.out.txt depuis une map passée en paramètres
	 * @param symptoms une map de symptomes
	 */

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Project02Eclipse\\result.out.txt"))){

			for (Map.Entry<String, Integer> symptome : symptoms.entrySet())
			{
				writer.write(symptome.getKey() + " " + symptome.getValue() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
