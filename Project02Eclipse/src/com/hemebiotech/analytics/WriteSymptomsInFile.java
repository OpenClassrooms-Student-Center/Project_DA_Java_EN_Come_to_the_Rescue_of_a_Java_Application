package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 
 * The WriteSymptomsInFile class is used to write the contents of a map to a
 * file.
 * 
 */

public class WriteSymptomsInFile implements ISymptomWriter {

	private String fileName;

	/***
	 * 
	 * update filename
	 * 
	 * @param filename the file name where the writing will be done
	 *
	 */

	public WriteSymptomsInFile(String fileName) {

		this.fileName = fileName;

	}

	/*
	 * Write each symptom and its frequency from the Map to the file
	 * 
	 * 
	 * @param symptomMap Map of symptoms in the key and their frequency in value
	 * 
	 * 
	 * @see AnalyticsCounter#symptomCounter
	 * 
	 * 
	 */
	@Override
	public void writeSymptomsData(Map<String, Integer> symptomMap) {

		try {

			PrintWriter writer = new PrintWriter(fileName);

			for (Entry<String, Integer> symptom : symptomMap.entrySet()) {

				if (!symptom.getKey().isEmpty()) {

					writer.println("+ " + symptom.getKey() + " = " + symptom.getValue());
				}
			}
			writer.close();
			System.out.println("Done!!");

		} catch (FileNotFoundException e) {

			System.err.println("An error occurred while writing the result file" + e.getMessage());

		}

	}

}
