package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;


/** 
 * Main class pour commencer le programme
 * @param args
 * @throws IOException
 */
public class AnalyseMain {

	//Creations de deux constantes qui stockent le fichier entree et le fichier de sortie
	public final static String READFILE = "symptoms.txt";
	public final static String WRITEFILE = "result.out";

	
	/** 
	 * Methode Main pour executer le programme
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		// Instanciation des 3 objets de la classe AnalyseSymptoms 
		AnalyseSymptoms analyticCounter = new AnalyseSymptoms(new ReadSymptomDataFromFile(READFILE), 
		new WriteSymptomDataToFile(WRITEFILE), new CountSymptomFromList());
		
<<<<<<< HEAD
		// creation d'une list qui va recevoir les symptoms sur le fichier symptoms.txt
		List<String> listResult = analyticCounter.getSymptoms();
		
		// creation d'une map qui va recevoir les symptoms comptés et triés
		Map<String, Integer> mapResult = analyticCounter.countSymptoms(listResult);
		

		// La map mapResult de symptoms comptés et triés est renvoyée à la méthode pour l'ecrire sur le fichier result.out
		analyticCounter.writeSymptoms(mapResult);
	
	
		
=======
	
		// Lis le fichier avec la class BufferedReader et les met dans un ArrayList de String
		AnalyseSymptom analyse = new AnalyseSymptom(READFILE, WRITEFILE);
		ArrayList<String> symptoms = analyse.getSymptoms();

		// L'ArrayList est envoyé dans la méthode countSymptoms afin de compter les symptoms
		// et les met dans une Map : valeur:symptoms/cle:nombre d'occurrences 
		Map<String, Integer> map = analyse.countSymptoms(symptoms);

		// La Map est envoyée à la méthode writeSymptoms pour écrire le résultat.
		analyse.writeSymptoms(map);
>>>>>>> 8126feb3ce7f7d5829488901393bbcea18c9eb6a

	}


}

