package com.hemebiotech.analytics.write;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Print and write into a file an ordered and counted list of symptoms
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	/**
	 * Print and write into a file a TreeMap of symptoms
	 * @param an ordered and counted map of all symptoms as keys and number of occurrences as values
	 */
	public void putSymptoms(Map<String, Integer> resultsMap){
		try(PrintWriter writer = new PrintWriter(new FileWriter("result.out"));){
			for(Map.Entry<String, Integer> m: resultsMap.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
			writer.println(m.getKey() + " " + m.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
