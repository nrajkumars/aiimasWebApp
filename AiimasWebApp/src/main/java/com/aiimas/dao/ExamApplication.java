package com.aiimas.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class ExamApplication extends BaseDao {
	
	
	// GET Exam details
		public Map getExamDetails(Map input) throws Exception  {
			Object prNum =  input.get("prNum");
			Object prCode =  input.get("prCode");
			
		
			//Map finaldata = new HashMap();
			Map<String, Object> finaldata = new TreeMap<String, Object>();
			String admin = new String("Admin");
			String exam = new String("Exam");
		
			System.out.println(" INSIDE getExamDetails --  going to run the SQL = "+prNum+","+prCode );
			
			if (prNum != null && prNum.toString().trim().length() > 0) {
				if((prCode != null && prCode.toString().trim().length() > 0)) {
					
					// Read from ADMIN table
					String getAdminDataSql = "select ad_dipcode, ad_name, ad_durtn, ad_nofpapr from public.admn where ad_prcode = ? and ad_prno = ?";
					List data1 = executeFetchSql(getAdminDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
				
					if (data1 != null && data1.size() > 0) {
						finaldata.put(admin, data1.get(0));
					}
					
//					// Read form state table
					String getStateDataSql = "select * from public.state";
					List data2 = executeFetchSql(getStateDataSql);
				
					if (data2 != null && data2.size() > 0) {
						for (int ii = 0; ii <= data2.size()-1; ii++) {
							String state = new String("State"+ii);
							finaldata.put(state, data2.get(ii));
							
						}
					}
					
					//// Read form Center table
					String getCenterDataSql = "select * from public.centre";
					List data3 = executeFetchSql(getCenterDataSql);
				
					if (data3 != null && data3.size() > 0) {
						for (int ii = 0; ii <= data3.size()-1; ii++) {
							String centre = new String("Centre"+ii);
							finaldata.put(centre, data3.get(ii));
							
						}
					}
					
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
				Object examCenterCodeNew = data.get("examStateCode");
				Object examStateCodenew = data.get("examCenterCode");
				
				Object examStateNamenew = data.get("examStateName");
				Object examCenterNameNew = data.get("examCenterName");
				
				
				
				Object ackIniLetterDate = data.get("ackIniLetterDate");
				Object ackHallTckDate = data.get("ackHallTckDate");
				Object ackExamdate1 = data.get("ackExamdate1");
				Object ackExamdate2 = data.get("ackExamdate2");
				
				
				Object examPapers = data.get("ea_paprstr");
				
		
				
				
				Object examNewnoPapers = data.get("noofPaperExam");
				
				Object examOldnoPapers = data.get("oldnofpapr");
				
				
				
			//	Object examTotalPaper = data.get("examTotalPaper");
			//	Object examPassFlag = data.get("examPassFlag");
				
				
			
			System.out.println("RRRRRRRRRRRRRRRRRR -"+diplomaCodeExam);
			String newDipCode =  diplomaCodeExam.toString();
			int subcount = newDipCode.indexOf("/");
			System.out.println("RRRRRRRRRRRRRRRRRR - "+subcount);
			newDipCode = newDipCode.substring(0, subcount-1);
			
			System.out.println("RRRRRRRRRRRRRRRRRR  2222 HAL ticket    -"+ackHallTckDate);
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			Date enterDateExamnew = null;
			
			
			
			Date ackIniLetterDateNew = null;
			Date ackHallTckDateNew = null;
			Date ackExamdate1New = null;
			Date ackExamdate2New = null;
			
			if((enterDateExam != null && enterDateExam.toString().trim().length() > 8)) {
				enterDateExamnew = formatter.parse(enterDateExam.toString());
			}
			
			if((ackIniLetterDate != null && ackIniLetterDate.toString().trim().length() > 8)) {
				ackIniLetterDateNew = formatter.parse(ackIniLetterDate.toString());
			}
			if((ackHallTckDate != null && ackHallTckDate.toString().trim().length() > 8)) {
				ackHallTckDateNew = formatter.parse(ackHallTckDate.toString());
			}
			if((ackExamdate1 != null && ackExamdate1.toString().trim().length() > 8)) {
				ackExamdate1New = formatter.parse(ackExamdate1.toString());
			}
			if((ackExamdate2 != null && ackExamdate2.toString().trim().length() > 8)) {
				ackExamdate2New = formatter.parse(ackExamdate2.toString());
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
			
			
			
//			if((examPassFlag != null && examPassFlag.toString().trim().length() > 0)) {
//				//System.out.println(" INSIDE if  semYear"+semYear);
//			}else {
//				examPassFlag="0";
//			}
			
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
						
			
			//SEM str -1- or 2 ?? wjere ??todo
					
			String insertExamSQL = "insert into public.EAPPL (EA_DIPCODE, EA_PRCODE, EA_PRNO, EA_SESMON, EA_SESYR, EA_NAME, EA_STCODE, EA_STNAME, EA_CECODE, EA_CENTRE1, EA_NOFPAPR, EA_PAPRSTR, EA_DURTN, NEWNOFPAPR, OLDNOFPAPR, EA_ENTDATE) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			executeUpdate(insertExamSQL, new Object[]{newDipCode,prCodeExam.toString(),Integer.parseInt(prNoExam.toString()),semMonthExam.toString(),Integer.parseInt(semYearExam.toString()),stuNameExam.toString(),examStateCodenew ,examStateNamenew, examCenterCodeNew, examCenterNameNew, Integer.parseInt(noofPaperExam.toString()),examPapers.toString(),  durationExam.toString(),Integer.parseInt(examNewnoPapers.toString()),Integer.parseInt(examOldnoPapers.toString()),enterDateExamnew});
			
			System.out.println(" INSIDE insert EXAM SUCCESS");

			//executeUpdate(insertExamSQL, new Object[]{newDipCode,prCodeExam.toString(),Integer.parseInt(prNoExam.toString()),semMonthExam.toString(),Integer.parseInt(semYearExam.toString()),stuNameExam.toString(),examStateCodenew ,examStateNamenew, examCenterCodeNew, examCenterNameNew, Integer.parseInt(noofPaperExam.toString()),examPapers.toString(), examSemstr.toString(), durationExam.toString(),Integer.parseInt(examNewnoPapers.toString()),Integer.parseInt(examOldnoPapers.toString()),Integer.parseInt(examTotalPaper.toString()),Integer.parseInt(examPassFlag.toString()),enterDateExamnew});
			
			
			String insertACKLSQL = "insert into public.ACKBOX1 (AK_DIPCODE, AK_PRCODE, AK_PRNO, AK_SESMON, AK_SESYR, AK_NAME,ak_venudt,ak_examdt1,ak_examdt2,ak_halldt) values(?,?,?,?,?,?,?,?,?,?);";
			executeUpdate(insertACKLSQL, new Object[]{newDipCode,prCodeExam.toString(),Integer.parseInt(prNoExam.toString()),semMonthExam.toString(),Integer.parseInt(semYearExam.toString()),stuNameExam.toString(),ackIniLetterDateNew,ackExamdate1New,ackExamdate2New,ackHallTckDateNew});
			
			System.out.println(" INSIDE insert ACK table SUCCESS");
		
			
			
		}
	}


