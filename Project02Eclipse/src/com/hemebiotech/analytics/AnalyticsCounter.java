package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AnalyticsCounter {
		
	public static void CountFrequency(List<String> list) {
		
		// hashmap to store the frequency of element 
        Map<String, Integer> hashMapFrequency = new HashMap<String, Integer>(); 
  
        for (String i : list) { 
            Integer j = hashMapFrequency.get(i); 
            hashMapFrequency.put(i, (j == null) ? 1 : j + 1); 
        } 
        
        // displaying the occurrence of elements in the arraylist 
        for (Map.Entry<String, Integer> val : hashMapFrequency.entrySet()) { 
            System.out.println("Symptom --> "+ val.getKey() +" "+"-->  x"+ val.getValue()); 
        }
	}

	public static void main(String args[]) throws Exception {

		// get file from path
		String symptomsFile = new File("Project02Eclipse/symptoms.txt").getCanonicalPath();

		// create ReadSymptomDataFromFile and add path file in parameter
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(symptomsFile);

		// create variable "result" with function result in a array list
		List<String> result = reader.GetSymptoms();
		
		//use function CounFrequency
		CountFrequency(result);

		// generate output file
		File resultTxt = new File("result.out");
		
//		 write in file result.out
//		FileWriter writer = new FileWriter(resultTxt);
//		writer.write();
//		writer.close();
	}

}
