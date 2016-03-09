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

<!-- ------------------------- -->



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


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>




<!-- ------------------- -->
<link rel="stylesheet" href="<c:url value="/resources/addcar_1.css" />" type="text/css">
<script src="/resources/addcar_2.js"></script>

<!-- ------------------------- -->
<body>
<h1>
Welcome ${users.username}!
</h1>
<a href="/controller/logout">log out</a>
<a href="/controller/admin/">Go back to search</a>


<div class="container">
<div class="col-md-5">
    <div class="form-area">  
<form:form action="/controller/admin/add" modelAttribute="carAddInfo" enctype="multipart/form-data" role="form">

         <table>
              <tr>
                  <td>
                  <div class="form-group">
                    pick up date:
                     <p><form:input path="begindate"  placeholder="mm/dd/yyyy" id="datepicker" class="form-control"/></p>
                    <form:errors path="begindate"></form:errors>
                  </div>
                  </td>
                </tr>
                
                <tr>
                  <td>
                   <div class="form-group">
                    drop off date:
                     <p><form:input path="enddate"  placeholder="mm/dd/yyyy" id="datepicker_1" class="form-control"/></p>
                    <form:errors path="enddate"></form:errors>
                  </div>
                  </td>
                </tr>
                
                <tr>
                  <td>
                   <div class="form-group">
                    brand:
                    <form:input path="brand"  class="form-control"/>
                    <form:errors path="brand"></form:errors>
                  </div>
                  </td>
                </tr>
                
                 <tr>
                  <td>
                   <div class="form-group">
                    price:
                    <form:input path="price"  class="form-control" />
                    <form:errors path="price"></form:errors>
                  </div>
                  </td>
                </tr>
                
                
                <tr>
                  <td>
                   <div class="form-group">
                    location:
                    <form:input path="location" class="form-control" />
                    <form:errors path="location"></form:errors>
                  </div>
                  </td>
                </tr>
                
                
                <tr>
                  <td>
                   <div class="form-group">
                    street:
                    <form:input path="street"  class="form-control"/>
                    </div>
                  </td>
                </tr>
                
                
                
                <tr>
                  <td>
                   <div class="form-group">
                    zipcode:
                    <form:input path="zipcode" class="form-control" />
                    <form:errors path="zipcode"></form:errors>
                  </div>
                  </td>
                </tr>
                
                 <tr>
                  <td>
                   <div class="form-group">
                    details:
                    <form:textarea rows="4" cols="30" path="details"  /> 
                 </div>
                  </td>
                </tr>
                
                
              <!--<tr>
                  <td>
                    total:
                    <form:input path="total"  />
                    <form:errors path="total"></form:errors>
                  </td>
                </tr>
         
         
                  <tr>
                  <td>
                    useTime:
                    <form:input path="useTime"  />
                    <form:errors path="useTime"></form:errors>
                  </td>
                </tr>
                  -->
                
                
         
         
         </table>
          <!-- remove in case of emergency -->
         photo:<form:input path="photo" type="file"/>
               
         
         <input type="submit" value="submit" class="btn btn-primary pull-right"/>
              

</form:form>
    </div>
</div>
</div>

<script>




</script>

</body>
</html>