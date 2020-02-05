package com.hemebiotech;

import com.hemebiotech.analytics.ReadSymptomDataFromFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static ArrayList<ArrayList<String>> result = new ArrayList<>();
    static ArrayList<String> symptomsSearch = new ArrayList<>();
    static ArrayList<String> counting = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        ReadSymptomDataFromFile readSymptoms = new ReadSymptomDataFromFile("symptoms.txt");
        List<String> symptoms = readSymptoms.GetSymptoms();
        ReadSymptomDataFromFile readSymptomsSearch = new ReadSymptomDataFromFile("symptomsSearch.txt");
        symptomsSearch = readSymptomsSearch.GetSymptoms();
        if (symptomsSearch != null && symptoms != null) {
            for (String search : symptomsSearch) {
                int count = 0;

                for (String symptom : symptoms) {
                    if (symptom.contains(search)) {
                        count++;
                    }
                }
                counting.add(String.valueOf(count));
            }
        }
        result.add(symptomsSearch);
        result.add(counting);

        FileWriter writer = new FileWriter("result.out");
        for (int i = 0; i < symptomsSearch.size(); i++) {
            writer.write(symptomsSearch.get(i) + "=" + counting.get(i) + "\n");
        }
        for (int i = 0; i < symptomsSearch.size(); i++) {
            System.out.println(symptomsSearch.get(i) + "=" + counting.get(i));
        }
        System.out.println(result);
    }
}
