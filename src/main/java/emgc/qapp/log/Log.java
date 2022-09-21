package emgc.qapp.log;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import emgc.qapp.Application;

/**
 * The Class Log.
 */
public class Log {

    /** The loggers. */
    private static final Map<String, Logger> loggers = new HashMap<>();

    /**
     * Gets the logger.
     *
     * @param clazz the clazz
     * @return the logger
     */
    public static Logger getLogger(final Object clazz) {
	synchronized (loggers) {
	    final String key = clazz.toString();
	    Logger logger = loggers.get(key);
	    if (logger == null) {
		logger = Logger.getLogger(key);
		loggers.put(key, logger);
	    }
	    return logger;
	}
    }

    /**
     * Inits the.
     *
     * @param app the app
     */
    public void init(final Application app) {
	final String logPropertiesFile = getLogConfigFile(app);
	try {
	    LogManager.getLogManager().readConfiguration(new FileInputStream(logPropertiesFile));
	} catch (SecurityException | IOException e) {
	    config(this, "Can't read configuration from '" + logPropertiesFile + "'");
	}
    }

    /**
     * Config.
     *
     * @param clazz the clazz
     * @param msg   the msg
     */
    private void config(final Object clazz, final String msg) {
	final Logger logger = getLogger(clazz);

	logger.config(msg);
    }

    /**
     * Gets the log config file.
     *
     * @param app the app
     * @return the log config file
     */
    private String getLogConfigFile(final Application app) {
	final StringBuilder sb = new StringBuilder(app.getClass().getSimpleName());
	sb.append(".logging.properties");
	return sb.toString();
    }
}
