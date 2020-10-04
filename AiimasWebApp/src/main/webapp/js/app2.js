
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
	
	postAjax('rs',{"app":"AiimasPost","module":"addAdmission","action":"saveAdm","stuName":stuName,"address1":address1}, onPostAddAdmission);

}



function onPostAddAdmission(data) {
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


