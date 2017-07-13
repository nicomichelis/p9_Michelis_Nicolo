package test_funzionali;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import biblioteca.Articolo;
import biblioteca.Biblioteca;
import biblioteca.Libro;
import biblioteca.Sbu;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class UC3 {
	private static Sbu sistema = null;
	private static Biblioteca b1 = null;
	private static Articolo	a1 = null;
	
	@Parameters
	public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"Titolo1", true},
            {"Titolo2", false},
            {"Autore", true},
            {"Genere", true}
        });
	}
	
	@BeforeClass
	public static void init() {
		sistema = new Sbu("Sistema bibliotecario");
		b1 = new Biblioteca("Biblioteca 1", "Via Biblioteca 1",
				sistema);
		sistema.getBiblioteche().add(b1);
		a1 = new Libro("Titolo1", "Autore", "Genere", 
				"Collocazione", b1, 012345 , "Casa Editrice", 150);
		b1.getPossiede().add(a1);
	}
	
	@Parameter(0)
	public String search;
	
	@Parameter(1)
	public boolean result;
	
	@Test
	public void test() {
		ArrayList<Articolo> trovati = 
				(ArrayList<Articolo>)sistema.ricercaArticolo(search);
		assertEquals(trovati.contains(a1), result);
	}
}
