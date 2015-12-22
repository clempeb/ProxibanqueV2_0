package fr.gtm.proxibanque.dao;

import java.util.ArrayList;

import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.Conseiller;

/**
 * Interface de spécification des méthodes présentes dans la Classe ClientDao
 * 
 *
 */
public interface IClientDAO {
	
	public void creerClient(Client client);
	
	public void supprimerClient(Client client);
	
	public void modifierClient(Client clientAvant, Client clientApres);

	public Client consulterClient(Client client);

	public ArrayList<Client> consulterAllClient(Conseiller cons);
}
