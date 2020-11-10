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
			
		
				if(parsedData.Admin["ad_name"]!=null){
					document.getElementById("sa_name").innerHTML = parsedData.Admin["ad_name"];
				}
		
				
				if(parsedData.Admin["ad_durtn"]!=null){
					document.getElementById("ad_durtn").innerHTML = parsedData.Admin["ad_durtn"];
				}
		
				if(parsedData.Admin["ad_dipcode"]!=null){
					document.getElementById("ad_dipcode").innerHTML = parsedData.Admin["ad_dipcode"];
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
				console.log("data error,Reason"+e.toString());
			}
		
		

		}else{
		alert('else');
		document.getElementById('resultTable').style.display = "hide";
		}

}

// GET CURRENT PR No for Add amission screen



function getNextPRNo() {
	
	console.log('getCurrnetPRNo   clicked rajjj ');
	
	var prCode11 = document.getElementById('prCode11').value;
	//var prno = document.getElementById('prNo').value;
	
	if (prCode11 == "" ) {
			alert("Please enter the values in P.R.Code")
	  }else{
	
	postAjax('rs',{"app":"AiimasPost","module":"getCurrentPRno","action":"byPRNo","prCode11":prCode11}, onPostGetPRNo);
	}
}

function onPostGetPRNo(data) {
	console.log('RESPONSE POST  onPostGetPRNo in app .JS:' + data);
	var parsedData;
	
	if (data != null) {

		try{
			parsedData = JSON.parse(data);
			
			if(parsedData["max"]!=null){
					console.log('RESPONSE POST  onPostGetPRNo in app .JS:' + parsedData["max"]);
			
				document.getElementById("prNo1").value =  parsedData["max"] +1;
			}
			} catch (e) {
				console.log("data error, Reason"+e.toString());
			}
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
				console.log("data error, Reason"+e.toString());
			}
	}
}

// GET STUDNET and EXAM details for update exam
// get EXam details

function getExamUpdateData1() {
	
	console.log('getExamUpdateData...  on EXAM clicked rajjj ');
	
	var prcode = document.getElementById('prCodeExam1').value;
	var prno = document.getElementById('prNoExam1').value;
	
	if (prcode == "" || prno == "") {
			alert("Please enter the values in P.R.Code and P.R.No")
	  }else{
	
		postAjax('rs',{"app":"AiimasPost","module":"ExamUpdateApplication","action":"examUpdateDetail1","prNo":prno,"prCode":prcode}, onPostgetExamUpdateData1);
	}
}

function onPostgetExamUpdateData1(data) {
	//console.log('RESPONSE POST in   onPostgetExamData1  app .JS:' + data);
	var parsedData1;
		
	if (data != null) {
						
			try {
			// Parse JSON
			parsedData1 = JSON.parse(data);
			
			console.log(' parseddata===========>>'+ JSON.stringify(parsedData1)   );
		
			if(parsedData1['Admin'] !== undefined ){
				//$("#alertDetailFound").show();     
				document.getElementById('addExamGetExamDataLoad1').style.display='block';
				var sbutton = document.getElementById('resultSaveExamApp');
				if (sbutton.style.display === "none") {
					sbutton.style.display = "block";
				  } else {
					  sbutton.style.display = "none";
				  }   
				
				
				
				var ubutton = document.getElementById('resultUpdateExamApp1');
				if (ubutton.style.display === "none") {
					ubutton.style.display = "block";
				  } else {
					  ubutton.style.display = "none";
				  }
				/*document.getElementById('resultSaveExamApp').style.display='block';
				document.getElementById('resultUpdateExamApp').style.display='block';*/
				
				
			}else {		//if(parsedData1['Failure'] !== undefined)
				//$("#alertDetailNotFound").show();
				document.getElementById('addExamGetExamDataLoadFail1').style.display='block';
				clearAllAtrbutesV1();
			}
			
			if(parsedData1['Admin'] !== undefined){
				document.getElementById("stuNameExam1").value =  parsedData1.Admin["ad_name"];
				document.getElementById("diplomaCodeExam1").value =  parsedData1.Admin["ad_dipcode"];
				document.getElementById("durationExam1").value =  parsedData1.Admin["ad_durtn"];
				document.getElementById("noofPaperExam1").value =  parsedData1.Admin["ad_nofpapr"];
				
				document.getElementById("stuNameExam1").readOnly = true;
				document.getElementById("diplomaCodeExam1").readOnly = true;
				document.getElementById("durationExam1").readOnly = true;
				document.getElementById("noofPaperExam1").readOnly = true;
			}
			
			if(parsedData1['Exam'] !== undefined){
				document.getElementById("semMonthExam1").value =  parsedData1.Exam["ea_sesmon"];
				document.getElementById("semYearExam1").value =  parsedData1.Exam["ea_sesyr"];
				document.getElementById("examStateCode1").value =  parsedData1.Exam["ea_stcode"];
				document.getElementById("examCenterCode1").value =  parsedData1.Exam["ea_cecode"];
			}
			
			

			
			if(parsedData1['Ack'] !== undefined){
				var LetterDate1 = returnFormatDate(parsedData1.Ack["ak_venudt"]);
				document.getElementById("ackIniLetterDate1").value =  LetterDate1;
				
				var HallTckDate1 = returnFormatDate(parsedData1.Ack["ak_halldt"]);
				document.getElementById("ackHallTckDate1").value =  HallTckDate1;
				
				var Examdate11 = returnFormatDate(parsedData1.Ack["ak_examdt1"]);
				document.getElementById("ackExamdate11").value = Examdate11 ;
				
				var Examdate21 = returnFormatDate(parsedData1.Ack["ak_examdt2"]);
				document.getElementById("ackExamdate21").value =Examdate21  ;
				
				
				//document.getElementById("noofPaperExam1").readOnly = true;
			}
			
			var paperNumbers = document.getElementById("noofPaperExam1").value ;
			var s2 = document.getElementById('slct2');
			var elementCb = document.querySelectorAll("input[id='cboxpaper']");
			var mylabelforCbox = document.querySelectorAll("lbelnew");
			
			
			 if(typeof(elementCb) != 'undefined' && elementCb != null){
				 
				 var elem=$("#slct2 input");
				 $("#slct2").empty().html(elem);
				 
			        
			        for(var i = 0,j=1; i < elementCb.length; i++){
			        	elementCb[i].parentNode.removeChild(elementCb[i]);
			        }
			       
			        
			    } else{
			        console.log('Element does not exist!');
			    }
			 
			
			for (var i = 1; i <= paperNumbers; i++) {
				//console.log('paper... '+i);
				 	var nameinp = ' Paper '+i;
				 	var valinp = i;
				 	//console.log('nameinp... '+nameinp);
				 	//console.log('valinp... '+valinp);
			        var checkbox = document.createElement("input");
			        checkbox.type = "checkbox";
			        checkbox.name = 'cboxpaper';
			        checkbox.id = 'cboxpaper';
			        checkbox.value = valinp;
			        s2.appendChild(checkbox);

			        var label = document.createElement('label')
			        label.htmlFor = nameinp;
			        label.id = 'labelnew';
			        label.appendChild(document.createTextNode(nameinp));

			        s2.appendChild(label);
			        s2.appendChild(document.createElement("br"));   
			}
			
			var Stselect = document.getElementById("examStateCodeList1"); 
			  $('#examStateCodeList option').remove();  
			  $('#examCenterCodeList option').remove(); 
				  var state = {};  var centre= {}; var state1course = [];
				  for (var key in parsedData1) {
					    if (parsedData1.hasOwnProperty(key)) {
					        //console.log(key + " -> " + parsedData1[key]);
					        
					        if(key.includes('State')){
					        	var obj = parsedData1[key];
					        	var textval = '';
					        	var textopt = '';
					        	for (var key in obj) {
					        		  if (obj.hasOwnProperty(key)) {
					        		    var val = obj[key];
					        		    //console.log(val);
					        		    //console.log('Label '+key);
					        		    var el = document.createElement("option");
					        		    
					        		    if(key.includes('st_stname')){
					        		    	textval = val;
					        		    	
					        		    }
					        		    if(key.includes('st_stcode')){
					        		    	textopt = val;
					        		    }
					        		    
					        		  }
					        		}
							    el.text = textopt;
							    el.value = textval+' /'+el.text;
					        	Stselect.appendChild(el);
					        }
					        
					        if(key.includes('Centre')){
					        	
					        	var obj = parsedData1[key];
					        	
					        	var statecode1 = '';
					        	var centrecode1 = '';
					        	var centrename1 = '';
					        	for (var key in obj) {
					        		  if (obj.hasOwnProperty(key)) {
					        		    var val = obj[key];
					        		    
					        		    if(key.includes('ce_stcode')){
					        		    		statecode1 = val;
					        		    }
					        		    if(key.includes('ce_cecode')){
					        		    	centrecode1 = val;
					        		    }
					        		    if(key.includes('ce_cename')){
					        		    	centrename1 = val;
					        		    }
					        		  }
					        		}
					        	
					        	 var objstcentre = {
					        		        'statecode1': statecode1,
					        		        'centrecode1': centrecode1,
					        		        'centrename1': centrename1,
					        		    }
					        	 state1course.push(objstcentre);
					        	 localStorage.setItem('stateCentreMapObject', JSON.stringify(state1course));
					        	 var retrievedObject = localStorage.getItem('stateCentreMapObject');
					 			//console.log('retrievedObject: ', JSON.parse(retrievedObject));
					        }
					    }
				  }
			        
			//TODO SAKTHI  LOAD the exam application screen with this values

		} catch (e) {
				console.log("data error, Reason ========= >> "+e.toString());
			}
		}else{
		}

}			



