/**

 * ISymptomWriter Implementation of the interface ISymptomWriter
 * The method requires "filepath" to be passed as an argument.
 *
 * @version: 0.3 2024-01-26
 * @author: Pablo Miranda
 */

package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;


// Class implements the interface ISymptomWriter
public class WriteSymptomDataToFile implements ISymptomWriter {
    /**
     * Method writes the symptom "disease: frequency" into the file
     *
     * @return void
     */
    private String filepath;

    //Constructor initialises the path to the file to write
    public WriteSymptomDataToFile(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        /*
          Method writes the file result.out appending lines
         */
        try {
            //TODO - new file once the process starts
            FileWriter writer = new FileWriter(filepath, true); // appending is activated
            writer.write(symptoms.toString()); // conversion of map to String
            writer.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred");
            e.getStackTrace();
            System.exit(1);
        }
        }
}


