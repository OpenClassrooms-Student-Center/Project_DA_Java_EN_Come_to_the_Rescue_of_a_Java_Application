package com.hemebiotech.analytics;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private CountFreq countFreq;
	private Caster caster;
	private ChangeOrder changeOrder;
	private ResultWriter resultWriter;
	
	
	public AnalyticsCounter(ISymptomReader reader) {
		this.reader = reader;	
	}
	
	public void doProcess() throws IOException {
		List<String> symptoms = reader.GetSymptoms();
		Map<String,Integer> symptomsCount = countFreq.CountFrequency(symptoms);
		symptoms = caster.CastToList(symptomsCount);
		symptoms = changeOrder.InAlphabeticalOrder(symptoms);
		resultWriter.WriteResult(symptoms);
	

	public static void main(String args[]) throws Exception {
		
		String filepath = new File("Project02Eclipse/symptoms.txt").getCanonicalPath();
		ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader);
		analyticsCounter.doProcess();
				
				
//		ISymptomReader reader = new ReadSymptomDataFromFile(symptomsFile);
//		List<String> symptomList = reader.GetSymptoms();
//		
//		CountFreq counter = new CountFreq();
//		Map<String, Integer> symptomCount = counter.CountFrequency(symptomList);
//		
//		Caster changeToList = new CastAction();
//		List<String> symptomList = changeToList.CastToList(symptomCount);
//		
//		ChangeOrder OrderAlphabetic = new ChangeOrder();
//		symptomList = OrderAlphabetic.InAlphabeticalOrder(symptomList);
//		
//		ResultWriter writer = new WriteResultInFile();
//		writer.WriteResult(symptomList);
//		
	
	}

}
