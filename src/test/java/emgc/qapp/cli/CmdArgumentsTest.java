package emgc.qapp.cli;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import emgc.qapp.DummyApp;

class CmdArgumentsTest {

    @Test
    void testGetUsage() {
	final CmdArguments rut = new CmdArguments(new DummyApp());
	rut.addOption('d', "debug", false, false, "Log in debug mode");

	final String expected = "USAGE: DummyApp [options] " + System.lineSeparator() + System.lineSeparator()
		+ "-d, --debug : \t\tLog in debug mode";
	assertEquals(expected, rut.getUsage());
    }

}
