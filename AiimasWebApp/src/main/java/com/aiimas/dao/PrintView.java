package com.aiimas.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PrintView extends BaseDao {

		
	public List getQuestions(Map input) throws Exception  {
		
		System.out.println(" INSIDE PRINT VIEW DAO getQuestions ");
		
		Object diplomaCode1 =  input.get("diplomaCode1");
	
		String getDiplomaDataSql = "select * from public.QAIIMS where Q_DIPCODE = ?";
		List data1 = executeFetchSql(getDiplomaDataSql, new Object[]{diplomaCode1.toString() });
	
		System.out.println(" INSIDE getDiplomaDetails --  going to run result = "+data1 );
		
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
		
		System.out.println(" INSIDE PRINT VIEW  getAdmInitimationetails--  going to run the SQL = "+prNum+","+prCode );
		
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
		
		System.out.println(" INSIDE PRINT VIEW  getAcknowledgeContent--  going to run the SQL = "+prNum+","+prCode );
		
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
		
		
		System.out.println(" INSIDE PRINT VIEW  getAdmInitimationetails--  going to run the SQL = "+prNum+","+prCode );
		
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
		String admin = new String("Admin");
		String address = new String("Address");
		
		
		System.out.println(" INSIDE PRINT VIEW  getAdmInitimationetails--  going to run the SQL = "+prNum+","+prCode );
		
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
	
	//  Marksheet content
	public Map getMarkSheetContent(Map input) throws Exception  {
		Object prNum =  input.get("adpprNo");
		Object prCode =  input.get("adprCode");
		
	
		Map finaldata = new HashMap();
		String admin = new String("Admin");
		String address = new String("Address");
		
		
		System.out.println(" INSIDE PRINT VIEW  getAdmInitimationetails--  going to run the SQL = "+prNum+","+prCode );
		
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
	
//  diplomaCerti
	public Map getDiplomaCertiContent(Map input) throws Exception  {
		Object prNum =  input.get("adpprNo");
		Object prCode =  input.get("adprCode");
		
	
		Map finaldata = new HashMap();
		String admin = new String("Admin");
		String address = new String("Address");
		
		
		System.out.println(" INSIDE PRINT VIEW  getDiplomaCertiContent --  going to run the SQL = "+prNum+","+prCode );
		
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
	
	///  TO BE mapped to UI
	
//  Question paperlist
	public Map getQuestionPaperList1(Map input) throws Exception  {
		Object QAsemMonthName =  input.get("QAsemMonthName");
		Object QAsemYearName =  input.get("QAsemYearName");
		Object QAexamCenterCode =  input.get("QAexamCenterCode");
		
		
		Map<String, Object> finaldata = new TreeMap<String, Object>();
		
		String sesMonth = new String ("FEB");
		String sesYear = new String("2006");
		String center = new String("BHI");
		
		
		System.out.println(" INSIDE PRINT VIEW  getQuestionPaperList1 --  going to run the SQL = "+input.toString() );
		
		
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
		
		String dipCode = new String ("FM");
		String duration = new String("SIX MONTHS");
		String sesMonth = new String ("FEB");
		String sesYear = new String("2006");
		String center = new String("BHI");
		
		
		System.out.println(" INSIDE PRINT VIEW  getAttendanceChart--  going to run the SQL = "+input.toString() );
		
		
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
		
			
		// get hard code for now
//		String sesMonth = new String ("AUG");
//		String sesYear = new String("2020");
		
			String sesMonth = new String ("");
			String sesYear = new String("");
			
			
		//	sesMonth
		//	sesMonth = ALsemMonthName.toString()
		
		
		System.out.println(" INSIDE PRINT VIEW  getApplicantslist--  going to run the SQL = "+input.toString() );
		
		if (sesMonth != null && sesMonth.trim().length() > 0) {
			if((sesYear != null)) {
				
				// Read from ADMIN table
				String getAdminDataSql = "SELECT EA_DIPCODE, EA_PRCODE, EA_PRNO, EA_NAME, EA_STNAME, EA_DURTN, EA_PAPRSTR From public.EAPPL where EA_SESMON = ? AND EA_SESYR = ? GROUP BY EA_DIPCODE, EA_PRCODE, EA_PRNO, EA_NAME, EA_STNAME, EA_DURTN, EA_PAPRSTR";
				List data1 = executeFetchSql(getAdminDataSql, new Object[]{sesMonth,Integer.parseInt(sesYear) });
			
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
	
	
		

}


