package com.hemebiotech.analytics;

//import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * main class
 * 
 * should separate main function to other functions ?
 */
public class AnalyticsCounter {
	static String repoReading = "Project02Eclipse" ;
	static String repoWriting = "Project02Eclipse" ;

	/**
	 * main function:
	 * 1) read a file with symptoms names
	 * 2) count occurrences of each symptoms
	 * 3) write result in a file
	 * 
	 * @param args not used yet
	 */
	public static void main(String args[]) throws Exception {
		// step 1 : read data from file
		List<String> allSymptoms = readFile(repoReading+"/symptoms.txt") ;

		// step 2: counting ; each string increase a list of Symptom (class with name and count)
		List<Symptom> countedSymptoms = readSymptoms(allSymptoms);

		// step 3: generate output
		writeCountedSymptoms(countedSymptoms, repoWriting+"/result.out");
	}

	/**
	 * read of file where each line is a name of symptom
	 * 
	 * @param path file to read from
	 * @return List of String, each one is a symptom's name (possible repetitions)
	 */
	private static List<String> readFile(String path){
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(path) ;
		return reader.GetSymptoms() ;
	}
	
	/**
	 * 
	 * @param allSymptoms list of symptom's names
	 * @return countedSymptoms List of Symptom (name and count), alphabetically ordered
	 */
	private static List<Symptom> readSymptoms(List<String> allSymptoms){
		List<Symptom> countedSymptoms = new ArrayList<Symptom>() ;
		for(String symptomName : allSymptoms) {
			recursiveAddSymptomToList(symptomName, countedSymptoms, 0);
		}
		return countedSymptoms;
	}
	
	/**
	 * Write in a file the count for each symptom's name. Each line is in the format [name]=[count]
	 * 
	 * @param countedSymptoms list of Symptoms (name and count)
	 * @param path file to write
	 */
	private static void writeCountedSymptoms(List<Symptom> countedSymptoms, String path) {
		try {
			FileWriter writer = new FileWriter(path);
			for(Symptom symptom : countedSymptoms) {
				writer.write(symptom.name + "=" + symptom.count + "\n");
			}
			writer.close();
		} catch (IOException e) {
			System.err.println("Problem in writing the result file.");
			e.printStackTrace();
		}
	}
	
	/**
	 * recursive function, to update the list of Symptoms with a symptom name, 
	 * either by incrementing one entry of the list, or by adding a new entry.
	 * The update is done at the index position or send to the next call (recursivity).
	 * 
	 * @param symptom: String containing the name of the symptom to be added
	 * @param countedSymptoms: list of Symptom to be updated
	 * @param index: position where the list is updated, increased by the recursion 
	 * 					(must be set to 0 for the first call)
	 * 
	 * @return int, index of the added symptom's name, used to force the tail recursion 
	 * 				(the given list of Symptoms is updated)
	 */
	public static int recursiveAddSymptomToList(String symptomName, List<Symptom> countedSymptoms, int index) {
		
		if (countedSymptoms.size() <= index) {
			
			// base condition: index further than the last entry 
			countedSymptoms.add(new Symptom(symptomName));
			return(countedSymptoms.size());
			
		} else {
			
			int diffNewIndexed = symptomName.compareTo(countedSymptoms.get(index).name);
			
			if (diffNewIndexed == 0) {
				
				// name found: increment the counter
				countedSymptoms.get(index).count++;
				return(index);
				
			} else if (diffNewIndexed < 0) { 
				
				// symptom is before the current position: adding new symptom
				countedSymptoms.add(index, new Symptom(symptomName));
				return(index);
				
			} else { 
				
				// symptom have to be inserted further: recursion
				return recursiveAddSymptomToList(symptomName, countedSymptoms, index+1);
				
			}
		}
	}
}
