package com.aiimas.dao;


import java.util.List;
import java.util.Map;

public class Maintenance extends BaseDao {

	public void insertDiplomaData(Map data) throws Exception {
		
		
		Object diplomaCode1 =  data.get("diplomaCode1");
		Object diplomaName =  data.get("diplomaName");
		Object dcDiplomaName =  data.get("dcDiplomaName");
		Object noPaper =  data.get("noPaper");
	
		String insertEmployer = "insert into public.dipmast (dipcode, dipname, nofpapr, dcDiplomaName) values (?,?,?,?)";
		executeUpdate(insertEmployer, new String[]{diplomaCode1.toString(), diplomaName.toString(), noPaper.toString(), dcDiplomaName.toString() });
		
	}
	
	public boolean loginValidation(Map data) throws Exception {
		
		
		boolean loginResult = false;
		
		Object user =  data.get("user");
		Object checkp =  data.get("checkp");
		
		
		// Read from ADMIN table
		String getLoginSql = "select checkval from public.login where name = ?";
		List data1 = executeFetchSql(getLoginSql, new Object[]{user.toString() });
	
		if (data1 != null && data1.size() > 0) {

			String resultvalue = data1.get(0).toString();
					
					if((resultvalue != null )) {
						if(resultvalue.contains("=")) {
							int startcount = resultvalue.indexOf("=");

							int endcount = resultvalue.length();
							resultvalue= resultvalue.substring(startcount+1,endcount-1);
							loginResult = resultvalue.equals(checkp);
						}
					}

		}
	
		
		return loginResult;
		
	}
	
	
public void saveDiplomaDetail(Map data) throws Exception {
	
		
		Object diplomaCode1 =  data.get("diplomaCode1");
		Object diplomaName =  data.get("diplomaName");
		Object dcDiplomaName =  data.get("dcDiplomaName");
		Object noPaper =  data.get("noPaper");
		
		String updateEmployer = "update public.dipmast set dipname=?,nofpapr=?,dcDiplomaName=? where dipcode=?";
		executeUpdate(updateEmployer, new String[]{diplomaName.toString(),noPaper.toString(),dcDiplomaName.toString(), diplomaCode1.toString()});
		
		
	}

public void updateInstitue(Map data) throws Exception {
	
	Object instituteName =  data.get("instituteName");
	Object instituteAddress =  data.get("instituteAddress");
	Object institutePhNumbers =  data.get("institutePhNumbers");
	Object insituteCode =  data.get("insituteCode");
	
	
	String updateEmployer = "update public.company set coyname=?,coyadd1=?,coyadd2=? where coycode=?";
	executeUpdate(updateEmployer, new String[]{instituteName.toString(),instituteAddress.toString(),institutePhNumbers.toString(), insituteCode.toString()});
	
}
	
	
	public Map getDiplomaDetails(Map input) throws Exception  {
		
		Object diplomaCode1 =  input.get("diplomaCode1");
		
	
		String getDiplomaDataSql = "select * from public.dipmast where dipcode = ?";
		List data1 = executeFetchSql(getDiplomaDataSql, new Object[]{diplomaCode1.toString() });
	
		
		if (data1 != null && data1.size() > 0) {
			return (Map) data1.get(0);
		}
		return null;
			
		
	}
	
	
	public void saveInstitueDetails(Map data) throws Exception  {
		
		Object insituteCode =  data.get("insituteCode");
		Object instituteName =  data.get("instituteName");
		Object instituteAddress =  data.get("instituteAddress");
		Object institutePhNumbers =  data.get("institutePhNumbers");
		
		String updateInstituesql = "update public.company set coyname=?,coyadd1=?,coyadd2=? where coycode=?";
		executeUpdate(updateInstituesql, new String[]{instituteName.toString(),instituteAddress.toString(),institutePhNumbers.toString(), insituteCode.toString()});
		
	}
	
	
	public Map getInstituteDetails(Map input) throws Exception {
		
		Object insituteCode =  input.get("insituteCode");
		
	
		String getInstitDataSql = "select * from public.company where coycode = ?";
		List data1 = executeFetchSql(getInstitDataSql, new Object[]{insituteCode.toString() });
	
		
		if (data1 != null && data1.size() > 0) {
			return (Map) data1.get(0);
		}
		return null;
		
	}
		

}

