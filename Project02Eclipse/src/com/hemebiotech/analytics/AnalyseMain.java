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
		AnalyseSymptom reader = new AnalyseSymptom(READFILE, null, null);
		ArrayList<String> symptoms = reader.getSymptoms();

		// L'ArrayList est envoyé dans la méthode countSymptoms afin de compter les symptoms
		// et les met dans une Map : valeur:symptoms/cle:nombre d'occurrences 
		AnalyseSymptom counter = new AnalyseSymptom(null, null, null);
		Map<String, Integer> list = counter.countSymptoms(symptoms);

		// La Map est envoyée à la méthode writeSymptoms pour écrire le résultat.
		AnalyseSymptom  writer = new AnalyseSymptom(WRITEFILE, null, list);
		writer.writeSymptoms();
		
		
		
		

	}


}
