package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class AnalyseDriver {

	/** 
	 * Main class pour commencer le programme
	 * @param args
	 * @throws IOException
	 */
	
	public static String readFile = "symptoms.txt";
	public static String writeFile = "result.out";
	
	
	public static void main(String[] args) throws IOException {
		
		
	
		// Lis le fichier avec la class BufferedReader et return une ArrayList de String
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(readFile);
		ArrayList<String> result = reader.GetSymptoms();

		//Compte les symptoms et les met dans une Map : valeur:symptoms/cle:nombre d'occurrences
		Map<String, Integer> ListOccurences = CountSymptom.countSymptoms(result);

		//Ecrit la liste des symptomes triées sur un fichier
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile(writeFile, ListOccurences);
		writer.writeSymptoms();
		
		
		

	}


}
