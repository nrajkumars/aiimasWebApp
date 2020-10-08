function searchByPrCodePrNo() {
	
	console.log('searchByPrCodePrNo clicked rajjj ');
	
	var prcode = document.getElementById('prCode').value;
	var prno = document.getElementById('prNo').value;
	
	postAjax('rs',{"app":"AiimasPost","module":"verification","action":"searchByPrCodePrNo1","prNo":prno,"prCode":prcode}, onPostsearchByPrCodePrNo);

}



function onPostsearchByPrCodePrNo(data) {
	console.log('RESPONSE POST in app .JS:' + data);
	//document.setElementbyId('returnvalue', data);
	//var responseFromServer = request.responseText;
		if (data != null) {
			//document.getElementById("result").innerHTML = data;
			document.getElementById('resultTable').style.display = "block";
		
		try {
		// Parse a JSON
		parsedData = JSON.parse(data);
		} catch (e) {
		
		console.log(parsedData.ad_ref);
		}
		//{"ad_ref":"4799","ad_entdate":null,"ad_name":"CHARLES OWINO MUSUVI","ad_feedate":939493800000,"ad_durtn":"ONE YEAR","ad_prcode":"ABM2","ad_dipcode":"ADMN","ad_prno":"2","ad_sesmon":"MAY","ad_nofpapr":8,"ad_paidamt":0,"ad_feeamt":3600,"ad_enttime":null,"ad_sesyr":1999}
			document.getElementById("ad_ref").innerHTML = parsedData.ad_ref;
			document.getElementById("ad_name").innerHTML = parsedData.ad_name;
			document.getElementById("ad_feedate").innerHTML = parsedData.ad_feedate;
			document.getElementById("ad_durtn").innerHTML = parsedData.ad_durtn;
		
			//document.getElementById("ad_prcode").innerHTML = parsedData.ad_prcode;
			document.getElementById("ad_dipcode").innerHTML = parsedData.ad_dipcode;
			//document.getElementById("ad_prno").innerHTML = parsedData.ad_prno;
			document.getElementById("ad_sesmon").innerHTML = parsedData.ad_sesmon;
			document.getElementById("ad_nofpapr").innerHTML = parsedData.ad_nofpapr;
			document.getElementById("ad_paidamt").innerHTML = parsedData.ad_paidamt;
			document.getElementById("ad_feeamt").innerHTML = parsedData.ad_feeamt;
			document.getElementById("ad_sesyr").innerHTML = parsedData.ad_sesyr;
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
	
	postAjax('rs',{"app":"AiimasPost","module":"addAdmission","action":"saveAdm","stuName":stuName,"address1":address1, "diplomaCode":diplomaCode, "duration":duration, "semMonth":semMonth, "semYear":semYear, "enterDate":enterDate, "prCode11":prCode11, "prNo1":prNo1, "paidamt":paidamt, "address2":address2, "address3":address3, "address4":address4, "pincode":pincode, "phonenum":phonenum, "state":state, "mobNum":mobNum, "emailid":emailid, "dueDate":dueDate, "totfee":totfee, "papers":papers,"feepaiddate":feepaiddate,"feepaidmode":feepaidmode,"feeref":feeref}, onPostAddAdmission);

}



function onPostAddAdmission(data) {
	console.log(' onPostAddAdmission  RESPONSE POST in app .JS:' + data);

		if (data != null) {
			document.getElementById("resultAddAdm").innerHTML = data;
			// SAKTHI todo display the success or error in a dialog box

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
			document.getElementById("instResult").innerHTML = data;
			// SAKTHI todo display the success or error in a dialog box

	}
}


//MAintenance  - Diploma

function searchDiplomas() {
	
	console.log('searchDiplomas clicked rajjj ');
	
		var diplomaCode1 = document.getElementById('diplomaCode1').value;
		
	
	postAjax('rs',{"app":"AiimasPost","module":"Maintenance","action":"searchDiploma","diplomaCode1":diplomaCode1,}, onPostSearchDiplomas);

}
function onPostSearchDiplomas(data) {
	console.log(' onPostSearchDiplomas  RESPONSE POST in app .JS:' + data);

		if (data != null) {
			document.getElementById("diplomaResult").innerHTML = data;
			// SAKTHI todo display the success or error in a dialog box

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
    d = document.getElementById("diplomaCode").value;
    //alert(d);
}