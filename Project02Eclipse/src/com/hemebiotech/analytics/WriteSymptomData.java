package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomData implements ISymptomWriter {

	public static final String MESSAGE_IO_ERROR = "Problème de création ou d'écriture sur le fichier results.out - arrêt du traitement";
	public static final String MESSAGE_FILE_CLOSE_ERROR = "Impossible de refermer le fichier ouvert en écriture";

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file to write with type of symptom
	 *                 strings and number of occurrence in it, one per line
	 */
	public WriteSymptomData(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void WriteSymptoms(Map<String, Integer> listSymptoms) {

		FileWriter writer = null;

		try {
			writer = new FileWriter(filepath);
			for (Map.Entry<String, Integer> m : listSymptoms.entrySet()) {
				writer.write(m.getKey() + " : " + m.getValue() + "\n");
				}
			writer.close();
		} catch (IOException e) {
			System.out.println(MESSAGE_IO_ERROR);
			System.exit(-1);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException f) {
					System.out.println(MESSAGE_FILE_CLOSE_ERROR);
				}
			}
		}
	}
}
