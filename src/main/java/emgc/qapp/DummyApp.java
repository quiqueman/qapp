package emgc.qapp;

import emgc.qapp.cli.CmdArguments;
import emgc.qapp.log.Log;

public class DummyApp extends Application {

    @Override
    protected void declareCmdArgs() {
	final CmdArguments args = getCmdArguments();
	args.addOption('d', "debug", false, false, "Log in debug mode");
    }

    @Override
    protected void run() {
	Log.getLogger(this).info(getCmdArguments().getUsage());
    }

    public static void main(final String[] args) {
	AppRunner.run(new DummyApp(), args);
    }
}
