package test_strutturali;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({ArticoloTest.class, ArticoloTestParam.class, 
	BibliotecaTest.class, BibliotecarioTest.class, LibroTest.class, 
	ManagerDiSistemaTest.class, MiscellaneaTest.class, PersonaTest.class,
	PrestitoTest.class, RecensioneTest.class, SbuTest.class, 
	SbuTestLogin.class, SbuTestRicercaArticolo.class, 
	SbuTestRicercaUtente.class, UtenteRegistratoTest.class })

@RunWith(Suite.class)
public class TestSuite {

}
