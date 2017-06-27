package test_funzionali;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import biblioteca.ManagerDiSistema;
import biblioteca.Persona;
import biblioteca.Sbu;

public class UC55 {
	private static Sbu sistema = null;
	private static ManagerDiSistema u1 = null;
	@BeforeClass
	public static void init() {
		sistema = new Sbu("Sistema bibliotecario");
		u1 = new ManagerDiSistema("Nome1", "Cognome1", 
				"Indirizzo1", new Date(), "codiceFiscale1", "01234561", 
				"nico1@email.it", "pass1", sistema);
		sistema.inserisciUtente(u1);
	}
	
	@Test
	public void ricercaUtentePositiva1() {
		String s = "Nome";
		ArrayList<Persona> trovati = 
				(ArrayList<Persona>)sistema.ricercaUtente(s);
		assertFalse("La lista degli utenti trovati NON deve essere vuota",
				trovati.isEmpty());
	}
	
	@Test
	public void ricercaUtentePositiva2() {
		String s = "Cognome";
		ArrayList<Persona> trovati = 
				(ArrayList<Persona>)sistema.ricercaUtente(s);
		assertFalse("La lista degli utenti trovati NON deve essere vuota",
				trovati.isEmpty());
	}
	
	@Test
	public void ricercaUtentePositiva3() {
		String s = "codiceFiscale1";
		ArrayList<Persona> trovati = 
				(ArrayList<Persona>)sistema.ricercaUtente(s);
		assertFalse("La lista degli utenti trovati NON deve essere vuota",
				trovati.isEmpty());
	}
	
	@Test
	public void ricercaUtentePositiva4() {
		String s = "nico1@email.it";
		ArrayList<Persona> trovati = 
				(ArrayList<Persona>)sistema.ricercaUtente(s);
		assertFalse("La lista degli utenti trovati NON deve essere vuota",
				trovati.isEmpty());
	}
	
	@Test
	public void ricercaUtenteNegativa() {
		String s = "Name";
		ArrayList<Persona> trovati = 
				(ArrayList<Persona>)sistema.ricercaUtente(s);
		assertTrue("La lista degli utenti trovati deve essere vuota", 
				trovati.isEmpty());
	}

}
