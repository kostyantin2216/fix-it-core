package com.fixit.core.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FILog {
	
	private final static Logger DEFAULT_LOGGER = Logger.getLogger("FIX IT");
	
	public static void i(String msg) {
		log(null, Level.INFO, msg, null, false);
	}
	
	public static void i(String tag, String msg) {
		log(tag, Level.INFO, msg, null, false);
	}
	
	public static void w(String msg) {
		log(null, Level.WARNING, msg, null, false);
	}
	
	public static void w(String tag, String msg) {
		log(tag, Level.WARNING, msg, null, false);
	}
	
	public static void w(String tag, String msg, boolean storeInDb) {
		log(tag, Level.WARNING, msg, null, storeInDb);
	}
	
	public static void e(String msg) {
		log(null, Level.SEVERE, msg, null, false);
	}
	
	public static void e(String tag, String msg) {
		log(tag, Level.SEVERE, msg, null, false);
	}
	
	public static void e(String msg, Throwable throwable) {
		log(null, Level.SEVERE, msg, throwable, false);
	}

	public static void e(String tag, String msg, Throwable t) {
		log(tag, Level.SEVERE, msg, t, false);
	}
	
	public static void e(String tag, String msg, Throwable t, boolean storeInDb) {
		log(tag, Level.SEVERE, msg, t, storeInDb);
	}
	
	private static void log(String tag, Level level, String msg, Throwable throwable, boolean storeInDb) {
		Logger logger;
		if(tag != null) {
			logger = Logger.getLogger(tag);
		} else {
			logger = FILog.DEFAULT_LOGGER;
		}
		
		logger.log(level, msg, throwable);		
		
		if(storeInDb) {
			/*ServerLogDao logDao = CoreContextProvider.getServerLogDao();
			
			String stackTrace = null;
			if(throwable != null) {
				StringWriter sw = new StringWriter();
				throwable.printStackTrace(new PrintWriter(sw));
				stackTrace = sw.toString();
			}
			
			logDao.save(ServerLog.createLog(tag, level.getName(), msg, stackTrace));*/
		}
	}

}
