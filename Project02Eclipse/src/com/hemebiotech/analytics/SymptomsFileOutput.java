/**
 * SymptomsFileOutput Class creation as part of OCR Project 4 initiative
 *
 *  Takes a hasmap <String, Integer> as input in the constructor
 *  The method generateFileReport()
 *      - instanciate a filewriter handle
 *      - copies the input Map to a tree map for ordering purposed
 *  Scans the sorted map and writes each key value pair to the output file
 *  Closes the file writer handle
 *
 * @author  Sébastien Vigé
 * @version 2.0
 * @since   2018-12-18
 */

package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class SymptomsFileOutput {

//fields
    Map<String, Integer> inputMap  ;


// Contructor


    public SymptomsFileOutput(Map<String, Integer> inputMap) {
        this.inputMap = inputMap;
    }



    // next generate output

    public void generateFileReport() {

        TreeMap<String, Integer> sorted = new TreeMap<>(inputMap);


        try {
            FileWriter writer = new FileWriter("result.out");


            for (Map.Entry<String, Integer> entry : sorted.entrySet()) {

                String str = entry.getKey() +"="+ entry.getValue()+"\n";


                    writer.write(str);



            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
