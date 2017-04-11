package com.fixit.core.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FILog {
	
	
	
	private final static Logger logger = Logger.getLogger("FIX IT");
	
	public static void i(String msg) {
		log(Level.INFO, msg, null, false);
	}
	
	public static void e(String msg) {
		log(Level.SEVERE, msg, null, false);
	}
	
	public static void e(String msg, Throwable throwable) {
		log(Level.SEVERE, msg, throwable, false);
	}
	
	private static void log(Level level, String msg, Throwable throwable, boolean storeInDb) {
		logger.log(level, msg, throwable);		
	}

}
