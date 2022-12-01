package com.hemebiotech.analytics.main;

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
		
		AnalyticsCounter analysis = new AnalyticsCounter(new ReadSymptomDataFromFile(filePathIn), new AnalyseSymptomsFromList(),
				new WriteSymptomsInFile(filePathOut));
		analysis.readData();
		analysis.analyseData();
		analysis.writeData();

	}

}
