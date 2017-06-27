package test_strutturali;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.Recensione;
import biblioteca.Sbu;
import biblioteca.UtenteRegistrato;

public class RecensioneTest {
	private static Sbu sistema = null;
	private static UtenteRegistrato u1 = null;
	private static Recensione r1 = null;

	@BeforeClass
	public static void init() {
		sistema = new Sbu("Sistema bibliotecario");
		u1 = new UtenteRegistrato("Nome", "Cognome", 
				"Indirizzo", new Date(), "codiceFiscale", "0123456", 
				"nico@email.it", "pass", sistema);
		r1 = new Recensione("Recensione1", u1);
	}

	@Test
	public void testTesto() {
		String testo = "Recensione";
		r1.setTesto(testo);
		assertEquals("Il testo della recensione deve essere aggiornato", testo,
				r1.getTesto());
	}

	@Test
	public void testAutore() {
		UtenteRegistrato u2 = new UtenteRegistrato("Nome2", "Cognome2", 
				"Indirizzo2", new Date(), "codiceFiscale2", "01234562", 
				"nico2@email.it", "pass2", sistema);
		r1.setAutore(u2);
		assertEquals("L'autore deve essere u2", u2, r1.getAutore());
	}

}
