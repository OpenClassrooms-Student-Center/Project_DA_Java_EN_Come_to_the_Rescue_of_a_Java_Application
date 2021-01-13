package com.hemebiotech.analytics;

public class SymptomAnalysis {
    public static void main(String[] args) {

        ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("Project02Eclipse/src/com/hemebiotech/analytics/symptoms.txt");
        SymptomMapping mapping = new SymptomMapping(reader.GetSymptoms());
        SymptomOutput output = new SymptomOutput(mapping.analyzeSymptoms());

        try {
            output.getFileOutput();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}