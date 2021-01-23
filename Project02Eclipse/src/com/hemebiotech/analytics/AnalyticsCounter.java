package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * <b> AnalyticsCounterit is a class which parses a file and counts and lists
 * the results in a new file </b>
 * 
 * <p>
 * Entry point for this project.
 * </p>
 * <p>
 * This class creates a file (results.out), listing a list of symptoms.<br />
 * This list is created from a text file (symptoms.txt). Sorting is done in an
 * orderly manner, alphabetically and by counting the occurrences.<br />
 * This class implements ISymptomReader interface.
 * </p>
 * 
 * @author nico5310
 * 
 * @param filepath        is the type of element treated (source File).
 * @param resultsfilepath is the type of element that the program produces
 *                        (output File).
 *
 */
public class AnalyticsCounter implements ISymptomReader {

	private String filepath;
	private String resultsfilepath;

	/**
	 * Constructor AnalyticsCounter.
	 * 
	 * @param filePath        Source file
	 * @param resultsFilepath Output file
	 * 
	 * @see AnalyticsCounter#setFilepath
	 * @see AnalyticsCounter#setResultsfilepath
	 */

	public AnalyticsCounter(String filePath, String resultsFilepath) {
		this.setFilepath(filePath);
		this.setResultsfilepath(resultsFilepath);
	}

	/**
	 * Constructor Getter filepath
	 * 
	 * @return content filepath
	 * @see filepath
	 */

	public String getFilepath() {
		return filepath;
	}

	/**
	 * Constructor Setter filepath
	 * 
	 * @param filePath Update file symptoms
	 * @see filePath
	 * 
	 */

	public void setFilepath(String filePath) {
		this.filepath = filePath;
	}

	/**
	 * Constructor Getter resultsfilepath
	 * 
	 * @return content resultsfilepathepath
	 * @see resultsfilepath
	 */
	public String getResultsfilepath() {
		return resultsfilepath;
	}

	/**
	 * Constructor Setter resultsfilepath
	 * 
	 * @param resultsfilepath Update file order symptoms
	 * @see resultsFilePath
	 * 
	 */
	public void setResultsfilepath(String resultsFilepath) {
		this.resultsfilepath = resultsFilepath;
	}

	/**
	 * Public methods Return the list of symptoms and display number of occurrences
	 * 
	 * @return the list of symptoms and display number of occurrences
	 * @see AnalyticsCounter#getSymptomsOccurences()
	 */
	@Override
	public TreeMap<String, Integer> getSymptomsOccurences() {

		TreeMap<String, Integer> symptomReader = new TreeMap<>();

		if (this.filepath != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(this.filepath));) {
				String line = reader.readLine();
				while (line != null) {

					if (symptomReader.containsKey(line)) {
						symptomReader.put(line, symptomReader.get(line) + 1);
					} else {
						symptomReader.put(line, 1);

					}

					line = reader.readLine();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return symptomReader;
	}

	/**
	 * Public methods
	 * 
	 * Write resultsFilePath in output file
	 * 
	 * @see AnalyticsCounter#setMapToFile(TreeMap, String)
	 */
	@Override
	public void setMapToFile(TreeMap<String, Integer> symptomOccurence, String resultsFilePath) {

		try (FileWriter writer = new FileWriter(resultsFilePath); BufferedWriter result = new BufferedWriter(writer);) {
			File file = new File(resultsFilePath);
			if (!file.exists()) {
				file.createNewFile();
			}
			for (Map.Entry<String, Integer> mapentry : symptomOccurence.entrySet()) {
				result.write(mapentry.getKey() + " " + mapentry.getValue());
				result.newLine();
			}
			result.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}