package test_funzionali;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.Articolo;
import biblioteca.Biblioteca;
import biblioteca.Libro;
import biblioteca.Recensione;
import biblioteca.Sbu;
import biblioteca.UtenteRegistrato;

public class UC35 {
	private static Sbu sistema = null;
	private static Biblioteca b1 = null;
	private static Articolo	a1 = null;
	private static UtenteRegistrato u1 = null;
	private static Recensione r1 = null;
	
	@BeforeClass
	public static void init() {
		sistema = new Sbu("Sistema bibliotecario");
		b1 = new Biblioteca("Biblioteca 1", "Via Biblioteca 1",
				sistema);
		sistema.getBiblioteche().add(b1);
		a1 = new Libro("Titolo1", "Autore", "Genere", 
				"Collocazione", b1, 012345 , "Casa Editrice", 150);
		b1.getPossiede().add(a1);
		u1 = new UtenteRegistrato("Nome", "Cognome", 
				"Indirizzo", new Date(), "codiceFiscale", "0123456", 
				"nico@email.it", "pass", sistema);
	}

	@Test
	public void testModificaRecensione1() {
		// Una recensione presente di u1
		r1 = new Recensione("Recensione", u1);
		a1.inserisciRecensione(r1);
		assertTrue("La recensione deve essere modificata correttamente",
				a1.modificaRecensione(u1, "NuovaRecensione"));
	}
	
	@Test
	public void testModificaRecensione2() {
		/* 
		 * Una recensione presente di u1, cerco di modificare una di
		 * u2 (non presente) 
		 */
		UtenteRegistrato u2 = new UtenteRegistrato("Nome2", "Cognome2", 
				"Indirizzo2", new Date(), "codiceFiscale2", "01234562", 
				"nico2@email.it", "pass2", sistema);
		r1 = new Recensione("Recensione", u1);
		a1.inserisciRecensione(r1);
		assertFalse("La recensione NON deve essere modificata",
				a1.modificaRecensione(u2, "NuovaRecensione"));
	}
	
	@Test
	public void testModificaRecensione3() {
		// Una recensione presente di u1, la modifico con una lunga
		r1 = new Recensione("Recensione", u1);
		a1.inserisciRecensione(r1);
		assertFalse("La recensione NON deve essere modificata correttamente",
				a1.modificaRecensione(u1, 
						"NuovaRecensionePiuLungaDiVentiCaratteri"));
	}
	
	@After
	public void after() {
		a1 = new Libro("Titolo1", "Autore", "Genere", 
				"Collocazione", b1, 012345 , "Casa Editrice", 150);
	}
}
