package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filepath;

	public WriteSymptomDataToFile(String filename) {
		// TODO Auto-generated constructor stub
		this.filepath = filename;
	}

	@Override
	public void writeSymptom(Map<String, Integer> symptoms_map) throws IOException {
		// TODO Auto-generated method stub

		FileWriter writer = null;
		try {
			writer = new FileWriter(filepath);
			for (Entry<String, Integer> entry : symptoms_map.entrySet()) {
				writer.write(entry.getKey() + ":" + entry.getValue() + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			writer.close();

		}

	}

}
