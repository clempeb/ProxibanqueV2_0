<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="fr.gtm.proxibanque.domaine.Conseiller"%>
<%@ page import="fr.gtm.proxibanque.domaine.Client"%>
<%@ page import="fr.gtm.proxibanque.domaine.CompteBancaire"%>
<%@ page import="fr.gtm.proxibanque.dao.ClientDAO"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--BOOTSRAP-->
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Insert title here</title>
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


<form class="form-signin" action="servcompte" method="post">
	<div class="container">
	
	<center>
					<h2><span class="glyphicon glyphicon-search"></span>Recherche Client</h2>
<br><br>
						<div class="form-group">
							<label for="sel1">Client :</label> 
							<select class="form-control" id="sel1" name="idClient3">
								<%
									ArrayList<Client> listeClient = (ArrayList<Client>) session.getAttribute("listC");
									for (Client c : listeClient) {
										out.println("<option value=\"" + c.getIdClient() + "\">" + c.getNom() + ", " + c.getPrenom() + "</option>");
									}
								%>
</center>
							</select> <br>
						</div>
				</div>
				
				<br><br>
<center>
				 <input type="hidden" name="switch" value="deleteCompte">
				<button class="btn btn-lg btn-primary" type="submit">Valider</button></center>
</form>

	<div class="container">
		<h2>Client</h2>
		<br>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Type Compte</th>
					<th>Numéro de compte</th>
					<th>Solde</th>
					<th>Date d'ouverture</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
					if (request.getAttribute("listCompte") != null) {
						ArrayList<CompteBancaire> searchL = (ArrayList<CompteBancaire>) request.getAttribute("listCompte");
						for (CompteBancaire cb : searchL) {
							out.println("<tr>");
							out.println("<td>" + cb.getType() + "</td>");
							out.println("<td>" + cb.getNumCompte() + "</td>");
							out.println("<td>" + cb.getSolde() + "</td>");
							out.println("<td>" + cb.getDateOuverture() + "</td>");
							out.println("<td>");
							out.println("<div class=\"btn-group\">");
							out.println("<form class=\"form-signin\" action=\"servcompte\" method=\"post\">");
							out.println("<input type=\"hidden\" name=\"switch\" value=\"deleteCompteConfirm\">");
							out.println("<input type=\"hidden\" name=\"numcompte\" value=\""+cb.getNumCompte()+"\">");
							out.println("<button class=\"btn btn-xs btn-danger\" type=\"submit\">Supprimer</button>");
							out.println("</form>");
							out.println("<form class=\"form-signin\" action=\"menuClient.jsp\" method=\"post\">");
							out.println("<button class=\"btn btn-xs btn-primary\" type=\"submit\">Annuler</button>");
							out.println("</form></div></td>");
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