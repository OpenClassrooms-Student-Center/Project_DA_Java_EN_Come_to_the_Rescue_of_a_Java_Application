/**

 * Project Analytics
 * Frequency count of undesirable effects (symptoms) of patients testing drugs of Heme Biotech registered in a text file,
 * where one line represents one occurrence
 * Report is deployed in results.out
 * @version: 0.5 2024-01-29
 * @authors: Pablo Miranda, Alex OpenClassRooms, Caroline OpenClassRooms
 */

package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

//Code refactor and main functions added
public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;
	/**
	 * Constructor method initialises the Interfaces writer and reader.
	 * It concentrates the calls to the rest of methods (get, count, sort & write).
	 */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
    }

	/**
	 * Gets the symptoms in a List of Strings as it is (no order) from the patients
	 * from the text file passed to reader
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}

	/**
	 * Determines the frequency of the diseases reported by the patients and returns a Map as a result.
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> frequencies = new HashMap<String, Integer>();
		for (String symptom : symptoms) {
			if (frequencies.get(symptom) != null) {
			frequencies.put(symptom, (frequencies.get(symptom)+1)); // counts symptom if already exists, adds the symptom,frequency if not
			}
			else {
				frequencies.put(symptom, 1);
			}
			}
		return frequencies;
	}

	/**
	 * Sorts the Map alphabetic order through a simple transformation to a TreeMap and returns it back.
	 *
	 */

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        return new TreeMap<String, Integer>(symptoms);
	}

	/**
	 * Once all processed, writes the Map to the filepath indicated to the writer's interface.
	 * It cleanses and formats the output so to get in each line the requirement: disease : frequency.
	 *
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

	/**
	 * Program body, sets the specific instances of filepaths and instantiates the interfaces and launches the data processing tasks.
	 * Symptoms.txt (input) and result.out (output) are the main IO files of the project.
	 */
	public static void main(String[] args) {
		//We set the IO files for read and write as part of the initialization, class instantiation
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("symptoms.txt");
		WriteSymptomDataToFile writer = new WriteSymptomDataToFile("results.out");

		//We prepare the interface for the processing of the methods
		AnalyticsCounter analytics = new AnalyticsCounter(reader,writer);

		//Sents the symptoms of the text file in a list and runs the data processing and cleansing and generates the reporting
		List<String> symptoms = new ArrayList<String>(analytics.getSymptoms());
		analytics.writeSymptoms(analytics.sortSymptoms(analytics.countSymptoms(symptoms)));


	}

}

