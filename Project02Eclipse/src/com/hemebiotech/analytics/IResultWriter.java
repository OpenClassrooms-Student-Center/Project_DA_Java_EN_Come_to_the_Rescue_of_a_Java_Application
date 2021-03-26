package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IResultWriter {
	void WriteResult(Map<String, Integer> result) throws IOException;

}