// get student  details for add exam getExamData1

function getExamData1() {
	
	console.log('getExamData...  on EXAM clicked rajjj ');
	
	var prcode = document.getElementById('prCodeExam').value;
	var prno = document.getElementById('prNoExam').value;
	
	if (prcode == "" || prno == "") {
			alert("Please enter the values in P.R.Code and P.R.No")
	  }else{
	
		postAjax('rs',{"app":"AiimasPost","module":"ExamApplication","action":"examDetail","prNo":prno,"prCode":prcode}, onPostgetExamData1);
	}
}

function onPostgetExamData1(data) {
	//console.log('RESPONSE POST in   onPostgetExamData1  app .JS:' + data);
	var parsedData1;
		
	if (data != null) {
						
			try {
			// Parse JSON
			parsedData1 = JSON.parse(data);
			
			//console.log(' parseddata'+ JSON.stringify(parsedData1)   );
		
			if(parsedData1['Admin'] !== undefined ){
				//$("#alertDetailFound").show();     
				document.getElementById('addExamGetExamDataLoad').style.display='block';
				var sbutton = document.getElementById('resultSaveExamApp');
				//alert(sbutton.style.display);
				if (sbutton.style.display == "none") {
					sbutton.style.display = "block";
				  }  
				
				
				
//				var ubutton = document.getElementById('resultUpdateExamApp');
//				if (ubutton.style.display === "none") {
//					ubutton.style.display = "block";
//				  } else {
//					  ubutton.style.display = "none";
//				  }
				/*document.getElementById('resultSaveExamApp').style.display='block';
				document.getElementById('resultUpdateExamApp').style.display='block';*/
				
				
			}else {		//if(parsedData1['Failure'] !== undefined)
				//$("#alertDetailNotFound").show();
				document.getElementById('addExamGetExamDataLoadFail').style.display='block';
				clearAllAtrbutesV1();
			}
			
			if(parsedData1['Admin'] !== undefined){
				document.getElementById("stuNameExam").value =  parsedData1.Admin["ad_name"];
				document.getElementById("diplomaCodeExam").value =  parsedData1.Admin["ad_dipcode"];
				document.getElementById("durationExam").value =  parsedData1.Admin["ad_durtn"];
				document.getElementById("noofPaperExam").value =  parsedData1.Admin["ad_nofpapr"];
				
				document.getElementById("stuNameExam").readOnly = true;
				document.getElementById("diplomaCodeExam").readOnly = true;
				document.getElementById("durationExam").readOnly = true;
				document.getElementById("noofPaperExam").readOnly = true;
			}
			
			var paperNumbers = document.getElementById("noofPaperExam").value ;
			var s2 = document.getElementById('slct2');
			var elementCb = document.querySelectorAll("input[id='cboxpaper']");
			var mylabelforCbox = document.querySelectorAll("lbelnew");
			
			
			 if(typeof(elementCb) != 'undefined' && elementCb != null){
				 
				 var elem=$("#slct2 input");
				 $("#slct2").empty().html(elem);
				 
			        
			        for(var i = 0,j=1; i < elementCb.length; i++){
			        	elementCb[i].parentNode.removeChild(elementCb[i]);
			        }
			       
			        
			    } else{
			        console.log('Element does not exist!');
			    }
			 
			
			for (var i = 1; i <= paperNumbers; i++) {
				//console.log('paper... '+i);
				 	var nameinp = ' Paper '+i;
				 	var valinp = i;
				 	//console.log('nameinp... '+nameinp);
				 	//console.log('valinp... '+valinp);
			        var checkbox = document.createElement("input");
			        checkbox.type = "checkbox";
			        checkbox.name = 'cboxpaper';
			        checkbox.id = 'cboxpaper';
			        checkbox.value = valinp;
			        s2.appendChild(checkbox);

			        var label = document.createElement('label')
			        label.htmlFor = nameinp;
			        label.id = 'labelnew';
			        label.appendChild(document.createTextNode(nameinp));

			        s2.appendChild(label);
			        s2.appendChild(document.createElement("br"));   
			}
			
			var Stselect = document.getElementById("examStateCodeList"); 
			  $('#examStateCodeList option').remove();  
			  $('#examCenterCodeList option').remove(); 
				  var state = {};  var centre= {}; var state1course = [];
				  for (var key in parsedData1) {
					    if (parsedData1.hasOwnProperty(key)) {
					        //console.log(key + " -> " + parsedData1[key]);
					        
					        if(key.includes('State')){
					        	var obj = parsedData1[key];
					        	var textval = '';
					        	var textopt = '';
					        	for (var key in obj) {
					        		  if (obj.hasOwnProperty(key)) {
					        		    var val = obj[key];
					        		    //console.log(val);
					        		    //console.log('Label '+key);
					        		    var el = document.createElement("option");
					        		    
					        		    if(key.includes('st_stname')){
					        		    	textval = val;
					        		    	
					        		    }
					        		    if(key.includes('st_stcode')){
					        		    	textopt = val;
					        		    }
					        		    
					        		  }
					        		}
							    el.text = textopt;
							    el.value = textval+' /'+el.text;
					        	Stselect.appendChild(el);
					        }
					        
					        if(key.includes('Centre')){
					        	
					        	var obj = parsedData1[key];
					        	
					        	var statecode1 = '';
					        	var centrecode1 = '';
					        	var centrename1 = '';
					        	for (var key in obj) {
					        		  if (obj.hasOwnProperty(key)) {
					        		    var val = obj[key];
					        		    
					        		    if(key.includes('ce_stcode')){
					        		    		statecode1 = val;
					        		    }
					        		    if(key.includes('ce_cecode')){
					        		    	centrecode1 = val;
					        		    }
					        		    if(key.includes('ce_cename')){
					        		    	centrename1 = val;
					        		    }
					        		  }
					        		}
					        	
					        	 var objstcentre = {
					        		        'statecode1': statecode1,
					        		        'centrecode1': centrecode1,
					        		        'centrename1': centrename1,
					        		    }
					        	 state1course.push(objstcentre);
					        	 localStorage.setItem('stateCentreMapObject', JSON.stringify(state1course));
					        	 var retrievedObject = localStorage.getItem('stateCentreMapObject');
					 			//console.log('retrievedObject: ', JSON.parse(retrievedObject));
					        }
					    }
				  }
			        
			//TODO SAKTHI  LOAD the exam application screen with this values

		} catch (e) {
				console.log("data error, Reason"+e.toString());
			}
		}else{
			
	
			var sbutton = document.getElementById('resultSaveExamApp');
			alert('else '+sbutton.style.display);
			if (sbutton.style.display == "block") {
				sbutton.style.display = "none";
			  }  
			
		}

}


function removeElements(elements){
    for(var i = 0; i < elements.length; i++){
        elements[i].parentNode.removeChild(elements[i]);
    }
}

// EXAM Save 
function AddValue(el){
	  if(el.value.trim() != ''){
	    var opSelected = dl.querySelector(`[value="${el.value}"]`);
	    var option = document.createElement("option");
	    option.value = opSelected.value;
	    option.text = opSelected.getAttribute('label');
	    alert(option.text);
	  }
	}
function getSelectedStatecode(){
	
	//alert('get selected code');
	
	var element_input = document.getElementById('examStateCode');
    var element_datalist = document.getElementById('examStateCodeList');
    var opSelected = element_datalist.querySelector(`[value="${element_input.value}"]`);
    
    var id = opSelected.getAttribute('value');
    
    var n = id.indexOf("/")+1;
    var n1 = id.length;
    var code = id.slice(n,n1);
    
    var coursebystate = document.getElementById("examCenterCodeList"); 
    
    coursebystate.textContent = '';
    
    var retrievedObjectTemp = localStorage.getItem('stateCentreMapObject');
		console.log('retrievedObject2222: ', JSON.parse(retrievedObjectTemp));
		var retrievedObjec = JSON.parse(retrievedObjectTemp);
		for (var key in retrievedObjec) {
		    if (retrievedObjec.hasOwnProperty(key)) {
		        
		        var objnk = retrievedObjec[key];
	        	
	        	var coursetextopt = '';
	        	var coursetext = '';
	        	var statecode1 = '';
	        	var centrecode1 = '';
	        	var centrename1 = '';
	        	for (var key in objnk) {
	        		  if (objnk.hasOwnProperty(key)) {
	        		    var val = objnk[key];
	        		    
	        		    var el = document.createElement("option");
	        		    if(key.includes('statecode1')){
	        		    	if(val.includes(code)){
	        		    		coursetextopt = objnk['centrecode1'];
	        		    		coursetext = objnk['centrename1'];
	        		    		
	        		    		el.text = coursetextopt;
	        				    el.value = coursetext+' /'+el.text;
	        				    coursebystate.appendChild(el);
	        		    	}
	        		    }
	        		  }
	        	}
		    }
		}
}


