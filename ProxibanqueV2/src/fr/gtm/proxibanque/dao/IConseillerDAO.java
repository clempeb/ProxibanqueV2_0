package fr.gtm.proxibanque.dao;

import java.util.ArrayList;

import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.Conseiller;
/**
 *  Interface de spécification des méthodes présentes dans la Classe ConseillerDao
 * 
 *
 */
public interface IConseillerDAO {

	public Conseiller readConseiller(Conseiller cons);

	public ArrayList<Client> consulterListeClient(Conseiller cons);
	
}
