package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	final static String inputFilePath = "/Users/remax/OneDrive/Documents/openclassrooms/developpeur-java/projet2/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt";

	public static void main(String[] args) {
		// creating an instance of ReadSymptomDataFromFile
		ReadSymptomDataFromFile readingSymptomsFromFile = new ReadSymptomDataFromFile(inputFilePath);
		// doing some operations
		List<String> symptomList = readingSymptomsFromFile.GetSymptoms();

		// creating an instance of CountAndSortSymptomFromList
		CountAndSortSymptomFromList analyzingSymptomsFromList = new CountAndSortSymptomFromList(symptomList);
		// doing some operations
		Map<String, Integer> unsortedSymptoms = analyzingSymptomsFromList.GetSymptomsOccurrences();
		TreeMap<String, Integer> sortedSymptoms = analyzingSymptomsFromList
				.SortSymptomsAlphabetically(unsortedSymptoms);
		System.out.println(sortedSymptoms);
	}

}
