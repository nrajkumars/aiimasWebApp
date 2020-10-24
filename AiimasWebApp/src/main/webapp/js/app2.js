function searchByPrCodePrNo() {
	
	console.log('searchByPrCodePrNo  on VERIFICATION clicked rajjj ');
	
	var prcode = document.getElementById('prCode').value;
	var prno = document.getElementById('prNo').value;
	
	
	if (prcode == "" || prno == "") {
			alert("Please enter the values in P.R.Code and P.R.No")
	  }else{
	
	postAjax('rs',{"app":"AiimasPost","module":"verification","action":"fullDetails","prNo":prno,"prCode":prcode}, onPostsearchByPrCodePrNo);
	}
}



function onPostsearchByPrCodePrNo(data) {
	console.log('RESPONSE POST in app .JS:' + data);
	var parsedData;
		
	if (data != null) {
			document.getElementById('resultTable').style.display = "block";
		
			try {
			// Parse JSON
			parsedData = JSON.parse(data);
			
		
			if(parsedData.Address["sa_name"]!=null){
				document.getElementById("sa_name").innerHTML = parsedData.Address["sa_name"];
			}
		
				
				if(parsedData.Admin["ad_durtn"]!=null){
					document.getElementById("ad_durtn").innerHTML = parsedData.Admin["ad_durtn"];
				}
		
				if(parsedData.Address["sa_dipcode"]!=null){
					document.getElementById("ad_dipcode").innerHTML = parsedData.Address["sa_dipcode"];
				}
				if(parsedData.Admin["ad_sesmon"]!=null){
					document.getElementById("ad_sesmon").innerHTML = parsedData.Admin["ad_sesmon"];
				}
		
				if(parsedData.Admin["ad_sesyr"]!=null){
					document.getElementById("ad_sesyr").innerHTML = parsedData.Admin["ad_sesyr"];
				}
				if(parsedData.Admin["ad_nofpapr"]!=null){
					document.getElementById("ad_nofpapr").innerHTML = parsedData.Admin["ad_nofpapr"];
				}
				if(parsedData.Admin["ad_feeamt"]!=null){
					document.getElementById("ad_feeamt").innerHTML = parsedData.Admin["ad_feeamt"];
				}
				if(parsedData.Fee["fe_amount"]!=null){
					document.getElementById("fe_amount").innerHTML = parsedData.Fee["fe_amount"];
				}
							
				if(parsedData.Fee["fe_date"]!=null){
					document.getElementById("fe_date").innerHTML = parsedData.Address["fe_date"];
				}		
				if(parsedData.Address["sa_add1"]!=null){
					document.getElementById("sa_add1").innerHTML = parsedData.Address["sa_add1"];
				}
				if(parsedData.Address["sa_add2"]!=null){
					document.getElementById("sa_add2").innerHTML = parsedData.Address["sa_add2"];
				}	
				if(parsedData.Address["sa_add3"]!=null){
					document.getElementById("sa_add3").innerHTML = parsedData.Address["sa_add3"];
				}
				if(parsedData.Address["sa_add4"]!=null){
					document.getElementById("sa_add4").innerHTML = parsedData.Address["sa_add4"];
				}
				if(parsedData.Address["sa_add5"]!=null){
					document.getElementById("sa_add5").innerHTML = parsedData.Address["sa_add5"];
				}	
				if(parsedData.Address["sa_state"]!=null){
					document.getElementById("sa_state").innerHTML = parsedData.Address["sa_state"];
				}
				if(parsedData.Address["sa_pincode"]!=null){
					document.getElementById("sa_pincode").innerHTML = parsedData.Address["sa_pincode"];
				}
				if(parsedData.Address["sa_phone"]!=null){
					document.getElementById("sa_phone").innerHTML = parsedData.Address["sa_phone"];
				}
				if(parsedData.Address["sa_mobile"]!=null){
					document.getElementById("sa_mobile").innerHTML = parsedData.Address["sa_mobile"];
				}
				if(parsedData.Address["sa_email"]!=null){
					document.getElementById("sa_email").innerHTML = parsedData.Address["sa_email"];
				}
			
		
			
			
			} catch (e) {
				console.log("data error, please check administrator");
			}
		
		
		

		}else{
		alert('else');
		document.getElementById('resultTable').style.display = "hide";
		}


}

// SEARCH by NAME for Verification

