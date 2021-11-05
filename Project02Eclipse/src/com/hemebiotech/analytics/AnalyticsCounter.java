package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	static final String inPutFile = "Project02Eclipse/symptoms.txt";

	public static void main(String args[]) {

		// 1) Lire une source de donn�es-Read a data source
		ReadSymptomDataFromFile readingSymptomsFromFile = new ReadSymptomDataFromFile(inPutFile);
		List<String> symptomList = readingSymptomsFromFile.getSymptoms();

		// 2) Traiter une liste de donn�es-Process a list of data
		CountAndOrderSymptoms counter = new CountAndOrderSymptoms();
		Map<String, Integer> mapCounted = counter.processData(symptomList);

		// 3) Envoyer r�sultat- Send result
		GenerateOutput writer = new GenerateOutput();
		writer.writeSymptoms(mapCounted);

	}

}
