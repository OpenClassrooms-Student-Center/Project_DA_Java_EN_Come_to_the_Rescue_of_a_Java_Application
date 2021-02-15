package HemeBiotech;

import java.util.List;
import java.util.Map;

public class Count {
    /**
     * Count occurrence
     *
     * @param list -> ArrayList contains each line to read
     * @param map -> Object type Map<String, Integer>
     *
     */

    static void calculOcc (List<String> list, Map<String, Integer> map) {
        for (String symptomsFile : list) {
            Integer occurrences = map.get(symptomsFile);
            if (occurrences == null) {
                map.put(symptomsFile, 1);
            }
            else {
                map.put(symptomsFile, occurrences+1);
            }
        }
        System.out.println("Analysis is ok");
    }

}