function searchByName() {
	
	console.log('searchByName  on VERIFICATION clicked rajjj ');
	
	var studentName = document.getElementById('studentName').value;
	//var prno = document.getElementById('prNo').value;
	
	
	if (studentName == "" ) {
			alert("Please enter the values in P.R.Code and P.R.No")
	  }else{
	
	postAjax('rs',{"app":"AiimasPost","module":"verifyByName","action":"byName","studentName":studentName}, onPostsearchByName);
	}
}



function onPostsearchByName(data) {
	console.log('RESPONSE POST in app .JS:' + data);
	var parsedData;
		
	if (data != null) {
			// TODO Sakthi
		
			try {
			// Parse JSON
			parsedData = JSON.parse(data);
			} catch (e) {
				console.log("data error, please check administrator");
			}
	}
}
			

// get EXam details

function getExamData() {
	
	console.log('getExamData  on EXAM clicked rajjj ');
	
	var prcode = document.getElementById('prCodeExam').value;
	var prno = document.getElementById('prNoExam').value;
	
	if (prcode == "" || prno == "") {
			alert("Please enter the values in P.R.Code and P.R.No")
	  }else{
	
		postAjax('rs',{"app":"AiimasPost","module":"ExamApplication","action":"examDetail","prNo":prno,"prCode":prcode}, onPostgetExamData);
	}
}

function onPostgetExamData(data) {
	console.log('RESPONSE POST in   onPostgetExamData  app .JS:' + data);
	var parsedData1;
		
	if (data != null) {
						
					
			try {
			// Parse JSON
			parsedData1 = JSON.parse(data);
			
					
			
			//TODO SAKTHI  LOAD the exam application screen with this values


		} catch (e) {
				console.log("data error, please check administrator");
			}
		
		
		

		}else{
		//alert('else');
		//document.getElementById('resultTable1').style.display = "hide";
		}

}

// EXAM Save 

function saveExamApplication() {
	
	console.log('saveExamApplication  on EXAM clicked rajjj ');
	
	var prCodeExam = document.getElementById('prCodeExam').value;
	var prNoExam = document.getElementById('prNoExam').value;
	var diplomaCodeExam = document.getElementById('diplomaCodeExam').value;
	var durationExam = document.getElementById('durationExam').value;
	var noofPaperExam = document.getElementById('noofPaperExam').value;
	
	var semMonthExam = document.getElementById('semMonthExam').value;
	var semYearExam = document.getElementById('semYearExam').value;
	var enterDateExam = document.getElementById('enterDateExam').value;
	var stuNameExam = document.getElementById('stuNameExam').value;
	var examStateCode= document.getElementById('examStateCode').value;
	var examCenterCode= document.getElementById('examCenterCode').value;
	var examPapers= document.getElementById('examPapers').value;
	
	var examSemstr= document.getElementById('examSemstr').value;
	var examNewnoPapers= document.getElementById('examNewnoPapers').value;
	var examOldnoPapers= document.getElementById('examOldnoPapers').value;
	var examTotalPaper= document.getElementById('examTotalPaper').value;
	var examPassFlag= document.getElementById('examPassFlag').value;
	
	//no of paper ??
	
//	if (examStateCode == "" || prno == "") {
//			alert("Please enter the values in P.R.Code and P.R.No")
//	  }else{
	
	
	//if(isNaN( isNaN(examNewnoPapers) || isNaN(examOldnoPapers) || isNaN(examTotalPaper) || isNaN(examPassFlag) ){
	//		alert("Please enter only numbers for Exam No number of paper, Old number of paper,  Total paper,  and Exam Pass flag ");
	//}else{
		postAjax('rs',{"app":"AiimasPost","module":"AddExamApplication","action":"examDetail","prCodeExam":prCodeExam,"prNoExam":prNoExam,"diplomaCodeExam":diplomaCodeExam,"durationExam":durationExam,"noofPaperExam":noofPaperExam,"semMonthExam":semMonthExam,"semYearExam":semYearExam,"enterDateExam":enterDateExam,"stuNameExam":stuNameExam,"examStateCode":examStateCode,"examCenterCode":examCenterCode,"examPapers":examPapers,"examSemstr":examSemstr,"examNewnoPapers":examNewnoPapers,"examOldnoPapers":examOldnoPapers,"examTotalPaper":examTotalPaper,"examPassFlag":examPassFlag}, onPostgetExamData);
	//}
}

