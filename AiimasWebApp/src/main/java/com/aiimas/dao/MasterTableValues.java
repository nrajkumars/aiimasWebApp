package com.aiimas.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MasterTableValues extends BaseDao {

//	public List<Map> listEmployers() {
//		String listCandidates = "select tu.user_name,c.employername,c.contactname,c.email,c.phone,c.address from tomcat_users tu left join employers c on c.username = tu.user_name,tomcat_roles tr where tu.user_name=tr.user_name and tr.role_name='employer'";
//		List data = executeFetchSql(listCandidates);
//		return data;
//	}
	
	
	
	public List<Map> getListMasterTable() throws Exception  {
		
		
				String getVerifyDataSql = "select DIPCODE, DIPNAME, NOFPAPR from public.DIPMAST ";
				List data = executeFetchSql(getVerifyDataSql, new String[]{});
			
				System.out.println(" INSIDE MasterTableValues --  going to run result = "+data );
				return data;
			
	
	}
	
	
	public Map getStateCenterMasterTable() throws Exception  {
		
		Map<String, Object> finaldata = new TreeMap<String, Object>();
	
			// Read form state table
			String getStateDataSql = "select * from public.state";
			List data4 = executeFetchSql(getStateDataSql);
		
			if (data4 != null && data4.size() > 0) {
				for (int ii = 0; ii <= data4.size()-1; ii++) {
					String state = new String("State"+ii);
					finaldata.put(state, data4.get(ii));
					
				}
			}
	
	//// Read form Center table
			String getCenterDataSql = "select * from public.centre";
			List data5 = executeFetchSql(getCenterDataSql);
		
			if (data5 != null && data5.size() > 0) {
				for (int ii = 0; ii <= data5.size()-1; ii++) {
					String centre = new String("Centre"+ii);
					finaldata.put(centre, data5.get(ii));
					
				}
			}
	
			return finaldata;
	
	}
}

