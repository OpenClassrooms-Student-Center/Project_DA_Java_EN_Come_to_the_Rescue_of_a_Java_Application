package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteMapSymtomDataInFile implements ISymptomWriter {
	/**
	 * Create a new file if doens't exist and remove all content if already exist, then instantiate a BufferedWriter
	 * and iterate over symptoms. For each key/value in symptoms, write it in test.out and then go to the line.
	 * 
	 * @param symptoms is a Map object containing the name of a symptom as a key and it's occurrences as a value. 
	 */
	public void createFile(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter("Project02Eclipse\\results.out"); BufferedWriter bw = new BufferedWriter(writer)) {
        	for (Map.Entry<String, Integer> entry: symptoms.entrySet()) {
        		bw.write(entry.getKey() + " : " + entry.getValue());
        		bw.newLine();
        	}
        } catch (IOException e) {
			e.printStackTrace();
		}
	}
}
