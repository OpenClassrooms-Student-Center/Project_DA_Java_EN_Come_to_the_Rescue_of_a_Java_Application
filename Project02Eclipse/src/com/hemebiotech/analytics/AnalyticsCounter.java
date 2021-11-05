package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.count.*;
import com.hemebiotech.analytics.read.*;
import com.hemebiotech.analytics.write.*;

public class AnalyticsCounter {

	public static void main(String args[]) {
		
		String filepath = args[0];
		List<String> symptomList = null;
		Map<String, Integer> symptomMap = null;
		
		ISymptomReader symptomsRead = new ReadSymptomDataFromFile(filepath);
		symptomList = symptomsRead.getSymptoms();
		
		ISymptomCounter symptomsCount = new CountSymptom();
		symptomMap = symptomsCount.countSymptoms(symptomList);
		
		ISymptomWriter symptomsWrite = new WriteSymptomDataToFile();
		symptomsWrite.putSymptoms(symptomMap);
	}
	
}