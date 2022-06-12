package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SymptomOut {
	
	
	
	public static void editFinalFile(Map<String, Integer> map) {
		
	File resultOut = new File("Project02Eclipse/results.out.txt");
	 Map<String, Integer> listmap = new TreeMap<String, Integer>(map);
	
	try(BufferedWriter writter = new BufferedWriter(new FileWriter(resultOut))){
		
	
		for (Entry<String, Integer> entry : listmap.entrySet()) {
			String symptomName = entry.getKey();
			Integer numbers = entry.getValue();
			writter.write((symptomName + " = " + numbers + "\n"));
			
		}
		
		writter.flush();
		writter.close();
		
		
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	System.out.println("File location: " + resultOut.getAbsolutePath());
	
	
	
	
	
	
	
	
	}

}
