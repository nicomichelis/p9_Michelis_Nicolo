package test_strutturali;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.Articolo;
import biblioteca.Biblioteca;
import biblioteca.Libro;
import biblioteca.Sbu;
import biblioteca.UtenteRegistrato;

public class UtenteRegistratoTest {
	private static Sbu sistema = null;
	private static UtenteRegistrato u1 = null;
	private static Biblioteca b1 = null;
	private static Articolo a1 = null;
	
	@BeforeClass
	public static void init() {
		sistema = new Sbu("Sistema bibliotecario");
		u1 = new UtenteRegistrato("Nome", "Cognome", 
				"Indirizzo", new Date(), "codiceFiscale", "0123456", 
				"nico@email.it", "pass", sistema);
		sistema.inserisciUtente(u1);
		b1 = new Biblioteca("Biblioteca 1", "Via Biblioteca 1",
				sistema);
		sistema.getBiblioteche().add(b1);
		a1 = new Libro("Titolo1", "Autore", "Genere", 
				"Collocazione", b1, 012345 , "Casa Editrice", 150);
		b1.getPossiede().add(a1);
	}

	@Test
	public void testInserisciPrenotazione1() {
		// Articolo non ancora prenotato
		u1.inserisciPrenotazione(a1);
		assertTrue("La lista prenotazioni deve contenere l'articolo", 
				u1.getPrenotazioni().contains(a1));
	}
	
	@Test
	public void testInserisciPrenotazione2() {
		// Articolo prenotato 2 volte
		u1.inserisciPrenotazione(a1);
		assertFalse("La prenotazione non deve avvenire una seconda volta", 
				u1.inserisciPrenotazione(a1));
	}
	
	@Test
	public void testRimuoviPrenotazione() {
		u1.inserisciPrenotazione(a1);
		u1.rimuoviPrenotazione(a1);
		assertFalse("La lista prenotazioni NON deve contenere l'articolo", 
				u1.getPrenotazioni().contains(a1));
	}


	@Test
	public void testGetPrestiti() {
		assertNotNull("La lista prestiti non deve essere null", 
				u1.getPrestiti());
	}

	@Test
	public void testGetPrenotazioni() {
		assertNotNull("La lista prenotazioni non deve essere null", 
				u1.getPrenotazioni());
	}
	
	@After
	public void after() {
		u1 = new UtenteRegistrato("Nome", "Cognome", 
				"Indirizzo", new Date(), "codiceFiscale", "0123456", 
				"nico@email.it", "pass", sistema);
	}

}
