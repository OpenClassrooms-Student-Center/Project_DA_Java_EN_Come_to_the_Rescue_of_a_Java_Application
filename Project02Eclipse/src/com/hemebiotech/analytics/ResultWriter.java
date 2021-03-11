package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;

public interface ResultWriter {
	void WriteResult(List<String> result) throws IOException;

}
