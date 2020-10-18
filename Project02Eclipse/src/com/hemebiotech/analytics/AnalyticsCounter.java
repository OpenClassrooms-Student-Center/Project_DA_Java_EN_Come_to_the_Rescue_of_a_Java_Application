package com.hemebiotech.analytics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


/**
 * Classe permettant de compter le nombre de symptomes dans un fichier texte
 * @author Fouad
 * 
 */
public class AnalyticsCounter {
	
/**
 * 	
 * @param args
 * @throws Exception
 */
	
	public static void main(String args[]) throws Exception {

		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();
		
		 ArrayList <String> list_symptoms = new ArrayList<String>();
		while (line != null) {
			
			System.out.println("symptom from file: " + line);
			list_symptoms.add(line);

			line = reader.readLine();	// get another symptom
			
		}
		
		reader.close();
		
		HashMap<String, Integer> symptoms_map = new HashMap<>();
		for(int j=0; j<list_symptoms.size(); j++) {
		symptoms_map.put(list_symptoms.get(j), 1);	
			
		}
		
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		for (Entry<String, Integer> entry : symptoms_map.entrySet()) {
			writer.write(entry.getKey()+":" + entry.getValue() + "\n");	
		}
		
		
		writer.close();
	}
}
