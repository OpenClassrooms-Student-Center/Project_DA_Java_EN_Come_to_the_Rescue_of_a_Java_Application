package com.hemebiotech.analytics;

import com.hemebiotech.helpers.interfaceHelpers.ISymptomWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WriteSymptomOccurenceInFile implements ISymptomWriter {

    private String filename;
    
    public WriteSymptomOccurenceInFile(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> data) {

        try {
            FileWriter writer = new FileWriter(filename);
//            data.entrySet().stream().map(x->x.getKey() + " => " +x.getValue()).forEach(writer::write);
            Set s = data.entrySet();
            Iterator it = s.iterator();
            while ( it.hasNext() ) {
                Map.Entry entry = (Map.Entry) it.next();
                String key = (String) entry.getKey();
                int value = (Integer) entry.getValue();
                writer.write(key + " => " + value + "\n");
            }//while
            writer.close();
            System.out.println("Le fichier a été traité avec succès. \n Veuillez vous ouvrir le fichier \"result.out\" pour voir les symptomes par occurence. \n Merci");
            System.out.println("=======================================================\n\n\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
