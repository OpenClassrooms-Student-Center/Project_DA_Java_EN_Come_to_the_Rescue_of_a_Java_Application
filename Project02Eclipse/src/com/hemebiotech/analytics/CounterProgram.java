package com.hemebiotech.analytics;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CounterProgram {
	
	ISymptomReader reader;
	ISymptomWriter writer;
	
	public CounterProgram(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	public void start() {
		Map<String,Integer> symptoms = new TreeMap<>(reader.getSymptoms());
		writer.write();
	}

}
