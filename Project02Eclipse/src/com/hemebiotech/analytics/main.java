package com.hemebiotech.analytics;

import com.hemebiotech.resources.ISymptomReader;
import com.hemebiotech.resources.ISymptomWriter;
import com.hemebiotech.resources.ReadSymptomDataFromFile;
import com.hemebiotech.resources.WriteSymptomToAFile;

public class main {

	public static void main(String[] args) throws Exception {
		String filepath = "C:\\SRC\\me\\git\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt";
		ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile(filepath);

		IAnalyticsCounter analyticsCounter = new AnalyticsCounter(readSymptomDataFromFile.GetSymptoms());

		ISymptomWriter WriteSymptomToAFile = new WriteSymptomToAFile(analyticsCounter.AnalyticsCount());
		WriteSymptomToAFile.WriteSymptoms();

	}

}
