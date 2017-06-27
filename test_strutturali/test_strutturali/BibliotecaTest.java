package test_strutturali;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.Articolo;
import biblioteca.Biblioteca;
import biblioteca.Libro;
import biblioteca.Sbu;

public class BibliotecaTest {
	private static Sbu sistema = null;
	private static Biblioteca b1 = null;
	
	@BeforeClass
	public static void init() {
		sistema = new Sbu("Sistema bibliotecario");
		b1 = new Biblioteca("Biblioteca 1", "Via Biblioteca 1",
				sistema);
		sistema.getBiblioteche().add(b1);
	}

	@Test
	public void testRicercaArticolo1() {
		// La biblioteca non contiene elementi
		String ricerca = "No";
		ArrayList<Articolo> trovati = (ArrayList<Articolo>) 
				b1.ricercaArticolo(ricerca);
		assertTrue("La lista deve essere vuota", trovati.isEmpty());
	}
	
	@Test
	public void testRicercaArticolo2() {
		// La biblioteca contiene elementi, ma non quello cercato
		Articolo l1 = new Libro("Titolo1", "Autore", "Genere", 
				"Collocazione", b1, 012345 , "Casa Editrice", 150);
		b1.getPossiede().add(l1);
		String ricerca = "NO";
		ArrayList<Articolo> trovati = (ArrayList<Articolo>) 
				b1.ricercaArticolo(ricerca);
		assertTrue("La lista deve essere vuota", trovati.isEmpty());
	}
	
	@Test
	public void testRicercaArticolo3() {
		// La biblioteca contiene l'elemento cercato
		Articolo l1 = new Libro("Titolo1", "Autore", "Genere", 
				"Collocazione", b1, 012345 , "Casa Editrice", 150);
		b1.getPossiede().add(l1);
		String ricerca = "Titolo1";
		ArrayList<Articolo> trovati = (ArrayList<Articolo>) 
				b1.ricercaArticolo(ricerca);
		assertTrue("La lista deve contenere l1", trovati.contains(l1));
	}

	@Test
	public void testNome() {
		String nome = "NuovoNome";
		b1.setNome(nome);
		assertEquals("Il nome deve essere uguale", nome, b1.getNome());
	}

	@Test
	public void testIndirizzo() {
		String indirizzo = "NuovoIndirizzo";
		b1.setIndirizzo(indirizzo);
		assertEquals("L'indirizzo deve essere uguale", indirizzo, 
				b1.getIndirizzo());
	}

	@Test
	public void testSistema() {
		Sbu nuovaSbu = new Sbu("SBU2");
		b1.setSistema(nuovaSbu);
		assertEquals("L'SBU deve essere SBU2", nuovaSbu, 
				b1.getSistema());
	}

	@Test
	public void testGetPossiede() {
		assertNotNull("La lista non deve esser null",b1.getPossiede());
	}

	@Test
	public void testGetRecensioni() {
		assertNotNull("La lista non deve esser null",b1.getRecensioni());
	}

	@After
	public void after() {
		b1 = new Biblioteca("Biblioteca 1", "Via Biblioteca 1", sistema);
	}
}
