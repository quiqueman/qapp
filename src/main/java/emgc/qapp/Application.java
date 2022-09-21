package emgc.qapp;

import emgc.qapp.cli.CmdArguments;

public abstract class Application {
    private final CmdArguments cmdArguments = new CmdArguments(this);

    protected abstract void declareCmdArgs();

    protected void loadProperties() {

    }

    protected abstract void run();

    protected void initLog() {

    }

    public CmdArguments getCmdArguments() {
	return cmdArguments;
    }

}
