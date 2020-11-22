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
        this.reader = new ReadSymptomDataFromFile("/home/johanna/Bureau/workspace_OCR/P2/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt");;
        this.writer = new WriteSymptomDataResult("result.out");
        this.sorter = new SymptomsSort();
    }

    /**
     * Function who recover, sort and write a list of symptoms with the attached count
     */
    public void start()  {
        ArrayList<String> listSymptoms;
        Hashtable<String, Integer> listSymptomsClean;
        listSymptoms = this.reader.GetSymptoms();
        listSymptomsClean = this.sorter.CleanSymptomsList(listSymptoms);
        this.writer.WriteSymptoms(listSymptomsClean);
    }
}
