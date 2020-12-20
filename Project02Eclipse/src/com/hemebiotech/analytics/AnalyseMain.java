package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


/** 
 * Main class pour commencer le programme
 * @param args
 * @throws IOException
 */
public class AnalyseMain {

	
	public final static String READFILE = "symptoms.txt";
	public final static String WRITEFILE = "result.out";
	
	/** 
	 * Methode Main pour executer le programme
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		
	
		// Lis le fichier avec la class BufferedReader et les met dans un ArrayList de String

		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(READFILE);
		ArrayList<String> symptoms = reader.getSymptoms();

		//Compte les symptoms et les met dans une Map : valeur:symptoms/cle:nombre d'occurrences
		AnalyseSymptoms counter = new AnalyseSymptoms();
		Map<String, Integer> map = counter.countSymptoms(symptoms);

		//Ecrit la liste des symptomes triées sur un fichier
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile(WRITEFILE);
		writer.writeSymptoms(map);
		
		
		

	}


}
