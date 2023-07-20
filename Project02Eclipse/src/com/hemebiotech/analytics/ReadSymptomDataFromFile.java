package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {
  private final String filepath;

  public ReadSymptomDataFromFile(String filepath) {
    this.filepath = filepath;
  }

  @Override
  public List<String> retrieveSymptoms() {
    final var result = new ArrayList<String>();
    if (filepath != null) {
      try {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = reader.readLine();

        while (line != null) {
          result.add(line);
          line = reader.readLine();
        }
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return result;
  }
}
