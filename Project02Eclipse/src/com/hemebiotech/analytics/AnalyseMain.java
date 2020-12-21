package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class AnalyseMain {

	/** 
	 * Main class pour commencer le programme
	 * @param args
	 * @throws IOException
	 */
	
	public final static String READFILE = "symptoms.txt";
	public final static String WRITEFILE = "result.out";
	
	
	public static void main(String[] args) throws IOException {
		
		
	
		// Lis le fichier avec la class BufferedReader et les met dans un ArrayList de String
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(READFILE);
		ArrayList<String> result = reader.GetSymptoms();

		//Compte les symptoms et les met dans une Map : valeur:symptoms/cle:nombre d'occurrences
		CountSymptom counter = new CountSymptom();
		Map<String, Integer> MapList = counter.countSymptoms(result);

		//Ecrit la liste des symptomes triées sur un fichier
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile(WRITEFILE, MapList);
		writer.writeSymptoms(MapList);
		
		
		

	}


}
