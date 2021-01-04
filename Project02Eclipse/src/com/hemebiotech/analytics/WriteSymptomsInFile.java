package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class WriteSymptomsInFile implements ISymptomWriter {


    private String fileOut;
    /**
     *
     * @param fileOut a full or partial path to file within results will be written.
     */

    public WriteSymptomsInFile (String fileOut)
    {
        this.fileOut= fileOut;
    }
    @Override
    public void writeInFile (TreeMap<String,Integer> symptoms)
    {

        FileWriter writer;
        try {
            writer = new FileWriter (fileOut);	//Create a new file to write results inside.

            while (symptoms.firstEntry() != null)	//Verify the TreeMap is not empty; if it's empty the program ends.
            {
                writer.write(symptoms.firstEntry() + "\n");	//Write the first symptom still in the TreeMap
                //in the file and then go to a new line.
                symptoms.remove(symptoms.firstKey(),symptoms.get(symptoms.firstKey())); //remove symptom already written in file.
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Impossible to create the specified file or to write inside.");
        }
    }




}
