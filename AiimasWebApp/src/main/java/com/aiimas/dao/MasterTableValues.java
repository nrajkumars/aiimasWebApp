package com.aiimas.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MasterTableValues extends BaseDao {

//	public List<Map> listEmployers() {
//		String listCandidates = "select tu.user_name,c.employername,c.contactname,c.email,c.phone,c.address from tomcat_users tu left join employers c on c.username = tu.user_name,tomcat_roles tr where tu.user_name=tr.user_name and tr.role_name='employer'";
//		List data = executeFetchSql(listCandidates);
//		return data;
//	}
	
	
	
	public List<Map> getListMasterTable() {
		
		
				String getVerifyDataSql = "select DIPCODE, DIPNAME, NOFPAPR from public.DIPMAST ";
				List data = executeFetchSql(getVerifyDataSql, new String[]{});
			
				System.out.println(" INSIDE MasterTableValues --  going to run result = "+data );
				return data;
			
	
	}
}

