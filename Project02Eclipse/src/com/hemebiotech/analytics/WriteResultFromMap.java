package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Writes processed data in a file.
 * 
 * @author Yassine PAYET
 *
 */

public class WriteResultFromMap implements IResultWriter {
	/**
	 * Creates a map of an existing map to synch up data and overcome thread
	 * safety.<br/>
	 * Writes in a result file the processed symptom data.<br/>
	 * 
	 * 
	 * @param Map<K,V>mapSymptom
	 * @param sympList
	 * @throws IOException
	 */

	public static void writeResult(Map<String, Integer> mapSymptom, List<String> sympList)
			throws IOException, NullPointerException, ConcurrentModificationException {

		Map<String, Integer> mapSynched = new TreeMap<String, Integer>(mapSymptom);

		File resultDoc = new File("Results.out.txt");

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(resultDoc));
			writer.write("LIST OF SYMPTOMS IN NATURAL ORDER" + System.getProperty("line.separator"));
			writer.write("--------------------------------------------------------------"
					+ System.getProperty("line.separator"));
			writer.write("NoO = Number Of Occurrences || PoO = Percentage of Occurrences"
					+ System.getProperty("line.separator"));
			writer.write("--------------------------------------------------------------"
					+ System.getProperty("line.separator"));
			mapSynched.forEach((key, value) -> {
				try {
					/*
					 * writes each symptoms their occurrences and percentage of occurrences.
					 */
					DecimalFormat df = new DecimalFormat("#.##");
					writer.write(key + " => NoO = " + value + "|| PoO = "
							+ df.format(((float) value / (float) sympList.size()) * 100.0F) + "%"
							+ System.getProperty("line.separator"));

				} catch (IOException | NullPointerException | ConcurrentModificationException e) {
					e.printStackTrace();
				}
			});
			System.out.println("Writing Result file -> Ok");
			System.out.println("Result path file : " + resultDoc.getAbsolutePath());
			System.out.println(mapSynched.size() + " symtptoms analysed.");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
