package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Symptom {



   public static void main(String[] args) throws Exception{
        // read the file
     AnalyticCounter counter= new AnalyticCounter("C:\\Users\\sadok\\IdeaProjects\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\output");
     counter.read();
     counter.count();
     counter.write();




   }

}
