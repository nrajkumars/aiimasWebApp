package com.aiimas.dao;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class AddAdmission extends BaseDao {

	public void insertADMN(Map data) {
		try {
		
		System.out.println("inside ADDADMINSSION   inside - insertADMN"+data.toString());
		
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
			System.out.println(" INSIDE if add mission dte check"+dueDate);
			 feeDuedate = formatter.parse(dueDate.toString());
		}else {
			//feeDuedate = formatter.parse("0000-00-00");
		}
		
		if((enterDate != null && enterDate.toString().trim().length() > 8)) {
			System.out.println(" INSIDE if add mission dte check"+enterDate);
			enterDatef = formatter.parse(dueDate.toString());
		}else {
			//feeDuedate = formatter.parse("0000-00-00");
		}
		
		if((paidamt != null && paidamt.toString().trim().length() > 0)) {
			System.out.println(" INSIDE if paidamt"+paidamt);
		}else {
			paidamt="0";
		}
		
		if((papers != null && papers.toString().trim().length() > 0)) {
			System.out.println(" INSIDE if  papers "+papers);
		}else {
			papers="0";
		}
		
		if((totfee != null && totfee.toString().trim().length() > 0)) {
			System.out.println(" INSIDE if  totfee"+totfee);
		}else {
			totfee="0";
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
	public void saveEmployerData(Map data) {
		String[] employername = (String[]) data.get("employername");
		String[] registerusername = (String[]) data.get("registerusername");
		String[] contactname = (String[]) data.get("contactname");
		String[] phone = (String[]) data.get("phone");
		String[] email = (String[]) data.get("email");
		String[] address = (String[]) data.get("address");
		
		String updateEmployer = "update employers set employername=?,contactname=?,phone=?,email=?,address=? where username=?";
		executeUpdate(updateEmployer, new String[]{employername[0],contactname[0],phone[0],email[0],address[0],registerusername[0]});
		
	}
	public List<Map> listEmployers1() {
		String listCandidates = "select tu.user_name,c.employername,c.contactname,c.email,c.phone,c.address from tomcat_users tu left join employers c on c.username = tu.user_name,tomcat_roles tr where tu.user_name=tr.user_name and tr.role_name='employer'";
		List data = executeFetchSql(listCandidates);
		return data;
	}
	
	public Map getVerficationDetail11(Map input) {
		Object prNum =  input.get("prNum");
		Object prCode =  input.get("prCode");
		
		//String[] prNum = (String[]) input.get("prNum");
		//String[] prCode = (String[]) input.get("prCode");
		
		System.out.println(" INSIDE VERIFICATION --  going to run the SQL = "+prNum+","+prCode );
		
		if (prNum != null && prNum.toString().trim().length() > 0) {
			if((prCode != null && prCode.toString().trim().length() > 0)) {
				String getVerifyDataSql = "select * from public.admin where ad_prcode = ? and ad_prno = ?";
				List data = executeFetchSql(getVerifyDataSql, new Object[]{prCode.toString(),Integer.parseInt(prNum.toString()) });
			
				if (data != null && data.size() > 0) {
					return (Map) data.get(0);
				}
			}
		}
		return null;
	}
}

