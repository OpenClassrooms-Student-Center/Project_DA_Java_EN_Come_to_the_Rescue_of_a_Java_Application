package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteSymptomDataToFile implements ISymptomWriter {
  private static final Logger LOGGER = Logger.getLogger("WriteSymptomDataToFile");

  @Override
  public void writeSymptoms(Map<String, Integer> symptoms) {
    try (final FileWriter writer = new FileWriter("result.out")) {
      for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
        writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
      }
    } catch (IOException e) {
      LOGGER.log(Level.SEVERE, "Error Happened during writing");
      throw new RuntimeException(e);
    }
  }
}
