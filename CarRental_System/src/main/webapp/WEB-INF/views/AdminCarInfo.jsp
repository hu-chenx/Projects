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
<body>
<h1>
Welcome ${users.username}!
</h1>

<a href="/controller/admin/">Go back to search</a>
<a href="/controller/logout">log out</a>
 <table>
     <h1>   
     Reservation Details
     </h1>
  <!-- height="100" width="100" -->
  <tr>
  <td>
    <img src="/controller/admin/${car.id}/photo" height="400" width="600"  />
  </td>
  </tr>
  
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
  
  <table>
     <h1>
      Rental Charges
     </h1>
   
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
  
  
  <a href="/controller/admin/edit/${car.id}">Edit</a>
  
  
  <h1>
         Reviews:
     </h1>
  
            <c:if test="${!empty reviews}">
            
                   <table>
                       <tr>
                         <th>rating:</th>
                         <th>comment:</th>
                         <th>user name:</th>
                       </tr>
              
                    <c:forEach items="${reviews}" var="review">
                       <tr>
                        <td>${review.rating}</td>
                        <td>${review.comment}</td>
                        <td>${review.username}</td>
                      </tr>
                    </c:forEach>
              
              
                   </table>
            
           </c:if>

</body>
</html>