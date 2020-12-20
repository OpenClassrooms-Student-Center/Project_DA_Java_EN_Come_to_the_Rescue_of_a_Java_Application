package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

<<<<<<< HEAD
=======


>>>>>>> 4555bc06e8910c00005375f64aee5859e77f7918
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
<<<<<<< HEAD
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(READFILE);
		ArrayList<String> symptoms = reader.getSymptoms();

		//Compte les symptoms et les met dans une Map : valeur:symptoms/cle:nombre d'occurrences
		AnalyseSymptoms counter = new AnalyseSymptoms();
		Map<String, Integer> map = counter.countSymptoms(symptoms);

		//Ecrit la liste des symptomes triées sur un fichier
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile(WRITEFILE);
		writer.writeSymptoms(map);
		
		
		
=======
		AnalyseSymptom analyse = new AnalyseSymptom(READFILE, WRITEFILE);
		ArrayList<String> symptoms = analyse.getSymptoms();

		// L'ArrayList est envoyé dans la méthode countSymptoms afin de compter les symptoms
		// et les met dans une Map : valeur:symptoms/cle:nombre d'occurrences 
		Map<String, Integer> map = analyse.countSymptoms(symptoms);

		// La Map est envoyée à la méthode writeSymptoms pour écrire le résultat.
		analyse.writeSymptoms(map);

>>>>>>> 4555bc06e8910c00005375f64aee5859e77f7918
	}


}
