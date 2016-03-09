<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<title>Home</title>
</head>
<!-- ----------------------------- -->


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

<!-- ----------------------------- -->

<!-- ------------- -->

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>




<!-- ------------------- -->
<style>

body{
  background-color: #ddd;
 
}
.centered-form{
	margin-top: 60px;
}

.centered-form .panel{
	background: rgba(255, 255, 255, 0.8);
	box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
}

</style>
<!-- ------------------------------- -->

<body>


<h1>

</h1>


                
                   <a href="authenticate/register">register</a><br>
                   <a href="log_in">login</a><br>
                   <a href="user/Viewshopcart">Shopping Cart</a>
              
                 
     
     
     <div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title">	CarRental:  </h3>
			 			</div>
			 			<div class="panel-body">
     

<form:form action="/controller/search" modelAttribute="searchInfo" role="form">
            
            
               <div class="row">
			    <div class="col-xs-6 col-sm-6 col-md-6">
			     <div class="form-group">
                
                  
                    pick up date:
                     <form:input path="begindate" placeholder="mm/dd/yyyy" id="datepicker" class="form-control input-sm"/>
                    <form:errors path="begindate"></form:errors>
                 
                 
                 	</div>
                 </div>
			    <div class="col-xs-6 col-sm-6 col-md-6">
			     <div class="form-group">
                  
                    drop off date:
                     <form:input path="enddate"  placeholder="mm/dd/yyyy" id="datepicker_1" class="form-control input-sm"/>
                    <form:errors path="enddate"></form:errors>
           
                 </div>
			    </div>
			  </div>
                 
           
                	<div class="form-group">
                   <form:input path="ZipCode" placeholder="Zip Code"/>
                   <form:errors path="ZipCode"></form:errors>
                  </div>
                 
                
              
              <input type="submit" value="submit" class="form-control input-sm"/>
              
          
</form:form>
        
        	    	</div>
	    		</div>
    		</div>
    	</div>
    </div>
            
        
       <c:if test="${!empty info }">
           ${info }
       </c:if> 
        
    
       <c:if test="${!empty cars}">
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
                    <td><a href="info/${car.id}">Continue</a>
                    </td>
                  </tr>
                  
               </c:forEach>
           </table>
       </c:if>
       
       
        <!-- ---------- -->
        
        <script>


        </script>
        
        <!-- ---------- -->
       
       
</body>
</html>
