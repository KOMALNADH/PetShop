<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>registration</title>
    <link rel="stylesheet" href="/resources/css/registration.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>
<ul>
  <li><h3>PetShop</h3></li>
  <li style="float:right"><a class="active" href="/login"><h3>log in</h3></a></li>
</ul>
</br></br>
<div class="container-xxl">
<div class="header">
	<h2>Registration page</h2>
	<form:form action="/registration" method="post" modelAttribute="userform">
	  UserName:-
	<form:input type="text" path="user" />
	<h5 style="color : red;"><form:errors path="user" /></h5>
	Password:-
	<form:input type="text" path="password" />
	<h5 style="color : red;"><form:errors path="password" /></h5>
	Confirm Password:-
	<form:input type="text" path="confirmPassword" />
	<h5 style="color : red;"><form:errors path="confirmPassword" /></h5>
	<input type="submit" value="submit" />
	<a href="/registration"><input type="button" value="reset" /></a>
	</form:form>
	
	</div>
	</div>
</body>
</html>