package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
    private static int headacheCount = 0;
    private static int rashCount = 0;
    private static int pupilCount = 0;

    public static void main(String args[]) throws Exception {

        BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
        String line = reader.readLine();

        int i = 0;

        while (line != null) {
            i++;
            System.out.println("symptom from file: " + line);
            if (line.equals("headache")) {
                headacheCount++;
                System.out.println("number of headaches: " + headacheCount);
            } else if (line.equals("rash")) {
                rashCount++;
            } else if (line.contains("pupils")) {
                pupilCount++;
            }

            line = reader.readLine();
        }

        FileWriter writer = new FileWriter("result.out");
        writer.write("headache: " + headacheCount + "\n");
        writer.write("rash: " + rashCount + "\n");
        writer.write("dialated pupils: " + pupilCount + "\n");
        writer.close();
    }
}