function onPostgetExamData(data) {
	console.log('RESPONSE POST in   onPostgetExamData  app .JS:' + data);
	var parsedData1;
		
	if (data != null) {
						
					
			try {
			// Parse JSON
			parsedData1 = JSON.parse(data);
			
					
			
			//TODO SAKTHI  LOAD the exam application screen with this values


		} catch (e) {
				console.log("data error, please check administrator");
			}
		
		
		

		}else{
		//alert('else');
		//document.getElementById('resultTable1').style.display = "hide";
		}

}



//Exam Update todo


// MARKS deails

function getMarkData() {
	
	console.log('getMarkData  on MArk clicked rajjj ');
	
	var prcode = document.getElementById('prCodeMark').value;
	var prno = document.getElementById('prNoMark').value;
	
	if (prcode == "" || prno == "") {
			alert("Please enter the values in P.R.Code and P.R.No")
	  }else{
	
		postAjax('rs',{"app":"AiimasPost","module":"MarkApplication","action":"markDetail","prNo":prno,"prCode":prcode}, onPostgetMarkData);
	}
}

function onPostgetMarkData(data) {
	console.log('RESPONSE POST in   onPostgetMarkData  app .JS:' + data);
	var parsedData1;
		
	if (data != null) {
						
					
			try {
			// Parse JSON
			parsedData1 = JSON.parse(data);
			
					
			
			//TODO SAKTHI  LOAD the exam application screen with this values


		} catch (e) {
				console.log("data error, please check administrator");
			}
		
		
		

		}else{
		//alert('else');
		//document.getElementById('resultTable1').style.display = "hide";
		}

}

//MARKS SAVE

function saveMarktodo() {
	
	console.log('save MARK clicked rajjj ');
	
	var prCodeExam = document.getElementById('prCodeExam').value;
	var prNoExam = document.getElementById('prNoExam').value;
	var diplomaCodeExam = document.getElementById('diplomaCodeExam').value;
	var durationExam = document.getElementById('durationExam').value;
	var noofPaperExam = document.getElementById('noofPaperExam').value;
	
	var semMonthExam = document.getElementById('semMonthExam').value;
	var semYearExam = document.getElementById('semYearExam').value;
	var enterDateExam = document.getElementById('enterDateExam').value;
	var stuNameExam = document.getElementById('stuNameExam').value;
	var examStateCode= document.getElementById('examStateCode').value;
	var examCenterCode= document.getElementById('examCenterCode').value;
	var examPapers= document.getElementById('examPapers').value;
	
	var examSemstr= document.getElementById('examSemstr').value;
	var examNewnoPapers= document.getElementById('examNewnoPapers').value;
	var examOldnoPapers= document.getElementById('examOldnoPapers').value;
	var examTotalPaper= document.getElementById('examTotalPaper').value;
	var examPassFlag= document.getElementById('examPassFlag').value;
	

	
//	if (examStateCode == "" || prno == "") {
//			alert("Please enter the values in P.R.Code and P.R.No")
//	  }else{
	
	
	//if(isNaN( isNaN(examNewnoPapers) || isNaN(examOldnoPapers) || isNaN(examTotalPaper) || isNaN(examPassFlag) ){
	//		alert("Please enter only numbers for Exam No number of paper, Old number of paper,  Total paper,  and Exam Pass flag ");
	//}else{
		postAjax('rs',{"app":"AiimasPost","module":"AddExamApplication","action":"examDetail","prCodeExam":prCodeExam,"prNoExam":prNoExam,"diplomaCodeExam":diplomaCodeExam,"durationExam":durationExam,"noofPaperExam":noofPaperExam,"semMonthExam":semMonthExam,"semYearExam":semYearExam,"enterDateExam":enterDateExam,"stuNameExam":stuNameExam,"examStateCode":examStateCode,"examCenterCode":examCenterCode,"examPapers":examPapers,"examSemstr":examSemstr,"examNewnoPapers":examNewnoPapers,"examOldnoPapers":examOldnoPapers,"examTotalPaper":examTotalPaper,"examPassFlag":examPassFlag}, onPostgetExamData);
	//}
}

function onPostgetExamData(data) {
	console.log('RESPONSE POST in   onPostgetExamData  app .JS:' + data);
	var parsedData1;
		
	if (data != null) {
						
					
			try {
			// Parse JSON
			parsedData1 = JSON.parse(data);
			
					
			
			//TODO SAKTHI  LOAD the exam application screen with this values


		} catch (e) {
				console.log("data error, please check administrator");
			}
		
		
		

		}else{
		//alert('else');
		//document.getElementById('resultTable1').style.display = "hide";
		}

}