function saveExamApplication() {
	
	
	//save add new exam
	
	console.log('saveExamApplication  on EXAM clicked rajjj ');
	
	var prCodeExam = document.getElementById('prCodeExam').value;
	var prNoExam = document.getElementById('prNoExam').value;
	
	var stuNameExam = document.getElementById('stuNameExam').value;
	var diplomaCodeExam = document.getElementById('diplomaCodeExam').value;
	var durationExam = document.getElementById('durationExam').value;
	var noofPaperExam = document.getElementById('noofPaperExam').value;
	
	var semMonthExam = document.getElementById('semMonthExam').value;
	var semYearExam = document.getElementById('semYearExam').value;
	var enterDateExam = document.getElementById('enterDateExam').value;
	
	var examStateCode= document.getElementById('examStateCode').value;
	var examCenterCode= document.getElementById('examCenterCode').value;


	var ackIniLetterDate= document.getElementById('ackIniLetterDate').value
	var ackHallTckDate = document.getElementById('ackHallTckDate').value
	var ackExamdate1= document.getElementById('ackExamdate1').value
	var ackExamdate2= document.getElementById('ackExamdate2').value
	
	var oldnofpapr= document.getElementById('oldnofpapr').value=noofPaperExam;
	
	var items=document.getElementsByName('cboxpaper');
	var selectedItems="";
	for(var i=0; i<items.length; i++){
		console.log('  '+i+'    '+items[i].checked)
		if( items[i].checked==true)
			selectedItems+=items[i].value+", ";
	}
	console.log('cboxpaper  '+selectedItems);
	selectedItems = selectedItems.replace(/,\s*$/, "");    
	console.log('selectedItems .... '+selectedItems);
	document.getElementById('ea_paprstr').value = selectedItems;
	
	
	console.log('saveExamApplication  oldnofpapr '+oldnofpapr);
	console.log('saveExamApplication  ea_paprstr '+document.getElementById('ea_paprstr').value);
	
	var ea_paprstr= document.getElementById('ea_paprstr').value;

	
	console.log('saveExamApplication  on EXAM clicked rajjj ackHallTckDate '+ackHallTckDate );
	
	//var examNewnoPapers= document.getElementById('noofPaperExam').value;  do in DAO
	//var examTotalPaper= document.getElementById('examTotalPaper').value;
	
	if (prCodeExam == "" || prNoExam == "") {
			alert("Please enter the values in P.R.Code and P.R.No")
	  }else{
	
	
		if(isNaN( semMonthExam == "" || semYearExam == "" || examCenterCode == "") ){
				alert("Please enter values for Exam Semester Month and Year and Center,  Total paper,  and Exam Pass flag ");
		}else{
			postAjax('rs',{"app":"AiimasPost","module":"AddExamApplication","action":"examDetail","prCodeExam":prCodeExam,"prNoExam":prNoExam,"diplomaCodeExam":diplomaCodeExam,"durationExam":durationExam,"noofPaperExam":noofPaperExam,"semMonthExam":semMonthExam,"semYearExam":semYearExam,"enterDateExam":enterDateExam,"stuNameExam":stuNameExam,"examStateCode":examStateCode,"examCenterCode":examCenterCode,"ackIniLetterDate":ackIniLetterDate,"ackHallTckDate":ackHallTckDate,"ackExamdate1":ackExamdate1,"ackExamdate2":ackExamdate2,"oldnofpapr":oldnofpapr,"ea_paprstr":ea_paprstr}, onPostSAVEExamData);
		}
	}
}

function onPostSAVEExamData(data) {
	console.log('RESPONSE POST in   onPostSAVEExamData  app .JS:' + data);
	var parsedData1;
		
	if (data != null) {
						
					
			try {
			// Parse JSON
			parsedData1 = JSON.parse(data);
			
			console.log('save exam response '+JSON.stringify(parsedData1));	
			
			var stringformjsondata = JSON.stringify(parsedData1);
			
			if (stringformjsondata != null) {
				//if(parsedData1.Success.trim().length>0){   
				if(stringformjsondata.includes('Success')){ 
					document.getElementById('examApplication').style.display='block';
				}else if(stringformjsondata.includes('Failure')){
					document.getElementById('examApplicationfail').style.display='block';
				}
			}
			
			//TODO SAKTHI  LOAD the exam application screen with this values
			


		} catch (e) {
				console.log("data onPostSAVEExamData  error, Reason"+e.toString());
			}
		
		
		

		}else{
		//alert('else');
		//document.getElementById('resultTable1').style.display = "hide";
		}

}



//Exam Update todo
function updateExamApplication() {
	
	console.log('saveExamApplication  on EXAM clicked rajjj ');
	
	var prCodeExam = document.getElementById('prCodeExam1').value;
	var prNoExam = document.getElementById('prNoExam1').value;
	
	var stuNameExam = document.getElementById('stuNameExam1').value;
	var diplomaCodeExam = document.getElementById('diplomaCodeExam1').value;
	var durationExam = document.getElementById('durationExam1').value;
	var noofPaperExam = document.getElementById('noofPaperExam1').value;
	
	var semMonthExam = document.getElementById('semMonthExam1').value;
	var semYearExam = document.getElementById('semYearExam1').value;
	var enterDateExam = document.getElementById('enterDateExam1').value;
	
	var examStateCode= document.getElementById('examStateCode1').value;
	var examCenterCode= document.getElementById('examCenterCode1').value;
	var examPassFlag= document.getElementById('examPassFlag').value;


	var ackIniLetterDate= document.getElementById('ackIniLetterDate1').value
	var ackHallTckDate = document.getElementById('ackHallTckDate1').value
	var ackExamdate1= document.getElementById('ackExamdate11').value
	var ackExamdate2= document.getElementById('ackExamdate21').value
	
	var oldnofpapr= document.getElementById('oldnofpapr1').value=noofPaperExam;
	
	var items=document.getElementsByName('cboxpaper1');
	var selectedItems="";
	for(var i=0; i<items.length; i++){
		console.log('  '+i+'    '+items[i].checked)
		if( items[i].checked==true)
			selectedItems+=items[i].value+", ";
	}
	console.log('cboxpaper1  '+selectedItems);
	selectedItems = selectedItems.replace(/,\s*$/, "");    
	console.log('selectedItems .... '+selectedItems);
	document.getElementById('ea_paprstr1').value = selectedItems;
	
	
	console.log('saveExamApplication  oldnofpapr1 '+oldnofpapr);
	console.log('saveExamApplication  ea_paprstr1 '+document.getElementById('ea_paprstr1').value);
	
	var ea_paprstr= document.getElementById('ea_paprstr1').value;

	console.log('updateExamApplication  on EXAM clicked rajjj ea_paprstr  ???  Sakthi this vale no coming ?? '+ea_paprstr );
	console.log('updateExamApplication  on EXAM clicked rajjj ackHallTckDate '+ackHallTckDate );
	
	//var examNewnoPapers= document.getElementById('noofPaperExam').value;  do in DAO
	//var examTotalPaper= document.getElementById('examTotalPaper').value;
	
	if (prCodeExam == "" || prNoExam == "" || semMonthExam == "" || semYearExam == "" || examCenterCode == "" ) {
			alert("Please enter the values in P.R.Code and P.R.No, Exam Month, Exam year and  Center")
	  }else{
	
	
		if(isNaN(semYearExam) ){
				alert("Please enter Exam Semester Year in number ");
		}else{
			postAjax('rs',{"app":"AiimasPost","module":"UpdateExamApplication","action":"examDetail","prCodeExam":prCodeExam,"prNoExam":prNoExam,"diplomaCodeExam":diplomaCodeExam,"durationExam":durationExam,"noofPaperExam":noofPaperExam,"semMonthExam":semMonthExam,"semYearExam":semYearExam,"enterDateExam":enterDateExam,"stuNameExam":stuNameExam,"examStateCode":examStateCode,"examCenterCode":examCenterCode,"examPassFlag":examPassFlag,"ackIniLetterDate":ackIniLetterDate,"ackHallTckDate":ackHallTckDate,"ackExamdate1":ackExamdate1,"ackExamdate2":ackExamdate2,"oldnofpapr":oldnofpapr,"ea_paprstr":ea_paprstr}, onPostUpdateExamData);
		}
	}
}

function onPostUpdateExamData(data) {
	console.log('RESPONSE POST in   onPostUpdateExamData  app .JS:' + data);
	var parsedData1;
		
	if (data != null) {
					
			try {
			// Parse JSON
			parsedData1 = JSON.parse(data);
			
			console.log('save exam response '+JSON.stringify(parsedData1));	
			
			var stringformjsondata = JSON.stringify(parsedData1);
			
			if (stringformjsondata != null) {
				//if(parsedData1.Success.trim().length>0){   
				if(stringformjsondata.includes('Success')){ 
					document.getElementById('examUpdateApplication').style.display='block';
				}else if(stringformjsondata.includes('Failure')){
					document.getElementById('examUpdateApplicationfail').style.display='block';
				}
			}
			
			//TODO SAKTHI  LOAD the exam application screen with this values
			


		} catch (e) {
				console.log("data error, Reason"+e.toString());
			}
		
		
		

		}else{
		//alert('else');
		//document.getElementById('resultTable1').style.display = "hide";
		}

}

// MARKS  PAPER  deails

function getMarkData() {
	
	console.log('getMarkData  on MArk clicked rajjj ');
	
	clearAllAtrbutesMarks();
	
	var prcode = document.getElementById('prCodeMark').value;
	var prno = document.getElementById('prNoMark').value;
	
	if (prcode == "" || prno == "") {
			alert("Please enter the values in P.R.Code and P.R.No")
	  }else{
	
		postAjax('rs',{"app":"AiimasPost","module":"MarkApplication","action":"markDetail","prNo":prno,"prCode":prcode}, onPostgetMarkData);
	}
}

const sort_by = (field, reverse, primer) => {

	  const key = primer ?
	    function(x) {
	      return primer(x[field])
	    } :
	    function(x) {
	      return x[field]
	    };

	  reverse = !reverse ? 1 : -1;

	  return function(a, b) {
	    return a = key(a), b = key(b), reverse * ((a > b) - (b > a));
	  }
	}


