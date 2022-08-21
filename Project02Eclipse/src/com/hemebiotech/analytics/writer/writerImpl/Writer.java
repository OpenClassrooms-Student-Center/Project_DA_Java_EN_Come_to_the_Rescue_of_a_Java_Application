package com.hemebiotech.analytics.writer.writerImpl;

import com.hemebiotech.analytics.writer.ISymptomsCountWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Writer implements ISymptomsCountWriter {

    private final String filepath;

    public Writer(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeSymptomsCount(Map<String, Long> symptomsAndCount) {

        if (filepath != null) {
            try {
                // create output file
                FileWriter writer = new FileWriter(filepath);

                // write symptom and count them
                symptomsAndCount.forEach((s, aLong) -> {
                    try {
                        writer.write(s + ": " + aLong + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
