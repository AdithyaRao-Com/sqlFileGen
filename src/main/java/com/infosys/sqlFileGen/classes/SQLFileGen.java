package com.infosys.sqlFileGen.classes;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import com.infosys.sqlFileGen.classes.SqlFileGenLogger;

public class SQLFileGen {
	private File xlsxFile;
	private File sqlFile;
	private boolean skipWriteSQLFlag = false;
	private static Logger SQLFileGenLog = Logger.getLogger(SQLFileGen.class.getName());
	public SQLFileGen(File xlsxFile) throws IOException{
		SQLFileGenLog = SqlFileGenLogger.getLogger();
		this.xlsxFile = xlsxFile;
		String sqlFileStr = xlsxFile
				.getName()
				.replaceAll("(?i)"+Pattern.quote(".xlsx"),".sql");
		SQLFileGenLog.fine("sqlFileStr for "+xlsxFile.getName()+" is "+sqlFileStr);
		sqlFile = new File(sqlFileStr);
		if(sqlFile.exists()) {
			SQLFileGenLog.fine("skipWriteSQLFlag is true for "+this.xlsxFile.getName());
			skipWriteSQLFlag = true; 
		} else {
			SQLFileGenLog.fine("skipWriteSQLFlag is false for "+this.xlsxFile.getName());
		}
	}
	public void writeSQL() {
		if(!skipWriteSQLFlag) {
			//TODO Create excel Class
			//TODO Call excel class write method
		}
	}
}
