package test_funzionali;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.Biblioteca;
import biblioteca.Bibliotecario;
import biblioteca.ManagerDiSistema;
import biblioteca.Persona;
import biblioteca.Sbu;
import biblioteca.UtenteRegistrato;

public class UC1 {
	private static Sbu sistema = null;
	private static UtenteRegistrato u1 = null;
	private static Bibliotecario b1 = null;
	private static ManagerDiSistema m1 = null;
	
	@BeforeClass
	public static void init() {
		sistema = new Sbu("Sistema bibliotecario");
		u1 = new UtenteRegistrato("Nome1", "Cognome1", 
				"Indirizzo1", new Date(), "codiceFiscale1", "01234561", 
				"email@U1.it", "pass1", sistema);
		b1 = new Bibliotecario("Nome2", "Cognome2", 
				"Indirizzo2", new Date(), "codiceFiscale2", "01234562", 
				"email@B1.it", "pass2", sistema, 
				new Biblioteca("B1","Via1",sistema));
		m1 = new ManagerDiSistema("Nome3", "Cognome3", 
				"Indirizzo3", new Date(), "codiceFiscale3", "01234563", 
				"email@M1.it", "pass3", sistema);
		sistema.inserisciUtente(u1);
		sistema.inserisciUtente(b1);
		sistema.inserisciUtente(m1);
	}
	
	@Test
	public void testLoginUtenteRegistratoCorretto() {
		String username = "email@U1.it";
		String pass = "pass1";
		Persona login = sistema.login(username, pass);
		assertNotNull("L'username e la password devono essere "
				+ "corretti", login);
	}
	
	@Test
	public void testLoginBibliotecarioCorretto() {
		String username = "email@B1.it";
		String pass = "pass2";
		Persona login = sistema.login(username, pass);
		assertNotNull("L'username e la password devono essere "
				+ "corretti", login);
	}
	
	@Test
	public void testLoginManagerDiSistemaCorretto() {
		String username = "email@M1.it";
		String pass = "pass3";
		Persona login = sistema.login(username, pass);
		assertNotNull("L'username e la password devono essere "
				+ "corretti", login);
	}

	@Test
	public void testLoginUserErrato() {
		String username = "nico@email.com";
		String pass = "pass";
		Persona login = sistema.login(username, pass);
		assertNull("L'username deve essere "
				+ "errato", login);
	}
	
	@Test
	public void testLoginPassErrata() {
		String username = "email@U1.it";
		String pass = "password";
		Persona login = sistema.login(username, pass);
		assertNull("La password deve essere "
				+ "errata", login);
	}
}