function sortByKey(jsObj){
    var sortedArray = [];

    // Push each JSON Object entry in array by [key, value]
    for(var i in jsObj)
    {
        sortedArray.push([i, jsObj[i]]);
    }

    // Run native sort function and returns sorted array.
    return sortedArray.sort();
}





function onPostgetMarkData(data) {
	console.log('RESPONSE POST in   onPostgetMarkData  app .JS:' + data);
	var parsedData1;
		
	if (data != null) {
						
					
			try {
			// Parse JSON
			var parsedData1pr = JSON.parse(data);
			
			var jsonstring =  JSON.stringify(data) ;
			console.log(' mark Detail  '+ jsonstring   );
			
			var executeFunction = false;
			
			if(jsonstring == "\"{}\""){
				document.getElementById('markDetailNotFound').style.display='block'; 
				clearAllAtrbutesMarks();
			}else if(parsedData1pr['Failure'] !== undefined){
				document.getElementById('markDetailNotFound').style.display='block';
				//$("#markDetailNotFound").show();
				//executeFunction = true;
				clearAllAtrbutesMarks();
			}else if(parsedData1pr['Success'] !== undefined){
				
				
				//$("#markDetailFound").show();
				//clearAllAtrbutesV2();
				executeFunction = true;
			}
			
			for (var key in parsedData1pr) {
			    if (parsedData1pr.hasOwnProperty(key)) {
			        console.log(key + "  -> " + parsedData1pr[key]);
			        
			        if(key == 'Exam' || key.includes('Paper')){
			        	executeFunction = true;
			        	document.getElementById('markDetailFound').style.display='block';
			        }
			    }
			}
			
			if(executeFunction){
			
			
			for (var key in parsedData1pr) {
			    if (parsedData1pr.hasOwnProperty(key)) {
			        console.log(key + "  -> " + parsedData1pr[key]);
			        
			        if(key == 'Exam'){
				        //console.log('PaperList1 paper no >> '+parsedData1pr.PaperList1["dp_paperno"]);
				        //console.log('PaperList1 paper param >> '+parsedData1pr.PaperList1["dp_paprnam"]);
				        //dict[parsedData1pr.PaperList1["dp_paperno"]] = parsedData1pr.PaperList1["dp_paprnam"];
			        	
			        	document.getElementById("stuNameMark").value =  parsedData1pr.Exam["ea_name"];
						document.getElementById("diplomaCodeMark").value =  parsedData1pr.Exam["ea_dipcode"];
						document.getElementById("durationMark").value =  parsedData1pr.Exam["ea_durtn"];
						document.getElementById("noofPaperMark").value =  parsedData1pr.Exam["ea_nofpapr"];
						document.getElementById("SemMonthMark").value =  parsedData1pr.Exam["ea_sesmon"];
						document.getElementById("SemYearMark").value =  parsedData1pr.Exam["ea_sesyr"];
						document.getElementById("stateMark").value =  parsedData1pr.Exam["ea_stname"];
						document.getElementById("centerMark").value =  parsedData1pr.Exam["ea_centre1"];
			        }
			    }
			}
			
			
			var count = Object.keys(parsedData1pr).length;
			  console.log('parsedData1pr '+count);
			  var dict = {};
			  
			  for (var key in parsedData1pr) {
				    if (parsedData1pr.hasOwnProperty(key)) {
				        console.log(key + " -> " + parsedData1pr[key]);

  						if(key == 'PaperList0'){
					        //console.log('PaperList1 paper no >> '+parsedData1pr.PaperList1["dp_paperno"]);
					        //console.log('PaperList1 paper param >> '+parsedData1pr.PaperList1["dp_paprnam"]);
					        dict[parsedData1pr.PaperList0["dp_paperno"]] = parsedData1pr.PaperList0["dp_paprnam"];
					        document.getElementById("marksentersegment").style.display = "block";
				        }
				        
				        if(key == 'PaperList1'){
					        //console.log('PaperList1 paper no >> '+parsedData1pr.PaperList1["dp_paperno"]);
					        //console.log('PaperList1 paper param >> '+parsedData1pr.PaperList1["dp_paprnam"]);
					        dict[parsedData1pr.PaperList1["dp_paperno"]] = parsedData1pr.PaperList1["dp_paprnam"];
					        document.getElementById("marksentersegment").style.display = "block";
				        }
				        
				        if(key == 'PaperList2'){
					        //console.log('PaperList2 paper no >> '+parsedData1pr.PaperList2["dp_paperno"]);
					        //console.log('PaperList2 paper param >> '+parsedData1pr.PaperList2["dp_paprnam"]);
					        dict[parsedData1pr.PaperList2["dp_paperno"]] = parsedData1pr.PaperList2["dp_paprnam"];
				        }
				        
				        if(key == 'PaperList3'){
					        //console.log('PaperList3 paper no >> '+parsedData1pr.PaperList3["dp_paperno"]);
					        //console.log('PaperList3 paper param >> '+parsedData1pr.PaperList3["dp_paprnam"]);
					        dict[parsedData1pr.PaperList3["dp_paperno"]] = parsedData1pr.PaperList3["dp_paprnam"];
				        }
				        
				        if(key == 'PaperList4'){
					        //console.log('PaperList4 paper no >> '+parsedData1pr.PaperList4["dp_paperno"]);
					        //console.log('PaperList4 paper param >> '+parsedData1pr.PaperList4["dp_paprnam"]);
					        dict[parsedData1pr.PaperList4["dp_paperno"]] = parsedData1pr.PaperList4["dp_paprnam"];
				        }
				        
				        if(key == 'PaperList5'){
					        //console.log('PaperList5 paper no >> '+parsedData1pr.PaperList5["dp_paperno"]);
					        //console.log('PaperList5 paper param >> '+parsedData1pr.PaperList5["dp_paprnam"]);
					        dict[parsedData1pr.PaperList5["dp_paperno"]] = parsedData1pr.PaperList5["dp_paprnam"];
				        }
				        
				        if(key == 'PaperList6'){
					        //console.log('PaperList65 paper no >> '+parsedData1pr.PaperList6["dp_paperno"]);
					        //console.log('PaperList6 paper param >> '+parsedData1pr.PaperList6["dp_paprnam"]);
					        dict[parsedData1pr.PaperList6["dp_paperno"]] = parsedData1pr.PaperList6["dp_paprnam"];
				        }
				        
				        if(key == 'PaperList7'){
					        //console.log('PaperList7 paper no >> '+parsedData1pr.PaperList7["dp_paperno"]);
					        //console.log('PaperList7 paper param >> '+parsedData1pr.PaperList7["dp_paprnam"]);
					        dict[parsedData1pr.PaperList7["dp_paperno"]] = parsedData1pr.PaperList7["dp_paprnam"];
				        }
				        
				        if(key == 'PaperList8'){
					        //console.log('PaperList8 paper no >> '+parsedData1pr.PaperList8["dp_paperno"]);
					        //console.log('PaperList8 paper param >> '+parsedData1pr.PaperList18["dp_paprnam"]);
					        dict[parsedData1pr.PaperList8["dp_paperno"]] = parsedData1pr.PaperList8["dp_paprnam"];
				        }
				        
				    }
				}
			/*  
			var tbodyRef = document.getElementById('myTable').getElementsByTagName('tbody')[0];
			// Insert a row at the end of table
			var newRow = tbodyRef.insertRow();

			// Insert a cell at the end of the row
			var newCell = newRow.insertCell();

			// Append a text node to the cell
			var newText = document.createTextNode('new row');
			newCell.appendChild(newText);*/
			  
			  //var value = dict[key];

			  var value = dict.key; var xyincrement = 1;
			  for(var key in dict) {
			     console.log('xyincrement '+xyincrement+'   dict === >> '+key + " : " + dict[key]);
			     $("#displayPaper"+xyincrement).show();
			     var temp1= "row"+xyincrement+"paper";
			     var temp2= "row"+xyincrement+"papername";
			     document.getElementById(temp1).value   = 'Paper '+key;
			     document.getElementById(temp2).value   = dict[key];
			     xyincrement++;
			  }
			
			var sortedbyKeyJSONArray = sortByKey(parsedData1pr);
			//console.log(sortedbyKeyJSONArray);
			
			
			//var paperNoPaperName = {};
			//var paperList = []
			//paperNoPaperName.paperList = paperList;
			//console.log('paperNoPaperName = = = =  = = = = =  = = = = = =  = = = = '+paperNoPaperName);

			//sortedbyKeyJSONArray.PaperList 1["dp_paperno"]
			/*
			var paperList = {
			  "paperNoNew": firstName,
			  "paperNameNew": lastName
			}
			paperNoPaperName.paperList.push(paperList);
			console.log(paperNoPaperName);


			console.log(JSON.stringify(paperNoPaperName));			
			console.log('---------'+parsedData1pr);*/
			//Now you can sort by any field at will...
			//const homes=[{h_id:"3",city:"Dallas",state:"TX",zip:"75201",price:"162500"},{h_id:"4",city:"Bevery Hills",state:"CA",zip:"90210",price:"319250"},{h_id:"5",city:"New York",state:"NY",zip:"00010",price:"962500"}];
			// Sort by price high to low
			//console.log(parsedData1pr.sort(sort_by('dp_paperno', false, parseInt)));
			//console.log(parsedData1pr.sort(sortByProperty('dp_paperno')));
			//TODO SAKTHI  LOAD the exam application screen with this values
			}

		} catch (e) {
				console.log("data error,Reason"+e.toString());
			}

		}else{
		}
		
		

}

//MARKS SAVE

