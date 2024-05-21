<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Newsletter</title>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <h2 class="mt-5">Add Newsletter</h2>
    <form action="Controller" method="post" class="mt-3">
        <div class="form-group">
            <label for="titre">Title:</label>
            <input type="text" id="titre" name="titre" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="categorie">Category:</label>
            <input type="text" id="categorie" name="categorie" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="contenu">Content:</label>
            <textarea id="contenu" name="contenu" rows="10" cols="50" class="form-control" required></textarea>
        </div>
        <div class="form-group">
            <label for="image">Image URL (optional):</label>
            <input type="text" id="image" name="image" class="form-control">
        </div>
  <input type="submit" value="Add Newsletter" name="ajoutn">
    </form>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

