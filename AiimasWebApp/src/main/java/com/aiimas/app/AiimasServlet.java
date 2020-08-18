package com.aiimas.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.aiimas.util.PDFGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AiimasServlet
 */
@WebServlet("/rs")
public class AiimasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AiimasServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//app=Aiimas&module=Search&action=searchByPrCodePrNo&prNo=123&prCode=ABC123
		
		String app = request.getParameter("app");
		String mod = request.getParameter("module");
		String act = request.getParameter("action");
		String prn = request.getParameter("prNo");
		String prc = request.getParameter("prCode");
		
		System.out.println(app + "," + mod +"," + act + "," + prn + "," + prc);
		
		ObjectMapper om = new ObjectMapper();
		
		Map retval  =new HashMap();
		
		retval.put("app",app + " retval");
		
		String res = om.writeValueAsString(retval);
		
		response.getWriter().write(res);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String app = request.getParameter("app");
		String mod = request.getParameter("module");
		String act = request.getParameter("action");
		String prn = request.getParameter("prNo");
		String prc = request.getParameter("prCode");
		
		System.out.println(app + "," + mod +"," + act + "," + prn + "," + prc);		
		
		ObjectMapper om = new ObjectMapper();
		
		Map retval  =new HashMap();
		
		retval.put("app",app + " retval");
		
		String res = om.writeValueAsString(retval);
		
		response.getWriter().write(res);
	}
	
	private void connectPostgreSQL() {
		
		System.out.println("RRRR -  insdie  -- connectPostgreSQL");
		
		try {
			InitialContext cxt = new InitialContext();
	
			System.out.println("RRRR -  insdie  -- connectPostgreSQL : InitialContext -"+cxt);
		
			DataSource ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/postgres" );
	
			if ( ds == null ) {
			   throw new Exception("Data source not found!");
			}
		
			System.out.println("RRRR -  insdie  -- connectPostgreSQL : DataSource -"+ds);
			
			Connection conn = ds.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement("select * from  AIIMASTESTTABLE;");
	
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			System.out.println("Execution: "+rs.getString(2));
			rs.close();
		
			pstmt.close();
			conn.close();
						
		}catch( Exception ex) {
			System.out.println("RRRR -  insdie  -- connectPostgreSQL  EXCEPTION "+ex);
		}
		
	}

}
