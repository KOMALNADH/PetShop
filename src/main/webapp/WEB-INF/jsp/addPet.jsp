<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/addpet.css">
</head>
<body>
<ul>
  <li><h3>PetShop</h3></li>
  <li style="float:right"><a class="active" href="/login"><h3>log out</h3></a></li>
  <li><a class="active" href="/home?user=${userdetails}"><h3>Home</h3></a></li>
  <li><a class="active" href="/add?user=${userdetails}"><h3>Add Pet</h3></a></li>
  <li><a class="active" href="/mypets?user=${userdetails}"><h3>My Pets</h3></a></li>
</ul>
<h1>Welcome ${userdetails}</h1>
<div class="header">
<h1>Adding a Pet</h1>
<form:form action="/savepet?user=${userdetails}" method="post" modelAttribute="addpet" class="js-add">
	Pet Name:-
	<form:input type="text" path="Pet_name" id="name"/>
	<h5 style="color : red;"><form:errors path="pet_name" /></h5>
	Age:-
	<form:input type="text" path="Pet_age" id="age"/>
	<h5 style="color : red;"><form:errors path="pet_age" /></h5>
	Place:-
	<form:input type="text" path="Pet_place" id="place" />
	<h5 style="color : red;"><form:errors path="pet_place" /></h5>
	
	<form:button >Submit</form:button>
</form:form>
</div>
<script>

</script>
</body>
</html>