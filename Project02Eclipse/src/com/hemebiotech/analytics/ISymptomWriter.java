/**

 * ISymptomWriter Interface
 *
 *
 * @version: 0.3 2024-01-26
 * @author: Pablo Miranda
 */
package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {

    void writeSymptoms (Map<String, Integer> symptoms);
}

