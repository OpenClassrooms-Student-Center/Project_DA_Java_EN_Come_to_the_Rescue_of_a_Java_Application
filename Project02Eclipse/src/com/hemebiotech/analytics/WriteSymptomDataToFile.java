package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {

		FileWriter writer = null;
		try {
			writer = new FileWriter(".\\Project02Eclipse\\result.out"); // create the file result.out

			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				System.out.println(entry.getKey().toString() + " " + entry.getValue());
				writer.write(entry.getKey().toString() + " " + entry.getValue() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
