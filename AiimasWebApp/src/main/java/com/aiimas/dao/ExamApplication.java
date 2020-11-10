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
		
		
		// GET Exam  update details
				public Map getExamUpdateDetails(Map input) throws Exception  {
					
					// serach for dteail for update exam page
					
					Object prNum =  input.get("prNum");
					Object prCode =  input.get("prCode");
					
				
					//Map finaldata = new HashMap();
					Map<String, Object> finaldata = new TreeMap<String, Object>();
					String admin = new String("Admin");
					String exam = new String("Exam");
					String ack = new String("Ack");
				
					System.out.println(" INSIDE getExamupdate Details --  going to run the SQL = "+prNum+","+prCode );
					
					if (prNum != null && prNum.toString().trim().length() > 0) {
						if((prCode != null && prCode.toString().trim().length() > 0)) {
							
							// Read from ADMIN table
							String getAdminDataSql = "select ad_dipcode, ad_name, ad_durtn, ad_nofpapr from public.admn where ad_prcode = ? and ad_prno = ?";
							List data1 = executeFetchSql(getAdminDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
						
							if (data1 != null && data1.size() > 0) {
								finaldata.put(admin, data1.get(0));
							}
							
							System.out.println(" READ insert ADM SUCCESS");
							
							// Read from Exam table
							String getExamDataSql = "select EA_SESMON, EA_SESYR, EA_STCODE, EA_CECODE, EA_PAPRSTR, NEWNOFPAPR, EA_ENTDATE from public.EAPPL where EA_PRCODE = ? and EA_PRNO = ?";
							List data2 = executeFetchSql(getExamDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
						
							if (data2 != null && data2.size() > 0) {
								finaldata.put(exam, data2.get(0));
							}
							
							System.out.println(" READ  EXAM SUCCESS");
							
							// Read from Ack1 table
							String getAckDataSql = "select ak_venudt, ak_examdt1, ak_examdt2, ak_halldt from public.ACKBOX1 where AK_PRCODE = ? and AK_PRNO = ?";
							List data3 = executeFetchSql(getAckDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
						
							if (data3 != null && data3.size() > 0) {
								finaldata.put(ack, data3.get(0));
							}
							
							System.out.println(" READ  ACK SUCCESS");
							// there are two table in ACK why may be if not in first, look  for other
							
//////							// Read form state table
//							String getStateDataSql = "select * from public.state";
//							List data4 = executeFetchSql(getStateDataSql);
//						
//							if (data4 != null && data4.size() > 0) {
//								for (int ii = 0; ii <= data4.size()-1; ii++) {
//									String state = new String("State"+ii);
//									finaldata.put(state, data4.get(ii));
//									
//								}
//							}
//							
//							//// Read form Center table
//							String getCenterDataSql = "select * from public.centre";
//							List data5 = executeFetchSql(getCenterDataSql);
//						
//							if (data5 != null && data5.size() > 0) {
//								for (int ii = 0; ii <= data5.size()-1; ii++) {
//									String centre = new String("Centre"+ii);
//									finaldata.put(centre, data5.get(ii));
//									
//								}
//							}
							
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
				
				System.out.println("RR  ----- rAJK  examStateCode  "+examStateCode);
				System.out.println("RR  ---- rjal  examCenterCode "+examCenterCode);
				
				
				Object ackIniLetterDate = data.get("ackIniLetterDate");
				Object ackHallTckDate = data.get("ackHallTckDate");
				Object ackExamdate1 = data.get("ackExamdate1");
				Object ackExamdate2 = data.get("ackExamdate2");
				
				
				Object examPapers = data.get("ea_paprstr");
				
				Object examNewnoPapers = data.get("noofPaperExam");
				
				Object examOldnoPapers = data.get("oldnofpapr");
				
				
				
		
		
			//rak
				String newDipCode =  diplomaCodeExam.toString();
				if(newDipCode.contains("/")) {
					int subcount = newDipCode.indexOf("/");
					newDipCode = newDipCode.substring(0, subcount-1);
				}
				
				System.out.println("RRRRRRRRRRRRRRRRRR  2222 newDipCode  -"+newDipCode);
				
				//STATE
				String examStateString =  examStateCode.toString();
				String examStateCodeNew =  new String("");
				String examStateNameNew =  new String("");
				if(examStateString.contains("/")) {
					int subcount = examStateString.indexOf("/");
					examStateNameNew = examStateString.substring(0, subcount-1);
					examStateNameNew = examStateNameNew.trim();
					examStateCodeNew= examStateString.substring(subcount+1);
					examStateCodeNew= examStateCodeNew.trim();
				}
				
				//CENTER
				String examCenterString =  examCenterCode.toString();
				String examCenterCodeNew =  new String("");
				String examCenterNameNew =  new String("");
				if(examCenterString.contains("/")) {
					int subcount = examCenterString.indexOf("/");
					examCenterNameNew = examCenterString.substring(0, subcount-1);
					examCenterNameNew = examCenterNameNew.trim();
					examCenterCodeNew= examCenterString.substring(subcount+1);
					examCenterCodeNew= examCenterCodeNew.trim();
				}
					
				
				
			System.out.println("RRRRRRRRRRRRRRRRRR  2222 examStateNameNew  -"+examStateNameNew);
			System.out.println("RRRRRRRRRRRRRRRRRR  2222 examStateCodeNew  -"+examStateCodeNew);
			
			System.out.println("RRRRRRRRRRRRRRRRRR  2222 examCenterNameNew  -"+examCenterNameNew);
			System.out.println("RRRRRRRRRRRRRRRRRR  2222 examCenterCodeNew  -"+examCenterCodeNew);
			
			System.out.println("RRRRRRRRRRRRRRRRRR  2222 examOldnoPapers  -"+examOldnoPapers);
			System.out.println("RRRRRRRRRRRRRRRRRR  2222 examPapers  -"+examPapers.toString());
			
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
			executeUpdate(insertExamSQL, new Object[]{newDipCode,prCodeExam.toString(),Integer.parseInt(prNoExam.toString()),semMonthExam.toString(),Integer.parseInt(semYearExam.toString()),stuNameExam.toString(),examStateCodeNew ,examStateNameNew, examCenterCodeNew, examCenterNameNew, Integer.parseInt(noofPaperExam.toString()),examPapers.toString(),  durationExam.toString(),Integer.parseInt(examNewnoPapers.toString()),Integer.parseInt(examOldnoPapers.toString()),enterDateExamnew});
			
			System.out.println(" INSIDE insert EXAM SUCCESS");

			//executeUpdate(insertExamSQL, new Object[]{newDipCode,prCodeExam.toString(),Integer.parseInt(prNoExam.toString()),semMonthExam.toString(),Integer.parseInt(semYearExam.toString()),stuNameExam.toString(),examStateCodenew ,examStateNamenew, examCenterCodeNew, examCenterNameNew, Integer.parseInt(noofPaperExam.toString()),examPapers.toString(), examSemstr.toString(), durationExam.toString(),Integer.parseInt(examNewnoPapers.toString()),Integer.parseInt(examOldnoPapers.toString()),Integer.parseInt(examTotalPaper.toString()),Integer.parseInt(examPassFlag.toString()),enterDateExamnew});
			
			
			String insertACKLSQL = "insert into public.ACKBOX1 (AK_DIPCODE, AK_PRCODE, AK_PRNO, AK_SESMON, AK_SESYR, AK_NAME,ak_venudt,ak_examdt1,ak_examdt2,ak_halldt) values(?,?,?,?,?,?,?,?,?,?);";
			executeUpdate(insertACKLSQL, new Object[]{newDipCode,prCodeExam.toString(),Integer.parseInt(prNoExam.toString()),semMonthExam.toString(),Integer.parseInt(semYearExam.toString()),stuNameExam.toString(),ackIniLetterDateNew,ackExamdate1New,ackExamdate2New,ackHallTckDateNew});
			
			System.out.println(" INSIDE insert ACK table SUCCESS");
		
			
			
		}
		
		//UPDATE Exam
		
		
				public void updateExam(Map data) throws Exception {
					
					Object prCodeExam = data.get("prCodeExam");
					Object prNoExam = data.get("prNoExam");
					Object diplomaCodeExam = data.get("diplomaCodeExam");
					Object durationExam = data.get("durationExam");
					Object noofPaperExam = data.get("noofPaperExam");
					Object semMonthExam = data.get("semMonthExam");
					Object semYearExam = data.get("semYearExam");
					Object enterDateExam = data.get("enterDateExam");
					Object stuNameExam = data.get("stuNameExam");
					Object examPassFlag = data.get("examPassFlag");
					
					Object examStateCode = data.get("examStateCode");
					Object examCenterCode = data.get("examCenterCode");
					
					System.out.println("RR  ----- rAJK  examStateCode  "+examStateCode);
					System.out.println("RR  ---- rjal  examCenterCode "+examCenterCode);
					
					
					Object ackIniLetterDate = data.get("ackIniLetterDate");
					Object ackHallTckDate = data.get("ackHallTckDate");
					Object ackExamdate1 = data.get("ackExamdate1");
					Object ackExamdate2 = data.get("ackExamdate2");
					
					
					Object examPapers = data.get("ea_paprstr");
					
					Object examNewnoPapers = data.get("noofPaperExam");
					
					Object examOldnoPapers = data.get("oldnofpapr");
					
					
					
				//	Object examTotalPaper = data.get("examTotalPaper");
	
					
			
				//rak
					String newDipCode =  diplomaCodeExam.toString();
					if(newDipCode.contains("/")) {
						int subcount = newDipCode.indexOf("/");
						newDipCode = newDipCode.substring(0, subcount-1);
					}
					
					System.out.println("RRRRRRRRRRRRRRRRRR  2222 newDipCode  -"+newDipCode);
					
					//STATE
					String examStateString =  examStateCode.toString();
					String examStateCodeNew =  new String("");
					String examStateNameNew =  new String("");
					if(examStateString.contains("/")) {
						int subcount = examStateString.indexOf("/");
						examStateNameNew = examStateString.substring(0, subcount-1);
						examStateNameNew = examStateNameNew.trim();
						examStateCodeNew= examStateString.substring(subcount+1);
						examStateCodeNew= examStateCodeNew.trim();
					}
					
					//CENTER
					String examCenterString =  examCenterCode.toString();
					String examCenterCodeNew =  new String("");
					String examCenterNameNew =  new String("");
					if(examCenterString.contains("/")) {
						int subcount = examCenterString.indexOf("/");
						examCenterNameNew = examCenterString.substring(0, subcount-1);
						examCenterNameNew = examCenterNameNew.trim();
						examCenterCodeNew= examCenterString.substring(subcount+1);
						examCenterCodeNew= examCenterCodeNew.trim();
					}
						
					
					
				System.out.println("RRRRRRRRRRRRRRRRRR  UPDATE 2222 examStateNameNew  -"+examStateNameNew);
				System.out.println("RRRRRRRRRRRRRRRRRR UPDATE 2222 examStateCodeNew  -"+examStateCodeNew);
				
				System.out.println("RRRRRRRRRRRRRRRRRR UPDATE 2222 examCenterNameNew  -"+examCenterNameNew);
				System.out.println("RRRRRRRRRRRRRRRRRR UPDATE 2222 examCenterCodeNew  -"+examCenterCodeNew);
				
				System.out.println("RRRRRRRRRRRRRRRRRR UPDATE 2222 examOldnoPapers  -"+examOldnoPapers);
				System.out.println("RRRRRRRRRRRRRRRRRR UPDATE 2222 examPapers  -"+examPapers.toString());
				
				System.out.println("RRRRRRRRRRRRRRRRRR UPDATE 2222 examPassFlag  -"+examPassFlag);
				System.out.println("RRRRRRRRRRRRRRRRRR UPDATE 2222 examPassFlag  -"+examPassFlag.toString());
				
				System.out.println("RRRRRRRRRRRRRRRRRR UPDATE 2222 HAL ticket    -"+ackHallTckDate);
				
			
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
				
				// NOT INSERTED EA_PRNUM = CODE+NO	 AND END TIME
				//TOTAL 21 -2 = 19 ?
							
				
				//SEM str -1- or 2 ?? wjere ??todo  AK_DIPCODE, 
						
				String insertExamSQL = "UPDATE public.EAPPL SET  EA_SESMON=?, EA_SESYR=?, EA_STCODE=?, EA_STNAME=?, EA_CECODE=?, EA_CENTRE1=?, EA_PAPRSTR=?, NEWNOFPAPR=?, EA_ENTDATE=?,EA_PASSFLG=? WHERE EA_PRCODE=? AND EA_PRNO=?;";
				
				executeUpdate(insertExamSQL, new Object[]{semMonthExam.toString(),Integer.parseInt(semYearExam.toString()),examStateCodeNew ,examStateNameNew, examCenterCodeNew, examCenterNameNew, examPapers.toString(), Integer.parseInt(examNewnoPapers.toString()),enterDateExamnew, Integer.parseInt(examPassFlag.toString()), prCodeExam.toString(), Integer.parseInt(prNoExam.toString())});
				
				System.out.println(" INSIDE UPDATE EXAM SUCCESS");

				//executeUpdate(insertExamSQL, new Object[]{newDipCode,prCodeExam.toString(),Integer.parseInt(prNoExam.toString()),semMonthExam.toString(),Integer.parseInt(semYearExam.toString()),stuNameExam.toString(),examStateCodenew ,examStateNamenew, examCenterCodeNew, examCenterNameNew, Integer.parseInt(noofPaperExam.toString()),examPapers.toString(), examSemstr.toString(), durationExam.toString(),Integer.parseInt(examNewnoPapers.toString()),Integer.parseInt(examOldnoPapers.toString()),Integer.parseInt(examTotalPaper.toString()),Integer.parseInt(examPassFlag.toString()),enterDateExamnew});
				
				
				String insertACKLSQL = "UPDATE public.ACKBOX1 SET ak_venudt=?, ak_examdt1=?, ak_examdt2=?, ak_halldt=? WHERE AK_PRCODE =? AND AK_PRNO= ?;";
				executeUpdate(insertACKLSQL, new Object[]{ackIniLetterDateNew,ackExamdate1New,ackExamdate2New,ackHallTckDateNew,prCodeExam.toString(),Integer.parseInt(prNoExam.toString())});
				
				System.out.println(" INSIDE UPDATE ACK table SUCCESS");
		
				
					
				}
	}


