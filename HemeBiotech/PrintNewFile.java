package HemeBiotech;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class PrintNewFile {

    /**
     * Sort in natural order and generates a file with results
     *
     * @param map: Object type Map<String, Integer>
     * parameters String  -> key    = symptomsFile (list of symptoms to read)
     *
     * @throws IOException: signal that an I/O exception of some sort has occurred
     */

    static void docOut(Map<String, Integer> map) throws IOException {
        Map<String, Integer> newmap = new TreeMap<String, Integer>(map); // sort map in natural order in the TreeMap

        File doc2 = new File("results.out.txt"); // String variable containing the file path to generate

        BufferedWriter writOut = null;
        try {
            writOut = new BufferedWriter(new FileWriter(doc2));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        for (Entry<String, Integer> entry : newmap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            writOut.write(key + " = " + value + System.getProperty("line.separator"));
        }

        System.out.println("New File create : " + doc2);
        System.out.println("File location: " + doc2.getAbsolutePath());

        writOut.flush();
        writOut.close();
    }
}
