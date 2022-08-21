package com.hemebiotech.analytics.reader;

import com.hemebiotech.analytics.constant.Constant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.hemebiotech.analytics.constant.Constant.FILENAME_IN;


public class Reader {

    static public List<String> fetchSymptoms() throws IOException {
        BufferedReader reader
                = new BufferedReader(new FileReader(FILENAME_IN));
        List<String> symptoms = new ArrayList<>();

        // read all symptoms and create list
        String line = reader.readLine();
        while (line != null) {
            symptoms.add(line);
            line = reader.readLine();
        }
        return symptoms;
    }

}
