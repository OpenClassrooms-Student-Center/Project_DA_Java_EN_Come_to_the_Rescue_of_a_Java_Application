package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
	public String filepathWriteFile;

	public WriteSymptomDataToFile(String filepath) {
		this.filepathWriteFile = filepath;
	}

	/**
	 * This method create a file filepathOut and write the symptoms and its
	 * occurrence from a raw called symptoms contains symptoms (key) and occurrence
	 * (value)
	 * 
	 * @exception IOException Exception if the input file is not found
	 * @exception Exception   if an error produced by failed or interrupted I/O
	 *                        operations
	 * @param symptoms raw with symptoms (key) and occurrence (value)
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {

		try {
			FileWriter writer = new FileWriter(filepathWriteFile);

			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey().toString() + ":" + entry.getValue() + "\n");
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}