package fr.gtm.proxibanque.service;

import java.util.ArrayList;

import fr.gtm.proxibanque.dao.IConseillerDAO;
import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.Conseiller;

/**
 * Implementation des méthodes de l'interface IServiceConseiller 
 *
 *
 */
public class ServiceConseiller implements IServiceConseiller {

	IConseillerDAO iconsdao;
	
	public ServiceConseiller(IConseillerDAO iconsdao) {
		super();
		this.iconsdao = iconsdao;
	}

	/**
	 * Verifier si le conseiller existe bien dans la base
	 */
	@Override
	public boolean verifConseiller(Conseiller cons) {
		
		Conseiller c = iconsdao.readConseiller(cons);
		
		//test sequentiel, si le premier est false ne teste pas les suivants (null.equals() ne fonctionne pas)
		if(iconsdao.readConseiller(cons)!=null && cons.getLogin().equals(c.getLogin()) && cons.getPwd().equals(c.getPwd())){
			return true;
		} else {
			return false;
		}
		
	}
	/**
	 * 
	 * Appelle la méthode readConseiller de l'interface IserviceConseiller
	 */
	@Override
	public Conseiller readConseiller(Conseiller cons) {
		return iconsdao.readConseiller(cons);
	}
	
	/**
	 * 
	 * Appelle la méthode consulterListeClient de l'interface IserviceConseiller
	 */
	@Override
	public ArrayList<Client> consulterListeClient(Conseiller cons) {
		return iconsdao.consulterListeClient(cons);
	}

}
