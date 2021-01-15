package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;
import java.lang.String;
import java.util.stream.Collectors;

public class AnalyticsCounter {


    public static void main(String args[]) throws Exception {
        SymptomsReader.reader();
        DataSymptoms.datasymptoms();
        SymptomsWriter.writer();
        /*// first get input
        BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));

        ArrayList<String> symptomslist = new ArrayList<>();
        reader.lines().forEach(readLine -> {
            symptomslist.add(readLine);
        });
        Set<String> setsymptoms = new HashSet<>(symptomslist); // HashSet to delete double.
        ArrayList<String> symptomslist2 = new ArrayList<>(setsymptoms); // List with not double to compare to count.
        String[][] Symptoms = new String[symptomslist2.size()][2];

        for (int i = 0; i < symptomslist2.size(); i++) {
            Collections.sort(symptomslist2);
            String result1 = symptomslist2.get(i);
            int count = 0;
            for (int a = 0; a < symptomslist.size(); a++) {
                String result2 = symptomslist.get(a);
                if (result1.equals(result2)) {
                    count++;
                }
            }
            String strcount = Integer.toString(count);
            Symptoms[i][0] = result1;
            Symptoms[i][1] = strcount;
        }

        // next generate output
        FileWriter writer = new FileWriter("result.out");
        for (int i = 0; i< Symptoms.length ; i++){
            String result = Symptoms[i][0];
            if (result != null ){
                writer.write("Symptoms : " + Symptoms[i][0] + " occurrences numbers " + Symptoms[i][1] + "." + "\n");
            }
        }
        writer.close();*/
    }
}