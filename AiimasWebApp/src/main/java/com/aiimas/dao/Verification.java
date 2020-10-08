package com.aiimas.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Verification extends BaseDao {

	public void insertEmployerData(Map data) {
		//employername,registerusername,contactname,phone,email,address
		String[] employername = (String[]) data.get("employername");
		String[] registerusername = (String[]) data.get("username");
		if (registerusername == null || registerusername.length == 0 || registerusername[0].trim().length() == 0) {
			registerusername = (String[]) data.get("registerusername");
		}
		System.out.println("insertEmployerData: " + registerusername[0]);
		String[] contactname = (String[]) data.get("contactname");
		String[] phone = (String[]) data.get("phone");
		String[] email = (String[]) data.get("email");
		String[] address = (String[]) data.get("address");
		
		String insertEmployer = "insert into employers (employername,username,contactname,phone,email,address) values (?,?,?,?,?,?)";
		executeUpdate(insertEmployer, new String[]{employername[0],registerusername[0],contactname[0],phone[0],email[0],address[0]});
		
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
	public List<Map> listEmployers() {
		String listCandidates = "select tu.user_name,c.employername,c.contactname,c.email,c.phone,c.address from tomcat_users tu left join employers c on c.username = tu.user_name,tomcat_roles tr where tu.user_name=tr.user_name and tr.role_name='employer'";
		List data = executeFetchSql(listCandidates);
		return data;
	}
	
	public Map getVerficationDetail1(Map input) {
		Object prNum =  input.get("prNum");
		Object prCode =  input.get("prCode");
		
	
		Map finaldata = new HashMap();
		String admin = new String("Admin");
		String address = new String("Address");
		String fee = new String("Fee");
		
		System.out.println(" INSIDE VERIFICATION --  going to run the SQL = "+prNum+","+prCode );
		
		if (prNum != null && prNum.toString().trim().length() > 0) {
			if((prCode != null && prCode.toString().trim().length() > 0)) {
				
				// Read from ADMIN table
				String getAdminDataSql = "select * from public.admin where ad_prcode = ? and ad_prno = ?";
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
	
}

