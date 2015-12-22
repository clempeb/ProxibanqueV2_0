package fr.gtm.proxibanque.domaine;

/**
 * Classe metier Gerant
 *
 *
 */

public class Gerant {
	
	private Agence a;
	private String nom;

	public Gerant() {
		super();
	}
	
	/**
	 * 
	 * @param nom
	 * @param a
	 */
	public Gerant(String nom, Agence a) {
		super();
		this.nom = nom;
		this.a = a;
		a.setGerant(this);
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

	/**
	 * 
	 * @param a
	 */
	public Agence getA() {
		return a;
	}

	public void setA(Agence a) {
		this.a = a;
	}

	
	
	@Override
	public String toString() {
		return "Gerant [a=" + a.getNumId() + ", nom=" + nom + "]";
	}

}