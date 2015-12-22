package fr.gtm.proxibanque.domaine;

/**
 * Classe metier CompteCourant : Classe fille de CompteBancaire
 * 
 *
 */
public class CompteCourant extends CompteBancaire {


	private static int decouvert = 1000;
	private final static String type = "Courant";
	
	/**
	 * Obtenir la valeur du d�couvert d'un Compte
	 * @return decouvert Montant du decouvert autoris�
	 */
	public static int getDecouvert() {
		return decouvert;
	}

	/**
	 * Affecter une valeur du d�couvert � un Compte
	 * @param decouvert Montant du decouvert autoris�
	 */
	public void setDecouvert(int decouvert) {
		this.decouvert = decouvert;
	}

/**
 * Construire un Compte Courant � partir d'aucune infos
 */
	public CompteCourant() {
		// TODO - implement CompteCourant.CompteCourant

	}

	/**
	 * Construire un Compte Courant � partir des param�tres du Compte
	 * @param numCompte
	 * @param solde
	 * @param dateOuverture
	 * @param client
	 */
	public CompteCourant(int numCompte, double solde, String dateOuverture, Client client) {
		super(numCompte, solde, dateOuverture, client);
	}

	


}