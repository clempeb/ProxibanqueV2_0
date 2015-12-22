package fr.gtm.proxibanque.domaine;

/**
 * Classe metier Agence
 * 
 * 
 *
 */

public class Agence {

	private int numId;
	private String dateCreation;
	private Gerant gerant = new Gerant();

	/**
	 * Renvoie le numéro unique de l'agence
	 * @param numId Numero unique de l'agence
	 */
	public int getNumId() {
		return this.numId;
	}
	/**
	 * Affecte une valeur au numéro d'agence
	 * @param numId Numero unique de l'agence
	 */
	public void setNumId(int numId) {
		this.numId = numId;
	}

	/**
	 * Renvoie la date de création de l'agence
	 * @param dateCreation Date de création de l'agence
	 */
	public String getDateCreation() {
		return this.dateCreation;
	}

	/**
	 * Affecte une date de création de l'agence
	 * @param dateCreation Date de création de l'agence
	 */
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * Renvoie un objet Gerant de l'agence
	 * @param gerant Gérant de l'agence
	 */
	public Gerant getGerant() {
		return gerant;
	}

	/**
	 * Affecte un gérant à cet agence
	 * @param gerant Gérant de l'agence 
	 */ 
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	/**
	 * Construit une agence vide
	 * 
	 */
	public Agence() {
	}

	/**
	 * Construit une agence avec paramètres
	 * @param numId Numero unique de l'agence
	 * @param dateCreation Date de création de l'agence
	 * @param gerant Gérant de l'agence
	 */
	public Agence(int numId, String dateCreation) {
		super();
		this.numId = numId;
		this.dateCreation = dateCreation;
		this.gerant = gerant;
	}
	/**
	 * Renvoie un objet String à partir d'une agence
	 */
	@Override
	public String toString() {
		return "Agence [numId=" + numId + ", dateCreation=" + dateCreation + ", gerant=" + gerant.getNom() + "]";
	}

}