// Modify Adm -  LOAD data 
function getStudentDetail() {
	
	console.log('getModifyAdmData  on Modify Admin clicked rajjj ');
	
	var prcode = document.getElementById('prCode111').value;
	var prno = document.getElementById('prNo11').value;
	
	if (prcode == "" || prno == "") {
			alert("Please enter the values in P.R.Code and P.R.No")
	  }else{
	
		postAjax('rs',{"app":"AiimasPost","module":"UpdateAdmission","action":"admDetails","prNo":prno,"prCode":prcode}, onPostgetModifyAdmData);
	}
}



function onPostgetModifyAdmData(data) {
	console.log('RESPONSE POST in   onPostgetModifyAdmData  app .JS:' + data);
	var parsedData1;
		
	if (data != null) {
						
					
			try {
			// Parse JSON
			parsedData1 = JSON.parse(data);
			
		console.log(' NMAE'+parsedData1.Admin["ad_name"]);
		
			if(parsedData1.Admin["ad_name"]!=null){
				
				console.log(' NMAE'+parsedData1.Admin["ad_name"]);
	
				document.getElementById("stuName1").value =  parsedData1.Admin["ad_name"];
			}
			
			//TODO SAKTHI
			
			
			
//			console.log(' onPostSearchDiplomas  RESPONSE POST in app .JS:' + data);
//
//		if (data != null) {
//			
//			parsedData = JSON.parse(data);
//				
//			if(parsedData["dcdipname"]!=null){
//				document.getElementById("dcDiplomaName").value =  parsedData["dcdipname"];
//			}
//			
//			if(parsedData["dipname"]!=null){
//				document.getElementById("diplomaName").value =  parsedData["dipname"];
//			}
//			
//			if(parsedData["nofpapr"]!=null){
//				document.getElementById("noPaper").value =  parsedData["nofpapr"];
//			}
//	}
		
				
//				if(parsedData.Admin["ad_durtn"]!=null){
//					document.getElementById("ad_durtn").innerHTML = parsedData.Admin["ad_durtn"];
//				}
//		
//				if(parsedData.Address["sa_dipcode"]!=null){
//					document.getElementById("ad_dipcode").innerHTML = parsedData.Address["sa_dipcode"];
//				}
//				if(parsedData.Admin["ad_sesmon"]!=null){
//					document.getElementById("ad_sesmon").innerHTML = parsedData.Admin["ad_sesmon"];
//				}
//		
//				if(parsedData.Admin["ad_sesyr"]!=null){
//					document.getElementById("ad_sesyr").innerHTML = parsedData.Admin["ad_sesyr"];
//				}
//				if(parsedData.Admin["ad_nofpapr"]!=null){
//					document.getElementById("ad_nofpapr").innerHTML = parsedData.Admin["ad_nofpapr"];
//				}
//				if(parsedData.Admin["ad_feeamt"]!=null){
//					document.getElementById("ad_feeamt").innerHTML = parsedData.Admin["ad_feeamt"];
//				}
//				if(parsedData.Fee["fe_amount"]!=null){
//					document.getElementById("fe_amount").innerHTML = parsedData.Fee["fe_amount"];
//				}
//							
//				if(parsedData.Fee["fe_date"]!=null){
//					document.getElementById("fe_date").innerHTML = parsedData.Address["fe_date"];
//				}		
//				if(parsedData.Address["sa_add1"]!=null){
//					document.getElementById("sa_add1").innerHTML = parsedData.Address["sa_add1"];
//				}
//				if(parsedData.Address["sa_add2"]!=null){
//					document.getElementById("sa_add2").innerHTML = parsedData.Address["sa_add2"];
//				}	
//				if(parsedData.Address["sa_add3"]!=null){
//					document.getElementById("sa_add3").innerHTML = parsedData.Address["sa_add3"];
//				}
//				if(parsedData.Address["sa_add4"]!=null){
//					document.getElementById("sa_add4").innerHTML = parsedData.Address["sa_add4"];
//				}
//				if(parsedData.Address["sa_add5"]!=null){
//					document.getElementById("sa_add5").innerHTML = parsedData.Address["sa_add5"];
//				}	
//				if(parsedData.Address["sa_state"]!=null){
//					document.getElementById("sa_state").innerHTML = parsedData.Address["sa_state"];
//				}
//				if(parsedData.Address["sa_pincode"]!=null){
//					document.getElementById("sa_pincode").innerHTML = parsedData.Address["sa_pincode"];
//				}
//				if(parsedData.Address["sa_phone"]!=null){
//					document.getElementById("sa_phone").innerHTML = parsedData.Address["sa_phone"];
//				}
//				if(parsedData.Address["sa_mobile"]!=null){
//					document.getElementById("sa_mobile").innerHTML = parsedData.Address["sa_mobile"];
//				}
//				if(parsedData.Address["sa_email"]!=null){
//					document.getElementById("sa_email").innerHTML = parsedData.Address["sa_email"];
//				}
//			
		
			
			
			} catch (e) {
				console.log("data error, please check administrator");
			}
		
		
		

		}else{
		//alert('else');
		//document.getElementById('resultTable1').style.display = "hide";
		}




}
//

