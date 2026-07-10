package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Writes symptom data and their occurrence counts to a text file
 * <p>
 * This class implements the {@code ISymptomWriter} interface and saves
 * the content of a map into an output file named {@code output.txt}
 */

public class WriteSymptomDataFromFile implements ISymptomWriter {
	
	// Path to the directory where the output file will be created
	private String filepath;
	
	// Map containing symptoms and their occurrence counts
	private Map<String, Integer> symptomMap;
	
	/**
	 * Creates a new writer for symptom data
	 * <p>
     * @param filepath the path to the directory where the output file will be created
     * <p>
     * @param symptomMap the map containing symptoms and their occurrence counts
	 */
	public WriteSymptomDataFromFile (String filepath, Map<String, Integer> symptomMap) {
		this.filepath = filepath;
		this.symptomMap = symptomMap;
	}
		
	/**
     * Writes the symptom data to the {@code output.txt} file
     * <p>
     * Each entry is written on a separate line
     * <p>
     * @param symptomMap the map containing the symptoms to write
     */
	@Override
	public void WriteSymptoms(Map<String, Integer> symptomMap) {
		try (FileWriter writer = new FileWriter(filepath + "output.txt") ) {
			for (Map.Entry<String, Integer> entry : symptomMap.entrySet()) {
				// System.out.println(entry.getKey() + " : " + entry.getValue() + "\r\n");
				writer.write(entry.getKey() + " : " + entry.getValue() + "\r\n");
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}

