package com.infosys.sqlFileGen.classes;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SqlFileGenLogger {
	private static Logger sqlFileGenLog = Logger.getLogger(SqlFileGenLogger.class.getName());
	public static void setLog(File directory)  throws IOException {
		File logFile = new File(directory,SqlFileGenLogger.class.getName()+".log");
		FileHandler logFileHandler = new FileHandler(logFile.toString());
		Formatter logFileFormatter = new SimpleFormatter();
		logFileHandler.setFormatter(logFileFormatter);
		sqlFileGenLog.addHandler(logFileHandler);
		sqlFileGenLog.setLevel(Level.FINEST);
	}
	public static Logger getLogger() throws IOException {
		if(sqlFileGenLog != null) {
			return sqlFileGenLog;
		} else {
			setLog(new File(System.getProperty("user.dir")));
			return sqlFileGenLog;
		}
		
	}
}
