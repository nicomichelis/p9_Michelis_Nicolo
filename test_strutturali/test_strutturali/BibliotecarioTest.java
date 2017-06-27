package test_strutturali;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.Biblioteca;
import biblioteca.Bibliotecario;
import biblioteca.Sbu;

public class BibliotecarioTest {
	private static Sbu sistema = null;
	private static Biblioteca b1 = null;
	private static Bibliotecario p1 = null;

	@BeforeClass
	public static void init() {
		sistema = new Sbu("Sistema bibliotecario");
		b1 = new Biblioteca("Biblioteca 1", "Via Biblioteca 1",
				sistema);
		sistema.getBiblioteche().add(b1);
		p1 = new Bibliotecario("Nome", "Cognome", 
				"Indirizzo", new Date(), "codiceFiscale", "0123456", 
				"nico@email.it", "pass", sistema,b1);
		sistema.getUtenti().add(p1);
	}
	
	@Test
	public void testBibliotecaRiferimento() {
		Biblioteca b2 = new Biblioteca("Biblioteca 1", "Via Biblioteca 1",
				sistema);
		p1.setBibliotecaRiferimento(b2);
		assertEquals("La biblioteca di riferimento deve essere b2", b2, 
				p1.getBibliotecaRiferimento());
		
	}

}
