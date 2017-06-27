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

public class UC28 {
	private static Sbu sistema = null;
	private static Biblioteca b1 = null;
	private static Articolo	a1 = null;
	private static UtenteRegistrato u1 = null;
	
	@BeforeClass
	public static void init() {
		sistema = new Sbu("Sistema bibliotecario");
		b1 = new Biblioteca("Biblioteca 1", "Via Biblioteca 1",
				sistema);
		a1 = new Libro("Titolo", "Autore", "Genere", 
				"Collocazione", b1, 012345 , "Casa Editrice", 150);
		u1 = new UtenteRegistrato("Nome", "Cognome", 
				"Indirizzo", new Date(), "codiceFiscale", "0123456", 
				"nico@email.it", "pass", sistema);
	}
	
	@Test
	public void prenotazione1() {
		a1.prenota(u1);
		assertTrue("Utente deve essere inserito nella lista prenotazioni "
				+ "dell'articolo", a1.getPrenotato().contains(u1));
	}
	
	@Test
	public void prenotazione3() {
		// Prenotazione di articolo già prenotato
		a1.prenota(u1);
		assertFalse("La prenotazione non deve essere possibile", 
				a1.prenota(u1));
	}
	
	@After
	public void after() {
		u1 = new UtenteRegistrato("Nome", "Cognome", 
				"Indirizzo", new Date(), "codiceFiscale", "0123456", 
				"nico@email.it", "pass", sistema);
		a1 = new Libro("Titolo", "Autore", "Genere", 
				"Collocazione", b1, 012345 , "Casa Editrice", 150);
	}

}
