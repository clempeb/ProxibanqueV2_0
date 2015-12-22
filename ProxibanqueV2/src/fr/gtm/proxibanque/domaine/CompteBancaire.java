package fr.gtm.proxibanque.domaine;

/**
 * Classe métier (Abstraite) CompteBancaire 
 * Cette classe va servir de base pour les comptes courant et epargne
 *
 *
 */
public abstract class CompteBancaire {

	private int numCompte;
	private double solde;
	private String dateOuverture;
	private Client client;
	private String type;
	
	
	/**
	 * Récupérer le numéro de compte d'un Client donné
	 * @return numCompte Numéro de compte d'un Client
	 */
	public int getNumCompte() {
		return this.numCompte;
	}

	/**
	 * Affecter un numéro de compte à un Client donné
	 * @param numCompte Numéro de compte d'un Client
	 */
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	/**
	 * Récupérer le solde du compte d'un Client donné
	 * @return solde Solde du compte d'un Client
	 */
	public double getSolde() {
		return this.solde;
	}

	/**
	 * Affecter une valeur à un solde d'un compte d'un Client
	 * @param solde Solde du compte d'un Client
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/**
	 * Récupérer la date de l'ouverture du compte d'un Client donné
	 * @return dateOuverture Date d'ouverture du Compte
	 */
	public String getDateOuverture() {
		return this.dateOuverture;
	}

	/**
	 * Affecter une date de l'ouverture du compte d'un Client donné
	 * @param dateOuverture Date d'ouverture du Compte
	 */
	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	
	/**
	 * Récupérer le type de compte 
	 * @return type Type de Compte (Courant et Epargne)
	 */

	public String getType() {
		return type;
	}

	/**
	 * Affecter un type de compte
	 * @param type Type de Compte (Courant et Epargne)
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Obtenir un Client d'un Compte donné
	 * @return client Client de Proxibanque
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Affecter un Client à un Compte donné
	 * @return client Client de Proxibanque
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Construire un CompteBancaire (dans ses classes héritées : CompteCourant et CompteEpargne)
	 */
	public CompteBancaire() {
	}

	
	/**
	 * Construire un CompteBancaire (dans ses classes héritées : CompteCourant et CompteEpargne)
	 * @param numCompte
	 * @param solde
	 * @param dateOuverture
	 * @param client
	 */
	public CompteBancaire(int numCompte, double solde, String dateOuverture, Client client) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.client = client;
		
	}


	/**
	 * Obtenir les attributs d'un Compte
	 * @param numCompte
	 * @param solde
	 * @param dateOuverture
	 * @param client
	 */
	@Override
	public String toString() {
		return "CompteBancaire [numCompte=" + numCompte + ", solde=" + solde + ", dateOuverture=" + dateOuverture
				+ ", client=" + client.getNom() + " " + client.getPrenom() + "]";
	}




}