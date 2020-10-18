package com.aiimas.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintView extends BaseDao {

		
	public List getQuestions(Map input) {
		
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
	
	
	
	
	public Map getAdmInitimationetails(Map input) {
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
				String getAdminDataSql = "select * from public.admin where ad_prcode = ? and ad_prno = ?";
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
	
	public Map getAcknowledgeContent(Map input) {
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
				String getAdminDataSql = "select * from public.admin where ad_prcode = ? and ad_prno = ?";
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
				
				//// Read form Fee table  TODO HANGE to exam table
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
	
	public Map getAnswerSheetAcknowledge(Map input) {
		Object prNum =  input.get("adpprNo");
		Object prCode =  input.get("adprCode");
		
	
		Map finaldata = new HashMap();
		String admin = new String("Admin");
		String address = new String("Address");
		
		
		System.out.println(" INSIDE PRINT VIEW  getAdmInitimationetails--  going to run the SQL = "+prNum+","+prCode );
		
		if (prNum != null && prNum.toString().trim().length() > 0) {
			if((prCode != null && prCode.toString().trim().length() > 0)) {
				
				// Read from ADMIN table
				String getAdminDataSql = "select * from public.admin where ad_prcode = ? and ad_prno = ?";
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
	public Map getHallTicketContent(Map input) {
		Object prNum =  input.get("adpprNo");
		Object prCode =  input.get("adprCode");
		
	
		Map finaldata = new HashMap();
		String admin = new String("Admin");
		String address = new String("Address");
		
		
		System.out.println(" INSIDE PRINT VIEW  getAdmInitimationetails--  going to run the SQL = "+prNum+","+prCode );
		
		if (prNum != null && prNum.toString().trim().length() > 0) {
			if((prCode != null && prCode.toString().trim().length() > 0)) {
				
				// Read from ADMIN table
				String getAdminDataSql = "select * from public.admin where ad_prcode = ? and ad_prno = ?";
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
	
	public Map getMarkSheetContent(Map input) {
		Object prNum =  input.get("adpprNo");
		Object prCode =  input.get("adprCode");
		
	
		Map finaldata = new HashMap();
		String admin = new String("Admin");
		String address = new String("Address");
		
		
		System.out.println(" INSIDE PRINT VIEW  getAdmInitimationetails--  going to run the SQL = "+prNum+","+prCode );
		
		if (prNum != null && prNum.toString().trim().length() > 0) {
			if((prCode != null && prCode.toString().trim().length() > 0)) {
				
				// Read from ADMIN table
				String getAdminDataSql = "select * from public.admin where ad_prcode = ? and ad_prno = ?";
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
		

}


