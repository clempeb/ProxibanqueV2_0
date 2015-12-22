package fr.gtm.proxibanque.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * Classe présentant des méthodes de connexion et deconnexion
 *
 */
public class DBConnect {
	static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	static String login = "userpb";
	static String password = "userpb";
	static Connection cn = null;

	/**
	 * Envoie une connexion à la base
	 * @return
	 */
	public static Connection connect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			cn = DriverManager.getConnection(url, login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cn;
	}
	/**
	 * Déconnecte la base 
	 * @return
	 */
	public static void disconnect(Connection cn) {
		try {
			cn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
