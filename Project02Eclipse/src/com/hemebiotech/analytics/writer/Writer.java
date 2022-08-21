package com.hemebiotech.analytics.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import static com.hemebiotech.analytics.constant.Constant.FILENAME_OUT;

public class Writer {

    public static void writingData(Map<String,Long> symptomsAndCount) throws IOException {
        // create output file
        FileWriter writer = new FileWriter(FILENAME_OUT);

        // write symptom and count
        symptomsAndCount.forEach((s, aLong) -> {
            try {
                writer.write(s + ": " + aLong + "\n");
            } catch (IOException e) {
                System.out.println("for the future");
            }
        });
        writer.close();
    }

}
