package test_strutturali;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import biblioteca.Biblioteca;
import biblioteca.Bibliotecario;
import biblioteca.ManagerDiSistema;
import biblioteca.Sbu;
import biblioteca.UtenteRegistrato;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class SbuTestLogin {
	private static Sbu sistema = null;
	private static UtenteRegistrato u1 = null;
	private static Bibliotecario b1 = null;
	private static ManagerDiSistema m1 = null;
	
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"email@U1.it","pass1",true},
            {"email@B1.it","pass2",true},
            {"email@M1.it","pass3",true},
            {"email@U1.it","pass",false},
            {"NO@U1.it","pass2",false},
            {"email@U1.it","pass3",false},
        });
	}
	
	@Parameter(0)
	public String user;
	
	@Parameter(1)
	public String pass;
	
	@Parameter(2)
	public boolean check;
	
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
	public void testLogin() {
		boolean result;
		if (sistema.login(user, pass) == null) {
			result = false;
		} else {
			result = true;
		}
		assertEquals("Il login deve avvenire correttamente", 
				result,check);
	}

	@After
	public void after() {
		sistema = new Sbu("Sistema bibliotecario");
		sistema.inserisciUtente(u1);
		sistema.inserisciUtente(b1);
		sistema.inserisciUtente(m1);
	}

}
