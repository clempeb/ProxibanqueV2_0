package fr.gtm.proxibanque.service;

import java.util.ArrayList;

import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.CompteBancaire;
/**
 *  Interface de sp�cification des m�thodes de ServiceCompte
 * 
 *
 */
public interface IServiceCompte {
	
	public void creerCompte(CompteBancaire compte);
	
	public void supprimerCompte(CompteBancaire compte);
	
	public void modifierCompte(CompteBancaire compteavant, CompteBancaire compteapres);
	
	public CompteBancaire consulterCompte(CompteBancaire compte);
	
	public boolean virementCaC(CompteBancaire cDebit, CompteBancaire cCredit, int montant);
	
	public void simulCreditConso(int apport, int dur�e);

	public void simulCreditImmo(int apport, int dur�e);
	
	public void placement(CompteBancaire compte, String bourse, int montant);

	public ArrayList<CompteBancaire> consulterCompteClient(Client client);

	public CompteBancaire consulterCompteByNumcompte(int numcompte);





}