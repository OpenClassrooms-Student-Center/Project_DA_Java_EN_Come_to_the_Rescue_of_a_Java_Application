/**

 * ISymptomWriter Interface
 *
 *
 * @version: 0.4 2024-01-29
 * @author: Pablo Miranda
 */
package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
    /**
     * The requirement of the Interface to write symptoms is a Map<String, Integer>.
     * The implementation is deployed in WriteSymptomDataFile
     */

    void writeSymptoms (Map<String, Integer> symptoms);
}

