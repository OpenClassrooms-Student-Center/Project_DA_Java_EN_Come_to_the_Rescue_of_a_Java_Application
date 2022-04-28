package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
		this.filepath = filepath;}
	
	public HashMap<String,Integer> GetSymptoms() {
		
		HashMap<String,Integer> allSymptoms = new HashMap<String,Integer>();
		
		if (this.filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(this.filepath));
				String line = reader.readLine();
				
				while ((reader.readLine())!=null) {
					try {	
					allSymptoms.put(line, allSymptoms.getOrDefault(line,0)+1);
					}catch(NullPointerException e) {
						System.out.println("Null");
					}
					line = reader.readLine();
					
					
				}
				reader.close();
				System.out.println(allSymptoms);
					
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		//Sorting alphabetically
		return allSymptoms;
	}

}
