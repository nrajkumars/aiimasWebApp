package com.aiimas.dao;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class AddAdmission extends BaseDao {

	public void insertADMN(Map data) {
		try {
		
		
		Object stuName = data.get("stuName");
		Object address1 = data.get("address1");
		Object diplomaCode = data.get("diplomaCode");
		Object duration = data.get("duration");
		Object semMonth = data.get("semMonth");
		Object semYear = data.get("semYear");
		Object enterDate = data.get("enterDate");
		Object prCode11 = data.get("prCode11");
		Object prNo1 = data.get("prNo1");
		Object address2 = data.get("address2");
		Object address3 = data.get("address3");
		Object address4 = data.get("address4");
		Object pincode = data.get("pincode");
		Object mobNum = data.get("mobNum");
		Object emailid = data.get("emailid");
		Object dueDate = data.get("dueDate");
		Object totfee = data.get("totfee");
		Object papers = data.get("papers");
		Object paidamt = data.get("paidamt");
		
	
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date feeDuedate = null;
		Date enterDatef =null;
		
		if((dueDate != null && dueDate.toString().trim().length() > 8)) {
			 feeDuedate = formatter.parse(dueDate.toString());
		}
		
		if((enterDate != null && enterDate.toString().trim().length() > 8)) {
			enterDatef = formatter.parse(dueDate.toString());
		}
		
		if((paidamt != null && paidamt.toString().trim().length() > 0)) {
			//System.out.println(" INSIDE if paidamt"+paidamt);
		}else {
			paidamt="0";
		}
		
		if((papers != null && papers.toString().trim().length() > 0)) {
			//System.out.println(" INSIDE if  papers "+papers);
		}else {
			papers="0";
		}
		
		if((totfee != null && totfee.toString().trim().length() > 0)) {
			//System.out.println(" INSIDE if  totfee"+totfee);
		}else {
			totfee="0";
		}
		
		if((semYear != null && semYear.toString().trim().length() > 0)) {
			//System.out.println(" INSIDE if  semYear"+semYear);
		}else {
			semYear="0";
		}
		
			
		String insertAddAdm = "insert into public.ADMIN (AD_DIPCODE, AD_PRCODE, AD_PRNO, AD_SESMON, AD_SESYR, AD_NAME,AD_NOFPAPR, AD_FEEAMT, AD_DURTN, AD_PAIDAMT,AD_FEEDATE, AD_ENTDATE) values(?,?,?,?,?,?,?,?,?,?,?,?);";
		executeUpdate(insertAddAdm, new Object[]{diplomaCode.toString(),prCode11.toString(),Integer.parseInt(prNo1.toString()),semMonth.toString(),Integer.parseInt(semYear.toString()),stuName.toString(),Integer.parseInt(papers.toString()),Integer.parseInt(totfee.toString()), duration.toString(), Integer.parseInt(paidamt.toString()),feeDuedate,enterDatef });
	
		//AD_REF ??? todo find what it this ?
		// END time is not required

		}catch( Exception ex) {
				System.out.println(" INSIDE insertADMN ERROR  -"+ex.toString());
			ex.printStackTrace();
		}
//		
	}
	
	
	
}

