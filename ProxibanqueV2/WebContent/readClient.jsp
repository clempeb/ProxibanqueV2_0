<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="fr.gtm.proxibanque.domaine.Conseiller"%>
<%@ page import="fr.gtm.proxibanque.domaine.Client"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--BOOTSRAP-->
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Consulter Client</title>
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



	<div class="container">
		<center>

			<form class="form-signin" action="servclient" method="post">
				<h2 class="form-signin-heading"><span class="glyphicon glyphicon-search"></span>Recherche Client</h2>
				<label for="inputName">Nom</label> <input type="name" id="inputName"
					class="form-control" placeholder="Nom" required autofocus
					name="nomCl"> <label for="inputFirstName" class="">Prenom</label>
				<input type="name" id="inputFirstName" class="form-control"
					placeholder="Prenom" required autofocus name="prenomCl"> <input
					type="hidden" name="switch" value="readClient"> <br>
				<button class="btn btn-lg btn-primary" type="submit">Rechercher</button>
			</form>

		</center>
	</div>


	<div class="container">
		<h2>Client</h2>
		<br>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Email</th>
					<th>Adresse</th>
					<th>Code Postal</th>
					<th>Ville</th>
					<th>Telephone</th>
					<th>Conseiller</th>
				</tr>
			</thead>
			<tbody>
				<%
					if (session.getAttribute("searchList") != null) {
						ArrayList<Client> searchL = (ArrayList<Client>) session.getAttribute("searchList");
						for (Client c : searchL) {
							out.println("<tr>");
							out.println("<td>" + c.getNom() + "</td>");
							out.println("<td>" + c.getPrenom() + "</td>");
							out.println("<td>" + c.getEmail() + "</td>");
							out.println("<td>" + c.getAdresse() + "</td>");
							out.println("<td>" + c.getCodePostal() + "</td>");
							out.println("<td>" + c.getVille() + "</td>");
							out.println("<td>" + c.getTelephone() + "</td>");
							out.println("<td>" + c.getCons().getPrenom() + " " + c.getCons().getNom() + "</td>");
							out.println("</tr>");
						}
					} else if (request.getAttribute("etat") != null) {
						out.println(request.getAttribute("etat"));
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>