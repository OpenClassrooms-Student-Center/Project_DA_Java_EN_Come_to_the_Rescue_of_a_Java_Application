package com.hemebiotech.analytics;

import com.hemebiotech.analytics.dao.implement.SymptomFileDao;

public class Application {

    public static void main(String[] args) {
        new SymptomFileDao("symptoms.txt").getAll().forEach(symptom -> System.out.println(symptom.getName()));
    }
}
