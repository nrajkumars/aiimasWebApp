<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    

<html>
<title>AIIMAS App</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">-->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">  -->
<!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat"> -->

<!-- <script src="js/app1.js?ver=1"></script> -->

<script src="js/app2.js"></script> 



  <link href="lib/w3.css" rel="stylesheet">
  <link rel="stylesheet" href="lib/font-awesome-4.7.0/css/font-awesome.min.css">
  <link href="lib/montserratcss" rel="stylesheet">
  <link href="lib/roboto.css" rel="stylesheet">

<style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
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
	   <a href="#admApp" class="w3-bar-item w3-button">Add - Admission Application</a>
	    <a href="#admApp" class="w3-bar-item w3-button">Modify - Admission Application</a>
      <a href="#examApp" class="w3-bar-item w3-button">Examination Application</a>
      <a href="#markUpdate" class="w3-bar-item w3-button">Mark Updation</a>
    </div>



    <a onclick="myAccFunc1()" href="#ack1" class="w3-button w3-block w3-white w3-left-align" id="myBtn1">
      Print/View&nbsp;<i class="fa fa-caret-down"></i>
    </a>
    <div id="demoAcc1" class="w3-bar-block w3-hide w3-padding-large w3-medium">
	  <a href="#ack1" class="w3-bar-item w3-button">Ack./ Intimation</a>
      <a href="#markSheet" class="w3-bar-item w3-button">Mark Sheet</a>
      <a href="#mailAddress" class="w3-bar-item w3-button">Mailing Address</a>
    </div>


    <a onclick="myAccFunc2()" href="#search1" class="w3-button w3-block w3-white w3-left-align" id="myBtn2">
      Verification&nbsp;<i class="fa fa-caret-down"></i>
    </a>
    <div id="demoAcc2" class="w3-bar-block w3-hide w3-padding-large w3-medium">
	  <a href="#search1" class="w3-bar-item w3-button">Search by P.R.No</a>
      <a href="#search2" class="w3-bar-item w3-button">Search by Name</a>

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
 

   <div class="w3-padding-64 w3-light-grey w3-card-4" id=admApp>
		<center> <h2>Admission Application</h2>
		<p>Add, Modify and Delete the Student application</p>
		</center>
	  <div class="w3-container">
		<p>   
		
		  
		<label class="w3-text-brown"><b> Diploma:</b>&nbsp;</label>
		<input type="text" name="diplomaCode" maxlength="5" size="5">&nbsp;&nbsp;&nbsp;
  		<input type="text" name="diplomaName" maxlength="80" size="80"><br><br>
  		
  		
  		
		<div class="w3-third">
		<label class="w3-text-brown"><b> Duration:</b>&nbsp;</label>
		<select class="w3-select" name="option">
    		<option value="" disabled selected>Choose your option</option>
    		<option value="1">Six Months</option>
    		<option value="2">One Year- PG</option>
    		<option value="3">18 Months- PG</option>
   		 	<option value="3">One Year</option>
  		</select>
  	</div>
   
    
  		
		<br><br><br><br>

		
		<div class="w3-third">
			<label class="w3-text-brown"><b>Semester Month:</b></label>
			<input class="w3-input w3-border " type="text" >
		  </div>
		  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>Semester Year:</b></label>
			<input class="w3-input w3-border " type="year" >
		  </div>
				  


 		  <div class="w3-third"> 
			<label class="w3-text-brown"><b>Entered on:</b></label>
 			<input class="w3-input w3-border " type="date"><br>
 		  </div> 

		<div class="w3-third">
			<label class="w3-text-brown"><b>P.R.Code:</b></label>
			<input class="w3-input w3-border " type="text" value = "" id="prCode11" >
		  </div>
				  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>P.R.No:</b></label>
			<input class="w3-input w3-border " type="text" value = ""  id="prNo1">
		  </div>
		  
		  
		  <div class= "w3-third w3-container w3-border w3-Small">
  			<div class="w3-left-align"><p>Current Batch No:</p></div>
  			<div class="w3-left-align"><p>Last Batch No:</p></div>
		  </div>


<!-- 		  <div class="w3-third"> -->
<!-- 		    <label class="w3-text-brown"><b>&nbsp;</b></label><br> -->
<!-- 		    <label class="w3-text-brown"><b>&nbsp;</b></label><br> -->
<!--  			<button class="w3-button w3-blue" onclick="searchByPrCodePrNo()">&nbsp;&nbsp;Search</button><br>  -->
<!-- 			<br><br> -->
<!-- 		  </div> -->
		  
