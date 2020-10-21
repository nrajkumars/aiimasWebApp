package com.aiimas.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarkUpdate extends BaseDao {
	
	
	// GET Exam details
		public Map getMarkDetails(Map input) {
			Object prNum =  input.get("prNum");
			Object prCode =  input.get("prCode");
			
		
			Map finaldata = new HashMap();
			String admin = new String("Admin");
			
			//String fee = new String("Fee");
			
			System.out.println(" INSIDE getMarkDetails --  going to run the SQL = "+prNum+","+prCode );
			
			if (prNum != null && prNum.toString().trim().length() > 0) {
				if((prCode != null && prCode.toString().trim().length() > 0)) {
					
					// Read from ADMIN table
					String getAdminDataSql = "select * from public.admn where ad_prcode = ? and ad_prno = ?";
					List data1 = executeFetchSql(getAdminDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
				
					if (data1 != null && data1.size() > 0) {
						//return (Map) data1.get(0);
						finaldata.put(admin, data1.get(0));
					}
					
					// Read form Marks table
					String getMarksDataSql = "select * from public.appear where ap_prcode = ? and ap_prno = ?";
					List data2 = executeFetchSql(getMarksDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
				
					if (data2 != null && data2.size() > 0) {
						//return (Map) data2.get(0);
						for (int ii = 1; ii <= data2.size()-1; ii++) {
							String marks = new String("Marks"+ii);
							finaldata.put(marks, data2.get(ii));
							System.out.println(" INSIDE getMarkDetails MARKS - "+ii);  
						}
					}
					
//					//// Read form Fee table
//					String getFeeDataSql = "select * from public.fees where fe_prcode = ? and fe_prno = ?";
//					List data3 = executeFetchSql(getFeeDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
//				
//					if (data3 != null && data3.size() > 0) {
//						//return (Map) data3.get(0);
//						finaldata.put(fee, data3.get(0));
//					}
					
					return finaldata;
				}
			}
			return null;
		}
		
		
	}


