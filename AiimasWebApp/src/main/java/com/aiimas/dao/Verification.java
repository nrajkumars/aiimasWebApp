package com.aiimas.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Verification extends BaseDao {

	
	
	
	
	public Map getVerficationFULLDetail1(Map input) {
		Object prNum =  input.get("prNum");
		Object prCode =  input.get("prCode");
		
	
		Map finaldata = new HashMap();
		String admin = new String("Admin");
		String address = new String("Address");
		String fee = new String("Fee");
		String exam = new String("Exam");
		
		System.out.println(" INSIDE VERIFICATION --  going to run the SQL = "+prNum+","+prCode );
		
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
				
				
				// Read form Exam table
				String getExamsDataSql = "select * from public.staddr where sa_prcode = ? and sa_prno = ?";
				List data4 = executeFetchSql(getExamsDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
			
				if (data4 != null && data4.size() > 0) {
					//return (Map) data2.get(0);
					finaldata.put(exam, data4.get(0));
				}
				
				// Read form Marks table
				String getMarksDataSql = "select * from public.appear where ap_prcode = ? and ap_prno = ?";
				List data5 = executeFetchSql(getMarksDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
			
				if (data5 != null && data5.size() > 0) {
					//return (Map) data2.get(0);
					for (int ii = 1; ii <= data5.size()-1; ii++) {
						String marks = new String("Marks"+ii);
						finaldata.put(marks, data5.get(ii));
						
					}
				}
				
				return finaldata;
			}
		}
		return null;
	}
	
	// search by NAME
	//select * from public.admn where ad_name LIKE '%APR1%'
	
	public Map getVerficationByName(Map input) {
		Object studentName =  input.get("studentName");
	//	Object prCode =  input.get("prCode");
		
	
		Map finaldata = new HashMap();
		
		if (studentName != null && studentName.toString().trim().length() > 0) {
		//	if((prCode != null && prCode.toString().trim().length() > 0)) {
				
				String studentNameNew = studentName.toString();
				studentNameNew= "%"+studentNameNew+"%";
					
				System.out.println(" INSIDE VERIFICATION BY NAME --  going to run the SQL = "+studentNameNew);
				
				// Read form Admn table by name search
				String getMarksDataSql = "select ad_dipcode,ad_prcode, ad_prno, ad_name from public.admn where ad_name LIKE ? LIMIT 10";
				List data5 = executeFetchSql(getMarksDataSql, new Object[]{studentNameNew});
			
				if (data5 != null && data5.size() > 0) {
					//return (Map) data2.get(0);
					for (int ii = 1; ii <= data5.size()-1; ii++) {
						String marks = new String(" by NAME "+ii);
						finaldata.put(marks, data5.get(ii));
						
					}
				}
				
				return finaldata;
			}
		//}
		return null;
	}
	
	
}

