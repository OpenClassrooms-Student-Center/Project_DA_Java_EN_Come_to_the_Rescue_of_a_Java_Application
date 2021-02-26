package com.hemebiotech.analytics;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// @author Amyn Fekkoul

public class AnalyticsCounter {

	public static File doc = new File("symptoms.txt");
	public static List<String> list = new ArrayList<String>();
	public static Map<String, Integer> map = new TreeMap<String, Integer>();

	// @throws exception Signals that an I/O exception of some sort has occurred.

	public static void main(String args[]) throws IOException {

		ReadSymptomDataFromFile.read(doc, list); 
		// Reads the file line per line and put them in a list
		Iteration.count(list, map); 
		// Counts occurences, match them with the associated symptom, and put them in an ordered map
		Writer.write(map); 
		// Writes the data of the map in a txt file
	}

}