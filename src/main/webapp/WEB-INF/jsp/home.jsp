<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/home.css">
</head>
<body>

<ul>
  <li><h3>PetShop</h3></li>
  <li style="float:right"><a class="active" href="/login"><h3>log out</h3></a></li>
  <li><a class="active" href="/home?user=${userdetails.user}"><h3>Home</h3></a></li>
  <li><a class="active" href="/add?user=${userdetails.user}"><h3>Add Pet</h3></a></li>
  <li><a class="active" href="/mypets?user=${userdetails.user}"><h3>My Pets</h3></a></li>
</ul>
<h1>Welcome ${userdetails.user}</h1>
<table class="table" border=2 align="center">
<tr>
<th>Pet id</th>
<th>pet Name</th>
<th>pet age</th>
<th>pet place</th>
<th>Buy</th>
</tr>
<c:forEach items="${petsList}" var="pet">
<tr>
<td>${pet.pet_id}</td>
<td>${pet.pet_name}</td>
<td>${pet.pet_age}</td>
<td>${pet.pet_place}</td>
<td>
<c:choose>
	<c:when test="${empty pet.owner}">
	<a href="/buy?user=${userdetails.user}&pets_id=${pet.pet_id}">Buy</a>
	</c:when>
	<c:otherwise>
	sold
	</c:otherwise>
</c:choose>

<%-- <a href="/buy?user=${userdetails.user}&pets_id=${pet.pet_id}">Buy</a> --%>
</td>
</tr>
</c:forEach>
</table>

</body>
</html>