package fr.gtm.proxibanque.domaine;
/**
 * Classe metier Conseiller
 * 
 *
 */

public class Conseiller {

	private int idCons;
	private String nom;
	private String prenom;
	private Gerant gerant;
	private String login;
	private String pwd;

/**
 * Récupérer la valeur de l'Id Unique du Conseiller
 * @return idCons Identifiant Unique d'un Conseiller
 */

	public int getIdCons() {
		return idCons;
	}

	/**
	 * 
	 * Affecter une valeur à un Id Conseiller
* @return idCons Identifiant Unique d'un Conseiller
	 */
	public void setIdCons(int idCons) {
		this.idCons = idCons;
	}

	/**
	 * Construire un Conseiller sans infos
	 */
	public Conseiller() {

	}

	/**
	 * 
	 * @param nom
	 */	
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * 
	 * @param Gerant
	 */	
	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * 
	 * @param nom
	 * @param lsClient
	 */
	public Conseiller(String nom, Gerant gerant) {
		super();
		this.nom = nom;
		this.gerant = gerant;
	}

	public Conseiller(String login, String pwd) {
		super();
		this.login = login;
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Conseiller [nom=" + nom + ", agence=" + gerant.getA().getNumId() + "]";
	}

	public Conseiller(String nom, String prenom, String login, String pwd) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.pwd = pwd;
	}



}