<!-- 		  <div class="w3-third"> -->
<!-- 		    <label class="w3-text-brown"><b>&nbsp;</b></label><br> -->
<!-- 			<button class="w3-button w3-blue" onclick="searchByPrCodePrNo()">&nbsp;&nbsp;Search</button><br> -->
<!-- 			<br> -->
<!-- 		  </div> -->

<!-- 		<label class="w3-text-brown"><b>Reference:</b></label> -->
<!-- 		<input class="w3-input w3-border " name="first" type="text"><br> -->


   
		<label class="w3-text-brown"><b>Name:</b></label>
		<input class="w3-input w3-border " name="last" type="text"><br>
				
		<div class="w3-third">
		<label class="w3-text-brown"><b> Sex:</b>&nbsp;</label>
		<select class="w3-select" name="option">
    		<option value="" disabled selected>Choose your option</option>
    		<option value="1">Male</option>
   	 	   	<option value="3">Female</option>
  		</select>&nbsp;&nbsp;
   		</div>
   
   
   		<div class="w3-third"> 
			<label class="w3-text-brown"><b>Date of Birth:</b></label>
 			<input class="w3-input w3-border " type="date"><br>
 		  </div> 
   
		<br><br><br><br>
		
		<label class="w3-text-brown"><b>Address 1:</b></label>
		<input class="w3-input w3-border " name="last" type="text"><br>
		<label class="w3-text-brown"><b>Address 2:</b></label>
		<input class="w3-input w3-border " name="last" type="text"><br>
		<label class="w3-text-brown"><b>Address 3:</b></label>
		<input class="w3-input w3-border " name="last" type="text"><br>
		<label class="w3-text-brown"><b>Address 4:</b></label>
		<input class="w3-input w3-border " name="last" type="text"><br>
		<label class="w3-text-brown"><b>Address 5:</b></label>
		<input class="w3-input w3-border" name="last" type="text"><br>


		<label class="w3-text-brown" ><b>Pincode:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
		<input type="text" name="pincode" maxlength="10" size="10"><br><br>

		<label class="w3-text-brown" ><b>Ph/Mobile: &nbsp;</b></label>
		<input type="text" name="mobile" maxlength="15" size="15"><br><br>

		<label class="w3-text-brown" ><b>Email Add:&nbsp;</b></label>
		<input type="text" name="email" maxlength="25" size="25"><br><br>


		<label class="w3-text-brown" ><b>Due date:&nbsp;</b></label>
		<input type="date" name="diplomaCode" maxlength="5" size="5"><br><br>

		<label class="w3-text-brown" ><b>Total Fee:&nbsp;&nbsp;</b></label>
		<input type="text" name="diplomaCode" maxlength="5" size="5"><br><br>

		<label class="w3-text-brown" ><b>Papers:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
		<input type="text" name="papers" maxlength="2" size="2"><br><br><br>


		<center>
		<button class="w3-button w3-blue" onclick="" >Save</button>
		<button class="w3-button w3-orange onclick="" >Update</button>
		<button class="w3-button w3-red" onclick="" >Delete</button>
		</center>

		</p>
	  </div>
	</div>



<!-- Exam application update ------------------------------------------------------------------------------------------------------------------>

 <div class="w3-padding-64 w3-light-grey w3-card-4" id=examApp>
		<center> <h2>Exam Application</h2></center>
	  <form class="w3-container" action="/action_page.php">
		<p><center>
		<button class="w3-button w3-blue">Save</button>
		</center></p>
	  </form>
	</div>




<!-- MARK update --------------------------------------------------------------------------------------------------------------------------------->

 <div class="w3-padding-64 w3-light-grey w3-card-4" id=markUpdate>
		<center> <h2>Mark Updataion</h2></center>
	  <form class="w3-container" action="/action_page.php">
		<p><center>
		<button class="w3-button w3-blue">Save</button>
		</center></p>
	  </form>
	</div>



