<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <title>Welcome to Rissala!</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Welcome to Rissala!</h1>
        <a href="ajout.jsp" class="btn btn-primary">Add Newsletter</a>
        <div class="row mt-4">
            <c:if test="${not empty requestScope.newsletters}">
                <c:forEach var="news" items="${requestScope.newsletters}">
                    <div class="col-md-4 mb-3">
                      <div class="card">
                      <img src="${news.image}" class="card-img-top" alt="Newsletter Image">
                         <div class="card-body">
                           <h5 class="card-title">${news.titre}</h5>
                             <p class="card-text">${news.categorie}</p>
                              <p class="card-text">${news.contenu}</p>
                              <p class="card-text">${news.data_envoi}</p>
                              
                         <form action="" method="post">
                           <button class="btn btn-danger" name="deleter" type="submit" value="${news.id}">Delete</button>
                          <input type="hidden" name="newsid" value="${news.id}">
                     </form>
                          <form id="editForm_${news.id}" action="Controller" method="post">
    						<input type="hidden" name="editr" value="true">
    						<input type="hidden" name="id" value="${news.id}">
    						<a class="btn btn-primary" href="#" onclick="document.getElementById('editForm_${news.id}').submit();">Editer</a>
					</form>
             </div>
     </div>
       </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
    <!-- Bootstrap JS (optional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
