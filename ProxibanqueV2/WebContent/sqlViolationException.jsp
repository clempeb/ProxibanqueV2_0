<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
<link rel="stylesheet" href="CSS/bootstrap.css">
<link rel="stylesheet" href="CSS/bootstrap-theme.css">
<link rel="stylesheet" href="CSS/login.css">
<script src="JS/jquery-1.11.3.js"></script>
<script src="JS/bootstrap.js"></script>
<title>Menu Client</title>
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
								class="glyphicon glyphicon-plus"></span> Cr�er Client</a></li>
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
								Cr�er Compte</a></li>
						<li><a href="virement.jsp"><span class="glyphicon glyphicon-pencil"></span>
								Virement</a></li>
						<li><a href="deleteCompte.jsp"><span class="glyphicon glyphicon-remove"></span>
								Supprimer Compte</a></ul></li></ul>
		
			
	
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Aide</a></li>
				<li><a href="accueil.jsp"><span
						class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
						D�connexion</a></li>
			</ul>

		</div>
	</div>
	</nav>
		
Le Client poss�de d�j� un Compte de ce type - IMPOSSIBLE D'INSERER CET ELEMENT- 

<h3>Retour � <a href="menuClient.jsp">Votre espace personnel</a></h3>


</div>
	<br>