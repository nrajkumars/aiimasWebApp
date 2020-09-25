
function searchByPrCodePrNo() {
	
	console.log('searchByPrCodePrNo clicked rajjj ');
	
	var prcode = document.getElementById('prCode').value;
	var prno = document.getElementById('prNo').value;
	
	postAjax('rs',{"app":"AiimasPost","module":"verification","action":"searchByPrCodePrNo1","prNo":prno,"prCode":prcode}, onPostsearchByPrCodePrNo);

}



function onPostsearchByPrCodePrNo(data) {
	console.log('RESPONSE POST in app .JS:' + data);
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


