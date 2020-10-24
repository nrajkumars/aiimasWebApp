package com.aiimas.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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
		
		
		//insert MARK
		
				public void insertMark(Map data) {
					try {
					
					
						Object prCodeExam = data.get("prCodeExam");
						Object prNoExam = data.get("prNoExam");
						Object diplomaCodeExam = data.get("diplomaCodeExam");
						Object durationExam = data.get("durationExam");
						Object noofPaperExam = data.get("noofPaperExam");
						Object semMonthExam = data.get("semMonthExam");
						Object semYearExam = data.get("semYearExam");
						Object enterDateExam = data.get("enterDateExam");
						Object stuNameExam = data.get("stuNameExam");
						Object examStateCode = data.get("examStateCode");
						Object examCenterCode = data.get("examCenterCode");
						Object examPapers = data.get("examPapers");
						Object examSemstr = data.get("examSemstr");
						Object examNewnoPapers = data.get("examNewnoPapers");
						Object examOldnoPapers = data.get("examOldnoPapers");
						Object examTotalPaper = data.get("examTotalPaper");
						Object examPassFlag = data.get("examPassFlag");
					
					System.out.println("RRRRRRRRRRRRRRRRRR -"+diplomaCodeExam);
					String newDipCode =  diplomaCodeExam.toString();
					int subcount = newDipCode.indexOf("/");
					System.out.println("RRRRRRRRRRRRRRRRRR - "+subcount);
					newDipCode = newDipCode.substring(0, subcount-1);
					
					System.out.println("RRRRRRRRRRRRRRRRRR  2222    -"+newDipCode);
					
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
					Date enterDateExamnew = null;
					
					if((enterDateExam != null && enterDateExam.toString().trim().length() > 8)) {
						enterDateExamnew = formatter.parse(enterDateExam.toString());
					}
					
					
					
					if((examNewnoPapers != null && examNewnoPapers.toString().trim().length() > 0)) {
						//System.out.println(" INSIDE if paidamt"+paidamt);
					}else {
						examNewnoPapers="0";
					}
					
					if((examOldnoPapers != null && examOldnoPapers.toString().trim().length() > 0)) {
						//System.out.println(" INSIDE if  papers "+papers);
					}else {
						examOldnoPapers="0";
					}
					
					if((examTotalPaper != null && examTotalPaper.toString().trim().length() > 0)) {
						//System.out.println(" INSIDE if  totfee"+totfee);
					}else {
						examTotalPaper="0";
					}
					
					if((examPassFlag != null && examPassFlag.toString().trim().length() > 0)) {
						//System.out.println(" INSIDE if  semYear"+semYear);
					}else {
						examPassFlag="0";
					}
					
					if((noofPaperExam != null && noofPaperExam.toString().trim().length() > 0)) {
						//System.out.println(" INSIDE if  papers "+papers);
					}else {
						noofPaperExam="0";
					}
					
					if((semYearExam != null && semYearExam.toString().trim().length() > 0)) {
						//System.out.println(" INSIDE if  pincode "+pincode);
					}else {
						semYearExam="0";
					}
					
							
				//	String insertAddAdm = "insert into public.ADMN (AD_DIPCODE, AD_PRCODE, AD_PRNO, AD_SESMON, AD_SESYR, AD_NAME,AD_NOFPAPR, AD_FEEAMT, AD_DURTN, AD_PAIDAMT,AD_FEEDATE, AD_ENTDATE) values(?,?,?,?,?,?,?,?,?,?,?,?);";
					//executeUpdate(insertAddAdm, new Object[]{newDipCode,prCode11.toString(),Integer.parseInt(prNo1.toString()),semMonth.toString(),Integer.parseInt(semYear.toString()),stuName.toString(),Integer.parseInt(papers.toString()),Integer.parseInt(totfee.toString()), duration.toString(), Integer.parseInt(paidamt.toString()),feeDuedate,enterDatef });
					
					System.out.println(" INSIDE insert MARK SUCCESS");
					
					}catch( Exception ex) {
						System.out.println(" INSIDE insert MARK ERROR  -"+ex.toString());
					ex.printStackTrace();
				}
				}
		
		
	}

