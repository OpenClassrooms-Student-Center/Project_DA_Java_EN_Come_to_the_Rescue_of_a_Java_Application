package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class WriteSymptomIntoFile {
    private String filepath;
    private TreeMap<String, int[]> map;

    public WriteSymptomIntoFile(String filepath, TreeMap<String, int[]> map) {
        this.filepath = filepath;
        this.map = map;
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

                for (String key:map.keySet()){
                    int[]nombre = map.get(key);
                    bw.write(key +"="+nombre[0]);
                    bw.newLine();
                }

                bw.close();

            } catch (IOException e) {
                System.err.println("le fichier n'a pas été trouvé");
            }

        }
    }

}
