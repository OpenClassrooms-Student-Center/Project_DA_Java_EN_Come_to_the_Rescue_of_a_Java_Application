package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter  {


	public ISymptomWriter writer;
	public ISymptomReader reader;


	public AnalyticsCounter (ISymptomReader reader, ISymptomWriter writer) {

		this.reader = new ReadSymptomDataFromFile("C:\\Users\\emman\\git\\jurquet_emmanuel_debug_java\\Project02Eclipse\\symptoms.txt");
		this.writer = new WriteSymptomDataToFile();


	}

	public List<String>getSymptoms() {

		List <String>result= reader.getSymptoms();

		return result;

	}
	public  Map <String, Integer> countSymptoms (List<String> symptoms) {

		reader = new ReadSymptomDataFromFile("C:\\Users\\emman\\git\\jurquet_emmanuel_debug_java\\Project02Eclipse\\symptoms.txt");

		Map<String, Integer> countSymptoms =  new HashMap<String, Integer>();
		symptoms = reader.getSymptoms();

		for (int i = 0; i <symptoms.size(); i++ ) {

			String symptom = symptoms.get(i).trim().toLowerCase();

			if(countSymptoms.containsKey(symptom)) {

				countSymptoms.put(symptom, countSymptoms.get(symptom) + 1);

			}else {
				countSymptoms.put(symptom,1);
			}
		}

		return countSymptoms;

	}
	public Map<String, Integer> sortSymptoms (Map<String, Integer> symptoms){
		
		 return new TreeMap<>(symptoms);
	}
	public void writeSymptoms(Map<String, Integer> symptoms) {
		
        writer.writeSymptoms(symptoms);
	}
}










