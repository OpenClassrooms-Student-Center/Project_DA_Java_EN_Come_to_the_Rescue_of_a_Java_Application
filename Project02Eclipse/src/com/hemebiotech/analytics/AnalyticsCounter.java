package com.hemebiotech.analytics;
/** Main class reading the raw symptoms file and creating the result.out file. */
public class AnalyticsCounter {
	public static void main(String args[]) throws Exception {
        ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/src/com/hemebiotech/analytics/symptoms.txt");
        ISymptomAnalysis mapping = new SymptomMapping(reader.GetSymptoms());
	ISymptomFile output = new SymptomOutput(mapping.analyzeSymptoms());		
		//try catch to get the exceptions if something happens during the file creation
        try {
            output.getFileOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
