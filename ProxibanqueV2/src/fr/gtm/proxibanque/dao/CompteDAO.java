package fr.gtm.proxibanque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.CompteBancaire;
import fr.gtm.proxibanque.domaine.CompteCourant;
import fr.gtm.proxibanque.domaine.CompteEpargne;
/**
 * Implementation des méthodes présentes dans l'interface ICompteDao
 * 
 *
 */
public class CompteDAO implements ICompteDAO{

	Connection cn = null;
	Statement st = null;
	PreparedStatement pst = null;
	
	public CompteDAO() {
		super();
	}
	/**
	 * Ajouter un Compte en Base
	 */
	@Override
	public void creerCompte(CompteBancaire compte) {
		
		try {
			cn = DBConnect.connect();
			st = cn.createStatement();
			
			String sql = "INSERT INTO compte (idclient, numcompte, solde, dateouverture, typecompte) VALUES (" + compte.getClient().getIdClient() + ", seq_pk_numcompte.nextval," + compte.getSolde() +",'" + compte.getDateOuverture() + "','" + compte.getType() + "')";

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
	 *Supprimer un Compte de la Base
	 */
	@Override
	public void supprimerCompte(CompteBancaire compte) {
		
		try {
			cn = DBConnect.connect();
			st = cn.createStatement();
			
			String sql = "delete from compte where numcompte = " + compte.getNumCompte();

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
	 *Modifier un Compte de la Base
	 */
	@Override
	public void modifierCompte(CompteBancaire compteAvant, CompteBancaire compteApres) {
		
	}

	@Override
	public CompteBancaire consulterCompte(int numCompte) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Effectuer un Virement de Compte à Compte
	 */
	@Override
	public boolean virementCaC(CompteBancaire cDebit, CompteBancaire cCredit, int montant) {
		ResultSet result = null;
		CompteBancaire compteTemp = null;
		boolean b = true;
		try {
			cn = DBConnect.connect();
			st = cn.createStatement();
	
			if (cDebit.getType().equals("Courant")) {	
				if (cDebit.getSolde() + ((CompteCourant) cDebit).getDecouvert() >= montant) {
					double dD = cDebit.getSolde() - montant;
					double dC = cCredit.getSolde() + montant;
					String sql = "UPDATE Compte SET solde="+dD+" WHERE numcompte="+ cDebit.getNumCompte();
					String sql2 = "UPDATE Compte SET solde="+dC+" WHERE numcompte="+ cCredit.getNumCompte();
					st.executeUpdate(sql);
					st.executeUpdate(sql2);
					b = true;
				}
				else
					b = false;
			}
			else if (cDebit.getType().equals("Epargne")) {
				if (cDebit.getSolde() >= montant) {
					double dD = cDebit.getSolde() - montant;
					double dC = cCredit.getSolde() + montant;
					String sql = "UPDATE Compte SET solde="+dD+" WHERE numcompte="+ cDebit.getNumCompte();
					String sql2 = "UPDATE Compte SET solde="+dC+" WHERE numcompte="+ cCredit.getNumCompte();
					st.executeUpdate(sql);
					st.executeUpdate(sql2);
					b = true;
				}
				else
					b = false;
			}

			
				
		} catch (Exception expt) {
			System.out.println(expt);
		} finally {
			try {
				st.close();
				DBConnect.disconnect(cn);
			} catch (SQLException e1) {
				e1.printStackTrace();
				}
		}
		return b;
	}

	@Override
	public void simulCreditConso(int apport, int durée) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void simulCreditImmo(int apport, int durée) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void placement(CompteBancaire compte, String bourse, int montant) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 *Consulter le compte d'un client donné
	 */
	@Override
	public ArrayList<CompteBancaire> consulterCompteClient(Client client) {
		
		ArrayList<CompteBancaire> listCompte = new ArrayList<CompteBancaire>();
		ResultSet result = null;

		try {
			cn = DBConnect.connect();
			st = cn.createStatement();
			
			String sql = "SELECT numcompte, solde, dateouverture, typecompte FROM compte JOIN client USING (idclient) WHERE idclient="+ client.getIdClient();
			
			result = st.executeQuery(sql);
			
			while(result.next()){

				if(result.getString("typecompte").equals("Courant")){
					CompteBancaire compteTemp = new CompteCourant(); 
					compteTemp.setNumCompte(result.getInt("numcompte"));
					compteTemp.setSolde(result.getInt("solde"));
					compteTemp.setDateOuverture(result.getString("dateouverture"));
					compteTemp.setClient(client);
					compteTemp.setType(result.getString("typecompte"));
					listCompte.add(compteTemp);
				} else if (result.getString("typecompte").equals("Epargne")) {
					CompteBancaire compteTemp = new CompteEpargne(); 
					compteTemp.setNumCompte(result.getInt("numcompte"));
					compteTemp.setSolde(result.getInt("solde"));
					compteTemp.setDateOuverture(result.getString("dateouverture"));
					compteTemp.setClient(client);
					compteTemp.setType(result.getString("typecompte"));
					listCompte.add(compteTemp);
				}

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
		return listCompte;
	}

	@Override
	public CompteBancaire consulterCompte(CompteBancaire compte) {
		
		ResultSet result = null;
		CompteBancaire compteTemp = null;

		try {
			cn = DBConnect.connect();
			st = cn.createStatement();
			
			String sql = "SELECT * FROM compte WHERE idclient="+ compte.getClient().getIdClient() +" AND typecompte='" + compte.getType() +"'";
			
			result = st.executeQuery(sql);
			
			while(result.next()){

				if(result.getString("typecompte").equals("Courant")){
					compteTemp = new CompteCourant(); 
					compteTemp.setNumCompte(result.getInt("numcompte"));
					compteTemp.setSolde(result.getInt("solde"));
					compteTemp.setDateOuverture(result.getString("dateouverture"));
					compteTemp.setClient(compte.getClient());
					compteTemp.setType(result.getString("typecompte"));
				
				} else if (result.getString("typecompte").equals("Epargne")) {
					compteTemp = new CompteEpargne(); 
					compteTemp.setNumCompte(result.getInt("numcompte"));
					compteTemp.setSolde(result.getInt("solde"));
					compteTemp.setDateOuverture(result.getString("dateouverture"));
					compteTemp.setClient(compte.getClient());
					compteTemp.setType(result.getString("typecompte"));

				}

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
		return compteTemp;
	}

	@Override
	public CompteBancaire consulterCompteByNumcompte(int numcompte) {
		
		ResultSet result = null;
		CompteBancaire compteTemp = null;

		try {
			cn = DBConnect.connect();
			st = cn.createStatement();
			
			String sql = "SELECT * FROM compte WHERE numcompte=" + numcompte;
			
			result = st.executeQuery(sql);
			
			while(result.next()){

				if(result.getString("typecompte").equals("Courant")){
					compteTemp = new CompteCourant(); 
					compteTemp.setNumCompte(result.getInt("numcompte"));
					compteTemp.setSolde(result.getInt("solde"));
					compteTemp.setDateOuverture(result.getString("dateouverture"));
					compteTemp.setType(result.getString("typecompte"));
				
				} else if (result.getString("typecompte").equals("Epargne")) {
					compteTemp = new CompteEpargne(); 
					compteTemp.setNumCompte(result.getInt("numcompte"));
					compteTemp.setSolde(result.getInt("solde"));
					compteTemp.setDateOuverture(result.getString("dateouverture"));
					compteTemp.setType(result.getString("typecompte"));

				}

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
		return compteTemp;
	}
		
	

	/*@Override
	public void simulCreditConso(int apport, int durée) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void simulCreditImmo(int apport, int durée) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void placement(CompteBancaire compte, String bourse, int montant) {
		if (compte instanceof CompteCourant) {	
			if (compte.getSolde() + ((CompteCourant) compte).getDecouvert() >= montant && compte.getSolde() > 500000) {
				double d = compte.getSolde() - montant;
				compte.setSolde(d);
				System.out.println(compte + "\n" + montant + "€ placés à la bourse de " + bourse);
			}
			else
				System.out.println("Solde insuffisant");
		}
		else if (compte instanceof CompteEpargne) {
			if (compte.getSolde() >= montant && compte.getSolde() > 500000) {
				double d = compte.getSolde() - montant;
				compte.setSolde(d);
				System.out.println(compte + "\n" + montant + "€ placés à la bourse de " + bourse);
			}
			else
				System.out.println("Solde insuffisant");
		}
	}*/
}








