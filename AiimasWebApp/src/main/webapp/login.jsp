<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 20%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>



<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<link  href="login.css" rel="stylesheet">
<script>
    $(document).ready(function(){
       $('#login').click(function()
       {   
    	   //alert("in")
          var user=$('#userid').val();
          var pwd=$('#password').val();
          $.ajax({
               type: "POST",
               url:"rs",
               data:{"user":user,"password":pwd,"action":"login"},
               success: function (data) {
                  if(data=='success'){
                    $(location).attr('href','mainpage.jsp');
                  }else{
                      alert('Invalid username and password, please contact administrator!');
                  }
               }
             });                                
           });
         });
   </script>
   
   <script>
function myFunction() {
  var x = document.getElementById("password");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>
   </head>
<!------ Include the above in your HEAD tag ---------->
<body>
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
   
    </div>
    
    
      <div class="imgcontainer">
      	<H4>AIIMAS LOGIN</H4>
		   	 <img src="img/img_avatar2.png" alt="AIIMAS" class="avatar"> 
		   	 
		</div>

    <!-- Login Form   <form> -->
    
     <div class="container">
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" id="userid" name="userid" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" id="password" name="password" required>
        
    <button type="submit" value="Login" id="login" >Login</button>
    <label>
    <input type="checkbox" onclick="myFunction()">Show Password
<!--       <input type="checkbox" checked="checked" name="remember"> Remember me -->
    </label>
  </div>
    
    
    
    
  
  </div>
</div>
</body>
</html>