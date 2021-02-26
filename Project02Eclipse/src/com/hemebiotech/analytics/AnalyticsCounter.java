package com.hemebiotech.analytics;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;


public class AnalyticsCounter {

	public static void main(String args[]) throws Exception {

		String symptomsFile = new File("Project02Eclipse/symptoms.txt").getCanonicalPath();
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(symptomsFile);
		List<String> symptomList = reader.GetSymptoms();
		CountFreq counter = new CountFreq();
		List<String> symptomCount;
		symptomCount = counter.CountFrequency(symptomList);
		AlphabeticalOrder inOrderAlphabetic = new AlphabeticalOrder();
		List<String> listInOrder = inOrderAlphabetic.AlphabeticalOrder(symptomCount);
		WriteInFile writer = new WriteInFile(listInOrder);
	}
}
