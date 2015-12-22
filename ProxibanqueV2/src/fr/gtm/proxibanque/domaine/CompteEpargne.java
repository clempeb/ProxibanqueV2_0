package fr.gtm.proxibanque.domaine;
/**
 * Classe metier CompteEpargne : Classe fille de CompteBancaire
 * 
 *
 */

public class CompteEpargne extends CompteBancaire {

	private static double tauxRemuneration = 0.03;
	private final String type = "Epargne";

	/**
	 * Obtenir le taux de rémunération d'un compte
	 * 
	 * @param tauxRemuneration
	 *            Taux de rémunération
	 */
	public void getTauxRemuneration() {
		// TODO - implement CompteEpargne.getTauxRemuneration
		throw new UnsupportedOperationException();
	}

	/**
	 * Affecter une valeur de taux pour un compte donné
	 * 
	 * @param tauxRemuneration
	 *            Taux de rémunération
	 */

	public static void setTauxRemuneration(double tauxRemuneration) {
		CompteEpargne.tauxRemuneration = tauxRemuneration;
	}

	/**
	 * Construire un Compte Epargne sans infos
	 */
	public CompteEpargne() {
		super();
	}

	/**
	 * Construire un compte épargne avec les paramètres du compte
	 * 
	 * @param numCompte
	 * @param solde
	 * @param dateOuverture
	 * @param client
	 */
	public CompteEpargne(int numCompte, double solde, String dateOuverture,
			Client client) {
		super(numCompte, solde, dateOuverture, client);
		// TODO fixer le type
	}

}