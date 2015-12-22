package fr.gtm.proxibanque.service;

import java.util.ArrayList;

import fr.gtm.proxibanque.dao.IGerantDAO;
import fr.gtm.proxibanque.domaine.*;
/**
 * Implementation des méthodes de l'interface IServiceGerant
 *
 *
 */
public class ServiceGerant implements IServiceGerant {

	IGerantDAO ig;

	/**
	 * Construit un ServiceGerant
	 * @param ig
	 */
	public ServiceGerant(IGerantDAO ig) {
		super();
		this.ig = ig;
	}
	/**
	 * 
	 * Appelle la méthode audit de l'interface IserviceGerant
	 */
	@Override
	public void audit(Agence a) {
		ig.audit(a);
	}
	/**
	 * 
	 * Appelle la méthode consulterListConseiller de l'interface IserviceGerant
	 */
	public ArrayList<Conseiller> consulterListConseiller(){
		return ig.consulterListConseiller();
	}
	/**
	 * 
	 * Appelle la méthode creerConseiller de l'interface IserviceGerant
	 */
	public void creerConseiller(Conseiller conseiller) {
		ig.creerConseiller(conseiller);
	}
	/**
	 * 
	 * Appelle la méthode supprimerConseiller de l'interface IserviceGerant
	 */
	public void supprimerConseiller(Conseiller conseiller) {
		ig.supprimerConseiller(conseiller);
	}
	/**
	 * 
	 * Appelle la méthode modifierConseiller de l'interface IserviceGerant
	 */
	public void modifierConseiller(Conseiller conseillerAvant, Conseiller conseillerApres) {
		ig.modifierConseiller(conseillerAvant, conseillerApres);
	}
	/**
	 * 
	 * Appelle la méthode consulterConseiller de l'interface IserviceGerant
	 */
	public Conseiller consulterConseiller(String nom) {
		return ig.consulterConseiller(nom);
	}

}