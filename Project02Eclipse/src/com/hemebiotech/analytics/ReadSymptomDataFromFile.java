package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public String getFilepath() {
		return filepath;
	}
	public ReadSymptomDataFromFile (String filepath){
		this.filepath = filepath;
	}
	
	@Override
	public List<String> GetSymptoms(List<String>list) {
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					list.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Collections.sort(list);
		
		return list;
	}
	
	public Map<String,Integer> getSymptomsOccurences(List<String> list){
		Map <String, Integer> Symptoms = new HashMap<>();
		
		for(String entry:list) {
			Symptoms.putIfAbsent(entry, 0);
			Symptoms.put(entry, Symptoms.get(entry)+1);	
		}
		
		
		return Symptoms;
		
	}
	
	public static void printSymptoms (Map<String,Integer>map) {
		File file = new File("result.out");
		FileReader filewriter = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(filewriter);
		for(Map.Entry<String,Integer> entry : map.entrySet()) {
			writer.write(entry.getKey()+": " + entry.getValue());
			writer.newLine();
		}
	}
	
}
