package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		FileWriter writer = null;
		try {
			// code
			writer = new FileWriter("result.out");
			writer.write("headache: " + symptoms.get("headache") + "\n");
			writer.write("rash: " + symptoms.get("rash") + "\n");
			writer.write("dialated pupils: " + symptoms.get("pupils") + "\n");
			writer.close();

		} catch (Exception e) {
			// gestion de l'exception
			e.printStackTrace();
		}
		
	}

}
