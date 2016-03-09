<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>




<link rel="stylesheet" href="<c:url value="/resources/lc.css" />" type="text/css">
<script src="/resources/lc.js"></script>

<!-- ------------------- -->


<body>
<h1>
Welcome ${users.username}!
</h1>

<a href="/controller/admin/">Go back to search</a>
<a href="/controller/admin/AddCar">AddCar</a>
<a href="/controller/logout">log out</a>
 

                 
       <c:if test="${!empty information }">
           ${information }
       </c:if> 
       
       <c:if test="${!empty cars }">
       
        <h1>   
     Car Details
     </h1>
       
       
       <div class="row">
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">Tasks</h3>
					<div class="pull-right">
						<span class="clickable filter" data-toggle="tooltip" title="Toggle table filter" data-container="body">
							<i class="glyphicon glyphicon-filter"></i>
						</span>
					</div>
				</div>
       
         <table class="table table-hover" id="task-table">
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
                    <a href="/controller/admin/edit/${car.id}">Edit</a>
                    </td>
                    
                    <td>
                    <a href="/controller/admin/delete/${car.id}">delete</a>
                    </td>
                    
                    <td>
                    <a href="/controller/admin/process/${car.id}">View</a>
                    </td>
                 </tr>
                 
              
              </c:forEach>
          
         </table>
         	</div>
		</div>
	</div>
       </c:if>
       
       
       <script>

       </script>

</body>
</html>