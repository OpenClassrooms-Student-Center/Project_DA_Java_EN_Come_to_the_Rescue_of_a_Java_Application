package com.hemebiotech.analytics.service.impl;

import com.hemebiotech.analytics.constant.Constant;
import com.hemebiotech.analytics.service.ISymptomReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.hemebiotech.analytics.constant.Constant.*;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(PATH+FILENAME_IN));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
				throw new ArithmeticException("this");
			} catch (IOException e) {
				System.out.println("c'est IOExcept");
			}
			catch (ArithmeticException e) {
				System.out.println("c'est Arith");
			}
		}
		return result;
	}

}
