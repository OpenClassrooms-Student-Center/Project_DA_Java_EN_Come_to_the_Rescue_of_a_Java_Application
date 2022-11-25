package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;

import obj.AnalyticsCounter;

public class Main {
	

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String filePathIn = "./fichiers/symptoms.txt";
		String filePathOut = "./fichiers/result.out";
		AnalyticsCounter analysis = new AnalyticsCounter(filePathIn, filePathOut/*, new ReadSymptomDataFromFile(), new AnalyseSymptomsFromList(), new WriteSymptomsInFile()*/);
		analysis.readFile();
		analysis.analyseData();
		analysis.writeFile();
		
//		Map<String,Integer> mapNontriee = new HashMap<>();
//		Map<String,Integer> mapTriée = new TreeMap<>();
		

	}

}
