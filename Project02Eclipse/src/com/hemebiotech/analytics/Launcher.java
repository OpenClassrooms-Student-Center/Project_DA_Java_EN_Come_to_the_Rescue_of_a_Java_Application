package com.hemebiotech.analytics;

public class Launcher {

    public static void main(String[] args) throws Exception {

        String filePath = "symptoms.txt";
        String filename = "result.out";

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(filePath, filename);
        analyticsCounter.readAndSaveOccurenceSymptoms();
    }
}
