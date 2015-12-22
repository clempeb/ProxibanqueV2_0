package fr.gtm.proxibanque.domaine;

/**
 * 
 * Classe métier Client
 *
 */

public abstract class Client {

	private Conseiller cons;
	private int idClient;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;
	private CompteCourant compteC = new CompteCourant();
	private CompteEpargne compteE = new CompteEpargne();

	/**
	 * Récupérer un conseiller d'un client donné
	 * 
	 * @return cons le conseiller chargé d'un client
	 */
	public Conseiller getCons() {
		return cons;
	}

	/**
	 * Affecte un conseiller à un Client
	 * 
	 * @param cons
	 *            le conseiller chargé d'un client
	 */
	public void setCons(Conseiller cons) {
		this.cons = cons;
	}

	/**
	 * Récupérer l'identifiant unique d'un Client
	 * 
	 * @return idClient Numero Unique de chaque Client
	 */
	public int getIdClient() {
		return idClient;
	}

	/**
	 * Affecte l'identifiant unique d'un Client
	 * 
	 * @param idClient
	 *            Numero Unique de chaque Client
	 */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	/**
	 * Récupérer le nom d'un Client
	 * 
	 * @param nom
	 *            Nom du Client
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Affecte un nom à un Client
	 * 
	 * @param nom
	 *            Nom du Client à attribuer
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Récupère le prénom d'un Client
	 * 
	 * @return prenom Prénom d'un Client
	 */

	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Affecte un prénom à un Client
	 * 
	 * @param prenom
	 *            Prénom d'un Client
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Récupère l'email d'un Client
	 * 
	 * @return email Email d'un Client
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Affecte un email à un Client
	 * 
	 * @param email
	 *            Email d'un Client
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Récupère l'adresse d'un Client
	 * 
	 * @return adresse Adresse d'un Client
	 */
	public String getAdresse() {
		return this.adresse;
	}

	/**
	 * Affecte une adresse à un Client
	 * 
	 * @param adresse
	 *            Adresse d'un Client
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Récupère le code postal d'un Client
	 * 
	 * @return codePostal Code Postal d'un Client
	 */
	public String getCodePostal() {
		return this.codePostal;
	}

	/**
	 * Affecte un code postal à un Client
	 * 
	 * @param codePostal
	 *            Code Postal d'un Client
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Récupère la ville d'un Client
	 * 
	 * @return ville Ville d'un Client
	 */
	public String getVille() {
		return this.ville;
	}

	/**
	 * Affecte une ville à un Client
	 * 
	 * @param ville
	 *            Ville d'un Client
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Récupère le numéro de telephone d'un Client
	 * 
	 * @return telephone Numero de telephone d'un Client
	 */
	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * Affecte un numéro de telephone à un Client
	 * 
	 * @param telephone Numéro de telephone d'un Client
	 *            
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Récupérer le compte Courant d'un client donné
	 * @param compteC Compte courant d'un client donné
	 */
	public CompteBancaire getCompteC() {
		return compteC;
	}
	
	
	/**
	 * Affecte un compte Courant d'un client donné
	 * @param compteC Compte courant d'un client donné
	 */
	public void setCompteC(CompteCourant compteC) {
		this.compteC = compteC;
	}
	/**
	 * Récupérer le compte Epargne d'un client donné
	 * @param compteE Compte epargne  d'un client donné
	 */
	public CompteBancaire getCompteE() {
		return compteE;
	}
	/**
	 * Affecte compte Epargne d'un client donné
	 * @param compteE Compte epargne  d'un client donné
	 */
	public void setCompteE(CompteEpargne compteE) {
		this.compteE = compteE;
	}
	
	/**
	 * Récupérer toutes les infos d'un Client
	 */

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", adresse="
				+ adresse + ", codePostal=" + codePostal + ", ville=" + ville
				+ ", telephone=" + telephone + ", n°CompteCourant="
				+ compteC.getNumCompte() + ", n°CompteEpargne="
				+ compteE.getNumCompte() + "]";
	}

	public Client() {

	}

	/**
	 * Construire un Client avant de l'entrer en base
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param telephone
	 */

	public Client(Conseiller cons, String nom, String prenom, String email,
			String adresse, String codePostal, String ville, String telephone) {
		super();
		this.cons = cons;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}

	/**
	 * Construire un Client avant de l'entrer en base
	 * @param nom
	 * @param prenom
	 */
	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
}