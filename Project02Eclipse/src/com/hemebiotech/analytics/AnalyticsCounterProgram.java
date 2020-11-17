package com.hemebiotech.analytics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class AnalyticsCounterProgram {
    ISymptomReader reader;
    ISymptomResultWriter writer;
    ISymptomSort sorter;

    /**
     *
     * @throws IOException
     */
    public AnalyticsCounterProgram() throws IOException {
        this.reader = new ReadSymptomDataFromFile("/home/johanna/Bureau/workspace_OCR/P2/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt");;
        this.writer = new WriteSymptomDataResult("result.out");
        this.sorter = new SymptomsSort();
    }

    /**
     *
     * @throws IOException
     */
    public void start() throws IOException {
        ArrayList<String> listSymptoms;
        Hashtable<String, Integer> listSymptomsClean;
        listSymptoms = this.reader.GetSymptoms();
        listSymptomsClean = this.sorter.CleanSymptomsList(listSymptoms);
        this.writer.WriteSymptoms(listSymptomsClean);
    }
}
