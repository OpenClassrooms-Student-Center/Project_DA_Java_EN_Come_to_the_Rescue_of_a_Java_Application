package com.hemebiotech.analytics;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	
	private CountFrequency countFreq;
	private IResultWriter writer;
	private ISymptomReader reader;
	
	public AnalyticsCounter(ISymptomReader reader, IResultWriter writer) {
		this.countFreq = new CountFrequency();
		this.writer = writer;
		this.reader = reader;
	}
	
	public void analyticsProcess() throws IOException {
		List<String> symptomsList = this.reader.GetSymptoms();
		Map<String,Integer> symptomsCount = countFreq.CountFrequency(symptomsList);
		this.writer.WriteResult(symptomsCount);
	}

	public static void main(String args[]) throws Exception {
	
		String filepath = new File("Project02Eclipse/symptoms.txt").getCanonicalPath();
		String pathOutput = "Project02Eclipse/";		
		ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
		IResultWriter writer = new WriteResultInFile(pathOutput);
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);
		analyticsCounter.analyticsProcess();		
	}
}
