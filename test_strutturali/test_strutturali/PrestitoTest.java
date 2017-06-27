package test_strutturali;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.Articolo;
import biblioteca.Biblioteca;
import biblioteca.Libro;
import biblioteca.Prestito;
import biblioteca.Sbu;
import biblioteca.UtenteRegistrato;

public class PrestitoTest {
	private static Sbu sistema = null;
	private static Biblioteca b1 = null;
	private static Articolo a1 = null;
	private static UtenteRegistrato u1 = null;
	private static Prestito p1 = null;

	@BeforeClass
	public static void init() {
		sistema = new Sbu("Sistema bibliotecario");
		b1 = new Biblioteca("Biblioteca 1", "Via Biblioteca 1",
				sistema);
		sistema.getBiblioteche().add(b1);
		a1 = new Libro("Titolo1", "Autore", "Genere", 
				"Collocazione", b1, 012345 , "Casa Editrice", 150);
		u1 = new UtenteRegistrato("Nome", "Cognome", 
				"Indirizzo", new Date(), "codiceFiscale", "0123456", 
				"nico@email.it", "pass", sistema);
		sistema.getUtenti().add(u1);
		p1 = new Prestito(new Date(), new Date(), a1, u1);
		u1.getPrestiti().add(p1);
		a1.setPrestito(p1);
	}

	@Test
	public void testProlungaPrestito1() {
		// Prolungamento possibile (rinnovi non terminati)
		assertTrue("I rinnovi sono esauriti", p1.prolungaPrestito(new Date()));
	}
	
	@Test
	public void testProlungaPrestito2() {
		// Prolungamento non possibile (rinnovi terminati)
		while (p1.getRinnovi()>0) {
			p1.prolungaPrestito(new Date());
		}
		assertFalse("Il rinnovo non dovrebbe essere possibile", 
				p1.prolungaPrestito(new Date()));
	}

	@Test
	public void testRinnovi() {
		int rinnovi = 4;
		p1.setRinnovi(rinnovi);
		assertEquals("I rinnovi devono essere aggiornati", rinnovi, 
				p1.getRinnovi());
	}

	@Test
	public void testGetDataInizio() {
		assertNotNull("La data di inizio non deve esser null", 
				p1.getDataInizio());
	}

	@Test
	public void testGetDataFine() {
		assertNotNull("La data di fine non deve esser null", 
				p1.getDataFine());
	}

	@Test
	public void testGetArticolo() {
		assertNotNull("L'articolo relativo al prestito non "
				+ "deve esser null", p1.getArticolo());
	}

	@Test
	public void testGetRichiestoDa() {
		assertNotNull("L'utente relativo al prestito non "
				+ "deve esser null", p1.getRichiestoDa());
	}

}
