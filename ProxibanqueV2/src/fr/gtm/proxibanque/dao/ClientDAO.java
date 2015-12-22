package fr.gtm.proxibanque.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.CompteCourant;
import fr.gtm.proxibanque.domaine.CompteEpargne;
import fr.gtm.proxibanque.domaine.Conseiller;
import fr.gtm.proxibanque.domaine.Particulier;
/**
 * Implementation des méthodes présentes dans l'interface IClientDao
 * 
 *
 */
public class ClientDAO implements IClientDAO{
	
	Connection cn = null;
	Statement st = null;
	PreparedStatement pst = null;
	
	public ClientDAO() {
		super();
	}

	/**
	 * Ajouter un Client en Base
	 */
	@Override
	public void creerClient(Client client) {

		try {
			cn = DBConnect.connect();
			st = cn.createStatement();
			
			String sql = "INSERT INTO Client (idcons, idclient, nom, prenom, email, adresse, codepostal, ville, telephone) VALUES (" + client.getCons().getIdCons() + " , seq_pk_idclient.nextval,'" + client.getNom() +"','" + client.getPrenom() + "','" + client.getEmail() + "','" + client.getAdresse() + "','" + client.getCodePostal() + "','" + client.getVille() + "','" + client.getTelephone() + "')";

			st.executeUpdate(sql);				
		} catch (SQLException sqlEx) {
			System.out.println(sqlEx);
		} finally {
			try {
				st.close();
				DBConnect.disconnect(cn);
			} catch (SQLException e1) {
				e1.printStackTrace();
			    }
		}
	}
	

	/**
	 * Supprimer un Client de la base
	 */
	@Override
	public void supprimerClient(Client client) {
		try {
			cn = DBConnect.connect();
			st = cn.createStatement();
			
			String sql = "DELETE FROM Client WHERE nom='" + client.getNom() + "' AND prenom='" + client.getPrenom() + "'";

			st.executeUpdate(sql);			
		} catch (SQLException sqlEx) {
			System.out.println(sqlEx);
		} finally {
			try {
				st.close();
				DBConnect.disconnect(cn);
			} catch (SQLException e1) {
				e1.printStackTrace();
			    }
		}	
	}
	/**
	 * Modifier un Client de la base
	 */
	@Override
	public void modifierClient(Client clientAvant, Client clientApres) {
		try {
			cn = DBConnect.connect();
			
			String sql = "UPDATE Client SET nom=?, prenom=?, email=?, adresse=?, codepostal=?, ville=?, telephone=?, numcompteC=?, numcompteE=? WHERE nom='" + clientAvant.getNom() + "' AND prenom='" + clientAvant.getPrenom() + "'";
			pst = cn.prepareStatement(sql);
			pst.setString(1, clientApres.getNom());
			pst.setString(2, clientApres.getPrenom());
			pst.setString(3, clientApres.getEmail());
			pst.setString(4, clientApres.getAdresse());
			pst.setString(5, clientApres.getCodePostal());
			pst.setString(6, clientApres.getVille());
			pst.setString(7, clientApres.getTelephone());
			pst.setInt(8, clientApres.getCompteC().getNumCompte());
			pst.setInt(9, clientApres.getCompteE().getNumCompte());
			
			pst.executeUpdate();		
		} catch (SQLException sqlEx) {
			System.out.println(sqlEx);
		} finally {
			try {
				pst.close();
				DBConnect.disconnect(cn);
			} catch (SQLException e1) {
				e1.printStackTrace();
			    }
		}	
	}
	/**
	 * Consulter un Client de la base
	 */
	@Override
	public Client consulterClient(Client client) {

		ResultSet result = null;
		Particulier pa2 = null;
		Conseiller cons2 = null;

		try {
			cn = DBConnect.connect();
			st = cn.createStatement();
			
			String sql = "SELECT idclient, client.nom nomCl, client.prenom prenomcl, email, adresse, codepostal, ville, telephone, conseiller.nom nomcons, conseiller.prenom prenomcons FROM Client JOIN Conseiller USING (idcons) WHERE UPPER(client.nom)='" + client.getNom().toUpperCase() + "' AND UPPER(client.prenom)='" + client.getPrenom().toUpperCase() + "'";
			
			result = st.executeQuery(sql);
			while (result.next())
			{
				pa2 = new Particulier();
				cons2 = new Conseiller();
				cons2.setNom(result.getString("nomcons"));
				cons2.setPrenom(result.getString("prenomcons"));
				pa2.setCons(cons2);
				pa2.setIdClient(result.getInt("idclient"));
				pa2.setNom(result.getString("nomcl"));
				pa2.setPrenom(result.getString("prenomcl"));
				pa2.setEmail(result.getString("email"));
				pa2.setAdresse(result.getString("adresse"));
				pa2.setCodePostal(result.getString("codepostal"));
				pa2.setVille(result.getString("ville"));
				pa2.setTelephone(result.getString("telephone"));
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
		return pa2;
	}
	
	/**
	 * Consulter la liste des Client de la base
	 */
	@Override
	public ArrayList<Client> consulterAllClient(Conseiller cons) {
		ArrayList<Client> listeClient = new ArrayList<Client>();
		ResultSet result = null;
				
		try 
		{
			cn = DBConnect.connect();
			st = cn.createStatement();
			
			String sql = "SELECT * FROM Client";//TODO idcons
			
			result = st.executeQuery(sql);
			while (result.next())
			{
				Client tempC = new Particulier();
				tempC.setNom(result.getString("nom"));
				tempC.setPrenom(result.getString("prenom"));
				tempC.setEmail(result.getString("email"));
				tempC.setAdresse(result.getString("adresse"));
				tempC.setCodePostal(result.getString("codepostal"));
				tempC.setVille(result.getString("ville"));
				tempC.setTelephone(result.getString("telephone"));
				CompteCourant cc = new CompteCourant();
				cc.setNumCompte(result.getInt("numcomptec"));
				CompteEpargne ce = new CompteEpargne();
				ce.setNumCompte(result.getInt("numcomptee"));
				tempC.setCompteC(cc);
				tempC.setCompteE(ce);
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
	
	
	