function saveMark() {
	
	console.log('save MARK clicked rajjj ');
	
	var prCodeMark = document.getElementById('prCodeMark').value;
	var prNoMark = document.getElementById('prNoMark').value;
	
	//
	var diplomaCodeMark = document.getElementById('diplomaCodeMark').value;
	//var noofPaperMark = document.getElementById('durationMark').value;
	var noofPaperMark = document.getElementById('noofPaperMark').value;
	
	var SemMonthMark = document.getElementById('SemMonthMark').value;
	var SemYearMark = document.getElementById('SemYearMark').value;
	
	var enterDateMarks = document.getElementById('enterDateMarks').value;
	
	
	//var enterDateExam = document.getElementById('enterDateExam').value;
	var stuNameMark = document.getElementById('stuNameMark').value;
	
	
	
	var row1paperMark= document.getElementById('row1paperMark').value;
	var row1paper= document.getElementById('row1paper').value;
	var row1papername= document.getElementById('row1papername').value;
	
	var row2paperMark= document.getElementById('row2paperMark').value;
	var row2paper= document.getElementById('row2paper').value;
	var row2papername= document.getElementById('row2papername').value;
	
	var row3paperMark= document.getElementById('row3paperMark').value;
	var row3paper= document.getElementById('row3paper').value;
	var row3papername= document.getElementById('row3papername').value;
	
	var row4paperMark= document.getElementById('row4paperMark').value;
	var row4paper= document.getElementById('row4paper').value;
	var row4papername= document.getElementById('row4papername').value;
	
	var row5paperMark= document.getElementById('row5paperMark').value;
	var row5paper= document.getElementById('row5paper').value;
	var row5papername= document.getElementById('row5papername').value;
	
	var row6paperMark= document.getElementById('row6paperMark').value;
	var row6paper= document.getElementById('row6paper').value;
	var row6papername= document.getElementById('row6papername').value;
	
	var row7paperMark= document.getElementById('row7paperMark').value;
	var row7paper= document.getElementById('row7paper').value;
	var row7papername= document.getElementById('row7papername').value;
	
	var row8paperMark= document.getElementById('row8paperMark').value;
	var row8paper= document.getElementById('row8paper').value;
	var row8papername= document.getElementById('row8papername').value;
	
console.log('save MARK clicked rajjj '+row1paperMark);

	console.log('save MARK clicked rajjj '+isNaN(row1paperMark));
	
//	if (examStateCode == "" || prno == "") {
//			alert("Please enter the values in P.R.Code and P.R.No")
//	  }else{
	
	
	if( isNaN(row1paperMark) || isNaN(row2paperMark) || isNaN(row3paperMark) || isNaN(row4paperMark)|| isNaN(row5paperMark)|| isNaN(row6paperMark)|| isNaN(row7paperMark)|| isNaN(row8paperMark) ){
			alert("Please enter only numbers for MARKS ");
	}else{
	postAjax('rs',{"app":"AiimasPost","module":"SaveMark","action":"MarkDetail","prCodeMark":prCodeMark,"prNoMark":prNoMark,"diplomaCodeMark":diplomaCodeMark,"SemMonthMark":SemMonthMark,"SemYearMark":SemYearMark,"stuNameMark":stuNameMark,"enterDateMarks":enterDateMarks,"noofPaperMark":noofPaperMark,"row1paperMark":row1paperMark,"row1paper":row1paper,"row1papername":row1papername,"row2paperMark":row2paperMark,"row2paper":row2paper,"row2papername":row2papername,"row3paperMark":row3paperMark,"row3paper":row3paper,"row3papername":row3papername,"row4paperMark":row4paperMark,"row4paper":row4paper,"row4papername":row4papername,"row5paperMark":row5paperMark,"row5paper":row5paper,"row5papername":row5papername,"row6paperMark":row6paperMark,"row6paper":row6paper,"row6papername":row6papername,"row7paperMark":row7paperMark,"row7paper":row7paper,"row7papername":row7papername,"row8paperMark":row8paperMark,"row8paper":row8paper,"row8papername":row8papername}, onPostSaveMarkData);
	}
}

function onPostSaveMarkData(data) {
	
	console.log('RESPONSE POST in   onPostSaveMarkData  app .JS:' + data);
	var parsedData1;
		
	if (data != null) {
						
					
			try {
			// Parse JSON
			parsedData1 = JSON.parse(data);
			
			console.log('save exam response '+JSON.stringify(parsedData1));	
			
			var stringformjsondata = JSON.stringify(parsedData1);
			
			if (stringformjsondata != null) {
			
				if(stringformjsondata.includes('Success')){ 
					document.getElementById('saveMark').style.display='block';
				}else if(stringformjsondata.includes('Failure')){
					document.getElementById('saveMarkFail').style.display='block';
				}
			}
			
			//TODO SAKTHI  LOAD the exam application screen with this values
			


		} catch (e) {
				console.log("data onPostSAVEExamData  error, Reason"+e.toString());
			}
		
		
		

		}else{
		//alert('else');
		//document.getElementById('resultTable1').style.display = "hide";
		}

}

// get Marks update 
function getMarkUpdateData() {
	
	console.log('getMark UPDATE Data  on MArk clicked rajjj ');
	
	clearAllAtrbutesMarks();
	
	var prcode1 = document.getElementById('prCodeMark1').value;
	var prno1 = document.getElementById('prNoMark1').value;
	
	if (prcode1 == "" || prno1 == "") {
			alert("Please enter the values in P.R.Code and P.R.No")
	  }else{
	
		postAjax('rs',{"app":"AiimasPost","module":"MarkUpdateApplication","action":"markDetail","prNo1":prno1,"prCode1":prcode1}, onPostgetMarkUpdateData);
	}
}

function onPostgetMarkUpdateData(data) {
	console.log('RESPONSE POST in   onPostgetMarkData  app .JS:' + data);
	var parsedData1;
		
	if (data != null) {
		
		// SKATHI to do
		}
}
		

// UPDATE MARKS
function updateMark1() {
	
	console.log('UPDATE MARK1clicked rajjj ');
	
	var prCodeMark1 = document.getElementById('prCodeMark1').value;
	var prNoMark1 = document.getElementById('prNoMark1').value;
	
	//
	var diplomaCodeMark1 = document.getElementById('diplomaCodeMark1').value;
	//var noofPaperMark = document.getElementById('durationMark').value;
	var noofPaperMark1 = document.getElementById('noofPaperMark1').value;
	
	var SemMonthMark1 = document.getElementById('SemMonthMark1').value;
	var SemYearMark1 = document.getElementById('SemYearMark1').value;
	
	var enterDateMarks1 = document.getElementById('enterDateMarks1').value;
	
	
	//var enterDateExam = document.getElementById('enterDateExam').value;
	var stuNameMark1 = document.getElementById('stuNameMark1').value;
	
	
	
	var row1paperMark1= document.getElementById('row1paperMark1').value;
	var row1paper1= document.getElementById('row1paper1').value;
	var row1papername1= document.getElementById('row1papername1').value;
	
	var row2paperMark1= document.getElementById('row2paperMark1').value;
	var row2paper1= document.getElementById('row2paper1').value;
	var row2papername1= document.getElementById('row2papername1').value;
	
	var row3paperMark1= document.getElementById('row3paperMark1').value;
	var row3paper1= document.getElementById('row3paper1').value;
	var row3papername1= document.getElementById('row3papername1').value;
	
	var row4paperMark1= document.getElementById('row4paperMark1').value;
	var row4paper1= document.getElementById('row4paper1').value;
	var row4papername1= document.getElementById('row4papername1').value;
	
	var row5paperMark1= document.getElementById('row5paperMark1').value;
	var row5paper1= document.getElementById('row5paper1').value;
	var row5papername1= document.getElementById('row5papername1').value;
	
	var row6paperMark1= document.getElementById('row6paperMark1').value;
	var row6paper1= document.getElementById('row6paper1').value;
	var row6papername1= document.getElementById('row6papername1').value;
	
	var row7paperMark1= document.getElementById('row7paperMark1').value;
	var row7paper1= document.getElementById('row7paper1').value;
	var row7papername1= document.getElementById('row7papername1').value;
	
	var row8paperMark1= document.getElementById('row8paperMark1').value;
	var row8paper1= document.getElementById('row8paper1').value;
	var row8papername1= document.getElementById('row8papername1').value;
	
console.log('save MARK clicked rajjj '+row1paperMark1);

	console.log('save MARK clicked rajjj '+isNaN(row1paperMark1));
	

	
	
	if( isNaN(row1paperMark1) || isNaN(row2paperMark1) || isNaN(row3paperMark1) || isNaN(row4paperMark1)|| isNaN(row5paperMark1)|| isNaN(row6paperMark1)|| isNaN(row7paperMark1)|| isNaN(row8paperMark1) ){
			alert("Please enter only numbers for MARKS ");
	}else{
	postAjax('rs',{"app":"AiimasPost","module":"UpdateMark","action":"MarkDetail1","prCodeMark1":prCodeMark1,"prNoMark1":prNoMark1,"diplomaCodeMark1":diplomaCodeMark1,"SemMonthMark1":SemMonthMark1,"SemYearMark1":SemYearMark1,"stuNameMark1":stuNameMark1,"enterDateMarks1":enterDateMarks1,"noofPaperMark1":noofPaperMark1,"row1paperMark1":row1paperMark1,"row1paper1":row1paper1,"row1papername1":row1papername1,"row2paperMark1":row2paperMark1,"row2paper1":row2paper1,"row2papername1":row2papername1,"row3paperMark1":row3paperMark1,"row3paper1":row3paper1,"row3papername1":row3papername1,"row4paperMark1":row4paperMark1,"row4paper1":row4paper1,"row4papername1":row4papername1,"row5paperMark1":row5paperMark1,"row5paper1":row5paper1,"row5papername1":row5papername1,"row6paperMark1":row6paperMark1,"row6paper1":row6paper1,"row6papername1":row6papername1,"row7paperMark1":row7paperMark1,"row7paper1":row7paper1,"row7papername1":row7papername1,"row8paperMark1":row8paperMark1,"row8paper1":row8paper1,"row8papername1":row8papername1}, onPostUpdateMarkData);
	}
}

