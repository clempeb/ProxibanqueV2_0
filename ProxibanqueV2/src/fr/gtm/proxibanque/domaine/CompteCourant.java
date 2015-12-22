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
	 * Obtenir la valeur du découvert d'un Compte
	 * @return decouvert Montant du decouvert autorisé
	 */
	public static int getDecouvert() {
		return decouvert;
	}

	/**
	 * Affecter une valeur du découvert à un Compte
	 * @param decouvert Montant du decouvert autorisé
	 */
	public void setDecouvert(int decouvert) {
		this.decouvert = decouvert;
	}

/**
 * Construire un Compte Courant à partir d'aucune infos
 */
	public CompteCourant() {
		// TODO - implement CompteCourant.CompteCourant

	}

	/**
	 * Construire un Compte Courant à partir des paramètres du Compte
	 * @param numCompte
	 * @param solde
	 * @param dateOuverture
	 * @param client
	 */
	public CompteCourant(int numCompte, double solde, String dateOuverture, Client client) {
		super(numCompte, solde, dateOuverture, client);
	}

	


}