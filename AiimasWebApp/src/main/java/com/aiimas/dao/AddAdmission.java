package com.aiimas.dao;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class AddAdmission extends BaseDao {

	public void insertADMN(Map data)  throws Exception {
			
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
		Object state = data.get("state");
		Object pincode = data.get("pincode");
		Object phonenum = data.get("phonenum");
		Object mobNum = data.get("mobNum");
		Object emailid = data.get("emailid");
		Object dueDate = data.get("dueDate");
		Object totfee = data.get("totfee");
		Object paidamt = data.get("paidamt");
		Object papers = data.get("papers");
		Object feepaiddate = data.get("feepaiddate");
		Object feepaidmode = data.get("feepaidmode");
		Object feeref = data.get("feeref");
		
		System.out.println("RRRRRRRRRRRRRRRRRR -"+diplomaCode);
		String newDipCode =  diplomaCode.toString();
		int subcount = newDipCode.indexOf("/");
		System.out.println("RRRRRRRRRRRRRRRRRR - "+subcount);
		newDipCode = newDipCode.substring(0, subcount-1);
		
		System.out.println("RRRRRRRRRRRRRRRRRR  2222    -"+newDipCode);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date feeDuedate = null;
		Date enterDatef =null;
		Date feepaiddatef =null;
		
		if((dueDate != null && dueDate.toString().trim().length() > 8)) {
			 feeDuedate = formatter.parse(dueDate.toString());
		}
		
		if((enterDate != null && enterDate.toString().trim().length() > 8)) {
			enterDatef = formatter.parse(enterDate.toString());
		}
		
		if((feepaiddate != null && feepaiddate.toString().trim().length() > 8)) {
			feepaiddatef = formatter.parse(feepaiddate.toString());
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
		
		if((papers != null && papers.toString().trim().length() > 0)) {
			//System.out.println(" INSIDE if  papers "+papers);
		}else {
			papers="0";
		}
		
		if((pincode != null && pincode.toString().trim().length() > 0)) {
			//System.out.println(" INSIDE if  pincode "+pincode);
		}else {
			pincode="0";
		}
		
				
		String insertAddAdm = "insert into public.ADM (AD_DIPCODE, AD_PRCODE, AD_PRNO, AD_SESMON, AD_SESYR, AD_NAME,AD_NOFPAPR, AD_FEEAMT, AD_DURTN, AD_PAIDAMT,AD_FEEDATE, AD_ENTDATE) values(?,?,?,?,?,?,?,?,?,?,?,?);";
		executeUpdate(insertAddAdm, new Object[]{newDipCode,prCode11.toString(),Integer.parseInt(prNo1.toString()),semMonth.toString(),Integer.parseInt(semYear.toString()),stuName.toString(),Integer.parseInt(papers.toString()),Integer.parseInt(totfee.toString()), duration.toString(), Integer.parseInt(paidamt.toString()),feeDuedate,enterDatef });
		// END time is not required //AD_REF not required
		
		
		String insertAddAddress = "insert into public.STADDR (SA_DIPCODE, SA_PRCODE, SA_PRNO, SA_NAME, SA_ADD1, SA_ADD2, SA_ADD3, SA_ADD4, SA_STATE, SA_PINCODE, SA_PHONE, SA_MOBILE, SA_EMAIL) values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
		executeUpdate(insertAddAddress, new Object[]{newDipCode.toString(),prCode11.toString(),Integer.parseInt(prNo1.toString()),stuName.toString(), address1.toString(),address2.toString(),address3.toString(),address4.toString(),state.toString(), Integer.parseInt(pincode.toString()),phonenum.toString(), mobNum.toString(),emailid.toString() });
				
		String insertAddfee = "insert into public.FEES (FE_PRCODE, FE_PRNO, FE_SESMON, FE_SESYR, FE_NAME, FE_DATE, FE_AMOUNT, FE_MODE, FE_REF) values(?,?,?,?,?,?,?,?,?);";
		executeUpdate(insertAddfee, new Object[]{prCode11.toString(),Integer.parseInt(prNo1.toString()),semMonth.toString(),Integer.parseInt(semYear.toString()),stuName.toString(),feepaiddatef, Integer.parseInt(paidamt.toString()), feepaidmode.toString(), feeref.toString() });
	
		
//	ADD admission	
	}
	
	public void updateADMN(Map data) throws Exception {
			
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
		Object state = data.get("state");
		Object pincode = data.get("pincode");
		Object phonenum = data.get("phonenum");
		Object mobNum = data.get("mobNum");
		Object emailid = data.get("emailid");
		Object dueDate = data.get("dueDate");
		Object totfee = data.get("totfee");
		Object paidamt = data.get("paidamt");
		Object papers = data.get("papers");
		Object feepaiddate = data.get("feepaiddate");
		Object feepaidmode = data.get("feepaidmode");
		Object feeref = data.get("feeref");
		
		System.out.println("RRRRRRRRRRRRRRRRRR -"+diplomaCode);
		String newDipCode =  diplomaCode.toString();
		int subcount = newDipCode.indexOf("/");
		System.out.println("RRRRRRRRRRRRRRRRRR - "+subcount);
		newDipCode = newDipCode.substring(0, subcount-1);
		
		System.out.println("RRRRRRRRRRRRRRRRRR  2222    -"+newDipCode);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date feeDuedate = null;
		Date enterDatef =null;
		Date feepaiddatef =null;
		
		if((dueDate != null && dueDate.toString().trim().length() > 8)) {
			 feeDuedate = formatter.parse(dueDate.toString());
		}
		
		if((enterDate != null && enterDate.toString().trim().length() > 8)) {
			enterDatef = formatter.parse(enterDate.toString());
		}
		
		if((feepaiddate != null && feepaiddate.toString().trim().length() > 8)) {
			feepaiddatef = formatter.parse(feepaiddate.toString());
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
		
		if((papers != null && papers.toString().trim().length() > 0)) {
			//System.out.println(" INSIDE if  papers "+papers);
		}else {
			papers="0";
		}
		
		if((pincode != null && pincode.toString().trim().length() > 0)) {
			//System.out.println(" INSIDE if  pincode "+pincode);
		}else {
			pincode="0";
		}
		
				
		String insertAddAdm = "UPDATE public.ADMN SET AD_DIPCODE=?, AD_SESMON=?, AD_SESYR=?, AD_NAME=?, AD_NOFPAPR=?, AD_FEEAMT=?, AD_DURTN=?, AD_PAIDAMT=?, AD_FEEDATE=?, AD_ENTDATE=? WHERE AD_PRCODE=? AND AD_PRNO=?;";
		executeUpdate(insertAddAdm, new Object[]{newDipCode,semMonth.toString(),Integer.parseInt(semYear.toString()),stuName.toString(),Integer.parseInt(papers.toString()),Integer.parseInt(totfee.toString()), duration.toString(), Integer.parseInt(paidamt.toString()),feeDuedate,enterDatef, prCode11.toString(),Integer.parseInt(prNo1.toString())});

		
		String insertAddAddress = "UPDATE public.STADDR SET SA_DIPCODE=?, SA_NAME=?, SA_ADD1=?, SA_ADD2=?, SA_ADD3=?, SA_ADD4=?, SA_STATE=?, SA_PINCODE=?, SA_PHONE=?, SA_MOBILE=?, SA_EMAIL=? WHERE SA_PRCODE=? and SA_PRNO=?;";
		executeUpdate(insertAddAddress, new Object[]{newDipCode.toString(),stuName.toString(), address1.toString(),address2.toString(),address3.toString(),address4.toString(),state.toString(), Integer.parseInt(pincode.toString()),phonenum.toString(), mobNum.toString(),emailid.toString(),prCode11.toString(),Integer.parseInt(prNo1.toString()) });
				
		String insertAddfee = "UPDATE public.FEES SET FE_SESMON=?, FE_SESYR=?, FE_NAME=?, FE_DATE=?, FE_AMOUNT=?, FE_MODE=?, FE_REF=?WHERE FE_PRCODE=? and FE_PRNO=?;";
		executeUpdate(insertAddfee, new Object[]{semMonth.toString(),Integer.parseInt(semYear.toString()),stuName.toString(),feepaiddatef, Integer.parseInt(paidamt.toString()), feepaidmode.toString(), feeref.toString(),prCode11.toString(),Integer.parseInt(prNo1.toString()) });
	
		
		System.out.println(" INSIDE UDATE SUCCESSFUL");

		
//	Update admission	
	}
	
	public void deleteADMN(Map data) throws Exception {
		
		Object prCode11 = data.get("prCode11");
		Object prNo1 = data.get("prNo1");
		
			
		System.out.println(" INSIDE deleteADMN VALUE = "+prCode11.toString());
		System.out.println(" INSIDE deleteADMN VALUE = "+prNo1.toString());
		
				
		String deleteAdm = "DELETE from public.ADMN where AD_PRCODE = ? and AD_PRNO =?";
		executeUpdate(deleteAdm, new Object[]{prCode11.toString(),Integer.parseInt(prNo1.toString())});
		
		
		String deleteAddress = "DELETE from public.STADDR where SA_PRCODE= ? and SA_PRNO=?";
		executeUpdate(deleteAddress, new Object[]{prCode11.toString(),Integer.parseInt(prNo1.toString())});
				
		String deletefee = "DELETE from public.FEES where FE_PRCODE =? and FE_PRNO= ?";
		executeUpdate(deletefee, new Object[]{prCode11.toString(),Integer.parseInt(prNo1.toString())});
	
		System.out.println(" INSIDE delete SUCCESSFUL");
				
//	Delete admission	
	}
	
	
	// GET Student details
	public Map getStudentDetails(Map input) throws Exception {
		Object prNum =  input.get("prNum");
		Object prCode =  input.get("prCode");
		
	
		Map finaldata = new HashMap();
		String admin = new String("Admin");
		String address = new String("Address");
		String fee = new String("Fee");
		
		System.out.println(" INSIDE getStudentDetails --  going to run the SQL = "+prNum+","+prCode );
		
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
				
				return finaldata;
			}
		}
		return null;
	}
	
	// GET Student details
		public Map getCurrentPRNo(Map input) throws Exception {
			Object prCode11 =  input.get("prCode11");
			
				
					
			if (prCode11 != null && prCode11.toString().trim().length() > 0) {
				
				//Map finaldata = new HashMap();
								
				// Read form PRno  READ many rows
				String getPRnoDataSql = "select MAX(ad_prno) from public.admn where ad_prcode = ?";
				List data2 = executeFetchSql(getPRnoDataSql, new Object[]{prCode11.toString()});
				
				if (data2 != null && data2.size() > 0) {
					return (Map) data2.get(0);
					//finaldata.put(fee, data3.get(0));
				}
				
				// for many values
			
//				if (data2 != null && data2.size() > 0) {
//					//return (Map) data2.get(0);
//					for (int ii = 1; ii <= data2.size()-1; ii++) {
//						String marks = new String("PRno"+ii);
//						finaldata.put(marks, data2.get(ii));
//						System.out.println(" INSIDE PRNO = "+ii);  
//					}
//				}
			//	return finaldata;
				}
		
			return null;
		}
	
	
}