// ADD ADMISSION

function addAdmission() {
	
	console.log('addAdmission clicked rajjj ');
	
	var stuName = document.getElementById('stuName').value;
	var address1 = document.getElementById('address1').value;
		var diplomaCode = document.getElementById('diplomaCode').value;
		var duration = document.getElementById('duration').value;
		var semMonth = document.getElementById('semMonth').value;
		var semYear = document.getElementById('semYear').value;
		var enterDate = document.getElementById('enterDate').value;
		var prCode11 = document.getElementById('prCode11').value;
		var prNo1 = document.getElementById('prNo1').value;
		var paidamt = document.getElementById('paidamt').value;
		var address2 = document.getElementById('address2').value;
		var address3 = document.getElementById('address3').value;
		var address4 = document.getElementById('address4').value;
		var pincode = document.getElementById('pincode').value;
		var mobNum = document.getElementById('mobNum').value;
		var state = document.getElementById('state').value;
		var phonenum = document.getElementById('phonenum').value;
		var emailid = document.getElementById('emailid').value;
		var dueDate = document.getElementById('dueDate').value;
		var totfee = document.getElementById('totfee').value;
		var papers = document.getElementById('papers').value;
		var feepaiddate = document.getElementById('feepaiddate').value;
		var feepaidmode = document.getElementById('feepaidmode').value;
		var feeref = document.getElementById('feeref').value;
		
		//alert(duration);
		
		console.log('addAdmission clicked duration '+duration);
	
		if(isNaN(semYear) || isNaN(pincode) || isNaN(phonenum) || isNaN(mobNum) || isNaN(papers) || isNaN(totfee) || isNaN(paidamt)){
			alert("Please enter only numbers for PINCODE, PHONE NUMBER, SEM YEAR, MOBILE, NO OF PAPERS, TOTAL FEE AMT, FEE PAID AMOUNT ")
			
		}else if (prCode11 == "" || prNo1 == "" || diplomaCode == "")
		   {
			alert("Please enter the values in Diploma, P.R.Code and P.R.No")
		   }else{
	
	  postAjax('rs',{"app":"AiimasPost","module":"addAdmission","action":"saveAdm","stuName":stuName,"address1":address1, "diplomaCode":diplomaCode, "duration":duration, "semMonth":semMonth, "semYear":semYear, "enterDate":enterDate, "prCode11":prCode11, "prNo1":prNo1, "paidamt":paidamt, "address2":address2, "address3":address3, "address4":address4, "pincode":pincode, "phonenum":phonenum, "state":state, "mobNum":mobNum, "emailid":emailid, "dueDate":dueDate, "totfee":totfee, "papers":papers,"feepaiddate":feepaiddate,"feepaidmode":feepaidmode,"feeref":feeref}, onPostAddAdmission);

		   }

}


function onPostAddAdmission(data) {
	console.log(' onPostAddAdmission  RESPONSE POST in app .JS:' + data);

		if (data != null) {
			document.getElementById('newadmission').style.display='block';

		}
}


