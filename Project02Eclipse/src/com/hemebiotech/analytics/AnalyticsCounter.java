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
		 * 
		 * @analyse Creation d'une instance de classe qui implémente les interfaces
		 */
		Analyse analyse = new Analyse(new ReadSymptomDataFromFile(inPutFile), new CountAndOrderSymptoms(),
				new GenerateOutput(outPutFile));
		/**
		 * lecture à partir de inPutFile 
		 */
		List<String> listNotCounted = analyse.getSymptom();
		/**
		 * compter le nombre d'occurrences et trier les symptômes par ordre alphabétique
		 */
		Map<String, Integer> mapSortedAndCounted = analyse.symtomsCounter(listNotCounted);
		/**
		 * écrire dans outPutFile
		 */
		analyse.writeDataSymptoms(mapSortedAndCounted);

	}
}
