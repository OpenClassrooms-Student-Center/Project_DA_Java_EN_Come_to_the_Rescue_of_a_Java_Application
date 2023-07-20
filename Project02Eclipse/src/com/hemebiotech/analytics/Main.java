package com.hemebiotech.analytics;

public class Main {

  public static void main(String[] args) {
    final var analytics = new AnalyticsCounter(
      new ReadSymptomDataFromFile("symptoms.txt"),
      new WriteSymptomDataToFile("result.out")
    );
    analytics.writeSymptoms(analytics.sortSymptoms(analytics.countSymptoms(analytics.getSymptoms())));
  }
}
