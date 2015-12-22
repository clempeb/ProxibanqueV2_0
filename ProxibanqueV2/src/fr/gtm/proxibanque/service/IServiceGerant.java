package fr.gtm.proxibanque.service;

import java.util.ArrayList;

import fr.gtm.proxibanque.domaine.Agence;
import fr.gtm.proxibanque.domaine.Conseiller;
/**
 *  Interface de spécification des méthodes de ServiceGerant
 * 
 *
 */

public interface IServiceGerant {

	public void audit(Agence a);

	public ArrayList<Conseiller> consulterListConseiller();
	
	public void creerConseiller(Conseiller conseiller);
	
	public void supprimerConseiller(Conseiller conseiller);
	
	public void modifierConseiller(Conseiller conseillerAvant, Conseiller conseillerApres);

	public Conseiller consulterConseiller(String nom);
}