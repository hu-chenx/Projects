<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@page import="java.util.*"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>





<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>







<body>



   <form:form  action="insert" modelAttribute="client" class="col-md-12 well">
      
   <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
   
    <table>
     
        <tr>
          <td>firstname:
          <form:input path="firstname" class="form-control"/>
          <form:errors path="firstname"></form:errors>
          </td>
       </tr>
       
       
       
	   <tr>
	      <td>lastname:
	      <form:input path="lastname" class="form-control"/>
	      <form:errors path="lastname"></form:errors>
	      </td>
	   </tr>
       
       
       <tr>
          <td>email:
          <form:input path="email" placeholder="xxxx@gmail.com" class="form-control"/>
          <form:errors path="email"></form:errors>
          </td>
       </tr>
       
       
	 
       <tr>
          <td>license:
          <form:input path="license" class="form-control"/></td>
       </tr>      
	 
	 
  
       <tr>
          <td>age:
          <form:input path="age" class="form-control"/>
        
          </td>
       </tr>
       
   
  
       <tr>
          <td><input type="submit" value="submit" class="btn btn-primary pull-right"></td>
       </tr>    
       
       
       
  </table>
   
      </div>
                        </div>
                    </div>
    
   </form:form>
 

</body>
</html>