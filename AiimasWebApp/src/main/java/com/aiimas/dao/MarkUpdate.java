package com.aiimas.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

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
			
			System.out.println(" INSIDE getMarkUPDATEDetails --  going to run the SQL = "+prNum+","+prCode );
			
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
		
		
		// GET Exam details
		public Map getMarkUpdateDetails(Map input) throws Exception  {
			Object prNum =  input.get("prNum");
			Object prCode =  input.get("prCode");
			
		
			//Map finaldata = new HashMap();
			Map<String, Object> finaldata = new TreeMap<String, Object>();
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
				
							 
//							 Object dp_paprnamobj = map1.get("ea_durtn");
//							    if(dp_paprnamobj!=null) {
//							    	mDuration = dp_paprnamobj.toString();
//							    }
							    
							}
						}
					
					
							
					// Todo get dipcode and duration from above sql
					
					System.out.println(" RAJKUMAR   --mDipCode"+mDipCode);
					//System.out.println(" RAJKUMAR   --mDuration "+mDuration);
					
					
//					//// Read form Dip PAPERS
					
					// insertAddMark = "insert into public.APPEAR (AP_DIPCODE, AP_PRCODE, AP_PRNO, 
					//AP_PAPER, AP_MARK, AP_PAPRNAM,ap_mrkdate) values(?,?,?,?,?,?,?,?,?,?);";
						
					String getMarksListSql = "select AP_PAPER, AP_MARK, AP_PAPRNAM FROM PUBLIC.APPEAR WHERE AP_DIPCODE= ? AND AP_PRCODE = ? AND AP_PRNO=?";
					List data5 = executeFetchSql(getMarksListSql, new Object[]{mDipCode,prCode.toString(),Integer.parseInt(prNum.toString()) });
				
					System.out.println(" RAJKUMAR   --data5 "+data5.toString());
					
					if (data5 != null && data5.size() > 0) {
						//return (Map) data2.get(0);
						for (int ii = 0; ii <= data5.size()-1; ii++) {
							String papers = new String("MarkList"+(ii+1));
							finaldata.put(papers, data5.get(ii));
							
						}
					}
					
					return finaldata;
				}
			}
			return null;
		}
		
		
		//SAVE MARK  only insert
		
				public void saveMarks(Map data) throws Exception  {
					
					Object prCodeMark = data.get("prCodeMark");
					Object prNoMark = data.get("prNoMark");
					Object diplomaCodeMark = data.get("diplomaCodeMark");
					Object noofPaperMark = data.get("noofPaperMark");
					Object SemMonthMark = data.get("SemMonthMark");
					Object SemYearMark = data.get("SemYearMark");
					Object stuNameMark = data.get("stuNameMark");
					Object enterDateMarks = data.get("enterDateMarks");
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
						
					
					System.out.println("RRRRRRRRRRRRRRRRRR mark uodate noofPaperMark -"+noofPaperMark);
					
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
					Date enterDateMarksnew = null;
					
					if((enterDateMarks != null && enterDateMarks.toString().trim().length() > 8)) {
						enterDateMarksnew = formatter.parse(enterDateMarks.toString());
					}

					
//					System.out.println(" INSIDE if  SAVE MARK  row1paperMark"+Integer.parseInt(row1paperMark.toString()));
//					System.out.println(" INSIDE if  SAVE MARK  row1paper"+row1paper.toString().substring(5));
//					System.out.println(" INSIDE if  SAVE MARK  row1papername"+row1papername.toString());
//		
					// diplomo caode unique pr code pr code paper no
					
					int n = Integer.parseInt(noofPaperMark.toString());
					
					System.out.println(" before for loop "+n);
					
					int paperNo= 0;
					int paperMark= -1;
					String paperName= "";
					String insertAddMark = "";
					
					for (int i = 1; i <= n; i++) {
					      if(i==1) {
					    	  if((row1paper != null && row1paper.toString().trim().length() > 0)) {
					    		  paperNo =Integer.parseInt(row1paper.toString().substring(6));
					    	  }
					    	  if((row1paperMark != null && row1paperMark.toString().trim().length() > 0)) {
					    		  System.out.println(" inside mark1"+row1paperMark.toString());
					    		  paperMark = Integer.parseInt(row1paperMark.toString());
					    	  }else {paperMark =-1;}
					    	  paperName = row1papername.toString();
					      }else if(i==2) {
					    	  if((row2paper != null && row2paper.toString().trim().length() > 0)) {
					    		  paperNo =Integer.parseInt(row2paper.toString().substring(6));
					    	  }
					    	  if((row2paperMark != null && row2paperMark.toString().trim().length() > 0)) {
					    		  paperMark = Integer.parseInt(row2paperMark.toString());
					    	  }else {paperMark =-1;}
					    	  paperName = row2papername.toString();
					    	  
					      }else if(i==3) {
					    	  if((row3paper != null && row3paper.toString().trim().length() > 0)) {
					    		  paperNo =Integer.parseInt(row3paper.toString().substring(6));
					    	  }
					    	  if((row3paperMark != null && row3paperMark.toString().trim().length() > 0)) {
					    		  paperMark = Integer.parseInt(row3paperMark.toString());
					    	  }else {paperMark =-1;}
					    	  paperName = row3papername.toString();
					    	  
					      }else if(i==4) {
					    	  if((row4paper != null && row4paper.toString().trim().length() > 0)) {
					    		  paperNo =Integer.parseInt(row4paper.toString().substring(6));
					    	  }
					    	  if((row4paperMark != null && row4paperMark.toString().trim().length() > 0)) {
					    		  paperMark = Integer.parseInt(row4paperMark.toString());
					    	  }else {paperMark =-1;}
					    	  paperName = row4papername.toString();
					    	  
					      }else if(i==5) {
					    	  if((row5paper != null && row5paper.toString().trim().length() > 0)) {
					    		  paperNo =Integer.parseInt(row5paper.toString().substring(6));
					    	  }
					    	  if((row5paperMark != null && row5paperMark.toString().trim().length() > 0)) {
					    		  paperMark = Integer.parseInt(row5paperMark.toString());
					    	  }else {paperMark =-1;}
					    	  paperName = row5papername.toString();
					    	  
					      }else if(i==6) {
					    	  if((row6paper != null && row6paper.toString().trim().length() > 0)) {
					    		  paperNo =Integer.parseInt(row6paper.toString().substring(6));
					    	  }
					    	  if((row6paperMark != null && row6paperMark.toString().trim().length() > 0)) {
					    		  paperMark = Integer.parseInt(row6paperMark.toString());
					    	  }else {paperMark =-1;}
					    	  paperName = row6papername.toString();
	  
					      }else if(i==7) {
					    	  if((row7paper != null && row7paper.toString().trim().length() > 0)) {
					    		  paperNo =Integer.parseInt(row7paper.toString().substring(6));
					    	  }
					    	  if((row7paperMark != null && row7paperMark.toString().trim().length() > 0)) {
					    		  paperMark = Integer.parseInt(row7paperMark.toString());
					    	  }else {paperMark =-1;}
					    	  paperName = row7papername.toString();
					      		
					      }else if(i==8) {
					    	  if((row8paper != null && row8paper.toString().trim().length() > 0)) {
					    		  paperNo =Integer.parseInt(row8paper.toString().substring(6));
					    	  }
					    	  if((row8paperMark != null && row8paperMark.toString().trim().length() > 0)) {
					    		  paperMark = Integer.parseInt(row8paperMark.toString());
					    	  }else {paperMark =-1;}
					    	  paperName = row8papername.toString();
					    	  
					      }
					      
					     insertAddMark = "insert into public.APPEAR (AP_DIPCODE, AP_PRCODE, AP_PRNO, AP_SESMON, AP_SESYR, AP_NAME,AP_PAPER, AP_MARK, AP_PAPRNAM,ap_mrkdate) values(?,?,?,?,?,?,?,?,?,?);";
						 executeUpdate(insertAddMark, new Object[]{diplomaCodeMark.toString(),prCodeMark.toString(),Integer.parseInt(prNoMark.toString()),SemMonthMark.toString(),Integer.parseInt(SemYearMark.toString()),stuNameMark,paperNo,paperMark, paperName,enterDateMarksnew });
						 System.out.println(" INSIDE insert MARK SUCCESS for  -"+n);
							
					    }
					
						System.out.println(" INSIDE insert  FINALLY MARK SUCCESS");
					
					
				}
				
				//Update MARK  only update
				
				public void updateMarks(Map data) throws Exception  {
					
					
					System.out.println("sssssssssssssssssssssssssssssssss noofPaperMark -"+data.toString());
					
					Object prCodeMark = data.get("prCodeMark");
					Object prNoMark = data.get("prNoMark");
					Object diplomaCodeMark = data.get("diplomaCodeMark");
					Object noofPaperMark = data.get("noofPaperMark");
					Object SemMonthMark = data.get("SemMonthMark");
					Object SemYearMark = data.get("SemYearMark");
					Object stuNameMark = data.get("stuNameMark");
					Object enterDateMarks = data.get("enterDateMarks");
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
						
					
					System.out.println("RRRRRRRRRRRRRRRRRR mark uodate noofPaperMark -"+noofPaperMark);
					
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
					Date enterDateMarksnew = null;
					
					if((enterDateMarks != null && enterDateMarks.toString().trim().length() > 8)) {
						enterDateMarksnew = formatter.parse(enterDateMarks.toString());
					}

					
//					System.out.println(" INSIDE if  SAVE MARK  row1paperMark"+Integer.parseInt(row1paperMark.toString()));
//					System.out.println(" INSIDE if  SAVE MARK  row1paper"+row1paper.toString().substring(5));
//					System.out.println(" INSIDE if  SAVE MARK  row1papername"+row1papername.toString());
//		
					// diplomo caode unique pr code pr code paper no
					
					int n = Integer.parseInt(noofPaperMark.toString());
					
					System.out.println(" before for loop "+n);
					
					int paperNo= 0;
					int paperMark= -1;
					String paperName= "";
					String updateMarks = "";
					
					for (int i = 1; i <= n; i++) {
					      if(i==1) {
					    	  if((row1paper != null && row1paper.toString().trim().length() > 0)) {
					    		  paperNo =Integer.parseInt(row1paper.toString());
					    	  }
					    	  if((row1paperMark != null && row1paperMark.toString().trim().length() > 0)) {
					    		 // System.out.println(" inside mark1"+row1paperMark.toString());
					    		  paperMark = Integer.parseInt(row1paperMark.toString());
					    	  }else {paperMark =-1;}
					    	  paperName = row1papername.toString();
					      }else if(i==2) {
					    	  if((row2paper != null && row2paper.toString().trim().length() > 0)) {
					    		  paperNo =Integer.parseInt(row2paper.toString());
					    	  }
					    	  if((row2paperMark != null && row2paperMark.toString().trim().length() > 0)) {
					    		  paperMark = Integer.parseInt(row2paperMark.toString());
					    	  }else {paperMark =-1;}
					    	  paperName = row2papername.toString();
					    	  
					      }else if(i==3) {
					    	  if((row3paper != null && row3paper.toString().trim().length() > 0)) {
					    		  paperNo =Integer.parseInt(row3paper.toString());
					    	  }
					    	  if((row3paperMark != null && row3paperMark.toString().trim().length() > 0)) {
					    		  paperMark = Integer.parseInt(row3paperMark.toString());
					    	  }else {paperMark =-1;}
					    	  paperName = row3papername.toString();
					    	  
					      }else if(i==4) {
					    	  if((row4paper != null && row4paper.toString().trim().length() > 0)) {
					    		  paperNo =Integer.parseInt(row4paper.toString());
					    	  }
					    	  if((row4paperMark != null && row4paperMark.toString().trim().length() > 0)) {
					    		  paperMark = Integer.parseInt(row4paperMark.toString());
					    	  }else {paperMark =-1;}
					    	  paperName = row4papername.toString();
					    	  
					      }else if(i==5) {
					    	  if((row5paper != null && row5paper.toString().trim().length() > 0)) {
					    		  paperNo =Integer.parseInt(row5paper.toString());
					    	  }
					    	  if((row5paperMark != null && row5paperMark.toString().trim().length() > 0)) {
					    		  paperMark = Integer.parseInt(row5paperMark.toString());
					    	  }else {paperMark =-1;}
					    	  paperName = row5papername.toString();
					    	  
					      }else if(i==6) {
					    	  if((row6paper != null && row6paper.toString().trim().length() > 0)) {
					    		  paperNo =Integer.parseInt(row6paper.toString());
					    	  }
					    	  if((row6paperMark != null && row6paperMark.toString().trim().length() > 0)) {
					    		  paperMark = Integer.parseInt(row6paperMark.toString());
					    	  }else {paperMark =-1;}
					    	  paperName = row6papername.toString();
	  
					      }else if(i==7) {
					    	  if((row7paper != null && row7paper.toString().trim().length() > 0)) {
					    		  paperNo =Integer.parseInt(row7paper.toString());
					    	  }
					    	  if((row7paperMark != null && row7paperMark.toString().trim().length() > 0)) {
					    		  paperMark = Integer.parseInt(row7paperMark.toString());
					    	  }else {paperMark =-1;}
					    	  paperName = row7papername.toString();
					      		
					      }else if(i==8) {
					    	  if((row8paper != null && row8paper.toString().trim().length() > 0)) {
					    		  paperNo =Integer.parseInt(row8paper.toString());
					    	  }
					    	  if((row8paperMark != null && row8paperMark.toString().trim().length() > 0)) {
					    		  paperMark = Integer.parseInt(row8paperMark.toString());
					    	  }else {paperMark =-1;}
					    	  paperName = row8papername.toString();
					    	  
					      }
					      //UPDATE public.EAPPL SET  EA_SESMON=?   AP_DIPCODE, AP_PRCODE, AP_PRNO AP_PAPER,
					      
					      updateMarks = "UPDATE public.APPEAR SET AP_SESMON =?, AP_SESYR=?, AP_NAME=?, AP_MARK=?, AP_PAPRNAM=?, ap_mrkdate=? WHERE AP_DIPCODE=? AND AP_PRCODE=? AND AP_PRNO=? AND AP_PAPER=?;";
						 executeUpdate(updateMarks, new Object[]{SemMonthMark.toString(),Integer.parseInt(SemYearMark.toString()),stuNameMark,paperMark, paperName,enterDateMarksnew,diplomaCodeMark.toString(),prCodeMark.toString(),Integer.parseInt(prNoMark.toString()),paperNo });
						 System.out.println(" INSIDE UPDATE MARK SUCCESS for  -"+n);
							
					    }
					
						System.out.println(" INSIDE UPDATE  FINALLY MARK SUCCESS");
					
					
				}
		
		
	}


