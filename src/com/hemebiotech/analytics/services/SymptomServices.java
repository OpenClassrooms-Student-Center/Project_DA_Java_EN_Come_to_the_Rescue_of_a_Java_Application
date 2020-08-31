package com.hemebiotech.analytics.services;

import com.hemebiotech.analytics.dao.Dao;
import com.hemebiotech.analytics.dao.implement.SymptomFileDao;
import com.hemebiotech.analytics.models.Symptom;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SymptomServices {

    private SymptomFileDao file = new SymptomFileDao("symptoms.txt");

    /**
     *
     * @return a Map with Symptom name as key and frequency as value.
     */
    public Map<String, Integer> countFrequency() {
        Stream<Symptom> symptomStream = file.getAll().stream();

        Map<String, Integer> frequencyList = symptomStream.collect(Collectors.toMap(
                Symptom::getName,
                symptom -> 1,
                Integer::sum
        ));

        return frequencyList;
    }
}

