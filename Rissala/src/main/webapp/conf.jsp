<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <meta charset="UTF-8">
    <title>Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }
        .confirmation-message {
            margin-top: 50px;
            font-size: 20px;
            color: green;
        }
    </style>
</head>
<body>

<div class="confirmation-message">
    Welcome to Rissala!
</div>


	<c:if test="${not empty requestScope.createur}">
        <h2><c:out value="${requestScope.createur.id}"/></h2>
    </c:if>
		
	<c:if test="${empty requestScope.createur}">
		<li><c:out value="hello"/></li>
	</c:if> 











	<p>  now you have  an account click here to  <a href="login.jsp">login  </a></p>








</body>











</html>
