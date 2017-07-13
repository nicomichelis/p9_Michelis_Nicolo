package test_strutturali;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.Sbu;
import biblioteca.UtenteRegistrato;

public class SbuTest {
	private static Sbu sistema = null;
	private static UtenteRegistrato u1 = null;
	
	@BeforeClass
	public static void init() {
		sistema = new Sbu("Sistema bibliotecario");
		u1 = new UtenteRegistrato("Nome", "Cognome", 
				"Indirizzo", new Date(), "codiceFiscale", "0123456", 
				"nico@email.it", "pass", sistema);
	}

	@Test
	public void testSbu() {
		assertNotNull("sistema non deve essere null", sistema);
	}

	@Test
	public void testInserisciUtente1() {
		// L'utente non è presente nel sistema
		assertTrue("L'utente deve essere inserito nel sistema",
				sistema.inserisciUtente(u1));
	}
	
	@Test
	public void testInserisciUtente2() {
		// L'utente è presente nel sistema
		sistema.inserisciUtente(u1);
		assertFalse("L'utente non deve essere inserito nel sistema",
				sistema.inserisciUtente(u1));
	}
	
	@Test
	public void testInserisciUtente3() {
		// utente con codice fiscale uguale gia presente nel sistema
		sistema.inserisciUtente(new UtenteRegistrato("Nome2", "Cognome2", 
				"Indirizzo2", new Date(), "codiceFiscale2", "01234562", 
				"nico2@email.it", "pass2", sistema));
		sistema.inserisciUtente(u1);
		assertFalse("L'utente non deve essere inserito nel sistema",
				sistema.inserisciUtente(new UtenteRegistrato("Nome3", "Cognome3", 
						"Indirizzo3", new Date(), "codiceFiscale2", "01234563", 
						"nico3@email.it", "pass3", sistema)));
	}
	
	@Test
	public void testInserisciUtente4() {
		// utente con email uguale gia presente nel sistema
		sistema.inserisciUtente(new UtenteRegistrato("Nome2", "Cognome2", 
				"Indirizzo2", new Date(), "codiceFiscale2", "01234562", 
				"nico2@email.it", "pass2", sistema));
		sistema.inserisciUtente(u1);
		assertFalse("L'utente non deve essere inserito nel sistema",
				sistema.inserisciUtente(new UtenteRegistrato("Nome3", "Cognome3", 
						"Indirizzo3", new Date(), "codiceFiscale3", "01234563", 
						"nico2@email.it", "pass3", sistema)));
	}

	@Test
	public void testRimuoviUtente1() {
		// L'utente è presente nel sistema
		sistema.inserisciUtente(u1);
		assertTrue("L'utente deve essere rimosso nel sistema",
				sistema.rimuoviUtente(u1));
	}
	
	@Test
	public void testRimuoviUtente2() {
		// L'utente non è presente nel sistema
		assertFalse("L'utente NON deve essere rimosso nel sistema",
				sistema.rimuoviUtente(u1));
	}

	@Test
	public void testNome() {
		String nome = "nuovoNomeSBU";
		sistema.setNome(nome);
		assertEquals("Il nome deve essere aggiornato", nome, 
				sistema.getNome());
	}
	
	@Test
	public void testGetListaConsigli() {
		assertNotNull("La lista dei consigli non deve esser null", 
				sistema.getListaConsigli());
	}

	@Test
	public void testGetRecensioni() {
		assertNotNull("La lista delle recensioni non deve esser null",
				sistema.getRecensioni());
	}

	@Test
	public void testGetBiblioteche() {
		assertNotNull("La lista dele Biblioteche non deve esser null", 
				sistema.getBiblioteche());
	}

	@Test
	public void testGetUtenti() {
		assertNotNull("La lista degli utenti non deve esser null", 
				sistema.getUtenti());
	}
	
	@After
	public void after() {
		sistema = new Sbu("Sistema bibliotecario");
	}

}
