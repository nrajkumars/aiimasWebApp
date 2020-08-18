
function searchByPrCodePrNo() {
	console.log('searchByPrCodePrNo clicked');
	
	var prcode = document.getElementById('prCode').value;
	var prno = document.getElementById('prNo').value;
	getAjax('rs?app=AiimasGet&module=Search&action=searchByPrCodePrNo&prNo='+prno+'&prCode=' +prcode, onGetsearchByPrCodePrNo);
	postAjax('rs',{"app":"AiimasPost","module":"Search","action":"searchByPrCodePrNo","prNo":prno,"prCode":prcode}, onPostsearchByPrCodePrNo);

}

function onGetsearchByPrCodePrNo(data) {
	console.log('GET:' + data);
}
function onPostsearchByPrCodePrNo(data) {
	console.log('POST:' + data);
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


function getAjax(url, callback) {
    var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP');
    xhr.open('GET', url);
    xhr.onreadystatechange = function() {
        if (xhr.readyState>3 && xhr.status==200) callback(xhr.responseText);
    };
    xhr.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    xhr.send();
    return xhr;
}