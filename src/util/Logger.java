package util;
import java.time.LocalTime;

public final class Logger {
	private static volatile Logger instance = null;
	private static boolean debugEnabled = false;
	private static boolean verboseEnabled = false;

	private Logger() {
	}

	public static Logger getInstance() {
		if (instance == null) {
			synchronized (Logger.class) {
				if (instance == null) {
					instance = new Logger();
				}
			}
		}
		return instance;
	}

	public static void log(String message) {
		if (debugEnabled) {
			System.err.println(
					"[DEBUG] " + LocalTime.now().getHour() + ":" + LocalTime.now().getSecond() + ": " + message);
		}
	}

	public static void logVerbose(String message) {
		if (verboseEnabled) {
			System.err.println(
					"[VERBOSE] " + LocalTime.now().getHour() + ":" + LocalTime.now().getSecond() + ": " + message);
		}
	}

	public void setDebugEnabled(boolean debugEnabled) {
		Logger.debugEnabled = debugEnabled;
	}

	public void setVerboseEnabled(boolean verboseEnabled) {
		Logger.debugEnabled = true;
		Logger.verboseEnabled = verboseEnabled;
	}
}
