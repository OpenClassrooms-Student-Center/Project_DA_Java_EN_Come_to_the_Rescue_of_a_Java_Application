package com.hemebiotech.analytics;


/**
 * AnalyticsCounter Class revision as part of OCR Project 4 initiative
 * produces a result.out file with a list of distinct symptoms and their respective occurences count found
 * in source file symptoms.txt
 * This particular class contains the main where the program starts
 *
 *
 * @author  Sébastien Vigé
 * @version 2.0
 * @since   2020-12-18
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	// revision 2.0 -svige - deleted headacheCount rashCount and pupilCount
	// added inputSymptoms and symptomsreport - both are used
	private static List<String> inputSymptoms = new ArrayList<>();
	private static Map<String, Integer> symptomsreport = new HashMap<>();



	public static void main(String args[]) throws Exception {

		// path defines the sourcefile symptoms.txt relative path to the project
		// filename can be changed and storage location too - you will need to adaps path variable assignment
		// if no source file is found expect a FileNotFount Exception if the referenced file name in path is not found in project
		String path = new File("Project02Eclipse/symptoms.txt").getAbsolutePath();

		//first get input symptoms from file and store them in a temp list
		ReadSymptomDataFromFile filereader = new ReadSymptomDataFromFile(path);
		inputSymptoms.addAll(filereader.GetSymptoms());


		// take the list and pass it to a map class method for count
		SymptomsCounter symptomcounter = new SymptomsCounter(inputSymptoms);
		symptomsreport = symptomcounter.getSymptomsCount();





		// take the map and write content to file

		SymptomsFileOutput output = new SymptomsFileOutput(symptomsreport);

		output.generateFileReport();

		

	}
}
