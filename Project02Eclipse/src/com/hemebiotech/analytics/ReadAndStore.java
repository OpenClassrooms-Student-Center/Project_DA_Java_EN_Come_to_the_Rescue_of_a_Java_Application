/**
 * 
 */
package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
/**
 * @author gnorman
 *
 */
public class ReadAndStore {
	public void symptomsReaderAndStorer(){
		try {
			BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"));
			String line = reader.readLine();
			HashMap<String, Integer> symptomsMap = new HashMap<String, Integer>();

			while (line != null) {	
				symptomsMap.put(line, symptomsMap.getOrDefault(line, 0) + 1);
				line = reader.readLine();		
			}
			reader.close();
			for(String i: symptomsMap.keySet()) {
				System.out.println("key: " + i + " value: " + symptomsMap.get(i));
			}
		}
		catch(Exception e){
			System.out.println("File not found.");
		}

	}	
}
