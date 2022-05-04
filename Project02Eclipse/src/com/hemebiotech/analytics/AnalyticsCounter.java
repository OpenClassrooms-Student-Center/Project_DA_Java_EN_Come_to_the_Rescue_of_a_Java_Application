package com.hemebiotech.analytics;

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.FileWriter;
import java.util.HashMap;
// import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter implements ISymptomCounter{
	// private static int headacheCount = 0;
	// private static int rashCount = 0;	
	// private static int pupilCount = 0;	
	
	// first get input
	// BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
	// String line = reader.readLine();
	
	private List<String> listOfSymptoms;

	public AnalyticsCounter(List<String> listOfSymptoms) {
		this.listOfSymptoms = listOfSymptoms;
	}

	@Override
	public Map<String, Integer> symptomCounter() {
		Map<String, Integer> result = new HashMap<String, Integer>();
		int counter = 0;
		for ( String symptom : listOfSymptoms) {
			for(int i=0; i < listOfSymptoms.size(); i++){
				if(symptom.equals(listOfSymptoms.get(i))) {
					counter++;
				}
			}
			if(!result.containsKey(symptom)) {
				result.put(symptom, counter);
			}
			counter = 0;
		}
		return result;
	}

	// int i = 0;	
	// int headCount = 0;	// counts headaches
	// while (line != null) {
	// 	i++;	
	// 	System.out.println("symptom from file: " + line);
	// 	if (line.equals("headache")) {
	// 		headCount++;
	// 		System.out.println("number of headaches: " + headCount);
	// 	}
	// 	else if (line.equals("rush")) {
	// 		rashCount++;
	// 	}
	// 	else if (line.contains("pupils")) {
	// 		pupilCount++;
	// 	}

	// 	line = reader.readLine();	// get another symptom
	// }
	
	// next generate output
	// FileWriter writer = new FileWriter ("result.out");
	// writer.write("headache: " + headacheCount + "\n");
	// writer.write("rash: " + rashCount + "\n");
	// writer.write("dialated pupils: " + pupilCount + "\n");
	// writer.close();
	
}
