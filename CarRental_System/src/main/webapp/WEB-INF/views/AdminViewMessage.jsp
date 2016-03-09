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




<!-- ------------------------- -->
<link rel="stylesheet" href="<c:url value="/resources/AVM.css" />" type="text/css">
<script src="/resources/AVM.js"></script>

<body>

<h1>
Welcome ${users.username}!
</h1>

<a href="/controller/admin/">Go back to search</a>
<a href="/controller/logout">log out</a>


<h2>
Message:
</h2>

<div class="container">
<div class="col-md-5">
    <div class="form-area">


<table>

 <c:forEach items="${messages}" var="message">
 <tr>
 <td>from:${message.sender}</td><tr>
    <td>message:${message.message}</td>
    <td>
      <form action="/controller/admin/reply/${message.id}" role="form">
         
          <br style="clear:both">
         
         
         <div class="form-group">
        <textarea rows="4" cols="30"  name="message">
         </textarea>
         </div>
   
        <input type="hidden" name="sender" value="${users.username}"/>
        
        <input type="hidden" name="receiver" value="${message.sender}"/>
        
        <input type="hidden" name="status" value="pending"/>
   
        <input type="submit" name="submit" class="btn btn-primary pull-right"/>
      
      </form>
    </td>
 </tr>
</c:forEach>


</table>

</div>
</div>
</div>









<script>



</script>
</body>
</html>