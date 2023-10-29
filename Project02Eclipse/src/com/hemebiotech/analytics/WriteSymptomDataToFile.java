package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Simple implementation
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filePath;

	/**
	 * @param symptoms a map containing symptoms strings and their quantities.
	 */
	public WriteSymptomDataToFile(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * write the symptoms and their quantities in a result.out file.
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
			
		// false passed as the 2nd argument of the FileWriter constructor
		// implies deletion of the contents of the resultat.out file if not empty.
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filePath, false))) {	

			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				String line = entry.getKey() + " : " + entry.getValue();
				writer.write(line);
				writer.newLine();
			}
		} catch (IOException e) {
			System.err.println("Error while writing file " + e.getMessage() + " caused by " + e.getCause());
		}
								
	}
}
