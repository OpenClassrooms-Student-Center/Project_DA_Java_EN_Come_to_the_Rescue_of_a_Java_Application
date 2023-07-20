package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadSymptomDataFromFile implements ISymptomReader {
  private static final Logger LOGGER = Logger.getLogger("ReadSymptomDataFromFile");
  private final String filepath;

  public ReadSymptomDataFromFile(String filepath) {
    this.filepath = filepath;
  }

  @Override
  public List<String> retrieveSymptoms() {
    final var result = new ArrayList<String>();
    try (final BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
      String line = reader.readLine();
      while (line != null) {
        result.add(line);
        line = reader.readLine();
      }
    } catch (IOException e) {
      LOGGER.log(Level.SEVERE, "Error Happened during reading file");
    }
    return result;
  }
}
