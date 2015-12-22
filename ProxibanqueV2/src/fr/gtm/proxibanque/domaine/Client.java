package fr.gtm.proxibanque.domaine;

/**
 * 
 * Classe m�tier Client
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
	 * R�cup�rer un conseiller d'un client donn�
	 * 
	 * @return cons le conseiller charg� d'un client
	 */
	public Conseiller getCons() {
		return cons;
	}

	/**
	 * Affecte un conseiller � un Client
	 * 
	 * @param cons
	 *            le conseiller charg� d'un client
	 */
	public void setCons(Conseiller cons) {
		this.cons = cons;
	}

	/**
	 * R�cup�rer l'identifiant unique d'un Client
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
	 * R�cup�rer le nom d'un Client
	 * 
	 * @param nom
	 *            Nom du Client
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Affecte un nom � un Client
	 * 
	 * @param nom
	 *            Nom du Client � attribuer
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * R�cup�re le pr�nom d'un Client
	 * 
	 * @return prenom Pr�nom d'un Client
	 */

	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Affecte un pr�nom � un Client
	 * 
	 * @param prenom
	 *            Pr�nom d'un Client
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * R�cup�re l'email d'un Client
	 * 
	 * @return email Email d'un Client
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Affecte un email � un Client
	 * 
	 * @param email
	 *            Email d'un Client
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * R�cup�re l'adresse d'un Client
	 * 
	 * @return adresse Adresse d'un Client
	 */
	public String getAdresse() {
		return this.adresse;
	}

	/**
	 * Affecte une adresse � un Client
	 * 
	 * @param adresse
	 *            Adresse d'un Client
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * R�cup�re le code postal d'un Client
	 * 
	 * @return codePostal Code Postal d'un Client
	 */
	public String getCodePostal() {
		return this.codePostal;
	}

	/**
	 * Affecte un code postal � un Client
	 * 
	 * @param codePostal
	 *            Code Postal d'un Client
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * R�cup�re la ville d'un Client
	 * 
	 * @return ville Ville d'un Client
	 */
	public String getVille() {
		return this.ville;
	}

	/**
	 * Affecte une ville � un Client
	 * 
	 * @param ville
	 *            Ville d'un Client
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * R�cup�re le num�ro de telephone d'un Client
	 * 
	 * @return telephone Numero de telephone d'un Client
	 */
	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * Affecte un num�ro de telephone � un Client
	 * 
	 * @param telephone Num�ro de telephone d'un Client
	 *            
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * R�cup�rer le compte Courant d'un client donn�
	 * @param compteC Compte courant d'un client donn�
	 */
	public CompteBancaire getCompteC() {
		return compteC;
	}
	
	
	/**
	 * Affecte un compte Courant d'un client donn�
	 * @param compteC Compte courant d'un client donn�
	 */
	public void setCompteC(CompteCourant compteC) {
		this.compteC = compteC;
	}
	/**
	 * R�cup�rer le compte Epargne d'un client donn�
	 * @param compteE Compte epargne  d'un client donn�
	 */
	public CompteBancaire getCompteE() {
		return compteE;
	}
	/**
	 * Affecte compte Epargne d'un client donn�
	 * @param compteE Compte epargne  d'un client donn�
	 */
	public void setCompteE(CompteEpargne compteE) {
		this.compteE = compteE;
	}
	
	/**
	 * R�cup�rer toutes les infos d'un Client
	 */

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", adresse="
				+ adresse + ", codePostal=" + codePostal + ", ville=" + ville
				+ ", telephone=" + telephone + ", n�CompteCourant="
				+ compteC.getNumCompte() + ", n�CompteEpargne="
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