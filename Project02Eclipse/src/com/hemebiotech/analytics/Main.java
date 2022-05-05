package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/** 
 * Run the Application
 * 
 */
public class Main {
    
    public static void main(String[] args) {
        
        ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("/Users/ray/Documents/DeveloppeurApplicationJAVA/P2_debuggez_une_application_Java/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt");

		List<String> listOfSymptoms = readSymptomDataFromFile.GetSymptoms();

        // listOfSymptom.forEach((symptom) -> System.out.println(symptom));

        AnalyticsCounter analyticsCounter = new AnalyticsCounter(listOfSymptoms);

        Map<String, Integer> symptomCounter = analyticsCounter.symptomCounter();

        // symptomCounter.forEach((symptom, count) -> System.out.println(symptom + "=" + count));

        WriteSymptomDataOnFile symptomsCountFile = new WriteSymptomDataOnFile(symptomCounter, "/Users/ray/Documents/DeveloppeurApplicationJAVA/P2_debuggez_une_application_Java/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/result.out");

        symptomsCountFile.writeSymptoms();

    }

}
