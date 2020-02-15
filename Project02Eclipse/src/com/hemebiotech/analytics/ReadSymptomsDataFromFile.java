package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Map;

public class ReadSymptomsDataFromFile implements ISymptomReader {
	private String filePath;
	
	public ReadSymptomsDataFromFile(String pfilePath) {
		this.filePath = pfilePath.trim();
	}
	
	public Map<String, Integer> GetSymptoms() {
		Map<String, Integer> symptoms = new TreeMap<String, Integer>();
		
		if (this.filePath != null || this.filePath != "") {
			try ( BufferedReader reader = new BufferedReader (new FileReader(this.filePath))) {
				String line = reader.readLine();
				
				
				while (line != null) {
					line = line.toLowerCase();
					line = line.trim();
					if (symptoms.containsKey(line)) {
						symptoms.put(line, symptoms.get(line) + 1);
					} else {
						symptoms.put(line, 1);
					}
					line = reader.readLine();
				}
			} catch (IOException e) {
				  e.printStackTrace();
			}
		}
		
		return symptoms;
	}
}
