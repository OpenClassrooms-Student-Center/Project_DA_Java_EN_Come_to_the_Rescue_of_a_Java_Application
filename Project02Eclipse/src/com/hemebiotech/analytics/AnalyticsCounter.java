package com.hemebiotech.analytics;
import java.util.TreeMap;

public class AnalyticsCounter {

	public static void main(String[] args) {
// The localization of source and destination text documents

		String destinationpath = "results.out.txt";
		String sourcepath = "symptoms.txt";
//New class which allow to read the source document and generate a TreeMap in Which :
// the key is the symptom
// the value is the frequency
// it's naturally sorted
//The method getSymptoms return the treemap
		ReadSymptomDataFromFile read = new ReadSymptomDataFromFile(sourcepath);
		TreeMap<String,int[]> listsymptoms = read.getSymptoms();

		for (String key:listsymptoms.keySet()){
			int [] nombre = listsymptoms.get(key);
			System.out.println(key +"="+nombre[0]);
		}

//Writedataonfile class allow to create a file called results.out and write the final list on it
WriteSymptomIntoFile writesortie = new WriteSymptomIntoFile(destinationpath, listsymptoms);
writesortie.writeSymptoms();
	}
}

