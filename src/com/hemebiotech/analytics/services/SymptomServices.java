package com.hemebiotech.analytics.services;

import com.hemebiotech.analytics.dao.Dao;
import com.hemebiotech.analytics.dao.implement.SymptomFileDao;
import com.hemebiotech.analytics.models.Symptom;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.Entry.comparingByKey;

/**
 * Creates methods of services
 */
public class SymptomServices {

    private Dao<Symptom> file = new SymptomFileDao("symptoms.txt");

    /**
     *
     * @return a TreeMap with Symptom name as key and frequency as value.
     * No duplicate allowed. In alphabetical order (by key / symptom name).
     */
    public Map<String, Integer> countFrequency() {

        return file.getAll().stream().collect(Collectors.toMap(
                Symptom::getName,
                symptom -> 1,
                Integer::sum,
                TreeMap::new
        ));
    }

    /**
     * generates file result.out with symptom name and frequency
     * if existing, replace the old by the new
     */
    public void getResult() {
        Map <String, Integer> map = countFrequency();
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("result.out"));
            for (String i : map.keySet()) {
                bw.write(i + "," + map.get(i));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

