package test_strutturali;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import biblioteca.Articolo;
import biblioteca.Biblioteca;
import biblioteca.Libro;
import biblioteca.Sbu;
import biblioteca.UtenteRegistrato;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class ArticoloTestParam {
	private static Sbu sistema = null;
	private static Biblioteca b1 = null;
	private static Articolo a1 = null;
	private static UtenteRegistrato u1 = null;
	
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"Titolo1", true},
            {"Autore", true},
            {"Genere", true},
            {"NO", false}
        });
	}
	
	@Parameter(0)
	public String search;
	
	@Parameter(1)
	public boolean result;
	
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
		new UtenteRegistrato("Nome2", "Cognome2", 
				"Indirizzo2", new Date(), "codiceFiscale2", "01234562", 
				"nico2@email.it", "pass2", sistema);
		sistema.getUtenti().add(u1);
		
	}

	@Test
	public void testRicercaArticolo1() {
		assertEquals(a1.ricercaArticolo(search), result);
	}
	
	@After
	public void after() {
		a1 = new Libro("Titolo1", "Autore", "Genere", 
				"Collocazione", b1, 012345 , "Casa Editrice", 150);
	}
}
