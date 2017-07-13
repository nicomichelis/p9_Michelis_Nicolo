package test_funzionali;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.Articolo;
import biblioteca.Biblioteca;
import biblioteca.Libro;
import biblioteca.Recensione;
import biblioteca.Sbu;
import biblioteca.UtenteRegistrato;

public class UC34 {
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
		// Inserimento recensione da visualizzare
		a1.scriviRecensione("Recensione",u1);
	}
	
	@Test
	public void testVisualizza() {
		// Ricerco Libro Titolo1 e viene selezionato il primo trovato
		String ricerca = "Titolo1";
		ArrayList<Articolo> articoliTrovati = (ArrayList<Articolo>) 
				sistema.ricercaArticolo(ricerca);
		Articolo articolo = articoliTrovati.get(0);
		Recensione recensione = articolo.getRecensioni().get(0);
		assertTrue("La lista recensioni deve contenere la recensione",
				a1.getRecensioni().contains(recensione));
	}
}
