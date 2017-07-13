package test_strutturali;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.Articolo;
import biblioteca.Biblioteca;
import biblioteca.Libro;
import biblioteca.Prestito;
import biblioteca.Recensione;
import biblioteca.Sbu;
import biblioteca.UtenteRegistrato;

public class ArticoloTest {
	private static Sbu sistema = null;
	private static Biblioteca b1 = null;
	private static Articolo a1 = null;
	private static UtenteRegistrato u1 = null;
	private static UtenteRegistrato u2 = null;
	private static Recensione r1 = null;
	private static Recensione r2 = null;

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
		u2 = new UtenteRegistrato("Nome2", "Cognome2", 
				"Indirizzo2", new Date(), "codiceFiscale2", "01234562", 
				"nico2@email.it", "pass2", sistema);
		sistema.getUtenti().add(u1);
		r1 = new Recensione("Recensione1", u1);
		new Prestito(new Date(), new Date(), a1, u1);
		r2 = new Recensione("Recensione2", u2);
	}

	@Test
	public void testInserisciRecensione1() {
		// Nessuna recensione presente
		a1.inserisciRecensione(r1);
		assertTrue("l'articolo deve contenere la recensione",
				a1.getRecensioni().contains(r1));
	}
	
	@Test
	public void testInserisciRecensione2() {
		// Una recensione dello stesso autore gia presente
		a1.inserisciRecensione(r1);
		a1.inserisciRecensione(r1);
		assertTrue("l'articolo deve contenere la recensione",
				a1.getRecensioni().contains(r1));
	}
	
	@Test
	public void testInserisciRecensione3() {
		// Una recensione di un altro autore gia presente
		a1.inserisciRecensione(r2);
		a1.inserisciRecensione(r1);
		assertTrue("l'articolo deve contenere la recensione r1", 
				a1.getRecensioni().contains(r1));
	}

	@Test
	public void testRimuoviRecensione1() {
		// Non sono presenti recensioni
		a1.rimuoviRecensione(u1);
		assertFalse("L'articolo non contiene recensioni dell'utente",
				a1.getRecensioni().contains(r1));
	}
	
	@Test
	public void testRimuoviRecensione2() {
		// Presente una recensione di u1, la rimuovo
		a1.inserisciRecensione(r1);
		a1.rimuoviRecensione(u1);
		assertFalse("L'articolo non contiene recensioni dell'utente",
				a1.getRecensioni().contains(r1));
	}

	@Test
	public void testRimuoviRecensione3() {
		// Presente una recensione di u1 ma rimuovo quelle di u2
		a1.inserisciRecensione(r1);
		a1.rimuoviRecensione(u2);
		assertTrue("L'articolo contiene recensioni dell'utente",
				a1.getRecensioni().contains(r1));
	}
	
	@Test
	public void testModificaRecensione1() {
		// Presente una recensione di u1 e la modifico
		a1.inserisciRecensione(r1);
		a1.modificaRecensione(u1,"NuovaRecensione");
		assertEquals("L'articolo contiene la recensione dell'utente",
				a1.getRecensioni().get(0).getTesto(), "NuovaRecensione");
	}
	
	@Test
	public void testModificaRecensione2() {
		// Non presenti recensioni ma provo a modificarne una
		assertFalse("Recensione non modificabile",
				a1.modificaRecensione(u1,"NuovaRecensione"));
	}
	
	@Test
	public void testModificaRecensione3() {
		// Presenti recensioni di altri utenti ma provo a modificarne una
		a1.inserisciRecensione(new Recensione("Recensione",u2));
		assertFalse("Recensione non modificabile",
				a1.modificaRecensione(u1,"NuovaRecensione"));
	}
	
	@Test
	public void testModificaRecensione4() {
		// Recensione troppo lunga
		assertFalse("Recensione non modificabile",
				a1.modificaRecensione(u1,
						"NuovaRecensioneLungaPiuDiVentiCaratteri"));
	}
	
	@Test
	public void testPrenota1() {
		a1.prenota(u1);
		assertTrue("L'utente deve essere nella lista prenotazioni",
				a1.getPrenotato().contains(u1));
	}
	
	@Test
	public void testPrenota2() {
		a1.prenota(u1);
		assertFalse("L'utente non prenota piu volte",
				a1.prenota(u1));
	}

	@Test
	public void testRimuoviPrenotazione1() {
		a1.rimuoviPrenotazione(u1);
		assertFalse("L'utente non deve essere nella lista",
				a1.getPrenotato().contains(u1));
	}
	
	@Test
	public void testRimuoviPrenotazione2() {
		a1.prenota(u1);
		assertTrue("L'utente deve essere rimosso", a1.rimuoviPrenotazione(u1));
	}

	@Test
	public void testScriviRecensione() {
		a1.scriviRecensione("Recensione", u2);
	}
	
	@Test
	public void testTitolo() {
		String titolo = "NuovoTitolo";
		a1.setTitolo(titolo);
		assertEquals("I titoli devono essere uguali", titolo, 
				a1.getTitolo());
	}

	@Test
	public void testAutore() {
		String autore = "NuovoAutore";
		a1.setAutore(autore);
		assertEquals("Gli autori devono essere uguali", autore, 
				a1.getAutore());
	}

	@Test
	public void testGenere() {
		String genere = "NuovoGenere";
		a1.setGenere(genere);
		assertEquals("I generi devono essere uguali", genere, 
				a1.getGenere());
	}

	@Test
	public void testCollocazione() {
		String collocazione = "NuovaCollocazione";
		a1.setCollocazione(collocazione);
		assertEquals("Le collocazioni devono essere uguali", collocazione, 
				a1.getCollocazione());
	}
	
	@Test
	public void testGetRecensioni() {
		assertNotNull("La lista non deve essere null", 
				a1.getRecensioni());
	}

	@Test
	public void testBiblio() {
		Biblioteca biblio = new Biblioteca("Biblioteca 2", "Via Biblioteca 2",
				sistema);
		a1.setBiblio(biblio);
		assertEquals("Le biblioteche devono essere uguali", biblio, 
				a1.getBiblio());
	}

	@Test
	public void testPrestito() {
		Prestito prestito = new Prestito(new Date(), new Date(), a1, u1);
		a1.setPrestito(prestito);
		assertEquals("Il prestito deve essere lo stesso", prestito, 
				a1.getPrestito());
	}
	
	@After
	public void after() {
		a1 = new Libro("Titolo1", "Autore", "Genere", 
				"Collocazione", b1, 012345 , "Casa Editrice", 150);
	}
}
