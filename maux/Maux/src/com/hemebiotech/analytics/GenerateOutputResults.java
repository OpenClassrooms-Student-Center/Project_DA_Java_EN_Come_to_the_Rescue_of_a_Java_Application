package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;


/**
 * Generate the reports from a String List. Outputs in a file
 */
public class GenerateOutputResults {

    public static void generate(String text) {
        try (FileWriter writer = new FileWriter("result.out")) {
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
