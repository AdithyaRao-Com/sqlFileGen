package com.infosys.sqlFileGen.wrapper;

import java.io.File;
import java.io.FilenameFilter;
import com.infosys.sqlFileGen.classes.SQLFileGen;

public class ExcelSQLWrapper {
	private static String currentWorkingDirectoryStr;
//*****************************************************************************
// Main Wrapper to call the excel SQL Extract functionality
//*****************************************************************************
	public static void main(String[] args) throws Exception {
		currentWorkingDirectoryStr = getCurrentWorkingDirectory();
		File currentWorkingDirectory = new File(currentWorkingDirectoryStr);
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
		return System.getProperty("user.dir");	
	}
}
