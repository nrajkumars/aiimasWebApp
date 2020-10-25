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
	
//	//for PROD
//	
//	private static Connection getConnection()  throws Exception {
//	  //  if (System.getProperty("RDS_HOSTNAME") != null) {
//	    	  
//	    	System.out.println("INSIDE DB connection -------------");
//	      Class.forName("org.postgresql.Driver");
//	      String dbName = System.getProperty("RDS_DB_NAME");
//	      String userName = System.getProperty("RDS_USERNAME");
//	      String password = System.getProperty("RDS_PASSWORD");
//	      String hostname = System.getProperty("RDS_HOSTNAME");
//	      String port = System.getProperty("RDS_PORT");
//	      String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
//	      
//	      System.out.println("INSIDE DB connection --------jdbcUrl-----"+jdbcUrl);
//	     // logger.trace("Getting remote connection with connection string from environment variables.");
//	      Connection con = DriverManager.getConnection(jdbcUrl);
//	    //  logger.info("Remote connection successful.");
//	      
//	      System.out.println("connection successful");
//	      return con;
//	  
//	  }
	
	

	protected Connection getConnection() throws Exception {
		Connection conn = null;
		
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup( "java:/comp/env/jdbc/aiimas" );
			conn = ds.getConnection();
		
		return conn;
	}
	protected void executeUpdate(String sql, Object[] args) throws Exception {
		Connection conn = null;

		try {
			conn = getConnection();

			PreparedStatement ps = conn.prepareStatement(sql);
			//System.out.println(" exute - "+sql);
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
			//System.out.println("updated : " + cnt + " records"+sql);
		} finally {
			if (conn != null) {
					conn.close();
			}
		}
	}
	protected List executeFetchSql(String sql) throws Exception {
		return executeFetchSql(sql, null);
	}
	
	protected List executeFetchSql(String sql, Object[] args) throws Exception {
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
		} finally {
			if (conn != null) {
					conn.close();
			}
		}
		return al;
	}

	
}
