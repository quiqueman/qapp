package emgc.qapp.report;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

import emgc.qapp.log.Log;

public class CSVWriter {
    private static final char SEPARATOR = ';';
    private final String filePath;
    private final char separator;
    private final boolean timestamp;

    public CSVWriter(final String filePath) {
	this.filePath = filePath;
	separator = SEPARATOR;
	timestamp = false;
    }

    public void write(final List<List<?>> result) throws IOException {
	Log.getLogger(this).log(Level.INFO, "Escribiendo fichero : {0}", filePath);
	try (FileWriter output = new FileWriter(filePath)) {
	    if (result.size() > 1) {
		writeLine(output, result.get(0));
	    }

	    for (int i = 2; i < result.size(); i++) {
		writeLine(output, result.get(i));
	    }
	}
	Log.getLogger(this).log(Level.INFO, "Fichero escrito fichero : {0}", filePath);
    }

    private void writeLine(final FileWriter output, final List<?> list) throws IOException {
	for (final Object field : list) {
	    output.write(field.toString());
	    output.write(separator);
	}
	output.write(System.lineSeparator());
    }

}