package test_strutturali;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.ManagerDiSistema;
import biblioteca.Persona;
import biblioteca.Sbu;

public class ManagerDiSistemaTest {
	private static Persona p1 = null;
	private static Sbu sistema = null;

	@BeforeClass
	public static void init() {
		sistema = new Sbu("Sistema bibliotecario");
	}
	
	@Test
	public void testCreazione() {
		p1 = new ManagerDiSistema("Nome", "Cognome", 
				"Indirizzo", new Date(), "codiceFiscale", "0123456", 
				"nico@email.it", "pass", sistema);
		assertNotNull("Il Manager viene creato correttamente",p1);
	}

}
