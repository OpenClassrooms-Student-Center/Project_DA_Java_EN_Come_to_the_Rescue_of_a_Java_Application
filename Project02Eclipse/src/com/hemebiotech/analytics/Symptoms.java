package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;

public class Symptoms {
    String name = "";
    int occurences = 0;
    
   public Symptoms(String name, ArrayList<String> rawlist){
        this.name = name;
        this.occurences = Collections.frequency(rawlist, name);

    }
    public String GetName()
    {
        return this.name;
    }

    public int GetOccurences()
    {
        return this.occurences;
    }
}