package fr.gtm.proxibanque.domaine;

/**
 * Classe métier Entreprise
 * Herite de la classe Client
 * 
 *
 */


public class Entreprise extends Client {

	public Entreprise() {
	
	}

	

	/**
	 * 
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param telephone
	 */
	
	public Entreprise(Conseiller cons, String nom, String prenom, String email, String adresse, String codePostal, String ville, String telephone) {
		super(cons, nom, prenom, email, adresse, codePostal, ville, telephone);
		// TODO Auto-generated constructor stub
	}


}