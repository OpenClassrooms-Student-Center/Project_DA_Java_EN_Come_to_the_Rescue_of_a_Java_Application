package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {
		
		//1) lire une source de données
		ReadSymptomDataFromFile readerOk = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> listFromFile = readerOk.getSymptoms();
		
		//2) Traiter une liste de données
		CountAndOrderSymptoms counter = new CountAndOrderSymptoms();
		Map<String,Integer> mapCounted = counter.processData(listFromFile);
		
		System.out.println(mapCounted);
		
		//3) Envoyer resultat 
		GenerateOutput writer = new GenerateOutput();
		writer.writeSymptoms(mapCounted);
		
	}



	
}