// UPDATE Admission
function updateAdmission(admType) {
	
	console.log('updateAdmission clicked rajjj ');
	
	var stuName = document.getElementById('stuName1').value;
	var address1 = document.getElementById('address11').value;
		var diplomaCode = document.getElementById('diplomaCode3').value;
		var duration = document.getElementById('duration1').value;
		var semMonth = document.getElementById('semMonth1').value;
		var semYear = document.getElementById('semYear1').value;
		var enterDate = document.getElementById('enterDate1').value;
		var prCode11 = document.getElementById('prCode111').value;
		var prNo1 = document.getElementById('prNo11').value;
		var paidamt = document.getElementById('paidamt1').value;
		var address2 = document.getElementById('address21').value;
		var address3 = document.getElementById('address31').value;
		var address4 = document.getElementById('address41').value;
		var pincode = document.getElementById('pincode1').value;
		var mobNum = document.getElementById('mobNum1').value;
		var state = document.getElementById('state1').value;
		var phonenum = document.getElementById('phonenum1').value;
		var emailid = document.getElementById('emailid1').value;
		var dueDate = document.getElementById('dueDate1').value;
		var totfee = document.getElementById('totfee1').value;
		var papers = document.getElementById('papers1').value;
		var feepaiddate = document.getElementById('feepaiddate1').value;
		var feepaidmode = document.getElementById('feepaidmode1').value;
		var feeref = document.getElementById('feeref1').value;
		
	
		if(isNaN(semYear) || isNaN(pincode) || isNaN(phonenum) || isNaN(mobNum) || isNaN(papers) || isNaN(totfee) || isNaN(paidamt)){
			alert("Please enter only numbers for PINCODE, PHONE NUMBER, SEM YEAR, MOBILE, NO OF PAPERS, TOTAL FEE AMT, FEE PAID AMOUNT ")
			
		}else if (prCode11 == "" || prNo1 == "" || diplomaCode == "")
		   {
			alert("Please enter the values in Diploma, P.R.Code and P.R.No")
		   }else{
	
	  		postAjax('rs',{"app":"AiimasPost","module":"modifyAdmission","action":admType,"stuName":stuName,"address1":address1, "diplomaCode":diplomaCode, "duration":duration, "semMonth":semMonth, "semYear":semYear, "enterDate":enterDate, "prCode11":prCode11, "prNo1":prNo1, "paidamt":paidamt, "address2":address2, "address3":address3, "address4":address4, "pincode":pincode, "phonenum":phonenum, "state":state, "mobNum":mobNum, "emailid":emailid, "dueDate":dueDate, "totfee":totfee, "papers":papers,"feepaiddate":feepaiddate,"feepaidmode":feepaidmode,"feeref":feeref}, onPostUpdateAdmission);

		   }

}


function onPostUpdateAdmission(data) {
	console.log(' onPostAddAdmission  RESPONSE POST in app .JS:' + data);

		if (data != null) {
			document.getElementById('newadmission').style.display='block';

		}
}






//MAintenance  - Institute search

function searchInstitue() {
	
	console.log('searchInstitue clicked rajjj ');
	
		//var insituteCode = document.getElementById('insituteCode').value;
		
		var e = document.getElementById("insituteCode");
		var insituteCode = e.options[e.selectedIndex].value;
		
		console.log('searchInstitue clicked rajjj '+insituteCode);
		
	
	postAjax('rs',{"app":"AiimasPost","module":"Maintenance","action":"searchInsitute","insituteCode":insituteCode,}, onPostSearchInstitue);

}
function onPostSearchInstitue(data) {
	console.log(' onPostAddAdmission  RESPONSE POST in app .JS:' + data);

		if (data != null) {

			parsedData = JSON.parse(data);
			
			if(parsedData["coyname"]!=null){
				document.getElementById("instituteName").value =  parsedData["coyname"];
			}
			
			if(parsedData["coyadd1"]!=null){
				document.getElementById("instituteAddress").value =  parsedData["coyadd1"];
			}
			
			if(parsedData["coyadd2"] != null){
				document.getElementById("institutePhNumbers").value = parsedData["coyadd2"];
			}
	}
}


