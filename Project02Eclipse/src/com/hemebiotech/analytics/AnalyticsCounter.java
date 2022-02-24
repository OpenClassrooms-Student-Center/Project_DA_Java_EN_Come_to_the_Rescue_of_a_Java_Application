package com.hemebiotech.analytics;

//import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;

/**
 * main class
 * 
 */
public class AnalyticsCounter {
	/**
	 * main function:
	 * 1) read a file with symptoms names
	 * 2) count occurrences of each symptoms
	 * 3) write result in a file
	 * 
	 * @param args not used yet
	 * return: void (write result in a file)
	 */
	public static void main(String args[]) throws Exception {
		// TO DO : gestion des erreurs (lecture/écriture fichiers)
		// TO DO : utiliser args[] pour trouver le dossier pour source ou résultats

		// step 1: reading file; put result in a list of string
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt") ;
		List<String> allSymptoms = reader.GetSymptoms() ;

		// step 2: counting ; each string increase a list of Symptom (class with name and count)
		List<Symptom> countedSymptoms = new ArrayList<Symptom>() ;
		for(String symptomName : allSymptoms) {
			addSymptomToList(symptomName, countedSymptoms);
		}

		// step 3: generate output
		FileWriter writer = new FileWriter("Project02Eclipse/result.out");
		for(Symptom symptom : countedSymptoms) {
			writer.write(symptom.name + "=" + symptom.count + "\n");
		}
		writer.close();
	}

	/**
	 * update the list of Symptoms with a symptom, either by incrementing one entry 
	 * of the list, or by adding a new entry.
	 * Call the recursive function recursiveAddSymptomToList with
	 * initializing its index to 0.
	 * 
	 * @param symptom: String containing the name of the symptom to be added
	 * @param countedSymptoms: list of Symptom to be updated
	 * 
	 * return: void (the given list of Symptoms is updated)
	 */
	public static void addSymptomToList(String symptom, List<Symptom> countedSymptoms) {
		recursiveAddSymptomToList(symptom, countedSymptoms, 0);
	}
	
	/**
	 * recursive function, to update the list of Symptoms with a symptom, 
	 * either by incrementing one entry of the list, or by adding a new entry.
	 * The update is done at the index position or send to the next call (recursivity).
	 * 
	 * @param symptom: String containing the name of the symptom to be added
	 * @param countedSymptoms: list of Symptom to be updated
	 * @param index: position where the list is updated, increased by the recursion (must be set to 0 for the first call)
	 * 
	 * return: void (the given list of Symptoms is updated)
	 */
	private static void recursiveAddSymptomToList(String symptom, List<Symptom> countedSymptoms, int index) {
		
		if (countedSymptoms.size() <= index) {
			
			// base condition: index further than the last entry 
			countedSymptoms.add(new Symptom(symptom));
			
		} else {
			
			int diffNewIndexed = symptom.compareTo(countedSymptoms.get(index).name);
			
			if (diffNewIndexed == 0) {
				
				// name found: increment the counter
				countedSymptoms.get(index).count++;
				
			} else if (diffNewIndexed < 0) { 
				
				// symptom is before the current position: adding new symptom
				countedSymptoms.add(index, new Symptom(symptom));
				
			} else { 
				
				// symptom have to be inserted further: recursion
				recursiveAddSymptomToList(symptom, countedSymptoms, index+1);
				
			}
		}
	}
}
