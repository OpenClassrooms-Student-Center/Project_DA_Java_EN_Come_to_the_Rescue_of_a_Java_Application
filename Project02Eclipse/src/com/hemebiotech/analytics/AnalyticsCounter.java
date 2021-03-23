package com.hemebiotech.analytics;
import java.util.TreeMap;

/**
 * <p><b>Analytics Counter allows to:</b> read a file symptom.txt, count symptoms, sort them,
 * recopy symptom = occurency in a result.out file.
 *</p>
 * <b>AnalyticsCounter will call two classes :</b>
 *  <ul>
 *  <li>ReadSymptomDataFromFile</li>
 *  <li>WriteSymptomIntoFile</li>
 * </ul>
 *
 * @see ReadSymptomDataFromFile
 * @see WriteSymptomIntoFile
 *
 * @author Robin Couturier
 * @version 1.0
 */
public class AnalyticsCounter {

	public static void main(String[] args) {

		String destinationpath = "result.out";
		String sourcepath = "symptoms.txt";

		ReadSymptomDataFromFile read = new ReadSymptomDataFromFile(sourcepath);

		TreeMap<String,Integer> listsymptoms = read.getSymptoms();

		WriteSymptomIntoFile write = new WriteSymptomIntoFile(destinationpath, listsymptoms);

		write.writeSymptoms();
	}
}

