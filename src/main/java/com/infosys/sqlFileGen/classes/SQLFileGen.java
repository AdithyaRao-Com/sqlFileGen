package com.infosys.sqlFileGen.classes;

import java.io.File;
import java.util.regex.Pattern;

public class SQLFileGen {
	private File xlsxFile;
	private File sqlFile;
	private boolean skipWriteSQLFlag = false;
	public SQLFileGen(File xlsxFile){
		this.xlsxFile = xlsxFile;
		String sqlFileStr = xlsxFile
				.getName()
				.replace("(?i)"+Pattern.quote(".xlsx"),".sql");
		sqlFile = new File(sqlFileStr);
		if(sqlFile.exists()) {
			skipWriteSQLFlag = true; 
		}
	}
	public void writeSQL() {
		if(!skipWriteSQLFlag) {
			//TODO Create excel Class
			//TODO Call excel class write method
		}
	}
}
