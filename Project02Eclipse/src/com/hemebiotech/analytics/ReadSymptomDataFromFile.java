package com.hemebiotech.analytics;

import java.io.BufferedReader;
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
	private List<String> list;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public String getFilepath() {
		return filepath;
	}
	public ReadSymptomDataFromFile (String filepath, List<String> list){
		this.filepath = filepath;
		this.list = list;
	}
	
	@Override
	public List<String> GetSymptoms() {
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					this.list.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Collections.sort(this.list);
		
		return this.list;
	}
	
	public Map<String,Integer> getSymptomsOccurences(){
		Map<String,Integer> uniqueSymptoms = new HashMap<>();
		for(String entry:list) {
			uniqueSymptoms.putIfAbsent(entry, 0);
			uniqueSymptoms.put(entry, uniqueSymptoms.get(entry)+1);	
		}
		
		return uniqueSymptoms;
		
	}
	


}
