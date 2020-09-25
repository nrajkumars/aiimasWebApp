package com.aiimas.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
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
	
	//AiimasServlet aiimasServlet = new AiimasServlet();

//	private void writeResponse(Object mdata, HttpServletResponse response) {
//		try {
//			ObjectMapper om = new ObjectMapper();
//
//			byte buf[] = om.writeValueAsString(mdata).getBytes();
//			System.out.println("Response json : " + new String(buf));
//			response.setContentLength(buf.length);
//			response.setContentType("application/json");
//			response.getOutputStream().write(buf);
//			response.getOutputStream().close();
//			
//		} catch (Exception e) {
//			// ignore
//			e.printStackTrace();
//		}
//
//	}
	
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
				
				
				ObjectMapper om = new ObjectMapper();
				
				Map responseMap  =new HashMap();
				
				responseMap.put("app",app + "responseMap");
				
				String res = om.writeValueAsString(responseMap);
				
				resp.getWriter().write(res);
				
				
				//byte[] buf = (byte[]) download.get(fileName);
				//resp.setContentLength(buf.length);
				//resp.setContentType("application/octet-stream");
		       // resp.setHeader("Content-disposition","attachment; filename=" + fileName);
				//resp.getOutputStream().write(buf);
				//resp.getOutputStream().close();
			}
		//	writeResponse(response, resp);
			
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
		
		
		// connect to db
		//String sqlqry = "";
		//BaseDao basedao = new BaseDao();
		//basedao.executeFetchSql(sqlqry);
		
//		System.out.println(" SQL Query exeuted success");
//		
//		ObjectMapper om = new ObjectMapper();
//		
//		Map retval  =new HashMap();
//		
//		retval.put("app",app + " retval");
//		
//		String res = om.writeValueAsString(retval);
//		
//		response.getWriter().write(res);
	}
	
	
	


}
