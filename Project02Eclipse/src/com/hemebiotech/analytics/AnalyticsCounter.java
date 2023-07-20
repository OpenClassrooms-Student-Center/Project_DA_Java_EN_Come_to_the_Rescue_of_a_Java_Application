package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
  private final ISymptomReader reader;
  private final ISymptomWriter writer;

  public AnalyticsCounter(final ISymptomReader reader, final ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
  }

  public Map<String, Integer> countSymptoms(final List<String> symptoms) {
    final Map<String, Integer> map = new HashMap<>();
    symptoms.forEach(s -> map.put(s, symptoms.stream().filter(word -> word.equals(s)).toList().size()));
    return map;
  }

  public List<String> getSymptoms() {
    return reader.retrieveSymptoms();
  }

  public Map<String, Integer> sortSymptoms(final Map<String, Integer> symptoms) {
    return new TreeMap<>(symptoms);
  }

  public void writeSymptoms(Map<String, Integer> symptoms) {
    writer.writeSymptoms(symptoms);
  }
}
