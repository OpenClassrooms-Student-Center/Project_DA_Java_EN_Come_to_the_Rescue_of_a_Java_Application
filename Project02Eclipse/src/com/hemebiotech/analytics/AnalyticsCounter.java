package com.hemebiotech.analytics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		
		List<String> list_symptoms = reader.GetSymptoms();
		ISymptomCounter counter = new SymptomsCounter();
		HashMap<String, Integer> occurence_symptoms = counter.GetSymptomsOccurence(list_symptoms);
		
		
		
		
		// next generate output
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		writer.writeSymptom(occurence_symptoms); // writeSymptom
		/*FileWriter writer = new FileWriter ("result.out");
		for (Entry<String, Integer> entry : symptoms_map.entrySet()) {
			writer.write(entry.getKey()+":" + entry.getValue() + "\n");	
		}
		
		
		writer.close();*/
	}
}
