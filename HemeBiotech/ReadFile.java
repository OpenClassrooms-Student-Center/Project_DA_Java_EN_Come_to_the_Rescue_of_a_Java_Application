package HemeBiotech;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class ReadFile {

    /**
     * @param doc -> Contains the file to read
     * @param list-> ArrayList contains the file to be read line per line
     */


    public static void readDoc(File doc, List<String> list) {
        if(doc != null) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(doc));

                String line = null;
                while ((line = br.readLine()) != null) {
                    list.add(line);
                }
                br.close();
            }
            catch (IOException e) {
                System.err.println("Can't read the file"); // error message
            }
        }
        System.out.println(doc + " : reading ok");
    }
}
