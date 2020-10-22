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

	
	public void init() throws ServletException { 
		
		
		try { 
			
			System.out.println(" RESPONSE insdie ------***********---------init  ");

			MasterTableValues masterTable = new MasterTableValues();
				
			// Loading master values and save as Global variables

			diplmaDetails = masterTable.getListMasterTable();
			
			System.out.println(" RESPONSE GOT Master table in MAP -- "+diplmaDetails);
			
		    if(diplmaDetails!=null){
		    		getServletContext().setAttribute( "diplomaCodeDetails", diplmaDetails );
		    }
					
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	

	private void writeResponse(Object mdata, HttpServletResponse response) {
		try {
			ObjectMapper om = new ObjectMapper();
			
//			System.out.println("inside writeResponse ----------------------------");
	
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
				
							
				Verification verification = new Verification();
				Map input = new HashMap();
				input.put("prNum", prn);
				input.put("prCode", prc);

				//String[] username = (String[])data.get("username");
				//input.put("username", username[0]);
				
				
				Map verifyedFullValues = verification.getVerficationFULLDetail1(input);
				System.out.println(" RESPONSE  FULL verification GOT in MAP -- "+verifyedFullValues);
				
				writeResponse(verifyedFullValues, resp);
				
				
			}else if (module != null && module.equals("verifyByName")) {
				System.out.println("Inside module Verification  by name : " + action);
				
				
				String studentName = request.getParameter("studentName");
			//	String prc = request.getParameter("prCode");
				
							
				Verification verification = new Verification();
				Map input = new HashMap();
				input.put("studentName", studentName);
			//	input.put("prCode", prc);

			
				
				Map verifyedbyName = verification.getVerficationByName(input);
				
				System.out.println(" RESPONSE   verification by NAME GOT in MAP -- "+verifyedbyName);
				
				writeResponse(verifyedbyName, resp);
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
				
			}else if(module != null && module.equals("printReport")) {
				
				System.out.println(" AIIMAS SERVLET  --  PRINT REPORTS  all reports here  ");
				
				String adprCode = request.getParameter("adprCode");
				String adpprNo = request.getParameter("adpprNo");
				
					
				System.out.println(" AIIMAS SERVLET  --  PRINT REPORTS  all reports here  " +adprCode);	
				System.out.println(" AIIMAS SERVLET  --  PRINT REPORTS  all reports here  " +adpprNo);	
				
				Map input = new HashMap();
				input.put("action", action);
				input.put("adprCode", adprCode);
				input.put("adpprNo", adpprNo);

				
			//	PrintView printView = new PrintView();
			//	Map searchAdmIniti = printView.getAdmInitimationetails(input);
				//Map printReports = printView.getPrintReports(input);
							// MOVING DATA fetch to  PDFGenerator.java						
				//System.out.println(" RESPONSE  printAdmInit GOT in MAP -- "+printReports);
				
				// GENERATING the PDF
				
				System.out.println(" Going to  GENERATE the PDF file  and get data there in pdf gen file ");
				
				PDFGenerator pdfGenerator = new PDFGenerator();
				String gfile = pdfGenerator.PrintPDF(input);
				
				System.out.println("DONE GENERATE the PDF file and saved in c:/temp/FirstPdf.pdf");
				
				//String gfile = new String("c:\\ temp\\ FirstPdf.pdf");
				
				Map retrunMap = new HashMap();
				
				retrunMap.put("Filename", gfile);
				
				writeResponse(retrunMap, resp);
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
				}else if (module != null && module.equals("UpdateAdmission")) {

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
							
							System.out.println(" start --  SAVE  Admission ");
							
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
							String examPapers = request.getParameter("examPapers");
							String examSemstr = request.getParameter("examSemstr");
							String examNewnoPapers = request.getParameter("examNewnoPapers");
							String examOldnoPapers = request.getParameter("examOldnoPapers");
							String examTotalPaper = request.getParameter("examTotalPaper");
							String examPassFlag = request.getParameter("examPassFlag");
							
										
							ExamApplication examApplication = new ExamApplication();
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
							input.put("examPapers", examPapers);
							input.put("examSemstr", examSemstr);
							input.put("examNewnoPapers", examNewnoPapers);
							input.put("examOldnoPapers", examOldnoPapers);
							input.put("examTotalPaper", examTotalPaper);
							input.put("examPassFlag", examPassFlag);

							
							
							
							//Map examDetails = 
								examApplication.insertExam(input);
							System.out.println(" RESPONSE examDetails sucesses -- ");
							
							Map response1 = new HashMap();
							response1.put("Success", "EXAM Insert is Done successfully");
							
							writeResponse(response1, resp);
							
							
							System.out.println(" RESPONSE GOT in MAP --  Exam application success");
							
						
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
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			pw.close();
			sw.close();
			
			response = "Error : " + sw.toString();
			Map ret = new HashMap();
			ret.put("error", "Unable to process request due to technical error TRY again");
			writeResponse(ret, resp);
		}
		
		
		
	}
	
	public void destroy() {
	      // do nothing.
	   }
	
	
	


}