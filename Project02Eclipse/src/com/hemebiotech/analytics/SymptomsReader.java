package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SymptomsReader implements ISymptomReader {

    private final String filePath;

    public SymptomsReader(String file) {
        this.filePath = file;
    }

    @Override
    public List<String> getSymptoms() {
        List<String> result = new ArrayList<String>();

        if (filePath != null) {
            try {
                BufferedReader reader = new BufferedReader (new FileReader(filePath));
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
