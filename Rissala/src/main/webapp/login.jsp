<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <h1 class="mt-5">Login</h1>
    <form action="Controller" method="get" class="mt-3">
        <div class="form-group">
            <label for="log">Login</label>
            <input type="text" class="form-control" id="log" name="user">
        </div>
        <div class="form-group">
            <label for="pwd">Password</label>
            <input type="password" class="form-control" id="pwd" name="pwd">
        </div>
        <button type="submit" value ="login" class="btn btn-primary" name="myBtn">Login</button>
    </form>
    <p class="mt-3">If you don't have an account, click <a href="sign.jsp">here</a></p>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>