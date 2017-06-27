package test_strutturali;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.Articolo;
import biblioteca.Biblioteca;
import biblioteca.Miscellanea;
import biblioteca.Sbu;

public class MiscellaneaTest {
	private static Sbu sistema = null;
	private static Biblioteca b1 = null;
	private static Articolo a1 = null;
	
	@BeforeClass
	public static void init() {
		sistema = new Sbu("Sistema bibliotecario");
		b1 = new Biblioteca("Biblioteca 1", "Via Biblioteca 1",
				sistema);
		sistema.getBiblioteche().add(b1);
		a1 = new Miscellanea("Titolo1", "Autore", "Genere", 
				"Collocazione", b1, "DVD");
	}
	
	@Test
	public void testTipo() {
		String tipo = "CD";
		((Miscellanea) a1).setTipo(tipo);
		assertEquals("Il tipo della miscellanea deve essere CD", tipo, 
				((Miscellanea) a1).getTipo());
	}
}
