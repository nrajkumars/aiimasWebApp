package com.aiimas.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PrintView extends BaseDao {

		
	public List getQuestions(Map input) throws Exception  {
		
	//	System.out.println(" INSIDE PRINT VIEW DAO getQuestions ");
		
		Object diplomaCode1 =  input.get("diplomaCode1");
	
		String getDiplomaDataSql = "select * from public.QAIIMS where Q_DIPCODE = ?";
		List data1 = executeFetchSql(getDiplomaDataSql, new Object[]{diplomaCode1.toString() });
	
	//	System.out.println(" INSIDE getDiplomaDetails --  going to run result = "+data1 );
		
		if (data1 != null && data1.size() > 0) {
			return data1;
		}
		return null;
			
		
	}
	
	
	
	
	public Map getAdmInitimationetails(Map input) throws Exception  {
		Object prNum =  input.get("adpprNo");
		Object prCode =  input.get("adprCode");
		
	
		Map finaldata = new HashMap();
		String admin = new String("Admin");
		String address = new String("Address");
		String fee = new String("Fee");
		
	//	System.out.println(" INSIDE PRINT VIEW  getAdmInitimationetails--  going to run the SQL = "+prNum+","+prCode );
		
		if (prNum != null && prNum.toString().trim().length() > 0) {
			if((prCode != null && prCode.toString().trim().length() > 0)) {
				
				// Read from ADMIN table
				String getAdminDataSql = "select * from public.admn where ad_prcode = ? and ad_prno = ?";
				List data1 = executeFetchSql(getAdminDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
			
				if (data1 != null && data1.size() > 0) {
					//return (Map) data1.get(0);
					finaldata.put(admin, data1.get(0));
				}
				
				// Read form ADDRESS table
				String getAddressDataSql = "select * from public.staddr where sa_prcode = ? and sa_prno = ?";
				List data2 = executeFetchSql(getAddressDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
			
				if (data2 != null && data2.size() > 0) {
					//return (Map) data2.get(0);
					finaldata.put(address, data2.get(0));
				}
				
				//// Read form Fee table
				String getFeeDataSql = "select * from public.fees where fe_prcode = ? and fe_prno = ?";
				List data3 = executeFetchSql(getFeeDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
			
				if (data3 != null && data3.size() > 0) {
					//return (Map) data3.get(0);
					finaldata.put(fee, data3.get(0));
				}
				
				return finaldata;
			}
		}
		return null;
	}
	
	public Map getAcknowledgeContent(Map input) throws Exception  {
		Object prNum =  input.get("adpprNo");
		Object prCode =  input.get("adprCode");
		
	
		Map finaldata = new HashMap();
	//	String admin = new String("Admin");
		String address = new String("Address");
		String ack = new String("Ack");
		
//		System.out.println(" INSIDE PRINT VIEW  getAcknowledgeContent--  going to run the SQL = "+prNum+","+prCode );
		
		if (prNum != null && prNum.toString().trim().length() > 0) {
			if((prCode != null && prCode.toString().trim().length() > 0)) {
				
//				// Read from ADMIN table
//				String getAdminDataSql = "select * from public.admn where ad_prcode = ? and ad_prno = ?";
//				List data1 = executeFetchSql(getAdminDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
//			
//				if (data1 != null && data1.size() > 0) {
//					//return (Map) data1.get(0);
//					finaldata.put(admin, data1.get(0));
//				}
				
				// Read form ADDRESS table
				String getAddressDataSql = "select * from public.staddr where sa_prcode = ? and sa_prno = ?";
				List data2 = executeFetchSql(getAddressDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
			
				if (data2 != null && data2.size() > 0) {
					//return (Map) data2.get(0);
					finaldata.put(address, data2.get(0));
				}
				
				//// Read form  to ACK table
				String getFeeDataSql = "select ak_sesmon, ak_sesyr, ak_venudt, ak_examdt1, ak_examdt2, ak_halldt from public.ACKBOX1 where AK_PRCODE = ? and AK_PRNO = ?";
				List data3 = executeFetchSql(getFeeDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
			
				if (data3 != null && data3.size() > 0) {
					//return (Map) data3.get(0);
					finaldata.put(ack, data3.get(0));
				}
				
				
				return finaldata;
			}
		}
		return null;
	}
	
	public Map getAnswerSheetAcknowledge(Map input) throws Exception  {
		Object prNum =  input.get("adpprNo");
		Object prCode =  input.get("adprCode");
		
	
		Map finaldata = new HashMap();
		String admin = new String("Admin");
		String address = new String("Address");
		
		
	//	System.out.println(" INSIDE PRINT VIEW  getAdmInitimationetails--  going to run the SQL = "+prNum+","+prCode );
		
		if (prNum != null && prNum.toString().trim().length() > 0) {
			if((prCode != null && prCode.toString().trim().length() > 0)) {
				
				// Read from ADMIN table
				String getAdminDataSql = "select * from public.admn where ad_prcode = ? and ad_prno = ?";
				List data1 = executeFetchSql(getAdminDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
			
				if (data1 != null && data1.size() > 0) {
					//return (Map) data1.get(0);
					finaldata.put(admin, data1.get(0));
				}
				
				// Read form ADDRESS table
				String getAddressDataSql = "select * from public.staddr where sa_prcode = ? and sa_prno = ?";
				List data2 = executeFetchSql(getAddressDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
			
				if (data2 != null && data2.size() > 0) {
					//return (Map) data2.get(0);
					finaldata.put(address, data2.get(0));
				}
				
						
				return finaldata;
			}
		}
		return null;
	}
	
	
	//  HallTicketContent
	public Map getHallTicketContent(Map input) throws Exception  {
		Object prNum =  input.get("adpprNo");
		Object prCode =  input.get("adprCode");
		
	
		Map finaldata = new HashMap();
		String exam = new String("Exam");
		String address = new String("Address");
		
		
	//	System.out.println(" INSIDE PRINT VIEW  getAdmInitimationetails--  going to run the SQL = "+prNum+","+prCode );
		
		if (prNum != null && prNum.toString().trim().length() > 0) {
			if((prCode != null && prCode.toString().trim().length() > 0)) {
				
				// Read form ADDRESS table
				String getAddressDataSql = "select * from public.staddr where sa_prcode = ? and sa_prno = ?";
				List data2 = executeFetchSql(getAddressDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
			
				if (data2 != null && data2.size() > 0) {
					//return (Map) data2.get(0);
					finaldata.put(address, data2.get(0));
				}
				
				// Read from exam table
				String getAdminDataSql = "select ea_sesmon, ea_sesyr,ea_cecode,ea_centre1, ea_durtn, ea_paprstr from public.eappl where ea_prcode = ? and ea_prno = ?";
				List data1 = executeFetchSql(getAdminDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
			
				if (data1 != null && data1.size() > 0) {
					//return (Map) data1.get(0);
			//		finaldata.put(exam, data1.get(0));
					
					for (int ii = 0; ii <= data1.size()-1; ii++) {
						String ex = new String("Exam"+(ii+1));
						finaldata.put(ex, data1.get(ii));
						
					}
				}
				
				
				
						
				return finaldata;
			}
		}
		return null;
	}
	
	//  Marksheet content
	public Map getMarkSheetContent(Map input) throws Exception  {
		Object prNum =  input.get("adpprNo");
		Object prCode =  input.get("adprCode");
		
	
		//Map finaldata = new HashMap();
		
		Map<String, Object> finaldata = new TreeMap<String, Object>();
		String admin = new String("Admin");
		String marks = new String("Marks");
		
		
	//	System.out.println(" INSIDE PRINT VIEW  getAdmInitimationetails--  going to run the SQL = "+prNum+","+prCode );
		
		if (prNum != null && prNum.toString().trim().length() > 0) {
			if((prCode != null && prCode.toString().trim().length() > 0)) {
				
				// Read from ADMIN table
				String getAdminDataSql = "select ad_name,ad_prcode,ad_prno,ad_dipcode from public.admn where ad_prcode = ? and ad_prno = ?";
				List data1 = executeFetchSql(getAdminDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
			
				if (data1 != null && data1.size() > 0) {
					//return (Map) data1.get(0);
					finaldata.put(admin, data1.get(0));
				}
				
				
				// Read form ADDRESS table
				String getAddressDataSql = "select ap_paper,ap_mark, ap_paprnam from public.appear where ap_prcode = ? and ap_prno = ?";
				List data5 = executeFetchSql(getAddressDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
			
				
				if (data5 != null && data5.size() > 0) {
					//return (Map) data2.get(0);
					for (int ii = 0; ii <= data5.size()-1; ii++) {
						String papers = new String("MarkList"+(ii+1));
						finaldata.put(papers, data5.get(ii));
						
					}
				}
				
						
				return finaldata;
			}
		}
		return null;
	}
	
//  diplomaCerti
	public Map getDiplomaCertiContent(Map input) throws Exception  {
		Object prNum =  input.get("adpprNo");
		Object prCode =  input.get("adprCode");
		
	
		Map finaldata = new HashMap();
		String admin = new String("Admin");
		String address = new String("Address");
		
		
	//	System.out.println(" INSIDE PRINT VIEW  getDiplomaCertiContent --  going to run the SQL = "+prNum+","+prCode );
		
		if (prNum != null && prNum.toString().trim().length() > 0) {
			if((prCode != null && prCode.toString().trim().length() > 0)) {
				
				// Read from ADMIN table
				String getAdminDataSql = "select ad_name,ad_prcode,ad_prno,ad_durtn,ad_dipcode from public.admn where ad_prcode = ? and ad_prno = ?";
				List data1 = executeFetchSql(getAdminDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
			
				if (data1 != null && data1.size() > 0) {
					//return (Map) data1.get(0);
					finaldata.put(admin, data1.get(0));
				}
				
//				// Read form ADDRESS table
//				String getAddressDataSql = "select * from public.staddr where sa_prcode = ? and sa_prno = ?";
//				List data2 = executeFetchSql(getAddressDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
//			
//				if (data2 != null && data2.size() > 0) {
//					//return (Map) data2.get(0);
//					finaldata.put(address, data2.get(0));
//				}
				
						
				return finaldata;
			}
		}
		return null;
	}
	
	///  TO BE mapped to UI
	
//  Question paperlist
	public Map getQuestionPaperList1(Map input) throws Exception  {
		Object QAsemMonthName =  input.get("QAsemMonthName");
		Object QAsemYearName =  input.get("QAsemYearName");
		Object QAexamCenterCode =  input.get("QAexamCenterCode");
		
		
		Map<String, Object> finaldata = new TreeMap<String, Object>();
		
//		String sesMonth = new String ("FEB");
//		String sesYear = new String("2006");
//		String center = new String("BHI");
		
		String sesMonth = new String ("");
    	 String sesYear = new String("");
    	String center = new String("");
    	
		if((QAexamCenterCode != null )) {
			center= QAexamCenterCode.toString();
			if(center.contains("/")) {
				int subcount = center.indexOf("/");
				center= center.substring(subcount+1);
				center= center.trim();
			}
		}
		      
     	 
        if (QAsemMonthName!=null) {
        	sesMonth = QAsemMonthName.toString();
        }
        
        if(QAsemYearName!=null) {
        	 sesYear = QAsemYearName.toString();;
         } 
        
//		String sesMonth = new String ("FEB");
//		String sesYear = new String("2006");
//		String center = new String("BHI");
		
		
	//	System.out.println(" INSIDE PRINT VIEW  getQuestionPaperList1 --  going to run the SQL = "+input.toString() );
		
		
		//tod0 check to be change
		if (sesMonth != null && sesMonth.trim().length() > 0) {
			if((sesYear != null)) {

				String getQuestionPapList = "SELECT count(EA_DIPCODE),EA_DIPCODE, EA_DURTN FROM PUBLIC.EAPPL WHERE EA_SESMON= ? AND EA_SESYR = ? AND EA_CECODE= ? GROUP BY EA_DIPCODE, EA_DURTN";
				List data2 = executeFetchSql(getQuestionPapList, new Object[]{sesMonth,Integer.parseInt(sesYear),center });

				if (data2 != null && data2.size() > 0) {
					for (int ii = 0; ii <= data2.size()-1; ii++) {
			
						String paper = new String("QPaper"+ii);
						finaldata.put(paper, data2.get(ii));
					}
				}
			
				
//				// Read from ADMIN table
//				String getAdminDataSql = "SELECT ea_dipcode,ea_name, ea_prcode, ea_prno, ea_paprstr FROM PUBLIC.EAPPL WHERE EA_SESMON=? AND EA_SESYR = ? AND EA_CECODE= ? AND EA_DIPCODE = ? AND EA_DURTN= ?";
//				List data1 = executeFetchSql(getAdminDataSql, new Object[]{sesMonth,Integer.parseInt(sesYear),center,dipCode, duration});
//			
//				if (data1 != null && data1.size() > 0) {
//					for (int ii = 0; ii <= data1.size()-1; ii++) {
//						String appList = new String("appList"+ii);
//						finaldata.put(appList, data1.get(ii));
//					}
//				}
						
				return finaldata;
			}
		}
		return null;
	}
	
	
//  Attendance Chart
	public Map getAttendanceChart(Map input) throws Exception  {
		Object ACsemMonthName =  input.get("ACsemMonthName");
		Object ACsemYearName =  input.get("ACsemYearName");
		Object ACduration =  input.get("ACduration");
		Object ACdiplomaCode =  input.get("ACdiplomaCode");
		Object ACexamCenterCode =  input.get("ACexamCenterCode");
	
		//Map finaldata = new HashMap();
		
		Map<String, Object> finaldata = new TreeMap<String, Object>();
		//String paperList = new String("paperList");
		
		
		//String admin = new String("Admin");
		//String address = new String("Address");
		
		// get hard code for now
		
//		String dipCode = new String ("FM");
//		String duration = new String("SIX MONTHS");
//		String sesMonth = new String ("FEB");
//		String sesYear = new String("2006");
//		String center = new String("BHI");
		
		String dipCode = new String ("");
		String duration = new String("");
		String sesMonth = new String ("");
		String sesYear = new String("");
		String center = new String("");
		
		if((ACsemMonthName != null )) {
			sesMonth= ACsemMonthName.toString();
		}
		if((ACsemYearName != null )) {
			sesYear= ACsemYearName.toString();
		}
		if((ACduration != null )) {
			duration= ACduration.toString();
		}
		if((ACdiplomaCode != null )) {
			dipCode= ACdiplomaCode.toString();
			if(dipCode.contains("/")) {
				int subcount = dipCode.indexOf("/");
				dipCode = dipCode.substring(0, subcount-1);
			}
		}
		if((ACexamCenterCode != null )) {
			center= ACexamCenterCode.toString();
			if(center.contains("/")) {
				int subcount = center.indexOf("/");
				center= center.substring(subcount+1);
				center= center.trim();
			}
		}
		
		
		
		
		
//		System.out.println(" INSIDE PRINT VIEW  getAttendanceChart--  going to run the SQL = "+dipCode);
//		System.out.println(" INSIDE PRINT VIEW  getAttendanceChart--  going to run the SQL = "+duration );
//		System.out.println(" INSIDE PRINT VIEW  getAttendanceChart--  going to run the SQL = "+sesMonth );
//		System.out.println(" INSIDE PRINT VIEW  getAttendanceChart--  going to run the SQL = "+sesYear);
//		System.out.println(" INSIDE PRINT VIEW  getAttendanceChart--  going to run the SQL = "+center );
//		
//		
//		System.out.println(" INSIDE PRINT VIEW  getAttendanceChart--  going to run the SQL = "+input.toString() );
		
		
		//tod0 check to be change
		if (dipCode != null && dipCode.trim().length() > 0) {
			if((duration != null && duration.trim().length() > 0)) {
				
				
				String getMarksDataSql = "SELECT DP_PAPERNO, DP_PAPRNAM FROM PUBLIC.DIPPAPER WHERE DP_DIPCODE =? AND DP_DURTN = ? GROUP BY DP_PAPERNO, DP_PAPRNAM";
				List data2 = executeFetchSql(getMarksDataSql, new Object[]{dipCode,duration });
			
				if (data2 != null && data2.size() > 0) {
					for (int ii = 0; ii <= data2.size()-1; ii++) {
			
						String paper = new String("Paper"+ii);
						finaldata.put(paper, data2.get(ii));
					}
				}
			
				
				// Read from ADMIN table
				String getAdminDataSql = "SELECT ea_dipcode,ea_name, ea_prcode, ea_prno, ea_paprstr FROM PUBLIC.EAPPL WHERE EA_SESMON=? AND EA_SESYR = ? AND EA_CECODE= ? AND EA_DIPCODE = ? AND EA_DURTN= ?";
				List data1 = executeFetchSql(getAdminDataSql, new Object[]{sesMonth,Integer.parseInt(sesYear),center,dipCode, duration});
			
				if (data1 != null && data1.size() > 0) {
					for (int ii = 0; ii <= data1.size()-1; ii++) {
						String appList = new String("appList"+ii);
						finaldata.put(appList, data1.get(ii));
					}
				}
						
				return finaldata;
			}
		}
		return null;
	}
	
	
	
//  applicants list
	public Map getApplicantslist(Map input) throws Exception  {
		
		Object ALsemMonthName =  input.get("ALsemMonthName");
		Object ALsemYearName =  input.get("ALsemYearName");
		Object ALexamCenterCode =  input.get("ALexamCenterCode");
		
		
	
		
		Map<String, Object> finaldata = new TreeMap<String, Object>();
		
	
			String semMonth = new String("");
			String semYear = new String ("");
			String center = new String ("");
			
			
			if (ALsemMonthName != null) {
				semMonth = ALsemMonthName.toString(); 
				semMonth = semMonth.trim();
			}
			if (ALsemYearName != null) {
				semYear = ALsemYearName.toString();
				semYear = semYear.trim();
			}
			
			if((ALexamCenterCode != null )) {
				center= ALexamCenterCode.toString();
				if(center.contains("/")) {
					int subcount = center.indexOf("/");
					center= center.substring(subcount+1);
					center= center.trim();
				}
			}
			

		//	System.out.println(" INSIDE PRINT VIEW  getApplicantslist- centre "+center);
		//	System.out.println(" INSIDE PRINT VIEW  getApplicantslist- semMonth"+semMonth);
		//	System.out.println(" INSIDE PRINT VIEW  getApplicantslist- semYear"+semYear);
		
		
		if (center != null && center.trim().length() > 0) {
			if((semYear != null && semMonth != null )) {
				
				// Read from ADMIN table
				String getAdminDataSql = "SELECT EA_DIPCODE, EA_PRCODE, EA_PRNO, EA_NAME, EA_STNAME, EA_DURTN, EA_PAPRSTR From public.EAPPL where EA_SESMON = ? AND EA_SESYR = ? and EA_CECODE = ?  GROUP BY EA_DIPCODE, EA_PRCODE, EA_PRNO, EA_NAME, EA_STNAME, EA_DURTN, EA_PAPRSTR";
				List data1 = executeFetchSql(getAdminDataSql, new Object[]{semMonth,Integer.parseInt(semYear),center  });
			
				if (data1 != null && data1.size() > 0) {
					for (int ii = 1; ii <= data1.size()-1; ii++) {
						String appList = new String("appList"+ii);
						finaldata.put(appList, data1.get(ii));
					}
				}
						
				return finaldata;
			}
		}
		return null;
	}
	
//  StudentAddress list
	
	public Map getStudentAddress(Map input) throws Exception  {
		
		Object StuAdrPRCode1 =  input.get("StuAdrPRCode1");
		Object StuAdrPRNo1 =  input.get("StuAdrPRNo1");
	
	
		
		Map<String, Object> finaldata = new TreeMap<String, Object>();
		
			
			String StuAdrPRCode2 = new String("");
			String StuAdrPRNo2 = new String ("");
			
			
			if (StuAdrPRCode1 != null) {
				StuAdrPRCode2 = StuAdrPRCode1.toString();
				StuAdrPRCode2 = StuAdrPRCode2.trim();
			}
			if (StuAdrPRNo1 != null) {
				StuAdrPRNo2 = StuAdrPRNo1.toString();
				StuAdrPRCode2 = StuAdrPRCode2.trim();
				
			}
			
			
			String adr = new String("Address");
		
		
	//	System.out.println(" INSIDE PRINT VIEW  getApplicantslist--  going to run the SQL = "+input.toString() );
	//	System.out.println(" INSIDE PRINT VIEW  getApplicantslist--  going to run the SQL = "+StuAdrPRCode2 );
	//.out.println(" INSIDE PRINT VIEW  getApplicantslist--  going to run the SQL = "+StuAdrPRNo2 );
		
		
		
				// Read from ADDRESS table
				String getAddressDataSql = "select * from public.staddr where sa_prcode = ? and sa_prno = ?";
				List data1 = executeFetchSql(getAddressDataSql, new Object[]{StuAdrPRCode2,Integer.parseInt(StuAdrPRNo2) });
							
				if (data1 != null && data1.size() > 0) {
					//return (Map) data1.get(0);
					finaldata.put(adr, data1.get(0));
				}
						
				return finaldata;
			
	}
		
//  StudentAddress list
	
	public Map getStudentAddressByCentre(Map input) throws Exception  {
		
		Object ALsemMonthName1 =  input.get("ALsemMonthName1");
		Object ALsemYearName1 =  input.get("ALsemYearName1");
		Object ALexamCenterCode1 =  input.get("ALexamCenterCode1");
	
		
		Map<String, Object> finaldata = new TreeMap<String, Object>();
		Map<String, Object> prdata = new TreeMap<String, Object>();
		
			
			String semMonth = new String("");
			String semYear = new String ("");
			String center = new String ("");
			
			
			if (ALsemMonthName1 != null) {
				semMonth = ALsemMonthName1.toString();
				semMonth =semMonth.trim();
			}
			if (ALsemYearName1 != null) {
				semYear = ALsemYearName1.toString();
				semYear= semYear.trim();
			}
			
			
			if((ALexamCenterCode1 != null )) {
				center= ALexamCenterCode1.toString();
				if(center.contains("/")) {
					int subcount = center.indexOf("/");
					center= center.substring(subcount+1);
					center= center.trim();
				}
			}
			
			String adr = new String("Address");
			String sqlAddress = new String("");
			List finadata1 = null; 
		
		
	//	System.out.println(" INSIDE PRINT VIEW  getApplicantslist--  going to run the SQL = "+input.toString() );
		
	//	System.out.println(" INSIDE PRINT VIEW  getApplicantslist--  going to run the  centre SQL = "+center );
	//.out.println(" INSIDE PRINT VIEW  getApplicantslist--  going to run the  semYear SQL = "+semYear );
	//	System.out.println(" INSIDE PRINT VIEW  getApplicantslist--  going to run the  semYear semMonthSQL = "+semMonth );
		   ObjectMapper oMapper = new ObjectMapper();
		   String prCode = new String ("");
			String prNo = new String ("");
			
				// Read from ADDRESS table
				String getAddressDataSql = "select EA_PRCODE, EA_PRNO from public.EAPPL where EA_SESMON =? and EA_SESYR  = ? and EA_CECODE = ?";
				List data1 = executeFetchSql(getAddressDataSql, new Object[]{semMonth,Integer.parseInt(semYear),center });
				
			//	System.out.println(" RAJKUMAR  Address 1 QUERY  size--------------"+data1.toString());
							
				if (data1 != null && data1.size() > 0) {
					for (int ii = 1; ii <= data1.size()-1; ii++) {
						Object adddata = data1.get(ii);
						
						//Object val = data.get(key);
						Map<String, Object> map1 = oMapper.convertValue(adddata, Map.class);
					//	System.out.println(" RAJKUMAR  Address 1 list possint"+ii);
						
						//System.out.println(" RAJKUMAR  Address 1 map value"+map1.toString());
						//System.out.println(" RAJKUMAR  Address 1 map size"+map1.size());
						
						
						
					  
						
						Object prcodeObj = map1.get("ea_prcode");
						
					//	System.out.println(" RAJKUMAR  Address 3"+prcodeObj.toString());
						
					    	if(prcodeObj!=null) {
					    		prCode = prcodeObj.toString();
					    	}
					    	
					    	Object prNoObj = map1.get("ea_prno");
					    	if(prNoObj!=null) {
					    		prNo = prNoObj.toString();
					    	}	
					    	
											
						
						sqlAddress = "select * from public.staddr where sa_prcode = ? and sa_prno = ?";
						finadata1 = executeFetchSql(sqlAddress, new Object[]{prCode, Integer.parseInt(prNo) });
						
						//System.out.println(" INSIDE adress 2nd query result  = "+finadata1.toString());
						
						if (finadata1 != null && finadata1.size() > 0) {
							//return (Map) data1.get(0);
							//String addList = new String("address"+);
							finaldata.put("Address"+ii, finadata1.get(0));
						}
						//prdata.put(appList, finadata1.get(ii));
					}
				}
				
			//	System.out.println(" RAJKUMAR  Address 2 QUERY  size--------------"+finaldata.size());
				
			//	System.out.println(" INSIDE PRINT VIEW  KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK centre SQL = "+finaldata.toString() );
						
				return finaldata;
			
	}
}


