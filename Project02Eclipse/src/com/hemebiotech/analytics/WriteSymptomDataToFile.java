package com.hemebiotech.analytics;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Map;

/**
 * The WriteSymptomDataToFile class implements the ISymptomWriter interface
 * to write symptom data and their counts to a file.
 *
 * Usage:
 * - Create an instance of WriteSymptomDataToFile.
 * - Call the writeSymptoms method, providing a map of symptom counts and the output file path as parameters.
 * - The method writes the symptom data to the specified output file.
 *
 * @author Mauricio Lopez
 * @version 1.0
 * @see ISymptomWriter
 */

public class WriteSymptomDataToFile implements ISymptomWriter {
    /**
     * Writes symptom data and their counts to a specified output file.
     *
     * @param symptomCount   A map containing symptom data and their corresponding counts.
     * @param outputFilePath The path to the output file where data will be written.
     * @see ISymptomWriter#writeSymptoms(Map, String)
     */
    @Override
	public void writeSymptoms(Map<String,Integer>symptomCount,String outputFilePath) {
        
        try (FileWriter writer=new FileWriter(outputFilePath)){
            // Iterate through the entries in the symptomCount map.
            for (Map.Entry<String,Integer> entry: symptomCount.entrySet()){
                // Write each entry as "symptom:count" followed by a newline.
                writer.write(entry.getKey()+':'+entry.getValue()+'\n');

            }
        }catch(IOException e){
            // Handle exceptions and print error message
            System.err.println("error"+e.getMessage());
        }
	}

}
