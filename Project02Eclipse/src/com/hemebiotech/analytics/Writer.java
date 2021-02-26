package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

//@author Amyn Fekkoul

public class Writer {
	/*
	 * Writes map informations in a txt file "result.out.txt"
	 * 
	 * @throws exception Signals that an I/O exception of some sort has occurred.
	 * 
	 * @param map Map that contains each symptom matched with its occurences The
	 * treemap orders symptoms alphabetically
	 *
	 * @return a txt file with symptoms and occurences, aphabetically ordered
	 */

	public static void write(Map<String, Integer> map) throws IOException {

		File resultat = new File("result.out.txt");
		BufferedWriter writeDoc = null;

		try {
			writeDoc = new BufferedWriter(new FileWriter(resultat));
		} catch (IOException exception) {
			System.out.println(exception);
		}
		for (Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			writeDoc.write(key + " = " + value + "\n");
		}
		writeDoc.close();
	}
}
