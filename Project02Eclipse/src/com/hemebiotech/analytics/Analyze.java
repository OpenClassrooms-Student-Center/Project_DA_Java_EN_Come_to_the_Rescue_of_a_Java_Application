package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.HashMap;

public class Analyze {

	private ArrayList<String> listOfResults;
	private ArrayList<String> intermediateListOfResult;
	private ArrayList<Integer> listOfCounters;
	private HashMap<String, Integer> mapOfSymptomsAndTheirCounter;

	public void TreatSymptomsFile(String symptomsPathAndFilename, String resultsPathAndFilename) {

		ReadSymptomDataFromFile rs = new ReadSymptomDataFromFile(symptomsPathAndFilename);

		listOfResults = rs.GetSymptoms();
		listOfCounters = rs.GetCounters(listOfResults);

		mapOfSymptomsAndTheirCounter = rs.TransformListIntoMap(listOfResults, listOfCounters);
		// intermediateListOfResult = rs.RemoveDuplicates(listOfResults);

//		WriteResultDataInFile wr = new WriteResultDataInFile(resultsPathAndFilename, mapOfSymptomsAndTheirCounter);
		WriteResultDataInFile wr = new WriteResultDataInFile(resultsPathAndFilename, listOfResults);
		wr.SetResults();

	}
}
