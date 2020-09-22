package com.aiimas.dao;


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
	public Map getEmployerDetails(Map input) {
		Object username =  input.get("username");
		if (username != null && username.getClass().isArray()) {
			username = ((Object[])username)[0];
		}
		if (username != null && username.toString().trim().length() > 0) {
			String getUserData = "select * from employers where username = ?";
			List data = executeFetchSql(getUserData, new String[]{username.toString()});
			
			if (data != null && data.size() > 0) {
				return (Map) data.get(0);
			}
		}
		return null;
	}
}

