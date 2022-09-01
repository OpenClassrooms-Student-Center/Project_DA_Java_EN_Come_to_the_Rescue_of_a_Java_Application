package com.hemebiotech.analytics.service;

import java.util.List;
import java.util.Map;

public interface ISymptomsOperations {

    Map<String, Long> symptomsAndCount(List<String> symptoms);

}
