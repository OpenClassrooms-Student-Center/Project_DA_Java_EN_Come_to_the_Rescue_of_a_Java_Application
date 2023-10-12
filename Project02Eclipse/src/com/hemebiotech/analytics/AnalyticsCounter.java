package com.hemebiotech.analytics;

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;

public class AnalyticsCounter {
	ISymptomReader reader;
	ISymptomWriter writer;
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> result = new HashMap<>();
		for(int i=0; i<symptoms.size(); i++){
			boolean isInMap=false; //to track if we found the symptom in the map
			for (String key : result.keySet()) {
				if(symptoms.get(i).equals(key)){
					result.put(key, result.get(key)+1);
					isInMap=true;
				}
			}
			if(!isInMap){
				result.put(symptoms.get(i), 1);
			}
		}
		return result;
	}

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		TreeMap<String, Integer> sorted = new TreeMap<>(symptoms);
		return sorted;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

	public static void main(String args[]) throws Exception {

 	}
}
