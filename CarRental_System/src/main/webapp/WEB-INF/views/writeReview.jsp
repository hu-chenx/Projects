<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@page import="java.util.*" %>
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



<link rel="stylesheet" href="<c:url value="/resources/AVM.css" />" type="text/css">
<script src="/resources/AVM.js"></script>
<!-- ------------------------- -->

<body>

<a href="/controller/user/profile/${users.client.id}">${users.username}</a>
                   <a href="/controller/user/Viewshopcart">Shopping Cart</a>
                   <a href="/controller/logout">log out</a>
                   <a href="/controller/user/">Go back to search</a>
 <h1>   
     Reservation Details
     </h1>
      <table>
     <tr> 
      <td>
        Car Details:
      </td>
    </tr>
    
    <tr>
      <td>
        ${car.details}
      </td>
    </tr>
    
     <tr>
      <td>
        pick up time:
      </td>
    </tr>
    
     <tr>
      <td>
        ${car.begindate}:
      </td>
    </tr>
    
    <tr>
      <td>
        pick up location:
      </td>
    </tr>
    
    <tr>
      <td>
       ${car.location}
      <td>
    </tr>
    
    <tr>
      <td>
        ${car.street }
      </td>
    </tr>
    
     <tr>
      <td>
        ${car.zipcode }
      </td>
    </tr>
    
     <tr>
      <td>
        drop off:
      </td>
    </tr>
    
     <tr>
      <td>
        ${car.enddate }
      </td>
    </tr>
  </table>
  
   <h1>
      Rental Charges
     </h1>
     
     <table>
     <tr>
        <td>
        range:
          ${car.useTime}
          days
        </td>
      <tr>
      
      <tr>
        <td>
         rate:
         ${car.price}
         /day
        </td>
      </tr>
      
      <tr>
       <td>
         Total Price:
         ${car.total }
         USD
       </td>
      </tr>
     </table>
     
     <h1>
        Write Review:
     </h1>
     
     
     <div class="container">
<div class="col-md-5">
    <div class="form-area"> 
     
     
     <form:form action="/controller/user/write/${car.id }" modelAttribute="review">
      <br style="clear:both">
     
         <table>
         
         
         <%
            Map<String,String> rating = new HashMap();
            
         rating.put("1", "1");
         rating.put("2","2");
         rating.put("3","3");
         rating.put("4","4");
         rating.put("5","5");
            
            request.setAttribute("rating",rating );
       
       %>
         
         <tr>
          <td>rating:
           <div class="form-group">
          <form:select path="rating" items="${rating}"  class="form-control"/>
          <form:errors path="rating"></form:errors>
         </div>
         </td>
       </tr>  
         
           <tr>
            <td>
            <div class="form-group">
              Comment:
          <form:textarea rows="4" cols="50" path="comment"  class="form-control"/>
          <form:errors path="comment"></form:errors>
           </div>
            </td>
           </tr>
           
            <tr>
         <td>
          <form:input type="hidden" path="username" value="${users.username}"/>
         </td>
       </tr>
           
           
      <tr>
       <td>
         <input type="submit" value="submit"  class="btn btn-primary pull-right"/>
       </td>
      </tr>
    
         
         </table>
     </form:form>

    </div>
</div>
</div>




</body>
</html>