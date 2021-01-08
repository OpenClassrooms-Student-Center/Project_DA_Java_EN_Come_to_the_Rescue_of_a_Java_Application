package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.lang.String;


public class AnalyticsCounter {
    private static int headacheCount = 0;
    private static int rashCount = 0;
    private static int dialatedpupilCount = 0;
    public static int i = 0;

    public static void main(String args[]) throws Exception {
        // first get input
        BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
        String line = reader.readLine();

        while (line != null) {
        	System.out.println("symptom from file: " + line);
        	if (line.equals("headache")) {
        		headacheCount++;
        	}
        	else if (line.equals("rash")) {
        		rashCount++;
        	}
        	else if (line.contains("dialated pupils")) {
        		dialatedpupilCount++;
        	}
        	line = reader.readLine();
        }
        int y = 100;
        String arraysymptoms[] = new String[y];
        String result;

        while (line != null) {
            arraysymptoms[i] = line;
            result = arraysymptoms[i];
            System.out.println("symptom from file: " + line);
            System.out.println("Symptom add to array: " + result);
            i++;
            line = reader.readLine();
        }

        // si symptoms es = alors ++ dans 2e array
        i = 0;
        int resultint;
        int numbersymptoms[]= new int[y];
        int a = i;
        for (int x=0; x<=y; x++ ){
            if (arraysymptoms[i] == arraysymptoms[a]){
                numbersymptoms[i]=numbersymptoms[i] + 1;
                resultint = numbersymptoms[i];
                System.out.println(resultint);
                a++;
            }
        }

        // next generate output
        FileWriter writer = new FileWriter("result.out");
        writer.write("headache: " + headacheCount + "\n");
        writer.write("rash: " + rashCount + "\n");
        writer.write("dialated pupils: " + dialatedpupilCount + "\n");
        writer.close();
    }
}
