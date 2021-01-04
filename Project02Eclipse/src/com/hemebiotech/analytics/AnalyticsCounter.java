package com.hemebiotech.analytics;

import java.util.TreeMap;

public class AnalyticsCounter {

	public static void main(String[] args)
	{
		ReadSymptomDataFromFile readSymptomData = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		TreeMap<String,Integer> symptoms = readSymptomData.getSymptoms();/*Read the data in the specified file and put it in a TreeMap,
																		in the alphabetical order, counting the occurrences of each symptom.*/

		WriteSymptomsInFile allSymptoms = new WriteSymptomsInFile("result.out");
		allSymptoms.writeInFile(symptoms);//write the symptoms from the TreeMap in a new file called result.out, one per line.
	}
}


