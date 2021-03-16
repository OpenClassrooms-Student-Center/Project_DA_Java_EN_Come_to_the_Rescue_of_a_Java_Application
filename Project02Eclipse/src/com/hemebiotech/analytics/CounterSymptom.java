package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;

// In this class we have to count symptoms and return a list with "symptoms" = "occurence"
public class CounterSymptom {

    private List<String> list;

    //	entry-parameter : list of strings in alphabetical order
    public CounterSymptom(List<String> list) {

        this.list = list;

    }

    // method that count. We are in alphabetical order so if two symptows appear they are in a row. We just compare
//	2 elements in a row and if they are similar, we increase the count, if not we have a new symptom and we start a new count
//	we create a new String list in which each element is a string define with :"name of symptome" = "occurence"
    public List<String> getCount() {
        List<String> finalist = new ArrayList<>();

        int frequenceSymptom = 1;

        for (int i = 0; i < list.size() - 1; i++) {

            if (list.get(i).equals(list.get(i + 1))) {

//	If we are at the end of the list we have to stop the count and write the last symptom and its frequence into the list
// So we have a small condition that allow to verify that we are at the end of the list

                if (i != list.size() - 2) {
                    frequenceSymptom++;
                } else {
                    frequenceSymptom++;
                    finalist.add(list.get(i) + "=" + frequenceSymptom);
                }
            } else {

                finalist.add(list.get(i) + "=" + frequenceSymptom);
                frequenceSymptom = 1;

            }
        }

        return finalist;

    }

}
