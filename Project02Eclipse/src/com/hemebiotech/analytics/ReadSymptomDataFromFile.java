package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	/**
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	public Map<String,Integer> getSymptoms() {
		List<String> result = new ArrayList<String>(); 
		if (filepath != null) {
			try {
				FileReader fileReader = new FileReader(filepath);
				BufferedReader reader = new BufferedReader(fileReader);
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}

				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		HashMap<String,Integer> symptomsRes = new HashMap<String,Integer>();
		return CountInstances(result,symptomsRes); // count instances is the method that count the number of instances of each symptom
	}
	
	public  Map<String,Integer> CountInstances(List<String> symptoms,Map<String,Integer> symptomsMap) {
		
		for (String symp : symptoms) {
			if(symptomsMap.containsKey(symp)) {
				symptomsMap.put(symp, symptomsMap.get(symp)+1);
			}
			else {
				symptomsMap.put(symp, 1);
			}
		}
		Map<String,Integer> sortedMap = new TreeMap<>(symptomsMap); // Use of TreeMap because HashMap are unordered 
		
		return sortedMap;
	}

}
