package com.aiimas.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.text.Paragraph;

public class MarkUpdate extends BaseDao {
	
	
	// GET Exam details
		public Map getMarkDetails(Map input) throws Exception  {
			Object prNum =  input.get("prNum");
			Object prCode =  input.get("prCode");
			
		
			Map finaldata = new HashMap();
			String exam = new String("Exam");
		
			
			
			//String mDipCode = new String("BA");  // todo get from first sql output
			//String mDuration = new String("SIX MONTHS");
			
			System.out.println(" INSIDE getMarkDetails --  going to run the SQL = "+prNum+","+prCode );
			
			if (prNum != null && prNum.toString().trim().length() > 0) {
				if((prCode != null && prCode.toString().trim().length() > 0)) {
					
					
					String getMarksDataSql = "select EA_DIPCODE, EA_SESMON, EA_SESYR, EA_DURTN, EA_NAME, EA_STNAME, EA_CENTRE1, EA_NOFPAPR from public.EAPPL WHERE EA_PRCODE =? and EA_PRNO=?";
					List data2 = executeFetchSql(getMarksDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
				
					if (data2 != null && data2.size() > 0) {
						//return (Map) data1.get(0);
						finaldata.put(exam, data2.get(0));
					}
					
					System.out.println(" RAJKUMAR   --finaldata "+finaldata.toString());
					
				/// TO READ from MAP /list	
					
					
					 	String mDipCode = new String("");
				        String mDuration = new String("");
				        ObjectMapper oMapper = new ObjectMapper();
				        Iterator<String> iter1 = finaldata.keySet().iterator();
				        while (iter1.hasNext()) {
							String key = iter1.next();
							System.out.println(" RAJKUMAR  1" +key);
							if(key.contains("Exam")) {
								//System.out.println(key);
							Object val = finaldata.get(key);
							 Map<String, Object> map1 = oMapper.convertValue(val, Map.class);
								System.out.println(" RAJKUMAR  2");
							// dp_paperno
							 
							 Object dp_papernoobj = map1.get("ea_dipcode");
							    if(dp_papernoobj!=null) {
							    	mDipCode = dp_papernoobj.toString();
							    }
				
							 
							 Object dp_paprnamobj = map1.get("ea_durtn");
							    if(dp_paprnamobj!=null) {
							    	mDuration = dp_paprnamobj.toString();
							    }
							    
							}
						}
					
					
							
					// Todo get dipcode and duration from above sql
					
					System.out.println(" RAJKUMAR   --mDipCode"+mDipCode);
					System.out.println(" RAJKUMAR   --mDuration "+mDuration);
					
					
//					//// Read form Dip PAPERS
					String getPaperListSql = "select dp_semster, dp_paperno, dp_paprnam, dp_paperid FROM PUBLIC.DIPPAPER WHERE dp_dipcode= ? AND dp_durtn= ?";
					List data5 = executeFetchSql(getPaperListSql, new Object[]{mDipCode, mDuration});
				
					System.out.println(" RAJKUMAR   --data5 "+data5.toString());
					
					if (data5 != null && data5.size() > 0) {
						//return (Map) data2.get(0);
						for (int ii = 0; ii <= data5.size()-1; ii++) {
							String papers = new String("PaperList"+ii);
							finaldata.put(papers, data5.get(ii));
							
						}
					}
					
					return finaldata;
				}
			}
			return null;
		}
		
		
		//SAVE MARK
		
				public void saveMarks(Map data) throws Exception  {
					
					Object prCodeMark = data.get("prCodeMark");
					Object prNoMark = data.get("prNoMark");
					Object diplomaCodeMark = data.get("diplomaCodeMark");
					Object SemMonthMark = data.get("SemMonthMark");
					Object SemYearMark = data.get("SemYearMark");
					Object stuNameMark = data.get("stuNameMark");
					Object row1paperMark= data.get("row1paperMark");
					Object row1paper= data.get("row1paper");
					Object row1papername= data.get("row1papername");
					Object row2paperMark= data.get("row2paperMark");
					Object row2paper= data.get("row2paper");
					Object row2papername= data.get("row2papername");
					Object row3paperMark= data.get("row3paperMark");
					Object row3paper= data.get("row3paper");
					Object row3papername= data.get("row3papername");
					Object row4paperMark= data.get("row4paperMark");
					Object row4paper= data.get("row4paper");
					Object row4papername= data.get("row4papername");
					Object row5paperMark= data.get("row5paperMark");
					Object row5paper= data.get("row5paper");
					Object row5papername= data.get("row5papername");
					Object row6paperMark= data.get("row6paperMark");
					Object row6paper= data.get("row6paper");
					Object row6papername= data.get("row6papername");
					Object row7paperMark= data.get("row7paperMark");
					Object row7paper= data.get("row7paper");
					Object row7papername= data.get("row7papername");
					Object row8paperMark= data.get("row8paperMark");
					Object row8paper= data.get("row8paper");
					Object row8papername= data.get("row8papername");
						
					
					System.out.println("RRRRRRRRRRRRRRRRRR -"+diplomaCodeMark);
					
					
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
					Date enterDateMark = new Date();
					Date enterDateMarknew = null;
					
				
					if((enterDateMark != null && enterDateMark.toString().trim().length() > 8)) {
						enterDateMarknew = formatter.parse(enterDateMark.toString());
					}
					
					System.out.println(" INSIDE if  SAVE MARK  enterDateMarknew"+enterDateMarknew);
					
					
					if((row1paperMark != null && row1paperMark.toString().trim().length() > 0)) {
						//System.out.println(" INSIDE if paidamt"+paidamt);
					}else {
						row1paperMark="";
					}
					
					System.out.println(" INSIDE if  SAVE MARK  row1paperMark"+Integer.parseInt(row1paperMark.toString()));
					
					
//					if((examOldnoPapers != null && examOldnoPapers.toString().trim().length() > 0)) {
//						//System.out.println(" INSIDE if  papers "+papers);
//					}else {
//						examOldnoPapers="";
//					}
//					
//					if((examTotalPaper != null && examTotalPaper.toString().trim().length() > 0)) {
//						//System.out.println(" INSIDE if  totfee"+totfee);
//					}else {
//						examTotalPaper="0";
//					}
//					
//					if((examPassFlag != null && examPassFlag.toString().trim().length() > 0)) {
//						//System.out.println(" INSIDE if  semYear"+semYear);
//					}else {
//						examPassFlag="0";
//					}
//					
//					if((noofPaperExam != null && noofPaperExam.toString().trim().length() > 0)) {
//						//System.out.println(" INSIDE if  papers "+papers);
//					}else {
//						noofPaperExam="0";
//					}
//					
//					if((semYearExam != null && semYearExam.toString().trim().length() > 0)) {
//						//System.out.println(" INSIDE if  pincode "+pincode);
//					}else {
//						semYearExam="0";
//					}
					
							
				//	String insertAddAdm = "insert into public.ADMN (AD_DIPCODE, AD_PRCODE, AD_PRNO, AD_SESMON, AD_SESYR, AD_NAME,AD_NOFPAPR, AD_FEEAMT, AD_DURTN, AD_PAIDAMT,AD_FEEDATE, AD_ENTDATE) values(?,?,?,?,?,?,?,?,?,?,?,?);";
					//executeUpdate(insertAddAdm, new Object[]{newDipCode,prCode11.toString(),Integer.parseInt(prNo1.toString()),semMonth.toString(),Integer.parseInt(semYear.toString()),stuName.toString(),Integer.parseInt(papers.toString()),Integer.parseInt(totfee.toString()), duration.toString(), Integer.parseInt(paidamt.toString()),feeDuedate,enterDatef });
					
					System.out.println(" INSIDE insert MARK SUCCESS");
					
					
				}
		
		
	}


