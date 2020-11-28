package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;


public class WriteSymptomDataToFile implements ISymptomWriter{
	
	
		private String filepath;
		private Map<String, Integer> symptoms;

	    /**
	     * @param filepath a full or partial path to file to write in
	     * @param symptoms a map with a symptom as key and the count of appearance as value
	     */
	    public WriteSymptomDataToFile(String filepath, Map<String, Integer> ListOccurences) {
	        this.filepath = filepath;
	        this.symptoms = ListOccurences;
	        
	        
	    }

	    @Override
	    public void writeSymptoms() {
	    	
	    	

	        if (symptoms != null) {
	            //Use Stream to sort the symptoms then return a LinkedHashMap to keep it sorted
	            Map<String, Integer>  sortedSymptoms= symptoms.entrySet().stream()
	                    .sorted(Map.Entry.comparingByKey())
	                    .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
	                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
	     
	            

	         if (filepath != null) {
	                //Iterate through the LinkedHashMap to write the symptoms in the file
	                try {
	                    BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));
	                    for (Map.Entry<String, Integer> symptom : sortedSymptoms.entrySet()) {
	                        writer.write(symptom.getKey() + " = " + symptom.getValue() + "\n");
	                    }
	                    writer.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                    
	                     
	                }
	            }
	        }
	    }


}