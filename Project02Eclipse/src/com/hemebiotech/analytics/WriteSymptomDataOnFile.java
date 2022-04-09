package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WriteSymptomDataOnFile {
	private Map<String,Integer> map = new LinkedHashMap<>();

	public Map<String,Integer> getMap() {
		return map;
	}
	
	/**
	 * Function putting the symptoms form the ArrayList in an HashMap
	 * and counting the number of occurrences of each symptoms in the ArrayList.
	 * @return the map.
	 */

	public void setMap(List<String> list) {
		for(String entry:list) {
			this.map.putIfAbsent(entry, 0);
			this.map.put(entry, this.map.get(entry)+1);	
		}
	}
	/**
	 * Function creating a result.out file and writing
	 * the symptoms and their number of occurrences in the HashMap
	 * 
	 */
	public void printSymptoms () {
		File file = new File("result.out");
		try {
		FileWriter filewriter = new FileWriter(file);
		BufferedWriter writer = new BufferedWriter(filewriter);
		for(Map.Entry<String,Integer> entry : this.map.entrySet()) {
			writer.write(entry.getKey()+": " + entry.getValue());
			writer.write("\n");	
		}
		writer.close();
	} catch(IOException e) {
		e.printStackTrace();
	}
	
	}
	

}
