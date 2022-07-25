package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.util.Map;

public class AnalyticsCounter {

    public static void main(String[] args) throws Exception {
        CheckSymptomFile checkSymptomFile = new CheckSymptomFile();
        String filePathFromClassPath;
        String fileName = "symptoms.txt";
        String outPutFile = "result.out";

        try {
            filePathFromClassPath = checkSymptomFile.getFilePathFromClassPath(fileName);
            ISymptomReader reader = new ReadSymptomDataFromFile(filePathFromClassPath);
            ISymptomWriter writer = new WriteSymptomOnNewFile(outPutFile);

            Map<String, Integer> mapFromFile
                    = reader.hashMapSymptoms();

            writer.writeSymptoms(mapFromFile);
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName +" not found");
        }
    }
}

