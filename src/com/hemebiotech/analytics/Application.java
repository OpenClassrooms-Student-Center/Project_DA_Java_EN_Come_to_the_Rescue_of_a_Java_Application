package com.hemebiotech.analytics;

import com.hemebiotech.analytics.services.SymptomServices;

public class Application {

    public static void main(String[] args) {
        new SymptomServices("symptoms.txt").getResult();
    }
}
