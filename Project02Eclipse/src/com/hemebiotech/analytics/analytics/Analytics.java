package com.hemebiotech.analytics.analytics;

import com.hemebiotech.analytics.analytics.counter.SymptomCounter;
import com.hemebiotech.analytics.analytics.reader.SymptomReader;
import com.hemebiotech.analytics.analytics.writer.SymptomWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Analytics {

    private final SymptomReader reader;
    private final SymptomCounter counter;
    private final SymptomWriter writter;

    /**
     *
     * @param from is the name of the file which contains the list of symptoms out of order.
     * @param to is the name of the file that will be generated once the list is sorted.
     */
    public Analytics(String from, String to) {
        this.reader = new SymptomReader(from);
        this.counter = new SymptomCounter();
        this.writter = new SymptomWriter(to);
    }

    /**
     * Read count and sort all symptoms.
     */
    public void generateSymptomsResult() {
        this.reader.read(); // Read main file and create raw list.
        this.counter.setSymptoms(this.reader.getSymptoms()); // Set raw list in SymptomCounter object .
        this.counter.count(); // Count and sort raw list and create TreeMap.
        this.writter.write(this.counter.getSortedSymptoms()); // Create new file with result.
    }

}