//todo here

function onPostUpdateMarkData(data) {
	
	console.log('RESPONSE POST in   onPostSaveMarkData  app .JS:' + data);
	var parsedData1;
		
	if (data != null) {
						
					
			try {
			// Parse JSON
			parsedData1 = JSON.parse(data);
			
			console.log('save exam response '+JSON.stringify(parsedData1));	
			
			var stringformjsondata = JSON.stringify(parsedData1);
			
			if (stringformjsondata != null) {
			
				if(stringformjsondata.includes('Success')){ 
					document.getElementById('saveMark1').style.display='block';
				}else if(stringformjsondata.includes('Failure')){
					document.getElementById('saveMarkFail1').style.display='block';
				}
			}
			
			//TODO SAKTHI  LOAD the exam application screen with this values
			


		} catch (e) {
				console.log("data onPost update ExamData  error, Reason"+e.toString());
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
	
		postAjax('rs',{"app":"AiimasPost","module":"getStudentData","action":"admDetails","prNo":prno,"prCode":prcode}, onPostgetModifyAdmData);
	}
}



function onPostgetModifyAdmData(data) {
	console.log('RESPONSE POST in   onPostgetModifyAdmData  app .JS:' + data);
	let parsedData1 = null;
		
	if (data != null) {
						
		//console.log(' parseddata'+ JSON.stringify(data)   );
			try {
			// Parse JSON
			parsedData1 = JSON.parse(data);
			console.log(' parsedData1'+parsedData1);
		
			if(parsedData1['Admin'] !== undefined || parsedData1['Address'] !== undefined || parsedData1['Fee'] !== undefined ){
				//$("#alertDetailFound").show();     
				document.getElementById('updateadmissionDataLoad').style.display='block';
			}else if(parsedData1['Failure'] !== undefined){
				//$("#alertDetailNotFound").show();
				document.getElementById('updateadmissionDataLoadFail').style.display='block'; 
				clearAllAtrbutes();
			}else{
				var jsonstring =  JSON.stringify(data) ;
				console.log(' parseddata empty '+ jsonstring   );
				if(jsonstring == "\"{}\""){
					document.getElementById('get_student_detail').style.display='block'; 
				}
			}
		
			
			
		if(parsedData1['Admin'] !== undefined){
			
			document.getElementById("stuName1").value =  parsedData1.Admin["ad_name"];
			document.getElementById("papers1").value = parsedData1.Admin["ad_nofpapr"]; 
			//document.getElementById("duration1").value = parsedData1.Admin["ad_durtn"];   
			//document.querySelector('#duration1').value = parsedData1.Admin["ad_durtn"];
			console.log('----------------------------------------------------------------'+ parsedData1.Admin["ad_durtn"]);
			selectItem('#duration1', parsedData1.Admin["ad_durtn"]);
			document.getElementById("paidamt1").value = parsedData1.Admin["ad_paidamt"]; 
			document.getElementById("totfee1").value = parsedData1.Admin["ad_feeamt"]; 
			
			var endDate = returnFormatDate(parsedData1.Admin["ad_entdate"]);
			//document.getElementById("dueDate1").value = endDate; 
			document.getElementById("enterDate1").value = endDate; 
			
			var feedate = returnFormatDate(parsedData1.Admin["ad_feedate"]);
			document.getElementById("feepaiddate1").value = feedate; 
		}
		
		if(parsedData1['Address'] !== undefined){
			document.getElementById("emailid1").value = parsedData1.Address["sa_email"]; 
			document.getElementById("state1").value = parsedData1.Address["sa_state"]; 
			document.getElementById("pincode1").value = parsedData1.Address["sa_pincode"]; 
			document.getElementById("diplomaCodeUad").value = parsedData1.Address["sa_dipcode"]; 
			document.getElementById("mobNum1").value = parsedData1.Address["sa_mobile"];  
			document.getElementById("address31").value = parsedData1.Address["sa_add3"];
			document.getElementById("address21").value = parsedData1.Address["sa_add2"]; 
			document.getElementById("address11").value = parsedData1.Address["sa_add1"]; 
			document.getElementById("address41").value = parsedData1.Address["sa_add4"]; 
			document.getElementById("phonenum1").value = parsedData1.Address["sa_phone"]; 
		}
		
		if(parsedData1['Fee'] !== undefined){
			document.getElementById("semMonth1").value = parsedData1.Fee["fe_sesmon"]; 
			document.getElementById("semYear1").value = parsedData1.Fee["fe_sesyr"]; 
			document.getElementById("feepaidmode1").value = parsedData1.Fee["fe_mode"]; 
			document.getElementById("feeref1").value = parsedData1.Fee["fe_ref"]; 
		}
		
			} catch (e) {
		console.log("data error, Reason"+e.toString());
	}	
			
	}else{
		document.getElementById('get_student_detail').style.display='block'; 
	}
}

function selectItem(selector, label) {     
			/*console.log('label- - - - '+label);
			console.log('label- - - - '+label.length);
			const dropdown = document.querySelector(selector);     
			console.log('dropdown- - - - '+dropdown.options);
			const index = Array.from(dropdown.options).findIndex(option => option.label === label);    
			console.log('index- - - - '+!index);
			if (!index) 
				return  dropdown.selectedIndex = index   */
		const dd = document.querySelector(selector); 
		for (var i = 0; i < dd.options.length; i++) {
			console.log('dd.options[i].text- - - - '+dd.options[i].text);
			console.log('label- - - - '+label);
			console.log('are they equal- - - - '+dd.options[i].text === label);
			//$('jqueryselector').val($(this).val().toUpperCase());
			
		    if (dd.options[i].text.toUpperCase() === label.toUpperCase()) {
		        dd.selectedIndex = i;
		        break;
		    }
		}
	}  
				/*
				
			
				
				
				
				if(parsedData1.Admin["ad_entdate"]!=null){
					
				}
				
				  
				if(parsedData1.Admin["ad_feedate"]!=null){
					
				}  
				
				
				
				
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
				console.log("data error, Reason"+e.toString());
			}
		
		
		

		}else{
		//alert('else');
		//document.getElementById('resultTable1').style.display = "hide";
		}




}*/
function loadDate(getField){
	
	//var date = new Date();
	///let dateToday =  ((date.getMonth() > 8) ? (date.getMonth() + 1) : ('0' + (date.getMonth() + 1))) + '/' + ((date.getDate() > 9) ? date.getDate() : ('0' + date.getDate())) + '/' + date.getFullYear();
	//console.log('load date called ---------------------------------------------------------------------'+dateToday);
	//document.getElementById(getField).value = ''+dateToday;
	//document.getElementById('enterDate').value = dateToday;
	//console.log('vvvvvvvvvvvvvvvvv '+getField);
	/*
	 var myDate = document.querySelector(getField);
	 document.getElementById('enterDate').innerHTML = '11/12/2012';
	  var today = new Date();
	  console.log('vvvvvvvvvvvvvvvvv '+today.toISOString().substr(0, 10));
	  myDate.value = today.toISOString().substr(0, 10);
	  console.log('vvvvvvvvvvvvvvvvv '+document.getElementById('enterDate').value);*/
	var field = document.querySelector('input[id="'+getField+'"]');
	var date = new Date();

	// Set the date
	field.value = date.getFullYear().toString() + '-' + (date.getMonth() + 1).toString().padStart(2, 0) + 
	    '-' + date.getDate().toString().padStart(2, 0);
	
	}



function returnFormatDate(inputDate){
	var ad_entdate11 = new Date(inputDate);
	  var dd = ad_entdate11.getDate();

	  var mm = ad_entdate11.getMonth()+1; 
	  var yyyy = ad_entdate11.getFullYear();
	  if(dd<10)   {
	      dd='0'+dd;
	  } 
	  if(mm<10)   {
	      mm='0'+mm;
	  } 
	  
	  return ad_entdate11 = yyyy+'-'+mm+'-'+dd;
}

function clearAllAtrbutes() {
	
	console.log('clear dong');
	
	document.getElementById("stuName1").value =  "";
	document.getElementById("papers1").value = ""; 
	document.getElementById("emailid1").value = ""; 
	document.getElementById("state1").value = ""; 
	document.getElementById("pincode1").value = ""; 
	document.getElementById("diplomaCodeUad").value = ""; 
	document.getElementById("mobNum1").value = ""; 
	document.getElementById("address31").value = ""; 
	document.getElementById("address21").value = ""; 
	document.getElementById("address11").value = ""; 
	document.getElementById("address41").value = ""; 
	document.getElementById("semMonth1").value = ""; 
	document.getElementById("semYear1").value = ""; 
	document.getElementById("duration1").value = ""; 
	document.getElementById("feepaidmode1").value = ""; 
	document.getElementById("feeref1").value = ""; 
	document.getElementById("paidamt1").value = ""; 
	document.getElementById("totfee1").value = ""; 
	document.getElementById("dueDate1").value = ""; 
	document.getElementById("feepaiddate1").value = "";    
	document.getElementById("prCode111").value = "";
	document.getElementById("prNo11").value = "";
}

function clearAllAtrbutesV1() {
	
	// for exam add
	
	  document.getElementById("prCodeExam").value =  "";
	  document.getElementById("prNoExam").value =  "";
	  document.getElementById("stuNameExam").value =  "";
	  document.getElementById("diplomaCodeExam").value =  "";
	  document.getElementById("durationExam").value =  "";
	  document.getElementById("noofPaperExam").value =  "";
	  document.getElementById("semMonthExam").value =  "";
	  document.getElementById("semYearExam").value =  "";
	  document.getElementById("examStateCode").value =  "";
	  document.getElementById("examCenterCode").value =  "";

 document.getElementById("ackIniLetterDate").value =  "";
 document.getElementById("ackHallTckDate").value =  "";
 document.getElementById("ackExamdate1").value =  ""; 
 document.getElementById("ackExamdate2").value =  "";
	  
	  if($("#cboxpaper").length){
		  document.getElementById('displayPaper1').style.display='none'; 
	  }

	  
	  $('#examStateCodeList option').remove();  
	  $('#examCenterCodeList option').remove(); 
	  //$('#examStateCodeList text').val('');
	 // document.getElementById("examStateCode").innerHTML =  "";   
	 // document.getElementById("examStateCodeList").innerHTML =  "";
	  
	  
	 /* $('#examStateCode option').remove();
	  $('#examStateCodeList option').remove();   
	  $('#examCenterCodeList option').remove();  
	  $('#examCenterCode text').remove();
	  
	  $('#examStateCode value').remove();
	  $('#examStateCodeList value').remove();   
	  $('#examCenterCodeList value').remove();  
	  $('#examCenterCode value').remove();*/
	  
	  var elementStCode = document.querySelectorAll("input[id='examStateCodeList']");
	  if(typeof(elementStCode) != 'undefined' && elementStCode != null){
		  console.log('drop down data list '+elementStCode.length);
						
	}
	  var elementCb = document.querySelectorAll("input[id='cboxpaper']");

		 if(typeof(elementCb) != 'undefined' && elementCb != null){
						 
				 var elem=$("#slct2 input");
				 $("#slct2").empty().html(elem);
				 
					
				for(var i = 0,j=1; i < elementCb.length; i++){
					elementCb[i].parentNode.removeChild(elementCb[i]);
				}
						   
							
		} else{
			console.log('Element does not exist!');
		}
}


function clearAllAtrbutesExamUpdate() {
	
	// for exam update
	
	  document.getElementById("prCodeExam1").value =  "";
	  document.getElementById("prNoExam1").value =  "";
	  document.getElementById("stuNameExam1").value =  "";
	  document.getElementById("diplomaCodeExam1").value =  "";
	  document.getElementById("durationExam1").value =  "";
	  document.getElementById("noofPaperExam1").value =  "";
	  document.getElementById("semMonthExam1").value =  "";
	  document.getElementById("semYearExam1").value =  "";
	  document.getElementById("examStateCode1").value =  "";
	  document.getElementById("examCenterCode1").value =  "";
	  
	  if($("#cboxpaper").length){
		  document.getElementById('displayPaper12').style.display='none'; 
	  }

 document.getElementById("ackIniLetterDate1").value =  "";
 document.getElementById("ackHallTckDate1").value =  "";
 document.getElementById("ackExamdate11").value =  ""; 
 document.getElementById("ackExamdate21").value =  "";

	  
	  $('#examStateCodeList1 option').remove();  
	  $('#examCenterCodeList1 option').remove(); 
	  //$('#examStateCodeList text').val('');
	 // document.getElementById("examStateCode").innerHTML =  "";   
	 // document.getElementById("examStateCodeList").innerHTML =  "";
	  
	  
	 /* $('#examStateCode option').remove();
	  $('#examStateCodeList option').remove();   
	  $('#examCenterCodeList option').remove();  
	  $('#examCenterCode text').remove();
	  
	  $('#examStateCode value').remove();
	  $('#examStateCodeList value').remove();   
	  $('#examCenterCodeList value').remove();  
	  $('#examCenterCode value').remove();*/
	  
	  var elementStCode = document.querySelectorAll("input[id='examStateCodeList1']");
	  if(typeof(elementStCode) != 'undefined' && elementStCode != null){
		  console.log('drop down data list '+elementStCode.length);
						
	}
	  var elementCb = document.querySelectorAll("input[id='cboxpaper1']");

		 if(typeof(elementCb) != 'undefined' && elementCb != null){
						 
				 var elem=$("#slct2 input");
				 $("#slct2").empty().html(elem);
				 
					
				for(var i = 0,j=1; i < elementCb.length; i++){
					elementCb[i].parentNode.removeChild(elementCb[i]);
				}
						   
							
		} else{
			console.log('Element does not exist!');
		}
}


function clearAllAtrbutesMarks() {
	//	document.getElementById("prCodeMark").value =   "";
	// document.getElementById("prNoMark").value =   "";
	document.getElementById("diplomaCodeMark").value =   "";
	document.getElementById("SemMonthMark").value =   "";
	document.getElementById("SemYearMark").value =   "";
	document.getElementById("stuNameMark").value =   "";
	
	document.getElementById("enterDateMarks").value =   "";
	document.getElementById("durationMark").value =   "";
	document.getElementById("noofPaperMark").value =   "";
	document.getElementById("stateMark").value =   "";
	document.getElementById("centerMark").value =   "";
	document.getElementById("row1paperMark").value =   "";
	document.getElementById("row1paper").value =   "";
	document.getElementById("row1papername").value =   "";
	document.getElementById("row2paperMark").value =   "";
	document.getElementById("row2paper").value =   "";
	document.getElementById("row2papername").value =   "";
	document.getElementById("row3paperMark").value =   "";
	document.getElementById("row3paper").value =   "";
	document.getElementById("row3papername").value =   "";
	document.getElementById("row4paperMark").value =   "";
	document.getElementById("row4paper").value =   "";
	document.getElementById("row4papername").value =   "";
	document.getElementById("row5paperMark").value =   "";
	document.getElementById("row5paper").value =   "";
	document.getElementById("row5papername").value =   "";
	document.getElementById("row6paperMark").value =   "";
	document.getElementById("row6paper").value =   "";
	document.getElementById("row6papername").value =   "";
	document.getElementById("row7paperMark").value =   "";
	document.getElementById("row7paper").value =   "";
	document.getElementById("row7papername").value =   "";
	document.getElementById("row8paperMark").value =   "";
	document.getElementById("row8paper").value =   "";
	document.getElementById("row8papername").value =   "";
	document.getElementById("marksentersegment").style.display = "none";
	//$("marksentersegment").hide();
	
}
// update screen
function clearAllAtrbutesMarks1() {
	//	document.getElementById("prCodeMark1").value =   "";
	// document.getElementById("prNoMark1").value =   "";
	document.getElementById("diplomaCodeMark1").value =   "";
	document.getElementById("SemMonthMark1").value =   "";
	document.getElementById("SemYearMark1").value =   "";
	document.getElementById("stuNameMark1").value =   "";
	
	document.getElementById("enterDateMarks1").value =   "";
	document.getElementById("durationMark1").value =   "";
	document.getElementById("noofPaperMark1").value =   "";
	document.getElementById("stateMark1").value =   "";
	document.getElementById("centerMark1").value =   "";
	document.getElementById("row1paperMark1").value =   "";
	document.getElementById("row1paper1").value =   "";
	document.getElementById("row1papername1").value =   "";
	document.getElementById("row2paperMark1").value =   "";
	document.getElementById("row2paper1").value =   "";
	document.getElementById("row2papername1").value =   "";
	document.getElementById("row3paperMark1").value =   "";
	document.getElementById("row3paper1").value =   "";
	document.getElementById("row3papername1").value =   "";
	document.getElementById("row4paperMark1").value =   "";
	document.getElementById("row4paper1").value =   "";
	document.getElementById("row4papername1").value =   "";
	document.getElementById("row5paperMark1").value =   "";
	document.getElementById("row5paper1").value =   "";
	document.getElementById("row5papername1").value =   "";
	document.getElementById("row6paperMark1").value =   "";
	document.getElementById("row6paper1").value =   "";
	document.getElementById("row6papername1").value =   "";
	document.getElementById("row7paperMark1").value =   "";
	document.getElementById("row7paper1").value =   "";
	document.getElementById("row7papername1").value =   "";
	document.getElementById("row8paperMark1").value =   "";
	document.getElementById("row8paper1").value =   "";
	document.getElementById("row8papername1").value =   "";
	document.getElementById("marksentersegment1").style.display = "none";
	//$("marksentersegment").hide();
	
}

function clearaddAdmission() {
	

	document.getElementById('stuName').value="";
	document.getElementById('address1').value="";
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
	document.getElementById('pincode').value="";
	document.getElementById('mobNum').value="";
	document.getElementById('state').value="";
	document.getElementById('phonenum').value="";
	document.getElementById('emailid').value="";
	document.getElementById('dueDate').value="";
	document.getElementById('totfee').value="";
	document.getElementById('papers').value="";
	document.getElementById('feepaiddate').value="";
	document.getElementById('feepaidmode').value="";
	document.getElementById('feeref').value="";
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

			parsedData1 = JSON.parse(data);	
			console.log('------------------------------------------------'+parsedData1.Failure);
			
			if (parsedData1 != null) {
				if(parsedData1['Success'] !== undefined){
					document.getElementById('newadmission').style.display='block';
				}else if(parsedData1['Failure'] !== undefined){
					document.getElementById('newadmissionfail').style.display='block';
				}
			}
		}
}

