package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * <b>WriteSymptomIntoFile allows :</b> create a new file results.out, write into the file symptoms = occurency.
 *
 */
public class WriteSymptomIntoFile {
    /**
     * Path of source.out
     * @see WriteSymptomIntoFile#writeSymptoms()
     * @see WriteSymptomIntoFile#WriteSymptomIntoFile(String, TreeMap)
     */
    private String filepath;

    /**
     * TreeMap which is the return of getSymptoms() and will be the argument of writeSymptoms()
     * @see ReadSymptomDataFromFile#getSymptoms()
     * @see WriteSymptomIntoFile#writeSymptoms()
     * @see WriteSymptomIntoFile#WriteSymptomIntoFile(String, TreeMap)
     */
    private TreeMap<String, int[]> map;

    /**
     * Constructor WriteSymptomIntoFile.
      * @param filepath
     * Path of source.out
     * @param map
     * TreeMap written into source.out
     */
    public WriteSymptomIntoFile(String filepath, TreeMap<String, int[]> map) {
        this.filepath = filepath;
        this.map = map;
    }
    /**
     * writeSymptoms() method that write keys and values of the TreeMap into source.out file.
     *
     * <ul>
     *     <li>create a file source.out.</li>
     *     <li>Write each key with its value into the file thanks to a bufferedWriter.</li>
     *
     * </ul>
     *
     * Catch two Exceptions.
     *  <ul>
     *        <li>the file can't be created</li>
     *        <li>the file was created but it can't be found</li>
     *
     *   </ul>
     */
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
                System.err.println("The file can't be found");
            }

        }
    }

}
