package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * File Data Access Object for Symptom
 * 
 * @see ISymptomDao
 * @see Symptom
 * @author trimok
 *
 */
public class SymptomFileDao implements ISymptomDao {

	/**
	 * The file where to read the list of symptom
	 */
	private String filepath = "symptoms.txt";

	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a list of all Symptom obtained from a data source, duplicates Symptom
	 *         name are possible/probable
	 */
	@Override
	public List<Symptom> findAll() {
		ArrayList<Symptom> symptomList = new ArrayList<Symptom>();

		// Read the data
		try (BufferedReader reader = new BufferedReader(new FileReader(filepath));) {
			String line;
			while ((line = reader.readLine()) != null) {
				// If the name of the symptom is not empty,
				// a new object Symptom is added to the list
				line = line.trim();
				if (!line.isEmpty()) {
					symptomList.add(new Symptom(line));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return symptomList;
	}
}
