<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



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
<!------ Include the above in your HEAD tag ---------->

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first"> Welcome Aiimas
      <!-- <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="User Icon" />  -->
    </div>

    <!-- Login Form   <form> -->
  
      <input type="text" id="userid" class="fadeIn second" name="userid" placeholder="user id">
      <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
      <input type="submit" class="fadeIn fourth" value="Login" id="login">
    

    <!-- Remind Passowrd </form>
    <div id="formFooter">
      <a class="underlineHover" href="#">Forgot Password?</a>
    </div>
	-->
  </div>
</div>