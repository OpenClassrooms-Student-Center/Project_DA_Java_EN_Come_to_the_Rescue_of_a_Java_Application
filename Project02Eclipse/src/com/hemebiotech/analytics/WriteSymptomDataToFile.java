package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;
import java.util.Map.Entry;

public class WriteSymptomDataToFile implements ISymptomWriter {

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		FileWriter writer = null;
		try {
			writer = new FileWriter("result.out");
			for (Entry<String, Integer> entry : symptoms.entrySet())
				writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
			writer.close();

		} catch (Exception e) {
			// gestion de l'exception
			e.printStackTrace();
		}

	}

}
