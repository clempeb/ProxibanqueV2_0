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
import fr.gtm.proxibanque.dao.GerantDAO;
import fr.gtm.proxibanque.domaine.Agence;
import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.Conseiller;
import fr.gtm.proxibanque.domaine.Gerant;
import fr.gtm.proxibanque.domaine.Particulier;
import fr.gtm.proxibanque.service.IServiceClient;
import fr.gtm.proxibanque.service.ServiceClient;
import fr.gtm.proxibanque.service.ServiceCompte;
import fr.gtm.proxibanque.service.ServiceGerant;

/**
 * Servlet implementation class ServletClient
 */
@WebServlet("/ServletClient")
public class ServletClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static GerantDAO gd = new GerantDAO();
	static ClientDAO cd = new ClientDAO();
	static CompteDAO cod = new CompteDAO();
	static ServiceGerant sg = new ServiceGerant(gd);
	static ServiceClient sc = new ServiceClient(cd);
	static ServiceCompte sco = new ServiceCompte(cod);
	static ArrayList<Client> alc = new ArrayList<Client>();
	static Client clTemp;

	static Agence a = new Agence(125, "26/11/2015");
	static Gerant g = new Gerant("BOSS", a);

	IServiceClient isc;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletClient() {
		super();
		ClientDAO cd = new ClientDAO();
		isc = new ServiceClient(cd);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request, response);
	}

	/**
	 * Renvoie à la méthode donnée en fonction du choix du conseiller dans la partie Client (Consulter, Créer, Modifier, Supprimer)
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sw = request.getParameter("switch");
		switch (sw) {
		case "createClient":
			createClient(request, response);
			break;
//		case "resultClient":
//			resultClient(request, response);
//			break;
		case "updateClient":
			updateClient(request, response);
			break;
		case "readClientFU":
			readClientForUpdate(request, response);
			break;
		case "readClient":
			readClient(request, response);
			break;
		case "deleteClient": 
			deleteClient(request, response);
			break;
		case "deleteClientConfirm": 
			deleteClientConfirm(request, response);
			break;
		default:
			RequestDispatcher dispatcher = request.getRequestDispatcher("menuClient.jsp");
			dispatcher.forward(request, response);
		}

	}
/**
 * Crée un Client dans la base 
 * @param request
 * @param response
 * @throws ServletException
 * @throws IOException
 */
	protected void createClient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession maSession = request.getSession();
		Conseiller cons = (Conseiller) maSession.getAttribute("user");
		String nom = request.getParameter("nomCl");
		String prenom = request.getParameter("prenomCl");
		String email = request.getParameter("emailCl");
		String adresse = request.getParameter("adresseCl");
		String codeP = request.getParameter("codePostalCl");
		String ville = request.getParameter("villeCl");
		String telephone = request.getParameter("telCl");

		Particulier pa = new Particulier(cons, nom, prenom, email, adresse, codeP, ville, telephone);


		if (isc.creerClient(pa)) {
			maSession.setAttribute("listC", isc.consulterAllClient(cons));
			request.setAttribute("client",pa);
			request.setAttribute("etat", "Client créé");
		} else {
			request.setAttribute("client", isc.consulterClient(pa));
			request.setAttribute("etat", "Client déjà existant");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("clientCree.jsp");

		dispatcher.forward(request, response);
	}

//	protected void resultClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("clientCree.jsp");
//		dispatcher.forward(request, response);	
//	}
	/**
	 * Renvoie vers la page JSP où l'on peut consulter les Client
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void readClient(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nomCl");
		String prenom = request.getParameter("prenomCl");

		Particulier pa = new Particulier(nom, prenom);
		HttpSession maSession = request.getSession();

		if (isc.consulterClient(pa) != null) {
			alc.add(isc.consulterClient(pa));
			maSession.setAttribute("searchList",alc);
		} else {
			request.setAttribute("etat", "Client non présent dans la base");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("readClient.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void readClientForUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nomCl");
		String prenom = request.getParameter("prenomCl");
		RequestDispatcher dispatcher;

		Particulier pa = new Particulier(nom, prenom);

		if (isc.consulterClient(pa) != null) {
			clTemp = isc.consulterClient(pa);
			request.setAttribute("clientAvant", clTemp);
			dispatcher = request.getRequestDispatcher("modifClientSuite.jsp");
		} else {
			request.setAttribute("etat", "Client non présent dans la base");
			dispatcher = request.getRequestDispatcher("modifClient.jsp");
		}
		dispatcher.forward(request, response);
	}
	/**
	 * Renvoie vers la page JSP où l'on peut modifier les Client
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	protected void updateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO implement method, recup données client après	
		HttpSession maSession = request.getSession();
		Conseiller cons = (Conseiller) maSession.getAttribute("user");
		String nom = request.getParameter("nomCl");
		String prenom = request.getParameter("prenomCl");
		String email = request.getParameter("emailCl");
		String adresse = request.getParameter("adresseCl");
		String codeP = request.getParameter("codePostalCl");
		String ville = request.getParameter("villeCl");
		String telephone = request.getParameter("telCl");

		Particulier pa = new Particulier(cons, nom, prenom, email, adresse, codeP, ville, telephone);
		isc.modifierClient(clTemp, pa);
		maSession.setAttribute("listC", isc.consulterAllClient(cons));
		request.setAttribute("etat", "Client modifié");
		request.setAttribute("client", pa);
		RequestDispatcher dispatcher = request.getRequestDispatcher("clientCree.jsp");
		dispatcher.forward(request, response);
	}
	
	/**
	 * Renvoie vers la page JSP où l'on peut supprimer les Client
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nomCl");
		String prenom = request.getParameter("prenomCl");
		RequestDispatcher dispatcher;

		Particulier pa = new Particulier(nom, prenom);

		if (isc.consulterClient(pa) != null) {
			clTemp = isc.consulterClient(pa);
			request.setAttribute("clientToDelete", clTemp);
			dispatcher = request.getRequestDispatcher("deleteClientConfirm.jsp");
		} else {
			request.setAttribute("etat", "Client non présent dans la base");
			dispatcher = request.getRequestDispatcher("deleteClient.jsp");
		}
		dispatcher.forward(request, response);
	}
	/**
	 * Renvoie vers la page JSP où l'on peut doit confirmer la suppression définitive d'un Client
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deleteClientConfirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		isc.supprimerClient(clTemp);
		HttpSession maSession = request.getSession();
		Conseiller cons = (Conseiller) maSession.getAttribute("user");
		maSession.setAttribute("listC", isc.consulterAllClient(cons));
		request.setAttribute("etat", "Client supprimé");
		RequestDispatcher dispatcher = request.getRequestDispatcher("clientCree.jsp");
		dispatcher.forward(request, response);
	}
}
