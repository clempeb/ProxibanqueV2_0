package fr.gtm.proxibanque.presentation;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.proxibanque.dao.ConseillerDAO;
import fr.gtm.proxibanque.domaine.Conseiller;
import fr.gtm.proxibanque.service.ServiceConseiller;

/**
 * Servlet implementation class ServletConseiller
 */
@WebServlet("/ServletConseiller")
public class ServletConseiller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ServiceConseiller iscons;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConseiller() {
        super();
        ConseillerDAO consd= new ConseillerDAO();
        this.iscons= new ServiceConseiller(consd);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request,response);
	}
	/**
	 * Renvoie vers la page JSP de la Page d'Accueil réservée au Conseiller
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sw = request.getParameter("switch");
		switch (sw) {
		case "verifCons":
			verifCons(request, response);
			break;
//		case "resultClient":
//			resultClient(request, response);
//			break;
//		case "retourMenu":
//			retourMenu(request, response);
//			break;
//		case "readClientFU":
//			readClientForUpdate(request, response);
//			break;
//		case "readClient":
//			readClient(request, response);
//			break;
//		case "deleteClient": // TODO deleteClient(request, response);
//			break;
		default:
			RequestDispatcher dispatcher = request.getRequestDispatcher("menuClient.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	/**
	 * Vérifier l'authentification d'un Conseiller avec son Login-Password, et renvoie à la page d'authentification avec un message d'erreur
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void verifCons(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login=request.getParameter("loginCons");
		String mdp=request.getParameter("pwdCons");
		RequestDispatcher dispatcher;
		Conseiller cons = new Conseiller(login,mdp);
		
		if(iscons.verifConseiller(cons)){
			dispatcher = request.getRequestDispatcher("menuClient.jsp");
			HttpSession maSession = request.getSession();
			cons = iscons.readConseiller(cons);
			maSession.setAttribute("user",cons);
			maSession.setAttribute("listC", iscons.consulterListeClient(cons));
		} else {
			request.setAttribute("echec", "Echec authentification, veuillez essayer à nouveau");
			dispatcher = request.getRequestDispatcher("accueil.jsp");
		}
		dispatcher.forward(request, response);
	}
	
//	protected void retourMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		RequestDispatcher dispatcher = request.getRequestDispatcher("menuClient.jsp");
//		HttpSession maSession = request.getSession();
//		maSession.setAttribute("listC", iscons.consulterListeClient());
//		dispatcher.forward(request, response);
//	}
}
