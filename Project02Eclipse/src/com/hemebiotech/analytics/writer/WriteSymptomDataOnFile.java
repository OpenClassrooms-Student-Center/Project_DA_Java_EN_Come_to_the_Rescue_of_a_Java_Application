package com.hemebiotech.analytics.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Sort and write symptoms data on a source
 */
public class WriteSymptomDataOnFile implements ISymptomWriter {

    private Map<String, Integer> symptomMap;
    private String filepath;

    /**
     * @param symptomMap a map of every symptom with their count from the source with no duplicate
     * @param filepath   a full or partial path to file with symptom strings in it, one per line
     */
    public WriteSymptomDataOnFile(Map<String, Integer> symptomMap, String filepath) {
        this.symptomMap = symptomMap;
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms() {

        Map<String, Integer> orderedSymptomsCount = orderSymptomsCount();

        if (filepath != null) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, false));

                orderedSymptomsCount.forEach((symptom, count) -> {
                    try {
                        writer.write(symptom + "=" + count);
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return an ordered alphbetic map of symtoms with their count, no duplicates are possible/probable
     */
    private Map<String, Integer> orderSymptomsCount() {

        List<String> orderkeys = new ArrayList<String>();

        symptomMap.forEach((symptom, count) -> orderkeys.add(symptom));

        Collections.sort(orderkeys);

        Map<String, Integer> orderedSymptomsCount = new LinkedHashMap<String, Integer>();

        orderkeys.forEach((key) -> orderedSymptomsCount.put(key, symptomMap.get(key)));

        return orderedSymptomsCount;

    }

}