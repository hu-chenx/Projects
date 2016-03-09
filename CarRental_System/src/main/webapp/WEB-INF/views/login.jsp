<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html><head><title>Login Page</title></head>

<!-- css -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>


<!--  -->


<body onload='document.f.username.focus();'>
<h3>Login with Username and Password</h3>




<!-- css -->

<!-- ---------------- -->
<div class="container">
	<div class="row">
    	<div class="container" id="formContainer">

<!-- ---------------- -->








<form name='f' action='/controller/logincheck' method='POST' class="form-signin" id="login" role="form">


<!-- ------ -->

<a href="#" id="flipToRecover" class="flipLink">
              <div id="triangle-topright"></div>
            </a>
<!-- -------- -->
 <table>
   ${error }
    <tr>  <td>User:</td>
          <td><input type='text' name='username' value=''  class="form-control" name="loginEmail" id="loginEmail" required autofocus></td></tr>
    
    
    
    <tr>   <td>Password:</td>
           <td><input type='password' name='password'       class="form-control" name="loginPass" id="loginPass" required/></td></tr>
    
    
    
    <tr>    <td colspan='2'><input name="submit" type="submit" value="Login" class="btn btn-lg btn-primary btn-block"/></td></tr>
 
     <tr> <td> <a href="authenticate/register">register</a></td></tr>
 
  </table>
</form>


<!-- ---------------------- -->
        </div> 
	</div>
</div>






</body></html>




