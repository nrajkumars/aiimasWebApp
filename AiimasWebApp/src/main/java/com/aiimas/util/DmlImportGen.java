package com.aiimas.util;

import java.util.Iterator;
import java.util.List;

import com.aiimas.util.FileUtil;

public class DmlImportGen {

	public static void genAdmin() throws Exception {
		String workFolder = "C:\\aiimas_DB_file";
		String inputCsvFilename = "admin.csv";
		String tableName = "admin";
		String csvColumns = "AD_DIPCODE,AD_PRCODE,AD_PRNO,AD_SESMON,AD_SESYR,AD_NAME,AD_NOFPAPR,AD_REF,AD_FEEDATE,AD_FEEAMT,AD_DURTN,AD_PAIDAMT,AD_ENTDATE,AD_ENTTIME";
		String dbColumns  = "AD_DIPCODE,AD_PRCODE,AD_PRNO,AD_SESMON,AD_SESYR,AD_NAME,AD_NOFPAPR,AD_REF,AD_FEEDATE,AD_FEEAMT,AD_DURTN,AD_PAIDAMT,AD_ENTDATE,AD_ENTTIME";

		String colTypes   = "character,character,character,character,numeric,character,numeric,character,date,numeric,character,numeric,date,time";
		String dbColTypes[] = colTypes.split(",");

		String insert = "insert into " + tableName + "(" + dbColumns + ") values (";
		
		FileUtil fu = FileUtil.asCSV(workFolder + "\\" + inputCsvFilename);
		
		List<String[]> data = fu.get();
		Iterator<String[]> iter = data.iterator();
		
		iter.next(); //skip header
		
		while (iter.hasNext()) {
			
			String[] row = iter.next();
			String insertSQL = null;

			for (int i=0;i<dbColTypes.length; i++) {
				
				if (insertSQL == null) {
					insertSQL = insert;
				} else {
					insertSQL += ",";
				}
				
				String val = row[i];
				final String colType = dbColTypes[i];
				
				switch (colType) {
				
				case "character":
					if (val == null || val.trim().length() == 0) {
						insertSQL += "null";
					} else {
						insertSQL += "'" + val + "'";
					}					
					break;
				case "numeric":
					if (val == null || val.trim().length() == 0) {
						insertSQL += "null";
					} else {
						insertSQL += val;
					}
					break;
				case "date":
					if (val == null || val.trim().length() == 0) {
						insertSQL += "null";
					} else {
						insertSQL += "'" + val + "'";
					}
					break;
				case "time":
					if (val == null || val.trim().length() == 0) {
						insertSQL += "null";
					} else {
						insertSQL += "'" + val + "'";
					}
					break;
				}
				
				
			}
			insertSQL += ")";
			System.out.println(insertSQL);
			
		}
		
	}
	
	public static void main(String args[]) throws Exception {
		genAdmin();
	}
}
