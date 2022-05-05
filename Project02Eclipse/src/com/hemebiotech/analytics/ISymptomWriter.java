package com.hemebiotech.analytics;

/** 
 * Anything that will write symptom data on a source
 * The important part is, the operation get symptom data from a LinkedHashMap,
 * in sort order
 */
public interface ISymptomWriter {
    
    void writeSymptoms ();

}
