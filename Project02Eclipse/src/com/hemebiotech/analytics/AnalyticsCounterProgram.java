package com.hemebiotech.analytics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class AnalyticsCounterProgram {
    ISymptomReader reader;
    ISymptomResultWriter writer;
    ISymptomSort sorter;

    /**
     * Constructor of the class AnalyticsCounterProgram
     * Instantiate the reader, writer and the sorter to enable the program to operate
     */
    public AnalyticsCounterProgram() {
        this.reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
        this.writer = new WriteSymptomDataResult("result.out");
        this.sorter = new SymptomsSort();
    }

    /**
     * Function who recover, sort and write a list of symptoms with the attached count
     */
    public void start() throws IOException {
        ArrayList<String> listSymptoms;
        Hashtable<String, Integer> listSymptomsClean;
        listSymptoms = this.reader.GetSymptoms();
        listSymptomsClean = this.sorter.CleanSymptomsList(listSymptoms);
        this.writer.WriteSymptoms(listSymptomsClean);
    }
}
