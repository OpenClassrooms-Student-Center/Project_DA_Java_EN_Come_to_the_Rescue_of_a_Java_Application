package com.hemebiotech.analytics;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.TreeMap;

public class Main  {


    public static void main(String[] args) throws IOException {


        AnalyticsCounter count = new AnalyticsCounter();



        ISymptomReader input = new ReadSymptomDataFromFile("Symptoms.txt");

        List<String> lireSymptoms = count.readSymptom(input);

        ICountAndSort countAndSort = new CountAndSortSymptoms(lireSymptoms);


        TreeMap<String, Integer> sortAndCount = count.sortAndCount(countAndSort);

        count.saveResult(sortAndCount);




        }

    }

