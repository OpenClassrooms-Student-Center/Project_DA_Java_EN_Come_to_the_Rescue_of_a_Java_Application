package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

	static final String inPutFile = "Project02Eclipse/symptoms.txt";

	public static void main(String args[]) {

		// 1) Lire une source de données-Read a data source
		ReadSymptomDataFromFile readingSymptomsFromFile = new ReadSymptomDataFromFile(inPutFile);
		List<String> symptomList = readingSymptomsFromFile.getSymptoms();

		// 2) Traiter une liste de données-Process a list of data
		CountAndOrderSymptoms counter = new CountAndOrderSymptoms();
		Map<String, Integer> mapCounted = counter.processData(symptomList);

		// 3) Envoyer résultat- Send result
		GenerateOutput writer = new GenerateOutput();
		writer.writeSymptoms(mapCounted);

	}

}
