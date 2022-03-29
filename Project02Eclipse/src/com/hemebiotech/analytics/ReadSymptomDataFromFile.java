package com.hemebiotech.analytics;

/**
 * @author Fatima
 */
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
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 * 
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * 
	 * Getter: Method that returns value of filepath
	 *
	 * @return filepath: String that contains a full or partial path to file with
	 *         symptom strings in it, one per line
	 */
	public String getFilepath() {
		return filepath;
	}

	/**
	 * 
	 * Setter: Method that sets value of filepath
	 * 
	 * @param filepath: String that contains a full or partial path to file with
	 *                  symptom strings in it, one per line
	 *
	 */
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * If no data is available, return an empty List
	 * 
	 * @exception generate FileNotFoundException when file not found
	 * @exception generate EmptyFileException when file is empty
	 * @exception generate IOException when error occurred
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates
	 *         are possible/probable
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();
				if (line == null) {
					reader.close();
					throw new EmptyFileException();
				}

				while (line != null) {
					if (!line.trim().equals(""))
						result.add(line);
					line = reader.readLine();
				}

				if (result.isEmpty()) {
					reader.close();
					throw new EmptyFileException();
				}

				reader.close();
			} catch (FileNotFoundException e) {
				System.out.println("Read data from file: file not found!");
				System.out.println("Read data from file: " + e.getMessage());
			} catch (EmptyFileException e) {
				System.out.println("Read data from file: " + e.getMessage());
			}

			catch (IOException e) {
				System.out.println("Read data from file: an Error occured!");
				e.printStackTrace();
			}
		} else
			System.out.println("Read data from file: file path is null!");

		return result;
	}
}
