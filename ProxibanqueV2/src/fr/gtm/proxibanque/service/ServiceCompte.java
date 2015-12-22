package fr.gtm.proxibanque.service;

import java.util.ArrayList;

import fr.gtm.proxibanque.dao.ICompteDAO;
import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.CompteBancaire;

public class ServiceCompte implements IServiceCompte{
	ICompteDAO icomdao;
	
	
	/**
	 * @param icomdao
	 */
	public ServiceCompte(ICompteDAO icomdao) {
		super();
		this.icomdao = icomdao;
	}
	/**
	 * Appele la méthode creerCompte de la classe CompteDao
	 * 
	 */
	@Override
	public void creerCompte(CompteBancaire compte) {
		icomdao.creerCompte(compte);
		
	}
	/**
	 * Appele la méthode supprimerCompte de la classe CompteDao
	 * 
	 */
	@Override
	public void supprimerCompte(CompteBancaire compte) {
		icomdao.supprimerCompte(compte);
		
	}
	/**
	 * Méthode non utile pour le moment
	 */
	@Override
	public void modifierCompte(CompteBancaire compteavant, CompteBancaire compteapres) {
		icomdao.modifierCompte(compteavant, compteapres);
		
	}
	/**
	 * Appele la méthode consulterCompte de la classe CompteDao
	 */
	@Override
	public CompteBancaire consulterCompte(CompteBancaire compte) {
		return icomdao.consulterCompte(compte);
	}
	/**
	 * Appele la méthode virementCAC de la classe CompteDao
	 */
	
	@Override
	public boolean virementCaC(CompteBancaire cDebit, CompteBancaire cCredit, int montant) {
		return icomdao.virementCaC(cDebit, cCredit, montant);
	}
	/**
	 * Méthode non utile pour le moment
	 */
	@Override
	public void simulCreditConso(int apport, int durée) {
		icomdao.simulCreditConso(apport, durée);
	}
	/**
	 * Méthode non utile pour le moment
	 */
	@Override
	public void simulCreditImmo(int apport, int durée) {
		icomdao.simulCreditImmo(apport, durée);
	}
	/**
	 * Méthode non utile pour le moment
	 */
	@Override
	public void placement(CompteBancaire compte, String bourse, int montant) {
		icomdao.placement(compte, bourse, montant);
	}
	/**
	 * Appele la méthode consulterCompteClient de la Classe ClientDao
	 */
	@Override
	public ArrayList<CompteBancaire> consulterCompteClient(Client client) {
		return icomdao.consulterCompteClient(client);
	}

	@Override
	public CompteBancaire consulterCompteByNumcompte(int numcompte) {
		return icomdao.consulterCompteByNumcompte(numcompte);
	}
	
		
}
