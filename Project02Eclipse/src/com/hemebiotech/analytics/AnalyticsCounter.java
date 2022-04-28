package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AnalyticsCounter {
		
	public static void main(String args[]) throws IOException {
		
		
		ReadSymptomDataFromFile newFile = new ReadSymptomDataFromFile("symptoms.txt");
		HashMap<String, Integer> symptoms = newFile.GetSymptoms(); 
		WriteResultToFile newOutputFile = new WriteResultToFile("result.out",symptoms);
		newOutputFile.write();
					
	}
	
}
