package fr.gtm.proxibanque.dao;

import java.util.ArrayList;

import fr.gtm.proxibanque.domaine.*;

/**
 * 
 * Données de la Dao servant à jouer avec les données
 */
public class DataDAO {
	
	private static ArrayList<Conseiller> lsCons = new ArrayList<Conseiller>();
	private static ArrayList<Client> lsClient = new ArrayList<Client>();
	private static ArrayList<CompteBancaire> lsCompte = new ArrayList<CompteBancaire>();
	
	public static ArrayList<Conseiller> getLsCons() {
		return lsCons;
	}
	public static void setLsCons(ArrayList<Conseiller> lsCons) {
		DataDAO.lsCons = lsCons;
	}
	public static ArrayList<Client> getLsClient() {
		return lsClient;
	}
	public static void setLsClient(ArrayList<Client> lsClient) {
		DataDAO.lsClient = lsClient;
	}
	protected static ArrayList<CompteBancaire> getLsCompte() {
		return lsCompte;
	}
	protected static void setLsCompte(ArrayList<CompteBancaire> lsCompte) {
		DataDAO.lsCompte = lsCompte;
	}
	
	
}
