package test_funzionali;

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

public class UC33 {
	private static Sbu sistema = null;
	private static Biblioteca b1 = null;
	private static Articolo	a1 = null;
	private static UtenteRegistrato u1 = null;
	
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
		sistema.getUtenti().add(u1);
	}
	
	@Test
	public void addRecensione1() {
		// Nuova recensione
		assertTrue("Recensione deve essere inserita correttamente", 
				a1.scriviRecensione("Recensione",u1));
	}

	@Test
	public void addRecensione2() {
		// Recensione dell'utente gia inserita
		a1.scriviRecensione("Recensione",u1);
		assertTrue("NuovaRecensione deve essere inserita correttamente", 
				a1.scriviRecensione("NuovaRecensione",u1));
	}

	@Test
	public void addRecensione3() {
		// Recensione di un altro utente gia inserita
		UtenteRegistrato u2 = new UtenteRegistrato("Nome2", "Cognome2", 
				"Indirizzo2", new Date(), "codiceFiscale2", "01234562", 
				"nico2@email.it", "pass2", sistema);
		a1.scriviRecensione("RecensioneU2",u2);
		assertTrue("Recensione deve essere inserita correttamente", 
				a1.scriviRecensione("RecensioneU1",u1));
	}
	
	@Test
	public void addRecensione4() {
		// Nuova recensione troppo lunga
		assertFalse("Recensione NON deve essere inserita", 
				a1.scriviRecensione("RecensionePiuLungaDiVentiCaratteri",u1));
	}
	
	@After
	public void after() {
		a1 = new Libro("Titolo1", "Autore", "Genere", 
				"Collocazione", b1, 012345 , "Casa Editrice", 150);
	}
}
