package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;

public class ReadSymptomsDataFromFile implements ISymptomReader {
	private String filePath;
	
	public ReadSymptomsDataFromFile(String pfilePath) {
		this.filePath = pfilePath.trim();
	}
	
	public Map<String, Integer> GetSymptoms() {
		Map<String, Integer> symptoms = new HashMap<String, Integer>();
		
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
	
	public Map<String, Integer> sortSymptomsByKey(Map<String, Integer> symptomsList) {
		Map<String, Integer> sortedSymptomsByKey = new TreeMap<String, Integer>(symptomsList);
		return sortedSymptomsByKey;
	}
	
	public Map<String, Integer> sortSymptomsByValue(Map<String, Integer> symptomsList) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(symptomsList.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<String, Integer> sortedSymptomsByValue = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
        	sortedSymptomsByValue.put(entry.getKey(), entry.getValue());
        }

        return sortedSymptomsByValue;
	}
}
