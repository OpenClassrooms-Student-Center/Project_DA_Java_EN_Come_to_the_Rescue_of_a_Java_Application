package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public interface Caster {
	public List<String> CastToList(Map<String, Integer> symptomCount);

}