package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @author Amyn Fekkoul
 */

public class ReadSymptomDataFromFile {

	/**
	 * Reads the file and put informations in a list
	 * 
	 * @throws exception Signals that an I/O exception of some sort has occurred.
	 * 
	 * @param doc:  File that will be read
	 * 
	 * @param list: Arraylist that contains each line of the file
	 * 
	 * @return a list with all symptoms
	 */

	public static void read(File doc, List<String> list) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(doc));
			String line = null;

			while ((line = reader.readLine()) != null) {
				list.add(line);
				// System.out.println(line);
			}
			reader.close();

		} catch (IOException noFile) {
			System.err.println("Unable to read the file.");
		}

	}

}