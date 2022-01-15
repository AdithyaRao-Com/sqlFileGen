package com.infosys.sqlFileGen.wrapper;

import java.io.File;
import java.io.FilenameFilter;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import com.infosys.sqlFileGen.classes.SqlFileGenLogger;


import com.infosys.sqlFileGen.classes.SQLFileGen;

public class ExcelSQLWrapper {
	private static String currentWorkingDirectoryStr;
	private static Logger excelSQLFileLogger = Logger.getLogger("SQLFileGen");
//*****************************************************************************
// Main Wrapper to call the excel SQL Extract functionality
//*****************************************************************************
	public static void main(String[] args) throws Exception {
		currentWorkingDirectoryStr = getCurrentWorkingDirectory();
		File currentWorkingDirectory = new File(currentWorkingDirectoryStr);
		SqlFileGenLogger.setLog(currentWorkingDirectory);
		excelSQLFileLogger = SqlFileGenLogger.getLogger();
		// Create a file filter to filter xlsx files only
		FilenameFilter xlsxFileFilter = new FilenameFilter() {
			private final String FILE_EXTENSION=".xlsx";
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(FILE_EXTENSION);
			}
		};
		// Loop through the XLSX files
		for(File innerFile:currentWorkingDirectory.listFiles(xlsxFileFilter)) {
			try {
				excelSQLFileLogger.fine("The file bein processed is "+innerFile.toString());
				SQLFileGen fileGenerator =new SQLFileGen(innerFile);
				fileGenerator.writeSQL();
			}
			catch (Exception e) {
				// TODO: handle exception
				throw new Exception("Unable to create the SQL File",e);
			}
		}
	}
//*****************************************************************************
// Get the current working directory
//*****************************************************************************
	public static String  getCurrentWorkingDirectory() {
//		String localDirectory = System.getProperty("user.dir");
		String localDirectory = "D:\\DetailsTest";
		return localDirectory;	
	}
}
