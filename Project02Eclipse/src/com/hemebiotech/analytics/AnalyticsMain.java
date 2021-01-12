package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/*
 * This is the main method 
 * The program will read a list of symptoms from a file and count these
 * symptoms, then print the result of the count by sorting it into another file.
 */
public class AnalyticsMain {

	public static void main(String args[]) throws Exception {
		
		ReadSymptomsFromFile readSymptoms = new ReadSymptomsFromFile();
		
		List<String> nameOfSymptoms = readSymptoms.getSymptoms();
		
		CountSymptoms countSymptoms = new CountSymptoms();
		
		Map<String, Integer> counterSymptomsABC = countSymptoms.getCounterSymptomsABC(nameOfSymptoms);
		
		WriteSymptomsInFile writeSymptoms = new WriteSymptomsInFile();
		
		writeSymptoms.writeSymptomsInAFile(counterSymptomsABC);

	}
}