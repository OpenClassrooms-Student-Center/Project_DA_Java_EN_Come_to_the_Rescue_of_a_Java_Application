/**
 * 
 */
package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * 
 * File Data Access Object for symptom / count
 * 
 * @see ISymptomCountDao
 * @see SymptomCount
 * @author trimok
 *
 */
public class SymptomCountFileDao implements ISymptomCountDao {
	/**
	 * The file where to save the list of symptom / count
	 */
	private String filepath = "result.out";

	/**
	 * Save a list of symptom/ count in a file
	 * 
	 * @return nbSymptomCountWritten : the number of written occurrences
	 */
	@Override
	public int saveAll(List<SymptomCount> symptomCounts) {
		// The b
		int nbSymptomCountWritten = 0;

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));) {
			int sizeSymptomCount = symptomCounts.size();

			for (SymptomCount symptomCount : symptomCounts) {
				// Write the data
				writer.write(symptomCount.toString());

				// Write a line feed except for the last row
				++nbSymptomCountWritten;
				if (nbSymptomCountWritten < sizeSymptomCount) {
					writer.newLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return nbSymptomCountWritten;
	}

}
