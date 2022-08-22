package com.hemebiotech.analytics;
import com.hemebiotech.analytics.readSymptoms.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.writer.Writer;
import java.util.*;
import static com.hemebiotech.analytics.constant.Constant.FILENAME_IN;
import static com.hemebiotech.analytics.constant.Constant.FILENAME_OUT;
import static com.hemebiotech.analytics.utils.Utils.symptomsAndCount;

public class AnalyticsCounter {

	public static void main(String[] args){

		// fetch all symptoms by reading in file
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(FILENAME_IN);
		List<String> symptoms = readSymptomDataFromFile.GetSymptoms();

		// count symptoms and create map
		Map<String, Long> symptomsAndCount = symptomsAndCount(symptoms);

		// write in out file
		Writer writer = new Writer(FILENAME_OUT);
		writer.writeSymptoms(symptomsAndCount);
	}
}
