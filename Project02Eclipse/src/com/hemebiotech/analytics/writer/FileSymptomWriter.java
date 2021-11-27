package com.hemebiotech.analytics.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * exports symptom list to a given file
 */
public class FileSymptomWriter implements ISymptomWriter {

	private final String filepath;

	/**
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public FileSymptomWriter(String filepath) {
		this.filepath = filepath;
	}

	public void export(TreeMap<String, Integer> sortedSymptoms) {
		try {
			var writer = new FileWriter(this.filepath);
			sortedSymptoms.forEach((key, value) -> {
				try {
					writer.write(key + "=" + value +";\n");
				} catch (IOException e) {
					System.out.println("An error occurred when writing in file " + this.filepath);
					System.exit(1);
				}
			});
			writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred when creating file " + this.filepath);
			System.exit(1);
		}
	}
}
