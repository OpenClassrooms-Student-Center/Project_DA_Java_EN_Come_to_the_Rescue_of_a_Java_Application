package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

/**
 * @author didier
 */
public class AnalyticsCounter {

	public static void main(String[] args) throws IOException {

		// extraction des données dans le fichier
		ISymptomReader file = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		List<String> symptomsFile = file.getSymptoms();
		// comptage des symptoms.
		Icomptage icomptage = new Comptage();
		TreeMap<String, Integer> symptomsCompte = icomptage.comptageSymptomsData(symptomsFile);
		// Ecriture dans le fichier results.out
		IFileWriterData iFileWriterData = new FileWriterData();
		iFileWriterData.writeSymptomsData(symptomsCompte);

	}

}