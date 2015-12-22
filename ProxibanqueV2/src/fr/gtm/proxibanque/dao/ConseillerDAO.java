package fr.gtm.proxibanque.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.Conseiller;
import fr.gtm.proxibanque.domaine.Particulier;

/**
 * Implementation des méthodes la l'interface ICOnseillerDao
 * 
 *
 */
public class ConseillerDAO implements IConseillerDAO {
	
	Connection cn = null;
	Statement st = null;
	

	
//	public void createConseiller(Conseiller e) throws DaoException
//	{
//		// Information d'accès à la base de données
//		String url = "jdbc:mysql://localhost/formation";
//		String login = "root";
//		String password = "";
//		Connection cn = null;
//		Statement st = null;
//		
//		try 
//		{
//			// Etape 1: Chargement du driver
//			Class.forName("com.mysql.jdbc.Driver");
//			// Etape 2: Récupération de la connexion
//			cn = DriverManager.getConnection(url, login, password);
//			// Etape 3: Création d'un statement
//			st = cn.createStatement();
//			String sql = "INSERT INTO Conseiller(nom, prenom) VALUES ('" + e.getNom() +"','"+ e.getPrenom() + "')";
//			// Etape 4: Exécution du statement
//			st.executeUpdate(sql);
//			throw new DaoException();
//		} catch (SQLException sqlEx) 
//		{
//			System.out.println(sqlEx);
//		} catch (ClassNotFoundException cnfEx) 
//		{
//			System.out.println(cnfEx);
//		}
//		catch (DaoException daoEx)
//		{
//			System.out.println(daoEx.getMessage());
//		}
//     	finally
//		{
//			try {
//				st.close();
//				cn.close();
//			} catch (SQLException e1)
//			    {
//				e1.printStackTrace();
//			    }
//		}
//		System.out.println(e.getNom() + ", " + e.getPrenom() + " ajouté à la base.");
//		throw new DaoException();
//	}
	
	public ConseillerDAO() {
		super();
	}

