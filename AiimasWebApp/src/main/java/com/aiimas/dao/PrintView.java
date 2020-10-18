package com.aiimas.dao;


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
		
		System.out.println(" INSIDE PRINT VIEW DAO getAdmInitimationetails");

		Object adprCode = input.get("adprCode");
		Object adpprNo = input.get("adpprNo");
		
		//System.out.println(" INSIDE getInstituteDetails  --------------------"+insituteCode.toString());
	
		String getAdmInstitSql = "select * from public.ADMIN where AD_PRCODE = ? and AD_PRNO= ?"; 
		
		List data1 = executeFetchSql(getAdmInstitSql, new Object[]{adprCode.toString(),Integer.parseInt(adpprNo.toString()) });
	
		System.out.println(" INSIDE getAdmInstitSql --  going to run result = "+data1 );
		
		if (data1 != null && data1.size() > 0) {
			return (Map) data1.get(0);
		}
		return null;
		
	}
		

}


