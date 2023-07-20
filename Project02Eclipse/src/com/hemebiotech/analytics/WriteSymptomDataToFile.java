package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteSymptomDataToFile implements ISymptomWriter {
  private static final Logger LOGGER = Logger.getLogger("WriteSymptomDataToFile");
  private final String fileName;

  public WriteSymptomDataToFile(final String fileName) {
    this.fileName = fileName;
  }

  @Override
  public void writeSymptoms(Map<String, Integer> symptoms) {
    try (final FileWriter writer = new FileWriter(fileName)) {
      for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
        writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
      }
    } catch (IOException e) {
      LOGGER.log(Level.SEVERE, "Error Happened during writing");
      throw new RuntimeException(e);
    }
  }
}
