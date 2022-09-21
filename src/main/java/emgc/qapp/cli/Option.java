package emgc.qapp.cli;

public class Option {
    private final char shortName;
    private final String paramName;
    private final boolean hasParameter;
    private final boolean mandatory;
    private final String description;

    public Option(final char shortName, final String paramName, final boolean hasParameter, final boolean mandatory,
	    final String description) {
	super();
	this.shortName = shortName;
	this.paramName = paramName;
	this.hasParameter = hasParameter;
	this.mandatory = mandatory;
	this.description = description;
    }

    public char getShortName() {
	return shortName;
    }

    public String getParamName() {
	return paramName;
    }

    public boolean isHasParameter() {
	return hasParameter;
    }

    public boolean isMandatory() {
	return mandatory;
    }

    public String getDescription() {
	return description;
    }

}
