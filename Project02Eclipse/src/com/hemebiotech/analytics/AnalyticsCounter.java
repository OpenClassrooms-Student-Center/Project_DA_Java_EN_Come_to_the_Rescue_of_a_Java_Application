package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
		
	public static void main(String args[]) throws Exception {
		//TEST COMMIT
		//READ A LINE ON THE FILE
		try (BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"))) {
			String textOnLine = reader.readLine();
		//CREATE MAP
			Map<String, Integer> mapCounter = new TreeMap<String,Integer>();	
			while (textOnLine != null) {
				//no exist = new data
				if (mapCounter.get(textOnLine) == null){
					mapCounter.put(textOnLine,1);
					System.out.println("NEW : "+textOnLine+" (1)");
				}
				//exist = increment data
				else{
					mapCounter.put(textOnLine,mapCounter.get(textOnLine)+1);
					System.out.println("Increment : "+ textOnLine+" = "+mapCounter.get(textOnLine));
				}
				textOnLine = reader.readLine();
			}
		
		
		// WRITE MAP ON A NEW FILE
		FileWriter writer = new FileWriter ("result.out");
		for (Map.Entry mapentry : mapCounter.entrySet()) {
			writer.write(mapentry.getKey() + " : " + mapentry.getValue()+"\n");
	        }
		writer.close();
		}

	}
}
