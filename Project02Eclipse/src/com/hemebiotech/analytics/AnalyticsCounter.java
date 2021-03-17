package com.hemebiotech.analytics;
import java.util.TreeMap;

/**
 * <p><b>Analytics Counter allows to:</b> read a file symptom.txt, count symptoms, sort them,
 * recopy symptom = occurency in a results.out file.
 *</p>
 * <b>AnalyticsCounter will call two classes :</b>
 *  <ul>
 *  <li>ReadSymptomDataFromFile</li>
 *  <li>WriteSymptomIntoFile</li>
 *</ul>
 *
 * @see ReadSymptomDataFromFile
 * @see WriteSymptomIntoFile
 *
 * @author Robin Couturier
 * @version 2.0
 */
public class AnalyticsCounter {

	public static void main(String[] args) {

		String destinationpath = "results.out.txt";
/**
 * The source path. if it's not inside the root directory it can be modified
 */
		String sourcepath = "symptoms.txt";

/**
 * creation of a new instance of ReadSymptomDataFromFile's class called read
 * @see ReadSymptomDataFromFile
  */
		ReadSymptomDataFromFile read = new ReadSymptomDataFromFile(sourcepath);
/**
 * creation of a TreeMap listsymptoms which is the return of the method getSymptoms
 * @see ReadSymptomDataFromFile#getSymptoms()
 *
  */
		TreeMap<String,int[]> listsymptoms = read.getSymptoms();

/**
 * creation of a new instance of WriteSymptomIntoFile's class called write
 * @see WriteSymptomIntoFile
 */
		WriteSymptomIntoFile write = new WriteSymptomIntoFile(destinationpath, listsymptoms);
/**
 * Use of the method writeSymptoms() in order to copy into results.out's file
 * @see WriteSymptomIntoFile#writeSymptoms()
 *
 */
		write.writeSymptoms();
	}
}

