package test_strutturali;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.Persona;
import biblioteca.Sbu;
import biblioteca.UtenteRegistrato;

public class PersonaTest {
	private static Sbu sistema = null;
	private static Persona p1 = null;
	
	@BeforeClass
	public static void init() {
		sistema = new Sbu("Sistema bibliotecario");
		p1 = new UtenteRegistrato("Nome", "Cognome", 
				"Indirizzo", new Date(), "codiceFiscale", "0123456", 
				"nico@email.it", "pass", sistema);
	}

	@Test
	public void testRicercaPersona1() {
		String ricerca = "Nome";
		assertTrue("La persona deve essere quella cercata", 
				p1.ricercaPersona(ricerca));
	}
	
	@Test
	public void testRicercaPersona2() {
		String ricerca = "Cognome";
		assertTrue("La persona deve essere quella cercata", 
				p1.ricercaPersona(ricerca));
	}
	
	@Test
	public void testRicercaPersona4() {
		String ricerca = "codiceFiscale";
		assertTrue("La persona deve essere quella cercata", 
				p1.ricercaPersona(ricerca));
	}
	
	@Test
	public void testRicercaPersona5() {
		String ricerca = "nico@email.it";
		assertTrue("La persona deve essere quella cercata", 
				p1.ricercaPersona(ricerca));
	}
	
	@Test
	public void testRicercaPersona3() {
		String ricerca = "NO";
		assertFalse("La persona non deve esser trovata", 
				p1.ricercaPersona(ricerca));
	}

	@Test
	public void testNome() {
		String newNome = "Name";
		p1.setNome(newNome);
		assertEquals("Il nome dell'utente deve essere aggiornato", newNome,
				p1.getNome());
	}

	@Test
	public void testCognome() {
		String newCognome = "LastName";
		p1.setCognome(newCognome);
		assertEquals("Il cognome dell'utente deve essere aggiornato", 
				newCognome, p1.getCognome());
	}

	@Test
	public void testIndirizzo() {
		String newIndirizzo = "Street";
		p1.setIndirizzo(newIndirizzo);
		assertEquals("L'indirizzo dell'utente deve essere aggiornato", 
				newIndirizzo, p1.getIndirizzo());
	}

	@Test
	public void testDataNascita() {
		Date newData = new Date();
		p1.setDataNascita(newData);
		assertEquals("La data di nascita dell'utente deve essere aggiornata", 
				newData, p1.getDataNascita());
	}

	@Test
	public void testCodiceFiscale() {
		String newCf = "newCodiceFiscale";
		p1.setCodiceFiscale(newCf);
		assertEquals("Il codice fiscale dell'utente deve essere aggiornato", 
				newCf, p1.getCodiceFiscale());
	}

	@Test
	public void testTelefono() {
		String newTelefono = "987654321";
		p1.setTelefono(newTelefono);
		assertEquals("Il numero di telefono dell'utente deve essere aggiornato",
				newTelefono, p1.getTelefono());
	}

	@Test
	public void testEmail() {
		String newEmail = "email@email.it";
		p1.setEmail(newEmail);
		assertEquals("L'indirizzo email dell'utente deve essere aggiornato", 
				newEmail, p1.getEmail());
	}

	@Test
	public void testGetPassword() {
		String newPassword = "password";
		p1.setPassword(newPassword);
		assertEquals("La password dell'utente deve essere aggiornato", 
				newPassword, p1.getPassword());
	}

	@Test
	public void testSistema() {
		Sbu newSistema = new Sbu("Nuova SBU");
		p1.setSistema(newSistema);
		assertEquals("Il sistema dell'utente deve essere aggiornato", 
				newSistema, p1.getSistema());
	}
	
	@After
	public void after() {
		p1 = new UtenteRegistrato("Nome", "Cognome", 
				"Indirizzo", new Date(), "codiceFiscale", "0123456", 
				"nico@email.it", "pass", sistema);
	}

}
