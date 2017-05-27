/*
 * Nicolò Michelis
 * 
 * Version 0.1 (beta)
 */
package biblioteca;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe Demo, utile a mostrare le funzionalità.
 * 
 * @version		0.1 28 May 2017
 * @author 		Nicolò Michelis
 *
 */
public class Demo {
	/**
     * Main function
     *
     * @param args argomenti
     */
	public static void main(String[] args) {
		System.out.println("Creo nuovo SBU");
		Sbu sistema = new Sbu("Sistema bibliotecario");
		System.out.println("Creato");
		// ---
		System.out.println("Creo nuovo Biblioteca");
		Biblioteca b1 = new Biblioteca("Biblioteca 1", "Via Biblioteca 1",
				sistema);
		sistema.getBiblioteche().add(b1);
		System.out.println("Creato");
		// ---
		System.out.println("Creo nuovo Bibliotecario");
		sistema.inserisciUtente(new Bibliotecario("Nome", "Cognome", 
				"Indirizzo", new Date(), "codiceFiscale", "0123456", 
				"nico@email.it", "pass", sistema, b1)); 
		System.out.println("Creato");
		// ---
		System.out.println("Ricerco utente Nom");
		List<Persona> trovati = new ArrayList<Persona>();
		trovati = sistema.ricercaUtente("Nom");
		for (Persona p:trovati) {
			System.out.println("Trovato "+ p.getCognome());
		}
		// ---
		System.out.println("Creo nuovo Libro in Biblioteca 1");
		b1.getPossiede().add(new Libro("Titolo1", "Autore", "Genere", "Collocazione", b1, 012345 , "Casa Editrice", 150));
		System.out.println("Creato!");
		// ---
		System.out.println("Creo nuovo Libro in Biblioteca 1");
		b1.getPossiede().add(new Libro("Titolo2", "Autore", "Genere", "Collocazione", b1, 012346 , "Casa Editrice", 150));
		System.out.println("Creato!");
		// --
		System.out.println("Ricerco Libro Tito");
		List<Articolo> articoliTrovati = new ArrayList<Articolo>();
		articoliTrovati = sistema.ricercaArticolo("Tito");
		for (Articolo a:articoliTrovati) {
			System.out.println("Trovato "+ a.getTitolo());
		}
	}
}
