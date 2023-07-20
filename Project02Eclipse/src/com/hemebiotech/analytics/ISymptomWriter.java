package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
  /**
   * write symptom to file
   * @param symptoms Map<String, Integer>
   */
  void writeSymptoms(Map<String, Integer> symptoms);
}
