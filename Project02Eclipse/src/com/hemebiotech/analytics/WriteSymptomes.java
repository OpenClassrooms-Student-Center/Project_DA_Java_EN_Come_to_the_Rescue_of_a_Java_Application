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

	Map<String, Integer> newMapSymptome;
	public String filePathOut;

	/**
	 * 
	 * @param newMapSymptome => une map classifier par ordre alphabitique
	 * @param filePathOut    => lien du fichier de sortie
	 */
	WriteSymptomes(Map<String, Integer> varNewMapSymptome, String varFilePathOut) {
		this.newMapSymptome = varNewMapSymptome;
		this.filePathOut = varFilePathOut;
	}

	@Override
	public void write() {
		if (this.filePathOut != null) {

			try {
				FileWriter fileWriter = new FileWriter(this.filePathOut, false);
				BufferedWriter writer = new BufferedWriter(fileWriter);
				for (Map.Entry<String, Integer> entry : this.newMapSymptome.entrySet()) {
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
