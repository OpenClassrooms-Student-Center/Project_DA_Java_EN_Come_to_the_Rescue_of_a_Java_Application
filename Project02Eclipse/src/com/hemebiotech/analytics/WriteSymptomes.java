package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * cette class remplit un fichier avec les symptomes et leurs nombre
 * d'occurances
 *
 */
public class WriteSymptomes implements ISymptomWriter {

	/**
	 * @return cette fonction écrira dans un fichier de sortie
	 * @param newMapSymptome : une map ordonner par sa clé
	 * @param filePathOut    : fichier de sortie ou les résultats vont etre affichés
	 */
	@Override
	public void write(Map<String, Integer> newMapSymptome, String filePathOut) {
		if (filePathOut != null) {

			try {
				FileWriter fileWriter = new FileWriter(filePathOut, false);
				BufferedWriter writer = new BufferedWriter(fileWriter);
				for (Map.Entry<String, Integer> entry : newMapSymptome.entrySet()) {
					writer.write(entry.getKey() + " = " + entry.getValue());
					writer.newLine();
				}
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
