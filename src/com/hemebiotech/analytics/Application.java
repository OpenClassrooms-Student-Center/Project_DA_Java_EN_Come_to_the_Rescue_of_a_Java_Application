package com.hemebiotech.analytics;

import com.hemebiotech.analytics.dao.implement.SymptomFileDao;
import com.hemebiotech.analytics.services.SymptomServices;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        //Fonction test
        new SymptomFileDao("symptoms.txt").getAll().forEach(symptom -> System.out.println(symptom.getName()));

        //Fonction test
        Map hashTest = new SymptomServices().countFrequency();
        for (Object i : hashTest.keySet())
            System.out.println(i + "," + hashTest.get(i));
    }
}
