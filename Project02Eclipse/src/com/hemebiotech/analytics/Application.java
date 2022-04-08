package com.hemebiotech.analytics;

/**
 * This is the Application class,
 * this Application must read a file count the occurrences 
 * and print in the alphabetical order the symptoms and their occurrences.
 * 
 * @author quentincaracatzanis
 *
 */

public class Application {
 
	public static void main(String[] args) {
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile();
		WriteSymptomDataOnFile writeSymptomDataOnFile = new WriteSymptomDataOnFile();
		writeSymptomDataOnFile.setMap(readSymptomDataFromFile.GetSymptoms());
		writeSymptomDataOnFile.printSymptoms();
	}
}
