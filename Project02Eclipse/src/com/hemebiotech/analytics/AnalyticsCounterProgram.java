package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class AnalyticsCounterProgram {
    ISymptomReader reader;
    ISymptomResultWriter writer;
    SymptomsSort sorter = new SymptomsSort();
    ArrayList<String> listSymptoms = new ArrayList<String>();
    Hashtable<String, Integer> listSymptomsClean = new Hashtable<>();

    /**
     *
     * @throws IOException
     */
    public AnalyticsCounterProgram() throws IOException {
        this.reader = new ReadSymptomDataFromFile("/home/johanna/Bureau/workspace_OCR/P2/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt");;
        this.writer = new WriteSymptomDataResult();
    }

    /**
     *
     * @throws IOException
     */
    public void start() throws IOException {
        listSymptoms = this.reader.GetSymptoms();
        listSymptomsClean = this.sorter.CleanSymptomsList(listSymptoms);
        this.writer.WriteSymptoms(listSymptomsClean);
    }
}
