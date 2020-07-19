package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 * @author Yassine PAYET
 */
public class ReadSymptomFromFile implements ISymptomAccessor {
	/**
	 * The partial path of the file.
	 */
	protected String filePath;
	/**
	 * The absolute path of the file.
	 */
	protected String path;

	/**
	 * Return the absolute path of a file.
	 * 
	 * @param filePath
	 */

	public ReadSymptomFromFile(String filePath) {
		this.filePath = filePath;
		File pathFile = new File(filePath);
		path = pathFile.getAbsolutePath();
	}

	@Override
	/**
	 * @throws IOException
	 * 
	 */
	public List<String> GetSymptom() throws IOException {
		ArrayList<String> symptoms = new ArrayList<String>();

		if (path != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(path));
				String line = reader.readLine();

				while (line != null) {
					line = line.trim(); // remove leading and trailing white space contained in line

					symptoms.add(line);
					line = reader.readLine();
				}
				symptoms.removeIf(item -> "".equals(item)); // Remove all empty elements of a List

				symptoms.replaceAll(String::toUpperCase); // Transform all elements of a List to upper case

				reader.close();

				System.out.println(path + " : reading -> Ok");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return symptoms;
	}
}
