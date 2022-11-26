package com.hemebiotech.analytics;
 

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		/** Read the symptoms and give feedback
		 */

		ReadAndWriteSymptomDataFile readData = new ReadAndWriteSymptomDataFile();
		List<String> symptoms = readData.GetSymptoms("C:\\Users\\natha\\git\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\bin\\com\\hemebiotech\\analytics\\symptoms.txt");
		
				
		/** Sorting by alphabetical order and occurences
		 */
		
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		Map<String, Integer> groupedSymptoms = analyticsCounter.groupSymptoms(symptoms);
		
				
		/** Output the list to a new folder "result.out"
		 * 
		 */
	
		groupedSymptoms = analyticsCounter.sortOfSymptoms(groupedSymptoms);
 		readData.writeFile("result.out", groupedSymptoms);
 
	}			
	}