// DELETE Admission
function deleteAdmission() {
	
	var confirmResult;

	 confirmResult = confirm("Are you sure to delete?");

	
	console.log('updateAdmission clicked rajjj ');
	
	var stuName = document.getElementById('stuName1').value;
	var address1 = document.getElementById('address11').value;
	var diplomaCode = document.getElementById('diplomaCodeUad').value;
	console.log('diplomaCode ------------------------------------------------'+diplomaCode);
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
	
	if(confirmResult){
	
		console.log('updateAdmission delete process ');
		
	
		if(isNaN(semYear) || isNaN(pincode) || isNaN(phonenum) || isNaN(mobNum) || isNaN(papers) || isNaN(totfee) || isNaN(paidamt)){
			alert("Please enter only numbers for PINCODE, PHONE NUMBER, SEM YEAR, MOBILE, NO OF PAPERS, TOTAL FEE AMT, FEE PAID AMOUNT ")
			
		}else if (prCode11 == "" || prNo1 == "" || diplomaCode == "")
		   {
			alert("Please enter the values in Diploma, P.R.Code and P.R.No")
		   }else{
	
	  		postAjax('rs',{"app":"AiimasPost","module":"modifyAdmission","action":"deleteAdm","stuName":stuName,"address1":address1, "diplomaCode":diplomaCode, "duration":duration, "semMonth":semMonth, "semYear":semYear, "enterDate":enterDate, "prCode11":prCode11, "prNo1":prNo1, "paidamt":paidamt, "address2":address2, "address3":address3, "address4":address4, "pincode":pincode, "phonenum":phonenum, "state":state, "mobNum":mobNum, "emailid":emailid, "dueDate":dueDate, "totfee":totfee, "papers":papers,"feepaiddate":feepaiddate,"feepaidmode":feepaidmode,"feeref":feeref}, onPostDeleteAdmission);
	  		console.log(' - - - - - DELETE - - - - ');
		   }
	}

}

