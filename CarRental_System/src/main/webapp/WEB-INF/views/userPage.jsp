<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>



<!-- ----------------- -->
<head>
  <meta charset="utf-8">
  
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
</head>


<head>
  <meta charset="utf-8">
  
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker_1" ).datepicker();
  });
  </script>
</head>
<!---------------->

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>



<link rel="stylesheet" href="<c:url value="/resources/admin_1.css" />" type="text/css">
<script src="/resources/admin_2.js"></script>
<!-- ------ -->
<body>
<h1>
Welcome ${users.username}!
</h1>
                   <a href="/controller/user/profile/${users.client.id}">${users.username}</a>
                  
                   <a href="/controller/logout">log out</a>
                 
                 <a href="/controller/user/Viewshopcart">Shopping Cart</a>
                 
                 
      
       <div class="container">
<div class="col-md-5">
    <div class="form-area">                
                 
<form:form action="/controller/user/searchCar" modelAttribute="searchInfo" role="form">
            <table>
             <tr>
                  <td>
                   <div class="form-group">
                    pick up date:
                   <p> <form:input path="begindate"  placeholder="mm/dd/yyyy" id="datepicker"/></p>
                    <form:errors path="begindate"></form:errors>
                  </div>
                  </td>
                </tr>
                
                
                <tr>
                  <td>
                   <div class="form-group">
                    drop off date:
                   <p>   <form:input path="enddate"  placeholder="mm/dd/yyyy" id="datepicker_1"/></p>
                    <form:errors path="enddate"></form:errors>
                  </div>
                  </td>
                </tr>
                
                
                <tr>
                  <td>
                   <div class="form-group">
                   <form:input path="ZipCode" placeholder="Zip Code"/>
                   <form:errors path="ZipCode"></form:errors>
                  </div>
                  </td>
                </tr>
              
              <input type="submit" value="submit" class="btn btn-primary pull-right"/>
             
            </table>
</form:form>
     </div>
</div>
</div>
 
        
       <c:if test="${!empty information }">
           ${information }
       </c:if> 
       
       <c:if test="${!empty cars }">
         <table>
              <tr>
			     
			      <th> price: </th>
			      <th> pick-up date: </th>
			      <th> drop-off date: </th>
			      <th> brand: </th>
			      <th> type: </th>
			      <th> location: </th>
			     
			   </tr>
			   
           
              <c:forEach items="${cars}" var="car">
                 <tr> 
                    <td>${car.price}</td>
                    <td>${car.begindate }</td>
                    <td>${car.enddate }</td>
                    <td>${car.brand }</td>
                    <td>${car.type }</td>
                    <td>${car.location }</td>
                    <td>
                    <a href="/controller/user/process/${car.id}">Process</a>
                    </td>
                 </tr>
                 
              
              </c:forEach>
          
         </table>
       </c:if>
        
    
      
      
 
        

</body>
</html>