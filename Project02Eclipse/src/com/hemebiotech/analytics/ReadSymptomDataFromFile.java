package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	private BufferedReader file;

	/**
	 *
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 * @param file an empty file which we'll fill
	 */
	public ReadSymptomDataFromFile (String filepath, BufferedReader file) {
		this.filepath = filepath;
		this.file = file;
	}
	
	@Override
	public BufferedReader GetSymptoms() {
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				this.file = reader;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return this.file;
	}


}
