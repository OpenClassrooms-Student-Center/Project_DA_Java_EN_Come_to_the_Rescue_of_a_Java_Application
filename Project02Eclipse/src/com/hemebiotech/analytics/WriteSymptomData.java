package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteSymptomData implements ISymptomWriter {

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
	public void WriteSymptoms(ArrayList<String> listeSymptomes) {

		try {
			FileWriter writer = new FileWriter(filepath);
			for (int i = 0; i < listeSymptomes.size(); i++) {
				if (i == listeSymptomes.size() - 1) {
					writer.write(listeSymptomes.get(i));
				} else {
					writer.write(listeSymptomes.get(i) + "\n");
				}
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
