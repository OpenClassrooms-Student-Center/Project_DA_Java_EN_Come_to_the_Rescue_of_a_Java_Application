package com.hemebiotech.analytics;

import java.util.List;

public interface ISymptomReader {
  /**
   * retrieve symptoms from specified file
   * @return List<String>
   */
  List<String> retrieveSymptoms();
}
