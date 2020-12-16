package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.Map;

public class AnalyticsCounter {

    public static void main(String[] args) throws Exception {

        CountSymptoms counter = new CountSymptoms();

        Map<String, Integer> symptoms = counter.getSymptoms("Project02Eclipse/symptoms.txt");
        System.out.println(symptoms);

        SymptomsWriter mywriter = new SymptomsWriter();
        mywriter.toFile("result.out", symptoms);

    }
}
