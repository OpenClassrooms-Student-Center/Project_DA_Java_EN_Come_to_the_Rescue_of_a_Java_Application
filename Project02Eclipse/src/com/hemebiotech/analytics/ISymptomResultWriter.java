package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;


public interface ISymptomResultWriter {
    /**
     *
     * @param listSymptomsClean
     * @throws IOException
     */
    void WriteSymptoms(Hashtable<String, Integer> listSymptomsClean) throws IOException;
}