	/**
	 * 
	 * Lire un COnseiller de la base
	 */
	public Conseiller readConseiller(Conseiller cons) {

		ResultSet result = null;
		Conseiller cons2 = null;
		try {
			cn = DBConnect.connect();
			st = cn.createStatement();
			
			String sql = "SELECT * FROM Conseiller WHERE login='" + cons.getLogin() + "'";
			
			result = st.executeQuery(sql);
			while (result.next()) {
				cons2 = new Conseiller();
				cons2.setIdCons(result.getInt("idcons"));
				cons2.setNom(result.getString("nom"));
				cons2.setPrenom(result.getString("prenom"));
				cons2.setLogin(result.getString("login"));
				cons2.setPwd(result.getString("password"));
			}	
		} catch (Exception expt) {
			System.out.println(expt);
		} finally {
			try {
				result.close();
				st.close();
				DBConnect.disconnect(cn);
			} catch (SQLException e1) {
				e1.printStackTrace();
				}
		}
		return cons2;
	}
	
//	public void updateNomConseiller(Conseiller e, String nom)
//	{
//		// Information d'accès à la base de données
//		String url = "jdbc:mysql://localhost/formation";
//		String login = "root";
//		String password = "";
//		Connection cn = null;
//		Statement st = null;
//		
//		try 
//		{
//			// Etape 1: Chargement du driver
//			Class.forName("com.mysql.jdbc.Driver");
//			// Etape 2: Récupération de la connexion
//			cn = DriverManager.getConnection(url, login, password);
//			// Etape 3: Création d'un statement
//			st = cn.createStatement();
//			String sql = "UPDATE Conseiller SET nom='" + nom + "' WHERE id=" + e.getId();
//			// Etape 4: Exécution du statement
//			st.executeUpdate(sql);
//		} catch (Exception expt) 
//		{
//			System.out.println(expt);
//		}
//     	finally
//		{
//			try {
//				st.close();
//				cn.close();
//			} catch (SQLException e1)
//			    {
//				e1.printStackTrace();
//			    }
//		}
//		System.out.println("Modification effectuée.");
//	}
//
//	public void deleteConseiller(Conseiller e) 
//	{
//		// Information d'accès à la base de données
//		String url = "jdbc:mysql://localhost/formation";
//		String login = "root";
//		String password = "";
//		Connection cn = null;
//		Statement st = null;
//				
//		try 
//		{
//			// Etape 1: Chargement du driver
//			Class.forName("com.mysql.jdbc.Driver");
//			// Etape 2: Récupération de la connexion
//			cn = DriverManager.getConnection(url, login, password);
//			// Etape 3: Création d'un statement
//			st = cn.createStatement();
//			String sql = "DELETE FROM Conseiller WHERE (nom='" + e.getNom() + "' AND prenom='" + e.getPrenom() + "')";
//			// Etape 4: Exécution du statement
//			st.executeUpdate(sql);
//			} catch (Exception expt) 
//			{
//				System.out.println(expt);
//			} finally {
//			try {
//					st.close();
//					cn.close();
//				} catch (SQLException e1) {
//						e1.printStackTrace();
//					}
//			}
//	
//		System.out.println( e.getNom() + ", " + e.getPrenom() + " supprimé de la base.");
//	}
//
//	public List<Conseiller> findAllConseillers() 
//	{
//		List<Conseiller> listeConseillers = new ArrayList<Conseiller>();
//		ResultSet results = null;
//		
//		// Information d'accès à la base de données
//		String url = "jdbc:mysql://localhost/formation";
//		String login = "root";
//		String password = "";
//		Connection cn = null;
//		Statement st = null;
//				
//		try 
//		{
//			// Etape 1: Chargement du driver
//			Class.forName("com.mysql.jdbc.Driver");
//			// Etape 2: Récupération de la connexion
//			cn = DriverManager.getConnection(url, login, password);
//			// Etape 3: Création d'un statement
//			st = cn.createStatement();
//			String sql = "SELECT * FROM Conseiller";
//			results = st.executeQuery(sql);
//			while (results.next())
//			{
//				Conseiller tempE = new Conseiller();
//				tempE.setId(results.getInt("id"));
//				tempE.setNom(results.getString("nom"));
//				tempE.setPrenom(results.getString("prenom"));
//				listeConseillers.add(tempE);
//			}
//		} catch (Exception expt) {
//				System.out.println(expt);
//		} finally
//			{
//				try
//				{
//					results.close();
//					st.close();
//					cn.close();
//				} catch (SQLException e1) 
//					{
//					e1.printStackTrace();
//				}}
//
//		return listeConseillers;
//	}
		
	
	/**
	 * 
	 * Consulter la liste des Clients pour un Conseiller donné
	 */
	@Override
	public ArrayList<Client> consulterListeClient(Conseiller cons) {
		ArrayList<Client> listeClient = new ArrayList<Client>();
		ResultSet result = null;
				
		try 
		{
			cn = DBConnect.connect();
			st = cn.createStatement();
			
			String sql = "SELECT * FROM Client WHERE idcons=" + cons.getIdCons();
			
			result = st.executeQuery(sql);
			while (result.next())
			{
				Client tempC = new Particulier();
				tempC.setIdClient(result.getInt("idclient"));
				tempC.setNom(result.getString("nom"));
				tempC.setPrenom(result.getString("prenom"));
				tempC.setEmail(result.getString("email"));
				tempC.setAdresse(result.getString("adresse"));
				tempC.setCodePostal(result.getString("codepostal"));
				tempC.setVille(result.getString("ville"));
				tempC.setTelephone(result.getString("telephone"));
				listeClient.add(tempC);
			}
		} catch (Exception expt) {
				System.out.println(expt);
		} finally {
				try {
					result.close();
					st.close();
					DBConnect.disconnect(cn);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}
		return listeClient;
	}

	

}
