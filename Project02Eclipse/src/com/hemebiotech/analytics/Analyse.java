package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;


public class Analyse {

	private ISymptomReader iSymptomReader;
	private CountAndOrderSymptoms countAndOrderSymptoms;
	private ISymptomWriter iSymptomWriter;

	
	public Analyse(ISymptomReader iSymptomReaderFromMain, CountAndOrderSymptoms countAndOrderSymptomsFromMain,
			ISymptomWriter iSymptomWriterFromMain) {
		this.iSymptomReader = iSymptomReaderFromMain;
		this.countAndOrderSymptoms = countAndOrderSymptomsFromMain;
		this.iSymptomWriter = iSymptomWriterFromMain;
	}

	
	public List<String> getSymptom() {
		return this.iSymptomReader.getSymptoms();
	}

	
	public Map<String, Integer> symtomsCounter(List<String> symptomList) {
		return this.countAndOrderSymptoms.processData(symptomList);
	}


	public void writeDataSymptoms(Map<String, Integer> symptomsMap) {
		this.iSymptomWriter.writeSymptoms(symptomsMap);
	}
}