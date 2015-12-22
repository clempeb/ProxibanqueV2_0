<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="fr.gtm.proxibanque.domaine.Conseiller" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--BOOTSRAP-->
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Création Client</title>
</head>
<body>
		<!--NavBAR-->
<%
		Conseiller cons = (Conseiller) session.getAttribute("user");
	%>

	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Bonjour Mr.
				<%=cons.getNom()%></a>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="menuClient.jsp">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><span
						class="glyphicon glyphicon-user"></span> Menu Client <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="readClient.jsp"> <span
								class="glyphicon glyphicon-search"></span> Consulter Client
						</a></li>
						<li><a href="creerClient.jsp"><span
								class="glyphicon glyphicon-plus"></span> Créer Client</a></li>
						<li><a href="modifClient.jsp"><span
								class="glyphicon glyphicon-pencil"></span> Modifier Client</a></li>
						<li><a href="deleteClient.jsp"><span
								class="glyphicon glyphicon-remove"></span> Supprimer Client</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><span
						class="glyphicon glyphicon-euro"></span> Menu Compte <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="consulterCompte.jsp"> <span class="glyphicon glyphicon-search"></span>
								Consulter Compte
						</a></li>
						<li><a href="creerCompte.jsp"><span class="glyphicon glyphicon-plus"></span>
								Créer Compte</a></li>
						<li><a href="virement.jsp"><span class="glyphicon glyphicon-pencil"></span>
								Virement</a></li>
						<li><a href="deleteCompte.jsp"><span class="glyphicon glyphicon-remove"></span>
								Supprimer Compte</a></ul></li></ul>
		
			
	
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Aide</a></li>
				<li><a href="accueil.jsp"><span
						class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
						Déconnexion</a></li>
			</ul>

		</div>
	</div>
	</nav>
	<%
	 session.getAttribute("user");
	%>



<div class="container"><center>

      <form class="form-signin" action="servclient" method="post">
        <h2 class="form-signin-heading"><span class="glyphicon glyphicon-plus"></span>      Nouveau Client      </h2>
        <label for="inputName">Nom</label>
        <input type="name" id="inputName" class="form-control" placeholder="Nom" required autofocus name="nomCl">
		
		<label for="inputFirstName" class="">Prénom</label>
        <input type="name" id="inputFirstName" class="form-control" placeholder="Prenom" required autofocus name="prenomCl">
        
        <label for="inputEmail" class="">Email</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email" required autofocus name="emailCl">
		
		<label for="inputAddress" class="">Adresse</label>
        <input type="address" id="inputAddress" class="form-control" placeholder="Adresse" required name="adresseCl">
        
        <label for="inputPostalCode" class="">Code Postal</label>
        <input type="text" id="inputPostalCode" class="form-control" placeholder="Code Postal" required name="codePostalCl">
        
        <label for="inputVille" class="">Ville</label>
        <input type="text" id="inputVille" class="form-control" placeholder="Ville" required name="villeCl">
		
		<label for="inputTelephone" class="">Téléphone</label>
        <input type="text" id="inputTelephone" class="form-control" placeholder="Telephone" required name="telCl">
        <input type="hidden" name="switch" value="createClient">
     	
        <button class="btn btn-lg btn-primary" type="submit">Valider</button>
      </form>

	  </center>
    </div>

</body>
</html>