package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filepath;

	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try (FileWriter writer = new FileWriter(filepath)) {
			for (Map.Entry<String, Integer> symptom : symptoms.entrySet()) {
				writer.write(symptom.getKey() + ": "+ symptom.getValue() + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
