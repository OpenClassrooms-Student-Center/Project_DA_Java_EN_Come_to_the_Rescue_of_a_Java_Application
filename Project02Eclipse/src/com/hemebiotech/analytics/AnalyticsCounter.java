package com.hemebiotech.analytics;
import com.hemebiotech.analytics.reader.Reader;

import java.io.BufferedReader;
import java.util.*;
import java.util.stream.Collectors;

import static com.hemebiotech.analytics.reader.Reader.fetchSymptoms;
import static com.hemebiotech.analytics.utils.Utils.symptomsAndCount;
import static com.hemebiotech.analytics.writer.Writer.writingData;

public class AnalyticsCounter {

	public static void main(String[] args) throws Exception {

		// fetch all symptoms by reading in file
		List<String> symptoms = fetchSymptoms();

		// count symptoms and create map
		Map<String, Long> symptomsAndCount = symptomsAndCount(symptoms);

		// write in out file
		writingData(symptomsAndCount);
	}
}
