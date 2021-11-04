package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		//Analyse analyse = new Analyse(new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt"));
				
		//1) lire une source de données
		ReadSymptomDataFromFile readingSymptomsFromFile = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		// doing some operations
		List<String> symptomList = readingSymptomsFromFile.getSymptoms();
		
		//2) Traiter une liste de données
		CountAndOrderSymptoms counter = new CountAndOrderSymptoms();
		Map<String,Integer> mapCounted = counter.processData(symptomList);
		
		System.out.println(mapCounted);
		
		//3) Envoyer resultat 
		GenerateOutput writer = new GenerateOutput();
		writer.writeSymptoms(mapCounted);
		 
	}



	
}


