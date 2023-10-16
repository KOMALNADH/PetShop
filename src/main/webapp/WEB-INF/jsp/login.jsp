<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/style1.css">
</head>
<body>
<nav class="nav">
<h3>pet Shop</h3>

</nav>
</br></br>
<div class="header">
<h2 >Log in</h2>
<h3 style="color : green;" >${registered}</h3>

<form:form action="/login1" method="post" modelAttribute="loginform">
	UserName:-
	<form:input  type="text" path="user" /></br>
	<h5 style="color : red;"><form:errors path="user" /></h5>
	Password:-
	<form:input type="text" path="password" /></br>
	<h5 style="color : red;"><form:errors path="password" /></h5>
	<input type="submit" value="login" /></br>
	<h4 style="color : red;" > ${login} </h4>
	</form:form>
	<a href="/registration">create an account</a>
	</br>
	</div>


</body>
</html>