//Print Questions
function getQuestion1() {
	
	console.log('getQuestion1 clicked rajjj ');
	
		var qdiplomaCode2 = document.getElementById('qdiplomaCode').value;
		
	
	//postAjax('rs',{"app":"AiimasPost","module":"printView","action":"searchQ","diplomaCode1":qdiplomaCode2}, onPostSearchQuestion1);
	
	postAjax('rs',{"app":"AiimasPost","module":"printViewQuestion","action":"searchQ","diplomaCode1":qdiplomaCode2,}, onPostSearchQuestion1);
	


}
function onPostSearchQuestion1(data) {
	console.log(' onPostSearchQuestion1  RESPONSE POST in app .JS:' + data);

		if (data != null) {
			
			parsedData = JSON.parse(data);
				if(parsedData!=null){
					
					//document.getElementById('showData').parentElement.removeChild(document.getElementById('quesTableDiv'));
					var element = document.getElementById("quesTable"); 
					if (element.style.display === "none") {
					  element.style.display = "block";
					}
					
					if(element.rows.length > 0){
						while(element.hasChildNodes())
						{
							element.removeChild(element.firstChild);
						}
					}
					
		        var col = [];
		        for (var i = 0; i < parsedData.length; i++) {
		            for (var key in parsedData[i]) {
		                if (col.indexOf(key) === -1) {
		                    col.push(key);
		                }
		            }
		        }

		        // CREATING DYNAMIC TABLE.
		       // var table = document.createElement("table");  quesTable
		        var table = document.getElementById("quesTable");  
		        var tr = table.insertRow(-1);                   // TABLE ROW.

		        for (var i = 0; i < col.length; i++) {
		            var th = document.createElement("th");      // TABLE HEADER.
		            th.setAttribute("style","white-space: nowrap;");
		            th.innerHTML = col[i];
		            if(col[i] == 'q_paperno')
		            	th.innerHTML = 'Paper No';
		            if(col[i] == 'q_filename')
		            	th.innerHTML = 'File Name';
		            if(col[i] == 'q_dipcode')
		            	th.innerHTML = 'Diploma Code';
		            if(col[i] == 'q_papernam')
		            	th.innerHTML = 'Paper Name';
		            tr.appendChild(th);
		        }

		        // ADD JSON DATA TO THE TABLE AS ROWS.
		        for (var i = 0; i < parsedData.length; i++) {

		            tr = table.insertRow(-1);

		            for (var j = 0; j < col.length; j++) {
		                var tabCell = tr.insertCell(-1);
		                tabCell.setAttribute("style","white-space: nowrap;");
		                var fileName = parsedData[i][col[j]];
		                var linkName="";
		                var innerHtmlText = "";
		                if ((fileName.toString()).indexOf(".pdf") !== -1) { //add .pdf here to send only pdf as link reference
		                	linkName=fileName;
		                	innerHtmlText = "<a href='secure/qpapers/EM.pdf' target='_blank'>"+fileName+"</a>";
		                }else{
		                	innerHtmlText = fileName;
		                }
		                
		                tabCell.innerHTML = innerHtmlText;
		            }
		        }

		        var divContainer = document.getElementById("quesTableDiv");
		        divContainer.appendChild(table);
		        
		       
				}else{
					/*var element = document.getElementById("quesTable"); 
					if (element.style.display === "none") {
					  element.style.display = "block";
					}else{*/
					var element = document.getElementById("quesTable"); 
						element.style.display = "none";
					//}
				}
		        
		    }

}


function hrefWindowOpen(dataItem){
	
	var websitelink = window.location.href+"qpaper/" + dataItem;   //appending the path :: pdf :: to the localhost address
    window.open(websitelink,'_blank', 'location=yes,height=570,width=520,scrollbars=yes,status=yes');
}

//PRINT  - Admmission Initimation

function printAdmInit(reportType) {
	
	console.log('printAdmInit clicked rajjj '+reportType);
	
		var adprCode = document.getElementById('adprCode').value;
		var adpprNo = document.getElementById('adpprNo').value;
		
	
	postAjax('rs',{"app":"AiimasPost","module":"printReport","action":reportType,"adprCode":adprCode,"adpprNo":adpprNo,}, onPostSearchAdmIniti);

}
function onPostSearchAdmIniti(data) {
	console.log('onPostSearchAdmIniti  RESPONSE POST in app .JS:' + data);

	parsedData = JSON.parse(data);
	
	if(parsedData["Filename"]!=null){   
		
		var e = document.getElementById('viewhref');
	    if(e.style.display == 'block')
	       e.style.display = 'none';
	    else
	       e.style.display = 'block';
		
			var filePath = parsedData["File name "];
			document.getElementById('intimationpdf').value = filePath;
	}
}

function openIntimationPDF() {
    var myInput = document.getElementById("intimationpdf").value;
    var  firstindex=  myInput.lastIndexOf("\\")+1; //this to get the file name, once u send only the file name i will remove this code
    myInput = myInput.substring( firstindex, myInput.length); //extracting the file name from c:\\temp\\Firstpdf.pdf
    myInput = myInput.trim();
    var websitelink = window.location.href+"pdf/" + myInput;   //appending the path :: pdf :: to the localhost address
    window.open(websitelink,'_blank', 'location=yes,height=570,width=520,scrollbars=yes,status=yes');
}


//MAintenance  - Diploma

