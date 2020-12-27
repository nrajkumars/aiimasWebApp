package com.aiimas.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Verification extends BaseDao {

	
	
	
	
	public Map getVerficationFULLDetail1(Map input) throws Exception  {
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
				String getExamsDataSql = "select * from public.EAPPL where ea_prcode = ? and ea_prno = ?";
				List data4 = executeFetchSql(getExamsDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
			
				if (data4 != null && data4.size() > 0) {
					//return (Map) data2.get(0);
					finaldata.put(exam, data4.get(0));
				}
				
//				// Read form Marks table
//				String getMarksDataSql = "select * from public.appear where ap_prcode = ? and ap_prno = ?";
//				List data5 = executeFetchSql(getMarksDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
//			
//				if (data5 != null && data5.size() > 0) {
//					//return (Map) data2.get(0);
//					for (int ii = 0; ii <= data5.size()-1; ii++) {
//						String marks = new String("Marks"+ii);
//						finaldata.put(marks, data5.get(ii));
//						
//					}
//				}
				
				return finaldata;
			}
		}
		return null;
	}
	
	// search by NAME
	//select * from public.admn where ad_name LIKE '%APR1%'
	
	public Map getVerficationByName(Map input) throws Exception  {
		Object studentName =  input.get("prcdnoNamesearch");
		Object prcdnoDipCodeName =  input.get("prcdnoDipCodeName");
		Object prcdnosemMonthName =  input.get("prcdnosemMonthName");
		Object prcdnosemYearName =  input.get("prcdnosemYearName");
		
	
		Map finaldata = new HashMap();
		String countPr  = new String("countPr");
		
		if (studentName != null && studentName.toString().trim().length() > 0) {
		//	if((prCode != null && prCode.toString().trim().length() > 0)) {
				
				String studentNameNew = studentName.toString();
				String prcdnoDipCode = "";
				String prcdnosemMonth = "";
				String prcdnosemYear = "";
						
				
			
					
			
				
				if((prcdnosemYearName != null && prcdnosemYearName.toString().trim().length() > 0)) {
					prcdnosemYear =prcdnosemYearName.toString();
				}else {
					prcdnosemYear="0";
				}
				
				if((prcdnosemMonthName != null && prcdnosemMonthName.toString().trim().length() > 0)) {
					prcdnosemMonth =prcdnosemMonthName.toString();
				}
				
				
				if((prcdnoDipCodeName != null && prcdnoDipCodeName.toString().trim().length() > 0)) {
					prcdnoDipCode =prcdnoDipCodeName.toString();
					if(prcdnoDipCode.contains("/")) {
						int subcount = prcdnoDipCode.indexOf("/");
						prcdnoDipCode = prcdnoDipCode.substring(0, subcount-1);
					}
				}
				
				System.out.println(" INSIDE VERIFICATION BY NAME --  going to run the SQL = "+studentNameNew);
				System.out.println(" INSIDE prcdnoDipCode BY NAME --  going to run the SQL = "+prcdnoDipCode);
				System.out.println(" INSIDE prcdnosemMonth BY NAME --  going to run the SQL = "+prcdnosemMonth);
				System.out.println(" INSIDE prcdnosemYear BY NAME --  going to run the SQL = "+prcdnosemYear);
				
				
				// CREATE SQL 
				String getPRDataSqlNEW =  "select ad_dipcode,ad_prcode, ad_prno, ad_name from public.admn where ad_name LIKE ? LIMIT 5";
				String getPRDataSqlCOUNT =  "select COUNT(ad_prcode) from public.admn where ad_name LIKE ?";
				Object[] SQLValue =  new Object[]{studentNameNew};
				
				//new Object[]{studentNameNew,prcdnoDipCode,prcdnosemMonth,Integer.parseInt(prcdnosemYear)});
				// "and ad_dipcode= ? and ad_sesmon =? and ad_sesyr =? LIMIT 5";
				//new Object[]{studentNameNew,prcdnoDipCode,prcdnosemMonth,Integer.parseInt(prcdnosemYear)});
				
				if((prcdnoDipCode != null && prcdnoDipCode.toString().trim().length() > 0)) {
					getPRDataSqlNEW =  "select ad_dipcode,ad_prcode, ad_prno, ad_name from public.admn where ad_name LIKE ? and ad_dipcode= ? LIMIT 5";
					getPRDataSqlCOUNT =  "select COUNT(ad_prcode) from public.admn where ad_name LIKE ? and ad_dipcode= ?";
					SQLValue =  new Object[]{studentNameNew,prcdnoDipCode};
					
					if((prcdnosemMonth != null && prcdnosemMonth.toString().trim().length() > 0)) {
						getPRDataSqlNEW =  "select ad_dipcode,ad_prcode, ad_prno, ad_name from public.admn where ad_name LIKE ? and ad_dipcode= ? and ad_sesmon = ? LIMIT 5";
						getPRDataSqlCOUNT =  "select COUNT(ad_prcode) from public.admn where ad_name LIKE ? and ad_dipcode= ? and ad_sesmon = ?";
						SQLValue =  new Object[]{studentNameNew,prcdnoDipCode,prcdnosemMonth};
						
						if((prcdnosemYear != null && prcdnosemYear.toString().trim().length() > 3)) {
							getPRDataSqlNEW =  "select ad_dipcode,ad_prcode, ad_prno, ad_name from public.admn where ad_name LIKE ? and ad_dipcode= ? and ad_sesmon = ? and ad_sesyr = ? LIMIT 5";
							getPRDataSqlCOUNT =  "select COUNT(ad_prcode) from public.admn where ad_name LIKE ? and ad_dipcode= ? and ad_sesmon = ? and ad_sesyr = ? ";
							SQLValue =  new Object[]{studentNameNew,prcdnoDipCode, prcdnosemMonth, Integer.parseInt(prcdnosemYear)};
						}
					}
					
				}else if((prcdnosemMonth != null && prcdnosemMonth.toString().trim().length() > 0)) {
					getPRDataSqlNEW =  "select ad_dipcode,ad_prcode, ad_prno, ad_name from public.admn where ad_name LIKE ? and  ad_sesmon = ? LIMIT 5";
					getPRDataSqlCOUNT =  "select COUNT(ad_prcode) from public.admn where ad_name LIKE ? and  ad_sesmon = ?";
					SQLValue =  new Object[]{studentNameNew,prcdnosemMonth};
					
					if((prcdnosemYear != null && prcdnosemYear.toString().trim().length() > 0)) {
						getPRDataSqlNEW =  "select ad_dipcode,ad_prcode, ad_prno, ad_name from public.admn where ad_name LIKE ? and ad_sesmon = ? and ad_sesyr = ? LIMIT 5";
						getPRDataSqlCOUNT =  "select COUNT(ad_prcode) from public.admn where ad_name LIKE ? and ad_sesmon = ? and ad_sesyr = ? ";
						SQLValue =  new Object[]{studentNameNew, prcdnosemMonth, Integer.parseInt(prcdnosemYear)};
					}
				}else if((prcdnosemYear != null && prcdnosemYear.toString().trim().length() > 3)) {
					getPRDataSqlNEW =  "select ad_dipcode,ad_prcode, ad_prno, ad_name from public.admn where ad_name LIKE ? and ad_sesyr= ? LIMIT 5";
					getPRDataSqlCOUNT =  "select COUNT(ad_prcode) from public.admn where ad_name LIKE ? and ad_sesyr = ? ";
					SQLValue =  new Object[]{studentNameNew, Integer.parseInt(prcdnosemYear)};
				}
				
				System.out.println(" INSIDE getPRDataSqlNEW = "+getPRDataSqlNEW);
				System.out.println(" INSIDE SQLValue= "+SQLValue.toString());
				
				
				// Read form Exam table
			//	String getPRDataSql = "select COUNT(ad_prcode) from public.admn where ad_name LIKE ?";
				List datapr = executeFetchSql(getPRDataSqlCOUNT, SQLValue);
			
				if (datapr != null && datapr.size() > 0) {
					//return (Map) data2.get(0);
					finaldata.put(countPr, datapr.get(0));
				}
				
				// Read form Admn table by name search
			//	String getPR1DataSql = "select ad_dipcode,ad_prcode, ad_prno, ad_name from public.admn where ad_name LIKE ? and ad_dipcode= ? and ad_sesmon =? and ad_sesyr =? LIMIT 5";
				List data5 = executeFetchSql(getPRDataSqlNEW, SQLValue);
				
			
				if (data5 != null && data5.size() > 0) {
					//return (Map) data2.get(0);
					for (int ii = 0; ii <= data5.size()-1; ii++) {
						String prvalue = new String("prvalue"+ii);
						finaldata.put(prvalue, data5.get(ii));
						
					}
				}
				
				return finaldata;
			}
		//}
		return null;
	}
	
	
}

