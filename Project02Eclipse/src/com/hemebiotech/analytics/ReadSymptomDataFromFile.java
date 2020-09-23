package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.toMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * Read each line of the symptom file and put it in a list
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	@Override



	public List<String> getSymptoms() {

		//Creating an ArrayList to contain the lines in the input file
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				//Creating BufferedReader object to read the file
				BufferedReader reader = new BufferedReader (new FileReader(filepath));

				//Reading all the lines of the file and putting them into an ArrayList
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();

				}

				Collections.sort(result);

				reader.close();


			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * Using a TreeMap to sort the list and count each symptom
	 * @return the list ordered and counted
	 */
	//Creating a TreeMap in order to sort and count the elements of the ArrayList
	public TreeMap<String, Integer> countSymptoms(){

		List<String> result = getSymptoms();

		TreeMap<String, Integer> frequency = new TreeMap<>();
	//Counting each occurence of the symptoms
		for (String s : result ){
			Integer j = frequency.get(s);
			frequency.put(s, (j == null) ? 1: j+1);
		}
	//Printing the result in order to check if everything works
		for (Map.Entry<String, Integer> value : frequency.entrySet()){
			System.out.println(value.getKey() + ": " + value.getValue() );
		}
		return frequency;
	}
}
