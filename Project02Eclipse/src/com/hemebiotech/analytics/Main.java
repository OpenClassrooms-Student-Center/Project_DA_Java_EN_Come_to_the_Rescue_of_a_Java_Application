package com.hemebiotech.analytics;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/*
 * Main class : use to launch the program
 */
public class Main extends AnalyticsCounter {
	
	
	public static void main(String[] args) throws IOException {

		
		
		/*
		 * Find the file symptom.txt and return a list in Eclipse
		 */
		
		ISymptomReader reader = new ReadSymptomDataFromFile ();
		List<String> listsymptoms = reader.GetSymptoms("/Users/alexandrecabanis/git/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/src/com/hemebiotech/analytics/symptoms.txt");
	

		/*
		 *  Count the occurrences of symptoms in the list
		 *  Create a symptoms list in alphabetical order
		 */
		ICountSymptoms symptomCounter = new AnalyticsCounter();
		Map<String, Integer> symptoms = symptomCounter.countSymptoms(listsymptoms);
		
		
	
		/*
		 * Create a new file with the symptoms list and all the occurrences
		 * Name the file : Result.out
		 */
		File fileOut = new File("Results.out");
		IPrintResult resultFile = new PrintResult();
		resultFile.CreateFile(symptoms, fileOut);
		
}
}
	


