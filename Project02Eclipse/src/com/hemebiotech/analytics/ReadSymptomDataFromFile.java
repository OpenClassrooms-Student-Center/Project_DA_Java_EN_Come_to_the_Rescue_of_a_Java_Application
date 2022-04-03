package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
	private List<String> list = new ArrayList<>();
	private Map<String,Integer> map = new HashMap<>();
	
	
	
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
		
		for(String entry:this.list) {
			this.map.putIfAbsent(entry, 0);
			this.map.put(entry, this.map.get(entry)+1);	
		}
		
		
		return this.map;
		
	}
	
	public void printSymptoms () {
		File file = new File("result.txt");
		try {
		FileWriter filewriter = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(filewriter);
		for(Map.Entry<String,Integer> entry : this.map.entrySet()) {
			writer.write(entry.getKey()+": " + entry.getValue());
			writer.write("\n");	
		}
		writer.close();
	} catch(Exception e) {
		
	}
	
	}
}
