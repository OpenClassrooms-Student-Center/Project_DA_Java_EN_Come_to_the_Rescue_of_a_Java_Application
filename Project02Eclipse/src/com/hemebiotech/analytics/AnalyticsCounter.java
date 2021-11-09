package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	/**
	 * Lire un fichier à partir d'une source/Read a file from a source.
	 */
	static final String inPutFile = "Project02Eclipse/symptoms.txt";
	/**
	 * Écrire le résultat dans un fichier assigné/Write result to an assigned file
	 */
	static final String outPutFile = "Project02Eclipse/result.out";

	public static void main(String args[]) {

		/**
		 * 1) Lire une source de données-Read a data source
		 * 
		 */
		ReadSymptomDataFromFile readingSymptomsFromFile = new ReadSymptomDataFromFile(inPutFile);
		List<String> symptomList = readingSymptomsFromFile.getSymptoms();

		/**
		 * 2) Traiter une liste de données-Process a list of data
		 * 
		 */
		CountAndOrderSymptoms counter = new CountAndOrderSymptoms();
		Map<String, Integer> mapCounted = counter.processData(symptomList);

		/**
		 * 3) Envoyer résultat- Send result
		 */
		GenerateOutput writer = new GenerateOutput(outPutFile);
		writer.writeSymptoms(mapCounted);

	}

}
