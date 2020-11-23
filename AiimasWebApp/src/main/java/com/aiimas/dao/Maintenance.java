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
		System.out.println(" *******************  insertDiplomaData ");
		
	}
	
public void saveDiplomaDetail(Map data) throws Exception {
	
	System.out.println(" *******************  saveDiplomaDetail ");
		
		Object diplomaCode1 =  data.get("diplomaCode1");
		Object diplomaName =  data.get("diplomaName");
		Object dcDiplomaName =  data.get("dcDiplomaName");
		Object noPaper =  data.get("noPaper");
		
		String updateEmployer = "update public.dipmast set dipname=?,nofpapr=?,dcDiplomaName=? where dipcode=?";
		executeUpdate(updateEmployer, new String[]{diplomaName.toString(),noPaper.toString(),dcDiplomaName.toString(), diplomaCode1.toString()});
		
		System.out.println(" *******************  saveDiplomaDetail ");
		
	}

public void updateInstitue(Map data) throws Exception {
	
	Object instituteName =  data.get("instituteName");
	Object instituteAddress =  data.get("instituteAddress");
	Object institutePhNumbers =  data.get("institutePhNumbers");
	Object insituteCode =  data.get("insituteCode");
	
	System.out.println("updateInstitue --"+data.toString());
	
	String updateEmployer = "update public.company set coyname=?,coyadd1=?,coyadd2=? where coycode=?";
	executeUpdate(updateEmployer, new String[]{instituteName.toString(),instituteAddress.toString(),institutePhNumbers.toString(), insituteCode.toString()});
	
}
	
	
	public Map getDiplomaDetails(Map input) throws Exception  {
		
		Object diplomaCode1 =  input.get("diplomaCode1");
		
		System.out.println(" INSIDE getDiplomaDetails "+diplomaCode1);
	
		String getDiplomaDataSql = "select * from public.dipmast where dipcode = ?";
		List data1 = executeFetchSql(getDiplomaDataSql, new Object[]{diplomaCode1.toString() });
	
		System.out.println(" INSIDE getDiplomaDetails --  going to run result = "+data1 );
		
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
		
		System.out.println(" INSIDE getInstituteDetails  --------------------"+insituteCode.toString());
	
		String getInstitDataSql = "select * from public.company where coycode = ?";
		List data1 = executeFetchSql(getInstitDataSql, new Object[]{insituteCode.toString() });
	
		System.out.println(" INSIDE getInstituteDetails --  going to run result = "+data1 );
		
		if (data1 != null && data1.size() > 0) {
			return (Map) data1.get(0);
		}
		return null;
		
	}
		

}

