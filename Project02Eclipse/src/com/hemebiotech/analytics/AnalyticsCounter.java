package com.hemebiotech.analytics;

import java.util.Collections;
import java.util.List;

public class AnalyticsCounter {

	public static void main(String[] args) {
// The localization of source and destination text documents

		String destinationpath = "results.out.txt";
		String sourcepath = "symptoms.txt";
//New class which allow to read the source document and generate a list with all symptoms in a row
//The method getSymptoms return the exhaustive list of symptoms as a list of strings
		ReadSymptomDataFromFile read = new ReadSymptomDataFromFile(sourcepath);
		List<String> listsymptoms = read.getSymptoms();

//Collections.sort allow to sort in ascending order
		Collections.sort(listsymptoms);

//CounterSymptom class allows to  return a list with "name of symptom" = "frequence" thanks to its getCount method
		CounterSymptom countofsymptoms = new CounterSymptom(listsymptoms);
		List<String> finalist = countofsymptoms.getCount();

//Writedataonfile class allow to create a file called results.out and write the final list on it
		WriteSymptomIntoFile writesortie = new WriteSymptomIntoFile(destinationpath, finalist);
		writesortie.writeSymptoms();
	}
}

