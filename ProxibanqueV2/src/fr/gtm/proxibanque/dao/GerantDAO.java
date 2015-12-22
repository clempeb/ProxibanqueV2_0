package fr.gtm.proxibanque.dao;

import java.util.ArrayList;

import fr.gtm.proxibanque.domaine.Agence;
import fr.gtm.proxibanque.domaine.Conseiller;
import fr.gtm.proxibanque.domaine.Entreprise;
import fr.gtm.proxibanque.domaine.Particulier;
/**
 * Implementation des méthodes présentes dans l'interface IGerantDao
 * 
 *
 */
public class GerantDAO implements IGerantDAO{
	

	public GerantDAO() {
		super();
	}

	public ArrayList<Conseiller> consulterListConseiller() {
		return DataDAO.getLsCons();
	}


	
	@Override
	public void audit(Agence a) {
		for (int i = 0; i < DataDAO.getLsCompte().size(); i++) {
			if (DataDAO.getLsCompte().get(i).getSolde() < -5000 && DataDAO.getLsCompte().get(i).getClient() instanceof Particulier && DataDAO.getLsCompte().get(i).getClient().getCons().getGerant().getA().equals(a))
				System.out.println("Compte état critique : " + DataDAO.getLsCompte().get(i));
			else if (DataDAO.getLsCompte().get(i).getSolde() < -50000 && DataDAO.getLsCompte().get(i).getClient() instanceof Entreprise && DataDAO.getLsCompte().get(i).getClient().getCons().getGerant().getA().equals(a))
				System.out.println("Compte état critique : " + DataDAO.getLsCompte().get(i));
		}
		System.out.println("Audit terminée");
	}

	/**
	 * Cree un nouveau conseiller dans la base
	 */
	@Override
	public void creerConseiller(Conseiller conseiller) {
		DataDAO.getLsCons().add(conseiller);
	}

	/**
	 * Supprime un conseiller de la base
	 */
	@Override
	public void supprimerConseiller(Conseiller conseiller) {
		DataDAO.getLsCons().remove(conseiller);
	}
/**
 * Modifie un conseiller de la base
 */
	@Override
	public void modifierConseiller(Conseiller conseillerAvant, Conseiller conseillerApres) {
		DataDAO.getLsCons().set(DataDAO.getLsCons().indexOf(conseillerAvant), conseillerApres);
		System.out.println(DataDAO.getLsCons());
	}
/**
 * Consulte la liste des conseillers de la base
 */
	@Override
	public Conseiller consulterConseiller(String nom) {
		for (int i = 0; i < DataDAO.getLsCons().size(); i++) {
			if (DataDAO.getLsCons().get(i).getNom().equals(nom))
				return DataDAO.getLsCons().get(i);
		}
		return null;
	}

}
