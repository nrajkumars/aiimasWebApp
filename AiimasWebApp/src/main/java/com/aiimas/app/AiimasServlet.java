package com.aiimas.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.aiimas.dao.AddAdmission;
import com.aiimas.dao.ExamApplication;
import com.aiimas.dao.Maintenance;
import com.aiimas.dao.MarkUpdate;
import com.aiimas.dao.MasterTableValues;
import com.aiimas.dao.PrintView;
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

@WebServlet(
	    urlPatterns = "/rs",
	    loadOnStartup = 1
	)
public class AiimasServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static List diplmaDetails = new ArrayList();
	Map<String, Object> stateCenterMap = new TreeMap<String, Object>();

	
	public void init() throws ServletException { 
		
		
		try { 
			
		//	System.out.println(" RESPONSE insdie ------***********--- RAJ------init  ");

			MasterTableValues masterTable = new MasterTableValues();
				
			// Loading master values and save as Global variables

			diplmaDetails = masterTable.getListMasterTable();
			
			stateCenterMap = masterTable.getStateCenterMasterTable();
			
			//System.out.println(" RESPONSE GOT Master table in MAP -- "+diplmaDetails);
			
		    if(diplmaDetails!=null){
		    		getServletContext().setAttribute( "diplomaCodeDetails", diplmaDetails );
		    }
		    
		   // System.out.println(" RESPONSE insdie ------***********---------init  loaded diploma code");
		    
		    if(stateCenterMap!=null){
	    		getServletContext().setAttribute( "stateCenterMap", stateCenterMap );
	    		 System.out.println(" RESPONSE insdie ------***********---------init  loaded STATE and CENTER "+stateCenterMap.toString());
		    }
		    
		   
					
			} catch (Exception e) {
				
				System.out.println(" ERROR in SERVLET INIT method: "+e.toString());
				
			}
		}
	

	private void writeResponse(Object mdata, HttpServletResponse response) {
		try {
			ObjectMapper om = new ObjectMapper();
			
			if (mdata instanceof Map) {
				Map m = (Map) mdata;
				String pdfFileName = (String) m.get("Filename");
				if (pdfFileName != null && pdfFileName.endsWith("pdf")) {

					File pdfFile = new File(pdfFileName);

					response.setContentType("application/pdf");
					response.setContentLength((int) pdfFile.length());

					FileInputStream fileInputStream = new FileInputStream(pdfFile);
					OutputStream responseOutputStream = response.getOutputStream();
					int bytes;
					while ((bytes = fileInputStream.read()) != -1) {
						responseOutputStream.write(bytes);
					}
					fileInputStream.close();
					responseOutputStream.flush();
					responseOutputStream.close();
					//System.out.println("PDF data written to output stream:" +pdfFile.length());
					return;
				}
			}
			
			//System.out.println("inside writeResponse -----------writeResponse-----------------");
	
			byte buf[] = om.writeValueAsString(mdata).getBytes();
			//System.out.println("inside AIIMAS Servlet writeResponse ---------Response json : " + new String(buf));
			
		
			response.setContentLength(buf.length);
			response.setContentType("application/json");
			response.getOutputStream().write(buf);
			response.getOutputStream().close();
			
			
		} catch (Exception e) {
			
			System.out.println("inside AIIMAS Servlet writeResponse ---ERROE-----Response json : "+e.toString());
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
		
		//System.out.println("inside aiimas servier");
		
		String app = request.getParameter("app");
		String module = request.getParameter("module");
		String action = request.getParameter("action");
		//String action = request.getParameter("logoutaiimas");
	
		
		//System.out.println("inside aiimas  RAJJJ servier do post...-"+app + "," + module +"," + action);	
		
		//--------------- Action = Logout -------------- //
		
		//System.out.println("inside aiimas  RAJJJ servier do -  to check LOGIN");
		if("login".equals(action)) {
			
			resp.setContentType("text/html;charset=UTF-8");
			String user = request.getParameter("user");
	        String checkp = request.getParameter("password");
	        // AUTHENDICATE in DB
	        boolean loginresult = false;
	        

	        
	      try {  
	        Maintenance maintenance = new Maintenance();
			Map input = new HashMap();
			input.put("user", user);
			input.put("checkp", checkp);

	        loginresult = maintenance.loginValidation(input);

		} catch (Exception e) {
			System.out.println("in Servlet CATCH Failure :: Servlet : LOGIN check -- "+e.toString());
		}
	        
	         if(loginresult) {
	        	resp.getWriter().write("success");
	            HttpSession session = request.getSession();
	            session.setAttribute("user", user);
	        }else {
	        	resp.getWriter().write("failure");
	        }
		}else if ("logout".equals(action)) {
			if ("mklogoutaiimas".equals(module)) {
			try {
				HttpSession session=request.getSession();  
	            session.invalidate();  
			//request.getSession(true).invalidate();
			//resp.sendRedirect("index.html");
	            System.out.println("SESSION INVALIDATED -");	
	            //resp.sendRedirect(request.getContextPath() + "/logout.jsp");


	            request.setAttribute("Error", "Session has ended.  Please login.");
	            //RequestDispatcher rd = request.getRequestDispatcher("logout.jsp");
	            //rd.forward(request, resp);
	            //System.out.println("POST forward ");		
			//return;

	            Map response1 = new HashMap();
				response1.put("loggedoutsuccess", "Logged out successfully");

				writeResponse(response1, resp);
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}
		}
		
		Object response="success";
		
		//--------------- Action = Application AIIMAS  -------------- //
		
		try {
		//	System.out.println("request :  " + module +"," + action);
			
			//--------------- Action = Application VERIFICATION  -------------- //
			if (module != null && module.equals("verification")) {
		
				//System.out.println("Inside module Verification : " + action);
			
												
				String prn = request.getParameter("prNo");
				String prc = request.getParameter("prCode");
				
							
				Verification verification = new Verification();
				Map input = new HashMap();
				input.put("prNum", prn);
				input.put("prCode", prc);

				//String[] username = (String[])data.get("username");
				//input.put("username", username[0]);
				
				
				Map verifyedFullValues = verification.getVerficationFULLDetail1(input);
				//System.out.println(" RESPONSE  FULL verification GOT in MAP -- "+verifyedFullValues);
				
				writeResponse(verifyedFullValues, resp);
				
				
			}else if (module != null && module.equals("findPRverify")) {
		
				//System.out.println("Inside module findPRverify : " + action);
			
												
				String prcdnoNamesearch = request.getParameter("prcdnoNamesearch");
				String prcdnoDipCodeName = request.getParameter("prcdnoDipCodeName");
				String prcdnosemMonthName = request.getParameter("prcdnosemMonthName");
				String prcdnosemYearName = request.getParameter("prcdnosemYearName");
				
							
				Verification verification = new Verification();
				Map input = new HashMap();
				input.put("prcdnoNamesearch", prcdnoNamesearch);
				input.put("prcdnoDipCodeName", prcdnoDipCodeName);
				input.put("prcdnosemMonthName", prcdnosemMonthName);
				input.put("prcdnosemYearName", prcdnosemYearName);

				//String[] username = (String[])data.get("username");
				//input.put("username", username[0]);
				
				
				Map verifyedFindPR = verification.getVerficationByName(input);
				System.out.println(" RESPONSE  getVerficationFindPR GOT in MAP   ***************** -- "+verifyedFindPR);
				
				writeResponse(verifyedFindPR, resp);
				
				
			}else if (module != null && module.equals("logoutaiimas")) {
				System.out.println("Inside module Verification  by name : " + action);
				
				 	resp.setContentType("text/html");  
		            PrintWriter out=resp.getWriter();  
		              
		            request.getRequestDispatcher("link.html").include(request, resp);  
		              
		            HttpSession session=request.getSession();  
		            session.invalidate();  
		              
		            out.print("You are successfully logged out!");  
		              
		            out.close();  

				
			}else if (module != null && module.equals("printViewQuestion")) {
				
				if(action != null && action.equals("searchQ")) {
					// search Institute
					System.out.println(" AIIMAS SERVLET  --  search QUESTION ");
					
					String diplomaCode1 = request.getParameter("diplomaCode1");
						
					Map input = new HashMap();
					input.put("diplomaCode1", diplomaCode1);

					
					PrintView printView = new PrintView();
					List searchQuestions = printView.getQuestions(input);
														
					System.out.println(" RESPONSE  searchQ GOT in LIST  -- "+searchQuestions);
					
					writeResponse(searchQuestions, resp);
				}
					
				// may be need else later else remove the if
				
			}else if(module != null && module.equals("printReport_QuestionPaper")) {
				
				System.out.println(" AIIMAS SERVLET  --  Question Paper List  ");
				
				String QAsemMonthName = request.getParameter("QAsemMonthName");
				String QAsemYearName = request.getParameter("QAsemYearName");
				String QAexamCenterCode = request.getParameter("QAexamCenterCode");
				String sessionvalue = request.getParameter("sessionvalue");
				
					
				
				Map input = new HashMap();
				input.put("action", action);
				input.put("QAsemMonthName", QAsemMonthName);
				input.put("QAsemYearName", QAsemYearName);
				input.put("QAexamCenterCode", QAexamCenterCode);
				input.put("sessionvalue", sessionvalue);

				//RAJKUMAR to merge start
				
				// click on marksheet to get the test report
				
				PrintView printView = new PrintView();
				List list = printView.getQuestionPaperList1(input);
				//Map finaldataPDF = new HashMap();
				
				Map finaldataPDF = new HashMap<String,String>();
				 int displayResult =  0;
				 String displayName = new String("");


				
				// GENERATING the PDF
				
				System.out.println(" Going to  WOOOOOOOOOOOOOOOOOOK array list here " +list.toString());
				String diplName = new String("");
				
			      Map<String, Integer> duplicates = new HashMap<String, Integer>(); 
			      
			      for (Object str : list) { 
			         if (duplicates.containsKey(str.toString())) { 
			            duplicates.put(str.toString(), duplicates.get(str) + 1); 
			         } else { 
			            duplicates.put(str.toString(), 1); 
			         } 
			      } 
			 
			      for (Map.Entry<String, Integer> entry : duplicates.entrySet()) { 
			         System.out.println(entry.getKey() + " =" + entry.getValue()); 
			         displayName = entry.getKey();
//			         
//			     	if((displayName != null )) {
//						if(displayName.contains("=")) {
//							int subcount = displayName.indexOf("=");
//							displayName= displayName.substring(subcount+1);
//							/////= center.trim();
//						}
//					}
			         
			         displayName = displayName.replace("{dp_paprnam=", " "); 	
			         displayName = displayName.replace("}", " "); 
			         displayResult = entry.getValue();
			         finaldataPDF.put(displayName,displayResult);
			      } 

			      System.out.println("TO PRINT PDF map = "+ finaldataPDF.toString()); 
			      
			      
//								
				 
				PDFGenerator pdfGenerator = new PDFGenerator();
				
				
				Map<String, Object> applicListData1 = new TreeMap<String, Object>();
				
				String gfile = pdfGenerator.PrintLetterPDF(input, finaldataPDF);
				
			//	System.out.println("DONE GENERATE the PDF file and saved in c:/temp/FirstPdf.pdf");
				
							
				Map retrunMap = new HashMap();
				
				retrunMap.put("Filename", gfile);
				
				writeResponse(retrunMap, resp);
			}else if(module != null && module.equals("printReport_AttendChart")) {
				
				System.out.println(" AIIMAS SERVLET  --  Attendance chart  ");
				
			
				String ACsemMonthName = request.getParameter("ACsemMonthName");
				String ACsemYearName = request.getParameter("ACsemYearName");
				String ACduration = request.getParameter("ACduration");
				String ACdiplomaCode = request.getParameter("ACdiplomaCode");
				String ACexamCenterCode = request.getParameter("ACexamCenterCode");
				
//				System.out.println(" AIIMAS SERVLET  --  PRINT REPORTS  all reports here  " +action);	
//				System.out.println(" AIIMAS SERVLET  --  PRINT REPORTS  all reports here  " +ACsemMonthName);	
//				System.out.println(" AIIMAS SERVLET  --  PRINT REPORTS  all reports here  " +ACsemYearName);	
//				System.out.println(" AIIMAS SERVLET  --  PRINT REPORTS  all reports here  " +ACduration);	
//				System.out.println(" AIIMAS SERVLET  --  PRINT REPORTS  all reports here  " +ACdiplomaCode);	
//				System.out.println(" AIIMAS SERVLET  --  PRINT REPORTS  all reports here  " +ACexamCenterCode);	
				
				Map input = new HashMap();
				input.put("action", action);
				input.put("ACsemMonthName", ACsemMonthName);
				input.put("ACsemYearName", ACsemYearName);
				input.put("ACduration", ACduration);
				input.put("ACdiplomaCode", ACdiplomaCode);
				input.put("ACexamCenterCode", ACexamCenterCode);


				//RAJKUMAR to merge start
				
				// click on marksheet to get the test report
				
				PrintView printView = new PrintView();
				Map attendanceChatData = printView.getAttendanceChart(input);
				
				
				
				// GENERATING the PDF
				
				//System.out.println(" Going to  GENERATE attendanceChatData ====== " +attendanceChatData);
				 
				PDFGenerator pdfGenerator = new PDFGenerator();
				String gfile = pdfGenerator.PrintLetterPDF(input, attendanceChatData);
				
				//System.out.println("DONE GENERATE the PDF file and saved in c:/temp/FirstPdf.pdf");
				
							
				Map retrunMap = new HashMap();
				
				retrunMap.put("Filename", gfile);
				
				writeResponse(retrunMap, resp);
			}else if(module != null && module.equals("printReport_ApplicantList")) {
				
				System.out.println(" AIIMAS SERVLET  --  APPLICANT LIST LETTER here  ");
				
				String ALsemMonthName = request.getParameter("ALsemMonthName");
				String ALsemYearName = request.getParameter("ALsemYearName");
				String ALexamCenterCode = request.getParameter("ALexamCenterCode");
				
				
				Map input = new HashMap();
				input.put("action", action);
				input.put("ALsemMonthName", ALsemMonthName);
				input.put("ALsemYearName", ALsemYearName);
				input.put("ALexamCenterCode", ALexamCenterCode);
				
				//RAJKUMAR to merge start
				
			
				
				PrintView printView = new PrintView();
				Map applicListData = printView.getApplicantslist(input);
				
							
				// GENERATING the PDF
				
				System.out.println(" Going to  GENERATE the PDF file  and get data there in pdf gen file " +applicListData);
				 
				PDFGenerator pdfGenerator = new PDFGenerator();
				String gfile = pdfGenerator.PrintLetterPDF(input, applicListData);
				
				System.out.println("DONE GENERATE APPLICANT LIST the PDF file and saved in c:/temp/FirstPdf.pdf");
				
							
				Map retrunMap = new HashMap();
				
				retrunMap.put("Filename", gfile);
				
				writeResponse(retrunMap, resp);
			}else if(module != null && module.equals("printReport_StudentAddress")) {
				
				System.out.println(" AIIMAS SERVLET  --  printReport_StudentAddress  ");
				
				String StuAdrPRCode1 = request.getParameter("StuAdrPRCode1");
				String StuAdrPRNo1 = request.getParameter("StuAdrPRNo1");
				String StuAdrCopy1 = request.getParameter("StuAdrCopy1");
				
					
				System.out.println(" AIIMAS SERVLET  --  PRINT REPORTS  all reports here  " +StuAdrPRNo1);	
				System.out.println(" AIIMAS SERVLET  --  PRINT REPORTS  all reports here  " +StuAdrCopy1);	
				
				Map input = new HashMap();
				input.put("action", action);
				input.put("StuAdrPRCode1", StuAdrPRCode1);
				input.put("StuAdrPRNo1", StuAdrPRNo1);
				input.put("StuAdrCopy1", StuAdrCopy1);

				//RAJKUMAR to merge start
				
			
				
				PrintView printView = new PrintView();
				Map applicListData = printView.getStudentAddress(input);
				
							
				// GENERATING the PDF
				
				System.out.println(" Going to  GENERATE the PDF file  and get data there in pdf gen file " +applicListData);
				 
				PDFGenerator pdfGenerator = new PDFGenerator();
				String gfile = pdfGenerator.PrintStudAddressPDF(input, applicListData);
				
				//System.out.println("DONE GENERATE APPLICANT LIST the PDF file and saved in c:/temp/FirstPdf.pdf");
				
							
				Map retrunMap = new HashMap();
				
				retrunMap.put("Filename", gfile);
				
				writeResponse(retrunMap, resp);
			}else if(module != null && module.equals("printReport_StuAddressbyCentre")) {
				
				System.out.println(" AIIMAS SERVLET  --  printReport_StuAddressbyCentre ");
				
				String ALsemMonthName1 = request.getParameter("ALsemMonthName1");
				String ALsemYearName1 = request.getParameter("ALsemYearName1");
				String ALexamCenterCode1 = request.getParameter("ALexamCenterCode1");
			
				
				
				Map input = new HashMap();
				input.put("action", action);
				input.put("ALsemMonthName1", ALsemMonthName1);
				input.put("ALsemYearName1", ALsemYearName1);
				input.put("ALexamCenterCode1", ALexamCenterCode1);

				//RAJKUMAR to merge start
				
			
				
				PrintView printView = new PrintView();
				Map applicListData = printView.getStudentAddressByCentre(input);
				
							
				// GENERATING the PDF
				
				System.out.println(" Going to  GENERATE the PDF file  and get data there in pdf gen file " +applicListData);
				 
				PDFGenerator pdfGenerator = new PDFGenerator();
				String gfile = pdfGenerator.PrintStudAddressPDF(input, applicListData);
				
				System.out.println("DONE GENERATE APPLICANT LIST the PDF file and saved in c:/temp/FirstPdf.pdf");
				
							
				Map retrunMap = new HashMap();
				
				retrunMap.put("Filename", gfile);
				
				writeResponse(retrunMap, resp);
			}else if(module != null && module.equals("printReport")) {
				
				//printReport - ORGINAL 
				
				System.out.println(" AIIMAS SERVLET  --  PRINT REPORTS  all reports here  ");
				
				String adprCode = request.getParameter("adprCode");
				String adpprNo = request.getParameter("adpprNo");
				
					
				System.out.println(" AIIMAS SERVLET  printReport  rrrr--  PRINT REPORTS  all reports here  " +adprCode);	
				System.out.println(" AIIMAS SERVLET  printReport rrrr--  PRINT REPORTS  all reports here  " +adpprNo);	
				
				Map input = new HashMap();
				input.put("action", action);
				input.put("adprCode", adprCode);
				input.put("adpprNo", adpprNo);

				//RAJKUMAR to merge start
				
				// click on marksheet to get the test report
				
				
				//BASED on  Action , change the query  KEVIN
				
				PrintView printView = new PrintView();
				Map pdfData = new HashMap();
				
				 // for each Report this has to be changed
	            if (action != null && action.equals("admInit")) {
	            	pdfData =  printView.getAdmInitimationetails(input);
	            }else if(action != null && action.equals("ackLetter")) {
	            	pdfData =  printView.getAcknowledgeContent(input);
	            }else if(action != null && action.equals("ansSheet")) {
	            	pdfData =  printView.getAnswerSheetAcknowledge(input);
	            }else if(action != null && action.equals("hallTck")) {
	            	pdfData =  printView.getHallTicketContent(input);
	            }else if(action != null && action.equals("mrkSheet")) {
	            	pdfData =  printView.getMarkSheetContent(input);
	            }else if(action != null && action.equals("diplomaCerti")) {
	            	pdfData =  printView.getDiplomaCertiContent(input);
	            }
				
						
				// GENERATING the PDF
			
	            	
	            	PDFGenerator pdfGenerator = new PDFGenerator();
					String gfile = pdfGenerator.PrintPDF(input, pdfData );
					
					System.out.println("DONE GENERATE the PDF file and saved "+gfile);
					
					Map retrunMap = new HashMap();
					
					retrunMap.put("Filename", gfile);
					
					writeResponse(retrunMap, resp);
	            	
	            
	            
				
			}else if (module != null && module.equals("getCurrentPRno")) {
				
				String prCode11 = request.getParameter("prCode11");
									
				System.out.println(" AIIMAS SERVLET  --  getCurrentPRno " +prCode11);	
	
				
				Map input = new HashMap();
				input.put("prCode11", prCode11);
				
				AddAdmission addAdmission = new AddAdmission();
				Map currentPRNo = addAdmission.getCurrentPRNo(input);
				System.out.println(" RESPONSE MarkApplication GOT in MAP -- "+currentPRNo);
				
				writeResponse(currentPRNo, resp);
				
				
			}else if (module != null && module.equals("addAdmission")) {
					
					System.out.println("Inside module addAdmission : " + action);
				
													
					String stuName = request.getParameter("stuName");
					String address1 = request.getParameter("address1");
					String diplomaCode = request.getParameter("diplomaCode");
					String duration = request.getParameter("duration");
					String semMonth = request.getParameter("semMonth");
					String semYear = request.getParameter("semYear");
					String enterDate = request.getParameter("enterDate");
					String prCode11 = request.getParameter("prCode11");
					String prNo1 = request.getParameter("prNo1");
					String paidamt = request.getParameter("paidamt");
					String address2 = request.getParameter("address2");
					String address3 = request.getParameter("address3");
					String address4 = request.getParameter("address4");
					String pincode = request.getParameter("pincode");
					String mobNum = request.getParameter("mobNum");
					String phonenum = request.getParameter("phonenum");
					String state = request.getParameter("state");
					String emailid = request.getParameter("emailid");
					String dueDate = request.getParameter("dueDate");
					String totfee = request.getParameter("totfee");
					String papers = request.getParameter("papers");
					String feepaiddate= request.getParameter("feepaiddate");
					String feepaidmode = request.getParameter("feepaidmode");
					String feeref= request.getParameter("feeref");
					
								
					
					Map input = new HashMap();
					input.put("stuName", stuName);
					input.put("address1", address1);
					input.put("diplomaCode",diplomaCode );
					input.put("duration",duration );
					input.put("semMonth",semMonth );
					input.put("semYear",semYear );
					input.put("enterDate",enterDate );
					input.put("prCode11",prCode11 );
					input.put("prNo1",prNo1 );
					input.put("paidamt",paidamt);
					input.put("address2",address2 );
					input.put("address3",address3 );
					input.put("address4",address4 );
					input.put("state",state );
					input.put("pincode",pincode );
					input.put("phonenum",phonenum );
					input.put("mobNum",mobNum );
					input.put("emailid",emailid );
					input.put("dueDate",dueDate );
					input.put("totfee",totfee );
					input.put("papers",papers );
					input.put("feepaiddate",feepaiddate );
					input.put("feepaidmode",feepaidmode );
					input.put("feeref",feeref );
					
					System.out.println(" calling addadmission");
					AddAdmission addAdmission = new AddAdmission();
					addAdmission.insertADMN(input);
					
					System.out.println(" RESPONSE GOT in MAP --  INSERT successsss");
					
					Map response1 = new HashMap();
					response1.put("Success", "Admission is Done successfully");
					
					writeResponse(response1, resp);
				}else if (module != null && module.equals("modifyAdmission")) {
					
					System.out.println("Inside module modifyAdmission : " + action);
				
													
					String stuName = request.getParameter("stuName");
					String address1 = request.getParameter("address1");
					String diplomaCode = request.getParameter("diplomaCode");
					String duration = request.getParameter("duration");
					String semMonth = request.getParameter("semMonth");
					String semYear = request.getParameter("semYear");
					String enterDate = request.getParameter("enterDate");
					String prCode11 = request.getParameter("prCode11");
					String prNo1 = request.getParameter("prNo1");
					String paidamt = request.getParameter("paidamt");
					String address2 = request.getParameter("address2");
					String address3 = request.getParameter("address3");
					String address4 = request.getParameter("address4");
					String pincode = request.getParameter("pincode");
					String mobNum = request.getParameter("mobNum");
					String phonenum = request.getParameter("phonenum");
					String state = request.getParameter("state");
					String emailid = request.getParameter("emailid");
					String dueDate = request.getParameter("dueDate");
					String totfee = request.getParameter("totfee");
					String papers = request.getParameter("papers");
					String feepaiddate= request.getParameter("feepaiddate");
					String feepaidmode = request.getParameter("feepaidmode");
					String feeref= request.getParameter("feeref");
					
								
					
					Map input = new HashMap();
					input.put("stuName", stuName);
					input.put("address1", address1);
					input.put("diplomaCode",diplomaCode );
					input.put("duration",duration );
					input.put("semMonth",semMonth );
					input.put("semYear",semYear );
					input.put("enterDate",enterDate );
					input.put("prCode11",prCode11 );
					input.put("prNo1",prNo1 );
					input.put("paidamt",paidamt);
					input.put("address2",address2 );
					input.put("address3",address3 );
					input.put("address4",address4 );
					input.put("state",state );
					input.put("pincode",pincode );
					input.put("phonenum",phonenum );
					input.put("mobNum",mobNum );
					input.put("emailid",emailid );
					input.put("dueDate",dueDate );
					input.put("totfee",totfee );
					input.put("papers",papers );
					input.put("feepaiddate",feepaiddate );
					input.put("feepaidmode",feepaidmode );
					input.put("feeref",feeref );
					
				 if(action != null && action.equals("updateAdm")) {
					
						System.out.println(" **** calling UPDATE admission");
						AddAdmission addAdmission = new AddAdmission();
						addAdmission.updateADMN(input);
						
						System.out.println(" RESPONSE GOT in MAP --  UPDATE Admission successsss");
						
						Map response1 = new HashMap();
						response1.put("Success", " UPDATE Admission is Done successfully");
						
						writeResponse(response1, resp);
						//end of UPDATE admission
					}else if(action != null && action.equals("deleteAdm")) {
						
						System.out.println(" **** calling delete admission");
						AddAdmission addAdmission = new AddAdmission();
						addAdmission.deleteADMN(input);
						
						System.out.println(" RESPONSE GOT in MAP --  DELETE  Admission successsss");
						
						Map response1 = new HashMap();
						response1.put("Success", " DELETE Admission is Done successfully");
						
						writeResponse(response1, resp);
						//end of Delete admission
					}
				}else if (module != null && module.equals("getStudentData")) {

				// GET STudent Details
					
					System.out.println(" start --  UPDATE  Admission ");
					
					String prn = request.getParameter("prNo");
					String prc = request.getParameter("prCode");
					
								
					AddAdmission addAdmission = new AddAdmission();
					Map input = new HashMap();
					input.put("prNum", prn);
					input.put("prCode", prc);

					
					Map studentDetails = addAdmission.getStudentDetails(input);
					System.out.println(" RESPONSE getStudentDetails GOT in MAP -- "+studentDetails);
					
					writeResponse(studentDetails, resp);
					
					
					System.out.println(" RESPONSE GOT in MAP --  UPDATE  Admission success");
					
				
				} if(module != null && module.equals("updateDiplomas")) {
					
					String diplomaName = request.getParameter("diplomaName");
					String dcDiplomaName = request.getParameter("dcDiplomaName");
					String noPaper = request.getParameter("noPaper1");
					String diplomaCode1 = request.getParameter("diplomaCode1");
					
					
								
					AddAdmission addAdmission = new AddAdmission();
					Map input = new HashMap();
					input.put("diplomaName", diplomaName);
					input.put("dcDiplomaName", dcDiplomaName);
					input.put("noPaper", noPaper);
					input.put("diplomaCode1", diplomaCode1);
					
					System.out.println(" **** calling UPDATE -------------UPDATE-----------  Diploma ");
					Maintenance maintenance = new Maintenance();
					
					maintenance.saveDiplomaDetail(input);
//					if(action != null && action.equals("Update")) {
//						
//						System.out.println(" **** calling UPDATE --------Update----------------  Diploma ");
//					}else if(action != null && action.equals("Insert")) {
//						maintenance.insertDiplomaData(input);
//						System.out.println(" **** calling UPDATE ----------Insert--------------  Diploma ");
//					}
					
					System.out.println(" RESPONSE GOT in MAP --  UPDATE Diploma successsss");
					
					Map response1 = new HashMap();
					response1.put("Success", " UPDATE Diploma is Done successfully");
					
					writeResponse(response1, resp);
					//end of UPDATE admission
				}if(module != null && module.equals("updateInstitue")) {
					
					String instituteName = request.getParameter("instituteName");
					String instituteAddress = request.getParameter("instituteAddress");
					String institutePhNumbers = request.getParameter("institutePhNumbers");
					String insituteCode = request.getParameter("insituteCode");
					
					
								
					AddAdmission addAdmission = new AddAdmission();
					Map input = new HashMap();
					input.put("instituteName", instituteName);
					input.put("instituteAddress", instituteAddress);
					input.put("institutePhNumbers", institutePhNumbers);
					input.put("insituteCode", insituteCode);
					
					System.out.println(" **** calling UPDATE  Institue");
					Maintenance maintenance = new Maintenance();
					maintenance.updateInstitue(input);
					
					System.out.println(" RESPONSE GOT in MAP --  UPDATE Institue successsss");
					
					Map response1 = new HashMap();
					response1.put("Success", " UPDATE Institue is Done successfully");
					
					writeResponse(response1, resp);
					//end of UPDATE admission
				}else if (module != null && module.equals("ExamApplication")) {

					// GET EXAM Details
						
						System.out.println(" start --  serach Eaxm ");
						
						String prn = request.getParameter("prNo");
						String prc = request.getParameter("prCode");
						
									
						ExamApplication examApplication = new ExamApplication();
						Map input = new HashMap();
						input.put("prNum", prn);
						input.put("prCode", prc);

						
						Map examDetails = examApplication.getExamDetails(input);
						System.out.println(" RESPONSE examDetails GOT in MAP -- "+examDetails);
						
						writeResponse(examDetails, resp);
						
						
						System.out.println(" RESPONSE GOT in MAP --  Exam application success");
						
					
					}else if (module != null && module.equals("AddExamApplication")) {

						// SAVE EXAM Details
							
							System.out.println(" start --  SAVE EXAM application");
							
							String prCodeExam = request.getParameter("prCodeExam");
							String prNoExam = request.getParameter("prNoExam");
							String diplomaCodeExam = request.getParameter("diplomaCodeExam");
							String durationExam = request.getParameter("durationExam");
							String noofPaperExam = request.getParameter("noofPaperExam");
							String semMonthExam = request.getParameter("semMonthExam");
							String semYearExam = request.getParameter("semYearExam");
							String enterDateExam = request.getParameter("enterDateExam");
							String stuNameExam = request.getParameter("stuNameExam");
							String examStateCode = request.getParameter("examStateCode");
							String examCenterCode = request.getParameter("examCenterCode");
				
							
							String ackIniLetterDate = request.getParameter("ackIniLetterDate");
							String ackHallTckDate= request.getParameter("ackHallTckDate");
							String ackExamdate1 = request.getParameter("ackExamdate1");
							String ackExamdate2 = request.getParameter("ackExamdate2");
							
							String oldnofpapr = request.getParameter("oldnofpapr");
							String ea_paprstr = request.getParameter("ea_paprstr");
						//	String examPassFlag = request.getParameter("examPassFlag");
							
										
							
							Map input = new HashMap();
							input.put("prCodeExam", prCodeExam);
							input.put("prNoExam", prNoExam);
							input.put("diplomaCodeExam", diplomaCodeExam);
							input.put("durationExam", durationExam);
							input.put("noofPaperExam", noofPaperExam);
							input.put("semMonthExam", semMonthExam);
							input.put("semYearExam", semYearExam);
							input.put("enterDateExam", enterDateExam);
							input.put("stuNameExam", stuNameExam);
							input.put("examStateCode", examStateCode);
							input.put("examCenterCode", examCenterCode);
							
							
							input.put("ackIniLetterDate", ackIniLetterDate);
							input.put("ackHallTckDate", ackHallTckDate);
							input.put("ackExamdate1", ackExamdate1);
							input.put("ackExamdate2", ackExamdate2);
							input.put("oldnofpapr", oldnofpapr);
							input.put("ea_paprstr", ea_paprstr);
							
							System.out.println(" RESPONSE examDetails befr   ackHallTckDate -- "+ackHallTckDate);
							
							ExamApplication examApplication = new ExamApplication();
							examApplication.insertExam(input);
							System.out.println(" RESPONSE examDetails sucesses -- ");
							
							Map response1 = new HashMap();
							response1.put("Success", "EXAM Insert is Done successfully");
							
							writeResponse(response1, resp);
							
							
							System.out.println(" RESPONSE GOT in MAP --  Exam application success");
							
						
						}else if (module != null && module.equals("ExamUpdateApplication")) {

							// GET EXAM  and student detailf or update  exam Details
								
								System.out.println(" start --  serach  update Eaxm ");
								
								String prn = request.getParameter("prNo");
								String prc = request.getParameter("prCode");
								
								
								System.out.println(" RESPONSE examupdateDetails GOT  prn in MAP"+prn);
								System.out.println(" RESPONSE examupdateDetails GOT  prc in MAP"+prc);
											
								ExamApplication examApplication = new ExamApplication();
								Map input = new HashMap();
								input.put("prNum", prn);
								input.put("prCode", prc);

								
								Map examUpdateDetails = examApplication.getExamUpdateDetails(input);
								System.out.println(" RESPONSE examDetails GOT in MAP -- "+examUpdateDetails);
								
								writeResponse(examUpdateDetails, resp);
								
								
								System.out.println(" RESPONSE GOT in MAP --  Exam application success");
								
							
							}else if (module != null && module.equals("UpdateExamApplication")) {

// UPDATE EXAM Details
							
							System.out.println(" start --   UPDATE EXAM application");
							
							String prCodeExam = request.getParameter("prCodeExam");
							String prNoExam = request.getParameter("prNoExam");
							String diplomaCodeExam = request.getParameter("diplomaCodeExam");
							String durationExam = request.getParameter("durationExam");
							String noofPaperExam = request.getParameter("noofPaperExam");
							String semMonthExam = request.getParameter("semMonthExam");
							String semYearExam = request.getParameter("semYearExam");
							String enterDateExam = request.getParameter("enterDateExam");
							String stuNameExam = request.getParameter("stuNameExam");
							String examStateCode = request.getParameter("examStateCode");
							String examCenterCode = request.getParameter("examCenterCode");
							String examPassFlag = request.getParameter("examPassFlag");
				
							
							String ackIniLetterDate = request.getParameter("ackIniLetterDate");
							String ackHallTckDate= request.getParameter("ackHallTckDate");
							String ackExamdate1 = request.getParameter("ackExamdate1");
							String ackExamdate2 = request.getParameter("ackExamdate2");
							
							String oldnofpapr = request.getParameter("oldnofpapr");
							String ea_paprstr = request.getParameter("ea_paprstr");
						//	String examPassFlag = request.getParameter("examPassFlag");
							
										
							
							Map input = new HashMap();
							input.put("prCodeExam", prCodeExam);
							input.put("prNoExam", prNoExam);
							input.put("diplomaCodeExam", diplomaCodeExam);
							input.put("durationExam", durationExam);
							input.put("noofPaperExam", noofPaperExam);
							input.put("semMonthExam", semMonthExam);
							input.put("semYearExam", semYearExam);
							input.put("enterDateExam", enterDateExam);
							input.put("stuNameExam", stuNameExam);
							input.put("examStateCode", examStateCode);
							input.put("examCenterCode", examCenterCode);
							input.put("examPassFlag", examPassFlag);
							
							input.put("ackIniLetterDate", ackIniLetterDate);
							input.put("ackHallTckDate", ackHallTckDate);
							input.put("ackExamdate1", ackExamdate1);
							input.put("ackExamdate2", ackExamdate2);
							input.put("oldnofpapr", oldnofpapr);
							input.put("ea_paprstr", ea_paprstr);
							
							System.out.println(" RESPONSE examDetails befr   ackHallTckDate -- "+ackHallTckDate);
							
							ExamApplication examApplication = new ExamApplication();
							examApplication.updateExam(input);
							System.out.println(" RESPONSE examUPDATEDetails sucesses -- ");
							
							Map response1 = new HashMap();
							response1.put("Success", "EXAM Update is Done successfully");
							
							writeResponse(response1, resp);
							
							
							System.out.println(" RESPONSE GOT in MAP --  Exam UPDATE application success");
							
								
							
							}else if (module != null && module.equals("MarkUpdateApplication")) {

								// GET MARK Details
									
									System.out.println(" start --  MARK  UPDATE application  Admission ");
									
									String prn = request.getParameter("prNo1");
									String prc = request.getParameter("prCode1");
									
												
									MarkUpdate markUpdate = new MarkUpdate();
									Map input = new HashMap();
									input.put("prNum", prn);
									input.put("prCode", prc);

									
									Map marksDetails = markUpdate.getMarkUpdateDetails(input);
									System.out.println(" RESPONSE Mark   UPDATE  Application GOT in MAP -- "+marksDetails);
									
									writeResponse(marksDetails, resp);
									
									
									System.out.println(" RESPONSE GOT in MAP --  MARKs applicatoin success");
									
								
								}else if (module != null && module.equals("MarkApplication")) {

						// GET MARK Details
							
							System.out.println(" start --  MARK application  Admission ");
							
							String prn = request.getParameter("prNo");
							String prc = request.getParameter("prCode");
							
										
							MarkUpdate markUpdate = new MarkUpdate();
							Map input = new HashMap();
							input.put("prNum", prn);
							input.put("prCode", prc);

							
							Map marksDetails = markUpdate.getMarkDetails(input);
							System.out.println(" RESPONSE MarkApplication GOT in MAP -- "+marksDetails);
							
							writeResponse(marksDetails, resp);
							
							
							System.out.println(" RESPONSE GOT in MAP --  MARKs applicatoin success");
							
						
						}else if (module != null && module.equals("SaveMark")) {

							// Save Mark Details
								
								System.out.println(" start --  Save Mark      ");
								
								String prCodeMark = request.getParameter("prCodeMark");
								String prNoMark = request.getParameter("prNoMark");
								String diplomaCodeMark = request.getParameter("diplomaCodeMark");
								String SemMonthMark = request.getParameter("SemMonthMark");
								String SemYearMark = request.getParameter("SemYearMark");
								String stuNameMark = request.getParameter("stuNameMark");
								String enterDateMarks = request.getParameter("enterDateMarks");
								String noofPaperMark = request.getParameter("noofPaperMark");
								
								String row1paperMark= request.getParameter("row1paperMark");
								String row1paper= request.getParameter("row1paper");
								String row1papername= request.getParameter("row1papername");
								String row2paperMark= request.getParameter("row2paperMark");
								String row2paper= request.getParameter("row2paper");
								String row2papername= request.getParameter("row2papername");
								String row3paperMark= request.getParameter("row3paperMark");
								String row3paper= request.getParameter("row3paper");
								String row3papername= request.getParameter("row3papername");
								String row4paperMark= request.getParameter("row4paperMark");
								String row4paper= request.getParameter("row4paper");
								String row4papername= request.getParameter("row4papername");
								String row5paperMark= request.getParameter("row5paperMark");
								String row5paper= request.getParameter("row5paper");
								String row5papername= request.getParameter("row5papername");
								String row6paperMark= request.getParameter("row6paperMark");
								String row6paper= request.getParameter("row6paper");
								String row6papername= request.getParameter("row6papername");
								String row7paperMark= request.getParameter("row7paperMark");
								String row7paper= request.getParameter("row7paper");
								String row7papername= request.getParameter("row7papername");
								String row8paperMark= request.getParameter("row8paperMark");
								String row8paper= request.getParameter("row8paper");
								String row8papername= request.getParameter("row8papername");
											
								MarkUpdate markUpdate = new MarkUpdate();
								Map input = new HashMap();
								input.put("prCodeMark", prCodeMark);
								input.put("prNoMark", prNoMark);
								input.put("diplomaCodeMark", diplomaCodeMark);
								input.put("noofPaperMark", noofPaperMark);
								input.put("SemMonthMark", SemMonthMark);
								input.put("SemYearMark", SemYearMark);
								input.put("stuNameMark", stuNameMark);
								input.put("enterDateMarks",enterDateMarks);
								input.put("row1paperMark", row1paperMark);
								input.put("row1paper", row1paper);
								input.put("row1papername", row1papername);
								input.put("row2paperMark", row2paperMark);
								input.put("row2paper", row2paper);
								input.put("row2papername", row2papername);
								input.put("row3paperMark", row3paperMark);
								input.put("row3paper", row3paper);
								input.put("row3papername", row3papername);
								input.put("row4paperMark", row4paperMark);
								input.put("row4paper", row4paper);
								input.put("row4papername", row4papername);
								input.put("row5paperMark", row5paperMark);
								input.put("row5paper", row5paper);
								input.put("row5papername", row5papername);
								input.put("row6paperMark", row6paperMark);
								input.put("row6paper", row6paper);
								input.put("row6papername", row6papername);
								input.put("row7paperMark", row7paperMark);
								input.put("row7paper", row7paper);
								input.put("row7papername", row7papername);
								input.put("row8paperMark", row8paperMark);
								input.put("row8paper", row8paper);
								input.put("row8papername", row8papername);

								
								 markUpdate.saveMarks(input);
							
								System.out.println(" RESPONSE examUPDATEDetails sucesses -- ");
								
								Map response1 = new HashMap();
								response1.put("Success", "SAVE Marks is Done successfully");
								
								writeResponse(response1, resp);

								System.out.println(" RESPONSE GOT in MAP --  SAVE Marks success");
								
							}else if (module != null && module.equals("UpdateMark")) {

								// Update  Mark Details
									
									System.out.println(" start --  update  Mark      ");
									
									String prCodeMark = request.getParameter("prCodeMark1");
									String prNoMark = request.getParameter("prNoMark1");
									String diplomaCodeMark = request.getParameter("diplomaCodeMark1");
									String SemMonthMark = request.getParameter("SemMonthMark1");
									String SemYearMark = request.getParameter("SemYearMark1");
									String stuNameMark = request.getParameter("stuNameMark1");
									String enterDateMarks = request.getParameter("enterDateMarks1");
									String noofPaperMark = request.getParameter("noofPaperMark1");
									
									String row1paperMark= request.getParameter("row1paperMark1");
									String row1paper= request.getParameter("row1paper1");
									String row1papername= request.getParameter("row1papername1");
									String row2paperMark= request.getParameter("row2paperMark1");
									String row2paper= request.getParameter("row2paper1");
									String row2papername= request.getParameter("row2papername1");
									String row3paperMark= request.getParameter("row3paperMark1");
									String row3paper= request.getParameter("row3paper1");
									String row3papername= request.getParameter("row3papername1");
									String row4paperMark= request.getParameter("row4paperMark1");
									String row4paper= request.getParameter("row4paper1");
									String row4papername= request.getParameter("row4papername1");
									String row5paperMark= request.getParameter("row5paperMark1");
									String row5paper= request.getParameter("row5paper1");
									String row5papername= request.getParameter("row5papername1");
									String row6paperMark= request.getParameter("row6paperMark1");
									String row6paper= request.getParameter("row6paper1");
									String row6papername= request.getParameter("row6papername1");
									String row7paperMark= request.getParameter("row7paperMark1");
									String row7paper= request.getParameter("row7paper1");
									String row7papername= request.getParameter("row7papername1");
									String row8paperMark= request.getParameter("row8paperMark1");
									String row8paper= request.getParameter("row8paper1");
									String row8papername= request.getParameter("row8papername1");
												
									MarkUpdate markUpdate = new MarkUpdate();
									Map input = new HashMap();
									input.put("prCodeMark", prCodeMark);
									input.put("prNoMark", prNoMark);
									input.put("diplomaCodeMark", diplomaCodeMark);
									input.put("noofPaperMark", noofPaperMark);
									input.put("SemMonthMark", SemMonthMark);
									input.put("SemYearMark", SemYearMark);
									input.put("stuNameMark", stuNameMark);
									input.put("enterDateMarks",enterDateMarks);
									input.put("row1paperMark", row1paperMark);
									input.put("row1paper", row1paper);
									input.put("row1papername", row1papername);
									input.put("row2paperMark", row2paperMark);
									input.put("row2paper", row2paper);
									input.put("row2papername", row2papername);
									input.put("row3paperMark", row3paperMark);
									input.put("row3paper", row3paper);
									input.put("row3papername", row3papername);
									input.put("row4paperMark", row4paperMark);
									input.put("row4paper", row4paper);
									input.put("row4papername", row4papername);
									input.put("row5paperMark", row5paperMark);
									input.put("row5paper", row5paper);
									input.put("row5papername", row5papername);
									input.put("row6paperMark", row6paperMark);
									input.put("row6paper", row6paper);
									input.put("row6papername", row6papername);
									input.put("row7paperMark", row7paperMark);
									input.put("row7paper", row7paper);
									input.put("row7papername", row7papername);
									input.put("row8paperMark", row8paperMark);
									input.put("row8paper", row8paper);
									input.put("row8papername", row8papername);

									
									 markUpdate.updateMarks(input);
								
									System.out.println(" RESPONSE examUPDATEDetails sucesses -- ");
									
									Map response1 = new HashMap();
									response1.put("Success", "update Marks is Done successfully");
									
									writeResponse(response1, resp);

									System.out.println(" RESPONSE GOT in MAP --  update Marks success");
									
								}else if (module != null && module.equals("Maintenance")) {				
					//	 Maintenance
					
					if(action != null && action.equals("searchInsitute")) {
						// search Institute
						System.out.println(" AIIMAS SERVLET  --  search Institute");
						
						String insituteCode = request.getParameter("insituteCode");
							
						Map input = new HashMap();
						input.put("insituteCode", insituteCode);

						
						Maintenance maintenance = new Maintenance();
						Map searchInsitute = maintenance.getInstituteDetails(input);
															
						System.out.println(" RESPONSE  searchInsitute GOT in MAP -- "+searchInsitute);
						
						writeResponse(searchInsitute, resp);
						
					}else if(action != null && action.equals("searchDiploma")) {
						// search Diploma
						System.out.println(" AIIMAS SERVLET  --  search Diploma");
						
						String diplomaCode1 = request.getParameter("diplomaCode1");
							
						Map input = new HashMap();
						input.put("diplomaCode1", diplomaCode1);

						
						System.out.println(" RESPONSE  searchDiploma  ------------------------------GOT in MAP -- "+diplomaCode1);
						

						Maintenance maintenance = new Maintenance();
						Map searchDiploma = maintenance.getDiplomaDetails(input);
						
						
															
						System.out.println(" RESPONSE  searchInsitute GOT in MAP -- "+searchDiploma);
						
						writeResponse(searchDiploma, resp);
						
					}	// end of 	Maintenance		
					
					
				} // end of overall elseif
			
			
		} catch (Exception e) {
			System.out.println("in Servlet CATCH Failure :: AIIMAS Servlet -- "+e.toString());
//			StringWriter sw = new StringWriter();
//			PrintWriter pw = new PrintWriter(sw);
//			e.printStackTrace(pw);
//			pw.close();
//			sw.close();
			String responsestatus = new String("Failure");
			Map responseerror = new HashMap();
			responseerror.put(responsestatus, "failed "+e.toString());
		
			//Map ret = new HashMap();
			//ret.put("error", "Unable to process request due to technical error TRY again");
			writeResponse(responseerror, resp);
		}
		
		
		
	}
	
	public void destroy() {
	      // do nothing.
	   }
	
	
	


}