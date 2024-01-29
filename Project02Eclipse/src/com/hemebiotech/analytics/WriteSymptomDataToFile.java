/**

 * ISymptomWriter Implementation of the interface ISymptomWriter
 * The method requires "filepath" to be passed as an argument.
 *
 * @version: 0.4 2024-01-29
 * @author: Pablo Miranda
 */

package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


// Class implements the interface ISymptomWriter
public class WriteSymptomDataToFile implements ISymptomWriter {
    private String filepath;

    //Constructor initialises the path to the file to write
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     *
     * Method writes the file result.out passed in the argument, appending symptoms sorted alphabetically before.
     * If the file report file exists, it's overwritten, if not is created.
     * Method writes the symptom "disease: frequency" into the file.
     *
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try {
            FileWriter writer = new FileWriter(filepath, false);
            writer.write((symptoms.toString().replace("{","").replace("}","").replace(", ","\n").replace("=",":"))); // conversion of map to String, cleanses & formats the output
            writer.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred");
            e.getStackTrace();
            System.exit(1);
        }
        }
}


