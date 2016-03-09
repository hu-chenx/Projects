<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<a href="/controller/user/profile/${users.client.id}">${users.username}</a>
<a href="/controller/logout">log out</a>
<a href="/controller/user/">Go back to search</a>
<a href="/controller/user/ViewHistory">Order History</a>


       <c:if test="${!empty info }">
           ${info }
       </c:if> 
       
       
       
       <c:if test="${!empty checkout}">
           ${checkout}
       </c:if>
       
       
        <c:if test="${!empty shopcart}">
          <h1>
       Orders:
       </h1>
         <a href="/controller/user/checkout">checkout</a>
         
          
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
         
         <table  class="table table-hover" id="task-table">
         <tr>
           <th>total price: </th>
		   <th> pick-up date: </th>
		   <th> drop-off date: </th>
		   <th> brand: </th>
			<th> type: </th>
			<th> location: </th>
			<th>order status:</th>
			 
           </tr>
           <c:forEach items="${shopcart}" var="shopcart">
             <tr>
                <td>${shopcart.total }</td>
                <td>${shopcart.begindate }</td>
                <td>${shopcart.enddate }</td>
                <td>${shopcart.brand }</td>
                <td>${shopcart.type }</td>
                <td>${shopcart.location }</td>
                <td>${shopcart.status }</td>
                <td><a href="/controller/user/cancelOrder/${shopcart.id }">Cancel Order</a></td>
             </tr>
           </c:forEach>
         </table>  
         
          	</div>
		</div>
	</div>     
        </c:if>






</body>
</html>