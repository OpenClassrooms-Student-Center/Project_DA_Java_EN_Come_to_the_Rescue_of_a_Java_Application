package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.TreeMap;

public class AnalyticsCounter {
	static BufferedReader symptomsFile;
	final static String pathFile = "C:\\Users\\collo\\IdeaProjects\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\symptoms.txt";
	static TreeMap<String, Integer> result = new TreeMap<String, Integer>();
	
	public static void main(String args[]) throws Exception {
		ReadSymptomDataFromFile readSymptoms = new ReadSymptomDataFromFile(pathFile, symptomsFile);
		symptomsFile  = readSymptoms.GetSymptoms();
		CountSymptom countSymptom = new CountSymptom(symptomsFile, result);
		countSymptom.count();
		System.out.println(result);
		// next generate output
		//FileWriter writer = new FileWriter ("result.out");
		//writer.write("headache: " + headacheCount + "\n");
		//writer.write("rash: " + rashCount + "\n");
		//writer.write("dialated pupils: " + pupilCount + "\n");
		//writer.close();
	}
}
