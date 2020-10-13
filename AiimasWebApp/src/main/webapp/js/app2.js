function searchByPrCodePrNo() {
	
	console.log('searchByPrCodePrNo clicked rajjj ');
	
	var prcode = document.getElementById('prCode').value;
	var prno = document.getElementById('prNo').value;
	
	postAjax('rs',{"app":"AiimasPost","module":"verification","action":"searchByPrCodePrNo1","prNo":prno,"prCode":prcode}, onPostsearchByPrCodePrNo);

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
		
		if (prCode11 == "" || prNo1 == "")
		   {
			alert("Please enter the values in P.R.Code and P.R.No")
		   }else{
	
	  postAjax('rs',{"app":"AiimasPost","module":"addAdmission","action":"saveAdm","stuName":stuName,"address1":address1, "diplomaCode":diplomaCode, "duration":duration, "semMonth":semMonth, "semYear":semYear, "enterDate":enterDate, "prCode11":prCode11, "prNo1":prNo1, "paidamt":paidamt, "address2":address2, "address3":address3, "address4":address4, "pincode":pincode, "phonenum":phonenum, "state":state, "mobNum":mobNum, "emailid":emailid, "dueDate":dueDate, "totfee":totfee, "papers":papers,"feepaiddate":feepaiddate,"feepaidmode":feepaidmode,"feeref":feeref}, onPostAddAdmission);

		   }

}



function onPostAddAdmission(data) {
	console.log(' onPostAddAdmission  RESPONSE POST in app .JS:' + data);

		if (data != null) {
			//document.getElementById("resultAddAdm").innerHTML = data;
			// SAKTHI todo display the success or error in a dialog box
			
			
			//$("#Modal-Admission .modal-body").load(data);
            
            // open the other modal
           // $("#myModal2").modal("show");
           // document.getElementById("newadmission").showModal();
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


//MAintenance  - Diploma

function searchDiplomas() {
	
	console.log('searchDiplomas clicked rajjj ');
	
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
	document.getElementById('diplomaCode').value="";
	document.getElementById('duration').value="";
	document.getElementById('semMonth').value="";
	document.getElementById('semYear').value="";
	document.getElementById('enterDate').value="";
	document.getElementById('prCode11').value="";
	document.getElementById('prNo1').value="";
	document.getElementById('paidamt').value="";
	document.getElementById('address2').value="";
	document.getElementById('address3').value="";
	document.getElementById('address4').value="";
	document.getElementById('address5').value="";
	document.getElementById('pincode').value="";
	document.getElementById('mobNum').value="";
	document.getElementById('emailid').value="";
	document.getElementById('dueDate').value="";
	document.getElementById('totfee').value="";
	document.getElementById('papers').value="";
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