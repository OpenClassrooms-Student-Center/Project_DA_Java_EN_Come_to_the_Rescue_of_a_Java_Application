package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
/**
 * Write the symptoms in a new file "results.out" in alphabetical order with the count of occurrence 
 *
 */
public class Writer {
	/**
	 * 
	 * @param map: Object type Map<String, Integer>
	 * @throws IOException: signal that an I/O exception of some sort has occurred
	 */
	public void writer(Map<String, Integer> map) throws IOException {
		Map<String, Integer> map2 = new TreeMap<String, Integer>(map);
		File result = new File("results.out"); 
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(result));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Entry<String, Integer> entry : map2.entrySet()) {
			String symptom = entry.getKey();
			Integer value = entry.getValue();
			writer.write(symptom + " = " + value + System.getProperty("line.separator"));
			System.out.println(symptom + " = " + value);
		}
		writer.close();
	}
}