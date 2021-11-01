package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Read anything from file and return an ArrayList
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader{
	/**
	 * @param doc : The file to read "symptoms.txt"
	 * @param list : ArrayList with the file to be read line per line
	 */
	public List<String> getSymptoms(File doc) {

		List<String> list = new ArrayList<String>();

		if(doc != null) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(doc));
				String line = null;
				while ((line = br.readLine()) != null) {
					list.add(line);
				}
				br.close();
			} catch (IOException e) {
				System.err.println("File not found"); 
			}
		}
		return list;
	}
}