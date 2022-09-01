package com.hemebiotech.analytics;
import com.hemebiotech.analytics.service.ISymptomReader;
import com.hemebiotech.analytics.service.ISymptomsCountWriter;
import com.hemebiotech.analytics.service.impl.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.service.impl.Writer;
import com.hemebiotech.analytics.service.ISymptomsOperations;
import com.hemebiotech.analytics.service.impl.SymptomOperations;

import java.util.*;

import static com.hemebiotech.analytics.constant.Constant.*;

public class AnalyticsCounterApplication {

	public static void main(String[] args){

		// fetch all symptoms by reading in file
		ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile(PATH+FILENAME_IN);
		List<String> symptoms = readSymptomDataFromFile.getSymptoms();

		// count symptoms and create map
		ISymptomsOperations symptomsOperations = new SymptomOperations();
		Map<String, Long> symptomsAndCount = symptomsOperations.symptomsAndCount(symptoms);

		// write in out file
		ISymptomsCountWriter writer = new Writer(PATH+FILENAME_OUT);
		writer.writeSymptoms(symptomsAndCount);
	}

}
