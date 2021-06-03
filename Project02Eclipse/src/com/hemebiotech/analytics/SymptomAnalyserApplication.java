package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

public class SymptomAnalyserApplication extends AbstractSymptomAnalyzerApplication {
	
	public void run() {
		
		List<String> symptoms = this.reader.GetSymptoms();
		
		TreeMap<String, Integer> stats = analyser.count(symptoms);
		
		this.writer.export(stats);
		
	}
	
}
