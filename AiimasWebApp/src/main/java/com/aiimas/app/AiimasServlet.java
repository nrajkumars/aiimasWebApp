package com.aiimas.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AiimasServlet
 */
@WebServlet("/AiimasServlet")
public class AiimasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AiimasServlet() {
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String diplomaCode = request.getParameter("diplomaCode");
				String diplomaName = request.getParameter("diplomaName");
				String prCode = request.getParameter("prCode");
				String prNo = request.getParameter("prNo");
				
				System.out.println("RRRR -  DipplomCode -- "+diplomaCode+"/"+diplomaName);
				
				System.out.println("RRRR -  PR --  "+prCode+":"+prNo);
				
				System.out.println("RRRR -  CAlling DB method");
				
				connectPostgreSQL();
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
