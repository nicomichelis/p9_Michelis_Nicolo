package test_strutturali;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import biblioteca.Persona;
import biblioteca.Sbu;
import biblioteca.UtenteRegistrato;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class SbuTestRicercaUtente {
	private static Sbu sistema = null;
	private static UtenteRegistrato u1 = null;
	
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"Nome",true},
            {"NO",false}
        });
	}
	
	@Parameter(0)
	public String ricerca;
	
	@Parameter(1)
	public boolean check;
	
	@BeforeClass
	public static void init() {
		sistema = new Sbu("Sistema bibliotecario");
		u1 = new UtenteRegistrato("Nome", "Cognome", 
				"Indirizzo", new Date(), "codiceFiscale", "0123456", 
				"nico@email.it", "pass", sistema);
		sistema.inserisciUtente(u1);
	}

	@Test
	public void testRicerca() {
		ArrayList<Persona> trovati = (ArrayList<Persona>) 
				sistema.ricercaUtente(ricerca);
		assertEquals(trovati.contains(u1), check);
	}

	@After
	public void after() {
		sistema = new Sbu("Sistema bibliotecario");
		sistema.inserisciUtente(u1);
	}

}
