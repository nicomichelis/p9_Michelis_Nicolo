package test_strutturali;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.Articolo;
import biblioteca.Biblioteca;
import biblioteca.Libro;
import biblioteca.Sbu;

public class LibroTest {
	private static Sbu sistema = null;
	private static Biblioteca b1 = null;
	private static Articolo a1 = null;
	
	@BeforeClass
	public static void init() {
		sistema = new Sbu("Sistema bibliotecario");
		b1 = new Biblioteca("Biblioteca 1", "Via Biblioteca 1",
				sistema);
		sistema.getBiblioteche().add(b1);
		a1 = new Libro("Titolo1", "Autore", "Genere", 
				"Collocazione", b1, 012345 , "Casa Editrice", 150);
	}

	@Test
	public void testIsbn() {
		int newIsbn = 543210;
		((Libro) a1).setIsbn(newIsbn);
		assertEquals("ISBN deve essere il nuovo", newIsbn, ((Libro) a1).getIsbn());
	}
	
	@Test
	public void testCasaEditrice() {
		String newCasaEditrice = "newCasaEditrice";
		((Libro) a1).setCasaEditrice(newCasaEditrice);
		assertEquals("La casa editrice deve essere aggiornata", newCasaEditrice,
				((Libro) a1).getCasaEditrice());
	}

	@Test
	public void testPagine() {
		int newPagine = 100;
		((Libro) a1).setPagine(newPagine);
		assertEquals("Il numero di pagine deve essere aggiornato", newPagine,
				((Libro) a1).getPagine());
	}

}