function searchDiplomas() {
	
	
		var diplomaCode1 = document.getElementById('diplomaCode1').value.toUpperCase();
		
		postAjax('rs',{"app":"AiimasPost","module":"Maintenance","action":"searchDiploma","diplomaCode1":diplomaCode1,}, onPostSearchDiplomas);

}
function onPostSearchDiplomas(data) {
	console.log(' onPostSearchDiplomas  RESPONSE POST in app .JS:' + data);

		if (data != null) {
			
			parsedData = JSON.parse(data);
				
			if(parsedData["dcdipname"]!=null){
				document.getElementById("dcDiplomaName").value =  parsedData["dcdipname"];
			}
			
			if(parsedData["dipname"]!=null){
				document.getElementById("diplomaName").value =  parsedData["dipname"];
			}
			
			if(parsedData["nofpapr"]!=null){
				document.getElementById("noPaper").value =  parsedData["nofpapr"];
			}
	}
}


function postAjax(url, data, callback) {
	    var params = typeof data == 'string' ? data : Object.keys(data).map(
	            function(k){ return encodeURIComponent(k) + '=' + encodeURIComponent(data[k]) }
	        ).join('&');

	    var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");
	    xhr.open('POST', url);
	    xhr.onreadystatechange = function() {
	        if (xhr.readyState>3 && xhr.status==200) { callback(xhr.responseText); }
	    };
	    xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
	    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	    xhr.send(params);
	    return xhr;
}

function clearBtn(){
	document.getElementById('prCode').value = "";
	document.getElementById('prNo').value = "";
	document.getElementById("resultTable").style.display="none";
}
function clearDiplomaUpdation(){
	document.getElementById('diplomaName').value = "";
	document.getElementById('dcDiplomaName').value = "";
	document.getElementById("noPaper").value = "";
	document.getElementById('diplomaCode1').value = "";
	
	
}
function clearInstituteUpdation(){
	document.getElementById('instituteName').value = "";
	document.getElementById('instituteAddress').value = "";
	document.getElementById('institutePhNumbers').value = "";
	document.getElementById('insituteCode').options[0].selected = true;
}
function clearQuestionPaper(){
	document.getElementById('qdiplomaCode').value = "";  
	var x = document.getElementById("quesTable");
	    x.style.display = "none";
}

function sort_select() { 
    $("#diplomaCode").append($("#diplomaCode option") 
                      .remove().sort(function(a, b) { 
        var at = $(a).text(), 
            bt = $(b).text(); 
        
        return (at > bt) ? 1 : ((at < bt) ? -1 : 0); 
    })); 
    //el_down.innerHTML = "Select options are sorted"; 
} 

function itemSelect(s) { 
    
        s.options[0].selected = true;
}

function getSelectedDipcode() {
    var d_1 = document.getElementById("diplomaCode").value;
    alert(d_1);
}


function clearAllAtrbutes() {
	document.getElementById("duration").selectedIndex = "0";
	
		document.getElementById('semMonth').value="";
		document.getElementById('semYear').value="";
		document.getElementById('enterDate').value="";
		document.getElementById('prCode11').value="";
		document.getElementById('prNo1').value="";
		document.getElementById('stuName').value="";
		document.getElementById('prNo1').value="";
		
		document.getElementById('pincode').value="";
		document.getElementById('state').value="";
		
		document.getElementById('address1').value="";
		document.getElementById('address2').value="";
		document.getElementById('address3').value="";
		document.getElementById('address4').value="";
		document.getElementById('phonenum').value="";
		document.getElementById('mobNum').value="";
		document.getElementById('emailid').value="";
		document.getElementById('papers').value="";
		document.getElementById('dueDate').value="";
		document.getElementById('totfee').value="";
		document.getElementById('paidamt').value="";
		document.getElementById('feepaiddate').value="";
		document.getElementById('feepaidmode').value="";
		document.getElementById('feeref').value="";
}


$(function(){
    $('#diplomaCode').change(function(){
        var codeval = $("#diplomaCodeList option[value='" + $('#diplomaCode').val() + "']").attr('data-id');
        //alert($('#diplomaCode').val());
        var description = $('#diplomaCode').val();  //course description. ex :: SALES & MARKETING
        
        var parts = codeval.split('$', 2);
        var code = parts[0]; //diploma code.  ex :: SM
        var paper  = parts[1]; // no of papers  ex :: 6
        
        document.getElementById('papers').value=paper;
        document.getElementById('diplomaCode').value=description;
    });
});