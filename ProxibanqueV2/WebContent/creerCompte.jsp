<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="fr.gtm.proxibanque.domaine.Conseiller"%>
<%@ page import="fr.gtm.proxibanque.domaine.Client"%>
<%@ page import="fr.gtm.proxibanque.dao.ClientDAO"%>
<%@ page import="java.util.ArrayList"%>
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

	

	<div class="container">
		<center>

			<form class="form-signin" action="servcompte" method="post">
				<u><h2 class="form-signin-heading"><span class="glyphicon glyphicon-plus"></span> Nouveau Compte</h2></u> <br>

				<label for="inputName">Type de compte</label>
				<p>
					<input type="radio" name="typeCt" value="compteCourant" checked>
					Courant
				</p>
				<p>
					<input type="radio" name="typeCt" value="compteEpargne">
					Epargne
				</p>
				<br> <label for="inputName">Solde à fournir :</label> <input
					type="text" id="inputSolde" class="form-control"
					placeholder="Solde" required autofocus name="soldeCt"> <br>


				<div class="container">
				
<br><br>
					
						<div class="form-group">
							<label for="sel1">Client : </label> 
							<select class="form-control" id="sel1" name="idClient">
								<%
									ArrayList<Client> listeClient = (ArrayList<Client>) session.getAttribute("listC");
									for (Client c : listeClient) {
										out.println("<option value=\"" + c.getIdClient() + "\">" + c.getNom() + ", " + c.getPrenom() + "</option>");
									}
								%>

							</select> <br>
						</div>
				</div>


				<br>
				
				<iframe name="date" id="date-du-jour"
					style="width: 105px; height: 75px;"
					src="http://www.mathieuweb.fr/calendrier/date-jour-noir2.html"
					scrolling="no" frameborder="0" allowtransparency="true"></iframe>
				<br>
				 <input type="hidden" name="switch" value="createCompte">
				 <br><br>
				<button class="btn btn-lg btn-primary" type="submit">Valider</button>
				
				<br><br>
			</form>

		</center>
	</div>

</body>
</html>