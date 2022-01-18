package com.hemebiotech.analytics;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write result symptoms file
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filepath;

	/**
	 * @name: WriteSymptomDataToFile
	 * @description: create an objet with the filepath
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * @name: WriteSymptomsCount
	 * @description: write a filename whithin the count of symptoms
	 * @param HashMap of Symptom and number
	 * Format of records: Symptom : number
	 */
	@Override
	public void WriteCountSymptoms(Map<String, Integer> countSymptoms) {
		if (filepath != null) {
			FileWriter fileWriter = null;
			BufferedWriter writer = null;
			try {
				fileWriter = new FileWriter(filepath, false);
				writer = new BufferedWriter(fileWriter);
				for (Map.Entry mapEntry : countSymptoms.entrySet()) {
					writer.write(mapEntry.getKey().toString() + " : " + mapEntry.getValue());
					writer.newLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (writer != null) {
						writer.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
