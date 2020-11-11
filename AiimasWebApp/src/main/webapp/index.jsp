<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.math.BigDecimal,java.util.Map.Entry,com.fasterxml.jackson.core.JsonProcessingException" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper, java.util.HashMap,java.util.Map.Entry,com.fasterxml.jackson.core.JsonProcessingException" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 <%! String json="";%>
 <%
 Map<String, String> elements = new HashMap();
  ObjectMapper objectMapper = new ObjectMapper();
  elements = (TreeMap)application.getAttribute("stateCenterMap");
        try {
            json = objectMapper.writeValueAsString(elements);
            //System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } 
        %>
<html>
<title>AIIMAS App</title>  <!-- updated by sakthi -->

<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">-->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">  -->
<!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat"> -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>

<!-- <script src="js/app1.js?ver=1"></script> -->
<script src= "https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">     </script> 
<script src="js/app2.js?v=5"></script> 



  <link href="lib/w3.css" rel="stylesheet">
  <link rel="stylesheet" href="lib/font-awesome-4.7.0/css/font-awesome.min.css">
  <link href="lib/montserratcss" rel="stylesheet">
  <link href="lib/roboto.css" rel="stylesheet">
<script>
localStorage.setItem('globalstatecenterdata', '<%=json%>');
</script>
<style>
<!-- for table -->
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
tr:nth-child(even) {
  background-color: #dddddd;
}

table#tbsty,
table#tbsty td
{
    border: none !important;
}
<!-- end table -->
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
  input[name='diplomaCodeName']{width: 550px;}   
</style>
<body class="w3-content" style="max-width:1200px">

<!-- Title logo -->
<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top" style="z-index:3;width:250px" id="mySidebar">
  <div class="w3-container w3-display-container w3-padding-16">
    <i onclick="w3_close()" class="fa fa-remove w3-hide-large w3-button w3-display-topright"></i>
    <h3 class="w3-wide"><b>AIIMAS</b></h3>
  </div>

<!-- Sidebar/menu -->
  <div class="w3-padding-64 w3-large w3-text-grey" style="font-weight:bold">
  	
    
    <a onclick="myAccFunc()" href="#" class="w3-button w3-block w3-white w3-left-align" id="myBtn">
      Data Entry <i class="fa fa-caret-down"></i>
    </a>

    <div id="demoAcc" class="w3-bar-block w3-hide w3-padding-large w3-medium">
	   <a href="#admApp" class="w3-bar-item w3-button">Admission Application<b>- ADD</b></a>
	    <a href="#admApp1" class="w3-bar-item w3-button">Admission Applica <b>- UPDATE</b></a>
      <a href="#examApp" class="w3-bar-item w3-button">Examination Application<b>- ADD</b> </a>
      <a href="#examApp1" class="w3-bar-item w3-button">Exam Application<b>- UPDATE</b> </a>
      <a href="#markUpdate" class="w3-bar-item w3-button">Enter Marks</a>
       <a href="#markUpdate1" class="w3-bar-item w3-button">Update Marks</a>
    
    </div>



    <a onclick="myAccFunc1()" href="#ack1" class="w3-button w3-block w3-white w3-left-align" id="myBtn1">
      Print/View&nbsp;<i class="fa fa-caret-down"></i>
    </a>
    <div id="demoAcc1" class="w3-bar-block w3-hide w3-padding-large w3-medium">
	  <a href="#ack1" class="w3-bar-item w3-button">Student Letters</a>
	  <a href="#applicantsList" class="w3-bar-item w3-button">Applicants List</a>
      <a href="#diplomaQuestions" class="w3-bar-item w3-button">Question Papers - for Diploma</a>
       <a href="#pickupQuestions" class="w3-bar-item w3-button">Question Papers - Pickup list</a>
       <a href="#attendanceChart" class="w3-bar-item w3-button">Attendance Chart</a>
<!--       <a href="#timeTable" class="w3-bar-item w3-button">Time Table update</a> -->
    </div>


    <a onclick="myAccFunc2()" href="#search1" class="w3-button w3-block w3-white w3-left-align" id="myBtn2">
      Verification&nbsp;<i class="fa fa-caret-down"></i>
    </a>
    <div id="demoAcc2" class="w3-bar-block w3-hide w3-padding-large w3-medium">
      <a href="#verifyName" class="w3-bar-item w3-button">Find PR.No</a> 
	  <a href="#search1" class="w3-bar-item w3-button">Student History</a>
    </div>

	
    <a onclick="myAccFunc3()" href="#diplomaUpdate" class="w3-button w3-block w3-white w3-left-align" id="myBtn3">
      Maintenance&nbsp;<i class="fa fa-caret-down"></i>
    </a>
    <div id="demoAcc3" class="w3-bar-block w3-hide w3-padding-large w3-medium">
      <a href="#diplomaUpdate" class="w3-bar-item w3-button">Diploma Update</a>
      <a href="#addressUpdate" class="w3-bar-item w3-button">Institute Update</a>
    </div>


	<a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding" onclick="document.getElementById('newsletter').style.display='block'"><b>Exit</b></a> 

  </div>
  
</nav>



<!-- Top menu on small screens -->
<header class="w3-bar w3-top w3-hide-large w3-black w3-xlarge">
  <div class="w3-bar-item w3-padding-24 w3-wide">AIIMAS</div>
  <a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding-24 w3-right" onclick="w3_open()"><i class="fa fa-bars"></i></a>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:250px">

  <!-- Push down content on small screens -->
  <div class="w3-hide-large" style="margin-top:83px"></div>
  
  
 <div>
    <div class="w3-black w3-center w3-padding-24"><h1>AIIMAS</h1> </div>

 
<!-- Main screen start -------------------------------------------------------------------------------------------Main screen---------------------------------->
 

<!-- ADD Admission ----------->

   <div class="w3-padding-64 w3-light-grey w3-card-4" id=admApp>
		<center> <h2>ADD - Admission Application</h2>
		<p>Add New Student application</p>
		</center>
		
		
		<%
		
		ServletContext sc = request.getServletContext();
		List diplomaDetails = (ArrayList)sc.getAttribute("diplomaCodeDetails");
		HashMap<String, String> wholeList = new HashMap<String, String>();
		
		if(diplomaDetails!=null && diplomaDetails.size()>0){
		for(int i=0;i<diplomaDetails.size();i++){
			HashMap<String,String> map = (HashMap)diplomaDetails.get(i);
			
			String[] perRow = new String[6];
			
				int j=0;
				for(Object str : map.keySet()){
			              Object key=str;
			              Object value=map.get(str);
			              
			              //System.out.println(j+" "+key);
			              //System.out.println(j+" "+value);
			              
			              if(j==0){
			            	  perRow[0] = key.toString();
			            	  perRow[1] = value.toString();
			              }else  if(j==1){
			            	  perRow[2] = key.toString();
			            	  perRow[3] = value.toString();
			              }else  if(j==2){
			            	  perRow[4] = key.toString();
			            	  perRow[5] = value.toString();
			              }
			              j++;
				}
				
			wholeList.put(perRow[2]+"~"+perRow[3], perRow[0]+"~"+perRow[1]+"@"+perRow[4]+"^"+perRow[5]);
			perRow = new String[6];
			
		}
		//System.out.println("wholeList size "+wholeList.size());
		}
		
		%>
		
		<div class="w3-panel w3-pale-green">
		
	  <div class="w3-container">
		<p>   
		
		  
		<label class="w3-text-red"><b> Diploma:</b>&nbsp;</label>
		<!--  <input type="text" name="diplomaCode" id="diplomaCode"  maxlength="5" size="5">&nbsp;&nbsp;&nbsp;
  		<input type="text" name="diplomaName" id="diplomaName"  maxlength="80" size="80">
  		-->
  		
  		<!--  <select class="w3-select"  id="diplomaCode" onchange="getSelectedDipcode()">  -->
  		<input list="diplomaCodeList" name="diplomaCodeName" id="diplomaCode" placeholder="Choose your option">
  		<datalist id="diplomaCodeList" onchange="getSelectedDipcode()">
  		<option selected value="Choose your option"></option>
		
			<%
			if(wholeList.size()>0 ){
				for (Map.Entry<String,String> entry : wholeList.entrySet()) { 
					//System.out.println(entry.getKey()+"- - "+entry.getValue());
				String code = entry.getKey().substring(entry.getKey().indexOf("~")+1, entry.getKey().length());
				String value = entry.getValue().substring(entry.getValue().indexOf("^")+1, entry.getValue().length());
				String no_of_paper = entry.getValue().substring(entry.getValue().indexOf("~")+1,entry.getValue().indexOf("@"));
				//System.out.println("paper - - "+no_of_paper.length());
				%>
				<option data-id="<%=code%>$<%=no_of_paper%>" value="<%=code%> / <%=value %>"></option>
    			<!-- <option value="<%=entry.getKey() %>" ><%=code%> / <%=value %></option> -->
    		<%}} %>
    		</datalist>
    	
  		<script> 
    	//sort_select();
    	//itemSelect(document.getElementById('diplomaCode'));
    	</script>
  		<br><br>
  		<input type="hidden" name="diplomaCodeName" >
  		<!--   SAKTHI todo 1 --   The above the fields should have the drop downs for diploma details -->
  		
		<div class="w3-third">
		<label class="w3-text-brown"><b> Duration:</b>&nbsp;</label>
		<select class="w3-select" name="option" id="duration">
    		<option value="" disabled selected>Choose your option</option>
	    		<option value="SIX MONTHS">SIX MONTHS</option>
		    		<option value="ONE YEAR">ONE YEAR</option>
		   		 	<option value="ONE YEAR-PG">ONE YEAR-PG</option>
  		</select>
  	</div>
   
    
  		
		<br><br><br><br>

		
		<div class="w3-third">
			<label class="w3-text-brown"><b>Admission Month:</b></label>
			<input class="w3-input w3-border " type="text" id="semMonth" >
		  </div>
		  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>Admission Year:</b></label>
			<input class="w3-input w3-border " type="year" id="semYear"  >
		  </div>
				  


 		  <div class="w3-third"> 
			<label class="w3-text-brown"><b>Admission Date:</b></label>
 			<input class="w3-input w3-border " type="date" id="enterDate" value="" ><br>
 		  </div> 
<script> loadDate('enterDate');</script>
		<div class="w3-third">
			<label class="w3-text-red"><b>P.R.Code:</b></label>
			<input class="w3-input w3-border " type="text"  id="prCode11"  value ='APR13'>
		  </div>
				  
		  <div class="w3-third">
			<label class="w3-text-red"><b>P.R.No:</b></label>
			<input class="w3-input w3-border " type="text"   id="prNo1" >
		  </div>
		  
		  <div class="w3-third">
	
			<label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-blue" id="resultCurPRNo" onclick="getNextPRNo()">&nbsp;&nbsp;Get NEXT PR No:</button><br><br>
		  </div>
		  
		  
		

   
		<label class="w3-text-brown"><b>Name:</b></label>
		<input class="w3-input w3-border " name="last" type="text" id="stuName" ><br>
				
<!-- 		<div class="w3-third"> -->
<!-- 		<label class="w3-text-brown"><b> Sex:</b>&nbsp;</label> -->
<!-- 		<select class="w3-select" name="option" id="sex"> -->
<!--     		<option value="" disabled selected>Choose your option</option> -->
<!--     		<opstuNametion value="1">Male</option> -->
<!--    	 	   	<option value="3">Female</option> -->
<!--   		</select>&nbsp;&nbsp; -->
<!--    		</div> -->
   
   
<!--    		<div class="w3-third">  -->
<!-- 			<label class="w3-text-brown"><b>Date of Birth:</b></label> -->
<!--  			<input class="w3-input w3-border " type="date" id="dob"><br> -->
<!--  		  </div>  -->
   
	
		
		<label class="w3-text-brown"><b>Address 1:</b></label>
		<input class="w3-input w3-border " name="address1" type="text" id="address1" ><br>
		<label class="w3-text-brown"><b>Address 2:</b></label>
		<input class="w3-input w3-border " name="address2" type="text" id="address2"><br>
		<label class="w3-text-brown"><b>Address 3:</b></label>
		<input class="w3-input w3-border " name="address3" type="text" id="address3"><br>
		<label class="w3-text-brown"><b>Address 4:</b></label>
		<input class="w3-input w3-border " name="address4" type="text" id="address4"><br>




		
		<div class="w3-third">
			<label class="w3-text-brown"><b>Pincode:</b></label>
			<input class="w3-input w3-border " type="text" name="pincode" maxlength="10" size="10" id ="pincode">
		  </div>
		  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>State:</b></label>
			<input class="w3-input w3-border " type="text" name="state" maxlength="10" size="10" id ="state" >
		  </div>
				  


 		  <div class="w3-third"> 
			<label class="w3-text-brown"><b>Phone Number:</b></label>
 			<input class="w3-input w3-border " type="text" name="phonenum" maxlength="15" size="15" id="phonenum"><br>
 		  </div> 
 		  
 		  
 		  
 		  
 		  <!-- new -->
		
		<div class="w3-third">
			<label class="w3-text-brown"><b>Mobile:</b></label>
			<input class="w3-input w3-border " type="text" name="mobile" maxlength="15" size="15" id="mobNum">
		  </div>
		  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>Email Address:</b></label>
			<input class="w3-input w3-border " type="text" name="email" maxlength="25" size="25" id ="emailid" >
		  </div>
				  


 		  <div class="w3-third"> 
			<label class="w3-text-brown"><b>Papers:</b></label>
 			<input class="w3-input w3-border " type="text" name="papers" maxlength="2" size="2" id="papers" ><br>
 		  </div> 
		
		
		
		<div class="w3-third">
			<label class="w3-text-brown"><b>Fee Due date:</b></label>
			<input class="w3-input w3-border " type="date" name="duedate" maxlength="5" size="5" id="dueDate">
		  </div>
		  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>Total Fee Amount:</b></label>
			<input class="w3-input w3-border " type="text" name="totalfee" maxlength="5" size="5" id="totfee" >
		  </div>
			
 		  <div class="w3-third"> 
			<label class="w3-text-brown"><b>Fee Paid Amount:</b></label>
 			<input class="w3-input w3-border " type="text" name="paidamt" maxlength="5" size="5" id="paidamt" ><br>
 		  </div> 
 		  
 		  
 		  <div class="w3-third">
			<label class="w3-text-brown"><b>Fee Paid date:</b></label>
			<input class="w3-input w3-border " type="date" name="feepaiddate" maxlength="5" size="5" id="feepaiddate">
		  </div>
		  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>Fee paid mode:</b></label>
			<input class="w3-input w3-border " type="text" name="feepaidmode" maxlength="25" size="2" id="feepaidmode">
		  </div>
			
 		  <div class="w3-third"> 
			<label class="w3-text-brown"><b>Fee reference:</b></label>
 			<input class="w3-input w3-border " type="text" name="feeref" maxlength="25" size="2" id="feeref"  ><br>
 		  </div> 
 		  
		
		<br><br><br>
		
		<center>
		
			<button class="w3-button w3-blue" id="resultAddAdm" onclick="addAdmission()">&nbsp;&nbsp;Save</button>
<!-- 		<button class="w3-button w3-orange onclick="" >Update</button> -->
			<button class="w3-button w3-red" onclick="clearaddAdmission()" >Clear</button>
			
			<!--  Sakthi to disply the success or error got from response
				 clear button clear all values
				 display to enter values for PR code and pc no, wich are in red on click of save, user ui validateion
			 -->
			 
			 
		</center>

		</p>
	  </div>
	  </div>
	</div>

<!-- UPDATE Admission -------------------------------------------------------------------->

   <div class="w3-padding-64 w3-light-grey w3-card-4" id=admApp1>
		<center> <h2>UPDATE - Admission Application</h2>
		<p> Modify and Delete the Student application Details</p>
		</center>
		
		<div class="w3-panel w3-pale-green">
	  <div class="w3-container">
	  <div align="center" id='alertDetailNotFound' style="display:none"><span style="color:red"><b>NO STUDNET DETAIL FOUND</b></span></div>
	  <div align="center" id='alertDetailFound' style="display:none"><span style="color:blue"><b>STUDENT DETAILS LOADED SUCCESSFULLY</b></span></div>
		<p>   
				
		<div class="w3-third">
			<label class="w3-text-red"><b>P.R.Code:</b></label>
			<input class="w3-input w3-border " type="text"  id="prCode111" value='APR13'  >
		  </div>
				  
		  <div class="w3-third">
			<label class="w3-text-red"><b>P.R.No:</b></label>
			<input class="w3-input w3-border " type="text"   id="prNo11"  value ='286' >
		  </div>
		  
		  
		   <div class="w3-third">
		    <label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-blue" id="result11" onclick="getStudentDetail()">&nbsp;&nbsp;GET Student Detail</button><br> <br>
			<br>
		  </div>
		  
		  		
		
		  
		<label class="w3-text-red"><b> Diploma:</b>&nbsp;</label>
		
  		<input list="diplomaCodeList" name="diplomaCodeName" id="diplomaCodeUad" placeholder="Choose your option">
  		<datalist id="diplomaCodeList" onchange="getSelectedDipcode()">
  		<option selected value="Choose your option"></option>
		
			<%
			if(wholeList.size()>0 ){
				for (Map.Entry<String,String> entry : wholeList.entrySet()) { 
					//System.out.println(entry.getKey()+"- - "+entry.getValue());
				String code = entry.getKey().substring(entry.getKey().indexOf("~")+1, entry.getKey().length());
				String value = entry.getValue().substring(entry.getValue().indexOf("^")+1, entry.getValue().length());
				String no_of_paper = entry.getValue().substring(entry.getValue().indexOf("~")+1,entry.getValue().indexOf("@"));
				//System.out.println("paper - - "+no_of_paper.length());
				%>
				<option data-id="<%=code%>$<%=no_of_paper%>" value="<%=code%> / <%=value %>"></option>
    			<!-- <option value="<%=entry.getKey() %>" ><%=code%> / <%=value %></option> -->
    		<%}} %>
    		</datalist>
    	
  		<script> 
    	//sort_select();
    	//itemSelect(document.getElementById('diplomaCode'));
    	</script>
  		<br><br>
  		<input type="hidden" name="diplomaCodeName" >
  		
  		
		<div class="w3-third">
		<label class="w3-text-brown"><b> Duration:</b>&nbsp;</label>
		<select class="w3-select" name="option" id="duration1">
    		<option value="" selected>Choose your option</option>
	    		<option value="SIX MONTHS">SIX MONTHS</option>
		    		<option value="ONE YEAR">ONE YEAR</option>
		   		 	<option value="ONE YEAR-PG">ONE YEAR-PG</option>
   		 	<option value="One Year">One Year</option>
  		</select>
  	</div>
      
  		
		<br><br><br><br>

		
		<div class="w3-third">
			<label class="w3-text-brown"><b>Semester Month:</b></label>
			<input class="w3-input w3-border " type="text" id="semMonth1" >
		  </div>
		  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>Semester Year:</b></label>
			<input class="w3-input w3-border " type="year" id="semYear1"  >
		  </div>
				  


 		  <div class="w3-third"> 
			<label class="w3-text-brown"><b>Entered on:</b></label>
 			<input class="w3-input w3-border " type="date" id="enterDate1"><br>
 		  </div> 

		
   
		<label class="w3-text-brown"><b>Name:</b></label>
		<input class="w3-input w3-border " name="last" type="text" id="stuName1" ><br>
		
		<label class="w3-text-brown"><b>Address 1:</b></label>
		<input class="w3-input w3-border " name="address1" type="text" id="address11" ><br>
		<label class="w3-text-brown"><b>Address 2:</b></label>
		<input class="w3-input w3-border " name="address2" type="text" id="address21"><br>
		<label class="w3-text-brown"><b>Address 3:</b></label>
		<input class="w3-input w3-border " name="address3" type="text" id="address31"><br>
		<label class="w3-text-brown"><b>Address 4:</b></label>
		<input class="w3-input w3-border " name="address4" type="text" id="address41"><br>

		<div class="w3-third">
			<label class="w3-text-brown"><b>Pincode:</b></label>
			<input class="w3-input w3-border " type="text" name="pincode" maxlength="10" size="10" id ="pincode1">
		  </div>
		  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>State:</b></label>
			<input class="w3-input w3-border " type="text" name="state" maxlength="10" size="10" id ="state1" >
		  </div>


 		  <div class="w3-third"> 
			<label class="w3-text-brown"><b>Phone Number:</b></label>
 			<input class="w3-input w3-border " type="text" name="phonenum" maxlength="15" size="15" id="phonenum1"><br>
 		  </div> 
 		  
 		  
 		  
 		  <!-- new -->
		
		<div class="w3-third">
			<label class="w3-text-brown"><b>Mobile:</b></label>
			<input class="w3-input w3-border " type="text" name="mobile" maxlength="15" size="15" id="mobNum1">
		  </div>
		  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>Email Address:</b></label>
			<input class="w3-input w3-border " type="text" name="email" maxlength="25" size="25" id ="emailid1" >
		  </div>
				  


 		  <div class="w3-third"> 
			<label class="w3-text-brown"><b>Papers:</b></label>
 			<input class="w3-input w3-border " type="text" name="papers" maxlength="2" size="2" id="papers1" ><br>
 		  </div> 
		
		
		
		<div class="w3-third">
			<label class="w3-text-brown"><b>Fee Due date:</b></label>
			<input class="w3-input w3-border " type="date" name="duedate" maxlength="5" size="5" id="dueDate1">
		  </div>
		  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>Total Fee Amount:</b></label>
			<input class="w3-input w3-border " type="text" name="totalfee" maxlength="5" size="5" id="totfee1" >
		  </div>
			
 		  <div class="w3-third"> 
			<label class="w3-text-brown"><b>Fee Paid Amount:</b></label>
 			<input class="w3-input w3-border " type="text" name="paidamt" maxlength="5" size="5" id="paidamt1" ><br>
 		  </div> 
 		  
 		  
 		  <div class="w3-third">
			<label class="w3-text-brown"><b>Fee Paid date:</b></label>
			<input class="w3-input w3-border " type="date" name="feepaiddate" maxlength="5" size="5" id="feepaiddate1">
		  </div>
		  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>Fee paid mode:</b></label>
			<input class="w3-input w3-border " type="text" name="feepaidmode" maxlength="25" size="2" id="feepaidmode1">
		  </div>
			
 		  <div class="w3-third"> 
			<label class="w3-text-brown"><b>Fee reference:</b></label>
 			<input class="w3-input w3-border " type="text" name="feeref" maxlength="25" size="2" id="feeref1"  ><br>
 		  </div> 
 		  
		
		<br><br><br>
		
		<center>
		
			<button class="w3-button w3-blue" id="updateAddAdm" onclick="updateAdmission()">&nbsp;&nbsp;Update</button>
 			<button class="w3-button w3-red" id="deleteAddAdm" onclick="deleteAdmission()">Delete</button>
			<button class="w3-button w3-green" onclick="clearAllAtrbutes()" >Clear</button>
			

			 
			 
		</center>

		</p>
	  </div>
	  </div>
	</div>


<!-- Exam application ADD  ------------------------------------------------------------------------------------------------------------------>


   <div class="w3-padding-64 w3-light-grey w3-card-4" id=examApp>
		<center> <h2>ADD - Exam Application</h2>
		<p>Add Exam detail of an Student</p>
		</center>
		
		<div class="w3-panel w3-pale-green">
		
	  <div class="w3-container">
	  
		  
		
		<div class="w3-third">
			<label class="w3-text-brown"><b>P.R.Code:</b></label>
			<input class="w3-input w3-border " type="text"  id="prCodeExam" value='APR13'  >
		  </div>
				  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>P.R.No:</b></label>
			<input class="w3-input w3-border " type="text"   id="prNoExam"  value ='286' >
		  </div>
		  
<div id="addExamGetExamDataLoad" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('addExamGetExamDataLoad').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide"></h2>
      <p>STUDENTS DETAILS LOADED SUCCESSFULLY</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('addExamGetExamDataLoad').style.display='none'">OK</button>
    </div>
  </div>
</div>

<div id="addExamGetExamDataLoadFail" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('addExamGetExamDataLoadFail').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide"></h2>
      <p>STUDENTS DETAILS NOT FOUND</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('addExamGetExamDataLoadFail').style.display='none'">OK</button>
    </div>
  </div>
</div>		  
		   <div class="w3-third">
		    <label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-blue" id="resultExam" onclick="getExamData1()">&nbsp;&nbsp;GET Student Detail</button><br> <br>
			<br>
		  </div>
		  
		<div class="w3-panel w3-border w3-border-red">
  			
		    
		<label class="w3-text-brown"><b>Name:</b></label>
		<input class="w3-input w3-border" name="last" type="text" id="stuNameExam" disabled  ><br>
		
		
		
		<label class="w3-text-brown"><b>Diploma:</b></label>
		<input class="w3-input w3-border" name="last" type="text" id="diplomaCodeExam" disabled ><br>
		  
 
   
    	<div class="w3-half">
			<label class="w3-text-brown"><b>Duration:</b></label>
			<input class="w3-input w3-border " type="text" id="durationExam" disabled ><br>
		  </div>
		  
		  	<div class="w3-half">
			<label class="w3-text-brown"><b>No of paper:</b></label>
			<input class="w3-input w3-border " type="text" id="noofPaperExam" disabled ><br>
		  </div>
  		
		
		</div>
		
		<!--  Sakthi  ALL above fields to be Non editable 	 -->

		
		<div class="w3-third">
			<label class="w3-text-brown"><b>Enter Semester Month:</b></label>
			<input class="w3-input w3-border " type="text" id="semMonthExam" >
		  </div>
		  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>Enter Semester Year:</b></label>
			<input class="w3-input w3-border " type="year" id="semYearExam"  >
		  </div>
				  


 		  <div class="w3-third"> 
			<label class="w3-text-brown"><b>Exam Entered on:</b></label>
 			<input class="w3-input w3-border " type="date" id="enterDateExam"><br>
 		  </div> 
<script> loadDate('enterDateExam');</script>
		

		
			<label class="w3-text-brown"><b> Exam State:</b>&nbsp;</label>	<!--  onchange="getSelectedStatecode()" -->
			<input list="examStateCodeList" class="w3-text-brwon" name="examStateCode" id="examStateCode" placeholder="Choose your option" 
			onchange="getSelectedStatecode('examStateCode','examStateCodeList','examCenterCodeList')">
	  		<datalist id="examStateCodeList" >                             
	  		<option selected value="Choose your option"></option>	
	  		
	  		<option value=""></option>	
	  	
			
	  		<!--  SAKTHI get from DB data-->
	  		
	   
	  		
	  		</datalist>	
	  
		<BR>
 		  <BR>
		 
		
 		  <label class="w3-text-brown"><b> Exam Center:</b>&nbsp;</label>		
		<input list="examCenterCodeList" class="w3-text-brwon"  name="examCenterCode" id="examCenterCode" placeholder="Choose your option">
  		<datalist id="examCenterCodeList" onchange="getSelectedCentercode()">
  		<option selected value="Choose your option"></option>	
  		<!--  
  		<option value="HYD/HYDD"></option>	
  		<option value="VI/VIJYA"></option>	
  		<option value="VS/VISAK"></option> -->
  		<!--  SAKTHI get from DB data-->
  		
  		</datalist>	
  		
 		  <BR><BR>
 		  
 		 
 		    <div class="w3-panel w3-border-left w3-pale-red w3-border-red w3-border">
    			<center><b><p>Ack Details.</p></b></center>
    			
    	 	<div class="w3-half">
 		   <label class="w3-text-brown"><b>Venue Initimation Letter:</b></label>
			<input class="w3-input w3-border " type="date" id="ackIniLetterDate"><br>
 		    </div> 
 		  
  			<div class="w3-half">
 		   <label class="w3-text-brown"><b>Hall Ticket issue date:</b></label>
			<input class="w3-input w3-border " type="date" id="ackHallTckDate"><br>
 		    </div> 
 		    

    			
    	 	<div class="w3-half">
 		   <label class="w3-text-brown"><b>Exam Date 1:</b></label>
			<input class="w3-input w3-border " type="date" id="ackExamdate1"><br>
 		    </div> 
 		  
  			<div class="w3-half">
 		   <label class="w3-text-brown"><b>Exam Date 2:</b></label>
			<input class="w3-input w3-border " type="date" id="ackExamdate2"><br>
 		    </div> 
 		 	
 		    
  			</div> <!--  broder end -->
  			
  			
  			<!--  SAKTHI - No of checkbox selected  = oldnofpapr -->
  			
  			<!--    BASED on the no of papers - this has to come dynamic to match the paper count  -->
  			<div class="w3-container w3-card-4">
  			<h3>Papers</h3>
  			<div id="slct2"></div>
			</div>
  			
  			<!--  Sakthi this hase to be changed based on selection -->
  			<input type="hidden" name="Old no of Paper selected" id="oldnofpapr"  value ="">
  			<input type="hidden" name="paper selected string" id="ea_paprstr"  value ="">
 		    
 		  

<p></p>
<center><table id="tbsty" align="center" width="15%"  border="0" cellspacing="0" cellpadding="0"><tr><td>
			<button class="w3-button w3-blue" id="resultSaveExamApp" onclick="saveExamApplication()"  style="display:none"  >&nbsp;&nbsp;Save</button> </td>
		<td>	<button class="w3-button w3-red" onclick="clearAllAtrbutesV1()" >Clear</button> </td></tr></table>
</center>
<p></p>

		
	  </div>
	  </div>
	  	</div>
	  	
	  	
	  	
<!-- Exam application UPDATE ------------------------------------------------------------------------------------------------------------------>



   <div class="w3-padding-64 w3-light-grey w3-card-4" id=examApp1>
		<center> <h2>UPDATE - Exam Application</h2>
		<p>Update the Exam detail of an Student</p>
		</center>
		
		<div class="w3-panel w3-pale-green">
		
	  <div class="w3-container">
	  
		  
		
		<div class="w3-third">
			<label class="w3-text-brown"><b>P.R.Code:</b></label>
			<input class="w3-input w3-border " type="text"  id="prCodeExam1" value='APR13'  >
		  </div>
				  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>P.R.No:</b></label>
			<input class="w3-input w3-border " type="text"   id="prNoExam1"  value ='286' >
		  </div>
		  
<div id="addExamGetExamDataLoad1" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('addExamGetExamDataLoad').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide"></h2>
      <p>EXAM DETAILS LOADED SUCCESSFULLY</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('addExamGetExamDataLoad1').style.display='none'">OK</button>
    </div>
  </div>
</div>

<div id="addExamGetExamDataLoadFail1" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('addExamGetExamDataLoadFail1').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide"></h2>
      <p>EXAM DETAILS NOT FOUND</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('addExamGetExamDataLoadFail1').style.display='none'">OK</button>
    </div>
  </div>
</div>		  
		   <div class="w3-third">
		    <label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-blue" id="resultExam1" onclick="getExamUpdateData1()">&nbsp;&nbsp;GET Student and Exam Detail</button><br> <br>
			<br>
		  </div>
		  
		<div class="w3-panel w3-border w3-border-red">
  			
		    
		<label class="w3-text-brown"><b>Name:</b></label>
		<input class="w3-input w3-border" name="last" type="text" id="stuNameExam1" disabled  ><br>
		
		
		
		<label class="w3-text-brown"><b>Diploma:</b></label>
		<input class="w3-input w3-border" name="last" type="text" id="diplomaCodeExam1" disabled ><br>
		  
 
   
    	<div class="w3-half">
			<label class="w3-text-brown"><b>Duration:</b></label>
			<input class="w3-input w3-border " type="text" id="durationExam1" disabled ><br>
		  </div>
		  
		  	<div class="w3-half">
			<label class="w3-text-brown"><b>No of paper:</b></label>
			<input class="w3-input w3-border " type="text" id="noofPaperExam1" disabled ><br>
		  </div>
  		
		
		</div>
		
		<!--  Sakthi  ALL above fields to be Non editable 	 -->

		
		<div class="w3-third">
			<label class="w3-text-brown"><b>Enter Semester Month:</b></label>
			<input class="w3-input w3-border " type="text" id="semMonthExam1" >
		  </div>
		  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>Enter Semester Year:</b></label>
			<input class="w3-input w3-border " type="year" id="semYearExam1"  >
		  </div>
				  


 		  <div class="w3-third"> 
			<label class="w3-text-brown"><b>Exam Entered on:</b></label>
 			<input class="w3-input w3-border " type="date" id="enterDateExam1"><br>
 		  </div> 
		<script> loadDate('enterDateExam1');</script>
		

		    <!-- stateCodeWorking -->
			<label class="w3-text-brown"><b> Exam State:</b>&nbsp;</label>	<!--  onchange="getSelectedStatecode()" -->
			
			<input list="examStateCodeList_updt" class="w3-text-brwon" 
			name="examStateCodeUpd" id="examStateCodeUpd" placeholder="Choose your option" 
			onchange="getSelectedStatecode('examStateCodeUpd','examStateCodeList_updt','examCenterCodeList_updt')">
	  		
	  		<datalist id="examStateCodeList_updt" >
		  		<option selected value="Choose your option"></option>	
		  		<option value=""></option>	
	  		</datalist>	
	  
		<BR>
 		  <BR>
		 
		
 		 <label class="w3-text-brown"><b> Exam Center:</b>&nbsp;</label>		
		<input list="examCenterCodeList_updt" class="w3-text-brwon"  name="examCenterCode_upd" id="examCenterCode_upd" placeholder="Choose your option">
  		<datalist id="examCenterCodeList_updt" onchange="getSelectedCentercode1()">
  		<option selected value="Choose your option"></option>	
  	
  		
  		</datalist>	
  		
 		  <BR><BR>
 		  <div class="w3-half">
 			<label class="w3-text-brown"><b> Exam PASS Flag:</b>&nbsp;</label>
				<select class="w3-select" name="option" id="examPassFlag">
		    		<option value="" selected>Choose your option</option>
	    			<option value="1">PASS</option>
		    		<option value="0">FAIL</option>
		  		</select><br><br>
		  		 </div>
  	
  		
  <div class="w3-half">
  <br>  <br>
   </div>	
  	
  		
  		<BR><BR><BR>
 		  
 		 
 		    <div class="w3-panel w3-border-left w3-pale-red w3-border-red w3-border">
    			<center><b><p>Ack Details.</p></b></center>
    			
    	 	<div class="w3-half">
 		   <label class="w3-text-brown"><b>Venue Initimation Letter:</b></label>
			<input class="w3-input w3-border " type="date" id="ackIniLetterDate1"><br>
 		    </div> 
 		  
  			<div class="w3-half">
 		   <label class="w3-text-brown"><b>Hall Ticket issue date:</b></label>
			<input class="w3-input w3-border " type="date" id="ackHallTckDate1"><br>
 		    </div> 
 		    

    			
    	 	<div class="w3-half">
 		   <label class="w3-text-brown"><b>Exam Date 1:</b></label>
			<input class="w3-input w3-border " type="date" id="ackExamdate11"><br>
 		    </div> 
 		  
  			<div class="w3-half">
 		   <label class="w3-text-brown"><b>Exam Date 2:</b></label>
			<input class="w3-input w3-border " type="date" id="ackExamdate21"><br>
 		    </div> 
 		 	
 		    
  			</div> <!--  broder end -->
  			
  			
  			<!--  SAKTHI - No of checkbox selected  = oldnofpapr -->
  			
  			<!--    BASED on the no of papers - this has to come dynamic to match the paper count  -->
  			<div class="w3-container w3-card-4">
  			<h3>Papers!!</h3>
  			<div id="slct2upt"></div>
			</div>
  			
  			<!--  Sakthi this hase to be changed based on selection -->
  			<input type="hidden" name="Old no of Paper selected" id="oldnofpapr1"  value ="">
  			<input type="hidden" name="paper selected string" id="ea_paprstr1"  value ="">
 		    
 		  

<p></p>
	<center><table id="tbsty" align="center" width="15%"  border="0" cellspacing="0" cellpadding="0"><tr><td>
 		<td>	<button class="w3-button w3-orange" id="resultUpdateExamApp1" onclick="updateExamApplication()" style="display:none" >Update</button>  </td>
 			<!--  during update add a flg for pass field  todo -->
		<td>	<button class="w3-button w3-red" onclick="clearAllAtrbutesExamUpdate()" >Clear</button> </td></tr></table>
</center>
<p></p>

		
	  </div>
	  </div>
	  	</div>
	  	

<!-- MARK add --------------------------------------------------------------------------------------------------------------------------------->


	
	
	<!--  APPEAR Table DB   insert -->  


   <div class="w3-padding-64 w3-light-grey w3-card-4" id=markUpdate>
		<center> <h2>Enter Marks</h2>
		<p>Enter the Exam  Marks of an Student</p>
		</center>

<div id="markDetailFound" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('markDetailFound').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide"></h2>
      <p>PAPER DETAILS LOADED SUCCESSFULLY</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('markDetailFound').style.display='none'">OK</button>
    </div>
  </div>
</div>

<div id="markDetailNotFound" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('markDetailNotFound').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide"></h2>
      <p>DETAILS NOT FOUND</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('markDetailNotFound').style.display='none'">OK</button>
    </div>
  </div>
</div>	

		
		<div class="w3-panel w3-pale-green">
		
	  <div class="w3-container">
	  <!-- 
	  <div align="center" id='markDetailNotFound' style="display:none"><span style="color:red"><b>NO MARK DETAIL FOUND</b></span></div>
	  <div align="center" id='markDetailFound' style="display:none"><span style="color:blue"><b>MARK DETAILS LOADED SUCCESSFULLY</b></span></div>
	  -->
		<p>   
		
		<div class="w3-third">
			<label class="w3-text-red"><b>P.R.Code:</b></label>
			<input class="w3-input w3-border " type="text"  id="prCodeMark" value='APR13'  >
		  </div>
				  
		  <div class="w3-third">
			<label class="w3-text-red"><b>P.R.No:</b></label>
			<input class="w3-input w3-border " type="text"   id="prNoMark"  value ='286' >
		  </div>
		  
		  
		   <div class="w3-third">
		    <label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-blue" id="resultMark" onclick="getMarkData()">&nbsp;&nbsp;GET Paper Detail</button><br> <br>
			<br>
		  </div>
		  
				<div class="w3-panel w3-border w3-border-red">
  			
		    
		<label class="w3-text-brown"><b>Name:</b></label>
		<input class="w3-input w3-border" name="last" type="text" id="stuNameMark" disabled><br>
		
		
		
		<label class="w3-text-brown"><b>Diploma Code:</b></label>
		<input class="w3-input w3-border" name="last" type="text" id="diplomaCodeMark" disabled><br>
		  
  		<div class="w3-half">
			<label class="w3-text-brown"><b>Duration:</b></label>
			<input class="w3-input w3-border " type="text" id="durationMark" disabled><br>
		  </div>
		  
		  	<div class="w3-half">
			<label class="w3-text-brown"><b>No of paper:</b></label>
			<input class="w3-input w3-border " type="text" id="noofPaperMark" disabled><br>
		  </div>
		  
		  <div class="w3-half">
			<label class="w3-text-brown"><b>Exam Semester Month:</b></label>
			<input class="w3-input w3-border " type="text" id="SemMonthMark" disabled><br>
		  </div>
		  
		  	<div class="w3-half">
			<label class="w3-text-brown"><b>Exam Semester Year:</b></label>
			<input class="w3-input w3-border " type="text" id="SemYearMark" disabled><br>
		  </div>
  		
   
    	<div class="w3-half">
			<label class="w3-text-brown"><b>State Name:</b></label>
			<input class="w3-input w3-border " type="text" id="stateMark" disabled><br>
		  </div>
		  
		  	<div class="w3-half">
			<label class="w3-text-brown"><b>Center Name:</b></label>
			<input class="w3-input w3-border " type="text" id="centerMark" disabled><br>
		  </div>
  		
		
		</div>
		
		<!--  Sakthi  ALL above fields to be Non editable 	 -->
				  

 		 
 		    <!--   based on the DB data this has to come dynamically  only MARKS to be updated by the user-->
 		    
 		    
 		    <div class="w3-container w3-card-4" id="marksentersegment">
  			<h3>Enter Marks:</h3>
  			
  			<div class="w3-half">
  			
  			<label class="w3-text-brown"><b>Marks Entered on:</b></label>
 			<input class="w3-input w3-border " type="date" id="enterDateMarks"><br>
 			<script> loadDate('enterDateMarks');</script>
 			<br><br>
		  		 </div>
  	
  		
			  <div class="w3-half">
			  <br>  <br>
			   </div>	
  	
  		
  		<BR><BR><BR>
  			
			<!--    <p>
	  
			  <div class="w3-quarter">
			  <input class="w3-input w3-border" type="text" id="Marksenter1" ><br>
			  </div>
			  
			   <div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="Paper 1" id="markPaperno"><br>
			  </div>
			  
			   <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder="Elements of managemnet"  id="markPapername"><br>
			  </div>
			  
			  <p>-->
			
			
			
			<div class="w3-container " id="displayPaper1" style="display: none;">
			
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="row1paperMark"><br>
			  </div>
			
			   <div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" value=1  id="row1paper"><br>
			  </div>
			  
			   <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="row1papername"><br>
			  </div>
		</div>
			
			<div class="w3-container " id="displayPaper2" style="display: none;">
			
						<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="row2paperMark"><br>
			  </div>
			
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="row2paper"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="row2papername"><br>
			  </div>
			</div>
			
						<div class="w3-container " id="displayPaper3" style="display: none;">
						
									<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="row3paperMark"><br>
			  </div>
						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="row3paper"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="row3papername"><br>
			  </div>
			</div>
			
						<div class="w3-container " id="displayPaper4" style="display: none;">
						
									<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="row4paperMark"><br>
			  </div>
						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="row4paper"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="row4papername"><br>
			  </div>
			</div>
			
						<div class="w3-container " id="displayPaper5" style="display: none;">
						
									<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="row5paperMark"><br>
			  </div>
						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="row5paper"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="row5papername"><br>
			  </div>
			</div>
			
						<div class="w3-container " id="displayPaper6" style="display: none;">
						
				<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="row6paperMark"><br>
			  </div>
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="row6paper"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="row6papername"><br>
			  </div>
			</div>
			
						<div class="w3-container " id="displayPaper7" style="display: none;">
						
						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="row7paperMark"><br>
			  </div>						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="row7paper"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="row7papername"><br>
			  </div>
			</div>
			
						<div class="w3-container " id="displayPaper8" style="display: none;">
						
						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="row8paperMark"><br>
			  </div>						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" value=8  id="row8paper"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="row8papername"><br>
			  </div>
			</div>
			
			</div>
			
		
 		    
		
		<br><br>
		
		<center>
		
			<button class="w3-button w3-blue" id="resultMark" onclick="saveMark()">&nbsp;&nbsp;Save</button>
<!-- 		<button class="w3-button w3-orange onclick="" >Update</button> -->
			<button class="w3-button w3-red" onclick="clearAllAtrbutesMarks()" >Clear</button>
			
			<!--  Sakthi  clear button
			 -->
			 
			 
		</center>

		</p>
	  </div>
	  </div>
	  	</div>
	
<!-- MARK UPDATE  --------------------------------------------------------------------------------------------------------------------------------->


	
	
	<!--  APPEAR Table DB   update -->  


   <div class="w3-padding-64 w3-light-grey w3-card-4" id=markUpdate1>
		<center> <h2>Update Marks</h2>
		<p>Update the Exam  Marks of an Student</p>
		</center>

<div id="markDetailFound1" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('markDetailFound1').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide"></h2>
      <p>MARK DETAILS LOADED SUCCESSFULLY</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('markDetailFound1').style.display='none'">OK</button>
    </div>
  </div>
</div>

<div id="markDetailNotFound1" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('markDetailNotFound1').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide"></h2>
      <p>MARKS DETAILS NOT FOUND</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('markDetailNotFound1').style.display='none'">OK</button>
    </div>
  </div>
</div>	

	
	<div id="updatemarkDetailFound" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('updatemarkDetailFound').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide"></h2>
      <p>MARK DETAILS LOADED SUCCESSFULLY</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('updatemarkDetailFound').style.display='none'">OK</button>
    </div>
  </div>
</div>

<div id="updatemarkDetailNotFound" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('updatemarkDetailNotFound').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide"></h2>
      <p>DETAILS NOT FOUND</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('updatemarkDetailNotFound').style.display='none'">OK</button>
    </div>
  </div>
</div>
	
	
		
		<div class="w3-panel w3-pale-green">
		
	  <div class="w3-container">
	  <!-- 
	  <div align="center" id='markDetailNotFound' style="display:none"><span style="color:red"><b>NO MARK DETAIL FOUND</b></span></div>
	  <div align="center" id='markDetailFound' style="display:none"><span style="color:blue"><b>MARK DETAILS LOADED SUCCESSFULLY</b></span></div>
	  -->
		<p>   
		
		<div class="w3-third">
			<label class="w3-text-red"><b>P.R.Code:</b></label>
			<input class="w3-input w3-border " type="text"  id="prCodeMark1" value='APR13'  >
		  </div>
				  
		  <div class="w3-third">
			<label class="w3-text-red"><b>P.R.No:</b></label>
			<input class="w3-input w3-border " type="text"   id="prNoMark1"  value ='7038' >
		  </div>
		  
		  
		   <div class="w3-third">
		    <label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-blue" id="resultMark" onclick="getMarkUpdateData()">&nbsp;&nbsp;GET Marks Detail</button><br> <br>
			<br>
		  </div>
		  
				<div class="w3-panel w3-border w3-border-red">
  			
		    
		<label class="w3-text-brown"><b>Name:</b></label>
		<input class="w3-input w3-border" name="last" type="text" id="stuNameMark1" disabled><br>
		
		
		
		<label class="w3-text-brown"><b>Diploma Code:</b></label>
		<input class="w3-input w3-border" name="last" type="text" id="diplomaCodeMark1" disabled><br>
		  
  		<div class="w3-half">
			<label class="w3-text-brown"><b>Duration:</b></label>
			<input class="w3-input w3-border " type="text" id="durationMark1" disabled><br>
		  </div>
		  
		  	<div class="w3-half">
			<label class="w3-text-brown"><b>No of paper:</b></label>
			<input class="w3-input w3-border " type="text" id="noofPaperMark1" disabled><br>
		  </div>
		  
		  <div class="w3-half">
			<label class="w3-text-brown"><b>Exam Semester Month:</b></label>
			<input class="w3-input w3-border " type="text" id="SemMonthMark1" disabled><br>
		  </div>
		  
		  	<div class="w3-half">
			<label class="w3-text-brown"><b>Exam Semester Year:</b></label>
			<input class="w3-input w3-border " type="text" id="SemYearMark1" disabled><br>
		  </div>
  		
   
    	<div class="w3-half">
			<label class="w3-text-brown"><b>State Name:</b></label>
			<input class="w3-input w3-border " type="text" id="stateMark1" disabled><br>
		  </div>
		  
		  	<div class="w3-half">
			<label class="w3-text-brown"><b>Center Name:</b></label>
			<input class="w3-input w3-border " type="text" id="centerMark1" disabled><br>
		  </div>
  		
		
		</div>
		
		<!--  Sakthi  ALL above fields to be Non editable 	 -->
				  

 		 
 		    <!--   based on the DB data this has to come dynamically  only MARKS to be updated by the user-->
 		    
 		    
 		    <div class="w3-container w3-card-4" id="marksentersegment1">
  			<h3>Enter Marks:</h3>
  			
  			<div class="w3-half">
  			
  			<label class="w3-text-brown"><b>Marks Entered on:</b></label>
 			<input class="w3-input w3-border " type="date" id="enterDateMarks1"><br>
 			
 			<br><br>
		  		 </div>
  	
  		
  		<div class="w3-container " id="updatePaper1" style="display: none;">
			
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="displayrow1paperMark"><br>
			  </div>
			
			   <div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" value=1  id="displayrow1paper"><br>
			  </div>
			  
			   <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="displayrow1papername"><br>
			  </div>
		</div>
			
			<div class="w3-container " id="updatePaper2" style="display: none;">
			
						<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="displayrow2paperMark"><br>
			  </div>
			
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="displayrow2paper"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="displayrow2papername"><br>
			  </div>
			</div>
			
						<div class="w3-container " id="updatePaper3" style="display: none;">
						
									<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="displayrow3paperMark"><br>
			  </div>
						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="displayrow3paper"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="displayrow3papername"><br>
			  </div>
			</div>
			
						<div class="w3-container " id="updatePaper4" style="display: none;">
						
									<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="displayrow4paperMark"><br>
			  </div>
						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="displayrow4paper"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="displayrow4papername"><br>
			  </div>
			</div>
			
						<div class="w3-container " id="updatePaper5" style="display: none;">
						
									<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="displayrow5paperMark"><br>
			  </div>
						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="displayrow5paper"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="displayrow5papername"><br>
			  </div>
			</div>
			
						<div class="w3-container " id="updatePaper6" style="display: none;">
						
				<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="displayrow6paperMark"><br>
			  </div>
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="displayrow6paper"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="displayrow6papername"><br>
			  </div>
			</div>
			
						<div class="w3-container " id="updatePaper7" style="display: none;">
						
						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="displayrow7paperMark"><br>
			  </div>						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="displayrow7paper"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="displayrow7papername"><br>
			  </div>
			</div>
			
		<div class="w3-container " id="updatePaper8" style="display: none;">
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="displayrow8paperMark"><br>
			  </div>						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" value=8  id="displayrow8paper"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="displayrow8papername"><br>
			  </div>
			</div>
  		
			  <div class="w3-half">
			  <br>  <br>
			   </div>	
  	
  		
  		<BR><BR><BR>
  			
			
			
			<div class="w3-container " id="displayPaper11" style="display: none;">
			
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="row1paperMark1"><br>
			  </div>
			
			   <div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" value=1  id="row1paper1"><br>
			  </div>
			  
			   <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="row1papername1"><br>
			  </div>
		</div>
			
			<div class="w3-container " id="displayPaper21" style="display: none;">
			
						<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="row2paperMark1"><br>
			  </div>
			
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="row2paper1"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="row2papername1"><br>
			  </div>
			</div>
			
						<div class="w3-container " id="displayPaper31" style="display: none;">
						
									<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="row3paperMark1"><br>
			  </div>
						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="row3paper1"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="row3papername1"><br>
			  </div>
			</div>
			
						<div class="w3-container " id="displayPaper41" style="display: none;">
						
									<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="row4paperMark1"><br>
			  </div>
						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="row4paper1"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="row4papername1"><br>
			  </div>
			</div>
			
						<div class="w3-container " id="displayPaper51" style="display: none;">
						
									<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="row5paperMark1"><br>
			  </div>
						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="row5paper1"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="row5papername1"><br>
			  </div>
			</div>
			
						<div class="w3-container " id="displayPaper61" style="display: none;">
						
				<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="row6paperMark1"><br>
			  </div>
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="row6paper1"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="row6papername1"><br>
			  </div>
			</div>
			
						<div class="w3-container " id="displayPaper71" style="display: none;">
						
						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="row7paperMark1"><br>
			  </div>						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" id="row7paper1"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="row7papername1"><br>
			  </div>
			</div>
			
						<div class="w3-container " id="displayPaper81" style="display: none;">
						
						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"   placeholder ="" id="row8paperMark1"><br>
			  </div>						
			<div class="w3-quarter">
			  <input class="w3-input w3-border" type="text"  disabled placeholder ="" value=8  id="row8paper1"><br>
			  </div>
			  
			 <div class="w3-half">
			  <input class="w3-input w3-border" type="text"  disabled Placeholder=""  id="row8papername1"><br>
			  </div>
			</div>
			
			</div>
			
		
 		    
		
		<br><br>
		
		<center>
		
			<button class="w3-button w3-orange" id="resultMark1" onclick="updateMark1()">&nbsp;&nbsp;Update</button>
<!-- 		<button class="w3-button w3-orange onclick="" >Update</button> -->
			<button class="w3-button w3-red" onclick="clearAllAtrbutesMarks1()" >Clear</button>
			
			
			 
			 
		</center>

		</p>
	  </div>
	  </div>
	  	</div>
	


<!-- PRINT / VIEW ---------------------------------------------------------------------------------------------------------------------------------->


<!-- PRINT  ADmission Intimation -------------->

 <div class="w3-padding-64 w3-light-grey w3-card-4" id=ack1>
		<center> <h2>Print Student Letters</h2></center>
	<div class="w3-panel w3-pale-green">
		 <p>Click the Report to generate the file and then Open to print.</p>
  	<div class="w3-container">
		<p>
		 <div class="w3-third">
			<label class="w3-text-brown"><b>P.R.Code:</b></label>
			<input class="w3-input w3-border " type="text" id="adprCode" value='APR13' >
		  </div>
				  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>P.R.No:</b></label>
			<input class="w3-input w3-border " type="text" id="adpprNo"  value ='286' >
		  </div>

		  <div class="w3-third">
		    <label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-red" id="adresult" onclick="cleartodo()">&nbsp;&nbsp;Clear</button><br> <br>
		  </div>
		  
		   <div class="w3-third">
			<label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-green" id="adresult" onclick="printAdmInit('admInit')">&nbsp;&nbsp;Admission Intimation Letter</button><br> <br>
		  </div>
				  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-green" id="adresult1" onclick="printAdmInit('ackLetter')">&nbsp;&nbsp;Admission Acknowledgement Letter</button><br> <br>
		  </div>

		  <div class="w3-third">
		    <label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-green" id="adresult2" onclick="printAdmInit('ansSheet')">&nbsp;&nbsp; Answer Sheet Acknowledgement Letter</button><br> <br>
		  </div>
		    <div class="w3-third">
			<label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-green" id="adresult3" onclick="printAdmInit('hallTck')">&nbsp;&nbsp;Examination Hall Ticket</button><br> <br>
		  </div>
				  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-green" id="adresult4" onclick="printAdmInit('mrkSheet')">&nbsp;&nbsp;Student Mark Sheet</button><br> <br>
		  </div>

		  <div class="w3-third">
		    <label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-green" id="adresult5" onclick="printAdmInit('diplomaCerti')">&nbsp;&nbsp;Student Diploma Certificate</button><br> <br>
		  </div>
		  
		  
		  <div class="w3-third" id="viewhref" style="display: none;">
		    <input id="intimationpdf" value="" type="hidden">  
			<button class="w3-button w3-orange" style='' id="myButton" onclick="openIntimationPDF()">Click to open Generated PDF Letter</button>
		    <BR>
		 <BR>
		  </div>
		  
		 

		</p> 

	</div>
	</div>
	 </div>
	 
	 
	 
	 <!--  Attendance LIST   ??? -->
	 
	 <!--  Serach by exam sem mon and year and the duration
	 	per diploma name  get the name , prcode prno, and  for all diplomas 
	  -->

	<div class="w3-padding-64 w3-light-grey w3-card-4" id=applicantsList>
		<center> <h2>Applicants List: </h2></center><br><br>
		
		<div class="w3-panel w3-pale-green">
	  <div class="w3-container" >
	
	<BR>
	
				
		<div class="w3-third">
			<label class="w3-text-brown"><b>Exam Semester Month:</b></label>
			<input class="w3-input w3-border " type="text" id="ALsemMonthName" >
		  </div>
		  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>Exam Semester Year:</b></label>
			<input class="w3-input w3-border " type="year" id="ALsemYearName"  >
		  </div>
			<div class="w3-third">
				<label class="w3-text-brown"><b> Duration:</b>&nbsp;</label>
				<select class="w3-select" name="option" id="ALduration">
		    		<option value="" disabled selected>Choose your option</option>
	    		<option value="SIX MONTHS">SIX MONTHS</option>
		    		<option value="ONE YEAR">ONE YEAR</option>
		   		 	<option value="ONE YEAR-PG">ONE YEAR-PG</option>
		  		</select><br><br>
  			</div>
  			
  			<!--
  			getSelectedStatecode('applicantID','applicantList','applicantCenterCode') 
  			applicantID >> input id name 
  			applicantList >> input list name and datalist id  >> PASS THE SAME IN loadStateCenter
  			applicantCenterCode >> next selectbox list name and datalist id name
  			 -->
  			
  			
  			
  			  <!-- stateCodeWorking -->
			<label class="w3-text-brown"><b> Exam State:</b>&nbsp;</label>	<!--  onchange="getSelectedStatecode()" -->
			
			<input list="examStateCodeList_updt1" class="w3-text-brwon" 
			name="examStateCodeUpd1" id="examStateCodeUpd1" placeholder="Choose your option" 
			onchange="getSelectedStatecode('examStateCodeUpd1','examStateCodeList_updt1','examCenterCodeList_updt1')">
	  		
	  		<datalist id="examStateCodeList_updt1" >
		  		<option selected value="Choose your option"></option>	
		  		<option value=""></option>	
	  		</datalist>	
	  
		<BR>
 		  <BR>
 		  <script>loadStateAndCenters('examStateCodeList_updt1');</script>
 		  
 		<label class="w3-text-brown"><b> Exam Center:</b>&nbsp;</label>		
		<input list="examCenterCodeList_updt1" class="w3-text-brwon"  name="eALxamCenterCode" id="ALexamCenterCode" placeholder="Choose your option">
  		<datalist id="examCenterCodeList_updt1" onchange="getSelectedCentercode()">
  		<option selected value="Choose your option"></option>	
  		
		
  		<!--  SAKTHI get from DB data-->
  		
  		</datalist>	
  		
 		  <BR><BR>
 	 
		  </div>
		
		<BR>
   		
	
		<Center>				 
			<button class="w3-button w3-green" id="applicantListPdf" onclick="printApplicantList()">&nbsp;&nbsp;Get Applicants List</button><br> <br>
		 </Center>

<br>
</div>
</div>
	 
	 
	 <!-- PRINT  Question Papers -------------->
  
<div class="w3-padding-64 w3-light-grey w3-card-4" id=diplomaQuestions>
		<center> <h2>Question Papers</h2></center><br><br>
		
 <div class="w3-panel w3-pale-green">
	  <div class="w3-container" >
	

<div id="updateadmissionDataLoad" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('updateadmissionDataLoad').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide"></h2>
      <p>STUDENT DETAILS LOADED SUCCESSFULLY</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('updateadmissionDataLoad').style.display='none'">OK</button>
    </div>
  </div>
</div>

<div id="get_student_detail" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('get_student_detail').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide"></h2>
      <p>STUDENTS NOT FOUND</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('get_student_detail').style.display='none'">OK</button>
    </div>
  </div>
</div>

<div id="updateadmissionDataLoadFail" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('updateadmissionDataLoadFail').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide"></h2>
      <p>STUDENT NOT FOUND</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('updateadmissionDataLoadFail').style.display='none'">OK</button>
    </div>
  </div>
</div>
	<div class="w3-container">
	  <div align="center" id='questionDetailNotFound' style="display:none"><span style="color:red"><b>No Diploma found</b></span></div>
	  <div align="center" id='questionDetailFound' style="display:none"><span style="color:blue"><b>QUESTION PAPER DETAILS LOADED SUCCESSFULLY</b></span></div>
		 <div class="w3-third">
			
			<label class="w3-text-brown"><b>Diploma Code:</b></label>
			<input class="w3-input w3-border " type="text" id="qdiplomaCode" value="BM" >
		
		  
		  </div>


<div id="getQuestPaper" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('getQuestPaper').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide"></h2>
      <p>QUESTION PAPER LOADED SUCCESSFULLY</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('getQuestPaper').style.display='none'">OK</button>
    </div>
  </div>
</div>

<div id="getQuestPaperFail" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('getQuestPaperFail').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide"></h2>
      <p>QUESTION PAPER NOT FOUND</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('getQuestPaperFail').style.display='none'">OK</button>
    </div>
  </div>
</div>
		  
		   <div class="w3-third">
		    <label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-blue" id="searchquestion" onclick="getQuestion1()">&nbsp;&nbsp;Get Question Paper</button>
			<button class="w3-button w3-red" onclick="clearQuestionPaper()" >Clear</button>
		  </div>
	</div>
	<br>
	<div class="w3-container" id="showData">

		 <div class="w3-third" id="showTableData">			  
		  	 <div class="table-responsive"  id="quesTableDiv"  align ="center"> <!-- style="display: none;" -->
				<table class="table-bordered text-sm-left table-striped" style="border: 2px solid #ddd !important;" id="quesTable">
				</table>
				</div>
			</div>
	<br>
	
	 </div>
   </div>
   <br>
 </div>
</div>

<!--  Print Questions Pickup list  -->

	 
	 <!--  Serach by exam sem mon and year and the duration
	 	per diploma name  get the name , prcode prno, and  for all diplomas 
	  -->

	<div class="w3-padding-64 w3-light-grey w3-card-4" id=pickupQuestions>
		<center> <h2>Question Papers Pick up List: </h2></center><br><br>
		
		<div class="w3-panel w3-pale-green">
	  <div class="w3-container" >
	
	<BR>
	
				
		<div class="w3-half">
			<label class="w3-text-brown"><b>Exam Semester Month:</b></label>
			<input class="w3-input w3-border " type="text" id="QAsemMonthName" >
		  </div>
		  
		  <div class="w3-half">
			<label class="w3-text-brown"><b>Exam Semester Year:</b></label>
			<input class="w3-input w3-border " type="year" id="QAsemYearName"  ><br>
		  </div>
			
  			
  			
<!-- stateCodeWorking -->
			<label class="w3-text-brown"><b> Exam State:</b>&nbsp;</label>	<!--  onchange="getSelectedStatecode()" -->
			
			<input list="examStateCodeList_updt2" class="w3-text-brwon" 
			name="examStateCodeUpd2" id="examStateCodeUpd2" placeholder="Choose your option" 
			onchange="getSelectedStatecode('examStateCodeUpd2','examStateCodeList_updt2','examCenterCodeList_updt2')">
	  		
	  		<datalist id="examStateCodeList_updt2" >
		  		<option selected value="Choose your option"></option>	
		  		<option value=""></option>	
	  		</datalist>	
	  
		<BR>
 		  <BR>
 		  <script>loadStateAndCenters('examStateCodeList_updt2');</script>
		 
		
 		  <label class="w3-text-brown"><b> Exam Center:</b>&nbsp;</label>		
		<input list="examCenterCodeList_updt2" class="w3-text-brwon"  name="QAexamCenterCode" id="QAexamCenterCode" placeholder="Choose your option">
  		<datalist id="examCenterCodeList_updt2" onchange="getSelectedCentercode()">
  		<option selected value="Choose your option"></option>	
  		
  		<option value=""></option>	
		
  		<!--  SAKTHI get from DB data-->
  		
  		</datalist>	
  		
 		  <BR><BR>
 	 
		  </div>
		
		<BR>
   		
	
		<Center>				 
			<button class="w3-button w3-green" id="QuestionPaperListPdf" onclick="printQuestionPaperList()">&nbsp;&nbsp;Get QuestionPaper List</button><br> <br>
		 </Center>

<br>
</div>
</div>

<!--   attendanceChart  ???? -->

<!--  Serach by exam sem mon and year and the duration
	 	per diploma name  get the name , prcode prno, and  for all diplomas 
	  -->

	<div class="w3-padding-64 w3-light-grey w3-card-4" id=attendanceChart>
		<center> <h2>Attendance Chart: </h2></center><br><br>
		
		<div class="w3-panel w3-pale-green">
	  <div class="w3-container" >
	
	<BR>
	
				
		<div class="w3-third">
			<label class="w3-text-brown"><b>Exam Semester Month:</b></label>
			<input class="w3-input w3-border " type="text" id="ACsemMonthName" >
		  </div>
		  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>Exam Semester Year:</b></label>
			<input class="w3-input w3-border " type="year" id="ACsemYearName"  >
		  </div>
			<div class="w3-third">
				<label class="w3-text-brown"><b> Duration:</b>&nbsp;</label>
				<select class="w3-select" name="option" id="ACduration">
		    		<option value="" disabled selected>Choose your option</option>
	    			<option value="SIX MONTHS">SIX MONTHS</option>
		    		<option value="ONE YEAR">ONE YEAR</option>
		   		 	<option value="ONE YEAR-PG">ONE YEAR-PG</option>
		  		</select><br><br>
  			</div>
  			 			
  					  
		<label class="w3-text-red"><b> Diploma:</b>&nbsp;</label>
		
  		<input list="diplomaCodeList" name="diplomaCodeName" id="ACdiplomaCode" placeholder="Choose your option">
  		<datalist id="diplomaCodeList" onchange="getSelectedDipcode()">
  		<option selected value="Choose your option"></option>
		
			<%
			if(wholeList.size()>0 ){
				for (Map.Entry<String,String> entry : wholeList.entrySet()) { 
					//System.out.println(entry.getKey()+"- - "+entry.getValue());
				String code = entry.getKey().substring(entry.getKey().indexOf("~")+1, entry.getKey().length());
				String value = entry.getValue().substring(entry.getValue().indexOf("^")+1, entry.getValue().length());
				String no_of_paper = entry.getValue().substring(entry.getValue().indexOf("~")+1,entry.getValue().indexOf("@"));
				//System.out.println("paper - - "+no_of_paper.length());
				%>
				<option data-id="<%=code%>$<%=no_of_paper%>" value="<%=code%> / <%=value %>"></option>
    			<!-- <option value="<%=entry.getKey() %>" ><%=code%> / <%=value %></option> -->
    		<%}} %>
    		</datalist>
    	
  		<script> 
    	//sort_select();
    	//itemSelect(document.getElementById('diplomaCode'));
    	</script>
  		<br><br>
  		<input type="hidden" name="diplomaCodeName" >
  			
  			
<!-- stateCodeWorking chart-->
			<label class="w3-text-brown"><b> Exam State:</b>&nbsp;</label>	<!--  onchange="getSelectedStatecode()" -->
			
			<input list="examStateCodeList_updt3" class="w3-text-brwon" 
			name="examStateCodeUpd3" id="examStateCodeUpd3" placeholder="Choose your option" 
			onchange="getSelectedStatecode('examStateCodeUpd3','examStateCodeList_updt3','examCenterCodeList_updt3')">
	  		
	  		<datalist id="examStateCodeList_updt3" >
		  		<option selected value="Choose your option"></option>	
		  		<option value=""></option>	
	  		</datalist>	
	  
		<BR>
 		  <BR>
 		  <script>loadStateAndCenters('examStateCodeList_updt3');</script>
		 
		
 		  <label class="w3-text-brown"><b> Exam Center:</b>&nbsp;</label>		
		<input list="examCenterCodeList_updt3" class="w3-text-brwon"  name="ACexamCenterCode" id="ACexamCenterCode" placeholder="Choose your option">
  		<datalist id="examCenterCodeList_updt3" onchange="getSelectedCentercode()">
  		<option selected value="Choose your option"></option>	
  		
  		<option value=""></option>	
		
  		<!--  SAKTHI get from DB data-->
  		
  		</datalist>	
  		
 		  <BR><BR>
 	 
		  </div>
		
		<BR>
   		
	
		<Center>				 
			<button class="w3-button w3-green" id="applicantListPdf" onclick="getAttendChart()">&nbsp;&nbsp;Get Attendance Chart</button><br> <br>
		 </Center>

<br>
</div>
</div>
	 

 
 <!-- PRINT  Mark Sheet -------------->
 
 <div class="w3-padding-64 w3-light-grey w3-card-4" id=markSheet>
		<center> <h2>View and Print Mark sheet </h2></center>
	  <form class="w3-container" action="/action_page.php">
		<p><center>
		<button class="w3-button w3-green">Print</button>
		</center></p>
	  </form>
	</div>

	 <div class="w3-padding-64 w3-light-grey w3-card-4" id=mailAddress>
		<center> <h2>View & Print Mailing Address</h2></center>
	  <form class="w3-container" action="/action_page.php">
		<p><center>
		<button class="w3-button w3-green">Print</button>
		</center></p>
	  </form>
	</div>


<!-- VERIFICATION ----------------------------------------------------------------------------------------------------------------------------------->

<!--  get PR no by NAME -->
	 
		
	<div class="w3-padding-64 w3-light-grey w3-card-4" id=verifyName>
		<center> <h2>Find PR Code and PR No: </h2></center><br><br>
		
		<div class="w3-panel w3-pale-green">
	  <div class="w3-container" >
	
	<BR>
	
	<label class="w3-text-red"><b>Name:</b></label>
		<input class="w3-input w3-border " name="last" type="text" id="stuNamesearch" ><br>
	
		
		<label class="w3-text-red"><b> Diploma:</b>&nbsp;</label>
		
  		<input list="diplomaCodeList" name="diplomaCodeName" id="diplomaCode3" placeholder="Choose your option">
  		<datalist id="diplomaCodeList" onchange="getSelectedDipcode()">
  		<option selected value="Choose your option"></option>
		
			<%
			if(wholeList.size()>0 ){
				for (Map.Entry<String,String> entry : wholeList.entrySet()) { 
					//System.out.println(entry.getKey()+"- - "+entry.getValue());
				String code = entry.getKey().substring(entry.getKey().indexOf("~")+1, entry.getKey().length());
				String value = entry.getValue().substring(entry.getValue().indexOf("^")+1, entry.getValue().length());
				String no_of_paper = entry.getValue().substring(entry.getValue().indexOf("~")+1,entry.getValue().indexOf("@"));
				//System.out.println("paper - - "+no_of_paper.length());
				%>
				<option data-id="<%=code%>$<%=no_of_paper%>" value="<%=code%> / <%=value %>"></option>
    			<!-- <option value="<%=entry.getKey() %>" ><%=code%> / <%=value %></option> -->
    		<%}} %>
    		</datalist>
    	
  		<script> 
    	//sort_select();
    	//itemSelect(document.getElementById('diplomaCode'));
    	</script>
  		<br><br>
  		<input type="hidden" name="diplomaCodeName" >
  		
				
		<div class="w3-third">
			<label class="w3-text-brown"><b>Semester Month:</b></label>
			<input class="w3-input w3-border " type="text" id="semMonthName" >
		  </div>
		  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>Semester Year:</b></label>
			<input class="w3-input w3-border " type="year" id="semYearName"  >
		  </div>
				  
 		<div class="w3-third">
			<BR><BR><BR>
		  </div>

 		
		<BR>
   
		
		
		<Center>
				 
 			<label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-blue" id="nameResultName" onclick="searchByNamefind()">Search</button><br> <br>
	 </Center>

<br>
		<!--  SAKTHI,  create a Dynamic Table with NAME, PRCode, PR No and Diploma Code \Diploma name -->
		<!--  add a clear button -->	
		
		
		
		<div class="table-responsive" id="resultTableName1" align ="center">
	  
	 
	 
	 
	 <!-- table base -->
		<table class="table-bordered text-sm-left table-striped" style="border: 2px solid #ddd !important;" >
		<thead>
			<tr>
				<th >Name</th>
				<th >PR Code</th>
				<th >PR No</th>
				<th >Diploma Name</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>from DB name 1</td>
				<td>from DB PR code 1</td>
				<td>from DB PR no 1</td>
				<td>from DB diplom 1</td>
				

			</tr>
			<tr>
				<td>from DB name ..n</td>
				<td>from DB PR code ..n</td>
				<td>from DB PR no ..n</td>
				<td>from DB diplom ..n</td>
			</tr>
				
			
		</tbody>
		
		</table>
		  
		    <label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-blue" id="nameResultName" onclick="clearBtn()">Clear</button><br> <br>
		
	 </div>
		  
		</center></p>
	  </div>
	  </div>
	</div>

<!--  student History -->

 <div class="w3-padding-64 w3-light-grey w3-card-4" id=search1>
		<center> <h2>Student History</h2></center>
	<div class="w3-panel w3-pale-green">
		 <p>Search for Student information based on P.R.No.</p>
  	<div class="w3-container">
		<p>
		 <div class="w3-third">
			<label class="w3-text-red"><b>P.R.Code:</b></label>
			<input class="w3-input w3-border " type="text" id="prCode"  placeholder="APR13">
		  </div>
				  
		  <div class="w3-third">
			<label class="w3-text-red"><b>P.R.No:</b></label>
			<input class="w3-input w3-border " type="text" id="prNo"  placeholder="286">
		  </div>

		  <div class="w3-third">
		    <label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-blue" id="result" onclick="searchByPrCodePrNo()">&nbsp;&nbsp;Search</button><br> <br>
		  </div>
		 

		</p>


	 </div>

	 <div class="table-responsive" id="resultTable" style="display: none;" align ="center">
	  
	 
	 
	 
	 <!-- table base -->
		<table class="table-bordered text-sm-left table-striped" style="border: 2px solid #ddd !important;" >
		<thead>
			<tr>
				<th >Name</th>
				<th >Value</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Student Name</td>
				<td id="sa_name"></td>

			</tr>
			<tr>
				<td>Diploma Duration</td>
				<td id="ad_durtn"></td> 
			</tr>
			<tr>
 				<td>Diploma Code</td> 
				<td id="ad_dipcode"></td> 
			</tr>
			
			
			<tr>
				<td >Admission Semester Month</td>
				<td id="ad_sesmon"></td> 
			</tr>
			<tr>
				<td >Admission Semester Year</td>
				<td id="ad_sesyr"></td> 
			</tr>
			<tr>
				<td >Number of papers</td>
				<td id="ad_nofpapr"></td> 
			</tr>
			<tr>
				<td >Fee Amount</td>
				<td id="ad_feeamt"></td> 
			</tr>
			<tr>
				<td >Fee Paid Amount</td>
				<td id="fe_amount"></td> 
			</tr>
			<tr>
				<td >Fee paid Date</td>
				<td id="fe_date"></td> 
			</tr>
			<tr>
				<td >Address1</td>
				<td id="sa_add1"></td> 
			</tr>
			<tr>
				<td >Address2</td>
				<td id="sa_add2"></td> 
			</tr>
			<tr>
				<td >Address3</td>
				<td id="sa_add3"></td> 
			</tr>
				<tr>
				<td >Address4</td>
				<td id="sa_add4"></td> 
			</tr>
			
			<tr>
				<td >State</td>
				<td id="sa_state"></td> 
			</tr>
			<tr>
				<td >Pincode</td>
				<td id="sa_pincode"></td> 
			</tr>
			<tr>
				<td >Phone</td>
				<td id="sa_phone"></td> 
			</tr>
			<tr>
				<td >Mobile</td>
				<td id="sa_mobile"></td> 
			</tr>
			<tr>
				<td >Email</td>
				<td id="sa_email"></td> 
			</tr>
			
			<tr>
				<td >Exam State</td>
				<td id="ea_stname"></td> 
			</tr>
			<tr>
				<td >Exam Center</td>
				<td id="ea_center1"></td> 
			</tr>
			<tr>
				<td >Exam Papers</td>
				<td id="ea_paprstr"></td> 
			</tr>
			<tr>
				<td >Exam Pass Flag</td>
				<td id="ea_passflg"></td> 
			</tr>
			<tr>
				<td >Exam End Date</td>
				<td id="ea_entdate"></td> 
			</tr>
			<tr>
				<td >Exam Pass Flag</td>
				<td id="ea_passflg"></td> 
			</tr>
			
			
			<tr>
				<td >Marks Paper No</td>
				<td id="ap_paper"></td> 
			</tr>
			<tr>
				<td >Marks Paper Name   TODO mulitple ?</td>
				<td id="ap_paprname"></td> 
			</tr>
			<tr>
				<td >Marks </td>
				<td id="ap_mark"></td> 
			</tr>
			<tr>
				<td >Exam Date</td>
				<td id=""></td> 
			</tr>
			
			<tr>
				<td >Intimation Date</td>
				<td id="ap_mrkdate"></td> 
			</tr>
			
			<tr>
				<td >Hallticket Date</td>
				<td id="ap_mrkdate"></td> 
			</tr>
			
			
			
			
			
		</tbody>
		
		</table>
		  
		    <label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-blue" id="result" onclick="clearBtn()">Clear</button><br> <br>
		
	 </div>
	</div>
</div>




<!-- MAINTANCE  - Diploma update -------------------------------------------------------------------------------------------------------------->


	<div class="w3-padding-64 w3-light-grey w3-card-4" id=diplomaUpdate>
		<center> <h2>Diplomas updation</h2></center><br><br>
		
		<div class="w3-panel w3-pale-green">
	  <div class="w3-container" >
	

	<div class="w3-container">

		 <div class="w3-third">
			
		
			<label class="w3-text-brown"><b>Diploma Code:</b></label>
			<input class="w3-input w3-border " type="text" id="diplomaCode1"  placeholder="BM" >
		
		  
		  </div>
		  
		   <div class="w3-third">
		    <label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-blue" id="diplomaResult" onclick="searchDiplomas()">&nbsp;&nbsp;Search</button><br>
		  </div>
				  
		  <div class="w3-third">
		
		  </div>
		  
	

	 </div>
	 
	 

<br>
		
	  	<label class="w3-text-brown"><b>Diploma Name:</b></label>
		<input class="w3-input w3-border "  id="diplomaName" type="text"><br>
		
		<label class="w3-text-brown"><b>DC Diploma Name:</b></label>
		<input class="w3-input w3-border"  id="dcDiplomaName" type="text"><br>
		
		<label class="w3-text-brown" ><b>Number of Papers&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
		<input type="text"  maxlength="2" id="noPaper" size="2"><br><br>
		
		<p><center>
		<button class="w3-button w3-blue" onclick="updateDiplomas()" >Update</button>
		
			<button class="w3-button w3-blue" onclick="insertDiplomas()" >Add New Diploma</button>
			
			 <button class="w3-button w3-red" onclick="clearDiplomaUpdation()" >Clear</button>
		</center></p>
	  </div>
	  </div>
	</div>
	
	<!-- Institute Address update -->

 <div class="w3-padding-64 w3-light-grey w3-card-4" id=addressUpdate>
		<center> <h2>Institute Address update</h2></center><br><br>
		
		<div class="w3-panel w3-pale-green">
	  <div class="w3-container" >
	  
	  
	  
	   	<div class="w3-container">

		 <div class="w3-third">
			<label class="w3-text-brown"><b> Institute Code:</b>&nbsp;</label>
		<select class="w3-select" name="option" id="insituteCode">
    		<option value="" disabled selected>Choose your option</option>
    		<option value="AIIMS">AIIMS</option>
    		<option value="AICOMAS">AICOMAS</option>
    		<option value="IIMT">IIMT</option>
   		 	<option value="NCLM">NCLM</option>
  		</select>
		  </div>
		  
		  

		  
		  
		  
		  
		   <div class="w3-third">
		    <label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-blue" id="instResult" onclick="searchInstitue()">&nbsp;&nbsp;Search</button><br>
		  </div>
				  
		  <div class="w3-third">
		
		  </div>

	 </div>
	  
	  	    <label class="w3-text-brown"><b></b></label>
			 		
  		
		<br><br>
		
	  	<label class="w3-text-brown"><b>Institute Name::</b></label>
		<input class="w3-input w3-border " id="instituteName" type="text"><br>
		
		<label class="w3-text-brown"><b>Institute Address:</b></label>
		<input class="w3-input w3-border " id="instituteAddress" type="text"><br>
		
		<label class="w3-text-brown"><b>Institute PhoneNumber:</b></label>
		<input class="w3-input w3-border " id="institutePhNumbers" type="text"><br>
		<p><center>
		<button class="w3-button w3-blue" onclick="updateInstitue()">Update</button>
		<button class="w3-button w3-red" onclick="clearInstituteUpdation()" >Clear</button>
		</center></p>
	  </div>
	  </div>
	</div>





</div>

  <div class="w3-black w3-center w3-padding-24">By AIIMAS Group  </div>
  
 </div>

  <!-- End page content --------------------------------------------------------------------------------------------------------------------------->
 <!-- End page content --------------------------------------------------------------------------------------------------------------------------->
<!-- Newsletter Modal -->
<div id="newsletter" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('newsletter').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide">Do you want Logout</h2>
      <p>Please press "OK" to logout, else Cancel</p>
     
      <button type="button" class="w3-button w3-padding-large w3-red w3-margin-bottom" onclick="document.getElementById('newsletter').style.display='none'">Logout</button>

	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('newsletter').style.display='none'">Cancel</button>
    </div>
  </div>
</div>

<div id="examUpdateApplication" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('examUpdateApplication').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide">Update Exam Application</h2>
      <p>Successful !!!</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('examUpdateApplication').style.display='none'">OK</button>
    </div>
  </div>
</div>

<div id="examUpdateApplicationfail" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('examUpdateApplicationfail').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide">Update Exam Application</h2>
      <p style="color:red">Failed !!</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('examUpdateApplicationfail').style.display='none'">OK</button>
    </div>
  </div>
</div>


<div id="saveMark" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('saveMark').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide">Save Marks</h2>
      <p>Successful !!!</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('saveMark').style.display='none'">OK</button>
    </div>
  </div>
</div>

<div id="saveMarkFail" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('saveMarkFail').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide">Save Marks</h2>
      <p style="color:red">Failed !!</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('saveMarkFail').style.display='none'">OK</button>
    </div>
  </div>
</div>

<div id="saveMark1" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('saveMark1').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide">Update Marks</h2>
      <p>Successful !!!</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('saveMark1').style.display='none'">OK</button>
    </div>
  </div>
</div>

<div id="saveMarkFail1" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('saveMarkFail1').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide">Update Marks</h2>
      <p style="color:red">Failed !!</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('saveMarkFail1').style.display='none'">OK</button>
    </div>
  </div>
</div>

<div id="examApplication" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('examApplication').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide">ADD Exam Application</h2>
      <p>Successful !!!</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('examApplication').style.display='none'">OK</button>
    </div>
  </div>
</div>

<div id="examApplicationfail" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('examApplicationfail').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide">ADD Exam Application</h2>
      <p style="color:red">Failed !!</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('examApplicationfail').style.display='none'">OK</button>
    </div>
  </div>
</div>

<div id="deleteadmission" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('deleteadmission').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide">Delete Admission</h2>
      <p>Successful !!!</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('deleteadmission').style.display='none'">OK</button>
    </div>
  </div>
</div>


<div id="deleteadmissionFail" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('deleteadmissionFail').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide">Delete Admission</h2>
      <p style="color:red">Failed !!!</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('deleteadmissionFail').style.display='none'">OK</button>
    </div>
  </div>
</div>


<div id="update_admission" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('update_admission').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide">Update Admission</h2>
      <p>Successful !!!</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('update_admission').style.display='none'">OK</button>
    </div>
  </div>
</div>

<div id="update_admissionFail" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('update_admissionFail').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide">Update Admission</h2>
      <p style="color:red">Failed !!!</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('update_admissionFail').style.display='none'">OK</button>
    </div>
  </div>
</div>



<div id="newadmission" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('newadmission').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide">ADD Admission Application</h2>
      <p>Successful !!!</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('newadmission').style.display='none'">OK</button>
    </div>
  </div>
</div>

<div id="newadmissionfail" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('newadmissionfail').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide">ADD Admission Application</h2>
      <p style="color:red">Failed !!</p>
     
	 <button type="button" class="w3-button w3-padding-large w3-blue w3-margin-bottom" onclick="document.getElementById('newadmissionfail').style.display='none'">OK</button>
    </div>
  </div>
</div>

<!-- Modal aria-labelledby="Modal-vert-center-demo-label" aria-hidden="true" -->
 <div id="myModal2" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
<!-- <div class="modal fade" id="Modal-Admission" tabindex="-1" role="dialog" >  -->
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="Modal-vert-center-demo-label">Add Admission</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
 
      <div class="modal-body">
        Admission created successfully
      </div>
 
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<script>
// Accordion 
function myAccFunc() {
  var x = document.getElementById("demoAcc");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else {
    x.className = x.className.replace(" w3-show", "");
  }
}
// Accordion  for print
function myAccFunc1() {
  var x = document.getElementById("demoAcc1");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else {
    x.className = x.className.replace(" w3-show", "");
  }
}
// Accordion  for Verify
function myAccFunc2() {
  var x = document.getElementById("demoAcc2");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else {
    x.className = x.className.replace(" w3-show", "");
  }
}
// Accordion  for Maintenace
function myAccFunc3() {
  var x = document.getElementById("demoAcc3");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else {
    x.className = x.className.replace(" w3-show", "");
  }
}
// Open and close sidebar
function w3_open() {
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("myOverlay").style.display = "none";
}


populateState();
</script>

</body>
</html>