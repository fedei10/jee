<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <title>Modify Newsletter</title>
</head>
<body>
    <h1>Modify Newsletter</h1>
    
    <%-- Retrieve and print the ID value --%>
    <% String id = request.getParameter("id"); %>
    <c:if test="${not empty id}">
        <p>ID: <%= id %></p>
        
        <form action="Controller" method="post">
            <input type="hidden" name="id" value="${id}">
            <label for="titre">Titre:</label>
            <input type="text" id="titre" name="titre" ><br>
            <label for="categorie">Categorie:</label>
            <input type="text" id="categorie" name="categorie" ><br>
            <label for="contenu">Contenu:</label>
            <textarea id="contenu" name="contenu"></textarea><br>
            <label for="image">Image:</label>
            <input type="text" id="image" name="image" ><br>
            <input type="submit" value="Save" name="ajouti">
        </form>
    </c:if>
    
    <h2> moez</h2>
</body>
</html>
