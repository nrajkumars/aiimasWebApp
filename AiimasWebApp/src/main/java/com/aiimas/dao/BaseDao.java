package com.aiimas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BaseDao {

	protected Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:comp/env");
			DataSource ds = (DataSource) env.lookup("jdbc/aiimas");
			conn = ds.getConnection();
			System.out.println("Db conn from DS");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (conn == null) {
			Class.forName("org.postgresql.Driver");
			//conn = DriverManager.getConnection("jdbc:postgresql://aaobv2wbop5w0m.c8qevwrrmwp6.ap-south-1.rds.amazonaws.com:5432/postgres", "aiimasdb","");
			conn = DriverManager.getConnection("jdbc:postgresql://10.139.159.109:5432/crods","postgres","password");
			System.out.println("Db conn direct");
		}
		return conn;
	}
	protected void executeUpdate(String sql, Object[] args) {
		Connection conn = null;

		try {
			conn = getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);
			if (args != null) {
				int i=1;
				for (Object each : args) {
					if (each instanceof Date) {
						java.sql.Date sqlDate = new java.sql.Date(((Date) each).getTime());
						ps.setDate(i++, (java.sql.Date) sqlDate);
					} else {
						ps.setObject(i++, each);
					}
				}
			}
			int cnt = ps.executeUpdate();
			System.out.println("updated : " + cnt + " records");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	protected List executeFetchSql(String sql) {
		return executeFetchSql(sql, null);
	}
	protected List executeFetchSql(String sql, Object[] args) {
		Connection conn = null;
		List al = new ArrayList();
		try {
			conn = getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);
			if (args != null) {
				int i=1;
				for (Object each : args) {
					ps.setObject(i++, each);
				}
			}
			ResultSet rs = ps.executeQuery();

			int ccount = rs.getMetaData().getColumnCount();
			String columns[] = new String[ccount];
			for (int i = 1; i <= ccount; i++) {
				columns[i - 1] = rs.getMetaData().getColumnName(i);
			}
			while (rs.next()) {
				Map data = new HashMap();
				for (int i = 1; i <= ccount; i++) {

					Object value = rs.getObject(i);
					data.put(columns[i - 1], value);
				}
				al.add(data);
				//System.out.println(data);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return al;
	}

	
}
