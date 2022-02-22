package com.hemebiotech.analytics;

//import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;

/**
 * to be filled later structure of javadoc
 * 
 * 
 */
public class AnalyticsCounter {
	/**
	 * to be filled later ; structure of javadoc ; produce what we want
	 * 
	 * @args blabla
	 */

	public static void main(String args[]) throws Exception {
		/**
		 * to be filled later structure of javadoc produce what we want main steps: 1)
		 * read file (result: list of String) 2) counting: 2a) build empty list of
		 * Symptom (class with name and count) 2b) For each String from the list of
		 * String 2b-1) look for it in the list of Symptom 2b-1-a) if same symptom found
		 * : increase its count 2b-1-b) if not : insere new Symptom 3) write the result
		 * 
		 * @args blabla
		 */

		// step 1: read file; put result in a list of string
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt") ;
		List<String> allSymptoms = reader.GetSymptoms() ;

		// step 2: counting ; each string increase a list of Symptom (class with name and count)
		List<Symptom> countedSymptoms = new ArrayList<Symptom>() ;
		for(String symptomName : allSymptoms) {
			addSymptomToList(symptomName, countedSymptoms, 0);
		}

		// step 3: generate output
		FileWriter writer = new FileWriter("Project02Eclipse/result.out");
		for(Symptom symptom : countedSymptoms) {
			writer.write(symptom.name + "=" + symptom.count + "\n");
		}
		writer.close();
	}

	public static void addSymptomToList(String symptom, List<Symptom> countedSymptoms, int index) {
		// TO DO : add javadoc
		int sizeOfList = countedSymptoms.size();
		if (sizeOfList <= index) {
			countedSymptoms.add(new Symptom(symptom));
		} else {
			int diff = symptom.compareTo(countedSymptoms.get(index).name);
			if (diff == 0) {
				countedSymptoms.get(index).count++;
			} else if (diff < 0) { 
				// symptom is before countedSymptoms.get(index).name
				countedSymptoms.add(index, new Symptom(symptom));
			} else { 
				// symptom have to be inserted further
				addSymptomToList(symptom, countedSymptoms, index + 1);
			}
		}
	}
}
