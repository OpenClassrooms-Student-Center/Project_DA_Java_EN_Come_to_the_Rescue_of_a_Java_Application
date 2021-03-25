package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

/**
 * <b>ReadSymptomDataFromFile allows to :</b>
 * <ul>
 *     <li> read the file symptom.txt</li>
 *     <li> count the frequency of each symptom</li>
 *     <li> sort symptoms</li>
 * </ul>
 */
public class ReadSymptomDataFromFile {
	/**
	 * Path of symptom.txt
	 * @see ReadSymptomDataFromFile#getSymptoms()
	 * @see ReadSymptomDataFromFile#ReadSymptomDataFromFile(String)
	 */
	private String filepath;

	/**
	 * Constructor ReadSymptomFromDataFile
	 *
	 * @param filepath
	 * Path of symptom.txt
	 *
	 */

	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * getSymptoms() method that read, count and sort.
	 *
	 * @return A Treemap (K,V) such as (keys = symptoms, values = occurency) with keys sorted
	 */
	public TreeMap<String,Integer> getSymptoms() {
		TreeMap<String,Integer> result = new TreeMap<>();
		try {
			FileReader filereader = new FileReader(filepath);
			BufferedReader br = new BufferedReader(filereader);

			String line;

			while ((line = br.readLine()) != null) {
				Integer nombre;
				if(!result.containsKey(line)){
					nombre =1;
					result.put(line,nombre);}
				else {
					nombre = result.get(line);
					nombre ++;
					result.put(line,nombre);
				}
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.err.println("impossible to find the file");
		} catch (IOException e) {
			System.err.println("impossible to read the file");
		}

		return result;
	}

}
