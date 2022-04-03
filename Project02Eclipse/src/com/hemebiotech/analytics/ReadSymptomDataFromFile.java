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
	/**
	 * Function permitting to get the symptoms from the file,
	 * put them in an ArrayList in an alphabetical order and return it. 
	 */
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
	/**
	 * Function putting the symptoms form the ArrayList in an HashMap
	 * and counting the number of occurrences of each symptoms in the ArrayList.
	 * @return the map.
	 */
	
	public Map<String,Integer> getSymptomsOccurences(){
		
		for(String entry:this.list) {
			this.map.putIfAbsent(entry, 0);
			this.map.put(entry, this.map.get(entry)+1);	
		}
		
		
		return this.map;
		
	}
	/**
	 * Function creating a result.out file and writing
	 * the symptoms and their number of occurrences in the HashMap
	 * 
	 */
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
