package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;// Package containing the List class
import java.util.Map;// Package containing the Map class (collection)

/**
 * write the result to a file
 * 
 * @author Dave Discamps
 *
 */

public class WriterSymptom implements ISymptomWriter {

	/**
	 * writes the results of the occurrences of each symptom in alphabetical order
	 * to a file
	 * 
	 * @param mapSym   map of the symptoms in alphabetical order as well as their
	 *                 occurrences
	 * @param symptoms list of symptoms
	 * 
	 */
	public void writeResult(Map<String, Integer> mapSym, List<String> symptoms) {

		File resultOut = new File("result.out");
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(resultOut));

			for (String key : mapSym.keySet()) {

				System.out.println(key + "=" + mapSym.get(key));

				writer.write(key + "=" + mapSym.get(key) + "\n");

			}
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