function onPostDeleteAdmission(data) {
	console.log(' onPostDeleteAdmission  RESPONSE POST in app .JS:' + data);

		if (data != null) {
			parsedData1 = JSON.parse(data);
			if(parsedData1['Failure'] !== undefined){
				document.getElementById('deleteadmissionFail').style.display='block';
			
			}else if(parsedData1['Success'] !== undefined){
				document.getElementById('deleteadmission').style.display='block';
				clearAllAtrbutes();
			}
			
		}
}



// UPDATE Admission
function updateAdmission() {
	
	console.log('updateAdmission clicked rajjj ');
	
	var stuName = document.getElementById('stuName1').value;
	var address1 = document.getElementById('address11').value;
	var diplomaCode = document.getElementById('diplomaCodeUad').value;
	console.log('diplomaCode ------------------------------------------------'+diplomaCode);
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
			console.log('prCode11 '+prCode11);
			console.log('prNo1 '+prNo1);
			console.log('diplomaCode '+diplomaCode);
			alert("Please enter the values in Diploma, P.R.Code and P.R.No")
		   }else{
	
	  		postAjax('rs',{"app":"AiimasPost","module":"modifyAdmission","action":"updateAdm","stuName":stuName,"address1":address1, "diplomaCode":diplomaCode, "duration":duration, "semMonth":semMonth, "semYear":semYear, "enterDate":enterDate, "prCode11":prCode11, "prNo1":prNo1, "paidamt":paidamt, "address2":address2, "address3":address3, "address4":address4, "pincode":pincode, "phonenum":phonenum, "state":state, "mobNum":mobNum, "emailid":emailid, "dueDate":dueDate, "totfee":totfee, "papers":papers,"feepaiddate":feepaiddate,"feepaidmode":feepaidmode,"feeref":feeref}, onPostUpdateAdmission);

		   }


}


function onPostUpdateAdmission(data) {
	console.log(' onPostUpdateAdmission  RESPONSE POST in app .JS:' + data);

		if (data != null) {
			parsedData1 = JSON.parse(data);
			if(parsedData1['Failure'] !== undefined){
				document.getElementById('update_admissionFail').style.display='block';
				
			}else if(parsedData1['Success'] !== undefined){
				document.getElementById('update_admission').style.display='block';
			}
			
			
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
	console.log(' onPostSearchInstitue  RESPONSE POST in app .JS:' + data);

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
	//console.log(' onPostSearchQuestion1  RESPONSE POST in app .JS:' + data);

		if (data != null) {
			
			parsedData = JSON.parse(data);
			
			var jsonstring =  JSON.stringify(data) ;
			//console.log(' mark Detail get question paper '+ parsedData  );
			//console.log(' mark Detail get question paper '+ parsedData['Failure']    );
			
			var executeFunction = false;
			
			if(jsonstring == "\"{}\"" || jsonstring =="" || jsonstring == "\"null\""){
				console.log('json empty '+jsonstring);
				document.getElementById('getQuestPaperFail').style.display='block';
				clearQuestionPaper();
			}else {
				console.log('caaaaaaaaseeeee 3   '+parsedData);
				$("#getQuestPaper").show();
				
			}
			
			
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
							innerHtmlText = "<a href=\'public/qpapers/"+fileName+"\'  target=\'_blank\'>"+fileName+"</a>";
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



//ApplicantList

function printApplicantList() {
	
	console.log('printApplicantList clicked rajjj ');
	
		var ALsemMonthName = document.getElementById('ALsemMonthName').value;
		var ALsemYearName = document.getElementById('ALsemYearName').value;
		var ALexamCenterCode = document.getElementById('ALexamCenterCode').value;
	
		
	postAjaxReturnBinary('rs',{"app":"AiimasPost","module":"printReport_ApplicantList","action":"applicantList","ALsemMonthName":ALsemMonthName,"ALsemYearName":ALsemYearName,"ALexamCenterCode":ALexamCenterCode}, onPostprintApplicantList);

}
function onPostprintApplicantList(data) {

	console.log('pdf length :' + data.length);
	
	var file = new Blob([data], {type: 'application/pdf'});
    var fileURL = URL.createObjectURL(file);
    window.open(fileURL);
}


//QuestionPaperList

function printQuestionPaperList() {
	
	console.log('printQuestionPaperList clicked rajjj ');
	
		var QAsemMonthName = document.getElementById('QAsemMonthName').value;
		var QAsemYearName = document.getElementById('QAsemYearName').value;
		var QAexamCenterCode = document.getElementById('QAexamCenterCode').value;
	
		
	
	postAjaxReturnBinary('rs',{"app":"AiimasPost","module":"printReport_QuestionPaper","action":"QPaperList","QAsemMonthName":QAsemMonthName,"QAsemYearName":QAsemYearName,"QAexamCenterCode":QAexamCenterCode}, onPostQuestionPaperList);

}
function onPostQuestionPaperList(data) {

	console.log('pdf length :' + data.length);
	
	var file = new Blob([data], {type: 'application/pdf'});
    var fileURL = URL.createObjectURL(file);
    window.open(fileURL);
}



//ATTENDANCE CHART

function getAttendChart() {
	
	console.log('getAttendChart clicked rajjj ');
	
		var ACsemMonthName = document.getElementById('ACsemMonthName').value;
		var ACsemYearName = document.getElementById('ACsemYearName').value;
		var ACduration = document.getElementById('ACduration').value;
		var ACdiplomaCode = document.getElementById('ACdiplomaCode').value;
		var ACexamCenterCode = document.getElementById('ACexamCenterCode').value;
		
	
	postAjaxReturnBinary('rs',{"app":"AiimasPost","module":"printReport_AttendChart","action":"AttendChart","ACsemMonthName":ACsemMonthName,"ACsemYearName":ACsemYearName,"ACduration":ACduration,"ACdiplomaCode":ACdiplomaCode,"ACexamCenterCode":ACexamCenterCode,}, onPostAttendChart);

}
function onPostAttendChart(data) {

	console.log('pdf length :' + data.length);
	
	var file = new Blob([data], {type: 'application/pdf'});
    var fileURL = URL.createObjectURL(file);
    window.open(fileURL);
}

//PRINT  - Admmission Initimation

function printAdmInit(reportType) {
	
	console.log('printAdmInit clicked rajjj '+reportType);
	
		var adprCode = document.getElementById('adprCode').value;
		var adpprNo = document.getElementById('adpprNo').value;
		
	
	postAjaxReturnBinary('rs',{"app":"AiimasPost","module":"printReport","action":reportType,"adprCode":adprCode,"adpprNo":adpprNo,}, onPostSearchAdmIniti);

}
function onPostSearchAdmIniti(data) {

	console.log('pdf length :' + data.length);
	
	var file = new Blob([data], {type: 'application/pdf'});
    var fileURL = URL.createObjectURL(file);
    window.open(fileURL);
//    
//	// If you want to use the image in your DOM:
//	  var blob = new Blob([data], {type: "application/pdf"});
//	const url = window.URL.createObjectURL(blob);
//    const a = document.createElement('a');
//    a.style.display = 'none';
//    a.href = url;
//    // the filename you want
//    a.download = 'qpaper.pdf';
//    document.body.appendChild(a);
//    a.click();
//    window.URL.revokeObjectURL(url);
    /*
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
	*/
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
function postAjaxReturnBinary(url, data, callback) {
    var params = typeof data == 'string' ? data : Object.keys(data).map(
            function(k){ return encodeURIComponent(k) + '=' + encodeURIComponent(data[k]) }
        ).join('&');

    var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("Microsoft.XMLHTTP");    
    xhr.responseType = 'arraybuffer';

    xhr.open('POST', url);
    xhr.onreadystatechange = function() {
        if (xhr.readyState>3 && xhr.status==200) { callback(xhr.response); }
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

function populateState(){
	
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