package test_funzionali;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.Biblioteca;
import biblioteca.Bibliotecario;
import biblioteca.Persona;
import biblioteca.Sbu;
import biblioteca.UtenteRegistrato;

public class UC49 {
	private static Sbu sistema = null;
	private static Biblioteca b1 = null;
	private static Bibliotecario u1 = null;
	
	@BeforeClass
	public static void init() {
		sistema = new Sbu("Sistema bibliotecario");
		b1 = new Biblioteca("Biblioteca 1", "Via Biblioteca 1",
				sistema);
		sistema.getBiblioteche().add(b1);
	}
	
	@Test
	public void testInserimento1() {
		// Se non presente nessuno
		u1 = new Bibliotecario("Nome", "Cognome", "Indirizzo", 
				new Date(), "codiceFiscale", "0123456", "nico@email.it",
				"pass", sistema, b1);
		sistema.inserisciUtente(u1);
		assertTrue("Il bibliotecario deve essere nell'elenco utenti del sistema",
				sistema.getUtenti().contains(u1));
	}
	
	@Test
	public void testInserimento2() {
		// Se presente un altro utente
		sistema.inserisciUtente(new UtenteRegistrato("Nome2", "Cognome2", 
				"Indirizzo2", new Date(), "codiceFiscale2", "01234562", 
				"nico2@email.it", "pass2", sistema));
		u1 = new Bibliotecario("Nome", "Cognome", "Indirizzo", 
				new Date(), "codiceFiscale", "0123456", "nico@email.it",
				"pass", sistema, b1);
		sistema.inserisciUtente(u1);
		assertTrue("Il bibliotecario deve essere nell'elenco utenti del sistema",
				sistema.getUtenti().contains(u1));
	}
	
	@Test
	public void testInserimento3() {
		// Se utente gia presente
		u1 = new Bibliotecario("Nome", "Cognome", "Indirizzo", 
				new Date(), "codiceFiscale", "0123456", "nico@email.it",
				"pass", sistema, b1);
		sistema.inserisciUtente(u1);
		assertFalse("Il bibliotecario NON deve essere reinserito",
				sistema.inserisciUtente(u1));
	}
	
	@Test
	public void testInserimento4() {
		// Se email gia presente
		u1 = new Bibliotecario("Nome", "Cognome", "Indirizzo", 
				new Date(), "codiceFiscale", "0123456", "nico@email.it",
				"pass", sistema, b1);
		sistema.inserisciUtente(u1);
		Persona u2 = new Bibliotecario("Nome2", "Cognome2", "Indirizzo2", 
				new Date(), "codiceFiscale2", "01234562", "nico@email.it",
				"pass2", sistema, b1);
		assertFalse("Il bibliotecario NON deve essere inserito",
				sistema.inserisciUtente(u2));
	}
	
	@After
	public void after() {
		sistema = new Sbu("Sistema bibliotecario");
		b1 = new Biblioteca("Biblioteca 1", "Via Biblioteca 1",
				sistema);
		sistema.getBiblioteche().add(b1);
	}

}
