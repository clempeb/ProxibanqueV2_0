package fr.gtm.proxibanque.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.gtm.proxibanque.dao.ClientDAO;
import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.Particulier;

public class ClientDAOTest {
	
	static ClientDAO cdao;
	static Client client;
	
	@BeforeClass
	public static void init() {
		cdao = new ClientDAO();
		client = new Particulier("popo","popo");
	}
	
	
	@Test
	public void testTypeReadClient() {
		
//		Client clilu = cdao.consulterClient(client);
		assertTrue(cdao.consulterClient(client) instanceof Client);
	}

	@Test
	public void testNotNullReadClient() {
		assertNotNull(cdao.consulterClient(client));
	}
	
	
	public void testInsertClient() {
		Client cl = new Particulier();
		try {
			cdao.creerClient(cl);
		} catch (Exception e) {
			assertTrue(e instanceof SQLException);
		}
	}
	
}
