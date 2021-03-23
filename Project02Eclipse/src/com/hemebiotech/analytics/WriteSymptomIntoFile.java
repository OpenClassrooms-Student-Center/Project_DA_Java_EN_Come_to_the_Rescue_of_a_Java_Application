package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * <b>WriteSymptomIntoFile allows :</b> create and write into the "destinationpath" file (symptoms = occurency)
 *
 */
public class WriteSymptomIntoFile {
    /**
     * Path of result.out
     * @see WriteSymptomIntoFile#writeSymptoms()
     * @see WriteSymptomIntoFile#WriteSymptomIntoFile(String, TreeMap)
     */
    private String filepath;

    /**
     * TreeMap which is the return of getSymptoms()
     * @see ReadSymptomDataFromFile#getSymptoms()
     * @see WriteSymptomIntoFile#writeSymptoms()
     * @see WriteSymptomIntoFile#WriteSymptomIntoFile(String, TreeMap)
     */
    private TreeMap<String, Integer> map;

    /**
     * Constructor WriteSymptomIntoFile.
     * @param filepath
     * Path of source.out
     * @param map
     * TreeMap which is the return of getSymptoms() method
     */
    public WriteSymptomIntoFile(String filepath, TreeMap<String, Integer> map) {
        this.filepath = filepath;
        this.map = map;
    }
    /**
     * writeSymptoms() method that write (keys = values) of the contructor TreeMap into "destinationpath" file
     *
     */
    public void writeSymptoms() {
        File file = new File(filepath);

        try {
            FileWriter filewriter = new FileWriter(filepath);
            BufferedWriter bw = new BufferedWriter(filewriter);

            for (String key:map.keySet()){
                Integer nombre = map.get(key);
                bw.write(key +"="+nombre);
                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            System.err.println("The file can't be found");
        }


    }

}
