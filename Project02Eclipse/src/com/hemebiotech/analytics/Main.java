package com.hemebiotech.analytics;

import com.hemebiotech.analytics.analytics.Analytics;

public class Main {

    private static Analytics analytics;

    public static void main(String[] args) {
        analytics = new Analytics("symptoms.txt", "result.out"); //Create Analytics object.
        analytics.generateSymptomsResult(); // Generate file.
    }

    /**
     *
     * @return The object allowing to read / sort and rewrite a file
     */
    public Analytics getAnalytics() {
        return analytics;
    }
}
