package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class AnalyticsMain {

	public static void main(String args[]) throws Exception {
		
		ReadSymptomsFromFile readSymptoms = new ReadSymptomsFromFile();
		
		List<String> nameOfSymptoms = readSymptoms.GetSymptoms();
		
		CountSymptoms countSymptoms = new CountSymptoms();
		
		Map<String, Integer> counterSymptomsABC = countSymptoms.getCounterSymptomsABC(nameOfSymptoms);
		
		WriteSymptomsInFile writeSymptoms = new WriteSymptomsInFile();
		
		//System.out.println(writeSymptoms);
		
		writeSymptoms.WriteSymptomsInAFile(counterSymptomsABC);

	}
}