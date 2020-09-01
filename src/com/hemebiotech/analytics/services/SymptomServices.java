package com.hemebiotech.analytics.services;

import com.hemebiotech.analytics.dao.Dao;
import com.hemebiotech.analytics.dao.implement.SymptomFileDao;
import com.hemebiotech.analytics.models.Symptom;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Creates methods of services
 */
public class SymptomServices {

    private Dao<Symptom> symptomDao;

    public SymptomServices(String filepath) {
        symptomDao = new SymptomFileDao(filepath);
    }

    /**
     *
     * @return a TreeMap with Symptom name as key and frequency as value.
     * No duplicate allowed. In alphabetical order (by key / symptom name).
     */
    public Map<String, Integer> countFrequency() {

        return symptomDao.getAll().stream().collect(Collectors.toMap(
                Symptom::getName,
                symptom -> 1,
                Integer::sum,
                TreeMap::new
        ));
    }

    /**
     * generates symptomDao result.out with symptom name and frequency
     * if existing, replace the old by the new
     */
    public void getResult() {
        Map <String, Integer> map = countFrequency();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("result.out"))){
            for (String i : map.keySet()) {
                bw.write(i + "," + map.get(i));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

