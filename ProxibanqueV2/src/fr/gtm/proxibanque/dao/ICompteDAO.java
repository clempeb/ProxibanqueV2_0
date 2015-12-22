package fr.gtm.proxibanque.dao;

import java.util.ArrayList;

import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.CompteBancaire;

/**
 *  Interface de spécificationdes méthodes présentes dans la Classe CompteDao
 * 
 *
 */
public interface ICompteDAO {

	public void creerCompte(CompteBancaire compte);
	
	public void supprimerCompte(CompteBancaire compte);
	
	public void modifierCompte(CompteBancaire compteAvant, CompteBancaire compteApres);

	public CompteBancaire consulterCompte(int numCompte);
	
	public boolean virementCaC(CompteBancaire cDebit, CompteBancaire cCredit, int montant);
	
	public void simulCreditConso(int apport, int durée);
	
	public void simulCreditImmo(int apport, int durée);
	
	public void placement(CompteBancaire compte, String bourse, int montant);

	public ArrayList<CompteBancaire> consulterCompteClient(Client client);

	public CompteBancaire consulterCompte(CompteBancaire compte);

	public CompteBancaire consulterCompteByNumcompte(int numcompte);


}

