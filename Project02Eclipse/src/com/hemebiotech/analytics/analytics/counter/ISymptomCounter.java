package com.hemebiotech.analytics.analytics.counter;

public interface ISymptomCounter {

    /**
     * If no data is available, this will create an empty Map
     *
     * Create a raw map of all Symptoms counted and sorted obtained from listing of all Symptoms.
     */
    void count();
}
