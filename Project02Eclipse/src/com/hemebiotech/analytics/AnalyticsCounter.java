package com.hemebiotech.analytics;

import java.io.*;
import java.util.*;
import java.lang.String;
import java.util.stream.Collectors;


public class AnalyticsCounter {
    public static int i = 0;

    public static void main(String args[]) throws Exception {
        // first get input
        // changer de conteneur
            BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
            HashMap<String, Integer> symptoms = new HashMap<>();
            reader.lines().forEach(readLine -> {
                if (symptoms.containsKey(readLine)) {
                    symptoms.put(readLine, symptoms.get(readLine) + 1);
                } else {
                    symptoms.put(readLine, 1);
                }
            }


        System.out.println(symptoms.toString());

        // next generate output
/*      FileWriter writer = new FileWriter("result.out");
        writer.write("headache: " + headacheCount + "\n");
        writer.write("rash: " + rashCount + "\n");
        writer.write("dialated pupils: " + dialatedpupilCount + "\n");
        writer.close();*/

    }


    public void func() throws Exception {
        // first get input
        BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
        String line = reader.readLine();
        /*while (line != null) {
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
        }*/
        int y = 100;
        String arraysymptoms[] = new String[y];
        String result;

        while (line != null) {
            arraysymptoms[i] = line;
            /*result = arraysymptoms[i];
            System.out.println("symptom from file: " + line);
            System.out.println("Symptom add to array: " + result);*/
            i++;
            line = reader.readLine();
        }

        // si symptoms es = alors ++ dans 2e array

        for(String value : arraysymptoms)
        {
            System.out.println(value);
        }

        i = 0;
        int resultint;
        int numbersymptoms[]= new int[y];
        int a = i;
        int cmp =0;
        for (int x = 0; x < arraysymptoms.length; x++ ){
            if (arraysymptoms[i] == arraysymptoms[x]){
                cmp++;
                numbersymptoms[i]= cmp;
                resultint = numbersymptoms[i];
                System.out.println("yes occurence");
                System.out.println("count occurence " + resultint);
                a++;
            }
            else if (arraysymptoms[i] == arraysymptoms[x]){
                System.out.println("no occurence");
                a++;
            }
        }
    }
}
