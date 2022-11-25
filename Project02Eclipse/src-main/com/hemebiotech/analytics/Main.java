package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.IOException;

import impl.AnalyseSymptomsFromList;
import impl.ReadSymptomDataFromFile;
import impl.WriteSymptomsInFile;
import obj.AnalyticsCounter;

public class Main {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		String filePathIn = "./fichiers/symptoms.txt";
		String filePathOut = "./fichiers/result.out";
//		AnalyticsCounter analysis = new AnalyticsCounter(filePathIn, filePathOut);
		AnalyticsCounter analysis = new AnalyticsCounter(filePathIn, filePathOut, new ReadSymptomDataFromFile(filePathIn), new AnalyseSymptomsFromList(), new WriteSymptomsInFile(filePathOut));
		analysis.readFile();
		analysis.analyseData();
		analysis.writeFile();
		
		
	}

}
