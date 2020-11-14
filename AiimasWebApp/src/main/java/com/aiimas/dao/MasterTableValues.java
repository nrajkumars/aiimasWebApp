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
	
	
	
//	public List getValueFromDB(String sql) throws Exception  {
//		
//			//String getVerifyDataSql = "select DIPNAME from public.DIPMAST WHERE DIPCODE = ";
//			List<Map> data = executeFetchSql(sql);
//			return data;
//	}
	
	
	public List getExamDates(String semMon, String semYr, String prCode,  String prNo) throws Exception  {
		
		String getSql = "select ak_examdt1, ak_examdt2 from public.ACKBOX1 where AK_PRCODE = ? and AK_PRNO = ? and ak_sesmon=? and ak_sesyr=?";
		List<Map> data = executeFetchSql(getSql,new Object[]{prCode, Integer.parseInt(prNo), semMon,  Integer.parseInt(semYr)});
		return data;
}
	
	public List getCenteraddress(String cenCode) throws Exception  {
		
		String getSql = "select ex_add1, ex_add2, ex_add3, ex_add4, ex_add5, ex_add6 from public.excentre WHERE ex_cecode = ? ";
		List<Map> data = executeFetchSql(getSql,new String[]{cenCode});
		return data;
}
	
	
	
	public List getExamPaperDetails(String prCode, String prNo, String dipCode) throws Exception  {
		
		String getSql = "select ea_paprstr from public.EAPPL where EA_PRCODE = ? and EA_PRNO = ? and ea_dipcode=?";
		List<Map> data = executeFetchSql(getSql,new Object[]{prCode, Integer.parseInt(prNo), dipCode });
		return data;
}
	
	public List getDipPapers(String dipCode, String duration) throws Exception  {
		
		String getSql = "select dp_paperno, dp_paprnam, dp_session from public.dippaper WHERE dp_DIPCODE = ? and dp_durtn = ? ";
		List<Map> data = executeFetchSql(getSql,new String[]{dipCode, duration});
		return data;
}
	
	
	public List getDiplomName(String dipCode) throws Exception  {
	
		String getSql = "select DIPNAME from public.DIPMAST WHERE DIPCODE = ? ";
		List<Map> data = executeFetchSql(getSql,new String[]{dipCode});
		return data;
}
	
	
	public List getExamSemDetails(String prCode, String prNo) throws Exception  {
		
		String getSql = "select EA_SESMON, EA_SESYR  from public.EAPPL where EA_PRCODE = ? and EA_PRNO = ?";
		List<Map> data = executeFetchSql(getSql,new Object[]{prCode, Integer.parseInt(prNo)});
		return data;
}
	
	
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

