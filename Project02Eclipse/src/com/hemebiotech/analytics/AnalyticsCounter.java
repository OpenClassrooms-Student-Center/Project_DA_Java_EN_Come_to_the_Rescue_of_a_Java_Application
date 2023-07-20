package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
  private static final int headacheCount = 0;
  private static int rashCount = 0;
  private static int pupilCount = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"));
    String line = reader.readLine();
    int i = 0;
    int headCount = 0;
    while (line != null) {
      i++;
      System.out.println("symptom from file: " + line);
      if (line.equals("headache")) {
        headCount++;
        System.out.println("number of headaches: " + headCount);
      } else if (line.equals("rush")) {
        rashCount++;
      } else if (line.contains("pupils")) {
        pupilCount++;
      }
      line = reader.readLine();
    }
  }
}
