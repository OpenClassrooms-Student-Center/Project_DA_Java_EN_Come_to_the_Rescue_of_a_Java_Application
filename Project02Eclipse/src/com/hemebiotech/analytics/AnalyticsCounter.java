package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.util.TreeMap;

public class AnalyticsCounter {
	static BufferedReader symptomsFile;
	final static String pathFile = "C:\\Users\\collo\\IdeaProjects\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt";
	static TreeMap<String, Integer> result = new TreeMap<>();
	
	public static void main(String[] args) {
		try {
			ReadSymptomDataFromFile readSymptoms = new ReadSymptomDataFromFile(pathFile, symptomsFile);
			symptomsFile  = readSymptoms.GetSymptoms();
			CountSymptom countSymptom = new CountSymptom(symptomsFile, result);
			countSymptom.count();
			WriteSymptom writeSymptom = new WriteSymptom(result);
			writeSymptom.write();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
