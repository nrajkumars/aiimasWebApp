package com.aiimas.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.aiimas.dao.MasterTableValues;
import com.aiimas.dao.Verification;
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

	
	
	List diplmaDetails = new ArrayList();

	
	public void init() throws ServletException { 
		
		
		try { 
			
			System.out.println(" RESPONSE insdie -----------***********---------init  ");

			MasterTableValues masterTable = new MasterTableValues();
				
			// Loading master values and save as Global variables

			diplmaDetails = masterTable.getListMasterTable();
			
			System.out.println(" RESPONSE GOT Master table in MAP -- "+diplmaDetails);
					
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	

	private void writeResponse(Object mdata, HttpServletResponse response) {
		try {
			ObjectMapper om = new ObjectMapper();
			
			System.out.println("inside writeResponse ----------------------------");
	
			byte buf[] = om.writeValueAsString(mdata).getBytes();
			System.out.println("Response json : " + new String(buf));
			response.setContentLength(buf.length);
			response.setContentType("application/json");
			response.getOutputStream().write(buf);
			response.getOutputStream().close();
			
		//	System.out.println("inside writeResponse  DONE ------ HERE----------------------"+mdata.toString());
		//	System.out.println("inside writeResponse  DONE ------ HERE----------------------"+response.toString());
			
		} catch (Exception e) {
			// ignore
			e.printStackTrace();
		}

	}
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doPost(req, resp);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("inside aiimas servier");
		
		String app = request.getParameter("app");
		String module = request.getParameter("module");
		String action = request.getParameter("action");
	
		
		System.out.println("inside aiimas servier do post-"+app + "," + module +"," + action);	
		
		//--------------- Action = Logout -------------- //
		
		if ("logout".equals(action)) {
			try {
				request.getSession(true).invalidate();
				resp.sendRedirect("index.html");

				return;
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}
		
		Object response="success";
		
		//--------------- Action = Application AIIMAS  -------------- //
		
		try {
			System.out.println("request :  " + module +"," + action);
			
			//--------------- Action = Application VERIFICATION  -------------- //
			if (module != null && module.equals("verification")) {
		
				System.out.println("Inside module Verification : " + action);
			
												
				String prn = request.getParameter("prNo");
				String prc = request.getParameter("prCode");
				
				System.out.println("Inside module Verification  :: prn : " + prn);
				System.out.println("Inside module Verification  :: prc : " + prc);
				
				Verification verification = new Verification();
				Map input = new HashMap();
				input.put("prNum", prn);
				input.put("prCode", prc);

				//String[] username = (String[])data.get("username");
				//input.put("username", username[0]);
				
				Map verifyedValues = verification.getVerficationDetail1(input);
				
				System.out.println(" RESPONSE GOT in MAP -- "+verifyedValues);
				
				//TODO
				
				writeResponse(verifyedValues, resp);
			}
			
			
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			pw.close();
			sw.close();
			
			response = "Error : " + sw.toString();
			Map ret = new HashMap();
			ret.put("error", "Unable to process request due to technical error");
		//	writeResponse(ret, resp);
		}
		
		
		
	}
	
	public void destroy() {
	      // do nothing.
	   }
	
	
	


}
