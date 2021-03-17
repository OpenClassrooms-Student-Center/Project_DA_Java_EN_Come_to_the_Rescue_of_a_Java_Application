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
	 * <ul>
	 *     <li>Read symptoms thanks to a bufferedReader.</li>
	 *     <li>Write each symptom as a key in a TreeMap.</li>
	 *     <li>Increase the value of the key if the symptom is seen multiple times.</li>
	 *     <li>The TreeMap will automatically sort keys.</li>
	 * </ul>
	 *
	 * Catch two Exceptions.
	 *       <ul>
	 *           <li>the file can't be found</li>
	 *           <li>the file can't be read </li>
	 *
	 *       </ul>
	 * @return A Treemap (K,V) such as (keys = symptoms, values = occurency) with keys sorted
	 */
	public TreeMap<String,int[]> getSymptoms() {
		TreeMap<String,int[]> result = new TreeMap<>();
		try {
			FileReader filereader = new FileReader(filepath);
			BufferedReader br = new BufferedReader(filereader);

			String line;

			while ((line = br.readLine()) != null) {
				int [] nombre = result.get(line);
				if(nombre == null){
					nombre = new int[]{0};
					result.put(line,nombre);}
					else {
						nombre[0] ++;
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
