package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filepath;

	public WriteSymptomDataToFile(String filename) {

		this.filepath = filename;
	}

	@Override
	public void writeSymptom(Map<String, Integer> symptomsMap) throws IOException {

		FileWriter writer = null;
		try {
			writer = new FileWriter(filepath);
			for (Entry<String, Integer> entry : symptomsMap.entrySet()) {
				writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
			}
		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			writer.close();

		}

	}

}
