package com.hemebiotech.analytics;

/** 
 * Anything that will write symptom data on a source
 * The important part is, the operation get symptom data from a Map,
 * sort in alphabetic order
 * 
 */
public interface ISymptomWriter {
    /** 
     * Write an oredered Map of every symptom with his count, on the source's file,
     * without any duplicate 
     */
    void writeSymptoms ();

}
