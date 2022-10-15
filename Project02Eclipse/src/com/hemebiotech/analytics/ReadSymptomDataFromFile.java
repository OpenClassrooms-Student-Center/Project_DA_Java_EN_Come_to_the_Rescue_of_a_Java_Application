package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
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
		
		return result;
	}

	@Override
	public Map<String, Long> countAndSortSymptoms(List<String> symptomsList) {
		//1 - If symptomsList is null or empty, return empty Map
		if (symptomsList == null || symptomsList.isEmpty()){
			return new HashMap<>();
		}
		//2 - group symptoms by occurences
		Map<String, Long> occurenceBySymptoms = symptomsList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		//3 - return map by alphabethic order
		return new TreeMap<>(occurenceBySymptoms);
	}

}
