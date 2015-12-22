package fr.gtm.proxibanque.dao;

import java.util.ArrayList;

import fr.gtm.proxibanque.domaine.Agence;
import fr.gtm.proxibanque.domaine.Conseiller;
/**
 *  Interface de sp�cification des m�thodes pr�sentes dans la Classe GerantDao
 * 
 *
 */
public interface IGerantDAO {
	
	public void audit(Agence a);

	public ArrayList<Conseiller> consulterListConseiller();
	
	public void creerConseiller(Conseiller conseiller);
	
	public void supprimerConseiller(Conseiller conseiller);
	
	public void modifierConseiller(Conseiller conseillerAvant, Conseiller conseillerApres);

	public Conseiller consulterConseiller(String nom);
}

