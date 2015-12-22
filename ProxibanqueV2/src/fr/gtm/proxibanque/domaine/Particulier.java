package fr.gtm.proxibanque.domaine;

import java.io.Serializable;

/**
 * 
 * Classe metier Particulier
 * Herite de la classe Client
 *
 */
public class Particulier extends Client implements Serializable {

	public Particulier() {
		
	}

	/**
	 * 
	 * @param nom Nom du Particulier
	 * @param prenom Prenom du Particulier
	 * @param adresse Adresse du Particulier
	 * @param codePostal CP du Particulier
	 * @param ville Ville du Particulier
	 * @param telephone Telephone du Particulier
	 */

	public Particulier(Conseiller cons, String nom, String prenom, String email, String adresse, String codePostal, String ville, String telephone) {
		super(cons, nom, prenom, email, adresse, codePostal, ville, telephone);
	}

	public Particulier(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

}