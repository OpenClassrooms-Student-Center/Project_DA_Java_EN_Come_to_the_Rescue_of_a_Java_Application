package com.hemebiotech.analytics;


import java.io.FileWriter;

public class SymptomsWriter {

    public static void writer() throws Exception {

        // next generate output
        FileWriter writer = new FileWriter("result.out");
        for (int i = 0; i< symptoms.length ; i++){
            String result = symptoms[i][0];
            if (result != null ){
                writer.write("Symptoms : " + symptoms[i][0] + " occurrences numbers " + symptoms[i][1] + "." + "\n");
            }
        }
        writer.close();
    }
}
