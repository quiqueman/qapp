/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package emgc.qapp;

public class AppRunner {

    public static void run(final Application app, final String[] args) {
	app.initLog();
	app.declareCmdArgs();
	app.loadProperties();
	app.run();
    }
}
