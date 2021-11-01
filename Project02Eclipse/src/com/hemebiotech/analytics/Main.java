package com.hemebiotech.analytics;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 
 * Main
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {

		File doc = new File ("symptoms.txt");
		
		List<String> list = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile();
		list = readSymptomDataFromFile.getSymptoms(doc); 
		
		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		map = analyticsCounter.count(list); 
		
		Writer writer = new Writer();
		writer.writer(map); 
	}
}