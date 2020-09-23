package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/***
 *The program is used to read a file with symptoms, count each time they appear and order them alphabetically.
 * the result is then written in an other file
 */
public class OutputSymptoms {

    public static void main (String[] args) throws Exception {

       new AnalyticsCounter(args);

}
    }