package com.hemebiotech.analytics;

import com.hemebiotech.analytics.dao.implement.SymptomFileDao;
import com.hemebiotech.analytics.services.SymptomServices;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        // Fonction de test
        new SymptomServices().getResult();
    }
}
