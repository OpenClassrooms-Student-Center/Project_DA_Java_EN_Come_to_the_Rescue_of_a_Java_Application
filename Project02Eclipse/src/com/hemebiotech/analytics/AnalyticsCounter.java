package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
/**
 * 
 * @author Maxime
 *
 */

public class AnalyticsCounter {
	
	TreeMap<String, Integer> resultat = new TreeMap<String, Integer>();
	
	public void readSortSymptoms() {
		
		ReadSymptomDataFromFile rs = new ReadSymptomDataFromFile("symptoms.txt");

		resultat = rs.GetSymptoms();
		
	}
	
	public void writeSymptoms() {
		FileWriter writer;
		try {
			writer = new FileWriter ("result.out");
			for (Map.Entry<String, Integer> element : resultat.entrySet()) {
				System.out.println(element.getKey() + " = " + element.getValue());
				writer.write(element.getKey() + " = " + element.getValue() + "\n");
			}
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}