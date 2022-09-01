package com.hemebiotech.analytics;
import com.hemebiotech.analytics.service.ISymptomReader;
import com.hemebiotech.analytics.service.ISymptomsCountWriter;
import com.hemebiotech.analytics.service.impl.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.service.impl.Writer;
import java.util.*;

import static com.hemebiotech.analytics.constant.Constant.*;
import static com.hemebiotech.analytics.utils.Utils.symptomsAndCount;

public class AnalyticsCounterApplication {

	public static void main(String[] args){

		// fetch all symptoms by reading in file
		ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile(PATH+FILENAME_IN);
		List<String> symptoms = readSymptomDataFromFile.getSymptoms();

		// count symptoms and create map
		Map<String, Long> symptomsAndCount = symptomsAndCount(symptoms);

		// write in out file
		ISymptomsCountWriter writer = new Writer(PATH+FILENAME_OUT);
		writer.writeSymptoms(symptomsAndCount);
	}

}