<!-- PRINT / VIEW ---------------------------------------------------------------------------------------------------------------------------------->

 <div class="w3-padding-64 w3-light-grey w3-card-4" id=ack1> 
		<center> <h2>View and Print Ack./ Intimation</h2></center>
	  <form class="w3-container" action="/action_page.php">
		<p><center>
		<button class="w3-button w3-green">Print</button>
		</center></p>
	  </form>
	</div>
  
 
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

 <div class="w3-padding-64 w3-light-grey w3-card-4" id=search1>
		<center> <h2>Verification by P.R. No.</h2></center>
	<div class="w3-panel w3-pale-green">
		 <p>Search for Student information based on P.R.No.</p>
  	<div class="w3-container">
		<p>
		 <div class="w3-third">
			<label class="w3-text-brown"><b>P.R.Code:</b></label>
			<input class="w3-input w3-border " type="text" id="prCode" >
		  </div>
				  
		  <div class="w3-third">
			<label class="w3-text-brown"><b>P.R.No:</b></label>
			<input class="w3-input w3-border " type="text" id="prNo" >
		  </div>

		  <div class="w3-third">
		    <label class="w3-text-brown"><b>&nbsp;</b></label><br>
			<button class="w3-button w3-blue" onclick="searchByPrCodePrNo()">&nbsp;&nbsp;Search</button><br> <br>
		  </div>
		</p>
	 </div>
	</div>
</div>
	 
		
 <div class="w3-padding-64 w3-light-grey w3-card-4" id=search2>
	<center> <h2>Verfication by Name and Diploma name.</h2></center>
		<div class="w3-panel w3-pale-green">
		 <p>Search for Student information based on Name and Diploma name.</p>

		<div class="w3-container">
		 <p>   
		
		  
		<label class="w3-text-brown" ><b>Diploma:&nbsp;</label>
		<input type="text" name="diplomaCode" maxlength="5" size="5">&nbsp;&nbsp;&nbsp;
  		<input type="text" name="diplomaName" maxlength="80" size="60"><br><br>

		<label class="w3-text-brown" ><b>Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		<input type="text" name="pincode" maxlength="80" size="60"><br><br>
			
			  
	    <label class="w3-text-brown" ><b>Semester:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		<input type="text" name="pincode" maxlength="10" size="10"><br><br>

		<label class="w3-text-brown" ><b>Duration:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		<input type="text" name="pincode" maxlength="10" size="10"><br><br>

	 
		
		<label class="w3-text-brown" ><b>Pincode:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
		<input type="text" name="pincode" maxlength="10" size="10"><br><br>

		<label class="w3-text-brown" ><b>Ph/Mobile: &nbsp;</label>
		<input type="text" name="mobile" maxlength="15" size="15"><br><br>

		<label class="w3-text-brown" ><b>Email Add:&nbsp;</label>
		<input type="text" name="email" maxlength="25" size="25"><br><br>


		<center><button class="w3-button w3-blue">Search</button></center>

		</p>
	  </div>
	  </div>


<!-- MAINTANCE  - Diploma update -------------------------------------------------------------------------------------------------------------->


	<div class="w3-padding-64 w3-light-grey w3-card-4" id=diplomaUpdate>
		<center> <h2>Diplomas updation</h2></center><br><br>
	  <div class="w3-container" >
	    <label class="w3-text-brown"><b></b></label>
	
		
		<label class="w3-text-brown" ><b>Diploma Code:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
		<input type="text" name="papers" maxlength="10" size="10"><br><br>
		
	  	<label class="w3-text-brown"><b>Diploma Name:</b></label>
		<input class="w3-input w3-border " name="instituteName" type="text"><br>
		
		<label class="w3-text-brown"><b>DC Diploma Name:</b></label>
		<input class="w3-input w3-border " name="instituteAddress" type="text"><br>
		
		<label class="w3-text-brown" ><b>Number of Papers&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
		<input type="text" name="papers" maxlength="2" size="2"><br><br>
		
		<p><center>
		<button class="w3-button w3-blue">Save</button>
		</center></p>
	  </div>
	</div>
	




	<!-- Institute Address update -->

 <div class="w3-padding-64 w3-light-grey w3-card-4" id=addressUpdate>
		<center> <h2>Institute Address updation</h2></center><br><br>
	  <div class="w3-container" >
	    <label class="w3-text-brown"><b></b></label>
	
		
		<label class="w3-text-brown" ><b>Institute Code:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
		<input type="text" name="papers" maxlength="10" size="10"><br><br>
		
	  	<label class="w3-text-brown"><b>Institute Name:</b></label>
		<input class="w3-input w3-border " name="instituteName" type="text"><br>
		
		<label class="w3-text-brown"><b>Institute Address:</b></label>
		<input class="w3-input w3-border " name="instituteAddress" type="text"><br>
		
		<label class="w3-text-brown"><b>Institute PhoneNumber:</b></label>
		<input class="w3-input w3-border " name="instituteNumbers" type="text"><br>
		<p><center>
		<button class="w3-button w3-blue">Save</button>
		</center></p>
	  </div>
	</div>





</div>

  <div class="w3-black w3-center w3-padding-24">By <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-opacity">AIIMAS Group</a>
  </div>
  
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
</script>

</body>
</html>
    