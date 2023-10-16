<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/mypets.css">
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

<table border=2 align="center">
<tr>
<th>Pet id</th>
<th>pet Name</th>
<th>pet age</th>
<th>pet place</th>

</tr>
<c:forEach items="${mypets}" var="pet">
<tr>
<td>${pet.pet_id}</td>
<td>${pet.pet_name}</td>
<td>${pet.pet_age}</td>
<td>${pet.pet_place}</td>

</tr>
</c:forEach>
</table>
</body>
</html>