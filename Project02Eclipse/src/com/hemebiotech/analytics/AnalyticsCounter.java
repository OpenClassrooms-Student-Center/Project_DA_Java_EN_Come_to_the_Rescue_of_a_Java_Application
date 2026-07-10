package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Provides utility methods to read, count, sort, and write symptom data
 * <p>
 * This class reads a list of symptoms from a data source, counts the number
 * of occurrences of each symptom, sorts the results alphabetically, and
 * writes the final statistics to an output file
 */

public class AnalyticsCounter {
	
	// Path to the project directory containing the input and output files
	private static String chemin = "C:\\Users\\C_local\\Documents\\Openclassrooms\\Developpeur_Java\\Projet_2\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\\\Project02Eclipse\\";
	
	/**
     * Reads the list of symptoms from the input file
     * <p>
     * @return a list containing all symptoms read from the data source
     */	
	public static List <String> getSymptoms() {
		ISymptomReader readSymptom = new ReadSymptomDataFromFile(chemin + "symptoms.txt");
		return readSymptom.GetSymptoms();
	}
	
	/**
     * Counts the number of occurrences of each symptom
     * <p>
     * @param listSymptoms the list of symptoms to analyze
     * @return a map where the key is the symptom name and the value is its
     * number of occurrences
     */
	public static Map <String, Integer> countSymptoms(List <String> listSymptoms) {
		Map<String, Integer> symptomMap = new HashMap <>();
		for(String symptom : listSymptoms) {
			if (!symptomMap.containsKey(symptom)) {
				symptomMap.put(symptom, 1);
			}
			else {
				symptomMap.replace(symptom, symptomMap.get(symptom)+1);
			}
		}
		return symptomMap;
	} 

	/**
     * Sorts the symptoms alphabetically
     * <p>
     * @param mapSymptoms the map containing symptom counts
     * @return a {@code TreeMap} containing the same entries sorted by symptom
     * name
     */
	public static Map <String, Integer> sortSymptoms(Map <String, Integer> mapSymptoms) {
		Map <String, Integer> treeSymptomMap = new TreeMap <>();
		for (Map.Entry<String, Integer> entry : mapSymptoms.entrySet()) {
			// treeSymptomMap.putAll(mapSymptoms);
			treeSymptomMap.put(entry.getKey(), entry.getValue());
		}	
		return treeSymptomMap;
	} 
	
	/**
     * Writes the symptom statistics to the output file
     * <p>
     * @param mapSymptoms the map containing the sorted symptom counts
     */
	public static void writeSymptoms(Map <String, Integer> mapSymptoms) {
		ISymptomWriter writeSymptom = new WriteSymptomDataFromFile(chemin, mapSymptoms);
		writeSymptom.WriteSymptoms(mapSymptoms);
	} 
	
	/**
     * Runs the application
     * <p>
     * The program performs the following steps:
     * <p>
     * Reads the symptoms from the input file
     * Counts the occurrences of each symptom
     * Sorts the symptoms alphabetically
     * Displays the results in the console
     * Writes the results to an output file
     * <p>
     * @param args command-line arguments (not used)
     * @throws Exception if an unexpected error occurs during execution
     */
	public static void main(String args[]) throws Exception {
		List<String> listSymptom = AnalyticsCounter.getSymptoms();
		Map <String, Integer> mapSymptom = AnalyticsCounter.countSymptoms(listSymptom);
		Map <String, Integer> treeMapSymptom = AnalyticsCounter.sortSymptoms(mapSymptom);
		System.out.println(mapSymptom);
		System.out.println(treeMapSymptom);
		AnalyticsCounter.writeSymptoms(treeMapSymptom);
	} 
}


// File workDir = new File(System.getProperty("user.dir"));
// File resourcesDir = new File(workDir, "resources")
	
