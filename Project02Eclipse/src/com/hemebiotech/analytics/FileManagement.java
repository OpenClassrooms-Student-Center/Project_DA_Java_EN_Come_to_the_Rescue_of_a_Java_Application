package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Simple brute force implementation
 *
 */
public class FileManagement implements IFileManagement {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public FileManagement(String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();
		
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
		//3 - return map by alphabetic order
		return new TreeMap<>(occurenceBySymptoms);
	}

	@Override
	public void generateSymptomsReport(Map<String, Long> occurenceBySymptoms) {
		FileWriter writer = null;
		try {
			writer = new FileWriter("result.out");
			String symptomLine = null;
			System.out.println("--- DEBUT RAPPORT ---");
			for (String symptom : occurenceBySymptoms.keySet()) {
				symptomLine = symptom + ": " + occurenceBySymptoms.get(symptom) + "\n" ;
				System.out.println(symptomLine);
				writer.write(symptomLine);
			}
			System.out.println("--- FIN RAPPORT ---");
			writer.close();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
