package fr.gtm.proxibanque.service;

import java.util.ArrayList;

import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.Conseiller;
/**
 * Interface des traitement Conseiller avant entrer en base
 * @author Adminl
 *
 */
public interface IServiceConseiller {

	public boolean verifConseiller(Conseiller cons);

	public Conseiller readConseiller(Conseiller cons);

	public ArrayList<Client> consulterListeClient(Conseiller cons);
	
}
