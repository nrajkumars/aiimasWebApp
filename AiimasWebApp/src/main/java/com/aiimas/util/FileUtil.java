package com.aiimas.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

public class FileUtil {
	static Map<String, FileUtil> instances = new HashMap<String,FileUtil>();
	
	String fileName = null;
	
	List<String[]> res = new ArrayList<String[]>();

	BufferedWriter br = null;
	boolean firstLine = true;
	private FileUtil(String fileName) {
		this.fileName = fileName;
	}
	
	public void close() throws Exception {
		if (br != null) {
			br.close();		
		}
	}
	public void writeAll(List<String[]> data) throws Exception {
		Iterator<String[]> iter = data.iterator();
		
		while (iter.hasNext()) {
			if (firstLine) {
				write(iter.next());
				firstLine = false;
			} else {
				newLine();
				write(iter.next());
			}
			
			
		}
	}
	public void newLine() throws Exception {
		br.newLine();
		br.flush();
	}
	public void write(String[] data) throws Exception {
		
		for (int j=0;j<data.length;j++) {
			if (j != 0) {
				br.write(",");				
			}
			if (data[j].indexOf(',') == -1) {
				br.write(data[j]);
			} else {
				br.write("\"" + data[j] + "\"");
			}
		}
		
	}

	public static FileUtil toCSV(String fileName) throws Exception {
		FileUtil fu = instances.get(fileName);
		
		if (fu == null) {
			fu = new FileUtil(fileName);
			instances.put(fileName, fu);
		}
		File srcFile = new File(fileName);
		FileWriter fw = new FileWriter(srcFile);
		fu.br = new BufferedWriter(fw);
		
		return fu;
	}

	public static FileUtil asCSV(String fileName) throws Exception {
		FileUtil fu = instances.get(fileName);
		
		if (fu == null) {
			fu = new FileUtil(fileName);
			instances.put(fileName, fu);
		}
		fu.res.clear();
		File srcFile = new File(fileName);		
		FileReader fr = new FileReader(srcFile);
		BufferedReader br =new BufferedReader(fr);
		String line = br.readLine();
		while (line != null) {
			StringReader sr = new StringReader(line);
			CSVReader reader = new CSVReader(sr, ',');
			String data[] = reader.readNext();
			if (data != null) {
				fu.res.add(data);
			}
			reader.close();
			line = br.readLine();
		}
		br.close();
		fr.close();
		return fu;
	}
	public List<String[]> get() {
		return res;
	}
	public List<String> column(int index) {
		List<String> al  = new ArrayList<String>();
		
		Iterator<String[]> iter = res.iterator();
		while (iter.hasNext()) {
			String[] each = iter.next();
			if (index < each.length ) {
				al.add(each[index]);
			} else {
				al.add("");
			}
		}
		return al;
	}
	public Map<String, List<String[]>> mapByColumn(int index) {
		Iterator<String[]> iter = res.iterator();
		Map<String, List<String[]>> hm = new HashMap<String, List<String[]>>();
		while (iter.hasNext()) {
			String[] each = iter.next();
			if (index < each.length ) {
				if (each[index].trim().length() > 0) {
					if (hm.get(each[index]) != null) {
						List<String[]> al = hm.get(each[index]);
						al.add(each);
					} else {
						List<String[]> al = new ArrayList<String[]>();
						al.add(each);
						hm.put(each[index], al);						
					}
				}
			}
		}
		return hm;
	}
}
