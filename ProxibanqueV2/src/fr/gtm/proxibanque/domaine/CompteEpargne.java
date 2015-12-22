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
	 * Obtenir le taux de r�mun�ration d'un compte
	 * 
	 * @param tauxRemuneration
	 *            Taux de r�mun�ration
	 */
	public void getTauxRemuneration() {
		// TODO - implement CompteEpargne.getTauxRemuneration
		throw new UnsupportedOperationException();
	}

	/**
	 * Affecter une valeur de taux pour un compte donn�
	 * 
	 * @param tauxRemuneration
	 *            Taux de r�mun�ration
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
	 * Construire un compte �pargne avec les param�tres du compte
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