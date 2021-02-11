package HemeBiotech;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AnalyticsCounter {
    static File doc = new File ("C:/Users/solbr/IdeaProjects/P4HemeBiotech/src/HemeBiotech/symptoms.txt");
    static List<String> list = new ArrayList<String>();
    static Map<String, Integer> map = new HashMap<String, Integer>();


    public static void main(String[] args) throws IOException {
        ReadFile.readDoc(doc, list); // Reads and analyzes file.txt
        Count.calculOcc(list, map);  // Counts occurrences
        PrintNewFile.docOut(map);    // Sort in natural order and generates a file
    }
}

