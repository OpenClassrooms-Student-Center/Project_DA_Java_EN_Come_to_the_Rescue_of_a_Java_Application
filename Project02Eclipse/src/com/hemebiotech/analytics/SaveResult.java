package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;

import java.util.*;


public class SaveResult implements ISaveResult {


    private TreeMap<String, Integer> result;

    SaveResult(TreeMap<String, Integer> result)
    {
        this.result =result;
    }

    /**
     *
     * @param : saveresult is a map of string that write on a file the symptoms and the occurences.
     */
    @Override
    public void saveResult() {


        try{
            FileWriter writer = new FileWriter("result.out");
            Set<String> keys = result.keySet(); //list of key
            for(String key: keys){
                writer.write(key + ":" + result.get(key) + "\n");
            }
            writer.close();


        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
