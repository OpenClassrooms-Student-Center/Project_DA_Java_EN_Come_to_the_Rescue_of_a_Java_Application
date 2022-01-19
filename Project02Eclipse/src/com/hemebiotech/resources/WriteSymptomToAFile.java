package com.hemebiotech.resources;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class WriteSymptomToAFile implements ISymptomWriter {

	private Map<String, Integer> dictionaryOfSymptoms;

	public WriteSymptomToAFile(Map<String, Integer> dictionaryOfSymptoms) {
		this.dictionaryOfSymptoms = dictionaryOfSymptoms;
	}

	@Override
	public void WriteSymptoms() throws IOException {
		FileWriter writer = new FileWriter("result.out");

		Set<String> keys = dictionaryOfSymptoms.keySet();
		for (String key : keys) {
			writer.write(key + ";" + dictionaryOfSymptoms.get(key) + "\n");
		}
		writer.close();
	}

}
