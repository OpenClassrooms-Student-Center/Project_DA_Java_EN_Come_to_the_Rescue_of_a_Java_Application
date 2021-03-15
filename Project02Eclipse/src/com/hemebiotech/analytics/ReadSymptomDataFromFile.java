package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filepath;
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

	/**
	 * @return a BufferedFile with of all Symptoms obtained from a data source and
	 * if no data is available, return an empty BufferedFile
	 */
	@Override
	public BufferedReader GetAllSymptoms() {
		if (filepath != null) {
			try {
				this.file = new BufferedReader (new FileReader(filepath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return this.file;
	}


}
