package fr.gtm.proxibanque.service;



import java.util.ArrayList;


import fr.gtm.proxibanque.dao.IClientDAO;
import fr.gtm.proxibanque.domaine.*;

/**
 * Implementation des m�thodes de l'interface IServiceClient
 * 
 *
 */
public class ServiceClient implements IServiceClient {

	IClientDAO icdao;

	/**
	 * Cr�e un Objet ServiceClient
	 * @param icdao
	 */
	public ServiceClient(IClientDAO icdao) {
		super();
		this.icdao = icdao;
	}
	

	@Override
	/**
	 * Consulte si le Client existe en base et l'envoie � la Dao Client pour sa cr�ation dans le cas positif
	 * 
	 */
	public boolean creerClient(Client client) {
		if(consulterClient(client) == null) {
			icdao.creerClient(client);
			return true;
		}
		return false;
	}

	
	
	/**
	 * Appele la m�thode supprimerClient de la classe ClientDao
	 * 
	 */
	@Override
	public void supprimerClient(Client client) {
		icdao.supprimerClient(client);
	}

	/**
	 * Appele la m�thode modifierClient de la classe ClientDao
	 * 
	 */
	@Override
	public void modifierClient(Client clientAvant, Client clientApres) {
		icdao.modifierClient(clientAvant, clientApres);
	}

	/**
	 * Appele la m�thode consulterClient de la classe ClientDao
	 * 
	 */
	@Override
	public Client consulterClient(Client client) {
		return icdao.consulterClient(client);
	}

	/**
	 * Appele la m�thode consulterAllCLient de la classe ClientDao
	 * 
	 */
	@Override
	public ArrayList<Client> consulterAllClient(Conseiller cons) {
		return icdao.consulterAllClient(cons);
	}



}