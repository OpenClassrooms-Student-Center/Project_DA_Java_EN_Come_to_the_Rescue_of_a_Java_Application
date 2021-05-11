package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounter {
	

	public static void main(String args[]) throws Exception {
		
		
		// TODO recevoir en arguments le nom de fichier d'entree et le nom de fichier de sortie
		String fileIn = args.length > 0 ? args[0] : SymptomFileReader.DEFAULT_FILENAME_IN;
		String fileOut = args.length > 1 ? args[1] : SymptomFileWriter.DEFAULT_FILENAME_OUT;
		
		SymptomFileReader symptomReader = new SymptomFileReader(fileIn);
		SymptomFileWriter symptomWriter = new SymptomFileWriter(fileOut);
		SymptomAnalyser symptomAnalyser = new SymptomAnalyser();
		
		
		//Read all the symptoms
		List<String> symptoms = symptomReader.GetSymptoms();
		
		TreeMap<String, Integer> statistics = symptomAnalyser.count(symptoms);
		
		symptomWriter.export(statistics);
		
	}
}
