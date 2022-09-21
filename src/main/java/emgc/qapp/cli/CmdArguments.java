package emgc.qapp.cli;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import emgc.qapp.Application;

public class CmdArguments {
    private final List<Option> options;
    private final List<String> params;
    private final Application app;

    public CmdArguments(final Application app) {
	this.app = app;
	options = new ArrayList<>();
	params = new ArrayList<>();
    }

    public String getUsage() {
	final StringBuilder usage = new StringBuilder("USAGE: ");
	usage.append(app.getClass().getSimpleName());
	if (!options.isEmpty()) {
	    usage.append(" [options] ");
	}
	for (final String param : params) {
	    usage.append(' ');
	    usage.append(param);
	    usage.append(' ');
	}

	usage.append(System.lineSeparator());
	usage.append(System.lineSeparator());
	for (final Option option : options) {
	    usage.append('-');
	    usage.append(option.getShortName());
	    usage.append(", --");
	    usage.append(option.getParamName());
	    usage.append(" : ");
	    usage.append("\t\t");
	    usage.append(option.getDescription());
	}
	return usage.toString();
    }

    public void addOption(final char shortName, final String paramName, final boolean hasParameter,
	    final boolean mandatory, final String description) {
	final Option option = new Option(shortName, paramName, hasParameter, mandatory, description);
	options.add(option);
    }

    public void parse() throws ParseException {
	// TODO
    }

}
