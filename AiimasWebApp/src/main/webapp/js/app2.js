
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
		var emailid = document.getElementById('emailid').value;
		var dueDate = document.getElementById('dueDate').value;
		var totfee = document.getElementById('totfee').value;
		var papers = document.getElementById('papers').value;
		
		//alert(duration);
		
		if (prCode11 == "" || prNo1 == "")
		   {
			alert("Please enter values for required fields, Required fields are marked in Red")
		   }else{
	
	postAjax('rs',{"app":"AiimasPost","module":"addAdmission","action":"saveAdm","stuName":stuName,"address1":address1, "diplomaCode":diplomaCode, "duration":duration, "semMonth":semMonth, "semYear":semYear, "enterDate":enterDate, "prCode11":prCode11, "prNo1":prNo1, "paidamt":paidamt, "address2":address2, "address3":address3, "address4":address4, "pincode":pincode, "mobNum":mobNum, "emailid":emailid, "dueDate":dueDate, "totfee":totfee, "papers":papers}, onPostAddAdmission);
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
        //alert(codeval);
        document.getElementById('diplomaCode').value=codeval;
    });
});