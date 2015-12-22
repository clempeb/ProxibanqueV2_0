<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--BOOTSRAP-->
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>ProxibanqueV2</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<center>

				<form class="form-signin" action="servcons" method="post">
					<h2 class="form-signin-heading">Authentification</h2>
					<p><% if (request.getAttribute("echec") != null) {
					out.println(request.getAttribute("echec"));}%></p>
					<br> 
					<label for="login">Login</label>
					<input type="login" name="loginCons" id="loginuser" class="form-control" placeholder="Login" required autofocus>
					
					<label for="password" class="">Password</label>
					<input type="password" name="pwdCons" id="password" class="form-control" placeholder="Password" required>
					
					<input type="hidden" name="switch" value="verifCons">
					<br>
					<button class="btn btn-lg btn-primary" type="submit">Valider</button>
				</form>
			</center>
		</div>
	</div>
</body>
</html>