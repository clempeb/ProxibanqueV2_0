package fr.gtm.proxibanque.presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.proxibanque.dao.ClientDAO;
import fr.gtm.proxibanque.dao.CompteDAO;

import fr.gtm.proxibanque.domaine.Agence;
import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.CompteBancaire;
import fr.gtm.proxibanque.domaine.CompteCourant;
import fr.gtm.proxibanque.domaine.CompteEpargne;
import fr.gtm.proxibanque.domaine.Conseiller;
import fr.gtm.proxibanque.domaine.Gerant;
import fr.gtm.proxibanque.domaine.Particulier;
import fr.gtm.proxibanque.service.IServiceClient;
import fr.gtm.proxibanque.service.IServiceCompte;
import fr.gtm.proxibanque.service.ServiceClient;
import fr.gtm.proxibanque.service.ServiceCompte;


/**
 * Servlet implementation class ServletCompte
 */
@WebServlet("/ServletCompte")
public class ServletCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	static ClientDAO cd = new ClientDAO();
	static CompteDAO cod = new CompteDAO();

	static ServiceClient sc = new ServiceClient(cd);
	static ServiceCompte sco = new ServiceCompte(cod);
	static ArrayList<Client> alc = new ArrayList<Client>();
	static Client cTemp;
	static ArrayList<CompteBancaire> alco = new ArrayList<CompteBancaire>();
	static CompteBancaire coTemp;

	static Agence a = new Agence(125, "26/11/2015");
	static Gerant g = new Gerant("BOSS", a);

	IServiceCompte isco;
	IServiceClient iscl;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCompte() {
		super();
		CompteDAO cd = new CompteDAO();
		ClientDAO cld = new ClientDAO();
		isco = new ServiceCompte(cd);
		iscl = new ServiceClient(cld);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request, response);
	}

	protected void traitement(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String sw = request.getParameter("switch");
		switch (sw) {
		case "createCompte":
			createCompte(request, response);
			break;
//		 case "resultClient":
//		 resultClient(request, response);
//		 break;
		case "virement":
		virement(request, response);
			break;
//		case "readClientFU":
//			readClientForUpdate(request, response);
//			break;
		case "readCompte":
			readCompte(request, response);
			break;
		case "deleteCompte":
			deleteCompte(request, response);
			break;
		case "deleteCompteConfirm":
			deleteCompteConfirm(request, response);
			break;
		default:
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("compteCree.jsp");

			dispatcher.forward(request, response);
		}}

	
	/**
	 * Renvoie vers la page JSP où l'on créer un compte
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void createCompte(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession maSession = request.getSession();
		Conseiller cons = (Conseiller) maSession.getAttribute("user");
		Client cl = null;
		String type = request.getParameter("typeCt");
		String solde = request.getParameter("soldeCt");
		int soldeCt = Integer.parseInt(solde);
		String idClient = request.getParameter("idClient");
		int idCl = Integer.parseInt(idClient);
		String date = request.getParameter("date");
		ArrayList<Client> listeClient = (ArrayList<Client>) maSession.getAttribute("listC");
		for(Client c : listeClient){
			if( c.getIdClient() == idCl) {
				cl = c;
			}
		}

		if (type.equals("compteCourant")) {
		
			CompteCourant ct = new CompteCourant();
			ct.setClient(cl);
			ct.setSolde(soldeCt);
			ct.setDateOuverture(date);
			ct.setType("Courant");

			isco.creerCompte(ct);
			ct = (CompteCourant) isco.consulterCompte(ct);
			cl.setCompteC(ct);
			iscl.modifierClient(cl, cl);
			maSession.setAttribute("listC", iscl.consulterAllClient(cons));
			request.setAttribute("compte", ct);
			request.setAttribute("etat", "Compte créé");

		} else if(type.equals("compteEpargne")) {
			
			CompteEpargne ct = new CompteEpargne();
			ct.setClient(cl);
			ct.setSolde(soldeCt);
			ct.setDateOuverture(date);
			ct.setType("Epargne");
			
			isco.creerCompte(ct);
			ct = (CompteEpargne) isco.consulterCompte(ct);
			cl.setCompteE(ct);
			iscl.modifierClient(cl, cl);
			maSession.setAttribute("listC", iscl.consulterAllClient(cons));
			request.setAttribute("compte", ct);
			request.setAttribute("etat", "Compte créé");
					
		}
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("compteCree.jsp");

		dispatcher.forward(request, response);
	}

	 protected void virement(HttpServletRequest request,
	 HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher dispatcher = null;
		 String numD = request.getParameter("numDeb");
		 String numC = request.getParameter("numCre");
		 String mont = request.getParameter("montant");
		 int numDt = Integer.parseInt(numD);
		 int numCt = Integer.parseInt(numC);
		 int mt = Integer.parseInt(mont);
		 CompteBancaire cDeb = isco.consulterCompteByNumcompte(numDt);
		 CompteBancaire cCre = isco.consulterCompteByNumcompte(numCt);
		 if(cDeb != null && cCre != null) {
			 boolean bool = isco.virementCaC(cDeb, cCre, mt);
			 if(bool) {
				 request.setAttribute("compteD", cDeb);
				 request.setAttribute("compteC", cCre);
				 dispatcher = request.getRequestDispatcher("virementSuite.jsp");
			 } else {
				 request.setAttribute("error", "Solde du compte débiteur insuffisant");
				 dispatcher = request.getRequestDispatcher("virementError.jsp");
			 }
			 } else {
				 request.setAttribute("error", "Numéros de compte inexistants dans la base");
				 dispatcher = request.getRequestDispatcher("virementError.jsp");
			 }
		 
		 dispatcher.forward(request, response);
	 }

	/**
	 * Renvoie vers la page JSP où l'on lire un compte
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void readCompte(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CompteBancaire> alcb = new ArrayList<CompteBancaire>();
		String idClient2 = request.getParameter("idClient2");
		int idCl2 = Integer.parseInt(idClient2);
		Client cl2 = new Particulier();
		cl2.setIdClient(idCl2);
	

		if (isco.consulterCompteClient(cl2) != null) {
			alcb = (isco.consulterCompteClient(cl2));
			request.setAttribute("listCompte", alcb);
		} else {
			request.setAttribute("etat", "Pas de compte pour ce client");
		}
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("consulterCompte.jsp");
		dispatcher.forward(request, response);
	}

	/*protected void updateCompte(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO implement method, recup données client après
		String nom = request.getParameter("nomCl");
		String prenom = request.getParameter("prenomCl");
		String adresse = request.getParameter("adresseCl");
		String codeP = request.getParameter("codePostalCl");
		String ville = request.getParameter("villeCl");
		String telephone = request.getParameter("telCl");

		Particulier pa = new Particulier(nom, prenom, adresse, codeP, ville,
				telephone);
		isco.modifierClient(clTemp, pa);
		HttpSession maSession = request.getSession();
		maSession.setAttribute("listC", isco.consulterAllClient());
		request.setAttribute("etat", "Client modifié");
		request.setAttribute("client", pa);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("clientCree.jsp");
		dispatcher.forward(request, response);
	}*/

	
	/**
	 * Appele la page de confirmation de suppression d'un ccompte
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteCompte(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CompteBancaire> alcb = new ArrayList<CompteBancaire>();
		RequestDispatcher dispatcher;
		String idClient3 = request.getParameter("idClient3");
		int idCl3 = Integer.parseInt(idClient3);
		Client cl3 = new Particulier();
		cl3.setIdClient(idCl3);

		if (isco.consulterCompteClient(cl3) != null) {
			alcb = (isco.consulterCompteClient(cl3));
			request.setAttribute("listCompte", alcb);
			dispatcher = request.getRequestDispatcher("deleteCompte.jsp");
		} else {
			request.setAttribute("etat", "Pas de compte pour ce client");
			dispatcher = request.getRequestDispatcher("deleteCompte.jsp");
		}
		dispatcher.forward(request, response);
	}

	protected void deleteCompteConfirm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String numC = request.getParameter("numcompte");
		int numCo = Integer.parseInt(numC);
		coTemp = new CompteCourant();
		coTemp.setNumCompte(numCo);
		isco.supprimerCompte(coTemp);

		request.setAttribute("etat", "Compte supprimé");
		RequestDispatcher dispatcher = request.getRequestDispatcher("compteCree.jsp");
		dispatcher.forward(request, response);}
		
		}

