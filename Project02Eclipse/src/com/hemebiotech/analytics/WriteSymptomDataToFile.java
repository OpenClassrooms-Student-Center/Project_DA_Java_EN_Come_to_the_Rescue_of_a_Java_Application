package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
	public static String filepathOut = ".\\Project02Eclipse\\result.out";

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {

		try {
			FileWriter writer = new FileWriter(filepathOut); // create the file result.out

			for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
				writer.write(entry.getKey().toString() + ":" + entry.getValue() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
