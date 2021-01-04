package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;
//import java.util.TreeMap;

/**
 * Class representing count of the occurrence of the words 
 * of a txt file and to export it to a result.out file 
 * by classifying the ailments in alphabetical order. 
 */
public class Main {

	public static void main(String[] args) {

		String filepath = "Symptoms.txt";
		
		ReadSymptomDataFromFile symptomDataFromFile = new ReadSymptomDataFromFile();
		ArrayList<String> listSymptomWithDuplicat = symptomDataFromFile.getSymptomsWithDuplicate(filepath);
		Map<String, Integer> symptomsRate = symptomDataFromFile.getSymptomsRate(listSymptomWithDuplicat);
		
		WriteSymptomRateFromFile dataFromFile = new WriteSymptomRateFromFile();
		dataFromFile.writerSymptomsToFile(symptomsRate,"result.out");

	}

}