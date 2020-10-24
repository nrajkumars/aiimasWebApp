package com.aiimas.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ExamApplication extends BaseDao {
	
	
	// GET Exam details
		public Map getExamDetails(Map input) throws Exception  {
			Object prNum =  input.get("prNum");
			Object prCode =  input.get("prCode");
			
		
			Map finaldata = new HashMap();
			String admin = new String("Admin");
			String exam = new String("Exam");
			//String fee = new String("Fee");
			
			System.out.println(" INSIDE getExamDetails --  going to run the SQL = "+prNum+","+prCode );
			
			if (prNum != null && prNum.toString().trim().length() > 0) {
				if((prCode != null && prCode.toString().trim().length() > 0)) {
					
					// Read from ADMIN table
					String getAdminDataSql = "select * from public.admn where ad_prcode = ? and ad_prno = ?";
					List data1 = executeFetchSql(getAdminDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
				
					if (data1 != null && data1.size() > 0) {
						//return (Map) data1.get(0);
						finaldata.put(admin, data1.get(0));
					}
					
					// Read form Exam table
					String getExamsDataSql = "select * from public.staddr where sa_prcode = ? and sa_prno = ?";
					List data2 = executeFetchSql(getExamsDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
				
					if (data2 != null && data2.size() > 0) {
						//return (Map) data2.get(0);
						finaldata.put(exam, data2.get(0));
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
		
		
		//insert EXAM
		
		public void insertExam(Map data) throws Exception {
			
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
			
			// NOT INSERTED EA_PRNUM = CODE+NO		 AND END TIME
			//TOTAL 21 -2 = 19 ?
			
			//todo
			//examStateCodenew,examStateCode
			//examCenterCodeNew, examCenterCode
			//todo
			String examCenterCodeNew = "TE";
			String examStateCodenew ="TE";
			String examStateNamenew = "STATENAME";
			String examCenterNameNew ="CENTERNAME";
			
			String insertExamSQL = "insert into public.EAPPL (EA_DIPCODE, EA_PRCODE, EA_PRNO, EA_SESMON, EA_SESYR, EA_NAME, EA_STCODE, EA_STNAME, EA_CECODE, EA_CENTRE1, EA_NOFPAPR, EA_PAPRSTR, EA_SEMSTR, EA_DURTN, NEWNOFPAPR, OLDNOFPAPR, EA_TOTAPPR, EA_PASSFLG, EA_ENTDATE) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			executeUpdate(insertExamSQL, new Object[]{newDipCode,prCodeExam.toString(),Integer.parseInt(prNoExam.toString()),semMonthExam.toString(),Integer.parseInt(semYearExam.toString()),stuNameExam.toString(),examStateCodenew ,examStateNamenew, examCenterCodeNew, examCenterNameNew, Integer.parseInt(noofPaperExam.toString()),examPapers.toString(), examSemstr.toString(), durationExam.toString(),Integer.parseInt(examNewnoPapers.toString()),Integer.parseInt(examOldnoPapers.toString()),Integer.parseInt(examTotalPaper.toString()),Integer.parseInt(examPassFlag.toString()),enterDateExamnew});
			
			System.out.println(" INSIDE insert EXAM SUCCESS");
			
			
		}
	}


