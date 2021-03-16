package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteSymptomIntoFile {
    private String filepath;
    private List<String> list;

    public WriteSymptomIntoFile(String filepath, List<String> list) {
        this.filepath = filepath;
        this.list = list;
    }

    public void writeSymptoms() {
        File file = new File(filepath);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("we can't create the file");
            }
        } else {

            try {
                FileWriter filewriter = new FileWriter(filepath);
                BufferedWriter bw = new BufferedWriter(filewriter);

                for (String symptom : list) {
                    bw.write(symptom);
                    bw.newLine();
                }

                bw.close();

            } catch (IOException e) {
                System.err.println("le fichier n'a pas été trouvé");
            }

        }
    }

}
