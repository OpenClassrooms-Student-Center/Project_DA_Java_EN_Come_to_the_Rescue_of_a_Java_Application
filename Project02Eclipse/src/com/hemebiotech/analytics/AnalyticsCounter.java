package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List; // import of the LIST utility class to use
import java.util.Map; // import of the Map utility class to use
import java.util.TreeMap; // import of the mapTree utility class to use

/**
 * Takes a list of symptoms and return map of symptoms with occurrence and
 * sorted by alphabetical order
 * 
 * @Param : List of symptoms
 * @result : Map of occurrences symptoms sorted
 * 
 * @author HousM
 *
 */

public class AnalyticsCounter {

	private String InputDoc = "Project02Eclipse/symptoms.txt"; // File of symptoms to analyze
	private List<String> ListSymptoms = new ArrayList<String>();// List of symptoms
	private Map<String, Integer> mapSym = new TreeMap<String, Integer>();// Symptom map sorted in alphabetical order

	// Launching program
	public void Launch_pg() {
		this.GetSymptoms();
		this.mapCountTree(ListSymptoms);
		this.writeResult();
	}

	// Read List of Symptoms
	private void GetSymptoms() {
		ReadSymptomDataFromFile ReadSymptomDataFromFile = new ReadSymptomDataFromFile(InputDoc);
		ListSymptoms = ReadSymptomDataFromFile.GetSymptoms();
	}

	// Count and tree occurrence
	public Map<String, Integer> mapCountTree(List<String> ListSymptoms) {
		Map<String, Integer> mapCount = new TreeMap<String, Integer>();

		for (String Symptom : ListSymptoms) {
			if (mapCount.containsKey(Symptom)) {
				mapCount.put(Symptom, (mapCount.get(Symptom) + 1));
			} else {
				mapCount.put(Symptom, 1);
			}
		}
		for (String key : mapCount.keySet()) {

			System.out.println(key + " = " + mapCount.get(key));
		}
		return mapCount;
	}

	// Writing and displaying result of analyze
	public void writeResult() {
		WriteSymptomFromData writerSymptom = new WriteSymptomFromData();
		writerSymptom.writeResult(mapSym, ListSymptoms);
	}

}
