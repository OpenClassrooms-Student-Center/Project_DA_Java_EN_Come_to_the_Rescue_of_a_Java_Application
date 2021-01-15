package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DataSymptoms {

    public static void datasymptoms() throws Exception {
        Set<String> setsymptoms = new HashSet<>(symptomslist); // HashSet to delete double.
        ArrayList<String> symptomslist2 = new ArrayList<>(setsymptoms); // List with not double to compare to count.
        String[][] Symptoms = new String[symptomslist2.size()][2];

        for (int i = 0; i < symptomslist2.size(); i++) {
            Collections.sort(symptomslist2);
            String result1 = symptomslist2.get(i);
            int count = 0;
            for (int a = 0; a < symptomslist.size(); a++) {
                String result2 = symptomslist.get(a);
                if (result1.equals(result2)) {
                    count++;
                }
            }
            String strcount = Integer.toString(count);
            Symptoms[i][0] = result1;
            Symptoms[i][1] = strcount;
        }
    }
}
