package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	public ReadSymptomDataFromFile() {
	}

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 * @exception generate FileNotFoundException when file not found
	 * @exception generate EmptyFileException when file is empty
	 * @exception generate IOException when error occurred
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();
				int count = 0;

				while (line != null) {
					result.add(line);
					if (count == 0 && line.trim().equals("")) {
						reader.close();
						throw new EmptyFileException();
					} else {
						line = reader.readLine();
						count++;
					}
				}

				reader.close();

			} catch (FileNotFoundException e) {
				System.out.println("File to read not found!");
				System.out.println(e.getMessage());
			} catch (EmptyFileException e) {
				System.out.println(e.getMessage());
			}

			catch (IOException e) {
				System.out.println("an Error occured!");
				e.printStackTrace();
			}
		} else
			System.out.println("File path = null!");

		return result;
	}
}
